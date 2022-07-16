create database newschool;

use newschool;

create table if not exists `contact_msg` (
    `contact_id` int AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) not null,
    `mobile_num` varchar(100) not null,
    `email` varchar(100) not null,
    `subject` varchar(100) not null,
    `message` varchar(500) not null,
    `status` varchar(10) not null,
    `created_at` timestamp not null,
    `created_by` varchar(50) not null,
    `updated_at` timestamp default null,
    `updated_by` varchar(50) default null
);

create table if not exists `holidays` (
    `day` varchar(20) not null,
    `reason` varchar(100) not null,
    `type` varchar(20) not null,
    `created_at` timestamp not null,
    `created_by` varchar(50) not null,
    `updated_at` timestamp default null,
    `updated_by` varchar(50) default null
);
