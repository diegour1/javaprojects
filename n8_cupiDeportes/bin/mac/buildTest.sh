#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n8_cupiDeportes
# Autor: Equipo Cupi2 2015
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Asegura la creación de los directorios classes y lib en test
# ---------------------------------------------------------

cd ../../test
mkdir classes
mkdir lib

# ---------------------------------------------------------
# Compila las clases del directotio test/source
# ---------------------------------------------------------

cd source
javac -nowarn -classpath ../../lib/cupiDeportes.jar:../lib/junit.jar -d ../classes/ uniandes/cupi2/cupiDeportes/test/*.java

# ---------------------------------------------------------
# Crea el archivo jar a partir de los archivos compilados
# ---------------------------------------------------------

cd ../classes

jar cf ../lib/cupiDeportesTest.jar uniandes/* -C ../../data .

cd ../../bin

stty echo