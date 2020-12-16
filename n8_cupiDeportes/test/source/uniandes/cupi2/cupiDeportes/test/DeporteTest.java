/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_cupiDeportes
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiDeportes.test;


import uniandes.cupi2.cupiDeportes.mundo.Deporte;
import uniandes.cupi2.cupiDeportes.mundo.Deportista;
import uniandes.cupi2.cupiDeportes.mundo.ElementoExisteException;


import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Clase usada para verificar que los m�todos de la clase Deporte est�n correctamente implementados.
 */
public class DeporteTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Deporte deporte;

    /**
     * Deportista del deporte.
     */
    private Deportista deportista1;

    /**
     * Deprtista del deporte.
     */
    private Deportista deportista2;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo Deporte.
     */
    @Before
    public void setupEscenario1( )
    {
        deporte = new Deporte( "F�tbol", "FCF", 2300, "imagen" );
    }

    /**
     * Construye un nuevo deporte, dos deportistas y se agrega uno.
     */
    private void setupEscenario2( )
    {
        try
        {
            deporte = new Deporte( "F�tbol", "FCF", 2300, "imagen" );
            deportista1 = new Deportista( "James", 23, "Madrid", 39, "imagen2" );
            deportista2 = new Deportista( "Falcao", 29, "Manchester", 35, "imagen3" );
            deporte.agregarDeportistaSobresaliente( deportista1 );
        }
        catch( ElementoExisteException e )
        {
            fail( "No deber�a generar una excepci�n" );
        }
    }

    /**
     * Construye un nuevo deporte, dos deportistas y se agregan ambos.
     */
    private void setupEscenario3( )
    {
        try
        {
            deporte = new Deporte( "F�tbol", "FCF", 2300, "imagen" );
            deportista1 = new Deportista( "James", 23, "Madrid", 39, "imagen2" );
            deportista2 = new Deportista( "Falcao", 29, "Manchester", 35, "imagen3" );
            deporte.agregarDeportistaSobresaliente( deportista1 );
            deporte.agregarDeportistaSobresaliente( deportista2 );
        }
        catch( ElementoExisteException e )
        {
            fail( "No deber�a generar una excepci�n" );
        }
    }

    /**
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
     * constructor darNombre<br>
     * darEnteRegulador<br>
     * darCantidadDeportistasRegistrados<br>
     * darRutaImagen<br>
     * darDeportistasSobresalientes <br>
     * <b> Objetivo: </b> Probar inicializaci�n correcta del objeto Deporte<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Inicializaci�n correcta de Deporte<br>
     */
    @Test
    public void testConstructor( )
    {
        assertEquals( "El nombre del deporte es incorrecto.", "F�tbol", deporte.darNombre( ) );
        assertEquals( "El ente regulador del deporte es incorrecto.", "FCF", deporte.darEnteRegulador( ) );
        assertEquals( "La fecha cantidad de deportistas registrados del deporte es incorrecta.", 2300, deporte.darCantidadDeportistasRegistrados( ) );
        assertEquals( "La ruta de imagen del deporte es incorrecta.", "imagen", deporte.darRutaImagen( ) );
        assertNotNull( "La lista de deportistas es nula.", deporte.darDeportistasSobresalientes( ) );
        assertEquals( "La lista de deportistas no es vac�a.", 0, deporte.darDeportistasSobresalientes( ).size( ) );
    }

    /**
     * Prueba 2: Verifica el m�todo existeDeportistaSobresaliente.<br>
     * <b> M�todos a probar: </b> <br>
     * existeDeportistaSobresaliente. <br>
     * <b> Objetivo: </b> Probar funcionamiento correcto de existeDeportistaSobresaliente<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Resulado obtenido correcto de existeDeportistaSobresaliente<br>
     */
    @Test
    public void testExisteDeportistaSobresaliente( )
    {
        setupEscenario2( );
        assertTrue( "El deportista deber�a existir.", deporte.existeDeportistaSobresaliente( deportista1.darNombre( ) ) );
        assertFalse( "El deportista no deber�a existir.", deporte.existeDeportistaSobresaliente( deportista2.darNombre( ) ) );
    }

    /**
     * Prueba 3: Verifica el m�todo agregarDeportistaSobresaliente.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarDeportistaSobresaliente. <br>
     * existeDeportistaSobresaliente.<br>
     * darDeportistasSobresalientes.<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto de agregarDeportistaSobresaliente<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Agrega correctamente un deportista.<br>
     */
    @Test
    public void testAgregarDeportistaSobresalienteOK( )
    {
    	//TODO Parte 4 punto B: Implemente la prueba

    }

    /**
     * Prueba 4: Verifica el m�todo agregarDeportistaSobresaliente.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarDeportistaSobresaliente.<br>
     * existeDeportistaSobresaliente.<br>
     * darDeportistasSobresalientes.<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto de agregarDeportistaSobresaliente<br>
     * <b> Resultados esperados: </b> <br>
     * 2. No agrega un deportista porque lanza excepci�n.<br>
     */
    @Test
    public void testAgregarDeportistaSobresalienteError( )
    {
    	//TODO Parte 4 punto C: Implemente la prueba
    }

    /**
     * Prueba 5: Verifica el m�todo eliminarDeportistaSobresaliente.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarDeportistaSobresaliente.<br>
     * existeDeportistaSobresaliente.<br>
     * darDeportistasSobresalientes.<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto de eliminarDeportistaSobresaliente<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Elimina correctamente un deportista.<br>
     */
    @Test
    public void testEliminarDeportistaSobresaliente( )
    {
        setupEscenario3( );
        deporte.eliminarDeportistaSobresaliente( "James" );
        assertEquals( "El tama�o de los deportistas deber�a ser 1.", 1, deporte.darDeportistasSobresalientes( ).size( ) );
        assertFalse( "No deber�a existir el deportista eliminado.", deporte.existeDeportistaSobresaliente( "James" ) );
        deporte.eliminarDeportistaSobresaliente( "Falcao" );
        assertEquals( "El tama�o de los deportistas deber�a ser 0.", 0, deporte.darDeportistasSobresalientes( ).size( ) );
        assertFalse( "No deber�a existir el deportista eliminado.", deporte.existeDeportistaSobresaliente( "Falcao" ) );
    }

    /**
     * Prueba 6: Verifica el m�todo darDeportistaMasTrofeos.<br>
     * <b> M�todos a probar: </b> <br>
     * darDeportistaMasTrofeos.<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto de darDeportistaMasTrofeos<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Cuando no hay deportistas retorna null.<br>
     * 2. Cuando hay un deportista. 3. Cuando hay m�s de un deportista.
     */
    @Test
    public void testDarDeportistaMasTrofeos( )
    {
        // 1
        assertNull( "Deber�a ser nulo.", deporte.darDeportistaMasTrofeos( ) );

        // 2
        setupEscenario2( );
        assertNotNull( "No deber�a ser nulo.", deporte.darDeportistaMasTrofeos( ) );
        assertEquals( "El deportista con m�s trofeos no corresponde.", "James", deporte.darDeportistaMasTrofeos( ).darNombre( ) );

        // 3
        setupEscenario2( );
        assertNotNull( "No deber�a ser nulo.", deporte.darDeportistaMasTrofeos( ) );
        assertEquals( "El deportista con m�s trofeos no corresponde.", "James", deporte.darDeportistaMasTrofeos( ).darNombre( ) );

    }

    /**
     * Prueba 7: Verifica el m�todo darTotalTrofeos.<br>
     * <b> M�todos a probar: </b> <br>
     * darTotalTrofeos.<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto de darTotalTrofeos<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Cuando no hay deportistas retorna 0.<br>
     * 2. Cuando hay un deportista. 3. Cuando hay m�s de un deportista.
     */
    @Test
    public void testDarTotalTrofeos( )
    {
        // 1
        assertEquals( "El n�mero total de trofeos no corresponde.", 0, deporte.darTotalTrofeos( ) );

        // 2
        setupEscenario2( );
        assertEquals( "El n�mero total de trofeos no corresponde.", 39, deporte.darTotalTrofeos( ) );

        // 3
        setupEscenario3( );
        assertEquals( "El n�mero total de trofeos no corresponde.", 74, deporte.darTotalTrofeos( ) );

    }

}