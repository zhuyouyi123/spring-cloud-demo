CREATE DATABASE seata_order CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE seata_order;

CREATE TABLE `orders` (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         total_amount DECIMAL(10,2),
                         user_id BIGINT,
                         nickname VARCHAR(255),
                         address VARCHAR(500),
                         product_ids JSON
);

-- 注意：需在你的应用对应的数据库中执行（与spring.datasource.url指定的数据库一致）
CREATE TABLE IF NOT EXISTS `undo_log`
(
    `branch_id`     BIGINT       NOT NULL COMMENT '分支事务ID',
    `xid`           VARCHAR(128) NOT NULL COMMENT '全局事务ID',
    `context`       VARCHAR(128) NOT NULL COMMENT '上下文信息，如：serializer=jackson',
    `rollback_info` LONGBLOB     NOT NULL COMMENT '回滚日志内容',
    `log_status`    INT          NOT NULL COMMENT '日志状态：0-正常；1-已清理',
    `log_created`   DATETIME     NOT NULL COMMENT '日志创建时间',
    `log_modified`  DATETIME     NOT NULL COMMENT '日志修改时间',
    PRIMARY KEY (`branch_id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
    COMMENT ='Seata AT 模式事务回滚日志表';