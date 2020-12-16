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

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.*;
import uniandes.cupi2.cupiTrenes.mundo.*;

/**
 * Clase usada para verificar la correcta implementación de Tren.
 */
public class TrenTest
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Tren tren;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo tren sin vagones.
     */
    @Before
    public void setupEscenario1( )
    {
        tren = new Tren( 35 );

        // Paradas de la ruta.
        Date horario = null;
        for( int i = 0; i < 5; i++ )
        {
            horario = new Date( );
            horario.setHours( i );
            horario.setMinutes( i );
            tren.agregarParada( new Parada( "Ciudad" + i, horario ) );
        }
    }

    /**
     * Escenario 2: Crea un nuevo tren con vagones.
     */
    public void setupEscenario2( )
    {
        setupEscenario1( );
        try
        {
            // Vagón en primera clase.
            tren.agregarVagon( 3, 5, Vagon.CLASES[ 0 ], 300 );
            // Vagón en segunda clase.
            tren.agregarVagon( 5, 30, Vagon.CLASES[ 1 ], 100 );
            // Vagón en clase neogcios.
            tren.agregarVagon( 7, 20, Vagon.CLASES[ 2 ], 150 );
            // Vagón en clase VIP.
            tren.agregarVagon( 9, 10, Vagon.CLASES[ 3 ], 200 );
        }
        catch( ElementoExisteException e )
        {
            fail( "No debería generar error." );
        }
    }

    /**
     * Escenario 3: Crea un nuevo tren con un vagón.
     */
    public void setupEscenario3( )
    {
        setupEscenario1( );
        try
        {
            // Vagón en primera clase.
            tren.agregarVagon( 3, 1, Vagon.CLASES[ 0 ], 300 );
        }
        catch( ElementoExisteException e )
        {
            fail( "No debería generar error." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Tren <br>
     * darId <br>
     * darParadas <br>
     * darPrimerVagon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Crea el Tren correctamente y agrega las paradas descritas en el Escenario 1. No debería tener vagones. <br>
     */
    @Test
    public void testRutaTren( )
    {
        assertEquals( "No inicializó el Id del tren correctamente.", 35, tren.darId( ) );
        assertEquals( "No inicializó la cantidad de paradas correctamente.", 5, tren.darParadas( ).size( ) );
        assertEquals( "No debería tener vagones.", null, tren.darPrimerVagon( ) );

    }

    /**
     * Prueba 2: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Tren <br>
     * agregarParada <br>
     * darId <br>
     * darParadas <br>
     * darSiguiente <br>
     * darAnterior <br>
     * darPrimerVagon <br>
     * darCantidadRecaudada <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Crea el Tren correctamente y agrega las paradas descritas en el Escenario 1. No debería tener vagones. <br>
     */
    @Test
    public void testAgregarParada( )
    {
        try
        {
            assertEquals( "No inicializó el Id del tren correctamente.", 35, tren.darId( ) );

            ArrayList paradas = tren.darParadas( );
            assertEquals( "No inicializó la cantidad de paradas correctamente.", 5, paradas.size( ) );

            assertEquals( "No inicializó las paradas correctamente.", "Ciudad0", ( ( Parada )paradas.get( 0 ) ).darNombre( ) );
            assertEquals( "No inicializó las paradas correctamente.", "Ciudad1", ( ( Parada )paradas.get( 1 ) ).darNombre( ) );
            assertEquals( "No inicializó las paradas correctamente.", "Ciudad2", ( ( Parada )paradas.get( 2 ) ).darNombre( ) );
            assertEquals( "No inicializó las paradas correctamente.", "Ciudad3", ( ( Parada )paradas.get( 3 ) ).darNombre( ) );
            assertEquals( "No inicializó las paradas correctamente.", "Ciudad4", ( ( Parada )paradas.get( 4 ) ).darNombre( ) );

            assertEquals( "No inicializó los horarios correctamente.", "00:00", ( ( Parada )paradas.get( 0 ) ).darHorario( ) );
            assertEquals( "No inicializó los horarios correctamente.", "01:01", ( ( Parada )paradas.get( 1 ) ).darHorario( ) );
            assertEquals( "No inicializó los horarios correctamente.", "02:02", ( ( Parada )paradas.get( 2 ) ).darHorario( ) );
            assertEquals( "No inicializó los horarios correctamente.", "03:03", ( ( Parada )paradas.get( 3 ) ).darHorario( ) );
            assertEquals( "No inicializó los horarios correctamente.", "04:04", ( ( Parada )paradas.get( 4 ) ).darHorario( ) );

            assertNull( "No debería tener un tren siguiente.", tren.darSiguiente( ) );
            assertNull( "No debería tener un tren anterior.", tren.darAnterior( ) );
            assertNull( "No debería tener un primer vagón.", tren.darPrimerVagon( ) );

            assertEquals( "No inicializó la cantidad recaudada correctamente.", 0.0, tren.darCantidadRecaudada( ), 0.0 );
        }
        catch( Exception e )
        {
            fail( "No se debería generar ningún error." );
        }
    }

    /**
     * Prueba 3: Se encarga de verificar el método darOrigen de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darOrigen <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Retorna la ciudad de origen. <br>
     */
    @Test
    public void testDarOrigen( )
    {
        assertEquals( "No retorna el origen correcto.", "Ciudad0", tren.darOrigen( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el método darDestino de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darDestino <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Retorna la ciudad de destino.
     */
    @Test
    public void testDarDestino( )
    {
        assertEquals( "No retorna el destino correcto.", "Ciudad4", tren.darDestino( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el método cambiarSiguiente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Tren <br>
     * cambiarSiguiente <br>
     * darSiguiente <br>
     * darId <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Cambia el siguiente tren. <br>
     * 2. Cambia el siguiente tren cuando ya existe un siguiente.
     */
    @Test
    public void testCambiarSiguiente( )
    {
        try
        {
        	// Caso de prueba 1.
            Tren nuevo = new Tren( 5 );
            tren.cambiarSiguiente( nuevo );
            assertNotNull( "Debería tener un siguiente tren.", tren.darSiguiente( ) );
            assertEquals( "No agrega el siguiente tren correctamente.", 5, tren.darSiguiente( ).darId( ) );

            // Caso de prueba 2.
            Tren nuevo2 = new Tren( 6 );
            tren.cambiarSiguiente( nuevo2 );
            assertEquals( "No agrega el siguiente tren correctamente.", 6, tren.darSiguiente( ).darId( ) );

        }
        catch( Exception e )
        {
            fail( "No se debería generar ningún error." );
        }
    }

    /**
     * Prueba 6: Se encarga de verificar el método cambiarAnterior de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Tren <br>
     * cambiarAnterior <br>
     * darAnterior <br>
     * darId <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Cambia el tren anterior. <br>
     * 2. Cambia el tren anterior cuando ya existe un anterior.
     */
    @Test
    public void testCambiarAnterior( )
    {
        try
        {
        	// Caso de prueba 1.
            Tren nuevo = new Tren( 5 );
            tren.cambiarAnterior( nuevo );
            assertNotNull( "Deberia tener un tren anterior.", tren.darAnterior( ) );
            assertEquals( "No agrega el tren anterior correctamente.", 5, tren.darAnterior( ).darId( ) );

            // Caso de prueba 2.
            Tren nuevo2 = new Tren( 6 );
            tren.cambiarAnterior( nuevo2 );
            assertEquals( "No agrega el tren anterior correctamente.", 6, tren.darAnterior( ).darId( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería generar ningún error." );
        }
    }

    /**
     * Prueba 7: Se encarga de verificar el método agregarVagon de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarVagon <br>
     * darPrimerVagon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Agrega un vagón al tren cuando este no tiene vagones. <br>
     * 2. Agrega un vagón al tren cuando este ya tiene vagones.
     */
    @Test
    public void testAgregarVagon1( )
    {
        try
        {
            // Caso de prueba 1.
            // Vagón en primera clase.
            tren.agregarVagon( 3, 5, Vagon.CLASES[ 0 ], 300 );
            assertNotNull( "Debería tener un vagón.", tren.darPrimerVagon( ) );
            assertEquals( "No agregó el vagón correctamente.", 3, tren.darPrimerVagon( ).darNumero( ) );

            // Caso de prueba 2.
            // Vagón en segunda clase.
            tren.agregarVagon( 5, 10, Vagon.CLASES[ 1 ], 100 );
            assertNotNull( "Debería tener el vagón.", tren.darPrimerVagon( ).darSiguiente( ) );
            assertEquals( "No agregó el vagón correctamente.", 5, tren.darPrimerVagon( ).darSiguiente( ).darNumero( ) );
        }
        catch( ElementoExisteException e )
        {
            fail( "No debería generar error." );
        }

    }

    /**
     * Prueba 8: Se encarga de verificar el método agregarVagon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarVagon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Intenta agregar un vagón con un número de identificación ya existente.
     */
    @Test
    public void testAgregarVagon2( )
    {
        try
        {
            // Vagón en primera clase.
            tren.agregarVagon( 3, 5, Vagon.CLASES[ 0 ], 300 );
            // Vagon en segunda clase.
            tren.agregarVagon( 3, 7, Vagon.CLASES[ 1 ], 200 );

            fail( "Debería generar error. Ya existe un vagón con ese número." );
        }
        catch( ElementoExisteException e )
        {
            // Debe pasar por aquí.
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el método eliminarVagon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarVagon <br>
     * darPrimerVagon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Elimina el primer vagón. <br>
     * 2. Elimina un vagón que está en el medio. <br>
     * 3. Elimina el último vagón.
     */
    @Test
    public void testEliminarVagon1( )
    {
        setupEscenario2( );
        try
        {
            // Caso de prueba 1.
            tren.eliminarVagon( 3 );
            assertNull( "El vagón no debería existir.", tren.buscarVagon( 3 ) );
            assertEquals( "No eliminó el vagón correctamente.", 5, tren.darPrimerVagon( ).darNumero( ) );

            // Caso de prueba 2.
            tren.eliminarVagon( 7 );
            assertNull( "El vagón no debería existir.", tren.buscarVagon( 7 ) );
            assertEquals( "No eliminó el vagón correctamente.", 9, tren.darPrimerVagon( ).darSiguiente( ).darNumero( ) );

            // Caso de prueba 3.
            tren.eliminarVagon( 9 );
            assertNull( "El vagón no debería existir.", tren.buscarVagon( 9 ) );
            assertNull( "No eliminó el vagón correctamente.", tren.darPrimerVagon( ).darSiguiente( ) );
        }
        catch( ElementoNoExisteException e )
        {
            fail( "No debería generar error." );
        }

    }

    /**
     * Prueba 10: Se encarga de verificar el método eliminarVagon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarVagon <br>
     * <b> Casos de Prueba: <br>
     * 1. Se intenta eliminar un vagón no existente.
     */
    @Test
    public void testEliminarVagon2( )
    {
        setupEscenario2( );
        try
        {
            tren.eliminarVagon( 10 );
            fail( "Debería generar error. No existe un vagón con ese número." );
        }
        catch( ElementoNoExisteException e )
        {
            // Debe pasar por aquí.
        }
    }

    /**
     * Prueba 11: Se encarga de verificar el método darCantidadSillasDisponibles de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadSillasDisponibles <br>
     * <b> Casos de Prueba: </b> <br>
     * 1. Retorna la cantidad de sillas cuando no hay vagones. <br>
     * 2. Retorna la cantidad de sillas cuando hay un vagón. <br>
     * 3. Retorna la cantidad de sillas cuando hay más de un vagón. <br>
     */
    @Test
    public void testDarCantidadSillasDisponibles( )
    {
        // Caso de prueba 1.
        assertEquals( "No calcula correctamente la cantidad de sillas dispoibles.", 0, tren.darCantidadSillasDisponibles( ) );

        // Caso de prueba 2.
        setupEscenario3( );
        assertEquals( "No calcula correctamente la cantidad de sillas disponibles.", 1, tren.darCantidadSillasDisponibles( ) );

        // Caso de prueba 3.
        setupEscenario2( );
        assertEquals( "No calcula correctamente la cantidad de sillas disponibles.", 65, tren.darCantidadSillasDisponibles( ) );
    }

    /**
     * Prueba 12: Se encarga de verificar el método tieneParadas de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * tieneParadas <br>
     * <b> Casos de Prueba: </b> <br>
     * 1. La ciudad de origen y de destino no se encuentra en la lista de paradas. <br>
     * 2. La ciudad de destino no se encuentra en la lista de paradas. <br>
     * 3. La ciudad de origen no se encuentre en la lista de paradas. <br>
     * 4. Las ciudades de origen y destino existen, pero no están en el orden correcto. <br>
     * 5. Las ciudades de origen y destino existen y están en el orden correcto.
     */
    @Test
    public void testSirveItinerario( )
    {
        // Caso de prueba 1.
        assertFalse( "El tren no tiene las paradas.", tren.tieneParadas( "Ciudad5", "Ciudad6" ) );

        // Caso de prueba 2.
        assertFalse( "El tren no tiene las paradas.", tren.tieneParadas( "Ciudad0", "Ciudad5" ) );

        // Caso de prueba 3.
        assertFalse( "El tren no tiene las paradas.", tren.tieneParadas( "Ciudad-1", "Ciudad2" ) );

        // Caso de prueba 4.
        assertFalse( "El tren no tiene las paradas.", tren.tieneParadas( "Ciudad4", "Ciudad2" ) );
        assertFalse( "El tren no tiene las paradas.", tren.tieneParadas( "Ciudad3", "Ciudad1" ) );

        // Caso de prueba 5.
        assertTrue( "El tren tiene las paradas.", tren.tieneParadas( "Ciudad0", "Ciudad1" ) );
        assertTrue( "El tren tiene las paradas.", tren.tieneParadas( "Ciudad1", "Ciudad3" ) );
    }

    /**
     * Prueba 13: Se encarga de verificar el método venderTiquete de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * venderTiquete <br>
     * <b> Casos de Prueba: </b> <br>
     * 1. Intenta vender un tiquete de un vagón no existente.
     */
    @Test
    public void testVenderTiquete1( )
    {
        setupEscenario2( );

        try
        {
            tren.venderTiquete( 8 );
            fail( "Debería genera Excepción." );
        }
        catch( ElementoNoExisteException e )
        {
            // Debe pasar por aquí.
        }
    }

    /**
     * Prueba 14: Se encarga de verificar el método venderTiquete de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * venderTiquete <br>
     * darCantidadSillasDisponibles <br>
     * darCantidadRecaudada <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Vende tiquetes exitosamente. <br>
     * 2. Trata de vender un tiquete cuando no hay sillas disponibles.
     */
    @Test
    public void testVenderTiquete2( )
    {
        setupEscenario2( );

        try
        {
            // Caso de Prueba 1.
            assertTrue( "Debería vender la silla.", tren.venderTiquete( 3 ) );
            assertEquals( "No cambió correctamente la cantidad de sillas disponibles.", 64, tren.darCantidadSillasDisponibles( ) );
            assertEquals( "No calcula la cantidad recaudada correctamente.", 300.0, tren.darCantidadRecaudada( ), 0.0 );

            assertTrue( "Debería vender la silla.", tren.venderTiquete( 7 ) );
            assertEquals( "No cambió correctamente la cantidad de sillas disponibles.", 63, tren.darCantidadSillasDisponibles( ) );
            assertEquals( "No calcula la cantidad recaudada correctamente.", 450.0, tren.darCantidadRecaudada( ), 0.0 );
            
            // Solo hay una silla disponible.
            setupEscenario3( );
            assertTrue( "Debería vender la silla.", tren.venderTiquete( 3 ) );
            assertEquals( "No cambió correctamente la cantidad de sillas disponibles.", 0, tren.darCantidadSillasDisponibles( ) );
            assertEquals( "No calcula la cantidad recaudada correctamente.", 300.0, tren.darCantidadRecaudada( ), 0.0 );
            
            // Caso de Prueba 2.
            assertFalse( "No debería vender la silla.", tren.venderTiquete( 3 ) );
            
        }
        catch( ElementoNoExisteException e )
        {
            fail( "No debería genera Excepción." );
        }
    }

    /**
     * Prueba 15: Se encarga de verificar el método buscarVagon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarVagon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El vagón buscado es el primero. <br>
     * 2. El vagón buscado no es el primero. <br>
     * 3. El vagón buscado no existe.
     */
    @Test
    public void testBuscarVagon( )
    {
        setupEscenario2( );

        // Caso de Prueba 3.
        Vagon vagon = tren.buscarVagon( 3 );
        assertNotNull( "No encontró el vagón.", vagon );
        assertEquals( "No encontró el vagón esperado.", 3, vagon.darNumero( ) );
        
        // Caso de Prueba 2.
        vagon = tren.buscarVagon( 5 );
        assertNotNull( "No encontró el vagón.", vagon );
        assertEquals( "No encontró el vagón esperado.", 5, vagon.darNumero( ) );

        // Caso de Prueba 3.
        vagon = tren.buscarVagon( 15 );
        assertNull( "No debería encontrar un vagón.", vagon );
    }

    /**
     * Prueba 16: Se encarga de verificar el método darHorarioSalida de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darHorarioSalida <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Retorna la hora de salida correctamente.
     */
    @Test
    public void testDarHorarioSalida( )
    {
        assertEquals( "No retorna la hora de salida correctamente.", "00:00", tren.darHorarioSalida( ) );
    }

    /**
     * Prueba 17: Se encarga de verificar el método darHorarioLlegada de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darHorarioSalida <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Retorna la hora de llegada correctamente.
     */
    @Test
    public void testDarHorarioLlegada( )
    {
        assertEquals( "No retorna la hora de llegada correctamente.", "04:04", tren.darHorarioLlegada( ) );
    }
}