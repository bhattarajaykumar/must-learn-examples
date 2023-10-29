CREATE TABLE emp.employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

select * from emp.employee;

INSERT INTO emp.employee (name) VALUES
    ('John Doe'),
    ('Jane Smith'),
    ('Michael Johnson'),
    ('Sarah Brown'),
    ('David Lee'),
    ('Jennifer Davis'),
    ('James Wilson'),
    ('Jessica Taylor'),
    ('Robert Anderson'),
    ('Lisa Martin');
    
INSERT INTO emp.employee (name) VALUES
    ('Matthew Williams'),
    ('Emily Jones'),
    ('Daniel Johnson'),
    ('Olivia Davis'),
    ('Ethan Wilson'),
    ('Ava Martinez'),
    ('Alexander Garcia'),
    ('Sofia Rodriguez'),
    ('William Hernandez'),
    ('Mia Smith');


select * from emp.employee where name like 'So%';
