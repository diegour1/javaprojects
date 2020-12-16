#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n3_parqueEmpresarial
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/parqueEmpresarial.jar:./test/lib/parqueEmpresarialTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.parqueEmpresarial.test.EdificioTest
java -ea -classpath ./lib/parqueEmpresarial.jar:./test/lib/parqueEmpresarialTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.parqueEmpresarial.test.EmpresaTest
java -ea -classpath ./lib/parqueEmpresarial.jar:./test/lib/parqueEmpresarialTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.parqueEmpresarial.test.OficinaTest
java -ea -classpath ./lib/parqueEmpresarial.jar:./test/lib/parqueEmpresarialTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.parqueEmpresarial.test.PisoTest

cd bin/mac

stty echo
