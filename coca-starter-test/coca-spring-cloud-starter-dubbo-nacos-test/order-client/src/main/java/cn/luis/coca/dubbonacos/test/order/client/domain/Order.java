package cn.luis.coca.dubbonacos.test.order.client.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Order implements Serializable {

    private Long id;

    private String name;

    public Order(Long id) {
        this.id = id;
        this.name = UUID.randomUUID().toString();
    }
}
