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
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/fabricaDeCarros.jar:test/lib/junit.jar:test/lib/fabricaDeCarrosTest.jar junit.swingui.TestRunner uniandes.cupi2.fabricaDeCarros.test.FabricaDeCarrosTest
		
java -ea -classpath lib/fabricaDeCarros.jar:test/lib/junit.jar:test/lib/fabricaDeCarrosTest.jar junit.swingui.TestRunner uniandes.cupi2.fabricaDeCarros.test.ParteTest
cd bin/mac

stty echo
