/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
 * Clase usada para verificar la correcta implementación de Vagon.
 */
public class VagonTest
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Vagon vagon;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo vagón.
     */
    @Before
    public void setupEscenario1( )
    {
        //Vagón en primera clase.
        vagon = new Vagon( 35, 5, Vagon.CLASES[0], 100 );

    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Vagon <br>
     * darNumero <br>
     * darCantidadSillasDisponibles <br>
     * darClase <br>
     * darPrecio <br>
     * darSiguiente <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Construye correctamente el vagón del escenario 1 y a un nuevo vagón, cada uno de los valores corresponde al esperado.
     */
    @Test
    public void testVagon( )
    {
        assertEquals( "No inicializó el número del vagón correctamente.", 35, vagon.darNumero( ) );
        assertEquals( "No inicializó la cantidad de sillas disponibles correctamente.", 5, vagon.darCantidadSillasDisponibles( ) );
        assertEquals( "No inicializó la clase del vagón correctamente.", Vagon.CLASES[0], vagon.darClase( ) );
        assertEquals( "No inicializó el precio del vagón correctamente.", 100.0, vagon.darPrecio( ), 0.0 );
        assertNull( "No debería tener un vagón siguiente.", vagon.darSiguiente( ) );
        
        //Vagón en clase VIP.
        Vagon nuevoVagon = new Vagon( 36, 2, Vagon.CLASES[3], 200 );
        assertEquals( "No inicializó el número del vagón correctamente.", 36, nuevoVagon.darNumero( ) );
        assertEquals( "No inicializó la cantidad de sillas disponibles correctamente.", 2, nuevoVagon.darCantidadSillasDisponibles( ) );
        assertEquals( "No inicializó la clase del vagón correctamente.", Vagon.CLASES[3], nuevoVagon.darClase( ) );
        assertEquals( "No inicializó el precio del vagón correctamente.", 200.0, nuevoVagon.darPrecio( ), 0.0 );
        assertNull( "No debería tener un vagón siguiente.", vagon.darSiguiente( ) );
    }
    
    /**
     * Prueba 2: Se encarga de verificar el método cambiarSiguiente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Vagon <br>
     * cambiarSiguiente <br>
     * darSiguiente <br>
     * darNumero <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Cambia correctamente el siguiente vagón.
     */
    @Test
    public void testCambiarSiguiente( )
    {
        //Nuevo vagón en segunda clase.
        Vagon nuevo = new Vagon( 4, 20, Vagon.CLASES[1], 50 );
        vagon.cambiarSiguiente( nuevo );
        assertNotNull( "Debería tener un siguiente vagón.", vagon.darSiguiente( ) );
        assertEquals( "No asoció correctamente el siguiente vagón.", 4, vagon.darSiguiente( ).darNumero( ) );
    }
    
    /**
     * Prueba 3: Se encarga de verificar el método venderPasaje de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * venderTiquete <br>
     * darCantidadSillasDisponibles <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Vende correctamente todas los tiquetes disponibles en el vagón. <br>
     * 2. No hay sillas disponibles y no se vende el tiquetes.
     */
    @Test
    public void testVenderTiquete( )
    {
        // Caso de prueba 1.
        assertTrue( "Debería poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 4, vagon.darCantidadSillasDisponibles( ) );
        assertTrue( "Debería poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 3, vagon.darCantidadSillasDisponibles( ) );
        assertTrue( "Debería poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 2, vagon.darCantidadSillasDisponibles( ) );
        assertTrue( "Debería poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 1, vagon.darCantidadSillasDisponibles( ) );
        assertTrue( "Debería poder vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( 0, vagon.darCantidadSillasDisponibles( ) );     
        
        // Caso de prueba 2.
        assertFalse( "No debería vender el tiquete.", vagon.venderTiquete( ) );
        assertEquals( "Debería haber 0 sillas disponibles.", 0, vagon.darCantidadSillasDisponibles( ) );
    }
}