drop table pizza;

create table pizza(
    id INTEGER primary key autoincrement,
    name varchar,
    beschreibung varchar
);

insert into pizza (name, beschreibung) VALUES ("Salami", "einfach nur Salami");
insert into pizza (name, beschreibung) VALUES ("Spezial", "Mit Pilzen, Käse, Tomaten, Zwiebel und Steak ");
insert into pizza (name, beschreibung) VALUES ("Peperoni", "Mit Peperoni, Pilzen, Käse, Tomaten, Zwiebel und Steak ");


select * from pizza;