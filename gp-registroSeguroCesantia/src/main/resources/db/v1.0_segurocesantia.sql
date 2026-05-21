-- Tabla Seguro de Cesantía
CREATE TABLE seguro_cesantia_trabajador (
    id_seguro int AUTO_INCREMENT PRIMARY KEY,
    nombre_seguro VARCHAR(100) NOT NULL,
    porcentaje_cotizacion DECIMAL(5,2) NOT NULL
);

-- Seguro de Cesantía
INSERT INTO seguro_cesantia_trabajador (nombre_seguro, porcentaje_cotizacion) VALUES
    ('Definido', 0.00),
    ('Indefinido', 0.60);

