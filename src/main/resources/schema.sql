CREATE SCHEMA blog;

CREATE TABLE blog."user" (
                             id serial PRIMARY KEY,
                             name varchar(100),
                             email varchar(100),
                             password varchar(255),
                             age int
);

CREATE TABLE blog.post (
                           id serial PRIMARY KEY,
                           user_id bigint,
                           title varchar(255),
                           body text,
                           FOREIGN KEY (user_id) REFERENCES blog.user(id)
);
