INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123456789, 'John', 'Smith', 'Kapou', 00000001, 'someone@somecompany.com', '123456789', 'DETACHED');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123456788, 'John', 'Smith', 'Kapou', 0000000, 'someone1@somecompany.com', '123456789', 'MAISONETTE');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123456787, 'John', 'Smith', 'Kapou', 0000000, 'someone2@somecompany.com', '123456', 'APARTMENT_BUILDING');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123456786, 'John', 'Smith', 'Kapou', 0000000, 'someone3@somecompany.com', '123456', 'DETACHED');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123456785, 'John', 'Smith', 'Kapou', 0000000, 'someone4@somecompany.com', '123456', 'DETACHED');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123456784, 'John', 'Smith', 'Kapou', 0000000, 'someone5@somecompany.com', '123654', 'DETACHED');
INSERT INTO Users (afm, first_name, last_name, address, phone_number, email, password, house_type) VALUES (123456789, 'John', 'Smith', 'Kapou', 0000000, 'someone6@somecompany.com', '654123', 'DETACHED');

INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (getDate(), 'WAITING', 'PAINTING', 13, 'Κλεμανσώ 25', 1, 'a6s5d1a6s5d1a65sd');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (getDate(), 'ONGOING', 'INSULATION', 15, 'asdasdasd', 2, '123456789');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (getDate(), 'DONE', 'FRAMES', 25, 'asdasdasd', 3, 'asdasdasdasd');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (getDate(), 'WAITING', 'PLUMBING', 3000000000, 'asdasd', 1, 'asdasd');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (getDate(), 'ONGOING', 'ELECTRICAL_WORK', 15, 'asdasd', 2, '123456789');
INSERT INTO Repair ("date", state, repair_type, cost, address, user_id, description) VALUES (getDate(), 'DONE', 'ELECTRICAL_WORK', 25, 'asdasd', 3, 'asdasdasdasd');