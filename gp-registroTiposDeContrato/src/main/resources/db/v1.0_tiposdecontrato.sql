CREATE TABLE tipos_contrato (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                nombre VARCHAR(50) NOT NULL
);

-- Datos iniciales
INSERT INTO tipos_contrato (nombre) VALUES ('Indefinido');
INSERT INTO tipos_contrato (nombre) VALUES ('Plazo fijo');