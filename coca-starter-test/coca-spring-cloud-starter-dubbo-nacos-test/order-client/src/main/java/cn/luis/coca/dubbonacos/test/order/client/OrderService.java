package cn.luis.coca.dubbonacos.test.order.client;

import cn.luis.coca.dubbonacos.test.order.client.domain.Order;

public interface OrderService {

    Order queryOrder(Long id);
}
