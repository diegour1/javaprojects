/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueEmpresarial
 * Autor: Equipo Cupi2 - 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.parqueEmpresarial.test;

import uniandes.cupi2.parqueEmpresarial.mundo.Oficina;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Clase usada para verificar que los métodos de la clase Oficina estén correctamente implementados.
 */
public class OficinaTest 
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Oficina oficina;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva oficina con tamaño definido.
     */
    @Before
    public void setupEscenario1( )
    {
        double tamano1 = ( double )45.6;
        oficina = new Oficina( tamano1, 101 );
    }

    /**
     * Escenario 2: Construye una nueva oficina ocupada con tamaño definido.
     */
    private void setupEscenario2( )
    {
        double tamano1 = ( double )45.6;
        oficina = new Oficina( tamano1, 101 );
        try
        {
            oficina.ocuparOficina( "empresa1", 10 );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción.");
        }

    }

    /**
     * Prueba 1: Construye la oficina. <br>
     * <b> Métodos a probar: </b> <br>
     * darTamano<br>
     * darNumero<br>
     * estaOcupada<br>
     * darEmpresa<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente la oficina con los parámetros esperados. <br>
     */
    @Test
    public void testOficina( )
    {
        assertEquals( "Tamaño de la oficina no inicializado correctamente.", ( double )45.6, oficina.darTamano( ), 0.001 );
        assertEquals( "Número de la oficina no inicializado correctamente.", 101, oficina.darNumero( ) );
        assertFalse( "La oficina debería estar libre.", oficina.estaOcupada( ) );
        assertNull( "La empresa debería ser null.", oficina.darEmpresa( ) );
    }

    /**
     * Prueba 2: Ocupar la oficina.<br>
     * <b> Métodos a probar: </b> <br>
     * ocuparOficina<br>
     * darEmpresa<br>
     * darNombre<br>
     * estaOcupada<br>
     * <b> Caso de prueba 1: </b> <br>
     * La oficina queda ocupada.<br>
     * <b> Caso de prueba 2:<b><br>
     * Se intenta ocupar una oficina ocupada.
     */
    @Test
    public void testOcuparOficina( )
    {
        // Caso de prueba 1
        try
        {
            oficina.ocuparOficina( "empresa1", 10 );
            assertEquals( "No ocupa correctamente la oficina.", "empresa1", oficina.darEmpresa( ).darNombre( ) );
            assertTrue( "La oficina debería estar ocupada.", oficina.estaOcupada( ) );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción.");
        }

        // Caso de prueba 2
        try
        {
            oficina.ocuparOficina( "err1", 10 );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            assertNotNull("No debió modificar la empresa que ocupa la oficina.", oficina.darEmpresa( ));
            assertEquals("No debió modificar la empresa que ocupa la oficina.", "empresa1", oficina.darEmpresa( ).darNombre( ));
        }
    }

    /**
     * Prueba 3: Desocupar la oficina.<br>
     * <b> Métodos a probar: </b> <br>
     * desocuparOficina<br>
     * estaOcupada<br>
     * <b> Caso de prueba 1: </b> <br>
     * Oficina ocupada y luego queda libre.<br>
     * <b> Caso de prueba 2: </b> <br>
     * Oficina desocupada, por ende se encuentra en estado libre. <br>
     * <b> Caso de prueba 3: </b><br>
     * Itenta desocupar una oficina con empleados adentro.
     */
    @Test
    public void testDesocuparOficina( )
    {
        setupEscenario2( );
        try
        {
            assertTrue( "La oficina debería estar ocupada.", oficina.estaOcupada( ) );
            oficina.desocuparOficina( );
            assertFalse( "La oficina debería estar libre.", oficina.estaOcupada( ) );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción.");
        }

        setupEscenario2( );
        try
        {
            oficina.darEmpresa( ).agregarEmpleado( "empleado1", "1234" );
            oficina.darEmpresa( ).buscarEmpleado( "1234" ).registrarIngreso( );
        }
        catch( Exception e )
        {
            fail("No debería generar excepción. Revise la clase empresa.");
        }
        try
        {
            oficina.desocuparOficina( );
            fail("Debe generar excepción");
        }
        catch( Exception e )
        {
            assertTrue( "La oficina debería estar ocupada.", oficina.estaOcupada( ) );
        }
    }

    /**
     * Prueba 4: Indicar si la oficina está ocupada.<br>
     * <b> Métodos a probar: </b> <br>
     * estaOcupada<br>
     * desocuparOficina<br>
     * <b> Caso de prueba 1: </b> <br>
     * La oficina está ocupada.<br>
     * <b> Caso de prueba 2: </b> <br>
     * La oficina está desocupada.
     */
    @Test
    public void testEstaOcupada( )
    {
        setupEscenario2( );
        try
        {
            assertTrue( "La oficina debería estar ocupada.", oficina.estaOcupada( ) );
            oficina.desocuparOficina( );
            assertFalse( "La oficina debería estar ocupada.", oficina.estaOcupada( ) );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción.");
        }
    }

    /**
     * Prueba 5: Indicar si la oficina está ocupada por la empresa cuyo nombre es dado por parámetro.<br>
     * <b> Métodos a probar: </b> <br>
     * estaOcupadaPor<br>
     * desocuparOficina<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se ingresa el nombre de la empresa para verificación de una correcta ocupación de oficina.
     */
    @Test
    public void testEstaOcupadaPor( )
    {
        setupEscenario2( );
        try
        {
            assertTrue( "No compara correctamente los nombres de las oficinas.", oficina.estaOcupadaPor( "empresa1" ) );
            oficina.desocuparOficina( );
            assertFalse( "No compara correctamente los nombres de las oficinas.", oficina.estaOcupadaPor( "empresa1" ) );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción.");
        }

    }

    /**
     * Prueba 6: Comprueba que se siga el formato establecido del toString <br>
     * <b> Métodos a probar: </b> <br>
     * toString<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se comprueba el formato del toString
     */
    @Test
    public void testToString( )
    {
        setupEscenario1( );
        try
        {
            oficina.ocuparOficina( "Empresa1", 1 );
            assertEquals( "No cumple con el formato.", 101 + " - " + "Empresa1" + " - Empleados:" + 0, oficina.toString( ) );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción.");
        }

    }

    /**
     * Prueba 7: Prueba el método trabajaEnEmpresa <br>
     * <b> Métodos a probar: </b> <br>
     * trabajaEnEmpresa<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se prueba con un empleado que no trabaje en la empresa<br>
     *  <b> Caso de prueba 2: </b> <br>
     * Se prueba con un empleado que trabaje en la empresa.<br>
     *  <b> Caso de prueba 3: </b> <br>
     * Se prueba el llamado cuando la oficina está desocupada.
     */
    @Test
    public void testTrabajaEnEmpresa ()
    {
        setupEscenario2();
        // Caso de prueba 1
        assertFalse("El empleado no trabaja en la empresa",oficina.trabajaEnEmpresa( "1234" ));

        try
        {
            // Caso de prueba 2
            oficina.darEmpresa( ).agregarEmpleado( "empleado1", "1234" );
            assertTrue("El empleado si trabaja en la empresa",oficina.trabajaEnEmpresa( "1234" ));
            oficina.desocuparOficina( );

            // Caso de prueba 3
            assertFalse("El empleado no trabaja en la empresa",oficina.trabajaEnEmpresa( "1234" ));
        }
        catch( Exception e )
        {
            fail("No debería generar excepción.");
        }

    }

    /**
     * Prueba 8: Prueba el método agregarEmpleado <br>
     * <b> Métodos a probar: </b> <br>
     * agregarEmpleado<br>
     * trabajaEnEmpresa<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se prueba con un empleado que no trabaje en la empresa.<br>
     * <b> Caso de prueba 2: </b> <br>
     * Se intenta agregar un empleado cuando no hay espacio suficiente.
     * <b> Caso de prueba 3: </b> <br>
     * Se prueba con un empleado que ya trabaje en la empresa.<br>
     */
    @Test
    public void testAgregarEmpleado ()
    {
        setupEscenario2( );
        // Caso de prueba 1
        for(int i=0;i<5;i++){
            try
            {
                oficina.agregarEmpleado( "empleado"+i, "100"+i );
                assertTrue("No se agregó correctamente el empleado.", oficina.trabajaEnEmpresa( "100"+i ));
            }
            catch( Exception e )
            {
                fail("No debe generar excepción.");
            }
        }

        // Caso de prueba 2
        try
        {
            oficina.agregarEmpleado( "empleado5", "1005" );
            fail("Debe generar excepción");
        }
        catch( Exception e )
        {
            //Debe generar excepción
        }

        //Caso de prueba 3
        try
        {
            oficina.eliminarEmpleado( "1004" );
            oficina.agregarEmpleado( "err3", "1003" );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            // Debe generar excepción
        }
    }

    /**
     * Prueba 9: Prueba el método eliminarEmpleado <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarEmpleado<br>
     * trabajaEnEmpresa<br>
     * <b> Caso de prueba 1: </b> <br>
     * El empleado no trabaja en la empresa.<br>
     * <b> Caso de prueba 2: </b> <br>
     * El empleado está adentro del edificio.
     * <b> Caso de prueba 3: </b> <br>
     * El empleado trabaja en la empresa y está afuera del edificio.<br>
     */
    @Test
    public void testEliminarEmpleado ()
    {
        setupEscenario2( );
        //Caso de prueba 1
        try
        {
            oficina.eliminarEmpleado( "1234" );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            // Debe generar excepción
        }

        // Caso de prueba 2
        try
        {
            oficina.darEmpresa( ).agregarEmpleado( "empleado1", "1234" );
            oficina.darEmpresa( ).buscarEmpleado( "1234" ).registrarIngreso( );
        }
        catch( Exception e )
        {
            fail("No debería generar excepción. Revise la clase empresa.");
        }
        try
        {
            oficina.eliminarEmpleado( "1234" );
            fail("Debería generar excepción.");
        }
        catch( Exception e )
        {
            assertTrue("No debió eliminar el empleado.", oficina.trabajaEnEmpresa( "1234" ));
        }

        // Caso de prueba 3
        try
        {
            oficina.darEmpresa( ).buscarEmpleado( "1234" ).registrarSalida( );
        }
        catch( Exception e )
        {
            fail("No debería generar excepción. Revise la clase empresa.");
        }
        try
        {
            oficina.eliminarEmpleado( "1234" );
            assertFalse("Debió eliminar el empleado.", oficina.trabajaEnEmpresa( "1234" ));
        }
        catch( Exception e )
        {
            fail("No debería generar excepción.");
        }

    }



}
