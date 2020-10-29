package rabbitmq.broadcast.demo.rabbitmqbroadcastdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.broadcast.demo.rabbitmqbroadcastdemo.message.BroadcastMessage;

@Component
public class BroadcastProducer {
    // 在 RabbitAutoConfiguration 中自动注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 BroadcastMessage 消息
        BroadcastMessage message = new BroadcastMessage();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(BroadcastMessage.EXCHANGE, null, message);
    }
}
