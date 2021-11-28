package org.hegemol.taube.client.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.hegemol.taube.common.model.MessageModel;

/**
 * Netty客户端处理器
 *
 * @author KevinClair
 **/
@ChannelHandler.Sharable
public class NettyClientHandler extends SimpleChannelInboundHandler<MessageModel> {

    /**
     * 通道
     */
    private volatile Channel channel;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        this.channel = ctx.channel();
    }

    @Override
    protected void channelRead0(final ChannelHandlerContext channelHandlerContext, final MessageModel model) throws Exception {

    }

    public void invoke(MessageModel messageModel){
        // TODO 请求服务端
    }
}
