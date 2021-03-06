package rabbitmq.ttl.demo.rabbitmqttldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.ttl.demo.rabbitmqttldemo.message.Demo08Message;

@Component
@RabbitListener(queues = Demo08Message.DELAY_QUEUE)
public class Demo08Consumer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo08Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
