DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(500) NOT NULL,
    user_id INT NOT NULL,
    target_user_id INT COMMENT '若为null，则回复了其他人的回复',
    comment_id INT NOT NULL,
    like_num INT DEFAULT 0,
    created_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    INDEX(user_id)
);
    
  