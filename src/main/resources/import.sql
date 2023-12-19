-- Wstawianie danych do tabeli
INSERT INTO role (id, name,name_shortcut) VALUES (1, 'ROLE_ADMIN','Admin');
INSERT INTO role (id, name,name_shortcut) VALUES (2, 'ROLE_STUDENT','Uczeń');
INSERT INTO role (id, name,name_shortcut) VALUES (3, 'ROLE_PARENT','Rodzic');
INSERT INTO role (id, name,name_shortcut) VALUES (4, 'ROLE_TEACHER','Nauczyciel');
INSERT INTO role (id, name,name_shortcut) VALUES (5, 'ROLE_MANAGER','Manager');

CREATE TRIGGER creation_time BEFORE INSERT
    ON language_school.user FOR EACH ROW BEGIN SET NEW.date_created = NOW();end;
CREATE TRIGGER modification_time BEFORE update
    ON language_school.user FOR EACH ROW BEGIN SET NEW.date_modified = NOW();end;

