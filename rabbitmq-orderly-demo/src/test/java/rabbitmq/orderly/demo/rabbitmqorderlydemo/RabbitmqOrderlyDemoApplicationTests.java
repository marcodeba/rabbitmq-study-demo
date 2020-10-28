package rabbitmq.orderly.demo.rabbitmqorderlydemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
class RabbitmqOrderlyDemoApplicationTests {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo10Producer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            for (int id = 0; id < 4; id++) {
                producer.syncSend(id);
                logger.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
            }
        }
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
