package org.hegemol.taube.broker.service;

/**
 * Topic处理
 *
 * @author KevinClair
 **/
public interface TopicService {

    /**
     * 创建topic
     *
     * @param name topic姓名
     */
    void createTopic(String name);
}