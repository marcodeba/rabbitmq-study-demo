package rabbitmq.exchange.demo.rabbitmqtopicexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RabbitmqTopicExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqTopicExchangeApplication.class, args);
    }

}
