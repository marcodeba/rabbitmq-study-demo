package rabbitmq.transaction.demo.rabbitmqtransactiondemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
class RabbitmqTransactionDemoApplicationTests {
    @Autowired
    private Demo11Producer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
