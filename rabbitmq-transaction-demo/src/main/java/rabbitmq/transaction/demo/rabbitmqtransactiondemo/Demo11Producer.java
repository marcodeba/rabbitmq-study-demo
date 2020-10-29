package rabbitmq.transaction.demo.rabbitmqtransactiondemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rabbitmq.transaction.demo.rabbitmqtransactiondemo.message.Demo11Message;

@Component
public class Demo11Producer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    // 在 RabbitAutoConfiguration 中自动注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Transactional
    public void syncSend(Integer id) throws InterruptedException {
        // 创建 Demo11Message 消息
        Demo11Message message = new Demo11Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo11Message.EXCHANGE, Demo11Message.ROUTING_KEY, message);
        logger.info("[syncSend][发送编号：[{}] 发送成功]", id);

        // <X> 等待
        Thread.sleep(10 * 1000L);
    }
}
