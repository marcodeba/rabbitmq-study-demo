package rabbitmq.exchange.demo.rabbitmqfanoutexchange;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.exchange.demo.rabbitmqfanoutexchange.message.Demo03Message;

@Component
public class Demo03Producer {
    // 在 RabbitAutoConfiguration 中自动注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo03Message 消息
        Demo03Message message = new Demo03Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo03Message.EXCHANGE, null, message);
    }
}
