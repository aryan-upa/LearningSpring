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

create table if not exists `roles` (
   `role_id` int not null auto_increment,
   `role_name` varchar(50) not null ,
   `created_at` timestamp not null ,
   `created_by` varchar(50) not null ,
   `updated_at` timestamp default null ,
   `updated_by` varchar(50) default null,
   primary key (role_id)
);

create table if not exists `address` (
     `address_id` int not null auto_increment,
     `address1` varchar(200) not null ,
     `address2` varchar(200) default null,
     `city` varchar(50) not null ,
     `state` varchar(50) not null,
     `zip_code` int not null,
     `created_at` timestamp not null ,
     `created_by` varchar(50) not null ,
     `updated_at` timestamp default null ,
     `updated_by` varchar(50) default null,
     primary key (address_id)
);

create table if not exists `person` (
    `person_id` int not null auto_increment,
    `name` varchar(100) not null,
    `email` varchar(50) not null ,
    `phone_number` varchar(15) not null ,
    `pwd` varchar(150) not null ,
    `role_id` int not null ,
    `address_id` int null ,
    `created_at` timestamp not null ,
    `created_by` varchar(50) not null ,
    `updated_at` timestamp default null ,
    `updated_by` varchar(50) default null,
    foreign key (role_id) references roles(role_id) on delete cascade ,
    foreign key (address_id) references address(address_id)
);
