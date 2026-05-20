CREATE TABLE faenas (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        descripcion VARCHAR(255),
                        fecha_inicio DATE NOT NULL,
                        fecha_fin DATE,
                        id_direccion INT NOT NULL
);