package org.hegemol.taube.broker.service;

import org.hegemol.taube.broker.model.vo.TopicCreateRequest;
import org.hegemol.taube.broker.mysql.model.Topic;

import java.util.List;

/**
 * Topic处理
 *
 * @author KevinClair
 **/
public interface TopicService {

    /**
     * 创建topic
     *
     * @param request 请求参数 {@link TopicCreateRequest}
     */
    void createTopic(TopicCreateRequest request);

    /**
     * 查询所有的topic列表
     *
     * @return
     */
    List<Topic> select();
}