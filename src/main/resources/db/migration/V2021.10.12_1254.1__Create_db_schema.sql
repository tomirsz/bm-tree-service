CREATE TABLE IF NOT EXISTS trees(
    id serial primary key,
    name varchar(256) not null,
    latin_name varchar(256) not null,
    date timestamp not null,
    user_id text not null
);

CREATE TABLE IF NOT EXISTS irrigations(
    id serial primary key,
    date varchar(256) not null,
    tree_id serial not null,
    user_id text not null
);

ALTER TABLE irrigations
    ADD CONSTRAINT irrigations_tree_fk
        FOREIGN KEY (tree_id) REFERENCES trees (id);

CREATE TABLE IF NOT EXISTS fertilizations(
    id serial primary key,
    name varchar(256) not null,
    date varchar(256) not null,
    tree_id serial not null,
    user_id text not null
);

ALTER TABLE fertilizations
    ADD CONSTRAINT fertilizations_tree_fk
        FOREIGN KEY (tree_id) REFERENCES trees (id);

CREATE TABLE IF NOT EXISTS prunings(
    id serial primary key,
    description varchar(256) not null,
    date varchar(256) not null,
    tree_id serial not null,
    user_id text not null
);

ALTER TABLE prunings
    ADD CONSTRAINT prunings_tree_fk
        FOREIGN KEY (tree_id) REFERENCES trees (id);

CREATE TABLE IF NOT EXISTS repotting(
    id serial primary key,
    description varchar(256) not null,
    date varchar(256) not null,
    tree_id serial not null,
    user_id text not null
);

ALTER TABLE repotting
    ADD CONSTRAINT repotting_tree_fk
        FOREIGN KEY (tree_id) REFERENCES trees (id);

CREATE TABLE IF NOT EXISTS spraying(
    id serial primary key,
    description varchar(256) not null,
    date varchar(256) not null,
    tree_id serial not null,
    user_id text not null
);

ALTER TABLE spraying
    ADD CONSTRAINT spraying_tree_fk
        FOREIGN KEY (tree_id) REFERENCES trees (id);

