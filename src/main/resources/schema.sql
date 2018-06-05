create table addr_book (
  ab_id int auto_increment primary key,
  ab_name varchar,
  ab_email varchar,
  ab_tel varchar,
  ab_comdept varchar,
  ab_birth varchar,
  ab_memo varchar
);

create table simple_data (
  aid int auto_increment primary key,
  name varchar,
  email varchar,
  tel varchar,
  company varchar,
  memo varchar,
  birth date
);