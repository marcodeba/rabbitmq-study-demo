package rabbitmq.errorhandler.demo.rabbitmqerrorhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.errorhandler.demo.rabbitmqerrorhandler.message.Demo16Message;

@Component
@RabbitListener(queues = Demo16Message.QUEUE,
        errorHandler = "rabbitListenerErrorHandler")
public class Demo16Consumer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo16Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        // 模拟消费异常
        throw new RuntimeException("你猜");
    }
}
