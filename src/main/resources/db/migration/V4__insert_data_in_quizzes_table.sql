
INSERT INTO quizzes (title, category_id)
VALUES ('Biology Quiz', (SELECT id FROM categories WHERE name = 'Biology'));

INSERT INTO quizzes (title, category_id)
VALUES ('Physics Quiz', (SELECT id FROM categories WHERE name = 'Physics'));