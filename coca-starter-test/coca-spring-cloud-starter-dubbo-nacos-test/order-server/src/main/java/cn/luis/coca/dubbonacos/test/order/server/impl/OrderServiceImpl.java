package cn.luis.coca.dubbonacos.test.order.server.impl;

import cn.luis.coca.dubbonacos.test.order.client.OrderService;
import cn.luis.coca.dubbonacos.test.order.client.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OrderServiceImpl implements OrderService {
    @Override
    public Order queryOrder(Long id) {
        // 模拟订单查询
        if (id % 2 == 0) {
            return new Order(id);
        }
        return null;
    }
}
