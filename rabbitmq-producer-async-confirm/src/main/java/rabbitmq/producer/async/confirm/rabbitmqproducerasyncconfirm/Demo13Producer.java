package rabbitmq.producer.async.confirm.rabbitmqproducerasyncconfirm;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.producer.async.confirm.rabbitmqproducerasyncconfirm.message.Demo13Message;

@Component
public class Demo13Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo13Message 消息
        Demo13Message message = new Demo13Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo13Message.EXCHANGE, Demo13Message.ROUTING_KEY, message);
    }
}
