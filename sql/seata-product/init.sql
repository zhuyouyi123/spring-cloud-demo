CREATE DATABASE seata_product CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE seata_product;

CREATE TABLE product
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    price        DECIMAL(10, 2),
    num          INT DEFAULT 0,
    description  TEXT
);
