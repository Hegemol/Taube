package org.hegemol.taube.broker.netty.heartbeat;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.hegemol.taube.common.enums.MessageTypeEnum;
import org.hegemol.taube.common.model.MessageModel;

/**
 * 心跳请求处理器
 *
 * @author KevinClair
 **/
@ChannelHandler.Sharable
@Slf4j
public class HeartBeatRequestHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        final MessageModel requestModel = (MessageModel) msg;
        // CONSUMER心跳请求
        if (requestModel.getType().equals(MessageTypeEnum.CONSUMER_HEART_BEAT_RQEUEST)){
            MessageModel responseModel = new MessageModel();
            responseModel.setType(MessageTypeEnum.CONSUMER_HEART_BEAT_RESPONSE);
            ctx.channel().writeAndFlush(responseModel);
            ReferenceCountUtil.release(msg);
            return;
        }

        // PRODUCER心跳请求
        if (requestModel.getType().equals(MessageTypeEnum.PRODUCER_HEART_BEAT_RQEUEST)){
            MessageModel responseModel = new MessageModel();
            responseModel.setType(MessageTypeEnum.PRODUCER_HEART_BEAT_RESPONSE);
            ctx.channel().writeAndFlush(responseModel);
            ReferenceCountUtil.release(msg);
            return;
        }

        // 继续后续请求
        ctx.fireChannelRead(msg);
    }
}
