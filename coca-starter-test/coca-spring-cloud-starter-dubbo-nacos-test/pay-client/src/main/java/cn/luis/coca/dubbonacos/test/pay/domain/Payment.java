package cn.luis.coca.dubbonacos.test.pay.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Payment implements Serializable {

    /**
     * 流水号
     */
    private Long serialNumber;

    private String name;

    public Payment(Long serialNumber, String name) {
        this.serialNumber = serialNumber;
        this.name = name;
    }
}
