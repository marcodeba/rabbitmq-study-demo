package rabbitmq.orderly.demo.rabbitmqorderlydemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.orderly.demo.rabbitmqorderlydemo.message.Demo10Message;

@Component
public class Demo10Producer {
    // 在 RabbitAutoConfiguration 中自动注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo10Message 消息
        Demo10Message message = new Demo10Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo10Message.EXCHANGE, this.getRoutingKey(id), message);
    }

    private String getRoutingKey(Integer id) {
        return String.valueOf(id % Demo10Message.QUEUE_COUNT);
    }
}
