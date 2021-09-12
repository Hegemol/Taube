package org.hegemol.taube.producer;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.hegemol.taube.common.utils.MarshallingCodeCFactory;
import org.hegemol.taube.message.Message;

import java.net.InetSocketAddress;

/**
 * 消息实体 TODO
 *
 * @author clock
 **/
public class Producer {
    private static final String host = "127.0.0.1";
    private static final int port = 9527;

    private static String queueName = "test";

    public static void sendMsg(Message msg) {
        //创建nioEventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host, port))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                    }
                });
        try {
            // 发起连接
            ChannelFuture sync = bootstrap.connect().sync();
            sync.channel().writeAndFlush(msg);
            sync.channel().closeFuture().sync();
        } catch (Exception e) {

        } finally {
            group.shutdownGracefully();
        }
    }
}
