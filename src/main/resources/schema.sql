CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    telephone VARCHAR(20) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    role ENUM('ADMIN', 'USER') NOT NULL
);

CREATE TABLE dependents (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    dependent_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (dependent_id) REFERENCES users(id) ON DELETE CASCADE,
    UNIQUE KEY unique_dependent (user_id, dependent_id)
);


INSERT INTO `users` (first_name, last_name, password, email, cep, address, telephone, cpf, role)
 VALUES ('admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'ADMIN');