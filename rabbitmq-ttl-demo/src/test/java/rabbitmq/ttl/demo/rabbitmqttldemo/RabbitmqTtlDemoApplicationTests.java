package rabbitmq.ttl.demo.rabbitmqttldemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
class RabbitmqTtlDemoApplicationTests {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo08Producer producer;

    @Test
    public void testSyncSend01() throws InterruptedException {
        // 不设置消息的过期时间，使用队列默认的消息过期时间
        this.testSyncSendDelay(null);
    }

    @Test
    public void testSyncSend02() throws InterruptedException {
        // 设置发送消息的过期时间为 5000 毫秒
        this.testSyncSendDelay(5000);
    }

    private void testSyncSendDelay(Integer delay) throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id, delay);
        logger.info("[testSyncSendDelay][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
