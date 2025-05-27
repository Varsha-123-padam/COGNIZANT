CREATE DATABASE school;
USE school;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT
);

INSERT INTO students (name, age) VALUES 
    ('John Doe', 20),
    ('Jane Smith', 22),
    ('Bob Johnson', 21);