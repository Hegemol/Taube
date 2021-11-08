package org.hegemol.taube.common.enums;

/**
 * 消息发送类型枚举。
 *
 * @author KevinClair
 **/
public enum MessageTypeEnum {

    // Producer心跳请求
    PRODUCER_HEART_BEAT_RQEUEST(),

    // Producer心跳响应
    PRODUCER_HEART_BEAT_RESPONSE(),

    // Consumer心跳请求
    CONSUMER_HEART_BEAT_RQEUEST(),

    // Consumer心跳响应
    CONSUMER_HEART_BEAT_RESPONSE(),

    // 发送消息请求
    SEND_MESSAGE_REQUEST(),

    // 发送消息响应
    SEND_MESSAGE_RESPONSE(),

    // 拉取消息请求
    PULL_MESSAGE_REQUEST(),

    // 拉取消息响应
    PULL_MESSAGE_RESPONSE();
}
