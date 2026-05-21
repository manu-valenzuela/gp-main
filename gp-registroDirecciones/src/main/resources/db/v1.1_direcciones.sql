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
    (1, 'Arica y Parinacota'),
    (2, 'Tarapacá'),
    (3, 'Antofagasta'),
    (4, 'Atacama'),
    (5, 'Coquimbo'),
    (6, 'Valparaíso'),
    (7, 'Metropolitana de Santiago'),
    (8, 'O’Higgins'),
    (9, 'Maule'),
    (10, 'Ñuble'),
    (11, 'Biobío'),
    (12, 'Araucanía'),
    (13, 'Los Ríos'),
    (14, 'Los Lagos'),
    (15, 'Aysén'),
    (16, 'Magallanes');

-- Comunas
INSERT INTO comunas (nombre_comuna, id_region) VALUES
('Arica', 1),
('Putre', 1),
('Iquique', 2),
('Pozo Almonte', 2),
('Antofagasta', 3),
('Calama', 3),
('Taltal', 3),
('Copiapó', 4),
('Chañaral', 4),
('Vallenar', 4),
('La Serena', 5),
('Illapel', 5),
('Ovalle', 5),
('Valparaíso', 6),
('San Antonio', 6),
('Quillota', 6),
('Los Andes', 6),
('San Felipe', 6),
('La Ligua', 6),
('Isla de Pascua', 6),
('Santiago', 7),
('Puente Alto', 7),
('San Bernardo', 7),
('Melipilla', 7),
('Talagante', 7),
('Colina', 7),
('Rancagua', 8),
('San Fernando', 8),
('Pichilemu', 8),
('Talca', 9),
('Curicó', 9),
('Linares', 9),
('Cauquenes', 9),
('Chillán', 10),
('Bulnes', 10),
('Quirihue', 10),
('San Carlos', 10),
('Concepción', 11),
('Los Ángeles', 11),
('Lebu', 11),
('Temuco', 12),
('Angol', 12),
('Valdivia', 13),
('La Unión', 13),
('Puerto Montt', 14),
('Castro', 14),
('Osorno', 14),
('Ancud', 14),
('Coyhaique', 15),
('Puerto Aysén', 15),
('Chile Chico', 15),
('Cochrane', 15),
('Punta Arenas', 16),
('Puerto Natales', 16),
('Porvenir', 16),
('Puerto Williams', 16),

-- Direcciones (ejemplo con referencias a comunas y regiones)
INSERT INTO direcciones (calle, numero, id_comuna) VALUES
    ('Av. 18 de Septiembre', 1234, 1),   -- Arica (Región de Arica y Parinacota)
    ('Av. Arturo Prat', 567, 5),         -- Iquique (Región de Tarapacá)
    ('Av. Argentina', 890, 12),          -- Antofagasta (Región de Antofagasta)
    ('Av. Copayapu', 456, 20),           -- Copiapó (Región de Atacama)
    ('Av. Francisco de Aguirre', 789, 29), -- La Serena (Región de Coquimbo)
    ('Av. Pedro Montt', 321, 36),        -- Valparaíso (Región de Valparaíso)
    ('Av. Libertador Bernardo O’Higgins', 1000, 65), -- Santiago (Región Metropolitana)
    ('Av. Miguel Ramírez', 222, 90),     -- Rancagua (Región de O’Higgins)
    ('Av. Alameda', 333, 94),            -- Talca (Región del Maule)
    ('Av. Libertad', 444, 110);          -- Chillán (Región de Ñuble)
