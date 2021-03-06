package rabbitmq.messageconverter.demo.rabbitmqmessageconverter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.messageconverter.demo.rabbitmqmessageconverter.message.Demo15Message;

@Component
public class Demo15Producer {
    // 在 RabbitAutoConfiguration 中自动注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo01Message 消息
        Demo15Message message = new Demo15Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo15Message.EXCHANGE, Demo15Message.ROUTING_KEY, message);
    }
}

