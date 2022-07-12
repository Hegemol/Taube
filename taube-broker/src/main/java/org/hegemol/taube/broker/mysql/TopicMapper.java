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

    List<Topic> select();
}
