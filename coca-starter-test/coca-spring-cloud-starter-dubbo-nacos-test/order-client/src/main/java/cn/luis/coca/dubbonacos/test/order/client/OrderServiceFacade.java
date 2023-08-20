package cn.luis.coca.dubbonacos.test.order.client;


import cn.luis.coca.dubbonacos.test.order.client.domain.Order;

public interface OrderServiceFacade {

    String queryOrderName(Long id);

    Order queryOrder(Order order);


}
