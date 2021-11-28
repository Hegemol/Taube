package org.hegemol.taube.client.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 客户端配置文件
 *
 * @author KevinClair
 **/
@ConfigurationProperties(prefix = "taube.client")
@Data
public class TaubeClientConfigurationProperties {

    /**
     * broker地址
     */
    private String brokerAddress;
}
