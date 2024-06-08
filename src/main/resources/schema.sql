drop table Pet if exists;

create table if not exists Pet (
  id bigint auto_increment primary key,
  name varchar(25) not null,
  date_of_birth timestamp not null,
  race varchar(25) not null,
  weight float not null,
  has_chip boolean not null,
  url_picture varchar(100) not null
);
