CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    cep VARCHAR(20),
    address VARCHAR(255),
    telephone VARCHAR(20),
    cpf VARCHAR(20),
    role VARCHAR(50)
);

INSERT INTO `users` (first_name, last_name, password, email, cep, address, telephone, cpf, role)
 VALUES ('admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'ADMIN');