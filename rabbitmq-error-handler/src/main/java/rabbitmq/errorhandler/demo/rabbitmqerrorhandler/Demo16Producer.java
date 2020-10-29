package rabbitmq.errorhandler.demo.rabbitmqerrorhandler;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.errorhandler.demo.rabbitmqerrorhandler.message.Demo16Message;

@Component
public class Demo16Producer {
    // 在 RabbitAutoConfiguration 中自动注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo16Message 消息
        Demo16Message message = new Demo16Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo16Message.EXCHANGE, Demo16Message.ROUTING_KEY, message);
    }
}

