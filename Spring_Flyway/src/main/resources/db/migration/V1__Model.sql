drop table if exists course;
CREATE TABLE course
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    course_name VARCHAR(255)          NULL,
    instructor  VARCHAR(255)          NULL,
    email       VARCHAR(255)          NULL,
    CONSTRAINT pk_course PRIMARY KEY (id)
);
drop table if exists user;
CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    email    VARCHAR(255)          NULL,
    password VARCHAR(255)          NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);