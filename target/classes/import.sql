-- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
-- IN THIS FILE WE CAN WRITE AN SQL SCRIPT CONTAINING:
-- SCHEMA, TABLE AND DATA MANIPULATION QUERIES
-- TO BE EXECUTED AUTOMATICALLY DURING THE INITIALIZATION OF THE APPLICATION
-- AND AFTER THE CREATION OF SCHEMA AND TABLES BY Hibernate
-- IF spring.jpa.hibernate.ddl-auto IS SET TO create OR create-drop
-- IT IS A Hibernate feature (nothing to do with Spring)

-- INSERT INTO USER (id, firstname, lastname, email, username, password, role) VALUES ('123', 'John', 'Doe', 'john@mail.com', 'johnD', 'pass1234', 'ROLE_USER');
-- INSERT INTO USER (id, firstname, lastname, email, username, password, role) VALUES ('124', 'Jane', 'Doe', 'jane@mail.com', 'janeD', 'pass1234', 'ROLE_ADMIN');

INSERT INTO AUTHOR (firstname, lastname) VALUES ('Leo', 'Tolstoy');
INSERT INTO AUTHOR (firstname, lastname) VALUES ('John', 'Steinbeck');
INSERT INTO AUTHOR (firstname, lastname) VALUES ('Alexandros', 'Papadiamantis');
INSERT INTO AUTHOR (firstname, lastname) VALUES ('Nikos', 'Kazantzakis');
INSERT INTO AUTHOR (firstname, lastname) VALUES ('Angelos', 'Terzakis');

INSERT INTO BOOK (book_title, publication_year, author_id, book_category) VALUES ('War and Peace', '1867', '1', 'LITERARY_REALISM');
INSERT INTO BOOK (book_title, publication_year, author_id, book_category) VALUES ('The Grapes of Wrath', '1939', '2', 'DRAMA');
INSERT INTO BOOK (book_title, publication_year, author_id, book_category) VALUES ('The Murderess', '1903', '3', 'DRAMA');
INSERT INTO BOOK (book_title, publication_year, author_id, book_category) VALUES ('Captain Michalis', '1950', '4', 'DRAMA');
INSERT INTO BOOK (book_title, publication_year, author_id, book_category) VALUES ('Report to Greco', '1965', '4', 'DRAMA');
INSERT INTO BOOK (book_title, publication_year, author_id, book_category) VALUES ('The Last Temptation', '1960', '4', 'DRAMA');
INSERT INTO BOOK (book_title, publication_year, author_id, book_category) VALUES ('Christ Recrucified', '1954', '4', 'DRAMA');
INSERT INTO BOOK (book_title, publication_year, author_id, book_category) VALUES ('Princess Isambo', '1945', '5', 'DRAMA');

-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('fbe25e54-645f-4ede-829b-d28f3a29b2dc','War and Peace','1867','1','LITERARY_REALISM');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('a6fe1574-04de-44d6-ae2c-9f43fc2f42f1','The Grapes of Wrath','1939','2','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('2cfc4209-c32e-4a76-8b38-36b8ce5b3ef5','The Murderess','1903','3','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('534d9f04-1c29-4b68-91a1-902b75c982b4','Captain Michalis','1950','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('d7e7b6ed-fdae-424e-abc5-1718d82b64b8','Report to Greco','1965','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('23b20325-fc09-43c0-b69b-64c47f73988d','The Last Temptation','1960','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('6d002b7e-f985-477b-8320-b71ad7d7713a','Christ Recrucified','1954','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('ba1ba1f3-bbdc-46a5-b279-3a013a4f5ec7','Princess Isambo','1945','5','DRAMA');