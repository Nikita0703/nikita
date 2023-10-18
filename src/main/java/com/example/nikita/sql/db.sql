create table names(
         id  int auto_increment not null ,
         name varchar(45),
         primary key (id)
)

create table car_for_empl(
        id int auto_increment not null,
        model varchar(45),
        made int,
        primary key(id)
        )

create table house_for_empl(
        id int auto_increment not null,
        street varchar(45),
        flour int,
        flat int,
        primary key(id)
)

create table employee_full(
            id integer auto_increment not null,
            name varchar(30),
            surname varchar(45),
            salary int,
            department varchar(30),
            house_id int,
            car_id int,
            foreign key(name_id) references names(id),
            foreign key(car_id) references car_for_empl(id),
            foreign key(house_id) references house_for_empl(id),
            primary key(id)
)

create table pets_for_empl(
             id int auto_increment not null,
             vid varchar(30),
             name varchar(30),
             employee_id int,
             foreign key (employee_id) references employee_full(id),
             primary key(id)
)

create table projects_for_empl(
             id integer auto_increment not null,
             title varchar(30),
             year varchar(30),
             primary key(id)
)

create table emps_projects(
            id integer auto_increment not null,
            employee_id integer,
            project_id integer,
            foreign key(employee_id) references employee_full(id),
            foreign key(project_id) references projects_for_empl(id),
             primary key(id)
)