package org.hegemol.taube.client.common.model;

import org.hegemol.taube.client.common.enums.TaubeMessageStatusEnum;

import java.io.Serializable;

/**
 * 消息体.
 *
 * @author KevinClair
 **/
public class Message implements Serializable {

    // 消息id
    private long msgId;

    // 消费主题
    private String topic;

    // 内容
    private String data;

    // 消费状态
    private TaubeMessageStatusEnum status;

    public Message() {
    }

    public Message(final long msgId, final String topic, final String data) {
        this.msgId = msgId;
        this.topic = topic;
        this.data = data;
    }

    /**
     * Gets the value of msgId.
     *
     * @return the value of msgId
     */
    public long getMsgId() {
        return msgId;
    }

    /**
     * Sets the msgId.
     *
     * @param msgId msgId
     */
    public void setMsgId(final long msgId) {
        this.msgId = msgId;
    }

    /**
     * Gets the value of topic.
     *
     * @return the value of topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Sets the topic.
     *
     * @param topic topic
     */
    public void setTopic(final String topic) {
        this.topic = topic;
    }

    /**
     * Gets the value of data.
     *
     * @return the value of data
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data data
     */
    public void setData(final String data) {
        this.data = data;
    }

    /**
     * Gets the value of status.
     *
     * @return the value of status
     */
    public TaubeMessageStatusEnum getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status status
     */
    public void setStatus(final TaubeMessageStatusEnum status) {
        this.status = status;
    }
}
