package cn.luis.coca.dubbonacos.test.order.server.impl;

import cn.luis.coca.dubbonacos.test.order.client.OrderServiceFacade;
import cn.luis.coca.dubbonacos.test.order.client.domain.Order;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(interfaceClass = OrderServiceFacade.class)
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OrderServiceFacadeImpl extends OrderServiceImpl implements OrderServiceFacade {
    @Override
    public String queryOrderName(Long id) {
        Order order = queryOrder(id);
        return order == null ? null : order.getName();
    }

    @Override
    public Order queryOrder(Order order) {
        return queryOrder(order.getId());
    }
}
