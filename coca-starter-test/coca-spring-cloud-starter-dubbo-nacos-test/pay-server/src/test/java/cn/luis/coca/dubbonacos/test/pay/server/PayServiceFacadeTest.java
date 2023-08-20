package cn.luis.coca.dubbonacos.test.pay.server;

import cn.luis.coca.dubbonacos.test.pay.client.PayServiceFacade;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PayServiceFacadeTest {

    @DubboReference
    private PayServiceFacade PayServiceFacade;

    @Test
    public void testPayForOrder() {
        boolean b1 = PayServiceFacade.payForOrder(1L);
        Assertions.assertFalse(b1);

        boolean b2 = PayServiceFacade.payForOrder(2L);
        Assertions.assertTrue(b2);
    }


}
