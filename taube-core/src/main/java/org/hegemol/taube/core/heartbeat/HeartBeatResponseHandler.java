package org.hegemol.taube.core.heartbeat;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.hegemol.taube.common.enums.MessageTypeEnum;
import org.hegemol.taube.common.model.MessageModel;

/**
 * 心跳响应处理器
 *
 * @author KevinClair
 **/
@ChannelHandler.Sharable
public class HeartBeatResponseHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // TODO 心跳回应
        MessageModel responseModel = (MessageModel) msg;
        // CONSUMER心跳响应
        if (responseModel.getType().equals(MessageTypeEnum.CONSUMER_HEART_BEAT_RQEUEST)){
            ReferenceCountUtil.release(msg);
            return;
        }

        // PRODUCER心跳响应
        if (responseModel.getType().equals(MessageTypeEnum.PRODUCER_HEART_BEAT_RQEUEST)){
            ReferenceCountUtil.release(msg);
            return;
        }

        // 继续后续请求
        ctx.fireChannelRead(msg);
    }
}
