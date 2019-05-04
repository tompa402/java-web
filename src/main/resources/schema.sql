create table if not exists user (
 id identity,
 username varchar(20) not null,
 password varchar(100) not null,
 first_name varchar(100),
 last_name varchar(100),
 enabled bit not null,
 created timestamp,
 modified timestamp,
);
create table if not exists role (
 id identity,
 name varchar(20) not null,
 created timestamp,
 modified timestamp
);

create table if not exists user_role (
 user_id integer not null,
 role_id integer not null,
 PRIMARY KEY (user_id, role_id),
 foreign key (user_id) references user(id),
 foreign key (role_id) references role(id),

);

create table if not exists wallet_type(
  id identity,
  name varchar(16) not null,
  created timestamp,
  modified timestamp,
);

create table if not exists expense_type(
  id identity,
  name varchar(16) not null,
  created timestamp,
  modified timestamp,
);

create table if not exists wallet(
  id identity,
  user_id integer not null,
  wallet_type_id integer not null,
  name varchar(32) not null,
  created timestamp,
  modified timestamp,
  foreign key (user_id) references user(id),
  foreign key (wallet_type_id) references wallet_type(id),
);

create table if not exists expense(
  id identity,
  wallet_id integer not null,
  expense_type_id integer not null,
  name varchar(32) not null,
  amount NUMERIC(8,2) not null,
  description varchar (128),
  created timestamp,
  modified timestamp,
  foreign key (wallet_id) references wallet(id),
  foreign key (expense_type_id) references expense_type(id),
);

create table if not exists transaction_type(
  id identity,
  name varchar(16) not null,
  created timestamp,
  modified timestamp,
);

create table if not exists transaction_category(
  id identity,
  trx_type_id integer not null,
  name varchar(16) not null,
  created timestamp,
  modified timestamp,
  foreign key (trx_type_id) references transaction_type(id),
);

create table if not exists transaction(
  id identity,
  wallet_id integer not null,
  trx_type_id integer not null,
  trx_category_id integer not null,
  name varchar(32) not null,
  amount NUMERIC(8,2) not null,
  description varchar (128),
  created timestamp,
  modified timestamp,
  foreign key (wallet_id) references wallet(id),
  foreign key (trx_type_id) references transaction_type(id),
  foreign key (trx_category_id) references transaction_category(id),
);