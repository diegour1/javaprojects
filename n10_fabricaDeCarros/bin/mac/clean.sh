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
# Borra todos los archivos generados por el build
# ---------------------------------------------------------

cd ../../
rm -rf classes/*
rm -rf lib/fabricaDeCarros.jar

cd bin/mac

stty echo
