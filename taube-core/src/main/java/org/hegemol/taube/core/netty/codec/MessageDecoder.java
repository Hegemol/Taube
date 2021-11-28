package org.hegemol.taube.core.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.hegemol.taube.common.model.MessageModel;
import org.hegemol.taube.core.marshalling.MessageMarshalling;
import org.hegemol.taube.core.marshalling.kryo.KryoMessageMarshalling;

import java.util.List;

/**
 * 消息解码器
 *
 * @author KevinClair
 **/
public class MessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        // 标记当前读取位置
        byteBuf.markReaderIndex();
        // 判断是否能够读取length长度
        if (byteBuf.readableBytes() < 4){
            return;
        }
        // 读取长度
        int bytesSize = byteBuf.readInt();
        // 如果 message 不够可读，则退回到原读取位置
        if (byteBuf.readableBytes() < bytesSize) {
            byteBuf.resetReaderIndex();
            return;
        }
        byte[] bytes = new byte[bytesSize];
        byteBuf.readBytes(bytes);
        MessageMarshalling marshalling = new KryoMessageMarshalling();
        final MessageModel message = marshalling.unmarshalling(bytes);
        list.add(message);
    }
}
