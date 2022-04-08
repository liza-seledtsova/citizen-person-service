create table address
(
    id        bigint       not null
        primary key,
    address1  varchar(255) null,
    address2  varchar(255) null,
    post_code varchar(255) null,
    city_id   bigint       not null,
    constraint FKpo044ng5x4gynb291cv24vtea
        foreign key (city_id) references city (id)
);

INSERT INTO citizen.address (id, address1, address2, post_code, city_id) VALUES (1, 'Customs House', '1 Long Street', 'G10 1AA', 1);
INSERT INTO citizen.address (id, address1, address2, post_code, city_id) VALUES (2, '2 Short Street', null, 'SS0 8BB', 2);
INSERT INTO citizen.address (id, address1, address2, post_code, city_id) VALUES (3, '3 Lombard Street', null, 'B23 4CC', 3);
INSERT INTO citizen.address (id, address1, address2, post_code, city_id) VALUES (4, 'Tower House', '4 Clements Lane', 'EC14AA', 4);
INSERT INTO citizen.address (id, address1, address2, post_code, city_id) VALUES (5, '5 Watling Ave', '', 'M10 5DD', 5);
INSERT INTO citizen.address (id, address1, address2, post_code, city_id) VALUES (6, '8 Wrong Rd', null, 'L11 6AA', 6);

