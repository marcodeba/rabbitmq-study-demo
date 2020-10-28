package rabbitmq.orderly.demo.rabbitmqorderlydemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import rabbitmq.orderly.demo.rabbitmqorderlydemo.message.Demo10Message;

@Component
@RabbitListener(queues = Demo10Message.QUEUE_0)
@RabbitListener(queues = Demo10Message.QUEUE_1)
@RabbitListener(queues = Demo10Message.QUEUE_2)
@RabbitListener(queues = Demo10Message.QUEUE_3)
public class Demo10Consumer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static String getQueue(Message<Demo10Message> message) {
        return message.getHeaders().get("amqp_consumerQueue", String.class);
    }

    @RabbitHandler(isDefault = true)
    public void onMessage(Message<Demo10Message> message) {
        logger.info("[onMessage][线程编号:{} Queue:{} 消息编号：{}]", Thread.currentThread().getId(), getQueue(message),
                message.getPayload().getId());
    }
}
