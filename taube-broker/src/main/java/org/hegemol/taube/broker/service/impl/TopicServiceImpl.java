package org.hegemol.taube.broker.service.impl;

import lombok.RequiredArgsConstructor;
import org.hegemol.taube.broker.model.vo.TopicCreateRequest;
import org.hegemol.taube.broker.mysql.TopicMapper;
import org.hegemol.taube.broker.mysql.model.Topic;
import org.hegemol.taube.broker.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Topic服务实现
 *
 * @author KevinClair
 **/
@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicMapper topicMapper;

    @Override
    public void createTopic(final TopicCreateRequest request) {
        Topic topic = new Topic();
        topic.setName(request.getName());
        topicMapper.insert(topic);
    }

    @Override
    public List<Topic> select() {
        return topicMapper.select();
    }
}
