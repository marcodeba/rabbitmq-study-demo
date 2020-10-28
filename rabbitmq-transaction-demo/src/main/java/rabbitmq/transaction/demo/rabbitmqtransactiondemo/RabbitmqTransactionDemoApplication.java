package rabbitmq.transaction.demo.rabbitmqtransactiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RabbitmqTransactionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqTransactionDemoApplication.class, args);
    }

}
