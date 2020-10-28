package rabbitmq.delay.demo.rabbitmqdelaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RabbitmqDelayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDelayDemoApplication.class, args);
    }

}
