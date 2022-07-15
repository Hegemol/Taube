package org.hegemol.taube.client.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hegemol.taube.common.enums.TaubeMessageStatusEnum;

import java.io.Serializable;
import java.util.Objects;

/**
 * 消息体.
 *
 * @author KevinClair
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    // 消息id
    private long msgId = System.currentTimeMillis();

    // 消费主题
    private String topic;

    // 主题的tag
    private String tag = "";

    // 内容
    private Object data;

    // 消费状态
    private TaubeMessageStatusEnum status = TaubeMessageStatusEnum.NEW;
}
