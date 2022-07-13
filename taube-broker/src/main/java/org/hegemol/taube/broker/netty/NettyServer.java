package org.hegemol.taube.broker.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hegemol.taube.broker.config.TaubeBrokerConfigurationProperty;
import org.hegemol.taube.core.netty.codec.MessageDecoder;
import org.hegemol.taube.core.netty.codec.MessageEncoder;
import org.hegemol.taube.common.constants.CommonConstants;
import org.hegemol.taube.core.netty.heartbeat.HeartBeatRequestHandler;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.Objects;

/**
 * Netty服务端
 *
 * @author KevinClair
 **/
@Slf4j
@Component
public class NettyServer implements DisposableBean {

    private TaubeBrokerConfigurationProperty brokerConfigurationProperty;

    private NettyServerHandler nettyServerHandler;

    private Channel channel;

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    public NettyServer(final TaubeBrokerConfigurationProperty brokerConfigurationProperty, final NettyServerHandler nettyServerHandler) {
        this.brokerConfigurationProperty = brokerConfigurationProperty;
        this.nettyServerHandler = nettyServerHandler;
    }

    /**
     * Netty服务端启动
     */
    public void start(){
        // TODO 后期线程可配置化
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(brokerConfigurationProperty.getPort()))
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            // 获得 Channel 对应的 ChannelPipeline
                            ChannelPipeline channelPipeline = channel.pipeline();
                            // 添加一堆 NettyServerHandler 到 ChannelPipeline 中
                            channelPipeline
                                    /*Netty提供的日志打印Handler，可以展示发送接收出去的字节*/
//                                    .addLast(new LoggingHandler(LogLevel.INFO))
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
                                    // 心跳处理器
                                    .addLast(new HeartBeatRequestHandler())
                                    // 服务端处理器
                                    .addLast(nettyServerHandler);
                        }
                    });

            // 启动服务
            ChannelFuture future = bootstrap.bind().sync();
            if (future.isSuccess()) {
                log.debug("Netty Server started successfully.");
                channel = future.channel();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("netty sever started failed,msg:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    @Override
    public void destroy() throws Exception {
        if (Objects.nonNull(channel)){
            channel.close();
        }
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
