package rabbitmq.exchange.demo.rabbitmqtopicexchange.message;

import java.io.Serializable;

public class Demo02Message implements Serializable {

    public static final String QUEUE = "QUEUE_DEMO_02";
    public static final String EXCHANGE = "EXCHANGE_DEMO_02";
    public static final String ROUTING_KEY = "#.yu.nai";

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
        return "Demo02Message{" +
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
