package cn.luis.coca.jpabatis.core;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * 雪花ID
 *
 * @author luis
 * @since 1.0
 * created 2022/5/29 16:45
 */
public class IdGenerator implements IdentifierGenerator {

    /**
     * 生成雪花ID (19位)
     */
    public static Long getId() {
        return SnowFlakeIdWorker.getFlowIdWorkerInstance().nextId();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Serializable id = sharedSessionContractImplementor.getEntityPersister(null, o).getClassMetadata().getIdentifier(o, sharedSessionContractImplementor);
        if (id != null) {
            return id;
        }
        return getId();
    }
}