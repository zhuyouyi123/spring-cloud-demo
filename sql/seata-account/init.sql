CREATE DATABASE seata_account CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE seata_account;

CREATE TABLE account (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         username VARCHAR(255) NOT NULL,
                         gender VARCHAR(10),
                         create_time DATETIME,
                         update_time DATETIME
);
