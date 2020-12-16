/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: fabricaDeCarros
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.fabricaDeCarros.test;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import uniandes.cupi2.fabricaDeCarros.mundo.Calavera;
import uniandes.cupi2.fabricaDeCarros.mundo.DelanteraCamioneta;
import uniandes.cupi2.fabricaDeCarros.mundo.DelanteraCompacto;
import uniandes.cupi2.fabricaDeCarros.mundo.DelanteraSedan;
import uniandes.cupi2.fabricaDeCarros.mundo.FabricaDeCarros;
import uniandes.cupi2.fabricaDeCarros.mundo.IParte;
import uniandes.cupi2.fabricaDeCarros.mundo.Parte;
import uniandes.cupi2.fabricaDeCarros.mundo.Rayo;
import uniandes.cupi2.fabricaDeCarros.mundo.RinesDeLujo;
import uniandes.cupi2.fabricaDeCarros.mundo.RinesEconomicos;
import uniandes.cupi2.fabricaDeCarros.mundo.RinesGamaMedia;
import uniandes.cupi2.fabricaDeCarros.mundo.Teselacion;
import uniandes.cupi2.fabricaDeCarros.mundo.TraseraCamioneta;
import uniandes.cupi2.fabricaDeCarros.mundo.TraseraCompacto;
import uniandes.cupi2.fabricaDeCarros.mundo.TraseraSedan;

/**
 * Clase usada para verificar que los m�todos de la clase FabricaDeCarros est�n correctamente implementados.
 */
public class FabricaDeCarrosTest
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * La fabricaDeCarros donde se har�n las pruebas.
     */
    private FabricaDeCarros fabricaDeCarros;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * <b>Escenario 1 :</b>Crea una nueva f�brica de carros a partir de un archivo.
     */
    @Before
    public void setupEscenario1( )
    {

        fabricaDeCarros = new FabricaDeCarros( );

        try
        {
            fabricaDeCarros.abrir( "./test/data/test.dat" );

        }
        catch( Exception e )
        {
            fail( "No se pudo cargar el archivo: " + e.getMessage( ) + "." );
        }

    }

    /**
     * <b>Escenario 2 :</b>Crea una nueva f�brica de carros vac�a.
     */
    public void setupEscenario2( )
    {
        fabricaDeCarros = new FabricaDeCarros( );

    }

    /**
     * Prueba 1: Prueba el m�todo constructor de la f�brica. <br>
     * <b>M�todos a probar:</b> <br>
     * FabricaDeCarros<br>
     * darPartes<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye la f�brica y se verifica que cada uno de sus atributos se hayan inicializado correctamente.<br>
     */
    @Test
    public void testFabricaDeCarros( )
    {
        setupEscenario2( );
        assertNull( "Deber�a inicializar el nombre del archivo con null.", fabricaDeCarros.darRutaArchivo( ) );
        Collection listaPartes = fabricaDeCarros.darPartes( );
        assertNotNull( "No inicializ� la lista de partes.", listaPartes );
        assertTrue( "Deber�a inicializar una lista vacia.", listaPartes.isEmpty( ) );
    }

    /**
     * Prueba 2: Prueba el m�todo crearParte de los chasis delanteros. <br>
     * <b>M�todos a probar:</b> <br>
     * crearParte<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se le pide a la f�brica que cree tres partes, se verifica que no sean nulas y que sus atributos est�n correctamente inicializados.<br>
     */
    @Test
    public void testCrearParte1( )
    {
        setupEscenario2( );
        int x = 255;
        int y = 300;
        Color colorCarro = Color.green;
        IParte p = fabricaDeCarros.crearParte( DelanteraCamioneta.TIPO, x, y, colorCarro );
        assertNotNull( "No se cre� el chasis, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", DelanteraCamioneta.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorCarro, p.darColor( ) );

        x = 100;
        y = 400;
        colorCarro = Color.yellow;
        p = fabricaDeCarros.crearParte( DelanteraCompacto.TIPO, x, y, colorCarro );
        assertNotNull( "No se cre� el chasis, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", DelanteraCompacto.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorCarro, p.darColor( ) );

        x = 100;
        y = 400;
        colorCarro = Color.orange;
        p = fabricaDeCarros.crearParte( DelanteraSedan.TIPO, x, y, colorCarro );
        assertNotNull( "No se cre� el chasis, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", DelanteraSedan.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorCarro, p.darColor( ) );

    }

    /**
     * Prueba 3: Prueba el m�todo crearParte de los chasis traseros. <br>
     * <b>M�todos a probar:</b> <br>
     * crearParte<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se le pide a la f�brica que cree tres partes, se verifica que no sean nulas y que sus atributos est�n correctamente inicializados.<br>
     */
    @Test
    public void testCrearParte2( )
    {
        setupEscenario2( );
        int x = 0;
        int y = 40;
        Color colorCarro = Color.blue;
        IParte p = fabricaDeCarros.crearParte( TraseraCamioneta.TIPO, x, y, colorCarro );
        assertNotNull( "No se cre� el chasis, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", TraseraCamioneta.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorCarro, p.darColor( ) );

        x = 20;
        y = 100;
        colorCarro = Color.cyan;
        p = fabricaDeCarros.crearParte( TraseraCompacto.TIPO, x, y, colorCarro );
        assertNotNull( "No se cre� el chasis, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", TraseraCompacto.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorCarro, p.darColor( ) );

        x = 300;
        y = 30;
        colorCarro = Color.magenta;
        p = fabricaDeCarros.crearParte( TraseraSedan.TIPO, x, y, colorCarro );
        assertNotNull( "No se cre� el chasis, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", TraseraSedan.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorCarro, p.darColor( ) );
    }

    /**
     * Prueba 4: Prueba el m�todo crearParte para los diferentes est�nciles. <br>
     * <b>M�todos a probar:</b> <br>
     * crearParte<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se le pide a la f�brica que cree tres partes de los diferentes est�nciles, se verifica que no sean nulas y que sus atributos est�n correctamente inicializados.<br>
     */
    @Test
    public void testCrearParte3( )
    {
        setupEscenario2( );
        int x = 500;
        int y = 125;
        Color colorCarro = Color.red;
        IParte p = fabricaDeCarros.crearParte( Teselacion.TIPO, x, y, colorCarro );
        assertNotNull( "No se cre� el est�ncil, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", Teselacion.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorCarro, p.darColor( ) );

        x = 500;
        y = 125;
        colorCarro = Color.red;
        p = fabricaDeCarros.crearParte( Calavera.TIPO, x, y, colorCarro );
        assertNotNull( "No se cre� el est�ncil, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", Calavera.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorCarro, p.darColor( ) );

        x = 10;
        y = 0;
        colorCarro = Color.pink;
        p = fabricaDeCarros.crearParte( Rayo.TIPO, x, y, colorCarro );
        assertNotNull( "No se cre� el est�ncil, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", Rayo.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorCarro, p.darColor( ) );
    }

    /**
     * Prueba 5: Prueba el m�todo crearParte para los diferentes llantas. <br>
     * <b>M�todos a probar:</b> <br>
     * crearParte<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se le pide a la f�brica que cree tres partes de las diferentes llantas, se verifica que no sean nulas y que sus atributos est�n correctamente inicializados.<br>
     */
    @Test
    public void testCrearParte4( )
    {
        setupEscenario2( );
        int x = 700;
        int y = 300;
        Color colorParte = Color.orange;
        IParte p = fabricaDeCarros.crearParte( RinesGamaMedia.TIPO, x, y, colorParte );
        assertNotNull( "No se cre� el llanta, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", RinesGamaMedia.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorParte, p.darColor( ) );

        x = 700;
        y = 300;
        colorParte = Color.white;
        p = fabricaDeCarros.crearParte( RinesDeLujo.TIPO, x, y, colorParte );
        assertNotNull( "No se cre� el llanta, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo.", RinesDeLujo.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x.", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y.", y, p.darY( ) );
        assertEquals( "Error al inicializar color.", colorParte, p.darColor( ) );

        x = 452;
        y = 321;
        colorParte = Color.gray;
        p = fabricaDeCarros.crearParte( RinesEconomicos.TIPO, x, y, colorParte );
        assertNotNull( "No se cre� el llanta, el objeto no deber�a ser nulo.", p );
        assertEquals( "Error al inicializar tipo", RinesEconomicos.TIPO, p.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x", x, p.darX( ) );
        assertEquals( "Error al inicializar coordenada y", y, p.darY( ) );
        assertEquals( "Error al inicializar color", colorParte, p.darColor( ) );
    }

    /**
     * Prueba 6: Prueba el m�todo agregarParte para los diferentes chasis delanteros. <br>
     * <b>M�todos a probar:</b> <br>
     * crearParte<br>
     * agregarParte<br>
     * agregarParte<br>
     * <b> Caso de prueba 1 : <b><br>
     * Para cada chasis delantero, se crea una parte y se agrega. Despu�s se busca y se verifica que exista en la posici�n donde deber�a estar.<br>
     * Adem�s se verifica que la cantidad de partes sea la adecuada.<br>
     */
    @Test
    public void testAgregarParte1( )
    {
        setupEscenario2( );

        Parte p1 = fabricaDeCarros.crearParte( DelanteraCompacto.TIPO, 10, 10, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        DelanteraCompacto pa = ( DelanteraCompacto )fabricaDeCarros.buscarParte( 10, 10 );
        assertNotNull( "No se agreg� correctamente el chasis, la f�brica no encontr� el objeto en la posici�n dada.", pa );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 1 );

        p1 = fabricaDeCarros.crearParte( DelanteraSedan.TIPO, 100, 100, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        DelanteraSedan pg = ( DelanteraSedan )fabricaDeCarros.buscarParte( 100, 100 );
        assertNotNull( "No se agreg� correctamente el chasis, la f�brica no encontr� el objeto en la posici�n dada.", pg );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 2 );

        p1 = fabricaDeCarros.crearParte( DelanteraCamioneta.TIPO, 50, 50, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        DelanteraCamioneta ten = ( DelanteraCamioneta )fabricaDeCarros.buscarParte( 50, 50 );
        assertNotNull( "No se agreg� correctamente el chasis, la f�brica no encontr� el objeto en la posici�n dada.", ten );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 3 );
    }

    /**
     * Prueba 7: Prueba el m�todo agregarParte para los diferentes chasis traseros. <br>
     * <b>M�todos a probar:</b> <br>
     * crearParte<br>
     * agregarParte<br>
     * agregarParte<br>
     * <b> Caso de prueba 1 : <b><br>
     * Para cada chasis trasero, se crea una parte y se agrega. Despu�s se busca y se verifica que exista en la posici�n donde deber�a estar.<br>
     * Adem�s se verifica que la cantidad de partes sea la adecuada.<br>
     */
    @Test
    public void testAgregaParte2( )
    {
        setupEscenario2( );

        Parte p1 = fabricaDeCarros.crearParte( TraseraCamioneta.TIPO, 10, 10, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        TraseraCamioneta cb = ( TraseraCamioneta )fabricaDeCarros.buscarParte( 10, 10 );
        assertNotNull( "No se agreg� correctamente el chasis, la f�brica no encontr� el objeto en la posici�n dada.", cb );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 1 );

        p1 = fabricaDeCarros.crearParte( TraseraCompacto.TIPO, 100, 100, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        TraseraCompacto co = ( TraseraCompacto )fabricaDeCarros.buscarParte( 100, 100 );
        assertNotNull( "No se agreg� correctamente el chasis, la f�brica no encontr� el objeto en la posici�n dada.", co );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 2 );

        p1 = fabricaDeCarros.crearParte( TraseraSedan.TIPO, 50, 50, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        TraseraSedan ct = ( TraseraSedan )fabricaDeCarros.buscarParte( 50, 50 );
        assertNotNull( "No se agreg� correctamente el chasis, la f�brica no encontr� el objeto en la posici�n dada.", ct );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 3 );
    }

    /**
     * Prueba 8: Prueba el m�todo agregarParte para los diferentes est�nciles. <br>
     * <b>M�todos a probar:</b> <br>
     * crearParte<br>
     * agregarParte<br>
     * agregarParte<br>
     * <b> Caso de prueba 1 : <b><br>
     * Para cada est�ncil, se crea una parte y se agrega. Despu�s se busca y se verifica que exista en la posici�n donde deber�a estar.<br>
     * Adem�s se verifica que la cantidad de partes sea la adecuada.<br>
     */
    @Test
    public void testAgregarParte3( )
    {
        setupEscenario2( );

        Parte p1 = fabricaDeCarros.crearParte( Teselacion.TIPO, 10, 10, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        Teselacion mo = ( Teselacion )fabricaDeCarros.buscarParte( 10, 10 );
        assertNotNull( "No se agreg� correctamente el est�ncil, la f�brica no encontr� el objeto en la posici�n dada.", mo );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 1 );

        p1 = fabricaDeCarros.crearParte( Calavera.TIPO, 100, 100, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        Calavera bo = ( Calavera )fabricaDeCarros.buscarParte( 100, 100 );
        assertNotNull( "No se agreg� correctamente el est�ncil, la f�brica no encontr� el objeto en la posici�n dada.", bo );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 2 );

        p1 = fabricaDeCarros.crearParte( Rayo.TIPO, 50, 50, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        Rayo oa = ( Rayo )fabricaDeCarros.buscarParte( 50, 50 );
        assertNotNull( "No se agreg� correctamente el est�ncil, la f�brica no encontr� el objeto en la posici�n dada.", oa );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 3 );
    }

    /**
     * Prueba 9: Prueba el m�todo agregarParte para las diferentes llantas. <br>
     * <b>M�todos a probar:</b> <br>
     * crearParte<br>
     * agregarParte<br>
     * agregarParte<br>
     * <b> Caso de prueba 1 : <b><br>
     * Para cada llanta, se crea una parte y se agrega. Despu�s se busca y se verifica que exista en la posici�n donde deber�a estar.<br>
     * Adem�s se verifica que la cantidad de partes sea la adecuada.<br>
     */
    @Test
    public void testAgregarParte4( )
    {
        setupEscenario2( );

        Parte p1 = fabricaDeCarros.crearParte( RinesGamaMedia.TIPO, 10, 10, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        RinesGamaMedia da = ( RinesGamaMedia )fabricaDeCarros.buscarParte( 10, 10 );
        assertNotNull( "No se agreg� correctamente el llanta, la f�brica no encontr� el objeto en la posici�n dada.", da );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 1 );

        p1 = fabricaDeCarros.crearParte( RinesDeLujo.TIPO, 100, 100, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        RinesDeLujo dc = ( RinesDeLujo )fabricaDeCarros.buscarParte( 100, 100 );
        assertNotNull( "No se agreg� correctamente el llanta, la f�brica no encontr� el objeto en la posici�n dada.", dc );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 2 );

        p1 = fabricaDeCarros.crearParte( RinesEconomicos.TIPO, 50, 50, Color.RED );
        fabricaDeCarros.agregarParte( p1 );
        RinesEconomicos dr = ( RinesEconomicos )fabricaDeCarros.buscarParte( 50, 50 );
        assertNotNull( "No se agreg� correctamente el llanta, la f�brica no encontr� el objeto en la posici�n dada.", dr );
        assertEquals( "Error al agregar la parte, el n�mero de partes que deben haber en la f�brica es incorrecto.", fabricaDeCarros.darPartes( ).size( ), 3 );
    }

    /**
     * Prueba 10: Prueba el m�todo reiniciar. <br>
     * <b>M�todos a probar:</b> <br>
     * reiniciar<br>
     * crearParte<br>
     * agregarParte<br>
     * darPartes<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se reinicia una f�brica vac�a y se verifica que el numero de partes sea cero.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se agrega una parte a la f�brica y se verifica que el n�mero de partes sea cero.<br>
     */
    @Test
    public void testReiniciar( )
    {
        setupEscenario2( );
        // Reiniciar una f�brica vac�a.
        fabricaDeCarros.reiniciar( );
        assertEquals( "No se reinici� la f�brica correctamente, la lista de partes deber�a estar vac�a.", 0, fabricaDeCarros.darPartes( ).size( ) );

        // Reiniciar una f�brica con partes.
        Parte p1 = fabricaDeCarros.crearParte( TraseraSedan.TIPO, 0, 0, Color.green );
        fabricaDeCarros.agregarParte( p1 );

        Parte p2 = fabricaDeCarros.crearParte( Rayo.TIPO, 12, 12, Color.red );
        fabricaDeCarros.agregarParte( p2 );
        fabricaDeCarros.reiniciar( );

        assertEquals( "No se reinici� la f�brica correctamente, la lista de partes deber�a estar vac�a.", 0, fabricaDeCarros.darPartes( ).size( ) );

    }

    /**
     * Prueba 11: Prueba el m�todo abrir. <br>
     * <b>M�todos a probar:</b> <br>
     * abrir<br>
     * <b> Caso de prueba 1 : <b><br>
     * En una f�brica vac�a, se carga un archivo. Seguidamente se verifica que cada objeto en la f�brica corresponda a los del archivo.<br>
     */
    @Test
    public void testAbrir1( )
    {
        setupEscenario2( );

        try
        {
            fabricaDeCarros.abrir( "./test/data/test.dat" );
            assertEquals( "Error al abrir el archivo, la cantidad de partes actualmente no corresponde con la cantidad esperada.", 4, fabricaDeCarros.darPartes( ).size( ) );

            Iterator<IParte> it = fabricaDeCarros.darPartes( ).iterator( );
            IParte p = it.next( );
            assertEquals( "Error al abrir el archivo, el tipo de la primera parte no corresponde al esperado.", TraseraCamioneta.TIPO, p.darTipo( ) );
            assertEquals( "Error al abrir el archivo, la coordenada 'x' de la primera parte no corresponde al esperado.", 0, p.darX( ) );
            assertEquals( "Error al abrir el archivo, la coordenada 'y' de la primera parte no corresponde al esperado.", 290, p.darY( ) );
            assertEquals( "Error al abrir el archivo, el color de la primera parte no corresponde al esperado.", new Color( -3620889 ), p.darColor( ));

            p = it.next( );
            assertEquals( "Error al abrir el archivo, el tipo de la segunda parte no corresponde al esperado.", Teselacion.TIPO, p.darTipo( ) );
            assertEquals( "Error al abrir el archivo, la coordenada 'x' de la segunda parte no corresponde al esperado.", 9, p.darX( ) );
            assertEquals( "Error al abrir el archivo, la coordenada 'y' de la segunda parte no corresponde al esperado.", 376, p.darY( ) );
            assertEquals( "Error al abrir el archivo, el color de la segunda parte no corresponde al esperado.", new Color( -3620889 ), p.darColor( ));

            p = it.next( );
            assertEquals( "Error al abrir el archivo, el tipo de la tercera parte no corresponde al esperado.", RinesGamaMedia.TIPO, p.darTipo( ) );
            assertEquals( "Error al abrir el archivo, la coordenada 'x' de la tercera parte no corresponde al esperado.", 50, p.darX( ) );
            assertEquals( "Error al abrir el archivo, la coordenada 'y' de la tercera parte no corresponde al esperado.", 285, p.darY( ) );
            assertEquals( "Error al abrir el archivo, el color de la tercera parte no corresponde al esperado.", new Color( -3620889 ), p.darColor( ));

            p = it.next( );
            assertEquals( "Error al abrir el archivo, el tipo de la cuarta parte no corresponde al esperado.", Calavera.TIPO, p.darTipo( ) );
            assertEquals( "Error al abrir el archivo, la coordenada 'x' de la cuarta parte no corresponde al esperado.", 78, p.darX( ) );
            assertEquals( "Error al abrir el archivo, la coordenada 'y' de la cuarta parte no corresponde al esperado.", 396, p.darY( ) );
            assertEquals( "Error al abrir el archivo, el color de la cuarta parte no corresponde al esperado.", new Color( -3368449 ), p.darColor( ));

        }
        catch( Exception e1 )
        {
            fail( "No deber�a generarse el error: " + e1.getMessage( ) + ".");
        }

    }

    /**
     * Prueba 12: Prueba el m�todo abrir. <br>
     * <b>M�todos a probar:</b> <br>
     * abrir<br>
     * <b> Caso de prueba 1 : <b><br>
     * En una f�brica vac�a, se intenta leer un archivo con problemas de formato en la l�nea correspondiente al n�mero de partes.<br>
     * <b> Caso de prueba 2 : <b><br>
     * En una f�brica vac�a, se intenta leer un archivo con problemas de formato en la l�nea correspondiente al tipo de las partes.<br>
     * <b> Caso de prueba 3 : <b><br>
     * En una f�brica vac�a, se intenta leer un archivo con problemas de formato en la l�nea correspondiente a la posici�n de las partes.<br>
     * <b> Caso de prueba 4 : <b><br>
     * En una f�brica vac�a, se intenta leer un archivo con problemas de formato en la l�nea correspondiente al color de las partes.<br>
     */
    @Test
    public void testAbrir2( )
    {
        setupEscenario2( );

        try
        {
            fabricaDeCarros.abrir( "./test/data/testMalFormato1.dat" );
            fail( "El archivo tiene formato incorrecto en el n�mero de partes, deber�a fallar." );
        }
        catch( Exception e1 )
        {
            // Debe generar error.;
        }

        try
        {
            fabricaDeCarros.abrir( "./test/data/testMalFormato2.dat" );
            fail( "El archivo tiene formato incorrecto en el tipo de parte, deber�a fallar." );
        }
        catch( Exception e1 )
        {
            // Debe generar error.;
        }

        try
        {
            fabricaDeCarros.abrir( "./test/data/testMalFormato3.dat" );
            fail( "El archivo tiene formato incorrecto en los puntos de las posiciones de las partes, deber�a fallar." );
        }
        catch( Exception e1 )
        {
            // Debe generar error.;
        }

        try
        {
            fabricaDeCarros.abrir( "./test/data/testMalFormato4.dat" );
            fail( "El archivo tiene formato incorrecto en el color de la parte, deber�a fallar." );
        }
        catch( Exception e1 )
        {
            // Debe generar error.;
        }

    }

    /**
     * Prueba 13: Prueba el m�todo guardar con una ruta de archivo como par�metro. <br>
     * <b>M�todos a probar:</b> <br>
     * eliminarParte<br>
     * buscarParte<br>
     * abrir<br>
     * guardar<br>
     * <b> Caso de prueba 1 : <b><br>
     * De una f�brica, se elimina una parte, esta se guarda en un archivo. De este archivo se vuelve a cargar la f�brica y se verifica que la parte no exista<br>
     * <b> Caso de prueba 2 : <b><br>
     * De una f�brica, se elimina una parte, esta se guarda en un archivo. De este archivo se vuelve a cargar la f�brica y se verifica que las otras partes existan<br>
     * <b> Caso de prueba 3 : <b><br>
     * Se trata de guardar en un directorio inexistente para simular una excepci�n IO<br>
     */
    @Test
    public void testGuardar1( )
    {
    
        try
        {
            fabricaDeCarros.eliminarParte( 2, 295 );

            fabricaDeCarros.guardar( "./test/data/test3.dat" );
            fabricaDeCarros.abrir( "./test/data/test3.dat" );

            IParte p = fabricaDeCarros.buscarParte( 1, 291 );

            assertNull( "Archivo guardado incorrectamente. La parte en la posici�n buscada no deber�a existir.", p );
            assertEquals( "Archivo guardado incorrectamente, la cantidad de partes actualmente no corersponde con la esperada.", 3, fabricaDeCarros.darPartes( ).size( ) );

            p = fabricaDeCarros.buscarParte( 10, 380 );
            assertNotNull( "Archivo guardado incorrectamente. No deber�a existir ninguna parte en la posici�n dada.", p );
            
            
            try
            {
                fabricaDeCarros.guardar( "./test/data/carpetaFalsa/test3.dat" );
                fail("Debe�a presentar una excepci�n IO");
            }
            catch( IOException e )
            {
                //
            }

        }
        catch( Exception e1 )
        {
            fail( "No deber�a generarse el error: " + e1.getMessage( ) +".");
        }
    }

    /**
     * Prueba 14: Prueba el m�todo guardar. <br>
     * <b>M�todos a probar:</b> <br>
     * guardar<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se toma una f�brica y se guarda con dos rutas en dos archivos diferentes. Al hacer esto el atributo de ruta archivo de la f�brica debi� actualizarse a la �ltima de las
     * rutas.<br>
     * Este archivo se elimina, y se utiliza el m�todo guardar que no recibe par�metro. Se verifica que el primer archivo y el �ltimo sean exactamente igual en contenido.
     */
    @Test
    public void testGuardar2( )
    {
        

        try
        {
            fabricaDeCarros.guardar( "./test/data/testGuardar3.dat" );
            fabricaDeCarros.guardar( "./test/data/test3.dat" );
            File f = new File( "./test/data/test3.dat" );
            f.delete( );
            fabricaDeCarros.guardar( );

            BufferedReader br1 = new BufferedReader( new FileReader( "./test/data/testGuardar3.dat" ) );
            BufferedReader br2 = new BufferedReader( new FileReader( "./test/data/test3.dat" ) );

            for( int i = 0; i < 13; i++ )
            {
                assertEquals( "Archivo guardado incorrectamente. El archivo guardado con el m�todo guardar() no es igual al original.", br1.readLine( ), br2.readLine( ) );
            }
            br1.close( );
            br2.close( );
        }
        catch( Exception e1 )
        {
            fail( "No deber�a generarse el error: " + e1.getMessage( )  + ".");
        }
    }

    /**
     * Prueba 15: Prueba el m�todo eliminarParte para los diferentes chasis delanteros. <br>
     * <b>M�todos a probar:</b> <br>
     * eliminarParte<br>
     * crearParte<br>
     * agregarParte<br>
     * buscarParte<br>
     * darPartes<br>
     * <b> Caso de prueba 1 : <b><br>
     * En una f�brica vac�a se agrega uno de cada uno de los tipos de chasis delanteros,se verifica que la parte existe en la f�brica, luego se elimina y se verifica que la parte no exista.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se verifica que al eliminar elementos de la f�brica, el n�mero de partes disminuya en 1.<br>
     * <b> Caso de prueba 3 : <b><br>
     * Se verifica que al intentar elementos de la f�brica que no existen, el n�mero de partes se mantenga.<br>
     */
    @Test
    public void testEliminarParte1( )
    {
        setupEscenario2( );
        int numPartes = fabricaDeCarros.darPartes( ).size( );
        numPartes++;
        IParte p = fabricaDeCarros.crearParte( DelanteraCamioneta.TIPO, 0, 30, null );
        fabricaDeCarros.agregarParte( p );
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar el chasis, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 0, 30 ) );
        fabricaDeCarros.eliminarParte( 0, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        DelanteraCamioneta co = ( DelanteraCamioneta )fabricaDeCarros.buscarParte( 0, 30 );
        assertNull( "No elimin� el chasis correctamente.", co );

        p = fabricaDeCarros.crearParte( DelanteraCompacto.TIPO, 200, 30, null );
        numPartes++;
        fabricaDeCarros.agregarParte( p );
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar el chasis, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 200, 30 ) );
        fabricaDeCarros.eliminarParte( 200, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        DelanteraCompacto ct = ( DelanteraCompacto )fabricaDeCarros.buscarParte( 200, 30 );
        assertNull( "No elimin� el chasis correctamente.", ct );

        p = fabricaDeCarros.crearParte( DelanteraSedan.TIPO, 400, 30, null );
        numPartes++;
        fabricaDeCarros.agregarParte( p );
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar el chasis, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 400, 30 ) );
        fabricaDeCarros.eliminarParte( 400, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        DelanteraSedan cc = ( DelanteraSedan )fabricaDeCarros.buscarParte( 400, 30 );
        assertNull( "No elimin� el chasis correctamente.", cc );
        
        
        fabricaDeCarros.eliminarParte( 400, 30 );
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );

    }

    /**
     * Prueba 16: Prueba el m�todo eliminarParte para los diferentes chasis traseros. <br>
     * <b>M�todos a probar:</b> <br>
     * eliminarParte<br>
     * crearParte<br>
     * agregarParte<br>
     * buscarParte<br>
     * darPartes<br>
     * <b> Caso de prueba 1 : <b><br>
     * En una f�brica vac�a se agrega uno de cada uno de los tipos de chasis traseros,se verifica que la parte existe en la f�brica, luego se elimina y se verifica que la parte no exista.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se verifica que al eliminar elementos de la f�brica, el n�mero de partes disminuya.<br>
     * <b> Caso de prueba 3 : <b><br>
     * Se verifica que al intentar elementos de la f�brica que no existen, el n�mero de partes se mantenga.<br>
     */
    @Test
    public void testEliminarParte2( )
    {
        setupEscenario2( );

        int numPartes = fabricaDeCarros.darPartes( ).size( );
        
        IParte p = fabricaDeCarros.crearParte( TraseraCompacto.TIPO, 0, 30, null );
        numPartes++;
        fabricaDeCarros.agregarParte( p );
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar el chasis, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 0, 30 ) );
        fabricaDeCarros.eliminarParte( 0, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        TraseraCompacto co = ( TraseraCompacto )fabricaDeCarros.buscarParte( 0, 30 );
        assertNull( "No elimin� el chasis correctamente.", co );

        p = fabricaDeCarros.crearParte( TraseraSedan.TIPO, 200, 30, null );
        numPartes++;
        fabricaDeCarros.agregarParte( p );
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar el chasis, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 200, 30 ) );
        fabricaDeCarros.eliminarParte( 200, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        TraseraSedan ct = ( TraseraSedan )fabricaDeCarros.buscarParte( 200, 30 );
        assertNull( "No elimin� el chasis correctamente.", ct );

        p = fabricaDeCarros.crearParte( TraseraCamioneta.TIPO, 400, 30, null );
        numPartes++;
        fabricaDeCarros.agregarParte( p );
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar el chasis, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 400, 30 ) );
        fabricaDeCarros.eliminarParte( 400, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        TraseraCamioneta cc = ( TraseraCamioneta )fabricaDeCarros.buscarParte( 400, 30 );
        assertNull( "No elimin� el chasis correctamente.", cc );
        assertEquals( "Error eliminando parte.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        
        fabricaDeCarros.eliminarParte( 400, 30 );
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
    }

    /**
     * Prueba 17: Prueba el m�todo eliminarParte para los diferentes est�nciles. <br>
     * <b>M�todos a probar:</b> <br>
     * eliminarParte<br>
     * crearParte<br>
     * agregarParte<br>
     * buscarParte<br>
     * darPartes<br>
     * <b> Caso de prueba 1 : <b><br>
     * En una f�brica vac�a se agrega uno de cada uno de los tipos de est�nciles,se verifica que la parte existe en la f�brica, luego se elimina y se verifica que la parte no exista.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se verifica que al eliminar elementos de la f�brica, el n�mero de partes disminuya.<br>
     * <b> Caso de prueba 3 : <b><br>
     * Se verifica que al intentar elementos de la f�brica que no existen, el n�mero de partes se mantenga.<br>
     */
    @Test
    public void testEliminarParte3( )
    {
        setupEscenario2( );

        int numPartes = fabricaDeCarros.darPartes( ).size( );
        
        IParte p = fabricaDeCarros.crearParte( Teselacion.TIPO, 0, 30, null );
        fabricaDeCarros.agregarParte( p );
        numPartes++;
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar el est�ncil, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 0, 30 ) );
        fabricaDeCarros.eliminarParte( 0, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        Teselacion co = ( Teselacion )fabricaDeCarros.buscarParte( 0, 30 );
        assertNull( "No elimin� el est�ncil correctamente.", co );

        p = fabricaDeCarros.crearParte( Calavera.TIPO, 200, 30, null );
        fabricaDeCarros.agregarParte( p );
        numPartes++;
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar el est�ncil, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 200, 30 ) );
        fabricaDeCarros.eliminarParte( 200, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        Calavera ct = ( Calavera )fabricaDeCarros.buscarParte( 200, 30 );
        assertNull( "No elimin� el est�ncil correctamente.", ct );

        p = fabricaDeCarros.crearParte( Rayo.TIPO, 400, 30, null );
        fabricaDeCarros.agregarParte( p );
        numPartes++;
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar el est�ncil, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 400, 30 ) );
        fabricaDeCarros.eliminarParte( 400, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        Rayo cc = ( Rayo )fabricaDeCarros.buscarParte( 400, 30 );
        assertNull( "No elimin� el est�ncil correctamente.", cc );

        fabricaDeCarros.eliminarParte( 400, 30 );
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
    }

    /**
     * Prueba 18: Prueba el m�todo eliminarParte para las diferentes llantas. <br>
     * <b>M�todos a probar:</b> <br>
     * eliminarParte<br>
     * crearParte<br>
     * agregarParte<br>
     * buscarParte<br>
     * darPartes<br>
     * <b> Caso de prueba 1 : <b><br>
     * En una f�brica vac�a se agrega uno de cada uno de los tipos de llantas,se verifica que la parte existe en la f�brica, luego se elimina y se verifica que la parte no exista.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se verifica que al eliminar elementos de la f�brica, el n�mero de partes disminuya.<br>
     * <b> Caso de prueba 3 : <b><br>
     * Se verifica que al intentar elementos de la f�brica que no existen, el n�mero de partes se mantenga.<br>
     */
    @Test
    public void testEliminarParte4( )
    {
        setupEscenario2( );
        int numPartes = fabricaDeCarros.darPartes( ).size( );
        
        IParte p = fabricaDeCarros.crearParte( RinesGamaMedia.TIPO, 0, 30, null );
        fabricaDeCarros.agregarParte( p );
        numPartes++;
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar la llanta, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 0, 30 ) );
        fabricaDeCarros.eliminarParte( 0, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        RinesGamaMedia dr = ( RinesGamaMedia )fabricaDeCarros.buscarParte( 0, 30 );
        assertNull( "No elimin� la llanta correctamente.", dr );

        p = fabricaDeCarros.crearParte( RinesDeLujo.TIPO, 200, 30, null );
        fabricaDeCarros.agregarParte( p );
        numPartes++;
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar la llanta, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 200, 30 ) );
        fabricaDeCarros.eliminarParte( 200, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        RinesDeLujo da = ( RinesDeLujo )fabricaDeCarros.buscarParte( 200, 30 );
        assertNull( "No elimin� la llanta correctamente.", da );

        p = fabricaDeCarros.crearParte( RinesEconomicos.TIPO, 400, 30, null );
        fabricaDeCarros.agregarParte( p );
        numPartes++;
        assertEquals( "Error agregando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        assertNotNull( "Error al agregar la llanta, no se encontr� el objeto en la posici�n esperada.", fabricaDeCarros.buscarParte( 400, 30 ) );
        fabricaDeCarros.eliminarParte( 400, 30 );
        numPartes--;
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
        RinesEconomicos dc = ( RinesEconomicos )fabricaDeCarros.buscarParte( 400, 30 );
        assertNull( "No elimin� la llanta correctamente.", dc );
        assertEquals( "Error eliminando parte.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
      
        fabricaDeCarros.eliminarParte( 400, 30 );
        assertEquals( "Error eliminando parte, el n�mero de partes no corresponde.", numPartes, fabricaDeCarros.darPartes( ).size( ) );
    }

    /**
     * Prueba 19: Prueba el m�todo cambiarPosicionParte. <br>
     * <b>M�todos a probar:</b> <br>
     * cambiarPosicionParte<br>
     * buscarParte<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se cambia de posici�n una parte y se verifica que ya no exista en la posici�n original.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se cambia de posici�n una parte y se verifica que exista en la nueva posici�n.<br>
     */
    @Test
    public void testCambiarPosicionParte( )
    {
        
        try
        {

            fabricaDeCarros.cambiarPosicionParte( 0, 290, 300, 300 );
            IParte p = fabricaDeCarros.buscarParte( 0, 290 );
            assertNull( "No cambi� la posici�n de la parte correctamente.", p );

            TraseraCamioneta cc = ( TraseraCamioneta )fabricaDeCarros.buscarParte( 300, 300 );
            assertNotNull( "No cambi� la posici�n de la parte correctamente.", cc );
        }
        catch( Exception e )
        {
            fail( "No deber�a fallar" );
        }
    }

    
    /**
     * Prueba 20: Prueba el m�todo buscarParte. <br>
     * <b>M�todos a probar:</b> <br>
     * buscarParte<br>
     * <b> Caso de prueba 1 : <b><br>
     * En una f�brica con varias partes, se verifica que al buscar cada parte en sus respectivas posiciones, la f�brica devuelva elementos no nulos.<br>
     */
    @Test
    public void testBuscarParte1( )
    {
        
        try
        {
            Calavera ca = ( Calavera )fabricaDeCarros.buscarParte( 80, 400 );
            assertNotNull( "Deber�a encontrar la parte en la posici�n dada.", ca );

            ca = ( Calavera )fabricaDeCarros.buscarParte( 85, 411 );
            assertNotNull( "Deber�a encontrar la parte en la posici�n dada.", ca );

            RinesGamaMedia da = ( RinesGamaMedia )fabricaDeCarros.buscarParte( 60, 285 );
            assertNotNull( "Deber�a encontrar la parte en la posici�n dada.", da );

            da = ( RinesGamaMedia )fabricaDeCarros.buscarParte( 65, 292 );
            assertNotNull( "Deber�a encontrar la parte en la posici�n dada.", da );

            TraseraCamioneta cc = ( TraseraCamioneta )fabricaDeCarros.buscarParte( 30, 290 );
            assertNotNull( "Deber�a encontrar la parte en la posici�n dada.", cc );

            cc = ( TraseraCamioneta )fabricaDeCarros.buscarParte( 35, 300 );
            assertNotNull( "Deber�a encontrar la parte en la posici�n dada.", cc );

        }
        catch( Exception e )
        {
            fail( "No deber�a fallar (" + e.getMessage( ) + ")" );
        }
    }

    
    /**
     * Prueba 21: Prueba el m�todo buscarParte. <br>
     * <b>M�todos a probar:</b> <br>
     * buscarParte<br>
     * <b> Caso de prueba 1 : <b><br>
     * En una f�brica con varias partes, se verifica que al buscar partes donde no hay nada, la f�brica devuelva elementos nulos.<br>
     */
    @Test
    public void testBuscarParte2( )
    {
        
        try
        {
            Teselacion mo = ( Teselacion )fabricaDeCarros.buscarParte( 0, 100 );
            assertNull( "No deber�a encontrar la parte en la posici�n dada.", mo );

            RinesGamaMedia dr = ( RinesGamaMedia )fabricaDeCarros.buscarParte( 200, 555 );
            assertNull( "No deber�a encontrar la parte en la posici�n dada.", dr );

            TraseraSedan ct = ( TraseraSedan )fabricaDeCarros.buscarParte( 430, 2 );
            assertNull( "No deber�a encontrar la parte en la posici�n dada.", ct );
        }
        catch( Exception e )
        {
            fail( "No deber�a fallar (" + e.getMessage( ) + ")" );
        }
    }
}