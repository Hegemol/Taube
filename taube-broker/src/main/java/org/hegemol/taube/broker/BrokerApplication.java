package org.hegemol.taube.broker;

import org.hegemol.taube.broker.config.TaubeBrokerConfigurationProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 启动类
 *
 * @author KevinClair
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {TaubeBrokerConfigurationProperty.class})
public class BrokerApplication {

	public static void main(String[] args) {
        SpringApplication.run(BrokerApplication.class, args);
	}

}