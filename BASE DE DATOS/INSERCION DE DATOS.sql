  INSERT INTO usuario(nombre,apellidos,edad,telefono,correo,username,contrasenya)
 values('Mauricio','Colmenero Pochetino',53,'666222111','pochemauri@gmail.com','Poxecolme','Bigotes');
 
  INSERT INTO usuario(nombre,apellidos,edad,telefono,correo,username,contrasenya)
 values('Jose','Hilario Cubel',31,'666010111','josehilario@gmail.com','joseh','Hilario'); 
 
  INSERT INTO usuario(nombre,apellidos,edad,telefono,correo,username,contrasenya)
 values('Celia','Llorens Perez',24,'666000112','celialp@gmail.com','celialp','Llorens1104');
 
  INSERT INTO usuario(nombre,apellidos,edad,telefono,correo,username,contrasenya)
 values('Angel','Hilario Cubel',26,'666111111','anhicu@gmail.com','ahlario','Angel123');
 
  INSERT INTO usuario(nombre,apellidos,edad,telefono,correo,username,contrasenya)
 values('Pablo','Llorens Perez',20,'666000111','pablollorensperez17@gmail.com','pallope','Hola1725');
 
 
 
  INSERT INTO pajaro(especie,sexo,color,observaciones,id_usuario)
 values('Jilguero','Macho','Amarillo/Negro/Rojo','Macho reproductor','2');
 
  INSERT INTO pajaro(especie,sexo,color,observaciones,id_usuario)
 values('Jilguero','Hembra','Amarillo/Negro/Rojo','Hembra pasera','2');
 
   INSERT INTO pajaro(especie,sexo,color,observaciones,id_usuario)
 values('Verderol','Macho','Verde','Pajara de gran tamaño','4');
 
  INSERT INTO pajaro(especie,sexo,color,observaciones,id_usuario)
 values('Canario','Macho','Rojo','Canario con buen cante','1');
 
  INSERT INTO pajaro(especie,sexo,color,observaciones,id_usuario)
 values('Canario','Hembra','Amarillo','Canaria cedida','3');
 
 insert into enfermedad(nombre,sintomas)
values('Anemia','Perdida de equilibrio, palido y adelgazamiento');
insert into enfermedad(nombre,sintomas)
values('Cocccidios','Pajaro inchado, diarrea y como mucho');
insert into enfermedad(nombre,sintomas)
values('Pulmonia','Tos y dificultades respiratorias');
insert into enfermedad(nombre,sintomas)
values('Hepatitis','Perdidad del canto, heces liquidas');
insert into enfermedad(nombre,sintomas)
values('Falsa muda','Perdida de plumas');


insert into enfermedades(id_enfermedad,id_pajaro)
values(1,3);
insert into enfermedades(id_enfermedad,id_pajaro)
values(2,5);
insert into enfermedades(id_enfermedad,id_pajaro)
values(3,2);
insert into enfermedades(id_enfermedad,id_pajaro)
values(4,2);
insert into enfermedades(id_enfermedad,id_pajaro)
values(5,4);


insert into medicamento(nombre,fecha_caducidad)
values ('Nekton E','2018-02-18');

insert into medicamento(nombre,fecha_caducidad)
values ('Baycox ','2018-4-20');

insert into medicamento(nombre,fecha_caducidad)
values ('Calcicolina P','2018-5-14');

insert into medicamento(nombre,fecha_caducidad)
values ('Asmoserine','2018-02-28');

insert into medicamento(nombre,fecha_caducidad)
values ('Vitaminas','2018-03-01');


insert into tratamiento(id_enfermedad,id_medicamento,fecha_inicio,fecha_fin)
values ('1','5','2017-01-17','2017-01-20');

insert into tratamiento(id_enfermedad,id_medicamento,fecha_inicio,fecha_fin)
values ('2','2','2017-01-20','2017-01-22');

insert into tratamiento(id_enfermedad,id_medicamento,fecha_inicio,fecha_fin)
values ('3','4','2017-01-25','2017-01-30');

insert into tratamiento(id_enfermedad,id_medicamento,fecha_inicio,fecha_fin)
values ('4','5','2017-02-2','2017-02-7');

insert into tratamiento(id_enfermedad,id_medicamento,fecha_inicio,fecha_fin)
values ('5','1','2017-02-04','2017-02-09');

update pajaro
set id_pareja=1
where id_pajaro=2;

update pajaro
set id_pareja=2
where id_pajaro=1;

update pajaro
set id_pareja=3
where id_pajaro>2

select * from pajaro;

