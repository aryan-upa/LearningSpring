insert into `holidays` (`day`, `reason`, `type`, `created_at`, `created_by`)
values ('1 Jan', 'New Year''s Day', 'FESTIVAL', CURDATE(), 'DBA'),
       ('15 Apr', 'Good Friday', 'FESTIVAL', CURDATE(), 'DBA'),
       ('26 Jan', 'Republic Day', 'CENTRAL', CURDATE(), 'DBA'),
       ('15 Aug', 'Independence Day', 'CENTRAL', CURDATE(), 'DBA'),
       ('2 Oct', 'Mahatma Gandhi''s Birthday', 'CENTRAL', CURDATE(), 'DBA'),
       ('24 Nov', 'Guru Teg Bahadur Martyrdom Day', 'STATE', CURDATE(), 'DBA'),
       ('25 Dec', 'Christmas', 'FESTIVAL', CURDATE(), 'DBA');

insert into `roles` (`role_name`, `created_at`, `created_by`) values("ADMIN", CURDATE(), "DBA");
insert into `roles` (`role_name`, `created_at`, `created_by`) values("STUDENT", CURDATE(), "DBA");