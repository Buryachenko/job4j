create table role (
	id						serial primary key,
	name					varchar(100));

create table "user" (
	id						serial primary key,
	login					varchar(100) not null,
	password				varchar(100) not null,
	role_id					int not null references role(id));

create table rules (
	id						serial primary key,
	name					varchar(100),
	readInfo				boolean,
	putItem					boolean,
	changeItem				boolean,
	deleteItem				boolean,
	commentItem				boolean,
	configure				boolean);

create table role_rules (
	id						serial primary key,
	role_id					int references role(id),
	rules_id				int references rules(id));

create table category (
	id						serial primary key,
	name					varchar(100));

create table attachs (
	id						serial primary key,
	name					varchar(1000),
	pathFile				varchar(1000),
	ts						timestamp not null default current_timestamp);

create table "state" (
	id						serial primary key,
	valid					boolean);

create table item (
	id						serial primary key,
	name					varchar(1000),
	info					text,
	user_id					int references "user"(id),
	category_id				int references category(id),
	attachs_id				int references attachs(id),
	state_id				int references "state"(id),
	ts						timestamp not null default current_timestamp);

create table comments (
	id						serial primary key,
	content					text,
	item_id					int references item(id),
	ts						timestamp not null default current_timestamp);

insert into role (name) values ('root');
insert into role (name) values ('user');

insert into rules (name, readInfo, putItem, changeItem, deleteItem, commentItem, configure)
values ('root', true, true, true, true, true, true);

insert into rules (name, readInfo, putItem, changeItem, deleteItem, commentItem, configure)
values ('user', true, true, true, false, true, false);

insert into role_rules (role_id, rules_id) values (1, 1);
insert into role_rules (role_id, rules_id) values (2, 2);

insert into "user" (login, password, role_id) values ('root', 'root', 1);

insert into category (name) values ('declaration');
insert into category (name) values ('offer');
insert into category (name) values ('buy');
insert into category (name) values ('sell');

insert into "state" (valid) values (true);

insert into attachs (name, pathFile, ts) values ('shema', '/path/to/shema.pdf', current_timestamp);

insert into item (name, info, user_id, category_id, attachs_id, state_id, ts) values ('shema', 'declaration', 1, 1, 1, 1, current_timestamp);

insert into comments (content, item_id, ts) values ('limited offer', 1, current_timestamp);