package org.hegemol.taube.broker.service;

/**
 * Broker服务接口.
 *
 * @author KevinClair
 **/
public interface BrokerService {

    /**
     * Topic创建
     *
     * @param topic
     */
    void createTopic(String topic);

    /**
     * 消息发送
     *
     * @param topic 主题
     * @param data  数据
     */
    void sendMessage(String topic, String data);
}
