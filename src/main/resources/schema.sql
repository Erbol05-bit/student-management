-- Удаляем таблицу и последовательность, если они существуют
DROP TABLE IF EXISTS student;
DROP SEQUENCE IF EXISTS student_sequence;

-- Создаем последовательность для студентов
CREATE SEQUENCE IF NOT EXISTS public.student_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Создаем таблицу student в схеме public
CREATE TABLE IF NOT EXISTS public.student (
    id BIGINT PRIMARY KEY DEFAULT nextval('public.student_sequence'),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    birth_date DATE NOT NULL,
    student_class VARCHAR(255) NOT NULL,
    attendance DOUBLE PRECISION NOT NULL,
    grades VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
); 