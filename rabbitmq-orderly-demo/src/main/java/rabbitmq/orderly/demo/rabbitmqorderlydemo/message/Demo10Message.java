package rabbitmq.orderly.demo.rabbitmqorderlydemo.message;

import java.io.Serializable;

public class Demo10Message implements Serializable {
    public static final int QUEUE_COUNT = 4;
    public static final String EXCHANGE = "EXCHANGE_DEMO_10";
    private static final String QUEUE_BASE = "QUEUE_DEMO_10-";
    public static final String QUEUE_0 = QUEUE_BASE + "0";
    public static final String QUEUE_1 = QUEUE_BASE + "1";
    public static final String QUEUE_2 = QUEUE_BASE + "2";
    public static final String QUEUE_3 = QUEUE_BASE + "3";
    /**
     * 编号
     */
    private Integer id;

    public static String getQueueBase() {
        return QUEUE_BASE;
    }

    public static String getQueue0() {
        return QUEUE_0;
    }

    public static String getQueue1() {
        return QUEUE_1;
    }

    public static String getQueue2() {
        return QUEUE_2;
    }

    public static String getQueue3() {
        return QUEUE_3;
    }

    public static int getQueueCount() {
        return QUEUE_COUNT;
    }

    public static String getEXCHANGE() {
        return EXCHANGE;
    }

    @Override
    public String toString() {
        return "Demo10Message{" +
                "id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
