package cn.luis.coca.dubbonacos.test.pay.server.impl;

import cn.luis.coca.dubbonacos.test.pay.client.PayService;
import cn.luis.coca.dubbonacos.test.pay.domain.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PayServiceImpl implements PayService {

    @Override
    public boolean pay(Payment payment) {
        if (payment.getSerialNumber() > 1) {
            log.info("付款成功 , 流水号: {}", payment.getSerialNumber());
            return true;
        }
        log.info("付款失败, 付款信息: {}", payment);
        return false;
    }
}
