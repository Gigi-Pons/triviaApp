-- Necessary tables for the trivia database
CREATE TABLE users (
  id BINARY(16) PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(100) UNIQUE,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE categories (
  id BINARY(16) PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE quizzes (
  id BINARY(16) PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  category_id BINARY(16) NOT NULL,
  FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE questions (
  id BINARY(16) PRIMARY KEY,
  quiz_id BINARY(16) NOT NULL,
  text TEXT NOT NULL,
  correct_option CHAR(1) NOT NULL,
  FOREIGN KEY (quiz_id) REFERENCES quizzes(id)
);

CREATE TABLE options (
  id BINARY(16) PRIMARY KEY,
  question_id BINARY(16) NOT NULL,
  label CHAR(1) NOT NULL,
  text TEXT NOT NULL,
  FOREIGN KEY (question_id) REFERENCES questions(id)
);

CREATE TABLE user_quiz_attempts (
  id BINARY(16) PRIMARY KEY,
  user_id BINARY(16) NOT NULL,
  quiz_id BINARY(16) NOT NULL,
  started_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  completed_at DATETIME,
  score INT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (quiz_id) REFERENCES quizzes(id)
);

CREATE TABLE user_answers (
  id BINARY(16) PRIMARY KEY,
  attempt_id BINARY(16) NOT NULL,
  question_id BINARY(16) NOT NULL,
  selected_option CHAR(1) NOT NULL,
  FOREIGN KEY (attempt_id) REFERENCES user_quiz_attempts(id),
  FOREIGN KEY (question_id) REFERENCES questions(id)
);