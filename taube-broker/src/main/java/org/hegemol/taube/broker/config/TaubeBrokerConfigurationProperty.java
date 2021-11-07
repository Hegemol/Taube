package org.hegemol.taube.broker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Broker配置类.
 *
 * @author KevinClair
 **/
@ConfigurationProperties(prefix = "taube.broker")
public class TaubeBrokerConfigurationProperty {

    // 端口号
    private Integer port;

    /**
     * Gets the value of port.
     *
     * @return the value of port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Sets the port.
     *
     * @param port port
     */
    public void setPort(final Integer port) {
        this.port = port;
    }
}
