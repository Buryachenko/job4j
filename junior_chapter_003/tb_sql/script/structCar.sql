CREATE TABLE "body" (
							id				serial primary key,
							name			varchar(1000)
);

CREATE TABLE motor (
							id				serial primary key,
							name			varchar(1000)
);

CREATE TABLE gearbox (
							id				serial primary key,
							name			varchar(1000)
);

CREATE TABLE  car (
							id				serial primary key,
							name			varchar(1000),
							body_id			int references "body"(id),
							motor_id		int references motor(id),
							gearbox_id		int references gearbox(id)
);

INSERT INTO "body"(name)	VALUES('B000407');
INSERT INTO "body"(name)	VALUES('B002101');

INSERT INTO motor(name)		VALUES('M000407');
INSERT INTO motor(name)		VALUES('M002101');

INSERT INTO gearbox(name)	VALUES('G000407');
INSERT INTO gearbox(name)	VALUES('G002101');

INSERT INTO "body"(name)	VALUES('B_NOT_USE_0');
INSERT INTO motor(name)		VALUES('M_NOT_USE_0');
INSERT INTO gearbox(name)	VALUES('G_NOT_USE_0');
INSERT INTO "body"(name)	VALUES('B_NOT_USE_1');
INSERT INTO motor(name)		VALUES('M_NOT_USE_1');
INSERT INTO gearbox(name)	VALUES('G_NOT_USE_1');
INSERT INTO "body"(name)	VALUES('B_NOT_USE_2');
INSERT INTO motor(name)		VALUES('M_NOT_USE_2');
INSERT INTO gearbox(name)	VALUES('G_NOT_USE_2');

INSERT INTO car(name, body_id, motor_id, gearbox_id)
							VALUES('Москвич-407', 1, 1, 1);

INSERT INTO car(name, body_id, motor_id, gearbox_id)
							VALUES('ВАЗ-2101', 2, 2, 2);

-- 1. Вывести список всех машин и все привязанные к ним детали.
SELECT car.name AS car, "body".name AS "body", motor.name AS motor, gearbox.name AS gearbox
FROM car left join "body" on car.body_id = "body".id 
		 left join motor on car.motor_id = motor.id
		 left join gearbox on car.gearbox_id = gearbox.id;

-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
SELECT "body".name AS "body", motor.name AS motor, gearbox.name AS gearbox
FROM car right join "body" on car.body_id = "body".id
		 full join motor on car.motor_id = motor.id
		 full join gearbox on car.gearbox_id = gearbox.id
WHERE car is null;