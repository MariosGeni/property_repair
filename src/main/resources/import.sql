ALTER TABLE Repair ALTER COLUMN address VARCHAR(255) COLLATE Latin1_General_100_CI_AI_SC_UTF8;

INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123456789, 'John', 'Smith', 'Tsimiski 25', 2310444455, 'johnsmith@somecompany.com', '123456789', 'DETACHED_HOUSE');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (987654321, 'George', 'Papadopoulos', 'Trapezountos 3', 2102102100, 'georgepapadopoulos@somecompany.com', '123456789', 'MAISONETTE');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (112356794, 'Athanasios', 'Galatis', 'Kavalas 43', 2310231023, 'athanasiosgalatis2@somecompany.com', '123456', 'APARTMENT_BUILDING');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123457890, 'Marios', 'Genigiorgis', 'Korai 47', 2103456789, 'mariosgenigiorgis@somecompany.com', '123456', 'MAISONETTE');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123432109, 'Niyazi', 'Haci-Halil', 'Smirnis 2', 2541012345, 'niyazihacihalil@somecompany.com', '123456', 'DETACHED_HOUSE');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (987643246, 'Dimitra', 'Florou', 'Venizelou 78', 2541023456, 'dimitraflorou5@somecompany.com', '123654', 'APARTMENT_BUILDING');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123456700, 'Jonas', 'Kahnwald', 'Skiathou 67', 2310056789, 'johnaskahnwald@somecompany.com', '654123', 'MAISONETTE');

INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (SYSDATETIME(), 'WAITING', 'PAINTING', 130, 'Klemanso 25', 1, '2 Rooms');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (SYSDATETIME(), 'ONGOING', 'INSULATION', 1500, 'Korai 47', 2, 'Whole House');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (SYSDATETIME(), 'DONE', 'FRAMES', 2500, 'Skiathou 67', 3, '9 Windows');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (SYSDATETIME(), 'WAITING', 'PLUMBING', 300, 'Korai 47', 4, 'Bathroom');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (SYSDATETIME(), 'ONGOING', 'ELECTRICAL_WORK', 150, 'Venizelou 78', 5, 'Electric Sockets');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES ('2020-11-11', 'DONE', 'ELECTRICAL_WORK', 1000, 'Kavalas 43', 6, 'New sockets & switches for the whole house');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES ('2020-11-11', 'DONE', 'ELECTRICAL_WORK', 1000, 'Kavalas 43', 6, 'New sockets & switches for the whole house');