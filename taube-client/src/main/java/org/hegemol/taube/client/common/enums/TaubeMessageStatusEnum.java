package org.hegemol.taube.client.common.enums;

/**
 * 消息状态.
 *
 * @author KevinClair
 **/
public enum TaubeMessageStatusEnum {

    // 新建
    NEW,
    // 运行中，还未被消费状态
    RUNNING,
    // 消费成功
    SUCCESS,
    // 消费失败
    FAIL;
}
