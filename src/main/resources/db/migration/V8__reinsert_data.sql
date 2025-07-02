INSERT INTO categories (name)
VALUES
('Anatomy'),
('Biology'),
('Physics');




INSERT INTO quizzes (title, category_id)
VALUES ('Anatomy Quiz', (SELECT id FROM categories WHERE name = 'Anatomy'));

INSERT INTO quizzes (title, category_id)
VALUES ('Biology Quiz', (SELECT id FROM categories WHERE name = 'Biology'));

INSERT INTO quizzes (title, category_id)
VALUES ('Physics Quiz', (SELECT id FROM categories WHERE name = 'Physics'));




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





INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the largest organ in the human body?' LIMIT 1), 'A', 'The liver');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the largest organ in the human body?' LIMIT 1), 'B', 'The lungs');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the largest organ in the human body?' LIMIT 1), 'C', 'The intestines');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the largest organ in the human body?' LIMIT 1), 'D', 'The skin');

INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the name of the bone that protects your brain?' LIMIT 1), 'A', 'Ulna');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the name of the bone that protects your brain?' LIMIT 1), 'B', 'Cerebellum');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the name of the bone that protects your brain?' LIMIT 1), 'C', 'The skull');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the name of the bone that protects your brain?' LIMIT 1), 'D', 'Vertebrae');

INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'Which part of the brain controls balance and coordination?' LIMIT 1), 'A', 'The cerebellum');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'Which part of the brain controls balance and coordination?' LIMIT 1), 'B', 'The hypothalamus');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'Which part of the brain controls balance and coordination?' LIMIT 1), 'C', 'The pituitary gland');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'Which part of the brain controls balance and coordination?' LIMIT 1), 'D', 'The frontal lobe');

INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What type of organism make up the oldest known fossil?' LIMIT 1), 'A', 'Plants');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What type of organism make up the oldest known fossil?' LIMIT 1), 'B', 'Dust');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What type of organism make up the oldest known fossil?' LIMIT 1), 'C', 'Algae');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What type of organism make up the oldest known fossil?' LIMIT 1), 'D', 'Bacteria');

INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the name of the green pigment found in plants?' LIMIT 1), 'A', 'Microbe');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the name of the green pigment found in plants?' LIMIT 1), 'B', 'Algae');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the name of the green pigment found in plants?' LIMIT 1), 'C', 'Chlorophyll');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the name of the green pigment found in plants?' LIMIT 1), 'D', 'Eukaryotic');

INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the process called when a caterpillar transforms into a butterfly?' LIMIT 1), 'A', 'Organism');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the process called when a caterpillar transforms into a butterfly?' LIMIT 1), 'B', 'Microbiology');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the process called when a caterpillar transforms into a butterfly?' LIMIT 1), 'C', 'Homeostasis');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the process called when a caterpillar transforms into a butterfly?' LIMIT 1), 'D', 'Metamorphosis');

INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'If you mix all colors of light together, what color do you get?' LIMIT 1), 'A', 'White');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'If you mix all colors of light together, what color do you get?' LIMIT 1), 'B', 'Black');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'If you mix all colors of light together, what color do you get?' LIMIT 1), 'C', 'Yellow');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'If you mix all colors of light together, what color do you get?' LIMIT 1), 'D', 'Grey');

INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the force that resists motion when two solid surfaces rub against each other?' LIMIT 1), 'A', 'Acceleration');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the force that resists motion when two solid surfaces rub against each other?' LIMIT 1), 'B', 'Friction');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the force that resists motion when two solid surfaces rub against each other?' LIMIT 1), 'C', 'Gravity');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'What is the force that resists motion when two solid surfaces rub against each other?' LIMIT 1), 'D', 'Momentum');

INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'Where does sound travel faster?' LIMIT 1), 'A', 'Space');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'Where does sound travel faster?' LIMIT 1), 'B', 'Air');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'Where does sound travel faster?' LIMIT 1), 'C', 'Water');
INSERT INTO options (question_id, label, text)
VALUES ((SELECT id FROM questions WHERE text = 'Where does sound travel faster?' LIMIT 1), 'D', 'Room');

