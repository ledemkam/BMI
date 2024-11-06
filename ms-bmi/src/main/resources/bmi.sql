create  database  BMI;
use BMI;

create table ACCOUNT (
                         id int PRIMARY KEY auto_increment,
                         name varchar(30) ,
                         email varchar(30) ,
                         password varchar(30) ,
                         createdAt datetime default CURRENT_TIMESTAMP
);

create table SUGGESTION (
                            id int PRIMARY KEY auto_increment,
                            label varchar(200) ,
                            description text
);

create table BMI (
                     id int PRIMARY KEY auto_increment,
                     height integer ,
                     weight integer ,
                     createdAt datetime default CURRENT_TIMESTAMP,
                     account_id integer not null,
                     CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES ACCOUNT(id)
);

create table BMI_SUGGESTION (
                                id int PRIMARY KEY auto_increment,
                                bmi_id integer not null,
                                suggestions_id integer not null,
                                CONSTRAINT fk_bmi FOREIGN KEY (bmi_id) REFERENCES BMI(id),
                                CONSTRAINT fk_suggestion FOREIGN KEY (suggestions_id) REFERENCES SUGGESTION(id)
);