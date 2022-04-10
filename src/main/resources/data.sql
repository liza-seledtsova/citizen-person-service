INSERT INTO country (id, country_code)
VALUES (1, 'UK');
INSERT INTO country (id, country_code)
VALUES (2, 'GB');

INSERT INTO state (id, name, country_id)
VALUES (1, 'Glasgow', 1);
INSERT INTO state (id, name, country_id)
VALUES (2, 'Essex', 1);
INSERT INTO state (id, name, country_id)
VALUES (3, 'East Sussex', 2);
INSERT INTO state (id, name, country_id)
VALUES (4, 'Manchester', 1);
INSERT INTO state (id, name, country_id)
VALUES (5, 'W Yorks', 1);
INSERT INTO state (id, name, country_id)
VALUES (6, 'London', 1);

INSERT INTO city (id, name, state_id)
VALUES (1, 'Glasgow', 1);
INSERT INTO city (id, name, state_id)
VALUES (2, 'Southend', 2);
INSERT INTO city (id, name, state_id)
VALUES (3, 'Brighton', 3);
INSERT INTO city (id, name, state_id)
VALUES (4, 'London', 6);
INSERT INTO city (id, name, state_id)
VALUES (5, 'Manchester', 4);
INSERT INTO city (id, name, state_id)
VALUES (6, 'Leeds', 5);

INSERT INTO address (id, address1, address2, post_code, city_id)
VALUES (1, 'Customs House', '1 Long Street', 'G10 1AA', 1);
INSERT INTO address (id, address1, address2, post_code, city_id)
VALUES (2, '2 Short Street', null, 'SS0 8BB', 2);
INSERT INTO address (id, address1, address2, post_code, city_id)
VALUES (3, '3 Lombard Street', null, 'B23 4CC', 3);
INSERT INTO address (id, address1, address2, post_code, city_id)
VALUES (4, 'Tower House', '4 Clements Lane', 'EC14AA', 4);
INSERT INTO address (id, address1, address2, post_code, city_id)
VALUES (5, '5 Watling Ave', '', 'M10 5DD', 5);
INSERT INTO address (id, address1, address2, post_code, city_id)
VALUES (6, '8 Wrong Rd', null, 'L11 6AA', 6);

INSERT INTO person (id, date_of_birth, first_name, gender, surname)
VALUES (1, '1970-01-01', 'Fred', 'M', 'Smith');
INSERT INTO person (id, date_of_birth, first_name, gender, surname)
VALUES (2, '1971-01-02', 'Bob', 'M', 'Long');
INSERT INTO person (id, date_of_birth, first_name, gender, surname)
VALUES (3, '1973-03-03', 'Nancy', 'F', 'Bayliss');
INSERT INTO person (id, date_of_birth, first_name, gender, surname)
VALUES (4, '1974-04-04', 'Alan', 'M', 'Johnson');
INSERT INTO person (id, date_of_birth, first_name, gender, surname)
VALUES (5, '1975-05-05', 'Roger', 'M', 'May');
INSERT INTO person (id, date_of_birth, first_name, gender, surname)
VALUES (6, '1976-06-06', 'Mike', 'M', 'Ward');

INSERT INTO person_address (person_id, address_id)
VALUES (1, 1);
INSERT INTO person_address (person_id, address_id)
VALUES (2, 1);
INSERT INTO person_address (person_id, address_id)
VALUES (3, 2);
