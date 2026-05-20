CREATE TABLE regiones (
                          id_region INT PRIMARY KEY,
                          nombre_region VARCHAR(40) NOT NULL
);

CREATE TABLE comunas (
                         id_comuna INT PRIMARY KEY AUTO_INCREMENT,
                         nombre_comuna VARCHAR(20) NOT NULL,
                         id_region INT NOT NULL,
                         FOREIGN KEY (id_region) REFERENCES regiones(id_region)
);

CREATE TABLE direcciones (
                             id_direccion INT PRIMARY KEY AUTO_INCREMENT,
                             calle VARCHAR(100) NOT NULL,
                             numero INT NOT NULL,
                             id_comuna INT NOT NULL,
                             FOREIGN KEY (id_comuna) REFERENCES comunas(id_comuna),
);

--DATOS

-- Regiones
INSERT INTO regiones (id_region, nombre_region) VALUES
    (13, 'Metropolitana'),
    (5,'Valparaíso'),
    (8,'Biobío'),
    (9,'Araucanía'),
    (10,'Los Lagos'),
    (3,'Atacama'),
    (4,'Coquimbo'),
    (7,'Maule'),
    (16,'Ñuble'),
    (2,'Antofagasta');

-- Comunas
INSERT INTO comunas (nombre_comuna, id_region) VALUES
    ('Puente Alto', 13),
    ('Providencia', 13),
    ('Viña del Mar', 5),
    ('Concepción', 8),
    ('Temuco', 9),
    ('Puerto Montt', 10),
    ('Copiapó', 3),
    ('La Serena', 4),
    ('Talca', 7),
    ('Chillán', 16);

-- Direcciones (ejemplo con referencias a comunas y regiones)
INSERT INTO direcciones (calle, numero, id_comuna) VALUES
    ('Av. Concha y Toro', 1234, 1),
    ('Av. Nueva Providencia', 456, 2),
    ('Av. Libertad', 789, 3),
    ('Calle O’Higgins', 101, 4),
    ('Av. Alemania', 202, 5),
    ('Calle Los Robles', 303, 6),
    ('Av. Copayapu', 404, 7),
    ('Av. Francisco de Aguirre', 505, 8),
    ('Calle 1 Sur', 606, 9),
    ('Av. Libertad', 707, 10);
