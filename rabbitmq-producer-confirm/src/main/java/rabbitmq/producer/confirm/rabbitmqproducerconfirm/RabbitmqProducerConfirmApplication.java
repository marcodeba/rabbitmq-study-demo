package rabbitmq.producer.confirm.rabbitmqproducerconfirm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RabbitmqProducerConfirmApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerConfirmApplication.class, args);
    }

}
