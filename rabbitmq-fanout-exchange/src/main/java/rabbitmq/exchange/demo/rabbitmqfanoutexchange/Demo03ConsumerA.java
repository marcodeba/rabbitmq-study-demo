package rabbitmq.exchange.demo.rabbitmqfanoutexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.exchange.demo.rabbitmqfanoutexchange.message.Demo03Message;

@Component
@RabbitListener(queues = Demo03Message.QUEUE_A)
public class Demo03ConsumerA {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo03Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{} 消息id:{}]", Thread.currentThread().getId(), message, message.getId());
    }
}
