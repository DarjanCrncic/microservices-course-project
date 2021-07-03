
insert into currency values (1, 'USD');
insert into currency values (2, 'INR');
insert into currency values (3, 'HRK');
insert into currency values (4, 'EUR');

insert into currency_rate (id, from_id, to_id, conversion_multiple) values(1, 1, 2, 65);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(2, 1, 3, 6.16);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(3, 1, 4, 0.82);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(4, 2, 1, 0.01538461538);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(5, 3, 1, 0.16233766233);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(6, 4, 1, 1.21951219512);

insert into currency_rate (id, from_id, to_id, conversion_multiple) values(7, 2, 3, 0.085);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(8, 2, 4, 0.011);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(9, 3, 2, 11.76);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(10, 3, 4, 0.13);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(11, 4, 2, 88.08);
insert into currency_rate (id, from_id, to_id, conversion_multiple) values(12, 4, 3, 7.49);