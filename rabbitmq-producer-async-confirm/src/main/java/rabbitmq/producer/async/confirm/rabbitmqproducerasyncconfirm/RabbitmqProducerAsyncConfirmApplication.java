package rabbitmq.producer.async.confirm.rabbitmqproducerasyncconfirm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RabbitmqProducerAsyncConfirmApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerAsyncConfirmApplication.class, args);
    }
}
