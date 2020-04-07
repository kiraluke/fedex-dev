insert into roles (name, allowed_resource, allowed_read, allowed_create, allowed_update, allowed_delete) values
('Admin', '/', TRUE, TRUE, TRUE, TRUE),
('Manager', '/users,/user,/packs,/pack,/routing', TRUE, TRUE, TRUE, FALSE),
('user', '/users,/user,/packs,/pack', TRUE, FALSE, FALSE, FALSE)
;
commit;
insert into users (username, password, first_name, last_name, email) values
('dwang', '25f9e794323b453885f5181f1b624d0b', 'David', 'Wang', 'dwang@training.ascendingdc.com'),
('rhang', '25f9e794323b453885f5181f1b624d0b', 'Ryo', 'Hang', 'rhang@training.ascendingdc.com'),
('xyhuang', '25f9e794323b453885f5181f1b624d0b', 'Xinyue', 'Huang', 'xyhuang@training.ascendingdc.com')
;
commit;
insert into users_roles values
(1, 1),
(2, 2),
(3, 3),
(1, 2),
(1, 3)
;
commit;