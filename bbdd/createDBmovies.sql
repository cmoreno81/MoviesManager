
drop sequence pid_seq restrict;
create table movies(
    id  INT PRIMARY KEY,
    titulo VARCHAR (80) NOT NULL,
    genero VARCHAR (40) NOT NULL,
    valoracion INT,
    visto BOOLEAN);
create sequence pid_seq as int start with 1 increment by 1 no cycle;