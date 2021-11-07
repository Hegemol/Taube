package org.hegemol.taube.broker.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Netty服务端处理器.
 *
 * @author KevinClair
 **/
public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(final ChannelHandlerContext channelHandlerContext, final Object o) throws Exception {

    }
}
