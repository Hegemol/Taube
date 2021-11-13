package org.hegemol.taube.broker.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.hegemol.taube.common.model.MessageModel;
import org.hegemol.taube.core.marshalling.MessageMarshalling;
import org.hegemol.taube.core.marshalling.kryo.KryoMessageMarshalling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息相应编码器
 *
 *   0     1     2     3     4
 *   +-----+-----+-----+-----+
 *   |      full length      |
 *   +-----------------------+
 *   |                       |
 *   |        body           |
 *   |                       |
 *   |      ... ...          |
 *   +-----------------------+
 * 4B full length（消息长度，不是消息总长度） body（object类型数据）
 *
 * @author KevinClair
 **/
public class MessageEncoder extends MessageToByteEncoder<MessageModel> {

    private static final Logger logger = LoggerFactory.getLogger(MessageEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageModel object, ByteBuf byteBuf) throws Exception {
        // 序列化方法
        MessageMarshalling marshalling = new KryoMessageMarshalling();
        byte[] request = marshalling.marshalling(object);
        byteBuf.writeInt(request.length);
        byteBuf.writeBytes(request);
    }
}
