CREATE TABLE IF NOT EXISTS articles (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    content VARCHAR(50) NOT NULL,
    author_id INT NOT NULL,
    PRIMARY KEY (id), 
    FOREIGN KEY (author_id) REFERENCES authors(id),
    UNIQUE (title),
    CHECK (title <> '')
);