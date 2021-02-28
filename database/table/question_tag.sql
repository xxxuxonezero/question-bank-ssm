DROP TABLE IF EXISTS `question_tag`;

CREATE TABLE `question_tag`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    tag_id INT NOT NULL,
    question_id CHAR(32) NOT NULL
);
    
  