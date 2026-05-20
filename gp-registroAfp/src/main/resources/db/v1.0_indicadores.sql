-- Tabla AFP
CREATE TABLE afp (
    id_afp int AUTO_INCREMENT PRIMARY KEY,
    nombre_afp VARCHAR(100) NOT NULL,
    porcentaje_cotizacion DECIMAL(5,2) NOT NULL
);

-- Tabla Isapre
CREATE TABLE isapre (
    id_isapre int AUTO_INCREMENT PRIMARY KEY,
    nombre_isapre VARCHAR(100) NOT NULL,
    porcentaje_cotizacion DECIMAL(5,2) NOT NULL
);

-- Tabla Seguro de Cesantía
CREATE TABLE seguro_cesantia_trabajador (
    id_seguro int AUTO_INCREMENT PRIMARY KEY,
    nombre_seguro VARCHAR(100) NOT NULL,
    porcentaje_cotizacion DECIMAL(5,2) NOT NULL
);


-- AFPs
INSERT INTO afp (nombre_afp, porcentaje_cotizacion) VALUES
    ('AFP Habitat', 11.27),
    ('AFP Provida', 11.45),
    ('AFP Capital', 11.44),
    ('AFP Cuprum', 11.48),
    ('AFP Modelo', 10.58);

-- Isapres (ejemplo con valores referenciales)
INSERT INTO isapre (nombre_isapre, porcentaje_cotizacion) VALUES
    ('FONASA', 7.00),
    ('Isapre Banmédica', 7.00),
    ('Isapre Colmena', 7.00),
    ('Isapre Cruz Blanca', 7.00),
    ('Isapre Consalud', 7.00),
    ('Isapre Nueva Masvida', 7.00);

-- Seguro de Cesantía
INSERT INTO seguro_cesantia_trabajador (nombre_seguro, porcentaje_cotizacion) VALUES
    ('Definido', 0.00),
    ('Indefinido', 0.60);

