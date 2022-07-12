package org.hegemol.taube.broker.controller;

import lombok.RequiredArgsConstructor;
import org.hegemol.taube.broker.mysql.TopicMapper;
import org.hegemol.taube.broker.mysql.model.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author KevinClair
 **/
@RestController
@RequiredArgsConstructor
public class TopicController {

    private final TopicMapper topicMapper;

    @RequestMapping("/select")
    public List<Topic> select(){
        return topicMapper.select();
    }
}
