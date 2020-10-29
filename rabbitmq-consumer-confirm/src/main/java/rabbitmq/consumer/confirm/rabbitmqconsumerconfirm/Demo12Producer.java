package rabbitmq.consumer.confirm.rabbitmqconsumerconfirm;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import rabbitmq.consumer.confirm.rabbitmqconsumerconfirm.message.Demo12Message;

@Component
public class Demo12Producer {
    // 在 RabbitAutoConfiguration 中自动注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo12Message 消息
        Demo12Message message = new Demo12Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo12Message.EXCHANGE, Demo12Message.ROUTING_KEY, message);
    }

    public void syncSendDefault(Integer id) {
        // 创建 Demo12Message 消息
        Demo12Message message = new Demo12Message();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo12Message.QUEUE, message);
    }

    @Async
    public ListenableFuture<Void> asyncSend(Integer id) {
        try {
            // 发送消息
            this.syncSend(id);
            // 返回成功的 Future
            return AsyncResult.forValue(null);
        } catch (Throwable ex) {
            // 返回异常的 Future
            return AsyncResult.forExecutionException(ex);
        }
    }
}
