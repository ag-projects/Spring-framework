-- Insert Role
INSERT INTO role (name) VALUES ('ROLE_USER');

-- Insert to users passwords are both 'password'
INSERT INTO user (username, enabled, password, role_id) VALUES ('user', true, '$2a$08$3r6GhyanL8tcBj40USviduUiCsDoECOqfM7uMRZOoHQDDYTkZ9Jna', 1);
INSERT INTO user (username, enabled, password,role_id) VALUES ('user2', true, '$2a$08$3r6GhyanL8tcBj40USviduUiCsDoECOqfM7uMRZOoHQDDYTkZ9Jna', 1);

-- Insert tasks
insert into task (complete,description, user_id) values (true,'Code Task entity', 1);
insert into task (complete,description, user_id) values (false,'Discuss users and roles', 1);
insert into task (complete,description, user_id) values (false,'Enable Spring Security', 2);
insert into task (complete,description, user_id) values (false,'Test application', 2);