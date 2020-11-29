INSERT INTO `role` (`id`, `name`) VALUES
('1', 'ROLE_REGISTERED_USER'),
('2', 'ROLE_BOOKING_MANAGER');

INSERT INTO user (id, last_name, name, password, username) VALUES (1, 'demo', 'demo', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'demo');

INSERT INTO user_roles (user_id, roles_id) VALUES (1, 1);

INSERT INTO user_roles (user_id, roles_id) VALUES (1, 2);

