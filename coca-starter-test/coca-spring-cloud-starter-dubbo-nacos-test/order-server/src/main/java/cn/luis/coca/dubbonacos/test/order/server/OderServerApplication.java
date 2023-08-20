package cn.luis.coca.dubbonacos.test.order.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class OderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OderServerApplication.class, args);
    }

}
