@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n8_cupiDeportes
REM Autor: Equipo Cupi2 2015
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Asegura la creación del directorio docs/api
REM ---------------------------------------------------------

cd ../../docs
mkdir api
cd ../bin

REM ---------------------------------------------------------
REM Genera la documentación
REM ---------------------------------------------------------

javadoc -sourcepath ../source -d ../docs/api -subpackages uniandes.cupi2.cupiDeportes

pause