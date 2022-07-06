
CREATE TABLE IF NOT EXISTS movie (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    release_date DATE NOT NULL,
    unique (name)
);

create sequence hibernate_sequence start 1 increment 1;
create table if not exists account_settings (id int8 not null, name varchar(255) not null, value varchar(255) not null, account_id int8 not null, primary key (id));
create table if not exists accounts (id int8 not null, email_address varchar(255), name varchar(100) not null, primary key (id));
alter table account_settings add constraint FK54uo82jnot7ye32pyc8dcj2eh foreign key (account_id) references accounts;
