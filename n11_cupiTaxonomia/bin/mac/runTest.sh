#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n11_cupiTaxonomia
# Autor: Catalina Rodríguez - 11-abr-2012
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/cupiTaxonomia.jar:test/lib/junit.jar:test/lib/cupiTaxonomiaTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTaxonomia.test.ArbolTaxonomicoTest
	
java -ea -classpath lib/cupiTaxonomia.jar:test/lib/junit.jar:test/lib/cupiTaxonomiaTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTaxonomia.test.TaxonTest
	
java -ea -classpath lib/cupiTaxonomia.jar:test/lib/junit.jar:test/lib/cupiTaxonomiaTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTaxonomia.test.SerVivoTest
cd bin/mac

stty echo
