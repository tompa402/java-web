insert into users (username, password, enabled)
values ('admin', '$2a$10$eG28hqAjihXGfSyrNUji9OZEGnMNh66uQUjjIBU0OaaE4Os4u1tom', 1);
insert into users (username, password, enabled)
values ('student', '$2a$10$XUil1gwD8eWVxsCl4T0WmuvWr/u/eOR/colwWalMWa.4rw.BK7Unm', 1);
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('admin', 'ROLE_USER');
insert into authorities (username, authority) values ('student', 'ROLE_USER');

insert into wallet_type (name) values ('CASH');
insert into wallet_type (name) values ('DEBIT_CARD');
insert into wallet_type (name) values ('CREDIT_CARD');
insert into expense_type (name) values ('FOOD',);
insert into expense_type (name) values ('DRINK');
insert into expense_type (name) values ('BILL');
insert into expense_type (name) values ('OTHER');

insert into wallet (user_id, wallet_type_id, name) values (1, 1, 'Admin Novcarka');
insert into wallet (user_id, wallet_type_id, name) values (2, 1, 'User Novcarka');

insert into expense (wallet_id, expense_type_id, name, amount, description)
values (1, 1, 'Pizza', 35.00, 'Bila je fina');
insert into expense (wallet_id, expense_type_id, name, amount, description)
values (1, 2, 'Pivo', 20.00, 'Dobro al skupo');

insert into expense (wallet_id, expense_type_id, name, amount, description)
values (2, 1, 'Burek', 12.00, 'Od mesa, zna se');
insert into expense (wallet_id, expense_type_id, name, amount, description)
values (2, 2, 'Pelin', 11.00, 'U malim bocicama se otrov drzi');