package rabbitmq.producer.confirm.rabbitmqproducerconfirm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.producer.confirm.rabbitmqproducerconfirm.message.Demo13Message;

@Component
public class Demo13Producer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo13Message 消息
        Demo13Message message = new Demo13Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.invoke(operations -> {
            // 同步发送消息
            operations.convertAndSend(Demo13Message.EXCHANGE, Demo13Message.ROUTING_KEY, message);
            logger.info("[doInRabbit][发送消息完成]");
            // 等待确认
            operations.waitForConfirms(0); // timeout 参数，如果传递 0 ，表示无限等待
            logger.info("[doInRabbit][等待 Confirm 完成]");
            return null;
        }, (deliveryTag, multiple) -> logger.info("[handle][Confirm 成功]"), (deliveryTag, multiple) -> logger.info("[handle][Confirm 失败]"));
    }
}
