package cn.luis.coca.dubbonacos.test.pay.server.impl;

import cn.luis.coca.dubbonacos.test.order.client.OrderServiceFacade;
import cn.luis.coca.dubbonacos.test.order.client.domain.Order;
import cn.luis.coca.dubbonacos.test.pay.client.PayService;
import cn.luis.coca.dubbonacos.test.pay.client.PayServiceFacade;
import cn.luis.coca.dubbonacos.test.pay.domain.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@DubboService(interfaceClass = PayServiceFacade.class)
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PayServiceFacadeImpl extends PayServiceImpl implements PayServiceFacade {

    private final PayService payService;

    @DubboReference
    private final OrderServiceFacade orderServiceFacade;

    @Override
    public boolean payForOrder(Long serialNumber) {
        // 调用服务核实订单信息
        Order order = orderServiceFacade.queryOrder(new Order(serialNumber));

        if (order == null) {
            log.warn("{},流水号: {}", "抱歉，无此订单", serialNumber);
            return false;
        }

        return payService.pay(new Payment(order.getId(), order.getName()));
    }
}
