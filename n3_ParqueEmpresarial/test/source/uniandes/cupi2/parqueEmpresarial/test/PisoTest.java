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
import uniandes.cupi2.parqueEmpresarial.mundo.Piso;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



/**
 * Clase usada para verificar que los métodos de la clase Piso estén correctamente implementados.
 */
public class PisoTest 
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Piso piso;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo piso con un número de oficinas y tamaño definido.
     */
    @Before
    public void setupEscenario1( )
    {
        piso = new Piso( 10, 1 );
    }

    /**
     * Escenario 2: Construye un nuevo piso con oficinas ocupadas y tamaño definido.
     */
    private void setupEscenario2( )
    {
        piso = new Piso( Piso.CANTIDAD_MAXIMA_OFICINAS, 1 );
        piso.ocuparOficina( "Empresa1", 1, 10 );
        piso.ocuparOficina( "Empresa2", 2, 20 );
    }

    /**
     * Prueba 1: Construye el piso.<br>
     * <b> Métodos a probar: </b> <br>
     * darNumeroOficinas<br>
     * darNumeroPiso<br>
     * darOficina<br>
     * <b> Objetivo: </b> Probar la inicialización del piso.<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente el piso con los parámetros esperados.
     */
    @Test
    public void testPiso( )
    {
        int numeroOficinas = 10;
        assertEquals( "No inicializa correctamente el número de oficinas.", numeroOficinas, piso.darCantidadOficinas( ) );
        assertEquals( "No inicializa correctamente el número del piso.", 1, piso.darNumero( ) );
        for( int i = 0; i < numeroOficinas; i++ )
        {
            assertNotNull( "No inicializa correctamente las oficinas.", piso.darOficinas( )[ i ] );
            assertEquals( "No inicializa correctamente el tamaño de las oficinas.", ( double )Piso.AREA_PISO / numeroOficinas, ( ( Oficina )piso.darOficinas( )[ i ] ).darTamano( ), 0.001 );
        }
        assertEquals( "El tamaño del arreglo de oficinas no concuerda con el número de oficinas.", numeroOficinas, piso.darCantidadOficinas( ) );
    }

    /**
     * Prueba 2: Obtener la cantidad de oficinas ocupadas en el piso.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadOficinasOcupadas<br>
     * <b> Objetivo: </b> Probar que el método darCantidadOficinasOcupadas esté bien implementado.<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se ocupan oficinas y se comprueba que retorne la cantidad de oficinas ocupadas.
     */
    @Test
    public void testDarCantidadOficinasOcupadas( )
    {
        setupEscenario2( );
        assertEquals( "No retorna correctamente el número de oficinas ocupadas.", 2, piso.darCantidadOficinasOcupadas( ) );
    }

    /**
     * Prueba 3: Ocupar una oficina dado los datos de la empresa en un piso específico.<br>
     * <b> Métodos a probar: </b> <br>
     * ocuparOficina<br>
     * darOficinas<br>
     * darEmpresa<br>
     * darNombre<br>
     * <b> Objetivo: </b> Probar que el método ocuparOficina esté bien implementado.<br>
     * <b> Caso de prueba 1: </b> <br>
     * Ocupar las oficinas con diferente datos de empresas.<br>
     * <b> Caso de prueba 2: </br><br>
     * El piso ya está ocupado
     * 
     */
    @Test
    public void testOcuparOficina( )
    {
        for( int i = 0; i < 10; i++ )
        {
            assertTrue( piso.ocuparOficina( "empresa" + i, i, 11 - i ) );
            assertEquals( "No ocupa correctamente la oficina.", "empresa" + i, ( ( Oficina )piso.darOficinas( )[ i ] ).darEmpresa( ).darNombre( ) );
        }

        assertFalse( piso.ocuparOficina( "empresa10", 5, 3 ) );
    }

    /**
     * Prueba 4: Desocupar una oficina dado el nombre de la empresa.<br>
     * <b> Métodos a probar: </b> <br>
     * desocuparOficina<br>
     * darOficinas<br>
     * darEmpresa<br>
     * <b> Objetivo: </b> Probar que el método desocuparOficina esté bien implementado.<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se desocupan las empresas de las oficinas.
     */
    @Test
    public void testDesocuparOficina( )
    {
        setupEscenario2( );
        piso.desocuparOficina( "Empresa1" );
        assertNull( "No desocupa correctamente la oficina.", ( piso.darOficinas( )[ 0 ].darEmpresa( ) ) );
        piso.desocuparOficina( "Empresa2" );
        assertNull( "No desocupa correctamente la oficina.", ( piso.darOficinas( )[ 1 ].darEmpresa( ) ) );
    }

    /**
     * Prueba 5: Buscar oficina dado el nombre de la empresa.<br>
     * <b> Métodos a probar: </b> <br>
     * existeEmpresa<br>
     * <b> Objetivo: </b> Probar que el método existeEmpresa esté bien implementado.<br>
     * <b> Caso de prueba 1: </b> <br>
     * La empresa tiene oficina en el piso. <br>
     * <b> Caso de prueba 2: </b> <br>
     * La empresa no tiene oficina en el piso.
     */
    @Test
    public void testExisteEmpresa( )
    {
        setupEscenario2( );
        assertTrue( "La empresa Empresa1 debería ocupar una oficina en el piso.", piso.existeEmpresa( "Empresa1" ) );
        assertTrue( "La empresa Empresa2 debería ocupar una oficina el piso.", piso.existeEmpresa( "Empresa2" ) );
        piso.desocuparOficina( "Empresa2" );
        assertFalse( "La empresa Empresa2 no tiene oficina ocupada en el piso.", piso.existeEmpresa( "Empresa2" ) );
        piso.desocuparOficina( "Empresa1" );
        assertFalse( "La empresa Empresa1 no tiene oficina ocupada en el piso.", piso.existeEmpresa( "Empresa1" ) );
    }
}
