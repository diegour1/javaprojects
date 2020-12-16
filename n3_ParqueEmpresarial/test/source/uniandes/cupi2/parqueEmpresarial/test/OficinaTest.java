/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_parqueEmpresarial
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
        oficina.ocuparOficina( "empresa1", 10, 100 );

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
     * La oficina queda ocupada.
     */
    @Test
    public void testOcuparOficina( )
    {
        oficina.ocuparOficina( "empresa1", 10, 100 );
        assertEquals( "No ocupa correctamente la oficina.", "empresa1", oficina.darEmpresa( ).darNombre( ) );
        assertTrue( "La oficina debería estar ocupada.", oficina.estaOcupada( ) );

    }

    /**
     * Prueba 3: Desocupar la oficina.<br>
     * <b> Métodos a probar: </b> <br>
     * desocuparOficina<br>
     * estaOcupada<br>
     * <b> Caso de prueba 1: </b> <br>
     * Oficina ocupada y luego queda libre.<br>
     * <b> Caso de prueba 2: </b> <br>
     * Oficina desocupada, por ende se encuentra en estado libre.
     */
    @Test
    public void testDesocuparOficina( )
    {
        setupEscenario2( );
        assertTrue( "La oficina debería estar ocupada.", oficina.estaOcupada( ) );
        oficina.desocuparOficina( );
        oficina.desocuparOficina( );
        assertFalse( "La oficina debería estar libre.", oficina.estaOcupada( ) );
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
        assertTrue( "La oficina debería estar ocupada.", oficina.estaOcupada( ) );
        oficina.desocuparOficina( );
        assertFalse( "La oficina debería estar ocupada.", oficina.estaOcupada( ) );
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
        assertTrue( "No compara correctamente los nombres de las oficinas.", oficina.estaOcupadaPor( "empresa1" ) );
        oficina.desocuparOficina( );
        assertFalse( "No compara correctamente los nombres de las oficinas.", oficina.estaOcupadaPor( "empresa1" ) );

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
        oficina.ocuparOficina( "Empresa1", 1, 10 );
        assertEquals( "No cumple con el formato.", 101 + " - " + "Empresa1" + " - Empleados:" + 10, oficina.toString( ) );

    }

}
