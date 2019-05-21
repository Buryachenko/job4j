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

INSERT INTO "body"(name)	 VALUES('B000407');
INSERT INTO "body"(name)	 VALUES('B002101');

INSERT INTO motor(name)		 VALUES('M000407');
INSERT INTO motor(name)		 VALUES('M002101');

INSERT INTO gearbox(name)	 VALUES('G000407');
INSERT INTO gearbox(name)	 VALUES('G002101');

INSERT INTO "body"(name)	 VALUES('B_NOT_USE_0');
INSERT INTO motor(name)		 VALUES('M_NOT_USE_0');
INSERT INTO gearbox(name)	 VALUES('G_NOT_USE_0');
INSERT INTO "body"(name)	 VALUES('B_NOT_USE_1');
INSERT INTO motor(name)		 VALUES('M_NOT_USE_1');
INSERT INTO gearbox(name)	 VALUES('G_NOT_USE_1');
INSERT INTO "body"(name)	 VALUES('B_NOT_USE_2');
INSERT INTO motor(name)		 VALUES('M_NOT_USE_2');
INSERT INTO gearbox(name)	 VALUES('G_NOT_USE_2');

INSERT INTO car(name, body_id, motor_id, gearbox_id)
							 VALUES('Moskvich-407', 1, 1, 1);

INSERT INTO car(name, body_id, motor_id, gearbox_id)
							 VALUES('LADA-2101', 2, 2, 2);

SELECT car.name AS car, "body".name AS "body", motor.name AS motor, gearbox.name AS gearbox
FROM car LEFT JOIN "body" on car.body_id = "body".id 
		 LEFT JOIN motor on car.motor_id = motor.id
		 LEFT JOIN gearbox on car.gearbox_id = gearbox.id;

SELECT "body".name AS "body", motor.name AS motor, gearbox.name AS gearbox
FROM car RIGHT JOIN "body" on car.body_id = "body".id
		 FULL JOIN motor on car.motor_id = motor.id
		 FULL JOIN gearbox on car.gearbox_id = gearbox.id
WHERE car IS NULL;