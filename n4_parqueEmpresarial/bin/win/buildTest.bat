@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n3_parqueEmpresarial
REM Autor: Equipo cupi2 2015
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Asegura la creaci�n de los directorios classes y lib en test
REM ---------------------------------------------------------

cd ../../test
mkdir classes
mkdir lib

REM ---------------------------------------------------------
REM Compila las clases del directotio test/source
REM ---------------------------------------------------------

cd source

javac -classpath ../../lib/parqueEmpresarial.jar;../lib/junit.jar -d ../classes/ uniandes/cupi2/parqueEmpresarial/test/*.java

REM ---------------------------------------------------------
REM Crea el archivo jar a partir de los archivos compilados
REM ---------------------------------------------------------

cd ../classes

jar cf ../lib/parqueEmpresarialTest.jar uniandes/* -C ../data .

cd ../../bin

pause