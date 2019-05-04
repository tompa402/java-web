insert into user (username, password, enabled, created)
values ('admin', '$2a$10$eG28hqAjihXGfSyrNUji9OZEGnMNh66uQUjjIBU0OaaE4Os4u1tom', 1, NOW());
insert into user (username, password, enabled, created)
values ('student', '$2a$10$XUil1gwD8eWVxsCl4T0WmuvWr/u/eOR/colwWalMWa.4rw.BK7Unm', 1, NOW());

insert into role (name, created) values ('ROLE_ADMIN', NOW());
insert into role (name, created) values ('ROLE_USER', NOW());

insert into user_role (user_id, role_id) values (1,1);
insert into user_role (user_id, role_id) values (1,2);
insert into user_role (user_id, role_id) values (2,2);

insert into wallet_type (name, created) values ('CASH', NOW());
insert into wallet_type (name, created) values ('DEBIT_CARD', NOW());
insert into wallet_type (name, created) values ('CREDIT_CARD', NOW());
insert into expense_type (name, created) values ('FOOD', NOW());
insert into expense_type (name, created) values ('DRINK', NOW());
insert into expense_type (name, created) values ('BILL', NOW());
insert into expense_type (name, created) values ('OTHER', NOW());

insert into wallet (user_id, wallet_type_id, name, created) values (1, 1, 'Admin Novcarka', NOW());
insert into wallet (user_id, wallet_type_id, name, created) values (2, 1, 'User Novcarka', NOW());

insert into expense (wallet_id, expense_type_id, name, amount, description, created)
values (1, 1, 'Pizza', 35.00, 'Bila je fina', NOW());
insert into expense (wallet_id, expense_type_id, name, amount, description, created)
values (1, 2, 'Pivo', 20.00, 'Dobro al skupo', NOW());

insert into expense (wallet_id, expense_type_id, name, amount, description, created)
values (2, 1, 'Burek', 12.00, 'Od mesa, zna se', NOW());
insert into expense (wallet_id, expense_type_id, name, amount, description, created)
values (2, 2, 'Pelin', 11.00, 'U malim bocicama se otrov drzi', NOW());


insert into transaction_type (name, created) values ('INCOME', NOW());
insert into transaction_type (name, created) values ('EXPENSE', NOW());

insert into transaction_category (trx_type_id, name, created) values (2, 'FOOD', NOW());
insert into transaction_category (trx_type_id, name, created) values (2, 'DRINK', NOW());
insert into transaction_category (trx_type_id, name, created) values (2, 'BILL', NOW());
insert into transaction_category (trx_type_id, name, created) values (2, 'OTHER', NOW());

insert into transaction (wallet_id, trx_type_id, trx_category_id, name, amount, description, created)
values (1, 2, 1, 'Pizza', 35.00, 'Bila je fina', NOW());
insert into transaction (wallet_id, trx_category_id, trx_type_id, name, amount, description, created)
values (1, 2, 2, 'Pivo', 20.00, 'Dobro al skupo', NOW());

insert into transaction (wallet_id, trx_category_id, trx_type_id, name, amount, description, created)
values (2, 2, 1, 'Burek', 12.00, 'Od mesa, zna se', NOW());
insert into transaction (wallet_id, trx_category_id, trx_type_id, name, amount, description, created)
values (2, 2, 2, 'Pelin', 11.00, 'U malim bocicama se otrov drzi', NOW());