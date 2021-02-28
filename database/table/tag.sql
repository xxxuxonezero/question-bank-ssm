DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    parent_id INT DEFAULT 0 COMMENT '父标签 类似于操作系统--内存',
    name VARCHAR(40) NOT NULL,
    user_id INT DEFAULT 0 COMMENT '0---系统tag',
    created_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE INDEX(user_id, name)
);
    
  