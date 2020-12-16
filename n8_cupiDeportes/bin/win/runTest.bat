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
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd../..
java -classpath ./lib/cupiDeportes.jar;./test/lib/cupiDeportesTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiDeportes.test.DeportistaTest
java -classpath ./lib/cupiDeportes.jar;./test/lib/cupiDeportesTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiDeportes.test.DeporteTest
java -classpath ./lib/cupiDeportes.jar;./test/lib/cupiDeportesTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiDeportes.test.CupiDeportesTest

pause