CREATE TABLE contratos (
   id INT AUTO_INCREMENT PRIMARY KEY,
   id_persona INT NOT NULL,
   id_afp INT NOT NULL,
   id_isapre INT NOT NULL,
   id_tipo_contrato INT NOT NULL,
   id_seguro_cesantia INT NOT NULL,
   id_direccion INT NOT NULL,
   id_faena INT NOT NULL,
   salario DECIMAL(12,2) NOT NULL,
   fecha_inicio DATE NOT NULL,
   fecha_fin DATE);
