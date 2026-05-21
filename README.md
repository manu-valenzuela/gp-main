# gestionPersonal (gp)

**GP** es el backend de un programa desarrollado con microservicios que gestiona el personal de una empresa contratista con múltiples faenas o una empresa comercial con varias sucursales. Como este proyecto es académico, algunas características propias de la contratación en Chile han sido simplificadas.

**MICROSERVICIOS DEL SISTEMA**

Este es el repositorio principal del sistema. Los repositorios que componen parte del sistema son microservicios que operan de forma independiente; ellos son:


gp-registroPersonas  
Administra los datos personales de los trabajadores (RUT, nombre, apellido, fecha de nacimiento, estado civil).

gp-registroDirecciones  
Gestiona las direcciones de los trabajadores, incluyendo comuna y región.

gp-registroFaenas  
Define las faenas o proyectos en los que participan los trabajadores, con fechas de inicio y término.

gp-registroTiposDeContrato  
Contiene los tipos de contrato disponibles (indefinido, plazo fijo).

gp-registroAfp, gp-registroIsapres, gp-registroSeguroCesantia  
Manejan indicadores previsionales (AFP, Isapres, Seguro de Cesantía).

gp-contratosPersonal  
Microservicio agregador: crea contratos de trabajo integrando datos de los otros microservicios.
Tiene un dato propio: salario.


**EJECUCIÓN**

Instrucciones preliminares:

Clonar repositorio:
  git clone https://github.com/manu-valenzuela/gestionPersonal.git
Entrar al microservicio, por ejemplo:
  cd gp-contratosPersonal
Compilar y ejecutar con Maven:
  mvn clean install
  mvn spring-boot:run
Acceder en el puerto configurado, por ejemplo:
  http://localhost:8088/api/contratos



