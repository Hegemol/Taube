package org.hegemol.taube.broker.service.impl;

import lombok.RequiredArgsConstructor;
import org.hegemol.taube.broker.service.BrokerService;
import org.hegemol.taube.common.model.MessageModel;
import org.hegemol.taube.broker.service.TopicService;
import org.springframework.stereotype.Service;

/**
 * 发送端消息处理
 *
 * @author KevinClair
 **/
@RequiredArgsConstructor
@Service
public class BrokerServiceImpl implements BrokerService {

    private final TopicService topicService;

    @Override
    public MessageModel invoke(final MessageModel model) {
        // TODO 消息发送逻辑补全
        return null;
    }
}
