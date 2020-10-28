package rabbitmq.broadcast.demo.rabbitmqbroadcastdemo.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.broadcast.demo.rabbitmqbroadcastdemo.message.BroadcastMessage;

@Configuration
public class BroadcastingConfiguration {
    @Bean
    public TopicExchange broadcastingExchange() {
        return new TopicExchange(BroadcastMessage.EXCHANGE,
                true,  // durable: 是否持久化
                false);  // exclusive: 是否排它
    }
}
