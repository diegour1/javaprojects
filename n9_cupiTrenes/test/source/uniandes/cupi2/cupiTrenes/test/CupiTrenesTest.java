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

import java.util.Date;

import static org.junit.Assert.*;

import org.junit.*;
import uniandes.cupi2.cupiTrenes.mundo.*;

/**
 * Clase usada para verificar la correcta implementación de CupiTrenes.
 */
public class CupiTrenesTest
{
    // -------------------------------------------------------------
    // Constante
    // -------------------------------------------------------------

    /**
     * Prefijo de la ruta donde están los archivos de prueba.
     */
    public static final String RUTA_ARCHIVO = "test/data/test";

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private CupiTrenes cupiTrenes;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo cupiTrenes vacío.
     */
    @Before
    public void setupEscenario1( )
    {
        try
        {
            cupiTrenes = new CupiTrenes( RUTA_ARCHIVO + "0.data" );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Escenario 2: Crea un nuevo cupiTrenes con 2 trenes sin vagones.
     */
    public void setupEscenario2( )
    {
        try
        {
            cupiTrenes = new CupiTrenes( RUTA_ARCHIVO + "0.data" );

            String[] paradas1 = { "Lyon", "Geneve", "Zurich", "Konstanz", "Stuttgart" };
            int horas1[] = { 3, 9, 12, 13, 18 };
            int minutos1[] = { 30, 35, 50, 50, 10 };
            Date[] horarios1 = new Date[horas1.length];
            for( int i = 0; i < horarios1.length; i++ )
            {
                horarios1[ i ] = new Date( 0, 0, 0, horas1[ i ], minutos1[ i ] );
            }
            cupiTrenes.agregarTren( 35, paradas1, horarios1 );

            String[] paradas2 = { "Barcelona", "Madrid" };
            int horas2[] = { 6, 12 };
            int minutos2[] = { 0, 35 };
            Date[] horarios2 = new Date[horas2.length];
            for( int i = 0; i < horarios2.length; i++ )
            {
                horarios2[ i ] = new Date( 0, 0, 0, horas2[ i ], minutos2[ i ] );
            }
            cupiTrenes.agregarTren( 50, paradas2, horarios2 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Escenario 3: Crea un nuevo cupiTrenes con trenes que tienen vagones.
     */
    public void setupEscenario3( )
    {
        try
        {
            setupEscenario2( );

            // Vagón en segunda clase.
            cupiTrenes.agregarVagon( 35, 4, 5, Vagon.CLASES[ 1 ], 50.0 );

            // Vagón en primera clase.
            cupiTrenes.agregarVagon( 35, 5, 40, Vagon.CLASES[ 0 ], 100.0 );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * CupiTrenes <br>
     * darTotralRecaudo <br>
     * darTotalSillasDisponibles <br>
     * darPrimerTren <br>
     * <b> Casos de Prueba: </b> <br>
     * 1. Crea un nuevo cupiTrenes con trenes sin vagones.
     */
    @Test
    public void testCupiTrenes1( )
    {
        setupEscenario2( );

        assertEquals( "No se inicializó la clase correctamente.", 0.0, cupiTrenes.darTotalRecaudo( ), 0.0 );
        assertEquals( "No se inicializó la clase correctamente.", 0, cupiTrenes.darTotalSillasDisponibles( ) );

        Tren rutaTren = cupiTrenes.darPrimerTren( );
        assertNotNull( "No se inicializaron los trenes correctamente.", rutaTren );
        assertEquals( "No se inicializaron los trenes correctamente.", 35, rutaTren.darId( ) );
        assertEquals( "No se inicializaron los trenes correctamente.", 5, rutaTren.darParadas( ).size( ) );

        rutaTren = rutaTren.darSiguiente( );
        assertEquals( "No se inicializaron los trenes correctamente.", 50, rutaTren.darId( ) );
        assertEquals( "No se inicializaron los trenes correctamente.", 2, rutaTren.darParadas( ).size( ) );

    }

    /**
     * Prueba 2: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * CupiTrenes <br>
     * darTotalRecaudo <br>
     * darTotalSillasDisponibles <br>
     * darPrimerTren <br>
     * <b> Casos de Prueba: </b> <br>
     * 1. Crea un nuevo cupiTrenes con viajes y con vagones.
     */
    @Test
    public void testCupiTrenes2( )
    {
        setupEscenario3( );
        assertEquals( "No se inicializó la clase correctamente.", 0.0, cupiTrenes.darTotalRecaudo( ), 0.0 );
        assertEquals( "No se inicializó la clase correctamente.", 45, cupiTrenes.darTotalSillasDisponibles( ) );

        Vagon vagon = cupiTrenes.darPrimerTren( ).darPrimerVagon( );
        assertEquals( "No se inicializaron los vagones correctamente.", 4, vagon.darNumero( ) );
        assertEquals( "No se inicializaron los vagones correctamente.", 5, vagon.darCantidadSillasDisponibles( ) );
        assertEquals( "No se inicializaron los vagones correctamente.", 50.0, vagon.darPrecio( ), 0.0 );

        vagon = vagon.darSiguiente( );
        assertEquals( "No se inicializaron los vagones correctamente.", 5, vagon.darNumero( ) );
        assertEquals( "No se inicializaron los vagones correctamente.", 40, vagon.darCantidadSillasDisponibles( ) );
        assertEquals( "No se inicializaron los vagones correctamente.", 100.0, vagon.darPrecio( ), 0.0 );

    }

    /**
     * Prueba 3: Se encarga de verificar el método darTotalRecaudo de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darTotalRecaudo <br>
     * venderTiquete <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Calcula el total recaudado después de vender varios tiquetes.
     */
    @Test
    public void testDarTotalRecaudo( )
    {
        setupEscenario3( );
        assertEquals( "No calcula el recaudo correctamente.", 0.0, cupiTrenes.darTotalRecaudo( ), 0.0 );
        try
        {
            cupiTrenes.venderTiquete( 35, 4 );
            assertEquals( "No calcula correctamente el recaudo.", 50.0, cupiTrenes.darTotalRecaudo( ), 0.0 );

            cupiTrenes.venderTiquete( 35, 4 );
            cupiTrenes.venderTiquete( 35, 5 );
            cupiTrenes.venderTiquete( 35, 4 );
            assertEquals( "No calcula correctamente el recaudo.", 250.0, cupiTrenes.darTotalRecaudo( ), 0.0 );
        }
        catch( ElementoNoExisteException e )
        {
            fail( "No debería generar error." );
        }
    }

    /**
     * Prueba 4: Se encarga de verificar el método buscarTrenPorParadas de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarTrenPorParadas <br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay trenes en el sistema. <br>
     * 2. El tren no existe. <br>
     * 3. El tren existe.
     */
    @Test
    public void testBuscarTrenPorParadas( )
    {
        // Caso de prueba 1.
        assertNull( "No hay trenes en el sistema.", cupiTrenes.buscarTrenPorParadas( "Lyon", "Zurich" ) );

        // Caso de prueba 2.
        setupEscenario2( );
        assertNull( "No debería encontrar un tren.", cupiTrenes.buscarTrenPorParadas( "Stuttgart", "Konstanz" ) );
        assertNull( "No debería encontrar un tren.", cupiTrenes.buscarTrenPorParadas( "Madrid", "Barcelona" ) );
        assertNull( "No debería encontrar un tren.", cupiTrenes.buscarTrenPorParadas( "Madrid", "Stuttgart" ) );
        assertNull( "No debería encontrar un tren.", cupiTrenes.buscarTrenPorParadas( "Stuttgart", "Madrid" ) );

        // Caso de prueba 3.
        assertEquals( "No encontró el tren deseado.", 35, cupiTrenes.buscarTrenPorParadas( "Lyon", "Zurich" ).darId( ) );
        assertEquals( "No encontró el tren deseado.", 35, cupiTrenes.buscarTrenPorParadas( "Geneve", "Konstanz" ).darId( ) );
        assertEquals( "No encontró el tren deseado.", 50, cupiTrenes.buscarTrenPorParadas( "Barcelona", "Madrid" ).darId( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el método buscarTrenPorId de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarTrenPorId <br>
     * darParadas <br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay trenes en el sistema. <br>
     * 2. No existe un tren con el id dado. <br>
     * 3. Se encuentra el tren deseado.
     */
    @Test
    public void testBuscarTrenPorId( )
    {
        // Caso de prueba 1.
        assertNull( "No debería encontrar un tren.", cupiTrenes.buscarTrenPorId( 1 ) );

        // Caso de prueba 2.
        setupEscenario2( );
        assertNull( "No debería encontrar un tren.", cupiTrenes.buscarTrenPorId( 40 ) );
        assertNull( "No debería encontrar un tren.", cupiTrenes.buscarTrenPorId( 5 ) );

        // Caso de prueba 3.
        assertNotNull( "Debería encontrar un tren.", cupiTrenes.buscarTrenPorId( 35 ) );
        assertEquals( "No encontró el tren deseado.", 35, cupiTrenes.buscarTrenPorId( 35 ).darId( ) );
        assertNotNull( "Debería encontrar un tren.", cupiTrenes.buscarTrenPorId( 50 ) );
        assertEquals( "No encontró el tren deseado.", 50, cupiTrenes.buscarTrenPorId( 50 ).darId( ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el método agregarTren de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarTren <br>
     * darPrimeraTren <br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay ninguna ruta. <br>
     * 2. El tren se agrega antes de la ruta actual. <br>
     * 3. El tren se agrega en la mitad. <br>
     * 4. El tren se debe agregar al final.
     */
    @Test
    public void testAgregarTren1( )
    {
        String[] paradas = { "Roma", "Berlin", "Londres" };
        Date[] horarios1 = new Date[3];
        for( int i = 10; i < 13; i++ )
        {
            Date horario = new Date( );
            horario.setHours( i );
            horario.setMinutes( i );
            horarios1[ i - 10 ] = horario;
        }
        Date[] horarios2 = new Date[3];
        for( int i = 1; i < 4; i++ )
        {
            Date horario = new Date( );
            horario.setHours( i );
            horario.setMinutes( i );
            horarios2[ i - 1 ] = horario;
        }
        Date[] horarios3 = new Date[3];
        for( int i = 11; i < 14; i++ )
        {
            Date horario = new Date( );
            horario.setHours( i );
            horario.setMinutes( i );
            horarios3[ i - 11 ] = horario;
        }
        Date[] horarios4 = new Date[3];
        for( int i = 9; i < 12; i++ )
        {
            Date horario = new Date( );
            horario.setHours( i );
            horario.setMinutes( i );
            horarios4[ i - 9 ] = horario;
        }
        try
        {
            // Caso de prueba 1.
            cupiTrenes.agregarTren( 35, paradas, horarios1 );
            assertEquals( "No agrega el tren correctamente.", 35, cupiTrenes.darPrimerTren( ).darId( ) );

            // Caso de prueba 2.
            cupiTrenes.agregarTren( 40, paradas, horarios2 );
            assertEquals( "No agrega el tren correctamente.", 40, cupiTrenes.darPrimerTren( ).darId( ) );
            assertEquals( "No agrega el tren correctamente.", 35, cupiTrenes.darPrimerTren( ).darSiguiente( ).darId( ) );

            // Caso de prueba 3.
            cupiTrenes.agregarTren( 15, paradas, horarios4 );
            assertEquals( "No agrega el tren correctamente.", 40, cupiTrenes.darPrimerTren( ).darId( ) );
            assertEquals( "No agrega el tren correctamente.", 15, cupiTrenes.darPrimerTren( ).darSiguiente( ).darId( ) );
            assertEquals( "No agrega el tren correctamente.", 35, cupiTrenes.darPrimerTren( ).darSiguiente( ).darSiguiente( ).darId( ) );

            // Caso de prueba 4.
            cupiTrenes.agregarTren( 20, paradas, horarios3 );
            assertEquals( "No agrega el tren correctamente.", 40, cupiTrenes.darPrimerTren( ).darId( ) );
            assertEquals( "No agrega el tren correctamente.", 15, cupiTrenes.darPrimerTren( ).darSiguiente( ).darId( ) );
            assertEquals( "No agrega el tren correctamente.", 35, cupiTrenes.darPrimerTren( ).darSiguiente( ).darSiguiente( ).darId( ) );
            assertEquals( "No agrega el tren correctamente.", 20, cupiTrenes.darPrimerTren( ).darSiguiente( ).darSiguiente( ).darSiguiente( ).darId( ) );
        }
        catch( ElementoExisteException e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 7: Se encarga de verificar el método agregarTren de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarTren <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta agregar un tren ya existente.
     */
    @Test
    public void testAgregarTren2( )
    {

        String[] paradas = { "Roma", "Berlin", "Londres" };
        Date[] horarios1 = new Date[3];
        for( int i = 10; i < 13; i++ )
        {
            Date horario = new Date( );
            horario.setHours( i );
            horario.setMinutes( i );
            horarios1[ i - 10 ] = horario;
        }

        Date[] horarios2 = new Date[3];
        for( int i = 1; i < 4; i++ )
        {
            Date horario = new Date( );
            horario.setHours( i );
            horario.setMinutes( i );
            horarios2[ i - 1 ] = horario;
        }
        try
        {
            cupiTrenes.agregarTren( 35, paradas, horarios1 );
            cupiTrenes.agregarTren( 35, paradas, horarios2 );
            fail( "Debería generar excepción. Ya existe un tren con ese id." );
        }
        catch( ElementoExisteException e )
        {
            // Debe generar error.
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el método eliminarTren de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarTren <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Elimina un tren no existente.
     */
    @Test
    public void testEliminarTren1( )
    {
        setupEscenario2( );
        try
        {
            cupiTrenes.eliminarTren( 60 );
            fail( "Debería generar Excepción. No existe un tren con ese id." );
        }
        catch( ElementoNoExisteException e )
        {
            // Debe generar error.
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el método eliminarTren de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarTren <br>
     * eliminarTren <br>
     * darPrimeraTren <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Elimina el primer tren. <br>
     * 2. Elimina un tren intermedio. <br>
     * 3. Elimina el último tren.
     */
    @Test
    public void testEliminarTren2( )
    {
        setupEscenario2( );
        try
        {
            String[] paradas = { "Roma", "Berlin", "Londres" };
            Date[] horarios = new Date[3];
            for( int i = 10; i < 13; i++ )
            {
                Date horario = new Date( );
                horario.setHours( i );
                horario.setMinutes( i );
                horarios[ i - 10 ] = horario;
            }
            cupiTrenes.agregarTren( 40, paradas, horarios );

            Date[] horarios2 = new Date[3];
            for( int i = 9; i < 12; i++ )
            {
                Date horario = new Date( );
                horario.setHours( i );
                horario.setMinutes( i );
                horarios[ i - 9 ] = horario;
            }
            cupiTrenes.agregarTren( 15, paradas, horarios );

            // Caso de prueba 1.
            cupiTrenes.eliminarTren( 35 );
            assertEquals( "No eliminó el tren correctamente.", 50, cupiTrenes.darPrimerTren( ).darId( ) );
            assertNull( "El tren no debería existir.", cupiTrenes.buscarTrenPorId( 35 ) );

            // Caso de prueba 2.
            cupiTrenes.eliminarTren( 15 );
            assertEquals( "No eliminó el tren correctamente.", 40, cupiTrenes.darPrimerTren( ).darSiguiente( ).darId( ) );
            assertNull( "El tren no debería existir.", cupiTrenes.buscarTrenPorId( 15 ) );

            // Caso de prueba 3.
            cupiTrenes.eliminarTren( 40 );
            assertNull( "El tren no debería existir.", cupiTrenes.buscarTrenPorId( 40 ) );
            assertNull( "No eliminó el tren correctamente.", cupiTrenes.darPrimerTren( ).darSiguiente( ) );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el método eliminarVagon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarVagon <br>
     * <b> Caso de prueba: </b> <br>
     * 1. Se intenta eliminar un vagón de un tren que no existe. <br>
     * 2. Se intenta eliminar un vagón no existente de una ruta existente. <br>
     */
    @Test
    public void testEliminarVagon1( )
    {
        setupEscenario3( );
        try
        {
            // Caso de prueba 1.
            cupiTrenes.eliminarVagon( 60, 4 );
            fail( "Debería generar Excepción. No existe un tren con ese número." );

        }
        catch( ElementoNoExisteException e )
        {
            // Debe generar error.
        }
        try
        {
            // Caso de prueba 2.
            cupiTrenes.eliminarVagon( 35, 3 );
            fail( "Debería generar Excepción. No existe un vagón con ese número." );
        }
        catch( ElementoNoExisteException e )
        {
            // Debe generar error.
        }

    }

    /**
     * Prueba 11. Se encarga de verificar el método eliminarVagon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarVagon <br>
     * darPrimerTren <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se elimina el vagón correctamente.
     */
    @Test
    public void testEliminarVagon2( )
    {
        setupEscenario3( );
        try
        {
            cupiTrenes.eliminarVagon( 35, 4 );
            assertEquals( "No elimina el vagón correctamente.", 5, cupiTrenes.darPrimerTren( ).darPrimerVagon( ).darNumero( ) );
        }
        catch( ElementoNoExisteException e )
        {
            fail( "No debería generar error." );
        }
    }

    /**
     * Prueba 12: Se encarga de verificar el método agregarVagon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarVagon <br>
     * buscarTrenPorId <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El tren no existe. <br>
     * 2. El tren ya existe, pero ya tiene un vagón con el número dado.
     */
    @Test
    public void testAgregarVagon1( )
    {
        setupEscenario2( );
        try
        {
            // Caso de prueba 1.
            cupiTrenes.agregarVagon( 46, 8, 10, Vagon.CLASES[ 0 ], 40.0 );
            fail( "Debería generar excepción. El id del tren no existe." );
        }
        catch( ElementoExisteException e )
        {
            // Debería generar Excepción.
        }
        catch( ElementoNoExisteException e )
        {
            // Debería generar Excepción.
        }

        try
        {
            // Caso de prueba 2.
            cupiTrenes.agregarVagon( 35, 2, 20, Vagon.CLASES[ 1 ], 50.0 );
            cupiTrenes.agregarVagon( 35, 2, 20, Vagon.CLASES[ 1 ], 35.0 );
            fail( "Debería generar excepción. Ya existe un vagón con ese número" );
        }
        catch( ElementoExisteException e )
        {
            // Debería generar Excepción.
        }
        catch( ElementoNoExisteException e )
        {
            // Debería generar Excepción.
        }
    }

    /**
     * Prueba 13: Se encarga de verificar el método agregarVagon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarVagon <br>
     * buscarTrenPorId <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agrega el vagón exitosamente.
     */
    @Test
    public void testAgregarVagon2( )
    {
        setupEscenario2( );
        try
        {
            // Vagón en primera clase.
            cupiTrenes.agregarVagon( 50, 4, 50, Vagon.CLASES[ 0 ], 50.0 );
            cupiTrenes.agregarVagon( 50, 6, 10, Vagon.CLASES[ 1 ], 30.0 );

            Vagon vagon = cupiTrenes.buscarTrenPorId( 50 ).darPrimerVagon( );
            assertEquals( "No agregó el vagón correctamente.", 4, vagon.darNumero( ) );
            assertEquals( "No agregó el vagón correctamente.", 50.0, vagon.darPrecio( ), 0.0 );
            assertEquals( "No agregó el vagón correctamente.", 50, vagon.darCantidadSillasDisponibles( ) );
            assertEquals( "No agregó el vagón correctamente.", Vagon.CLASES[ 0 ], vagon.darClase( ) );

            vagon = vagon.darSiguiente( );
            assertEquals( "No agregó el vagón correctamente.", 6, vagon.darNumero( ) );

            vagon = vagon.darSiguiente( );
            assertNull( "El siguiente debería ser nulo.", vagon );
        }
        catch( ElementoExisteException e )
        {
            fail( "No debería generar error." );
        }
        catch( ElementoNoExisteException e )
        {
            fail( "No debería generar error." );
        }

    }

    /**
     * Prueba 14: Se encarga de verificar el método venderTiquete de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * venderTiquete <br>
     * darTotalRecaudo <br>
     * darTotalSillasDisponibles <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los tiquetes se venden exitosamente. <br>
     * 2. Se venden tiquetes cuando ya no hay sillas disponibles.
     */
    @Test
    public void testVenderTiquete1( )
    {
        setupEscenario3( );
        try
        {
            // Caso de prueba 1.
            assertTrue( "Debería vender el tiquete.", cupiTrenes.venderTiquete( 35, 4 ) );
            assertEquals( "No vende el tiquete correctamente.", 50.0, cupiTrenes.darTotalRecaudo( ), 0.01 );
            assertEquals( "No vende el tiquete correctamente.", 44, cupiTrenes.darTotalSillasDisponibles( ) );

            assertTrue( "Debería vender el tiquete.", cupiTrenes.venderTiquete( 35, 5 ) );
            assertEquals( "No vende el tiquete correctamente.", 150.0, cupiTrenes.darTotalRecaudo( ), 0.01 );
            assertEquals( "No vende el tiquete correctamente.", 43, cupiTrenes.darTotalSillasDisponibles( ) );
            assertTrue( "Debería vender el tiquete.", cupiTrenes.venderTiquete( 35, 4 ) );
            assertTrue( "Debería vender el tiquete.", cupiTrenes.venderTiquete( 35, 4 ) );
            assertTrue( "Debería vender el tiquete.", cupiTrenes.venderTiquete( 35, 4 ) );

            // Caso de prueba 2.
            assertTrue( "Debería vender el tiquete.", cupiTrenes.venderTiquete( 35, 4 ) );
            assertFalse( "No debería vender el tiquete. No hay sillas disponibles.", cupiTrenes.venderTiquete( 35, 4 ) );
        }
        catch( ElementoNoExisteException e )
        {
            fail( "No debería generar error." );
        }
    }

    /**
     * Prueba 15: Se encarga de verificar el método venderTiquete de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * venderTiquete <br>
     * <b> Casos de Prueba: </b> <br>
     * 1. Intenta vender tiquetes de un vagón no existente. <br>
     * 2. Intenta vender tiquetes de un tren no existente.
     */
    @Test
    public void testVenderTiquete2( )
    {
        setupEscenario3( );
        try
        {
            // Caso de Prueba 1.
            assertTrue( cupiTrenes.venderTiquete( 35, 8 ) );
            fail( "Debería generar error. No existe el vagón." );
        }
        catch( ElementoNoExisteException e )
        {
            // Debería generar error.
        }
        try
        {
            // Caso de Prueba 2.
            assertTrue( cupiTrenes.venderTiquete( 27, 4 ) );
            fail( "Debería generar error. No existe la ruta." );
        }
        catch( ElementoNoExisteException e )
        {
            // Debería generar error.
        }
    }

    /**
     * Prueba 16: Se encarga de verificar el método guardar de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * guardar <br>
     * agregarRuta <br>
     * agregarVagon <br>
     * cambiarRutaArchivo <br>
     * CupiTrenes <br>
     * darPrimerTren <br>
     * <b> Casos de Prueba: </b> <br>
     * 1. Se guarda el estado de CupiTrenes.
     */
    @Test
    public void testGuardar( )
    {
        String[] paradas = { "Roma", "Berlin", "Londres" };
        Date[] horarios = new Date[3];
        for( int i = 0; i < 3; i++ )
        {
            Date horario = new Date( );
            horario.setHours( i );
            horario.setMinutes( i * 5 );
            horarios[ i ] = horario;
        }
        try
        {
            String nuevaRuta = RUTA_ARCHIVO + "3.data";
            cupiTrenes.agregarTren( 20, paradas, horarios );
            cupiTrenes.agregarVagon( 20, 3, 50, Vagon.CLASES[ 0 ], 100 );

            cupiTrenes.guardar( nuevaRuta );

            cupiTrenes = new CupiTrenes( nuevaRuta );
            assertEquals( "No guardó correctamente los trenes.", 20, cupiTrenes.darPrimerTren( ).darId( ) );
            assertEquals( "No guardó correctamente los vagones.", 3, cupiTrenes.darPrimerTren( ).darPrimerVagon( ).darNumero( ) );
        }
        catch( ElementoExisteException e )
        {
            fail( "No debería generar Excepción." );
        }
        catch( ElementoNoExisteException e )
        {
            fail( "No debería generar Excepción." );
        }
        catch( PersistenciaException e )
        {
            fail( "No debería generar Excepción." );
        }

    }
}