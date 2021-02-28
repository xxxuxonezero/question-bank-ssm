DROP TABLE IF EXISTS `notification`;

CREATE TABLE `notification`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(1000) NOT NULL,
    uer_id INT DEFAULT 0,
    type TINYINT DEFAULT 0 COMMENT '0--全体用户，1--全体管理员',
    target_user VARCHAR(500) DEFAULT '',
    publishTime TIMESTAMP NOT NULL,
    created_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
    
  