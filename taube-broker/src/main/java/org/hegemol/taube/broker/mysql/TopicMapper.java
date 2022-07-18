package org.hegemol.taube.broker.mysql;

import org.apache.ibatis.annotations.Mapper;
import org.hegemol.taube.broker.mysql.model.Topic;

import java.util.List;

/**
 * TODO
 *
 * @author KevinClair
 **/
@Mapper
public interface TopicMapper {

    /**
     * 查询
     *
     * @return
     */
    List<Topic> select();

    /**
     * 插入一条数据
     *
     * @param topic 数据库model {@link Topic}
     * @return 插入成功的条数
     */
    int insert(Topic topic);
}
