package rabbitmq.concurrency.consumer.rabbitmqconcurrencyconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.concurrency.consumer.rabbitmqconcurrencyconsumer.message.Demo09Message;

@Configuration
public class RabbitConfig {
    // 创建 Direct Exchange
    @Bean
    public DirectExchange demo09Exchange() {
        return new DirectExchange(Demo09Message.EXCHANGE,
                true,  // durable: 是否持久化
                false);  // exclusive: 是否排它
    }

    // 创建 Queue
    @Bean
    public Queue demo09Queue() {
        return new Queue(Demo09Message.QUEUE, // Queue 名字
                true, // durable: 是否持久化
                false, // exclusive: 是否排它
                false); // autoDelete: 是否自动删除
    }

    // 创建 Binding
    // Exchange：Demo09Message.EXCHANGE
    // Routing key：Demo09Message.ROUTING_KEY
    // Queue：Demo09Message.QUEUE
    @Bean
    public Binding demo01Binding() {
        return BindingBuilder.bind(demo09Queue()).to(demo09Exchange()).with(Demo09Message.ROUTING_KEY);
    }
}
