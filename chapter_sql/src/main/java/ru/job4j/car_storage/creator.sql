CREATE TABLE car_storage.transmission (
  id   SERIAL PRIMARY KEY,
  type VARCHAR(100)
);
INSERT INTO car_storage.transmission VALUES (1, 'AUTOMATIC_TRANSMISSION');
INSERT INTO car_storage.transmission VALUES (2, 'MANUAL_GEARBOX');

CREATE TABLE car_storage.motor (
  id SERIAL  NOT NULL
  CONSTRAINT motor_type PRIMARY KEY,
  type VARCHAR(100)
);
INSERT INTO car_storage.motor (type) VALUES ('PETROL');
INSERT INTO car_storage.motor (type) VALUES ('DIESEL');
INSERT INTO car_storage.motor (type) VALUES ('GAS');
INSERT INTO car_storage.motor (type) VALUES ('HYBRID');
INSERT INTO car_storage.motor (type) VALUES ('ELECTRO');

CREATE TABLE car_storage.body_type (
  id   SERIAL NOT NULL
    CONSTRAINT body_id PRIMARY KEY,
  type VARCHAR(100)
);
INSERT INTO car_storage.body_type (type) VALUES ('SUV');
INSERT INTO car_storage.body_type (type) VALUES ('JEEP');
INSERT INTO car_storage.body_type (type) VALUES ('HATCHBACK');
INSERT INTO car_storage.body_type (type) VALUES ('LIMOUSINE');
INSERT INTO car_storage.body_type (type) VALUES ('CAB');
INSERT INTO car_storage.body_type (type) VALUES ('TRUCK');

CREATE TABLE car_storage.brand_name (
  id SERIAL NOT NULL CONSTRAINT brand_id PRIMARY KEY,
  name VARCHAR(100)
);
INSERT INTO car_storage.brand_name (name) VALUES ('CADILLAC');
INSERT INTO car_storage.brand_name (name) VALUES ('TOYOTA');
INSERT INTO car_storage.brand_name (name) VALUES ('TRABANT');
INSERT INTO car_storage.brand_name (name) VALUES ('VARBURG');
INSERT INTO car_storage.brand_name (name) VALUES ('HUMMER');
INSERT INTO car_storage.brand_name (name) VALUES ('KAMAZ');
INSERT INTO car_storage.brand_name (name) VALUES ('CHEVROLET');

CREATE TABLE car_storage.car (

  id SERIAL NOT NULL PRIMARY KEY,
  brand INTEGER REFERENCES car_storage.brand_name (id),
  body_type INTEGER REFERENCES car_storage.body_type (id),
  engine INTEGER REFERENCES car_storage.motor (id),
  transmission INTEGER REFERENCES car_storage.transmission (id)
);
INSERT INTO car_storage.car (brand, body_type, engine, transmission) VALUES (3, 3, 1, 2);
INSERT INTO car_storage.car (brand, body_type, engine, transmission) VALUES (1, 4, 4, 1);
INSERT INTO car_storage.car (brand, body_type, engine, transmission) VALUES (5, 2, 2, 1);
INSERT INTO car_storage.car (brand, body_type, engine, transmission) VALUES (6, 6, 2, 2);

SELECT * FROM car_storage.car;
SELECT brand.name, body.type, motor.type, transmission.type FROM car_storage.car AS car LEFT JOIN filters.type AS t ON p.type_id = t.id;