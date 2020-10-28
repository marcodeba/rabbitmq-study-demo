package rabbitmq.exchange.demo.rabbitmqdirectexchange.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.exchange.demo.rabbitmqdirectexchange.message.Demo01Message;

/**
 * Exchange 根据 Routing Key 和 Binding Key 将消息路由到 Queue
 * 目前提供了 Direct、Topic、Fanout 三种类型
 */
@Configuration
public class DirectExchangeDemoConfiguration {
    // 创建 Direct Exchange
    @Bean
    public DirectExchange demo01Exchange() {
        return new DirectExchange(Demo01Message.EXCHANGE,
                true,  // durable: 是否持久化
                false);  // exclusive: 是否排它
    }

    // 创建 Queue
    @Bean
    public Queue demo01Queue() {
        return new Queue(Demo01Message.QUEUE, // Queue 名字
                true, // durable: 是否持久化
                false, // exclusive: 是否排它
                false); // autoDelete: 是否自动删除
    }

    // 创建 Binding
    // Exchange：Demo01Message.EXCHANGE
    // Routing key：Demo01Message.ROUTING_KEY
    // Queue：Demo01Message.QUEUE
    @Bean
    public Binding demo01Binding() {
        return BindingBuilder.bind(demo01Queue()).to(demo01Exchange()).with(Demo01Message.ROUTING_KEY);
    }
}
