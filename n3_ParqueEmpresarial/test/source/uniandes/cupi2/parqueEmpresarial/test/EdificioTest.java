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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.parqueEmpresarial.mundo.Edificio;
import uniandes.cupi2.parqueEmpresarial.mundo.Piso;

/**
 * Clase usada para verificar que los métodos de la clase Edificio estén correctamente implementados.
 */
public class EdificioTest 
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Edificio edificio;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Edificio vacío.
     */
    @Before
    public void setupEscenario1( )
    {
        edificio = new Edificio( );
    }

    /**
     * Escenario 2: Construye un nuevo Edificio con un piso y dos oficinas ocupadas.
     */
    private void setupEscenario2( )
    {
        edificio = new Edificio( );
        edificio.agregarPiso( 2 );
        edificio.ocuparOficinaEnPiso( 1, "empresa1", 1, 10 );
        edificio.ocuparOficinaEnPiso( 1, "empresa2", 2, 20 );

    }

    /**
     * Escenario 3: Construye un nuevo Edificio con dos pisos y dos oficinas ocupadas.
     */
    private void setupEscenario3( )
    {
        edificio = new Edificio( );
        edificio.agregarPiso( 2 );
        edificio.agregarPiso( 2 );
        edificio.ocuparOficinaEnPiso( 1, "empresa1", 1, 30 );
        edificio.ocuparOficinaEnPiso( 2, "empresa2", 2, 20 );

    }

    /**
     * Prueba 1: Construye el edificio. <br>
     * <b> Métodos a probar: </b> <br>
     * darPisos<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente el Edificio con los parámetros esperados.<br>
     */
    @Test
    public void testEdificio( )
    {
        assertNotNull( "No se inicializan correctamente los pisos de edificio.", edificio.darPisos( ) );
    }

    /**
     * Prueba 2: Verifica que retorne correctamente las oficinas ocupadas.<br>
     * <b> Métodos a probar: </b> <br>
     * darOficinasOcupadas<br>
     * <b> Objetivo: </b> Probar que el método darOficinasOcupadas esté bien implementado.<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se ocupan dos oficinas.
     */
    @Test
    public void testDarOficinasOcupadas( )
    {
        setupEscenario2( );
        assertEquals( "No se ocuparon correctamente las oficinas.", 2, edificio.darOficinasOcupadas( ).size( ) );
    }
    /**
     * Prueba 3: Obtener el porcentaje de ocupación del edificio.<br>
     * <b> Métodos a probar: </b> <br>
     * darPorcentajeOcupacion<br>
     * desocuparOficina<br>
     * <b> Caso de prueba 1: </b> <br>
     * El edificio tiene oficinas ocupadas. <br>
     * <b> Caso de prueba 2: </b> <br>
     * El edificio no tiene pisos.
     */
    @Test
    public void testDarPorcentajeOcupacion( )
    {
        setupEscenario2( );
        assertEquals( "No se calcula correctamente el porcentaja con oficinas ocupadas.", ( double )100.0, edificio.darPorcentajeOcupacion( ), 0.001 );
        edificio.desocuparOficina( "empresa1" );
        assertEquals( "No se calcula correctamente el porcentaja con oficinas ocupadas.", ( double )50.0, edificio.darPorcentajeOcupacion( ), 0.001 );
        edificio.desocuparOficina( "empresa2" );
        assertEquals( "No se calcula correctamente el porcentaja con oficinas ocupadas.", ( double )0.0, edificio.darPorcentajeOcupacion( ), 0.001 );

    }

    /**
     * Prueba 4: Agregar un piso al edificio.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarPiso<br>
     * darPisos<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se agrega un piso correctamente
     */
    @Test
    public void testAgregarPiso( )
    {

        edificio.agregarPiso( 5 );
        assertEquals( "El tamaño del arreglo no aumentó como esperado.", 1, edificio.darPisos( ).size( ) );
        assertEquals( "No se agregó el piso con el número de oficinas esperado.", 5, ( ( Piso )edificio.darPisos( ).get( 0 ) ).darCantidadOficinas( ) );

        edificio.agregarPiso( 10 );
        assertEquals( "El tamaño del arreglo no aumentó como esperado.", 2, edificio.darPisos( ).size( ) );
        assertEquals( "No se agregó el piso con el número de oficinas esperado.", 10, ( ( Piso )edificio.darPisos( ).get( 1 ) ).darCantidadOficinas( ) );

    }

    /**
     * Prueba 5. Prueba el método ocuparOficinaEnPiso.<br>
     * <b> Métodos a probar: </b> <br>
     * ocuparOficinaEnPiso<br>
     * agregarPiso<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se ocupa la oficina correctamente.<br>
     * <b> Caso de prueba 2: </b> <br>
     * Todas las oficinas están ocupadas.<br>
     */
    @Test
    public void testOcuparOficinaEnPiso( )
    {
        edificio.agregarPiso( 1 );
        assertTrue( "Se debería haber agregado la oficina exitosamente.", edificio.ocuparOficinaEnPiso( 1, "empresa1", 1, 10 ) );
        assertFalse( "No se debería poder agregar la oficina exitosamente.", edificio.ocuparOficinaEnPiso( 1, "empresa2", 2, 20 ) );
    }

    /**
     * Prueba 6: Prueba el método buscarPisoOficina.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarPisoOficina<br>
     * agregarPiso<br>
     * desocuparOficina<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se busca oficina no existente. <br>
     * <b> Caso de prueba 2: </b> <br>
     * Se busca oficina existente.
     */
    @Test
    public void testBuscarPisoOficina( )
    {
        setupEscenario2( );
        edificio.agregarPiso( 2 );
        assertEquals( "No hace la correcta búsqueda de una oficina.", 1, edificio.buscarPisoOficina( "empresa1" ).darNumero( ) );
        edificio.desocuparOficina( "empresa1" );
        assertNull( "No se hace el correcto control de oficina no existente.", edificio.buscarPisoOficina( "empresa1" ) );
    }

    /**
     * Prueba 7: Desocupar una oficina dado un nombre.<br>
     * <b> Métodos a probar: </b> <br>
     * desocuparOficina<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se desocupa una oficina no existente.<br>
     * <b> Caso de prueba 2: </b> <br>
     * Se desocupa una oficina existente.
     */
    @Test
    public void testDesocuparOficina( )
    {
        setupEscenario2( );
        assertTrue( "No desocupa correctamente la oficina.", edificio.desocuparOficina( "empresa1" ) );
        assertFalse( "No se hace el correcto control de oficina no existente.", edificio.desocuparOficina( "empresa1" ) );
        assertTrue( "No desocupa correctamente la oficina.", edificio.desocuparOficina( "empresa2" ) );
        assertFalse( "No se hace el correcto control de oficina no existente.", edificio.desocuparOficina( "empresa1" ) );

    }

    /**
     * Prueba 8: Buscar piso con mayor de empleados.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarPisoConMayorNumeroDeEmpleados<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se busca el piso con mayor número de empleados.
     */
    @Test
    public void testBuscarPisoConMayorNumeroDeEmpleados( )
    {
        setupEscenario3( );
        assertEquals( "No obtiene el piso con más empleados.", 1, edificio.buscarPisoConMayorNumeroDeEmpleados( ).darNumero( ) );

    }

}