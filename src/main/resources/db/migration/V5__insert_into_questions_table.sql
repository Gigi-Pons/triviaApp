-- MySQL doesn't support multi-row insert statements when each row includes a subquery.
-- This happens because it requires MySQL to evaluate multiple subqueries inside a single statement.

INSERT INTO questions (quiz_id, text, correct_option)
VALUES ((SELECT id FROM quizzes WHERE title = 'Anatomy Quiz'), 'What is the largest organ in the human body?', 'D');

INSERT INTO questions (quiz_id, text, correct_option)
VALUES ((SELECT id FROM quizzes WHERE title = 'Anatomy Quiz'), 'What is the name of the bone that protects your brain?', 'C');

INSERT INTO questions (quiz_id, text, correct_option)
VALUES ((SELECT id FROM quizzes WHERE title = 'Anatomy Quiz'), 'Which part of the brain controls balance and coordination?', 'A');

INSERT INTO questions (quiz_id, text, correct_option)
VALUES ((SELECT id FROM quizzes WHERE title = 'Biology Quiz'), 'What type of organism make up the oldest known fossil?', 'D');

INSERT INTO questions (quiz_id, text, correct_option)
VALUES ((SELECT id FROM quizzes WHERE title = 'Biology Quiz'), 'What is the name of the green pigment found in plants?', 'C');

INSERT INTO questions (quiz_id, text, correct_option)
VALUES ((SELECT id FROM quizzes WHERE title = 'Biology Quiz'), 'What is the process called when a caterpillar transforms into a butterfly?', 'D');

INSERT INTO questions (quiz_id, text, correct_option)
VALUES ((SELECT id FROM quizzes WHERE title = 'Physics Quiz'), 'If you mix all colors of light together, what color do you get?', 'A');

INSERT INTO questions (quiz_id, text, correct_option)
VALUES ((SELECT id FROM quizzes WHERE title = 'Physics Quiz'), 'What is the force that resists motion when two solid surfaces rub against each other?', 'B');

INSERT INTO questions (quiz_id, text, correct_option)
VALUES ((SELECT id FROM quizzes WHERE title = 'Physics Quiz'), 'Where does sound travel faster?', 'C');
