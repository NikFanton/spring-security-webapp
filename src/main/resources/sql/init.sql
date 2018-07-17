DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_roles;

CREATE TABLE contact (
id INT NOT NULL AUTO_INCREMENT
, first_name VARCHAR(60) NOT NULL
, last_name VARCHAR(40) NOT NULL
, birth_date DATE
, description VARCHAR(2000)
, photo BLOB
, version INT NOT NULL DEFAULT 0
, UNIQUE UQ_CONTACT_l (first_name, last_name)
, primary key (ID)
);

-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Insert data

INSERT INTO users VALUES
(1, 'admin', '$2a$10$8g/ZyoWyAjRL7VNslMVLMekRgdx8iN7u88wa0/ceRfgsr1o9gTW9y'),
(2, 'user', '$2a$10$omV8jEK0L93YswIegBln3eh0RjWLiddwl0rWOo9QhvK0ZnpQlclRy');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);
INSERT INTO user_roles VALUES (2, 1);