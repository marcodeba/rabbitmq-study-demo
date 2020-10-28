package rabbitmq.producer.confirm.rabbitmqproducerconfirm.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.producer.confirm.rabbitmqproducerconfirm.message.Demo13Message;

@Configuration
public class RabbitConfig {
    // 创建 Queue
    @Bean
    public Queue demo01Queue() {
        return new Queue(Demo13Message.QUEUE, // Queue 名字
                true, // durable: 是否持久化
                false, // exclusive: 是否排它
                false); // autoDelete: 是否自动删除
    }

    // 创建 Direct Exchange
    @Bean
    public DirectExchange demo01Exchange() {
        return new DirectExchange(Demo13Message.EXCHANGE,
                true,  // durable: 是否持久化
                false);  // exclusive: 是否排它
    }

    // 创建 Binding
    // Exchange：Demo01Message.EXCHANGE
    // Routing key：Demo01Message.ROUTING_KEY
    // Queue：Demo01Message.QUEUE
    @Bean
    public Binding demo01Binding() {
        return BindingBuilder.bind(demo01Queue()).to(demo01Exchange()).with(Demo13Message.ROUTING_KEY);
    }
}
