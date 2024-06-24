-- roles
INSERT INTO test.roles (role_id, role_name) VALUES 
(1, 'SuperAdministrator'),
(2, 'Administrator'),
(3, 'Editor'),
(4, 'SubscribedUser'),
(5, 'GeneralUser');

INSERT INTO test.users (user_id, email, password, registration_date, user_name, role_id) VALUES
(1, 'dunglamsao837@gmail.com', '$2a$12$ONy9J2f9bSLoT24IONtX0.aXffXPKPJV.gOJWW0NUITU5a0bWUdlC', '2023-01-15', 'RealJerry', 1), -- EarnBig$
(2, 'tony.liu@example.com', '$2a$12$fIeFZHj5A9Icoe/2aipFPesqNeCyd08PMAi66AolfAXVwlZfK2eOG', '2023-02-20', 'Fake Tony', 2); -- admin
