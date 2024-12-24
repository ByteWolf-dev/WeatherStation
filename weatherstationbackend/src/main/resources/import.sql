-- Insert single test data for Sensor with specified IDs
INSERT INTO sensor (id, type, model, installationdate, status) VALUES (1, 'Temperature', 'ThermoX1000', TO_DATE('2023-01-15', 'YYYY-MM-DD'), 1);
INSERT INTO sensor (id, type, model, installationdate, status) VALUES (2, 'Humidity', 'HumidityProX', TO_DATE('2023-02-20', 'YYYY-MM-DD'), 1);
INSERT INTO sensor (id, type, model, installationdate, status) VALUES (3, 'Pressure', 'PressureMax200', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 0);

-- Insert Measurements for each sensor
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (1, 1, TO_TIMESTAMP('2023-01-15 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 22.5, 60.0, 1013.25);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (2, 2, TO_TIMESTAMP('2023-02-20 14:30:00', 'YYYY-MM-DD HH24:MI:SS'), 23.0, 65.5, 1012.80);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (3, 3, TO_TIMESTAMP('2023-03-10 08:45:00', 'YYYY-MM-DD HH24:MI:SS'), 21.0, 55.0, 1014.00);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (4, 1, TO_TIMESTAMP('2023-01-16 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 22.8, 59.5, 1013.10);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (5, 1, TO_TIMESTAMP('2023-01-17 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 23.1, 58.0, 1013.05);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (6, 1, TO_TIMESTAMP('2023-01-18 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 22.9, 60.2, 1013.20);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (7, 2, TO_TIMESTAMP('2023-02-21 14:30:00', 'YYYY-MM-DD HH24:MI:SS'), 22.5, 63.0, 1012.90);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (8, 2, TO_TIMESTAMP('2023-02-22 14:30:00', 'YYYY-MM-DD HH24:MI:SS'), 23.2, 66.0, 1012.75);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (9, 2, TO_TIMESTAMP('2023-02-23 14:30:00', 'YYYY-MM-DD HH24:MI:SS'), 22.9, 64.5, 1012.80);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (10, 2, TO_TIMESTAMP('2023-02-24 14:30:00', 'YYYY-MM-DD HH24:MI:SS'), 23.0, 65.0, 1012.85);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (11, 3, TO_TIMESTAMP('2023-03-11 08:45:00', 'YYYY-MM-DD HH24:MI:SS'), 20.8, 55.5, 1014.10);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (12, 3, TO_TIMESTAMP('2023-03-12 08:45:00', 'YYYY-MM-DD HH24:MI:SS'), 21.1, 56.0, 1014.05);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (13, 3, TO_TIMESTAMP('2023-03-13 08:45:00', 'YYYY-MM-DD HH24:MI:SS'), 21.0, 55.2, 1014.00);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (14, 3, TO_TIMESTAMP('2023-03-14 08:45:00', 'YYYY-MM-DD HH24:MI:SS'), 20.9, 55.8, 1014.15);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (15, 1, TO_TIMESTAMP('2023-01-19 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 23.0, 61.0, 1013.00);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (16, 1, TO_TIMESTAMP('2023-01-20 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 22.7, 59.0, 1013.10);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (17, 1, TO_TIMESTAMP('2023-01-21 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 23.2, 60.3, 1013.15);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (18, 2, TO_TIMESTAMP('2023-02-25 14:30:00', 'YYYY-MM-DD HH24:MI:SS'), 22.8, 62.0, 1012.70);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (19, 2, TO_TIMESTAMP('2023-02-26 14:30:00', 'YYYY-MM-DD HH24:MI:SS'), 23.1, 64.0, 1012.65);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (20, 2, TO_TIMESTAMP('2023-02-27 14:30:00', 'YYYY-MM-DD HH24:MI:SS'), 23.0, 63.5, 1012.60);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (21, 3, TO_TIMESTAMP('2023-03-15 08:45:00', 'YYYY-MM-DD HH24:MI:SS'), 21.2, 56.5, 1014.00);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (22, 3, TO_TIMESTAMP('2023-03-16 08:45:00', 'YYYY-MM-DD HH24:MI:SS'), 21.1, 56.2, 1014.05);
INSERT INTO measurement (id, sensor_id, timestamp, temperature, humidity, pressure) VALUES (23, 3, TO_TIMESTAMP('2023-03-17 08:45:00', 'YYYY-MM-DD HH24:MI:SS'), 21.0, 55.8, 1014.10);

-- Insert Locations for each sensor
INSERT INTO location (id, sensor_id, name, description) VALUES (1, 1, 'Room A', 'Temperature sensor in Room A');
INSERT INTO location (id, sensor_id, name, description) VALUES (2, 2, 'Room B', 'Humidity sensor in Room B');
INSERT INTO location (id, sensor_id, name, description) VALUES (3, 3, 'Room C', 'Pressure sensor in Room C');
