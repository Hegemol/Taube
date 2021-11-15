package org.hegemol.taube.broker.service;

import org.hegemol.taube.common.model.MessageModel;

/**
 * Broker服务接口.
 *
 * @author KevinClair
 **/
public interface BrokerService {

    /**
     * 处理请求
     *
     * @param model 请求模型
     * @return
     */
    MessageModel invoke(MessageModel model);
}
