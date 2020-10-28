package rabbitmq.exchange.demo.rabbitmqfanoutexchange.message;

import java.io.Serializable;

public class Demo03Message implements Serializable {
    public static final String QUEUE_A = "QUEUE_DEMO_03_A";
    public static final String QUEUE_B = "QUEUE_DEMO_03_B";
    public static final String EXCHANGE = "EXCHANGE_DEMO_03";

    /**
     * 编号
     */
    private Integer id;

    public static String getQueueA() {
        return QUEUE_A;
    }

    public static String getQueueB() {
        return QUEUE_B;
    }

    public static String getEXCHANGE() {
        return EXCHANGE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo03Message{" +
                "id=" + id +
                '}';
    }
}
