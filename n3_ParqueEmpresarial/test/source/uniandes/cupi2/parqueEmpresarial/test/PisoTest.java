/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase usada para verificar que los m�todos de la clase Piso est�n correctamente implementados.
 */
public class PisoTest 
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Piso piso;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo piso con un n�mero de oficinas y tama�o definido.
     */
    @Before
    public void setupEscenario1( )
    {
        piso = new Piso( 10, 1 );
    }

    /**
     * Escenario 2: Construye un nuevo piso con oficinas ocupadas y tama�o definido.
     */
    private void setupEscenario2( )
    {
        piso = new Piso( Piso.CANTIDAD_MAXIMA_OFICINAS, 1 );
        piso.ocuparOficina( "Empresa1", 1, 10 );
        piso.ocuparOficina( "Empresa2", 2, 20 );
    }

    /**
     * Prueba 1: Construye el piso.<br>
     * <b> M�todos a probar: </b> <br>
     * darNumeroOficinas<br>
     * darNumeroPiso<br>
     * darOficina<br>
     * <b> Objetivo: </b> Probar la inicializaci�n del piso.<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente el piso con los par�metros esperados.
     */
    @Test
    public void testPiso( )
    {
        int numeroOficinas = 10;
        assertEquals( "No inicializa correctamente el n�mero de oficinas.", numeroOficinas, piso.darCantidadOficinas( ) );
        assertEquals( "No inicializa correctamente el n�mero del piso.", 1, piso.darNumero( ) );
        for( int i = 0; i < numeroOficinas; i++ )
        {
            assertNotNull( "No inicializa correctamente las oficinas.", piso.darOficinas( )[ i ] );
            assertEquals( "No inicializa correctamente el tama�o de las oficinas.", ( double )Piso.AREA_PISO / numeroOficinas, ( ( Oficina )piso.darOficinas( )[ i ] ).darTamano( ), 0.001 );
        }
        assertEquals( "El tama�o del arreglo de oficinas no concuerda con el n�mero de oficinas.", numeroOficinas, piso.darCantidadOficinas( ) );
    }

    /**
     * Prueba 2: Obtener la cantidad de oficinas ocupadas en el piso.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadOficinasOcupadas<br>
     * <b> Objetivo: </b> Probar que el m�todo darCantidadOficinasOcupadas est� bien implementado.<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se ocupan oficinas y se comprueba que retorne la cantidad de oficinas ocupadas.
     */
    @Test
    public void testDarCantidadOficinasOcupadas( )
    {
        setupEscenario2( );
        assertEquals( "No retorna correctamente el n�mero de oficinas ocupadas.", 2, piso.darCantidadOficinasOcupadas( ) );
    }

    /**
     * Prueba 3: Ocupar una oficina dado los datos de la empresa en un piso espec�fico.<br>
     * <b> M�todos a probar: </b> <br>
     * ocuparOficina<br>
     * darOficinas<br>
     * darEmpresa<br>
     * darNombre<br>
     * <b> Objetivo: </b> Probar que el m�todo ocuparOficina est� bien implementado.<br>
     * <b> Caso de prueba 1: </b> <br>
     * Ocupar las oficinas con diferente datos de empresas.<br>
     * <b> Caso de prueba 2: </br><br>
     * El piso ya est� ocupado
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
     * <b> M�todos a probar: </b> <br>
     * desocuparOficina<br>
     * darOficinas<br>
     * darEmpresa<br>
     * <b> Objetivo: </b> Probar que el m�todo desocuparOficina est� bien implementado.<br>
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
     * <b> M�todos a probar: </b> <br>
     * existeEmpresa<br>
     * <b> Objetivo: </b> Probar que el m�todo existeEmpresa est� bien implementado.<br>
     * <b> Caso de prueba 1: </b> <br>
     * La empresa tiene oficina en el piso. <br>
     * <b> Caso de prueba 2: </b> <br>
     * La empresa no tiene oficina en el piso.
     */
    @Test
    public void testExisteEmpresa( )
    {
        setupEscenario2( );
        assertTrue( "La empresa Empresa1 deber�a ocupar una oficina en el piso.", piso.existeEmpresa( "Empresa1" ) );
        assertTrue( "La empresa Empresa2 deber�a ocupar una oficina el piso.", piso.existeEmpresa( "Empresa2" ) );
        piso.desocuparOficina( "Empresa2" );
        assertFalse( "La empresa Empresa2 no tiene oficina ocupada en el piso.", piso.existeEmpresa( "Empresa2" ) );
        piso.desocuparOficina( "Empresa1" );
        assertFalse( "La empresa Empresa1 no tiene oficina ocupada en el piso.", piso.existeEmpresa( "Empresa1" ) );
    }
}
