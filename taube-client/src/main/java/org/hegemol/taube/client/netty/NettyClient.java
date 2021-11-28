package org.hegemol.taube.client.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.hegemol.taube.client.netty.handler.NettyClientHandler;
import org.hegemol.taube.common.constants.CommonConstants;
import org.hegemol.taube.core.netty.codec.MessageDecoder;
import org.hegemol.taube.core.netty.codec.MessageEncoder;
import org.hegemol.taube.core.netty.heartbeat.HeartBeatResponseHandler;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author KevinClair
 **/
@Slf4j
public class NettyClient {

    private EventLoopGroup loopGroup;

    private void startClient(String address, NettyClientHandler handler) {
        loopGroup = new NioEventLoopGroup();
        String[] addrInfo = address.split(":");
        final String serverAddress = addrInfo[0];
        final String serverPort = addrInfo[1];
        // 配置客户端
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(loopGroup)
                .channel(NioSocketChannel.class)
                .remoteAddress(serverAddress, Integer.parseInt(serverPort))
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline
                                /*Netty提供的日志打印Handler，可以展示发送接收出去的字节*/
//                                .addLast(new LoggingHandler(LogLevel.INFO))
                                /*剥离接收到的消息的长度字段，拿到实际的消息报文的字节数组*/
                                .addLast(new LengthFieldBasedFrameDecoder(65535,
                                        0, 4, 0,
                                        0))
                                // 空闲检测
                                .addLast(new IdleStateHandler(CommonConstants.TIMEOUT_SECONDS, 0, 0))
                                // 解码器
                                .addLast(new MessageDecoder())
                                // 编码器
                                .addLast(new MessageEncoder())
                                // 心跳检测
                                .addLast(new HeartBeatResponseHandler())
                                // 客户端业务处理器
                                .addLast(handler);
                    }
                });
        // 启用客户端连接
        bootstrap.connect().addListener((ChannelFutureListener) channelFuture -> {
            if (!channelFuture.isSuccess()) {
                reconnect(address, handler);
                return;
            }
        });
    }

    /**
     * 重新链接服务端
     *
     * @param address 客户端地址
     * @param handler 处理器
     */
    public void reconnect(String address, NettyClientHandler handler) {
        loopGroup.schedule(() -> {
            if (log.isDebugEnabled()) {
                log.debug("Netty client start reconnect, address:{}", address);
            }
            startClient(address, handler);
        }, CommonConstants.RECONNECT_SECONDS, TimeUnit.SECONDS);
    }
}
