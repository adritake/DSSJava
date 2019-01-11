# DSSJava
Repositorio para la parte del servidor de la última práctica de DSS.

La parte de Android se encuentra en el siguiente [repositorio](https://github.com/samahetfield/DSSAndroid)

## Información del proyecto

La parte del sevidor es un proyecto en Java con Maven desarrollado en Eclispe Jee Version: 2018-09 (4.9). 
Se han usado las siguientes dependencias:
- jerser-server 1.9
- jersey-json 1.9
- jersey-client 1.9
- gson 2.8.0
Se ha usado como server Tomcat v9.0. Para la base de datos se ha usado MySQL con PHPMyAdmin alojada en
un servidor Apacche todo ello controlado por XAMPP Control Panel v3.2.2.

La base de datos se puede inicializar con el archivo que se encuentra en DSSJava/DB/consorcio.sql

Para ejecutar el proyecto hay que introducirlo en Tomcat y acceder a las distintas páginas web que se
encuentran en WebContent como por ejemplo http://localhost:8080/DSSJava/productos.jsp

