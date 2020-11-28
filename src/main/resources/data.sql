INSERT INTO `role` (`id`, `name`) VALUES
('1', 'ROLE_REGISTERED_USER'),
('2', 'ROLE_BOOKING_MANAGER');

INSERT INTO users.user (id, last_name, name, password, username) VALUES (1, 'demo', 'demo', 'demo', 'demo@localhost');

INSERT INTO users.user_roles (user_id, roles_id) VALUES (1, 1);

INSERT INTO users.user_roles (user_id, roles_id) VALUES (1, 2);

