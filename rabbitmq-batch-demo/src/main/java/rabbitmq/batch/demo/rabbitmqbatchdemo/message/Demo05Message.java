package rabbitmq.batch.demo.rabbitmqbatchdemo.message;

import java.io.Serializable;

public class Demo05Message implements Serializable {
    public static final String QUEUE = "QUEUE_DEMO_05";
    public static final String EXCHANGE = "EXCHANGE_DEMO_05";
    public static final String ROUTING_KEY = "ROUTING_KEY_05";
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

    @Override
    public String toString() {
        return "Demo05Message{" +
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
