DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(500),
    content VARCHAR(500) NOT NULL,
    images VARCHAR(500),
    user_id INT NOT NULL,
    type INT NOT NULL COMMENT '0--question, 1--oj, 2--forum',
    forum_id INT NOT NULL,
    like_num INT DEFAULT 0,
    created_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX(user_id)
);
    
  