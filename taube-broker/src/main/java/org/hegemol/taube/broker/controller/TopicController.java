package org.hegemol.taube.broker.controller;

import lombok.RequiredArgsConstructor;
import org.hegemol.taube.broker.model.Result;
import org.hegemol.taube.broker.model.vo.TopicCreateRequest;
import org.hegemol.taube.broker.mysql.TopicMapper;
import org.hegemol.taube.broker.mysql.model.Topic;
import org.hegemol.taube.broker.service.TopicService;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/topic")
public class TopicController {

    private final TopicService topicService;

    /**
     * 查询所有的topic
     *
     * @return 所有的topic列表
     */
    @RequestMapping("/select")
    public List<Topic> select(){
        return topicService.select();
    }

    /**
     * 创建topic
     *
     * @param request 请求参数 {@link TopicCreateRequest}
     * @return 创建是否成功
     */
    @RequestMapping("/create")
    public Result<String> create(@RequestBody TopicCreateRequest request){
        topicService.createTopic(request);
        return Result.success("success");
    }
}
