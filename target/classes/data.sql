DROP TABLE IF EXISTS phones CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
                         user_id bigint auto_increment NOT NULL,
                         name varchar(100),
                         email varchar(200) NOT NULL,
                         password varchar(255),
                         created_date datetime,
                         modified_date datetime,
                         last_login datetime,
                         active boolean
);

ALTER TABLE users
    ADD PRIMARY KEY (user_id);



CREATE TABLE phones (
                         phone_id bigint auto_increment NOT NULL,
                         number int(11) NOT NULL,
                         citycode int(11) NOT NULL,
                         countrycode int(11) NOT NULL,
                         user_id int(11) NOT NULL
);

ALTER TABLE phones
    ADD PRIMARY KEY (phone_id);



ALTER TABLE phones
    ADD FOREIGN KEY (user_id) REFERENCES phones(`user_id`);
COMMIT;

INSERT INTO users VALUES(NULL, 'Pedro','pedro@gmail.com','pedro123', NULL, NULL, NULL, false);
INSERT INTO users VALUES(NULL, 'Juan','juan@gmail.com','juan123', NULL, NULL, NULL, false);
INSERT INTO users VALUES(NULL, 'Diego','diego@gmail.com','diego123', NULL, NULL, NULL, false);

INSERT INTO phones VALUES(NULL, 966605535,9,'56', (SELECT user_id FROM users WHERE email='pedro@gmail.com'));
INSERT INTO phones VALUES(NULL, 966605532,9,'56', (SELECT user_id FROM users WHERE email='juan@gmail.com'));
INSERT INTO phones VALUES(NULL, 966605538,9,'56', (SELECT user_id FROM users WHERE email='diego@gmail.com'));