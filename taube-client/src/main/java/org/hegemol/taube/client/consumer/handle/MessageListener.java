package org.hegemol.taube.client.consumer.handle;

import org.hegemol.taube.client.common.model.MessageResult;

/**
 * 消息监听，消息消费实现此接口即可；
 *
 * @author KevinClair
 **/
public interface MessageListener<T> {

    /**
     * 消息消费。
     *
     * @param data 消息内容
     * @return 消费状态 {@link MessageResult}
     *
     * @throws Exception
     */
    MessageResult onMessage(T data) throws Exception;
}
