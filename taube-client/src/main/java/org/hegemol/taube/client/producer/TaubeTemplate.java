package org.hegemol.taube.client.producer;

import org.apache.commons.lang3.StringUtils;
import org.hegemol.taube.common.enums.TaubeMessageStatusEnum;
import org.hegemol.taube.client.common.model.Message;

import java.util.Objects;

/**
 * 消息发送端.
 *
 * @author KevinClair
 **/
public class TaubeTemplate {

    /**
     * 同步发送消息
     *
     * @param topic 消息主题
     * @param data  消息内容
     */
    public void send(String topic, Object data){
        this.send(topic, "", System.currentTimeMillis(), data);
    }

    /**
     * 同步发送消息
     *
     * @param topic     消息主题
     * @param messageId 消息id
     * @param data      消息内容
     */
    public void send(String topic, Long messageId, Object data){
        this.send(topic, "", messageId, data);
    }

    /**
     * 同步发送消息
     *
     * @param topic     主题
     * @param tag       主题tag
     * @param messageId 消息id
     * @param data      消息内容
     */
    public void send(String topic, String tag, Long messageId, Object data){
        // 校验消息
        if (StringUtils.isBlank(topic)) {
            throw new IllegalArgumentException("Topic can not be null.");
        }
        Message message = new Message();
        if (StringUtils.isNoneBlank(tag)){
            message.setTag(tag);
        }
        if (Objects.nonNull(messageId)){
            message.setMsgId(messageId);
        }
        message.setData(data);
        // TODO 发送消息
    }
}
