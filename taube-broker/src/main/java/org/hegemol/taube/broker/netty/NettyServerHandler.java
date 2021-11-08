package org.hegemol.taube.broker.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * Netty服务端处理器.
 *
 * @author KevinClair
 **/
@ChannelHandler.Sharable
@Component
public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(final ChannelHandlerContext channelHandlerContext, final Object o) throws Exception {

        // 通过Tcp header中的类型来判断当前的请求是发送消息请求还是拉取消息请求
    }
}
