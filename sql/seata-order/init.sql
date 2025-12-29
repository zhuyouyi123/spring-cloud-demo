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
