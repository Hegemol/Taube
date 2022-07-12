package org.hegemol.taube.broker.mysql.model;

import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author KevinClair
 **/
@Data
public class Topic {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 主题名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
