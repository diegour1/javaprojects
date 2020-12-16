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
 * Clase usada para verificar que los m�todos de la clase CupiDeportes est�n correctamente implementados.
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
     * Clase donde se har�n las pruebas.
     */
    private CupiDeportes cupiDeportes;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo sistema CupiDeportes con 2 deportes y 2 deportistas. <br>
     * deporte1: F�tbol, FCF, 2500, futbol.jpg. <br>
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
     * Construye una nuevo sistema CupiDeportes vac�o.
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
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
     * constructor darDeportes <br>
     * <b> Objetivo: </b> Probar inicializaci�n correcta del objeto CupiDeportes<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Inicializaci�n correcta de CupiDeportes<br>
     */
    @Test
    public void testConstructorCupiDeportes( )
    {
        
        ArrayList<Deporte> listaDeportes = cupiDeportes.darDeportes( );
        assertNotNull( "No deber�a ser nula la lista.", listaDeportes );
        assertEquals( "El tama�o de la lista no corresponde.", 2, listaDeportes.size( ) );

        // El primer deporte
        Deporte primero = ( Deporte )listaDeportes.get( 0 );
        assertEquals( "El primer deporte no corresponde.", "F�tbol", primero.darNombre( ) );
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
     * Prueba 2: Verifica el m�todo existeDeporte.<br>
     * <b> M�todos a probar: </b> <br>
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
        assertTrue( "Deber�a existir el deporte.", cupiDeportes.existeDeporte( "F�tbol" ) );

        // 2
        assertFalse( "No deber�a existir el deporte.", cupiDeportes.existeDeporte( "Basket" ) );
    }

    /**
     * Prueba 3: Verifica el m�todo agregarDeporte.<br>
     * <b> M�todos a probar: </b> <br>
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
    	//TODO Parte 4 punto E: Implemente el m�todo seg�n la documentaci�n.  
    }

    /**
     * Prueba 4: Verifica el m�todo agregarDeporte.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarDeporte<br>
     * darDeportes<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto agregarDeporte al lanzar excepci�n<br>
     * <b> Resultados esperados: </b> <br>
     * 1. No agrega, dado que ya exist�a un deporte con el nombre dado.<br>
     */
    @Test
    public void testAgregarDeporteError( )
    {
    	//TODO Parte 4 punto F: Implemente el m�todo seg�n la documentaci�n.  
    }

    /**
     * Prueba 5: Verifica el m�todo eliminarDeporte.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarDeporte<br>
     * existeDeporte<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto eliminarDeporte<br>
     * <b> Resultados esperados: </b> <br>
     * 1. No existe el deporte.<br>
     */
    @Test
    public void testEliminarDeporte( )
    {
        
        cupiDeportes.eliminarDeporte( "F�tbol" );
        assertEquals( "El tama�o de la lista de deportes deber�a ser 1.", 1, cupiDeportes.darDeportes( ).size( ) );
        assertFalse( "No deber�a existir el deporte.", cupiDeportes.existeDeporte( "F�tbol" ) );
    }

    /**
     * Prueba 6: Verifica el m�todo agregarDeportista.<br>
     * <b> M�todos a probar: </b> <br>
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
            cupiDeportes.agregarDeportistaSobresaliente( "F�tbol", "Falcao", 29, "Manchester", 35, "falcao.jpg" );
            Deporte primero = ( Deporte )cupiDeportes.darDeportes( ).get( 0 );
            assertEquals( "El tama�o de los deportistas no coincide.", 2, primero.darDeportistasSobresalientes( ).size( ) );
            Deportista nuevo = ( Deportista )primero.darDeportistasSobresalientes( ).get( 1 );
            assertEquals( "El nombre del deportista nuevo no coincide.", "Falcao", nuevo.darNombre( ) );
        }
        catch( ElementoExisteException e )
        {
            fail( "No deber�a lanzar una excepci�n al agregar el deportista." );
        }

        // 2
        try
        {
            cupiDeportes.agregarDeportistaSobresaliente( "F�tbol", "Falcao", 29, "Manchester", 35, "falcao.jpg" );
            fail( "Deber�a lanzar una excepci�n al agregar el deportista." );
        }
        catch( ElementoExisteException e )
        {
            Deporte primero = ( Deporte )cupiDeportes.darDeportes( ).get( 0 );
            assertEquals( "El tama�o de los deportistas no coincide.", 2, primero.darDeportistasSobresalientes( ).size( ) );
        }
    }

    /**
     * Prueba 7: Verifica el m�todo agregarDeportista.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarDeportista<br>
     * darDeportes<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto agregarDeportista<br>
     * <b> Resultados esperados: </b> <br>
     * 1. No agrega el deportista porque lanza excepci�n.<br>
     */
    @Test
    public void testAgregarDeportistaError( )
    {
        
        // 2
        try
        {
            cupiDeportes.agregarDeportistaSobresaliente( "F�tbol", "James", 23, "Madrid", 39, "james.jpg" );
            fail( "Deber�a lanzar una excepci�n al agregar el deportista." );
        }
        catch( ElementoExisteException e )
        {
            Deporte primero = ( Deporte )cupiDeportes.darDeportes( ).get( 0 );
            assertEquals( "El tama�o de los deportistas no coincide.", 1, primero.darDeportistasSobresalientes( ).size( ) );
        }
    }

    /**
     * Prueba 8: Verifica el m�todo eliminarDeportista.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarDeportista<br>
     * darDeportes<br>
     * <b> Objetivo: </b> Probar funcionamiento correcto eliminarDeportista<br>
     * <b> Resultados esperados: </b> <br>
     * 1. No existe el deportista.<br>
     */
    @Test
    public void testEliminarDeportista( )
    {
        
        cupiDeportes.eliminarDeportistaSobresaliente( "F�tbol", "Falcao" );
        Deporte primero = ( Deporte )cupiDeportes.darDeportes( ).get( 0 );
        assertEquals( "El tama�o de los deportistas no coincide.", 1, primero.darDeportistasSobresalientes( ).size( ) );

    }

    /**
     * Prueba 9: Verifica el m�todo darDeportistaMasTrofeos.<br>
     * <b> M�todos a probar: </b> <br>
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
        
        assertNotNull( "No deber�a ser nulo.", cupiDeportes.darDeportistaMasTrofeos( ) );
        assertEquals( "El nombre del deportista con m�s trofeos no corresponde.", "James", cupiDeportes.darDeportistaMasTrofeos( ).darNombre( ) );

        // 2
        setupEscenario2( );
        assertNull( "Deber�a ser nulo.", cupiDeportes.darDeportistaMasTrofeos( ) );
    }

    /**
     * Prueba 10: Verifica el m�todo darDeportistaMasTrofeos.<br>
     * <b> M�todos a probar: </b> <br>
     * darDeportistaMasTrofeos <br>
     * <b> Objetivo: </b> Probar funcionamiento correcto darDeportistaMasTrofeos<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Cuando hay 2 deportistas que tienen igual n�mero de trofeos y son m�ximos, retorna cualquiera.<br>
     */
    @Test
    public void testDarDeportistaMasTrofeos2( )
    {
        // 1
        
        try
        {
            cupiDeportes.agregarDeportistaSobresaliente( "F�tbol", "Falcao", 39, "Manchester", 35, "falcao.jpg" );
        }
        catch( ElementoExisteException e )
        {
            fail( "No deber�a generar excepci�n." );
        }

        assertNotNull( "No deber�a ser nulo.", cupiDeportes.darDeportistaMasTrofeos( ) );
        assertTrue( "El nombre del deportista con m�s trofeos no corresponde.", cupiDeportes.darDeportistaMasTrofeos( ).darNombre( ).equals( "James" ) || cupiDeportes.darDeportistaMasTrofeos( ).darNombre( ).equals( "Falcao" ) );

    }

    /**
     * Prueba 11: Verifica el m�todo darTotalTrofeos.<br>
     * <b> M�todos a probar: </b> <br>
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
        
        assertEquals( "El n�mero total de trofeos no es el esperado.", 50, cupiDeportes.darTotalTrofeos( ) );

        // 2
        setupEscenario2( );
        assertEquals( "El n�mero total de trofeos no es el esperado.", 0, cupiDeportes.darTotalTrofeos( ) );

    }

    /**
     * Prueba 12: Verifica el m�todo guardar.<br>
     * <b> M�todos a probar: </b> <br>
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
            assertEquals( "No se guard� correctamente CupiDeportes.", 2, temp.darDeportes( ).size( ) );

        }
        catch( PersistenciaException e )
        {
            fail( "No se deber�a generar una excepci�n" );
        }
    }

    /**
     * Prueba 13: Verifica el m�todo actualizarInformacionDeportistas.<br>
     * <b> M�todos a probar: </b> <br>
     * actualizarInformacionDeportistas <br>
     * darDeportes <br>
     * <b> Objetivo: </b> Probar funcionamiento correcto actualizarInformacionDeportistas<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Cuando actualiza correctamente.<br>
     * 2. Cuando hay errores de formato. Cantidad de deportistas mal.<br>
     * 3. Cuando hay errores de formato. No hay datos de deportistas.<br>
     * 4. Cuando hay errores de formato. Falta un dato en el formato.<br>
     * 5. Cuando hay errores de formato. N�meros negativos.<br>
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
            assertEquals( "El lugar de residencia del primer deportista no corresponde.", "Madrid, Espa�a", deport1.darLugarResidencia( ) );
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
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( IOException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( FormatoArchivoException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }

        // 2
        
        File pArchivo2 = new File( "./test/data/datosPruebaError.txt" );
        try
        {
            cupiDeportes.actualizarInformacionDeportistas( pArchivo2 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( FileNotFoundException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( IOException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( FormatoArchivoException e )
        {
            // Deber�a estar aca.
        }

        // 3
        
        File pArchivo3 = new File( "./test/data/datosPruebaError2.txt" );
        try
        {
            cupiDeportes.actualizarInformacionDeportistas( pArchivo3 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( FileNotFoundException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( IOException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( FormatoArchivoException e )
        {
            // Deber�a estar aca.
        }

        // 4
        
        File pArchivo4 = new File( "./test/data/datosPruebaError3.txt" );
        try
        {
            cupiDeportes.actualizarInformacionDeportistas( pArchivo4 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( FileNotFoundException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( IOException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( FormatoArchivoException e )
        {
            // Deber�a estar aca.
        }

        // 5
        
        File pArchivo5 = new File( "./test/data/datosPruebaError4.txt" );
        try
        {
            cupiDeportes.actualizarInformacionDeportistas( pArchivo5 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( FileNotFoundException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( IOException e )
        {
            fail( "No deber�a lanzar esta excepci�n." );
        }
        catch( FormatoArchivoException e )
        {
            // Deber�a estar aca.
        }
    }
}