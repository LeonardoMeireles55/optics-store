CREATE TABLE IF NOT EXISTS `USERS` (
  id bigint AUTO_INCREMENT primary key,
  firstname varchar(255) not null,
  lastname varchar(255) not null,
  password varchar(255) not null,
  email varchar(255) not null,
  cep varchar(255) not null,
  address varchar(255) not null,
  telephone varchar(255) not null,
  cpf varchar(255) not null,
  role varchar(255) not null default 'USER'
);

INSERT INTO `users` (firstname, lastname, password, email, cep, address, telephone, cpf, role)
 VALUES ('admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'ADMIN');