/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_cupiTrenes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTrenes.test;

import static org.junit.Assert.*;

import org.junit.*;
import uniandes.cupi2.cupiTrenes.mundo.*;

/**
 * Clase usada para verificar la correcta implementaci�n de Vagon.
 */
public class VagonTest
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Vagon vagon;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo vag�n.
     */
    @Before
    public void setupEscenario1( )
    {
        //Vag�n en primera clase.
        vagon = new Vagon( 35, 5, Vagon.CLASES[0], 100 );

    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * Vagon <br>
     * darNumero <br>
     * darCantidadSillasDisponibles <br>
     * darClase <br>
     * darPrecio <br>
     * darSiguiente <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Construye correctamente el vag�n del escenario 1 y a un nuevo vag�n, cada uno de los valores corresponde al esperado.
     */
    @Test
    public void testVagon( )
    {
        assertEquals( "No inicializ� el n�mero del vag�n correctamente.", 35, vagon.darNumero( ) );
        assertEquals( "No inicializ� la cantidad de sillas disponibles correctamente.", 5, vagon.darCantidadSillasDisponibles( ) );
        assertEquals( "No inicializ� la clase del vag�n correctamente.", Vagon.CLASES[0], vagon.darClase( ) );
        assertEquals( "No inicializ� el precio del vag�n correctamente.", 100.0, vagon.darPrecio( ), 0.0 );
        assertNull( "No deber�a tener un vag�n siguiente.", vagon.darSiguiente( ) );
        
        //Vag�n en clase VIP.
        Vagon nuevoVagon = new Vagon( 36, 2, Vagon.CLASES[3], 200 );
        assertEquals( "No inicializ� el n�mero del vag�n correctamente.", 36, nuevoVagon.darNumero( ) );
        assertEquals( "No inicializ� la cantidad de sillas disponibles correctamente.", 2, nuevoVagon.darCantidadSillasDisponibles( ) );
        assertEquals( "No inicializ� la clase del vag�n correctamente.", Vagon.CLASES[3], nuevoVagon.darClase( ) );
        assertEquals( "No inicializ� el precio del vag�n correctamente.", 200.0, nuevoVagon.darPrecio( ), 0.0 );
        assertNull( "No deber�a tener un vag�n siguiente.", vagon.darSiguiente( ) );
    }
    
    /**
     * Prueba 2: Se encarga de verificar el m�todo cambiarSiguiente de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * Vagon <br>
     * cambiarSiguiente <br>
     * darSiguiente <br>
     * darNumero <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Cambia correctamente el siguiente vag�n.
     */
    @Test
    public void testCambiarSiguiente( )
    {
        //Nuevo vag�n en segunda clase.
        Vagon nuevo = new Vagon( 4, 20, Vagon.CLASES[1], 50 );
        vagon.cambiarSiguiente( nuevo );
        assertNotNull( "Deber�a tener un siguiente vag�n.", vagon.darSiguiente( ) );
        assertEquals( "No asoci� correctamente el siguiente vag�n.", 4, vagon.darSiguiente( ).darNumero( ) );
    }
    
    /**
     * Prueba 3: Se encarga de verificar el m�todo venderPasaje de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * venderTiquete <br>
     * darCantidadSillasDisponibles <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Vende correctamente todas los tiquetes disponibles en el vag�n. <br>
     * 2. No hay sillas disponibles y no se vende el tiquetes.
     */
    @Test
    public void testVenderTiquete( )
    {
        // Caso de prueba 1.
        assertTrue( "Deber�a poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 4, vagon.darCantidadSillasDisponibles( ) );
        assertTrue( "Deber�a poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 3, vagon.darCantidadSillasDisponibles( ) );
        assertTrue( "Deber�a poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 2, vagon.darCantidadSillasDisponibles( ) );
        assertTrue( "Deber�a poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 1, vagon.darCantidadSillasDisponibles( ) );
        assertTrue( "Deber�a poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 0, vagon.darCantidadSillasDisponibles( ) );     
        
        // Caso de prueba 2.
        assertFalse( "No deber�a vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( "Deber�a haber 0 sillas disponibles.", 0, vagon.darCantidadSillasDisponibles( ) );
    }
}