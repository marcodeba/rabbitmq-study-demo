package rabbitmq.errorhandler.demo.rabbitmqerrorhandler.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.errorhandler.demo.rabbitmqerrorhandler.message.Demo16Message;

@Configuration
public class RabbitConfig {
    // 创建 Queue
    @Bean
    public Queue demo16Queue() {
        return new Queue(Demo16Message.QUEUE, // Queue 名字
                true, // durable: 是否持久化
                false, // exclusive: 是否排它
                false); // autoDelete: 是否自动删除
    }

    // 创建 Direct Exchange
    @Bean
    public DirectExchange demo16Exchange() {
        return new DirectExchange(Demo16Message.EXCHANGE,
                true,  // durable: 是否持久化
                false);  // exclusive: 是否排它
    }

    // 创建 Binding
    // Exchange：Demo16Message.EXCHANGE
    // Routing key：Demo16Message.ROUTING_KEY
    // Queue：Demo16Message.QUEUE
    @Bean
    public Binding demo16Binding() {
        return BindingBuilder.bind(demo16Queue()).to(demo16Exchange()).with(Demo16Message.ROUTING_KEY);
    }
}
