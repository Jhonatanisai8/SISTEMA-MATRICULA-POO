CREATE TABLE `persona` (
	`id_persona` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`nombre` VARCHAR(55) NOT NULL,
	`apellido_paterno` VARCHAR(55) NOT NULL,
	`apellido_materno` VARCHAR(55) NOT NULL,
	`fecha_nacimiento` VARCHAR(55) NOT NULL,
	`id_dni` INTEGER NOT NULL,
	`id_direccion` INTEGER NOT NULL,
	`telefono` VARCHAR(10) NOT NULL,
	`email_personal` VARCHAR(55) NOT NULL,
	PRIMARY KEY(`id_persona`)
);


CREATE TABLE `direccion` (
	`id_direccion` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`distrito` VARCHAR(50) NOT NULL,
	`calle` VARCHAR(35) NOT NULL,
	`numero_cale` VARCHAR(5) NOT NULL,
	`provincia` VARCHAR(55) NOT NULL,
	PRIMARY KEY(`id_direccion`)
);


CREATE TABLE `dni` (
	`id_dni` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`tipo_documento` VARCHAR(55) NOT NULL,
	`numero_dni` VARCHAR(10) NOT NULL,
	PRIMARY KEY(`id_dni`)
);


CREATE TABLE `estudiante` (
	`id_estudiante` INTEGER NOT NULL UNIQUE,
	`codigo_estudiante` VARCHAR(20) NOT NULL,
	`email_educativo` VARCHAR(30) NOT NULL,
	`id_apoderado` INTEGER NOT NULL,
	PRIMARY KEY(`id_estudiante`)
);


CREATE TABLE `docente` (
	`id_docente` INTEGER NOT NULL UNIQUE,
	`codigo_docente` VARCHAR(10) NOT NULL,
	`titulo_academico` VARCHAR(55) NOT NULL,
	`anios_esperiencia` INTEGER NOT NULL,
	`email_educativo_docente` VARCHAR(30) NOT NULL,
	PRIMARY KEY(`id_docente`)
);


CREATE TABLE `curso` (
	`id_curso` INTEGER AUTO_INCREMENT,
	`codigo_curso` VARCHAR(10) NOT NULL UNIQUE,
	`nombre_curso` VARCHAR(50) NOT NULL,
	`descripcion` TEXT,
	`grado` INTEGER,
	`nivel` VARCHAR(50),
	PRIMARY KEY(`id_curso`)
);


CREATE TABLE `horario` (
	`id_horario` INTEGER AUTO_INCREMENT,
	`dia_semana` VARCHAR(15) NOT NULL,
	`hora_inicio` TIME NOT NULL,
	`hora_fin` TIME NOT NULL,
	`turno` VARCHAR(55) NOT NULL,
	PRIMARY KEY(`id_horario`)
);


CREATE TABLE `salon` (
	`id_salon` INTEGER AUTO_INCREMENT,
	`nombre_salon` VARCHAR(50) NOT NULL UNIQUE,
	`capacidad` INTEGER NOT NULL,
	`referencia` VARCHAR(45) NOT NULL,
	PRIMARY KEY(`id_salon`)
);


CREATE TABLE `matricula` (
	`id_matricula` INTEGER AUTO_INCREMENT,
	`id_estudiante` INTEGER NOT NULL,
	`id_asignacion` INTEGER NOT NULL,
	`fecha_matricula` DATE NOT NULL,
	PRIMARY KEY(`id_matricula`)
);


CREATE TABLE `apoderado` (
	`id_apoderado` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`relacion_estudiante` VARCHAR(55) NOT NULL,
	`ocupacion` VARCHAR(55) NOT NULL,
	`estado_civil` VARCHAR(55) NOT NULL
);


CREATE TABLE `Asignacion` (
	`id_asignacion` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`id_docente` INTEGER NOT NULL,
	`id_curso` INTEGER NOT NULL,
	`id_salon` INTEGER NOT NULL,
	`id_horario` INTEGER NOT NULL,
	PRIMARY KEY(`id_asignacion`)
);


ALTER TABLE `matricula`
ADD FOREIGN KEY(`id_estudiante`) REFERENCES `estudiante`(`id_estudiante`)
ON UPDATE NO ACTION ON DELETE CASCADE;
ALTER TABLE `persona`
ADD FOREIGN KEY(`id_direccion`) REFERENCES `direccion`(`id_direccion`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `persona`
ADD FOREIGN KEY(`id_dni`) REFERENCES `dni`(`id_dni`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `estudiante`
ADD FOREIGN KEY(`id_estudiante`) REFERENCES `persona`(`id_persona`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `docente`
ADD FOREIGN KEY(`id_docente`) REFERENCES `persona`(`id_persona`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `apoderado`
ADD FOREIGN KEY(`id_apoderado`) REFERENCES `persona`(`id_persona`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `estudiante`
ADD FOREIGN KEY(`id_apoderado`) REFERENCES `apoderado`(`id_apoderado`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Asignacion`
ADD FOREIGN KEY(`id_docente`) REFERENCES `docente`(`id_docente`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Asignacion`
ADD FOREIGN KEY(`id_horario`) REFERENCES `horario`(`id_horario`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Asignacion`
ADD FOREIGN KEY(`id_salon`) REFERENCES `salon`(`id_salon`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Asignacion`
ADD FOREIGN KEY(`id_curso`) REFERENCES `curso`(`id_curso`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `matricula`
ADD FOREIGN KEY(`id_asignacion`) REFERENCES `Asignacion`(`id_asignacion`)
ON UPDATE NO ACTION ON DELETE NO ACTION;