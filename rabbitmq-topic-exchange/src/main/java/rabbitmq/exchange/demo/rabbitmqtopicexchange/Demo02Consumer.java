package rabbitmq.exchange.demo.rabbitmqtopicexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.exchange.demo.rabbitmqtopicexchange.message.Demo02Message;

@Component
@RabbitListener(queues = Demo02Message.QUEUE)
public class Demo02Consumer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo02Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{} 消息id:{}]", Thread.currentThread().getId(), message, message.getId());
    }
}
