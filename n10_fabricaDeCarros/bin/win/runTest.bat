@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n10_fabricaDeCarros
REM Autor: Vanessa Pérez Romanello - 05-mar-2012
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/fabricaDeCarros.jar;test/lib/junit.jar;test/lib/fabricaDeCarrosTest.jar junit.swingui.TestRunner uniandes.cupi2.fabricaDeCarros.test.FabricaDeCarrosTest
java -ea -classpath lib/fabricaDeCarros.jar;test/lib/junit.jar;test/lib/fabricaDeCarrosTest.jar junit.swingui.TestRunner uniandes.cupi2.fabricaDeCarros.test.ParteTest
cd bin/win