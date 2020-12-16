#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n10_fabricaDeCarros
# Autor: Vanessa Pérez Romanello - 05-mar-2012
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Asegura la creación de los directorios classes y lib en test
# ---------------------------------------------------------

cd ../../test/
mkdir classes
mkdir lib

# ---------------------------------------------------------
# Compila las clases del directotio test/source
# ---------------------------------------------------------

cd source
javac -encoding ISO-8859-1 -source 1.5 -classpath ../../lib/fabricaDeCarros.jar:../lib/junit.jar -d ../classes/ uniandes/cupi2/fabricaDeCarros/test/*.java

# ---------------------------------------------------------
# Crea el archivo jar a partir de los archivos compilados
# ---------------------------------------------------------

cd ../classes

jar cf ../lib/fabricaDeCarrosTest.jar uniandes/* -C ../data .

cd ../../bin/mac

stty echo