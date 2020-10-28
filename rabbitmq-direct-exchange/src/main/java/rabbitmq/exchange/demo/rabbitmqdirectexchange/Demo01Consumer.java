package rabbitmq.exchange.demo.rabbitmqdirectexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.exchange.demo.rabbitmqdirectexchange.message.Demo01Message;

@Component
@RabbitListener(queues = Demo01Message.QUEUE)
public class Demo01Consumer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo01Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{} 消息id:{}]", Thread.currentThread().getId(), message, message.getId());
    }
}
