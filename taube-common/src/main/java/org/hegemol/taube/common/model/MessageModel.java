package org.hegemol.taube.common.model;

import org.hegemol.taube.common.enums.MessageTypeEnum;

import java.io.Serializable;

/**
 * 消息模型
 *
 * @author KevinClair
 **/
public class MessageModel<T> implements Serializable {

    // 请求id
    private String requestId;

    // 请求内容
    private T data;

    // 请求类型
    private MessageTypeEnum type;

    /**
     * Gets the value of requestId.
     *
     * @return the value of requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the requestId.
     *
     * @param requestId requestId
     */
    public void setRequestId(final String requestId) {
        this.requestId = requestId;
    }

    /**
     * Gets the value of data.
     *
     * @return the value of data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data data
     */
    public void setData(final T data) {
        this.data = data;
    }

    /**
     * Gets the value of type.
     *
     * @return the value of type
     */
    public MessageTypeEnum getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type type
     */
    public void setType(final MessageTypeEnum type) {
        this.type = type;
    }
}
