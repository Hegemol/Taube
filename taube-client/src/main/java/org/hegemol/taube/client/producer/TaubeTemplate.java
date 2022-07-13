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
     * 发送消息
     *
     * @param message 消息体.
     */
    public static void send(Message message){
        // 校验消息
        validMessage(message);

        // TODO 发送消息
    }

    /**
     * 消息体校验.
     *
     * @param message 消息体.
     */
    private static void validMessage(final Message message) {
        if (Objects.isNull(message)) {
            throw new IllegalArgumentException("Message can not be null.");
        }
        if (StringUtils.isBlank(message.getTopic())){
            throw new IllegalArgumentException("Message's topic can not be null.");
        }
        if (Objects.isNull(message.getData())) {
            message.setData("");
        }
        if (Objects.isNull(message.getMsgId())){
            message.setMsgId(System.currentTimeMillis());
        }
        // 初始化消息状态
        message.setStatus(TaubeMessageStatusEnum.NEW);
    }
}
