package org.hegemol.taube.common.enums;

/**
 * 消息发送类型枚举。
 *
 * @author KevinClair
 **/
public enum MessageTypeEnum {

    // Producer心跳请求
    PRODUCER_HEART_BEAT_RQEUEST("procuder_heaert_beat"),

    // Producer心跳响应
    PRODUCER_HEART_BEAT_RESPONSE("procuder_heaert_beat"),

    // Consumer心跳请求
    CONSUMER_HEART_BEAT_RQEUEST("consumer_heaert_beat"),

    // Consumer心跳响应
    CONSUMER_HEART_BEAT_RESPONSE("consumer_heaert_beat"),

    // 发送消息请求
    SEND_MESSAGE_REQUEST("procuder_handler"),

    // 发送消息响应
    SEND_MESSAGE_RESPONSE("procuder_handler"),

    // 拉取消息请求
    PULL_MESSAGE_REQUEST("consumer_handler"),

    // 拉取消息响应
    PULL_MESSAGE_RESPONSE("consumer_handler");

    private String type;

    /**
     * Gets the value of type.
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    MessageTypeEnum(final String type) {
        this.type = type;
    }
}
