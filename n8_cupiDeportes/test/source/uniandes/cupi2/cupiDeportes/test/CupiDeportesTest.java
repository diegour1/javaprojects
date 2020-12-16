/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_cupiDeportes
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiDeportes.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import uniandes.cupi2.cupiDeportes.mundo.Deporte;
import uniandes.cupi2.cupiDeportes.mundo.ElementoExisteException;
import uniandes.cupi2.cupiDeportes.mundo.FormatoArchivoException;
import uniandes.cupi2.cupiDeportes.mundo.CupiDeportes;
import uniandes.cupi2.cupiDeportes.mundo.Deportista;
import uniandes.cupi2.cupiDeportes.mundo.PersistenciaException;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Clase usada para verificar que los métodos de la clase CupiDeportes estén correctamente implementados.
 */
public class CupiDeportesTest{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Ruta para cargar el archivo de prueba.
     */
    private final static String RUTA_PRUEBA = "./test/data/cupiDeportes.data";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private CupiDeportes cupiDeportes;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo sistema CupiDeportes con 2 deportes y 2 deportistas. <br>
     * deporte1: Fútbol, FCF, 2500, futbol.jpg. <br>
     * deportista1: James, 23, Madrid, 39, jamesRodriguez.jpg.<br>
     * deporte2: Tenis, FCT, 110, tenis.jpg. <br>
     * deportista2: Alejandro, 31, Cali, 11, alejandroFalla.jpg.
     */
    @Before
    public void setupEscenario1( )
    {
        try
        {
            cupiDeportes = new CupiDeportes( RUTA_PRUEBA );
        }
        catch( PersistenciaException e )
        {
            fail( "Hay errores al cargar el archivo de CupiDeportes." );
        }
    }

    /**
     * Construye una nuevo sistema CupiDeportes vacío.
     */
    private void setupEscenario2( )
    {
        try
        {
            cupiDeportes = new CupiDeportes( "" );
        }
        catch( PersistenciaException e )
        {
            fail( "Hay errores al cargar el archivo de CupiDeportes." );
        }
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * constructor darDeportes <br>
     * <b> Objetivo: </b> Probar inicialización correcta del objeto CupiDeportes<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Inicialización correcta de CupiDeportes<br>
     */
    @Test
    public void testConstructorCupiDeportes( )
    {
        
        ArrayList<Deporte> listaDeportes = cupiDeportes.darDeportes( );
        assertNotNull( "No debería ser nula la lista.", listaDeportes );
        assertEquals( "El tamaño de la lista no corresponde.", 2, listaDeportes.size( ) );

        // El primer deporte
        Deporte primero = ( Deporte )listaDeportes.get( 0 );
        assertEquals( "El primer deporte no corresponde.", "Fútbol", primero.darNombre( ) );
        ArrayList<Deportista> deportistasPrimero = primero.darDeportistasSobresalientes( );
        Deportista primerDeportista = ( Deportista )deportistasPrimero.get( 0 );
        assertEquals( "El primer deportista no corresponde.", "James", primerDeportista.darNombre( ) );

        // El segundo deporte
        Deporte segundo = ( Deporte )listaDeportes.get( 1 );
        assertEquals( "El segundo deporte no corresponde.", "Tenis", segundo.darNombre( ) );
        ArrayList<Deportista> deportistasSegundo = segundo.darDeportistasSobresalientes( );
        Deportista segundoDeportista = ( Deportista )deportistasSegundo.get( 0 );
        assertEquals( "El segundo deportista no corresponde.", "Alejandro", segundoDeportista.darNombre( ) );

    }

    /**
     * Prueba 2: Verifica el método existeDeporte.<br>
     * <b> Métodos a probar: </b> <br>
     * existeDeporte <br>
     * <b> Objetivo: </b> Probar funcionamiento correcto existeDeporte<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Existe el deporte.<br>
     * 2. No existe el deporte.<br>
     */
    @Test
    public void testExisteDeporte( )
    {
        
        // 1
        assertTrue( "Debería existir el deporte.", cupiDeportes.existeDeporte( "Fútbol" ) );

        // 2
        assertFalse( "No debería existir el deporte.", cupiDeportes.existeDeporte( "Basket" ) );
    }

    /**
     * Prueba 3: Verifica el método agregarDeporte.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarDeporte<br>
     * existeDeporte<br>
     * darDeportes<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto agregarDeporte<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Agrega un deporte nuevo.<br>
     */
    @Test
    public void testAgregarDeporteOK( )
    {
    	//TODO Parte 4 punto E: Implemente el método según la documentación.  
    }

    /**
     * Prueba 4: Verifica el método agregarDeporte.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarDeporte<br>
     * darDeportes<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto agregarDeporte al lanzar excepción<br>
     * <b> Resultados esperados: </b> <br>
     * 1. No agrega, dado que ya existía un deporte con el nombre dado.<br>
     */
    @Test
    public void testAgregarDeporteError( )
    {
    	//TODO Parte 4 punto F: Implemente el método según la documentación.  
    }

    /**
     * Prueba 5: Verifica el método eliminarDeporte.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarDeporte<br>
     * existeDeporte<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto eliminarDeporte<br>
     * <b> Resultados esperados: </b> <br>
     * 1. No existe el deporte.<br>
     */
    @Test
    public void testEliminarDeporte( )
    {
        
        cupiDeportes.eliminarDeporte( "Fútbol" );
        assertEquals( "El tamaño de la lista de deportes debería ser 1.", 1, cupiDeportes.darDeportes( ).size( ) );
        assertFalse( "No debería existir el deporte.", cupiDeportes.existeDeporte( "Fútbol" ) );
    }

    /**
     * Prueba 6: Verifica el método agregarDeportista.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarDeportista<br>
     * darDeportes<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto agregarDeportista<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Agrega el deportista.<br>
     */
    @Test
    public void testAgregarDeportistaOK( )
    {
        // 1
        try
        {
            cupiDeportes.agregarDeportistaSobresaliente( "Fútbol", "Falcao", 29, "Manchester", 35, "falcao.jpg" );
            Deporte primero = ( Deporte )cupiDeportes.darDeportes( ).get( 0 );
            assertEquals( "El tamaño de los deportistas no coincide.", 2, primero.darDeportistasSobresalientes( ).size( ) );
            Deportista nuevo = ( Deportista )primero.darDeportistasSobresalientes( ).get( 1 );
            assertEquals( "El nombre del deportista nuevo no coincide.", "Falcao", nuevo.darNombre( ) );
        }
        catch( ElementoExisteException e )
        {
            fail( "No debería lanzar una excepción al agregar el deportista." );
        }

        // 2
        try
        {
            cupiDeportes.agregarDeportistaSobresaliente( "Fútbol", "Falcao", 29, "Manchester", 35, "falcao.jpg" );
            fail( "Debería lanzar una excepción al agregar el deportista." );
        }
        catch( ElementoExisteException e )
        {
            Deporte primero = ( Deporte )cupiDeportes.darDeportes( ).get( 0 );
            assertEquals( "El tamaño de los deportistas no coincide.", 2, primero.darDeportistasSobresalientes( ).size( ) );
        }
    }

    /**
     * Prueba 7: Verifica el método agregarDeportista.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarDeportista<br>
     * darDeportes<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto agregarDeportista<br>
     * <b> Resultados esperados: </b> <br>
     * 1. No agrega el deportista porque lanza excepción.<br>
     */
    @Test
    public void testAgregarDeportistaError( )
    {
        
        // 2
        try
        {
            cupiDeportes.agregarDeportistaSobresaliente( "Fútbol", "James", 23, "Madrid", 39, "james.jpg" );
            fail( "Debería lanzar una excepción al agregar el deportista." );
        }
        catch( ElementoExisteException e )
        {
            Deporte primero = ( Deporte )cupiDeportes.darDeportes( ).get( 0 );
            assertEquals( "El tamaño de los deportistas no coincide.", 1, primero.darDeportistasSobresalientes( ).size( ) );
        }
    }

    /**
     * Prueba 8: Verifica el método eliminarDeportista.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarDeportista<br>
     * darDeportes<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto eliminarDeportista<br>
     * <b> Resultados esperados: </b> <br>
     * 1. No existe el deportista.<br>
     */
    @Test
    public void testEliminarDeportista( )
    {
        
        cupiDeportes.eliminarDeportistaSobresaliente( "Fútbol", "Falcao" );
        Deporte primero = ( Deporte )cupiDeportes.darDeportes( ).get( 0 );
        assertEquals( "El tamaño de los deportistas no coincide.", 1, primero.darDeportistasSobresalientes( ).size( ) );

    }

    /**
     * Prueba 9: Verifica el método darDeportistaMasTrofeos.<br>
     * <b> Métodos a probar: </b> <br>
     * darDeportistaMasTrofeos <br>
     * <b> Objetivo: </b> Probar funcionamiento correcto darDeportistaMasTrofeos<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Cuando hay deportistas retorna el deportista con mas trofeos.<br>
     * 2. Cuando no hay deportistas retorna null. <br>
     */
    @Test
    public void testDarDeportistaMasTrofeos( )
    {
        // 1
        
        assertNotNull( "No debería ser nulo.", cupiDeportes.darDeportistaMasTrofeos( ) );
        assertEquals( "El nombre del deportista con más trofeos no corresponde.", "James", cupiDeportes.darDeportistaMasTrofeos( ).darNombre( ) );

        // 2
        setupEscenario2( );
        assertNull( "Debería ser nulo.", cupiDeportes.darDeportistaMasTrofeos( ) );
    }

    /**
     * Prueba 10: Verifica el método darDeportistaMasTrofeos.<br>
     * <b> Métodos a probar: </b> <br>
     * darDeportistaMasTrofeos <br>
     * <b> Objetivo: </b> Probar funcionamiento correcto darDeportistaMasTrofeos<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Cuando hay 2 deportistas que tienen igual número de trofeos y son máximos, retorna cualquiera.<br>
     */
    @Test
    public void testDarDeportistaMasTrofeos2( )
    {
        // 1
        
        try
        {
            cupiDeportes.agregarDeportistaSobresaliente( "Fútbol", "Falcao", 39, "Manchester", 35, "falcao.jpg" );
        }
        catch( ElementoExisteException e )
        {
            fail( "No debería generar excepción." );
        }

        assertNotNull( "No debería ser nulo.", cupiDeportes.darDeportistaMasTrofeos( ) );
        assertTrue( "El nombre del deportista con más trofeos no corresponde.", cupiDeportes.darDeportistaMasTrofeos( ).darNombre( ).equals( "James" ) || cupiDeportes.darDeportistaMasTrofeos( ).darNombre( ).equals( "Falcao" ) );

    }

    /**
     * Prueba 11: Verifica el método darTotalTrofeos.<br>
     * <b> Métodos a probar: </b> <br>
     * darTotalTrofeos <br>
     * <b> Objetivo: </b> Probar funcionamiento correcto darTotalTrofeos<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Cuando hay deportistas retorna la suma de todos los trofeos.<br>
     * 2. Cuando no hay deportistas retorna 0. <br>
     */
    @Test
    public void testDarTotalTrofeos( )
    {
        // 1
        
        assertEquals( "El número total de trofeos no es el esperado.", 50, cupiDeportes.darTotalTrofeos( ) );

        // 2
        setupEscenario2( );
        assertEquals( "El número total de trofeos no es el esperado.", 0, cupiDeportes.darTotalTrofeos( ) );

    }

    /**
     * Prueba 12: Verifica el método guardar.<br>
     * <b> Métodos a probar: </b> <br>
     * guardar <br>
     * constructor <br>
     * <b> Objetivo: </b> Probar funcionamiento correcto guardar<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al guardar, carga correctamente.<br>
     */
    @Test
    public void testGuardar( )
    {
        
        try
        {
            cupiDeportes.guardar( RUTA_PRUEBA );
            CupiDeportes temp = new CupiDeportes( RUTA_PRUEBA );
            assertEquals( "No se guardó correctamente CupiDeportes.", 2, temp.darDeportes( ).size( ) );

        }
        catch( PersistenciaException e )
        {
            fail( "No se debería generar una excepción" );
        }
    }

    /**
     * Prueba 13: Verifica el método actualizarInformacionDeportistas.<br>
     * <b> Métodos a probar: </b> <br>
     * actualizarInformacionDeportistas <br>
     * darDeportes <br>
     * <b> Objetivo: </b> Probar funcionamiento correcto actualizarInformacionDeportistas<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Cuando actualiza correctamente.<br>
     * 2. Cuando hay errores de formato. Cantidad de deportistas mal.<br>
     * 3. Cuando hay errores de formato. No hay datos de deportistas.<br>
     * 4. Cuando hay errores de formato. Falta un dato en el formato.<br>
     * 5. Cuando hay errores de formato. Números negativos.<br>
     */
    @Test
    public void testActualizarInformacionDeportistas( )
    {
        // 1
        
        File pArchivo = new File( "./test/data/datosPruebaOK.txt" );
        try
        {
            cupiDeportes.actualizarInformacionDeportistas( pArchivo );
            Deporte primero = ( Deporte )cupiDeportes.darDeportes( ).get( 0 );
            Deporte segundo = ( Deporte )cupiDeportes.darDeportes( ).get( 1 );
            Deportista deport1 = ( Deportista )primero.darDeportistasSobresalientes( ).get( 0 );
            Deportista deport2 = ( Deportista )segundo.darDeportistasSobresalientes( ).get( 0 );

            assertEquals( "El nombre del primer deportista no corresponde.", "James", deport1.darNombre( ) );
            assertEquals( "La edad del primer deportista no corresponde.", 24, deport1.darEdad( ) );
            assertEquals( "El lugar de residencia del primer deportista no corresponde.", "Madrid, España", deport1.darLugarResidencia( ) );
            assertEquals( "La cantidad de trofeos del primer deportista no corresponde.", 45, deport1.darCantidadTrofeos( ) );
            assertEquals( "La ruta de la imagen del primer deportista no corresponde.", "./data/imagenes/jamesRodriguez.jpg", deport1.darRutaImagen( ) );

            assertEquals( "El nombre del segundo deportista no corresponde.", "Alejandro", deport2.darNombre( ) );
            assertEquals( "La edad del segundo deportista no corresponde.", 32, deport2.darEdad( ) );
            assertEquals( "El lugar de residencia del segundo deportista no corresponde.", "Cali, Colombia", deport2.darLugarResidencia( ) );
            assertEquals( "La cantidad de trofeos del segundo deportista no corresponde.", 12, deport2.darCantidadTrofeos( ) );
            assertEquals( "La ruta de la imagen del segundo deportista no corresponde.", "./data/imagenes/alejandroFalla.jpg", deport2.darRutaImagen( ) );
        }
        catch( FileNotFoundException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( IOException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( FormatoArchivoException e )
        {
            fail( "No debería lanzar esta excepción." );
        }

        // 2
        
        File pArchivo2 = new File( "./test/data/datosPruebaError.txt" );
        try
        {
            cupiDeportes.actualizarInformacionDeportistas( pArchivo2 );
            fail( "Debería lanzar excepción." );
        }
        catch( FileNotFoundException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( IOException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( FormatoArchivoException e )
        {
            // Debería estar aca.
        }

        // 3
        
        File pArchivo3 = new File( "./test/data/datosPruebaError2.txt" );
        try
        {
            cupiDeportes.actualizarInformacionDeportistas( pArchivo3 );
            fail( "Debería lanzar excepción." );
        }
        catch( FileNotFoundException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( IOException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( FormatoArchivoException e )
        {
            // Debería estar aca.
        }

        // 4
        
        File pArchivo4 = new File( "./test/data/datosPruebaError3.txt" );
        try
        {
            cupiDeportes.actualizarInformacionDeportistas( pArchivo4 );
            fail( "Debería lanzar excepción." );
        }
        catch( FileNotFoundException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( IOException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( FormatoArchivoException e )
        {
            // Debería estar aca.
        }

        // 5
        
        File pArchivo5 = new File( "./test/data/datosPruebaError4.txt" );
        try
        {
            cupiDeportes.actualizarInformacionDeportistas( pArchivo5 );
            fail( "Debería lanzar excepción." );
        }
        catch( FileNotFoundException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( IOException e )
        {
            fail( "No debería lanzar esta excepción." );
        }
        catch( FormatoArchivoException e )
        {
            // Debería estar aca.
        }
    }
}