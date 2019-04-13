create table if not exists users (
 id identity,
 username varchar(20) not null,
 password varchar(100) not null,
 enabled bit not null,

);
create table if not exists authorities (
 id identity,
 username varchar(20) not null,
 authority varchar(20) not null
);

create table if not exists wallet_type(
  id identity,
  name varchar(16) not null
);

create table if not exists expense_type(
  id identity,
  name varchar(16) not null
);

create table if not exists wallet(
  id identity,
  user_id int,
  wallet_type varchar(16),
  name varchar(32) not null,
  created timestamp as CURRENT_TIMESTAMP,
  foreign key (user_id) references users(id)
);

create table if not exists expense(
  id identity,
  wallet_id int,
  expense_type varchar (16),
  name varchar(32) not null,
  amount NUMERIC(8,2) not null,
  description varchar (128),
  created timestamp as CURRENT_TIMESTAMP,
  foreign key (wallet_id) references wallet(id),
);