insert into sensor_definition(id, name,distirict,city)
values(101, 'SensorSpain',' Gràcia, Eixample','Barcelona');

insert into sensor_roles(id, sensor_def_id,role)
values(101, 101,'SensorSpain');

insert into sensor_definition(id, name,distirict,city)
values(102, 'SensorAustria',' Währing, Penzing','Wien');

insert into sensor_roles(id, sensor_def_id,role)
values(102, 102,'SensorAustria');

insert into sensor_definition(id, name,distirict,city)
values(103, 'SensorGermany','Maxvorstadt','München');

insert into sensor_roles(id, sensor_def_id,role)
values(103, 103,'SensorGermany');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(201, 101,391.2,331.2,'2021-02-01 08:16:00');

insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(202, 101,391.2,341.2,'2021-02-01 09:16:00');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(203, 101,391.2,351.2,'2021-02-01 10:16:00');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(205, 101,391.2,371.2,'2021-02-01 10:20:00');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(206, 102,391.2,391.2,'2021-02-01 10:21:00');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(207, 102,391.2,331.2,'2021-02-01 10:22:00');

insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(208, 102,391.2,341.2,'2021-02-01 10:23:00');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(209, 102,391.2,351.2,'2021-02-01 10:23:00');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(210, 102,391.2,371.2,'2021-02-01 10:24:00');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(211, 102,391.2,391.2,'2021-02-01 10:25:00');

insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(212, 102,391.2,351.2,'2021-02-01 10:26:00');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(213, 102,391.2,371.2,'2021-01-23 21:31:00');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(214, 102,391.2,391.2,'2021-01-23 21:33:00');