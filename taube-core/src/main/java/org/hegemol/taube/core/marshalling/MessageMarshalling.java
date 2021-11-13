package org.hegemol.taube.core.marshalling;


import org.hegemol.taube.common.model.MessageModel;

/**
 * 消息编组和解组协议
 *
 * @author KevinClair
 */
public interface MessageMarshalling {

    /**
     * 编组请求
     *
     * @param object 请求信息
     * @return 请求字节数组
     * @throws Exception
     */
    byte[] marshalling(Object object) throws Exception;

    /**
     * 解组
     *
     * @param data 需要被解码的参数
     * @return {@link Object} // TODO 消息格式
     * @throws Exception
     */
    MessageModel unmarshalling(byte[] data) throws Exception;
}
