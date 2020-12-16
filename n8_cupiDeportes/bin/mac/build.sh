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
# Asegura la creación de los directorios classes y lib
# ---------------------------------------------------------

cd ../..
mkdir classes
mkdir lib

# ---------------------------------------------------------
# Compila las clases del directorio source
# ---------------------------------------------------------

cd source
javac -nowarn -classpath  -d ../classes/ uniandes/cupi2/cupiDeportes/mundo/*.java
javac -nowarn -classpath  -d ../classes/ uniandes/cupi2/cupiDeportes/interfaz/*.java

# ---------------------------------------------------------
# Crea el archivo jar a partir de los archivos compilados
# ---------------------------------------------------------

cd ../classes
jar cf ../lib/cupiDeportes.jar uniandes/*

cd ../bin/mac

stty echo