CREATE TABLE Users
(
user_id    SERIAL PRIMARY KEY,
username   VARCHAR(50)  NOT NULL UNIQUE,
email      VARCHAR(100) NOT NULL UNIQUE,
password   VARCHAR(100) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
created_by INT REFERENCES Users (user_id),
updated_by INT REFERENCES Users (user_id)
);

INSERT INTO Users (username, email, password, created_by, updated_by)
VALUES
('Ilkin', 'ilkin@example.com', 'password123', NULL, NULL),
('Elnur', 'eLnur@example.com', 'securepass456', NULL, NULL),
('Nurlan', 'nurlan@example.com', 'mypass789', NULL, NULL);

CREATE TABLE Posts
(
post_id    SERIAL PRIMARY KEY,
title      VARCHAR(255) NOT NULL,
content    TEXT         NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
created_by INT          NOT NULL REFERENCES Users (user_id),
updated_by INT REFERENCES Users (user_id)
);

INSERT INTO Posts (title, content, created_by, updated_by)
VALUES
('First Post', 'This is the content of the first post', 1, 1),
('Second Post', 'Here is some more content for the second post', 2, 2),
('Another Post', 'Content of yet another post', 3, 3);

CREATE TABLE Comments
(
comment_id SERIAL PRIMARY KEY,
post_id    INT  NOT NULL REFERENCES Posts (post_id),
user_id    INT  NOT NULL REFERENCES Users (user_id),
content    TEXT NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
created_by INT  NOT NULL REFERENCES Users (user_id),
updated_by INT REFERENCES Users (user_id)
);

INSERT INTO Comments (post_id, user_id, content, created_by, updated_by)
VALUES
(1, 2, 'Nice post!', 2, NULL),
(1, 3, 'I found this very helpful, thank you!', 3, NULL),
(2, 1, 'Interesting perspective!', 1, NULL),
(3, 2, 'Great insights, thanks for sharing!', 2, NULL);

SELECT * FROM Posts;

