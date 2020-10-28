package rabbitmq.batch.demo.rabbitmqbatchdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.batch.demo.rabbitmqbatchdemo.message.Demo05Message;

import java.util.List;

@Component
@RabbitListener(queues = Demo05Message.QUEUE,
        containerFactory = "consumerBatchContainerFactory")
public class Demo05Consumer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo05Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{} 消息id:{}]", Thread.currentThread().getId(), message, message.getId());
    }

    @RabbitHandler
    public void onMessage(List<Demo05Message> messages) {
        logger.info("[onMessage][线程编号:{} 消息数量：{}]", Thread.currentThread().getId(), messages.size());
    }
}
