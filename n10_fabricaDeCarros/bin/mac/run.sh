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
# Ejecución del programa
# ---------------------------------------------------------

cd ../..
java -ea -classpath ./lib/fabricaDeCarros.jar uniandes.cupi2.fabricaDeCarros.interfaz.InterfazFabricaDeCarros
cd bin/mac

stty echo
