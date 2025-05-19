-- Вставка тестовых данных для студентов
INSERT INTO student (name, email, birth_date, student_class, attendance, grades, password)
VALUES ('John Doe', 'john@example.com', '2000-01-01', '10A', 95.5, 'A+,A,A-', 'password123')
ON CONFLICT (email) DO NOTHING;

INSERT INTO student (name, email, birth_date, student_class, attendance, grades, password)
VALUES ('Jane Smith', 'jane@example.com', '2000-02-15', '10B', 98.0, 'A,A+,A', 'password123')
ON CONFLICT (email) DO NOTHING;

INSERT INTO student (name, email, birth_date, student_class, attendance, grades, password)
VALUES ('Test Student', 'test@example.com', '2000-03-20', '9A', 85.0, 'B+,B,A-', 'password123')
ON CONFLICT (email) DO NOTHING;

