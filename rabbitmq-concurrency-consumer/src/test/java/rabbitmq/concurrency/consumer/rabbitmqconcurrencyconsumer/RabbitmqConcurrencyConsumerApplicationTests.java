package rabbitmq.concurrency.consumer.rabbitmqconcurrencyconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
class RabbitmqConcurrencyConsumerApplicationTests {
    @Autowired
    private Demo09Producer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int id = (int) (System.currentTimeMillis() / 1000);
            producer.syncSend(id);
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
