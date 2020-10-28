package rabbitmq.messageconverter.demo.rabbitmqmessageconverter.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.messageconverter.demo.rabbitmqmessageconverter.message.Demo15Message;

@Configuration
public class RabbitConfig {
    // 创建 Queue
    @Bean
    public Queue demo15Queue() {
        return new Queue(Demo15Message.QUEUE, // Queue 名字
                true, // durable: 是否持久化
                false, // exclusive: 是否排它
                false); // autoDelete: 是否自动删除
    }

    // 创建 Direct Exchange
    @Bean
    public DirectExchange demo15Exchange() {
        return new DirectExchange(Demo15Message.EXCHANGE,
                true,  // durable: 是否持久化
                false);  // exclusive: 是否排它
    }

    // 创建 Binding
    // Exchange：Demo15Message.EXCHANGE
    // Routing key：Demo15Message.ROUTING_KEY
    // Queue：Demo15Message.QUEUE
    @Bean
    public Binding demo15Binding() {
        return BindingBuilder.bind(demo15Queue()).to(demo15Exchange()).with(Demo15Message.ROUTING_KEY);
    }
}
