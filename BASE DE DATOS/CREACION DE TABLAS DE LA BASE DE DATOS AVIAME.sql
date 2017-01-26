create database aviame;
use aviame;

create table usuario(
id_usuario int auto_increment not null,
nombre varchar(25),
apellidos varchar(25),
edad int (2),
telefono varchar(15),
correo varchar(60),
username varchar (20) unique,
contraseña varchar(29),
primary key(id_usuario)
)ENGINE=InnoDB;

create table pajaro(
id_pajaro int auto_increment not null,
especie varchar(25),
sexo varchar(25),
color varchar (25),
observaciones varchar(50),
id_usuario int(3),
id_pareja int (3),
primary key(id_pajaro),
foreign key (id_usuario) references usuario(id_usuario) on delete cascade on update cascade,
foreign key (id_pareja) references pajaro(id_pajaro) on delete cascade on update cascade
)ENGINE=InnoDB;

create table enfermedad(
id_enfermedad int auto_increment not null,
nombre varchar(25),
sintomas varchar(100),
primary key(id_enfermedad)
)ENGINE=InnoDB;


create table enfermedades(
id_enfermedad int(3),
id_pajaro int (3),
primary key(id_enfermedad,id_pajaro),
foreign key (id_enfermedad) references enfermedad(id_enfermedad) on delete cascade on update cascade,
foreign key (id_pajaro) references pajaro(id_pajaro) on delete cascade on update cascade
)ENGINE=InnoDB;


create table medicamento(
id_medicamento int auto_increment not null,
nombre varchar(30),
fecha_caducidad date,
primary key (id_medicamento)
)ENGINE=InnoDB;

create table tratamiento(
id_tratamiento int auto_increment not null ,
id_enfermedad int(3),
id_medicamento int (3),
fecha_inicio date,
fecha_fin date,
primary key (id_tratamiento),
foreign key (id_enfermedad) references enfermedad(id_enfermedad) on delete cascade on update cascade,
foreign key (id_medicamento) references medicamento(id_medicamento) on delete cascade on update cascade
)ENGINE=InnoDB;


