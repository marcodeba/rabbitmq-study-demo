package rabbitmq.broadcast.demo.rabbitmqbroadcastdemo.message;

import java.io.Serializable;

public class BroadcastMessage implements Serializable {
    public static final String QUEUE = "QUEUE_BROADCASTING";
    public static final String EXCHANGE = "EXCHANGE_BROADCASTING";
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

    @Override
    public String toString() {
        return "BroadcastMessage{" +
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
