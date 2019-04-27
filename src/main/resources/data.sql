insert into user (username, password, enabled, created)
values ('admin', '$2a$10$eG28hqAjihXGfSyrNUji9OZEGnMNh66uQUjjIBU0OaaE4Os4u1tom', 1, NOW());
insert into user (username, password, enabled, created)
values ('student', '$2a$10$XUil1gwD8eWVxsCl4T0WmuvWr/u/eOR/colwWalMWa.4rw.BK7Unm', 1, NOW());

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER');

insert into user_role (user_id, role_id) values (1,1);
insert into user_role (user_id, role_id) values (1,2);
insert into user_role (user_id, role_id) values (2,2);

insert into wallet_type (name) values ('CASH');
insert into wallet_type (name) values ('DEBIT_CARD');
insert into wallet_type (name) values ('CREDIT_CARD');
insert into expense_type (name) values ('FOOD',);
insert into expense_type (name) values ('DRINK');
insert into expense_type (name) values ('BILL');
insert into expense_type (name) values ('OTHER');

insert into wallet (user_id, wallet_type, name) values (1, 'CASH', 'Admin Novcarka');
insert into wallet (user_id, wallet_type, name) values (2, 'CASH', 'User Novcarka');

insert into expense (wallet_id, expense_type, name, amount, description)
values (1, 'FOOD', 'Pizza', 35.00, 'Bila je fina');
insert into expense (wallet_id, expense_type, name, amount, description)
values (1, 'DRINK', 'Pivo', 20.00, 'Dobro al skupo');

insert into expense (wallet_id, expense_type, name, amount, description)
values (2, 'FOOD', 'Burek', 12.00, 'Od mesa, zna se');
insert into expense (wallet_id, expense_type, name, amount, description)
values (2, 'DRINK', 'Pelin', 11.00, 'U malim bocicama se otrov drzi');