CREATE database if NOT EXISTS `taube` default character set utf8mb4 collate utf8mb4_general_ci;
use `taube`;

// topic表定义
CREATE TABLE `topic`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `topic`       varchar(255) NOT NULL COMMENT 'topic名称',
    `create_time` datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `UNIQUE_TOPIC` (`topic`) COMMENT 'topic唯一约束'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='topic信息表';

// queue队列表
CREATE TABLE `queue`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `queue_id`    int(11) NOT NULL COMMENT '队列id',
    `topic`       varchar(255) NOT NULL DEFAULT '' COMMENT '所属topic',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `update_time` datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `UNIQUE_QUEUE_TOPIC` (`queue_id`,`topic`) COMMENT 'topic队列id唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='队列信息';

CREATE TABLE `message` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `status` tinyint(1) NOT NULL comment ,
  `retry_count` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


