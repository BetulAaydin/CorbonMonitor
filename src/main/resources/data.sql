insert into sensor_definition(id, name,distirict,city)
values(101, 'SensorSpain',' Gràcia, Eixample','Barcelona');

insert into sensor_definition(id, name,distirict,city)
values(102, 'SensorAustria',' Währing, Penzing','Wien');

insert into sensor_definition(id, name,distirict,city)
values(103, 'SensorGermany','Maxvorstadt','München');


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(201, 101,391.2,331.2,sysdate()-0000.1);

insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(202, 101,391.2,341.2,sysdate()-0000.2);


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(203, 101,391.2,351.2,sysdate()-0000.3);


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(205, 101,391.2,371.2,sysdate()-0000.4);


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(206, 102,391.2,391.2,sysdate()-0000.5);


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(207, 102,391.2,331.2,sysdate()-0000.1);

insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(208, 102,391.2,341.2,sysdate()-0000.2);


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(209, 102,391.2,351.2,sysdate()-0000.3);


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(210, 102,391.2,371.2,sysdate()-0000.4);


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(211, 102,391.2,391.2,sysdate()-0.1);

insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(212, 102,391.2,351.2,sysdate()-0.1);


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(213, 102,391.2,371.2,sysdate()-0.1);


insert into sensor_corbon_level(id, sensor_def_id,cycle_value,trend_value,time)
values(214, 102,391.2,391.2,sysdate()-0.1);