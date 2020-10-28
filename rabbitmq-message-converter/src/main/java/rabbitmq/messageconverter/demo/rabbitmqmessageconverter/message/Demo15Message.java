package rabbitmq.messageconverter.demo.rabbitmqmessageconverter.message;


import java.io.Serializable;

public class Demo15Message implements Serializable {
    public static final String QUEUE = "QUEUE_DEMO_15";
    public static final String EXCHANGE = "EXCHANGE_DEMO_15";
    public static final String ROUTING_KEY = "ROUTING_KEY_15";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo15Message setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Demo15Message{" +
                "id=" + id +
                '}';
    }
}
