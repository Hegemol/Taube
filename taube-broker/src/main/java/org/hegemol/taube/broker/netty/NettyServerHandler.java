package org.hegemol.taube.broker.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.RequiredArgsConstructor;
import org.hegemol.taube.broker.service.BrokerService;
import org.hegemol.taube.common.enums.MessageTypeEnum;
import org.hegemol.taube.common.model.MessageModel;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Netty服务端处理器.
 *
 * @author KevinClair
 **/
@ChannelHandler.Sharable
@Component
@RequiredArgsConstructor
public class NettyServerHandler extends SimpleChannelInboundHandler<MessageModel> {

    private final Map<String, BrokerService> brokerService;

    @Override
    protected void channelRead0(final ChannelHandlerContext channelHandlerContext, final MessageModel messageModel) throws Exception {
        // TODO 处理消息逻辑
        // 发送消息请求
        final MessageModel model = brokerService.get(messageModel.getType().getType()).invoke(messageModel);
        channelHandlerContext.writeAndFlush(model);
    }
}
