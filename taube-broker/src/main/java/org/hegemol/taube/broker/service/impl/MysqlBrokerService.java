package org.hegemol.taube.broker.service.impl;

import org.hegemol.taube.broker.service.BrokerService;
import org.springframework.stereotype.Service;

/**
 * Broker服务的Mysql实现。
 *
 * @author KevinClair
 **/
@Service("mysql")
public class MysqlBrokerService implements BrokerService {

    @Override
    public void createTopic(final String topic) {

    }

    @Override
    public void sendMessage(final String topic, final String data) {

    }
}
