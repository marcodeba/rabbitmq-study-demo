package rabbitmq.concurrency.consumer.rabbitmqconcurrencyconsumer.message;

import java.io.Serializable;

public class Demo09Message implements Serializable {
    public static final String QUEUE = "QUEUE_DEMO_09";
    public static final String EXCHANGE = "EXCHANGE_DEMO_09";
    public static final String ROUTING_KEY = "ROUTING_KEY_09";

    /**
     * 编号
     */
    private Integer id;

    public static String getQUEUE() {
        return QUEUE;
    }

    public static String getEXCHANGE() {
        return EXCHANGE;
    }

    public static String getRoutingKey() {
        return ROUTING_KEY;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demo09Message{" +
                "id=" + id +
                '}';
    }
}
