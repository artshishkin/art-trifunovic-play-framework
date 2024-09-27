-- Posts table

-- !Ups

CREATE TABLE Posts
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    title   VARCHAR(100) NOT NULL,
    content VARCHAR(200) NOT NULL
);

-- !Downs

DROP TABLE Posts;