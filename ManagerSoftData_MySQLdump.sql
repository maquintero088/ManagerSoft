CREATE DATABASE IF NOT EXISTS managersoftdata /*!40100 DEFAULT CHARACTER SET UTF8 */;
use managersoftdata;
CREATE TABLE T_group (
	id_group bigint not null auto_increment primary key,
	name_group varchar(100) not null,
	state_group tinyint not null
);
CREATE TABLE T_activity (
	id_activity bigint not null auto_increment primary key,
	fk_kind int not null,
	fk_group bigint not null,
	date_activity date not null,
	start_activity time not null,
	fk_period int not null,
	image_activity longblob 
);
CREATE TABLE T_kind (
	id_kind int not null auto_increment primary key,
	name_kind varchar (35) not null,	
	description_kind text not null,
	state_kind tinyint not null,
	state_image tinyint not null
);
CREATE TABLE T_period (
	id_period int not null auto_increment primary key,
	name_period varchar(35) not null,
	val_period int
);
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `managersoftdata`.`v_activity` AS
    select 
        `act`.`id_activity` AS `Id`,
        concat(`act`.`date_activity`,
                ' - ',
                `act`.`start_activity`) AS `fecha_hora`,
        `knd`.`name_kind` AS `actividad`,
        `grp`.`name_group` AS `grupo`,
        `prd`.`name_period` AS `duracion`,
        `act`.`description_activity` AS `descripcion`
    from
        (((`managersoftdata`.`t_activity` `act`
        join `managersoftdata`.`t_kind` `knd`)
        join `managersoftdata`.`t_group` `grp`)
        join `managersoftdata`.`t_period` `prd`)
    where
        ((`knd`.`id_kind` = `act`.`fk_kind`)
            and (`grp`.`id_group` = `act`.`fk_group`)
            and (`prd`.`id_period` = `act`.`fk_period`))
    group by `act`.`id_activity`
    order by `act`.`id_activity`;

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `managersoftdata`.`v_schedule` AS
    select 
        `act`.`id_activity` AS `id`,
        `knd`.`name_kind` AS `actividad`,
        `grp`.`name_group` AS `grupo`,
        concat(`act`.`date_activity`,
                ' ',
                `act`.`start_activity`) AS `fecha_hora`,
        `prd`.`name_period` AS `duracion`,
        (str_to_date(concat(`act`.`date_activity`,
                        ' ',
                        `act`.`start_activity`),
                '%Y-%m-%d %h:%i:%s') + interval `prd`.`val_period` minute) AS `fecha_hora_fin`,
        (case
            when
                (str_to_date(concat(`act`.`date_activity`,
                                ' ',
                                `act`.`start_activity`),
                        '%Y-%m-%d %h:%i:%s') > now())
            then
                1
            else 0
        end) AS `estado`
    from
        (((`managersoftdata`.`t_group` `grp`
        join `managersoftdata`.`t_activity` `act`)
        join `managersoftdata`.`t_kind` `knd`)
        join `managersoftdata`.`t_period` `prd`)
    where
        ((`knd`.`id_kind` = `act`.`fk_kind`)
            and (`grp`.`id_group` = `act`.`fk_group`)
            and (`prd`.`id_period` = `act`.`fk_period`))
    order by `act`.`id_activity`