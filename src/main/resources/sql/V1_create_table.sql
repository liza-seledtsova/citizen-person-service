create table country
(
    id           bigint     not null
        primary key,
    country_code varchar(2) null
);

create table person
(
    id            bigint       not null
        primary key,
    date_of_birth date         null,
    first_name    varchar(255) null,
    gender        varchar(1)   null,
    surname       varchar(255) null
);

create table state
(
    id         bigint       not null
        primary key,
    name       varchar(255) null,
    country_id bigint       not null,
    constraint FKghic7mqjt6qb9vq7up7awu0er
        foreign key (country_id) references country (id)
);

create table city
(
    id       bigint       not null
        primary key,
    name     varchar(255) null,
    state_id bigint       not null,
    constraint FK6p2u50v8fg2y0js6djc6xanit
        foreign key (state_id) references state (id)
);

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

create table person_address
(
    person_id  bigint not null,
    address_id bigint not null,
    constraint FKcyc1krsxqelkm4uwh65avij23
        foreign key (address_id) references address (id),
    constraint FKnndfs0btabect8upo03uwgfxt
        foreign key (person_id) references person (id)
);

