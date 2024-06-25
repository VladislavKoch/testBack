create table favorite_relation
(
    id      int primary key generated by default as identity,
    user_id int references my_user (id) on DELETE cascade not null,
    film_id int references film (id)    on DELETE cascade not null,
    constraint user_id_film_id_unique unique (user_id, film_id)
);