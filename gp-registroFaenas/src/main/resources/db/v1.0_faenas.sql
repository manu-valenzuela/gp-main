CREATE TABLE faenas (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        descripcion VARCHAR(255),
                        fecha_inicio DATE NOT NULL,
                        fecha_fin DATE,
                        id_direccion INT NOT NULL
);

INSERT INTO faenas (nombre, descripcion, fecha_inicio, fecha_fin, id_direccion) VALUES
    ('Construcción Puente Río Claro', 'Faena vial para conectar sectores rurales', '2026-05-01', '2026-09-30', 1),
    ('Edificio Corporativo GP', 'Construcción de oficinas en Santiago Centro', '2026-04-15', '2027-01-15', 2),
    ('Hospital Regional Sur', 'Faena hospitalaria con pabellones y urgencias', '2026-03-10', '2027-06-30', 3),
    ('Escuela Básica Los Robles', 'Construcción de establecimiento educacional', '2026-05-20', NULL, 4),
    ('Planta de Tratamiento de Agua', 'Infraestructura sanitaria en sector norte', '2026-02-01', '2026-12-31', 5),
    ('Parque Urbano La Esperanza', 'Proyecto de áreas verdes y recreación', '2026-06-01', '2026-11-30', 6),
    ('Ampliación Aeropuerto Regional', 'Faena de ampliación de terminal aéreo', '2026-07-01', '2027-03-31', 7),
    ('Centro Deportivo Municipal', 'Construcción de gimnasio y canchas techadas', '2026-05-10', '2026-12-15', 8);