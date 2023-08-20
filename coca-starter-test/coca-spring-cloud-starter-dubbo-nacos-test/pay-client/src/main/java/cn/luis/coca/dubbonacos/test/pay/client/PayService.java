package cn.luis.coca.dubbonacos.test.pay.client;

import cn.luis.coca.dubbonacos.test.pay.domain.Payment;

public interface PayService {

    boolean pay(Payment payment);

}
