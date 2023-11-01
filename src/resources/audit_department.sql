create table audit_department (
      "Ревизионный номер" varchar not null primary key,
      "Тип изделия" varchar not null ,
      "Адрес расположения" varchar not null
);

insert into audit_department ("Ревизионный номер", "Тип изделия", "Адрес расположения")
values ('Xg_5124', 'Компьютер', 'Общага'),
       ('Dc_5223', 'Телевизор', 'Оршанская'),
       ('Hp_5012', 'Ноутбук', 'Дубосековская 5');

insert into audit_department ("Ревизионный номер", "Тип изделия", "Адрес расположения")
values ('Kq_2325', 'Монитор', 'Общага');

insert into audit_department ("Ревизионный номер", "Тип изделия", "Адрес расположения")
values ('Ld_9873', 'Ноутбук', 'Дубосековская 5');