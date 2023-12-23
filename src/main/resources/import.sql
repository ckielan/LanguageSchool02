-- Wstawianie danych do tabeli
INSERT INTO role (id, name,name_shortcut) VALUES (1, 'ROLE_ADMIN','Admin');
INSERT INTO role (id, name,name_shortcut) VALUES (2, 'ROLE_STUDENT','Uczeń');
INSERT INTO role (id, name,name_shortcut) VALUES (3, 'ROLE_PARENT','Rodzic');
INSERT INTO role (id, name,name_shortcut) VALUES (4, 'ROLE_TEACHER','Nauczyciel');
INSERT INTO role (id, name,name_shortcut) VALUES (5, 'ROLE_MANAGER','Manager');

INSERT INTO studentgroup (id, name,description) VALUES (1, 'Grupa 1','Grupa do 8 lat');
INSERT INTO studentgroup (id, name,description) VALUES (2, 'Grupa 2','Grupa do 8 lat');
INSERT INTO studentgroup (id, name,description) VALUES (3, 'Grupa 3','Grupa do 10 lat zaawansowani');

# insert into user (id,username,password,enabled) values (1,'admin','admin',1);

insert into teacher (id,firstName,lastName) values (1,'Magdalena', 'Magdalena');
insert into teacher (id,firstName,lastName) values (2,'Vanessa', 'Vanessa');

# CREATE TRIGGER creation_time BEFORE INSERT
#     ON language_school.user FOR EACH ROW BEGIN SET NEW.date_created = NOW();end;
# CREATE TRIGGER modification_time BEFORE update
#     ON language_school.user FOR EACH ROW BEGIN SET NEW.date_modified = NOW();end;

