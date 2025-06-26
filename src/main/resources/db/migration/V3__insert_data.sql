

-- Three categories to start
INSERT INTO categories (name)
VALUES
('Anatomy'),
('Biology'),
('Physics');

-- Do three quizzes to start
INSERT INTO quizzes (title, category_id)
VALUES ('Anatomy Quiz', (SELECT id FROM categories WHERE name = 'Anatomy'));
