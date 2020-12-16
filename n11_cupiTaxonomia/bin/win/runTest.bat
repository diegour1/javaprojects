@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n11_cupiTaxonomia
REM Autor: Catalina Rodríguez - 11-abr-2012
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/cupiTaxonomia.jar;test/lib/junit.jar;test/lib/cupiTaxonomiaTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTaxonomia.test.ArbolTaxonomicoTest
	
java -ea -classpath lib/cupiTaxonomia.jar;test/lib/junit.jar;test/lib/cupiTaxonomiaTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTaxonomia.test.TaxonTest
	
java -ea -classpath lib/cupiTaxonomia.jar;test/lib/junit.jar;test/lib/cupiTaxonomiaTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTaxonomia.test.SerVivoTest
cd bin/win