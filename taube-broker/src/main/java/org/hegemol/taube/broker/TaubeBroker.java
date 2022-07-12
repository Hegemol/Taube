package org.hegemol.taube.broker;

import org.hegemol.taube.broker.netty.NettyServer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * broker客户端;
 *
 * @author KevinClair
 **/
//@Component
public class TaubeBroker implements InitializingBean, DisposableBean {

    private NettyServer nettyServer;

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 初始化服务端
        nettyServer.start();
    }
}
