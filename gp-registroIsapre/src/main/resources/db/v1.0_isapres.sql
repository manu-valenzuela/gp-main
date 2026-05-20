-- Tabla AFP
CREATE TABLE isapre (
    id_isapre int AUTO_INCREMENT PRIMARY KEY,
    nombre_isapre VARCHAR(100) NOT NULL,
    porcentaje_cotizacion DECIMAL(5,2) NOT NULL
);

-- Isapres (ejemplo con valores referenciales)
INSERT INTO isapre (nombre_isapre, porcentaje_cotizacion) VALUES
    ('FONASA', 7.00),
    ('Isapre Banmédica', 7.00),
    ('Isapre Colmena', 7.00),
    ('Isapre Cruz Blanca', 7.00),
    ('Isapre Consalud', 7.00),
    ('Isapre Nueva Masvida', 7.00);


