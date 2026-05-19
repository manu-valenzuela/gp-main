CREATE TABLE estado_civil (
    id int not null,
    estado_civil varchar(10) not null,
    primary key (id)
);

CREATE TABLE persona (
                     rut VARCHAR(12) PRIMARY KEY,
                     dv VARCHAR(1) NOT NULL,
                     nombre VARCHAR(50) NOT NULL,
                     apellido VARCHAR(50) NOT NULL,
                     fecha_nacimiento DATE NOT NULL,
                     id_estado_civil int NOT NULL,

                     PRIMARY KEY (rut),
                     FOREIGN KEY (id_estado_civil) references estado_civil(id)
);

INSERT INTO estado_civil (id, estado_civil) values (1,'Soltero/a');
INSERT INTO estado_civil (id, estado_civil) values (2,'Casado/a');
INSERT INTO estado_civil (id, estado_civil) values (3,'Viudo/a');
INSERT INTO estado_civil (id, estado_civil) values (4,'Soltero/a');

INSERT INTO persona (rut, dv, nombre, apellido, fecha_nacimiento, estado_civil) VALUES
    ('12345678', '5','Juan', 'Pérez', '1990-05-12', 'Soltero'),
    ('87654321', '1','María', 'Soto', '1985-11-23', 'Casada'),
    ('11222333', 'K','Pedro', 'González', '1978-02-14', 'Viudo'),
    ('44556677', '4','Ana', 'Ramírez', '1992-07-30', 'Soltera'),
    ('99887766', '7','Luis', 'Torres', '1980-09-05', 'Casado'),
    ('13579135', '3','Carolina', 'Muñoz', '1995-03-18', 'Soltera'),
    ('24682468', '4','José', 'Fernández', '1988-12-01', 'Casado'),
    ('56785678', '5','Claudia', 'Vargas', '1993-06-25', 'Soltera'),
    ('10101010', '9','Ricardo', 'Silva', '1975-04-09', 'Divorciado'),
    ('20202020', '2','Isabel', 'Morales', '1982-08-15', 'Casada');
