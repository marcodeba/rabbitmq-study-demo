package rabbitmq.consumer.retry.rabbitmqconsumerretry.message;

import java.io.Serializable;

public class Demo07Message implements Serializable {
    public static final String QUEUE = "QUEUE_DEMO_07"; // 正常队列
    public static final String DEAD_QUEUE = "DEAD_QUEUE_DEMO_07"; // 死信队列
    public static final String EXCHANGE = "EXCHANGE_DEMO_07";
    public static final String ROUTING_KEY = "ROUTING_KEY_07"; // 正常路由键
    public static final String DEAD_ROUTING_KEY = "DEAD_ROUTING_KEY_07"; // 死信路由键
    // 编号
    private Integer id;

    public static String getQUEUE() {
        return QUEUE;
    }

    public static String getDeadQueue() {
        return DEAD_QUEUE;
    }

    public static String getEXCHANGE() {
        return EXCHANGE;
    }

    public static String getRoutingKey() {
        return ROUTING_KEY;
    }

    public static String getDeadRoutingKey() {
        return DEAD_ROUTING_KEY;
    }

    @Override
    public String toString() {
        return "Demo07Message{" +
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
