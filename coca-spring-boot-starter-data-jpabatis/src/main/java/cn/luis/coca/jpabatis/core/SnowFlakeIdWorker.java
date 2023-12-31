package cn.luis.coca.jpabatis.core;

import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://github.com/zzxadi/Snowflake-IdWorker/blob/master/IdWorker.java"></a>
 * <p>
 * twitter的snowflake 移植到Java:
 * (a) id构成: 42位的时间前缀 + 10位的节点标识 + 12位的sequence避免并发的数字(12位不够用时强制得到新的时间前缀)
 * 注意这里进行了小改动: snowkflake是5位的datacenter加5位的机器id; 这里变成使用10位的机器id
 * (b) 对系统时间的依赖性非常强，需关闭ntp的时间同步功能。当检测到ntp时间调整后，将会拒绝分配id
 *
 * @author zzxadi
 */
@Slf4j
public class SnowFlakeIdWorker {

    private static final SnowFlakeIdWorker FLOW_ID_WORKER = new SnowFlakeIdWorker(1);
    private final long workerId;
    /**
     * 时间起始标记点，作为基准，一般取系统的最近时间
     */
    private final long EPOCH = 1403854494756L;
    /**
     * 机器标识位数
     */
    private final long workerIdBits = 10L;
    /**
     * 毫秒内自增位
     */
    private final long sequenceBits = 12L;

    /**
     * 12
     */
    private final long workerIdShift = this.sequenceBits;
    /**
     * 22
     */
    private final long timestampLeftShift = this.sequenceBits + this.workerIdBits;
    /**
     * 4095,111111111111,12位
     */
    private final long sequenceMask;
    /**
     * 0，并发控制
     */
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    private SnowFlakeIdWorker(long workerId) {
        /*
         * 机器ID最大值: 1023
         */
        long maxWorkerId = ~(-1L << this.workerIdBits);
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        this.workerId = workerId;
        sequenceMask = ~(-1L << this.sequenceBits);

    }

    public static SnowFlakeIdWorker getFlowIdWorkerInstance() {
        return FLOW_ID_WORKER;
    }

    /**
     * 获得系统当前毫秒数
     */
    private static long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * test
     */
    public static void main(String[] args) {
        System.out.println(timeGen());
        SnowFlakeIdWorker idWorker = SnowFlakeIdWorker.getFlowIdWorkerInstance();
        System.out.println(idWorker.nextId());
        System.out.println(String.valueOf(idWorker.nextId()).length());
    }

    public synchronized long nextId() {
        long timestamp = timeGen();
        if (this.lastTimestamp == timestamp) {
            // 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环); 对新的timestamp，sequence从0开始
            this.sequence = this.sequence + 1 & this.sequenceMask;
            if (this.sequence == 0) {
                // 重新生成timestamp
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }

        if (timestamp < this.lastTimestamp) {
            log.error("clock moved backwards.Refusing to generate id for {} milliseconds", (this.lastTimestamp - timestamp));
            // throw new Exception(String.format("clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));
        }

        this.lastTimestamp = timestamp;
        return timestamp - EPOCH << this.timestampLeftShift | this.workerId << this.workerIdShift | this.sequence;
    }

    /**
     * 等待下一个毫秒的到来, 保证返回的毫秒数在参数lastTimestamp之后
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

}