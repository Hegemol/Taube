package org.hegemol.taube.broker.model.vo;

import lombok.Data;

/**
 * topic创建请求参数
 *
 * @author KevinClair
 **/
@Data
public class TopicCreateRequest {

    /**
     * topic名称
     */
    private String name;
}
