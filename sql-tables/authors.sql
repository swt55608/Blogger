CREATE TABLE IF NOT EXISTS authors (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (id), 
    UNIQUE (username),
    CHECK (username <> '' && password <> '')
);