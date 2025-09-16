create table todo_db.todo
(
    done bit          not null,
    id   int          not null
        primary key,
    text varchar(255) null
);

