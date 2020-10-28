package rabbitmq.exchange.demo.rabbitmqdirectexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RabbitmqDirectExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDirectExchangeApplication.class, args);
    }

}
