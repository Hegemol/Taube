package org.hegemol.taube.broker;

import org.hegemol.taube.broker.config.TaubeBrokerConfigurationProperty;
import org.hegemol.taube.broker.utils.IpUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * broker客户端;
 *
 * @author KevinClair
 **/
@Component
public class TaubeBroker implements InitializingBean, DisposableBean {

    private TaubeBrokerConfigurationProperty brokerConfigurationProperty;

    public TaubeBroker(final TaubeBrokerConfigurationProperty brokerConfigurationProperty) {
        this.brokerConfigurationProperty = brokerConfigurationProperty;
    }

    @Override
    public void destroy() throws Exception {
        // 初始化服务端
        initServer();
    }

    private void initServer() throws UnknownHostException {
        final String ip = IpUtils.getIp();
        String address = String.join(":", ip, brokerConfigurationProperty.getPort().toString());
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
