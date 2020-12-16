/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: fabricaDeCarros
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.fabricaDeCarros.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import uniandes.cupi2.fabricaDeCarros.mundo.DelanteraCamioneta;
import uniandes.cupi2.fabricaDeCarros.mundo.IParte;
import uniandes.cupi2.fabricaDeCarros.mundo.Parte;
import uniandes.cupi2.fabricaDeCarros.mundo.Rayo;
import uniandes.cupi2.fabricaDeCarros.mundo.RinesDeLujo;

/**
 * Clase usada para verificar que los métodos de la clase Parte estén correctamente implementados.
 */
public class ParteTest
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * La parte donde se harán las pruebas.
     */
    private IParte parte;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * <b>Escenario 1 :</b> Construye una nueva parte de tipo DelanteraCamioneta.
     */
    @Before
    public void setupEscenario1( )
    {
        parte = new DelanteraCamioneta( 50, 200, Color.green );

    }

    /**
     * <b>Escenario 2 :</b>Construye una nueva parte de tipo Rayo.
     */
    public void setupEscenario2( )
    {
        parte = new Rayo( 350, 221, Color.orange );
    }

    /**
     * <b>Escenario 3 :</b> Construye una nueva parte de tipo Llanta2.
     */
    public void setupEscenario3( )
    {
        parte = new RinesDeLujo( 30, 452, Color.yellow );
    }

    /**
     * Prueba 1: Prueba el método constructor de la clase DelanteraCamioneta a partir de un archivo. <br>
     * <b>Métodos a probar:</b> <br>
     * DelanteraCamioneta<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darAlto<br>
     * darAncho <br>
     * <b> Caso de prueba 1: <b><br>
     * Se construye un chasis leyendo un archivo y se verifica que se haya creado, y que sus atributos sean los correctos.
     */
    @Test
    public void testChasis1( )
    {
        try
        {
            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testChasis.dat" ) );

            br.readLine( ); // Tipo

            parte = new DelanteraCamioneta( br );
            // Prueba de constructor en atributo tipo.
            assertEquals( "La parte se cargó incorrectamente, el tipo de la parte no es el esperado.", "DelanteraCamioneta", parte.darTipo( ) );
            // Prueba de constructor en atributo x.
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'x' de la parte no es la esperada.", 0, parte.darX( ) );
            // Prueba de constructor en atributo y.
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'y' de la parte no es la esperada.", 290, parte.darY( ) );
            // Prueba de constructor en atributo color.
            assertEquals( "La parte se cargó incorrectamente, el color de la parte no es la esperado.", new Color( -3620889 ), parte.darColor( ) );
            // Prueba de constructor en atributo alto.
            assertEquals( "La parte se creó incorrectamente, el alto de la parte no es la eperado.", 200, parte.darAlto( ) );
            // Prueba de constructor en atributo ancho.
            assertEquals( "La parte se creó incorrectamente, el ancho de la parte no es la esperado.", 320, parte.darAncho( ) );

            br.close( );
        }
        catch( FileNotFoundException e )
        {
            fail( "No se debe generar el error: " + e.getMessage( ) );
        }
        catch( Exception e1 )
        {
            fail( "No se debe generar el error: " + e1.getMessage( ) );
        }
    }

    /**
     * Prueba 2: Prueba el método constructor de la clase DelanteraCamioneta. <br>
     * <b>Métodos a probar:</b> <br>
     * DelanteraCamioneta<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darAlto<br>
     * darAncho <br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye un chasis se verifica que se haya creado, y que sus atributos sean los correctos.
     */
    @Test
    public void testChasis2( )
    {
        
        // Prueba de constructor en atributo tipo.
        assertEquals( "La parte se creó incorrectamente, el tipo de la parte no es el esperado.", "DelanteraCamioneta", parte.darTipo( ) );
        // Prueba de constructor en atributo x.
        assertEquals( "La parte se creó incorrectamente, la coordenada 'x' de la parte no es la esperada.", 50, parte.darX( ) );
        // Prueba de constructor en atributo y.
        assertEquals( "La parte se creó incorrectamente, la coordenada 'y' de la parte no es la esperada.", 200, parte.darY( ) );
        // Prueba de constructor en atributo color.
        assertEquals( "La parte se creó incorrectamente, el color de la parte no es el esperado.", Color.green, parte.darColor( ) );
        // Prueba de constructor en atributo alto.
        assertEquals( "La parte se creó incorrectamente, el alto de la parte no es el esperado.", 200, parte.darAlto( ) );
        // Prueba de constructor en atributo ancho.
        assertEquals( "La parte se creó incorrectamente, el ancho de la parte no es el esperado.", 320, parte.darAncho( ) );
    }

    /**
     * Prueba 3: Prueba el método constructor de la clase Rayo a partir de un archivo. <br>
     * <b>Métodos a probar:</b> <br>
     * Rayo<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darAlto<br>
     * darAncho <br>
     * <b> Caso de prueba 1: <b><br>
     * Se construye un esténcil Rayo leyendo un archivo y se verifica que se haya creado, y que sus atributos sean los correctos.
     */
    @Test
    public void testEstencil1( )
    {
        try
        {
            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testStencil.dat" ) );

            br.readLine( ); // Tipo

            parte = new Rayo( br );
            // Prueba de constructor en atributo tipo.
            assertEquals( "La parte se cargó incorrectamente, el tipo de la parte no es el esperado", "Rayo", parte.darTipo( ) );
            // Prueba de constructor en atributo x.
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'x' de la parte no es la esperada.", parte.darX( ), 9 );
            // Prueba de constructor en atributo y.
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'y' de la parte no es la esperada.", parte.darY( ), 376 );
            // Prueba de constructor en atributo color.
            assertEquals( "La parte se cargó incorrectamente, el color de la parte no es el esperado.", new Color( -3620889 ), parte.darColor( ) );
            // Prueba de constructor en atributo alto.
            assertEquals( "La parte se creó incorrectamente, el alto de la parte no es el esperado.", 50, parte.darAlto( ) );
            // Prueba de constructor en atributo ancho.
            assertEquals( "La parte se creó incorrectamente, el ancho de la parte no es el esperado.", 100, parte.darAncho( ) );

            br.close( );
        }
        catch( FileNotFoundException e )
        {
            fail( "No se debe generar el error: " + e.getMessage( ) );
        }
        catch( Exception e1 )
        {
            fail( "No se debe generar el error: " + e1.getMessage( ) );
        }
    }

    /**
     * Prueba 4: Prueba el método constructor de la clase Rayo. <br>
     * <b>Métodos a probar:</b> <br>
     * Rayo<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darAlto<br>
     * darAncho <br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye un esténcil Rayo se verifica que se haya creado, y que sus atributos sean los correctos.
     */
    @Test
    public void testEstencil2( )
    {
        setupEscenario2( );
        // Prueba de constructor en atributo tipo.
        assertEquals( "La parte se creó incorrectamente, el tipo de la parte no es el esperado.", "Rayo", parte.darTipo( ) );
        // Prueba de constructor en atributo x.
        assertEquals( "La parte se creó incorrectamente, la coordenada 'x' de la parte no es la esperada.", 350, parte.darX( ) );
        // Prueba de constructor en atributo y.
        assertEquals( "La parte se creó incorrectamente, la coordenada 'y' de la parte no es la esperada.", 221, parte.darY( ) );
        // Prueba de constructor en atributo color.
        assertEquals( "La parte se creó incorrectamente, el color de la parte no es el esperado.", Color.orange, parte.darColor( ) );
        // Prueba de constructor en atributo alto.
        assertEquals( "La parte se creó incorrectamente, el alto de la parte no es el esperado.", 50, parte.darAlto( ) );
        // Prueba de constructor en atributo ancho.
        assertEquals( "La parte se creó incorrectamente, el ancho de la parte no es el esperado.", 100, parte.darAncho( ) );
    }

    /**
     * Prueba 5: Prueba el método constructor de la clase RinesDeLujo a partir de un archivo. <br>
     * <b>Métodos a probar:</b> <br>
     * RinesDeLujo<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darAlto<br>
     * darAncho <br>
     * <b> Caso de prueba 1: <b><br>
     * Se construye una llanta RinesDeLujo leyendo un archivo y se verifica que se haya creado, y que sus atributos sean los correctos.
     */
    @Test
    public void testLlanta1( )
    {
        try
        {
            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testLlanta.dat" ) );

            br.readLine( ); // Tipo

            parte = new RinesDeLujo( br );
            // Prueba de constructor en atributo tipo.
            assertEquals( "La parte se creó incorrectamente, el tipo de la parte no es el esperado.", "RinesDeLujo", parte.darTipo( ) );
            // Prueba de constructor en atributo x.
            assertEquals( "La parte se creó incorrectamente, la coordenada 'x' de la parte no es la esperada.", parte.darX( ), 50 );
            // Prueba de constructor en atributo y.
            assertEquals( "La parte se creó incorrectamente, la coordenada 'y' de la parte no es la esperada.", parte.darY( ), 285 );
            // Prueba de constructor en atributo color.
            assertEquals( "La parte se cargó incorrectamente, el color de la parte no es el esperado.", new Color( -3620889 ), parte.darColor( ) );
            // Prueba de constructor en atributo alto.
            assertEquals( "La parte se creó incorrectamente, el alto de la parte no es el esperado.", 85, parte.darAlto( ) );
            // Prueba de constructor en atributo ancho.
            assertEquals( "La parte se creó incorrectamente, el ancho de la parte no es el esperado.", 85, parte.darAncho( ) );

            br.close( );
        }
        catch( FileNotFoundException e )
        {
            fail( "No se debe generar el error: " + e.getMessage( ) );
        }
        catch( Exception e1 )
        {
            fail( "No se debe generar el error: " + e1.getMessage( ) );
        }
    }

    /**
     * Prueba 6: Prueba el método constructor de la clase RinesDeLujo. <br>
     * <b>Métodos a probar:</b> <br>
     * RinesDeLujo<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darAlto<br>
     * darAncho <br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye una llanta RinesDeLujo se verifica que se haya creado, y que sus atributos sean los correctos.
     */
    @Test
    public void testLlanta2( )
    {
        setupEscenario3( );
        // Prueba de constructor en atributo tipo.
        assertEquals( "La parte se creó incorrectamente, el tipo de la parte no es el esperado.", "RinesDeLujo", parte.darTipo( ) );
        // Prueba de constructor en atributo x.
        assertEquals( "La parte se creó incorrectamente, la coordenada 'x' de la parte no es la esperada.", 30, parte.darX( ) );
        // Prueba de constructor en atributo y.
        assertEquals( "La parte se creó incorrectamente, la coordenada 'y' de la parte no es la esperada.", 452, parte.darY( ) );
        // Prueba de constructor en atributo color.
        assertEquals( "La parte se creó incorrectamente, el color de la parte no es el esperado.", Color.yellow, parte.darColor( ) );
        // Prueba de constructor en atributo alto.
        assertEquals( "La parte se creó incorrectamente, el alto de la parte no es el esperado.", 85, parte.darAlto( ) );
        // Prueba de constructor en atributo ancho.
        assertEquals( "La parte se creó incorrectamente, el ancho de la parte no es el esperado.", 85, parte.darAncho( ) );
    }

    /**
     * Prueba 9: Prueba el método estaDentro. <br>
     * <b>Métodos a probar:</b> <br>
     * estaDentro<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye una parte, se consultan sobre 2 puntos que están dentro de la parte, y se verifica que la parte los reconozca.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se construye una parte, se consultan sobre 2 puntos que no están dentro de la parte, y se verifica que la parte no los reconozca.<br>
     */
    @Test
    public void testEstaDentro( )
    {
        

        // Prueba del punto cuando está dentro de la figura
        assertTrue( "El punto debe estar en la figura.", parte.estaDentro( 60, 350 ) );
        assertTrue( "El punto debe estar en la figura.", parte.estaDentro( 180, 370 ) );
        // Prueba del punto cuando no está en la figura.
        assertFalse( "El punto no debe estar en la figura.", parte.estaDentro( 49, 250 ) );
        assertFalse( "El punto no debe estar en la figura.", parte.estaDentro( 80, 418 ) );
    }

    /**
     * Prueba 10: Prueba el método cambiarX. <br>
     * <b>Métodos a probar:</b> <br>
     * cambiarX<br>
     * darX<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye una parte, se cambia su coordenada 'x' y luego se consulta para verificar el cambio.<br>
     */
    @Test
    public void testCambiarX( )
    {
        
        parte.cambiarX( 400 );
        assertEquals( "No hizo el cambio de la coordenada 'x' correctamente", 400, parte.darX( ) );

        parte.cambiarX( 50 );
        assertEquals( "No hizo el cambio de la coordenada 'x' correctamente", 50, parte.darX( ) );
    }

    /**
     * Prueba 11: Prueba el método cambiarY. <br>
     * <b>Métodos a probar:</b> <br>
     * cambiarY<br>
     * darY<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye una parte, se cambia su coordenada 'y' y luego se consulta para verificar el cambio.<br>
     */
    @Test
    public void testCambiarY( )
    {
        
        parte.cambiarY( 400 );
        assertEquals( "No hizo el cambio de la coordenada 'y' correctamente", 400, parte.darY( ) );

        parte.cambiarY( 50 );
        assertEquals( "No hizo el cambio de la coordenada 'y' correctamente", 50, parte.darY( ) );
    }

    /**
     * Prueba 12: Prueba el método cambiarAlto. <br>
     * <b>Métodos a probar:</b> <br>
     * cambiarAlto<br>
     * darAlto<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye una parte, se cambia su coordenada alto y luego se consulta para verificar el cambio.<br>
     */
    @Test
    public void testCambiarAlto( )
    {
        
        parte.cambiarAlto( 400 );
        assertEquals( "No hizo el cambio del alto de la parte correctamente", 400, parte.darAlto( ) );

        parte.cambiarAlto( 50 );
        assertEquals( "No hizo el cambio del alto de la parte correctamente", 50, parte.darAlto( ) );
    }

    /**
     * Prueba 13: Prueba el método cambiarAncho. <br>
     * <b>Métodos a probar:</b> <br>
     * cambiarAncho<br>
     * darAncho<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye una parte, se cambia su coordenada ancho y luego se consulta para verificar el cambio.<br>
     */
    @Test
    public void testCambiarAncho( )
    {
        
        parte.cambiarAncho( 400 );
        assertEquals( "No hizo el cambio del ancho de la parte correctamente", 400, parte.darAncho( ) );

        parte.cambiarAncho( 50 );
        assertEquals( "No hizo el cambio del ancho de la parte correctamente", 50, parte.darAncho( ) );
    }

    /**
     * Prueba 14: Prueba el método guardar para DelanteraCamioneta. <br>
     * <b>Métodos a probar:</b> <br>
     * guardar<br>
     * DelanteraCamioneta<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye una parte, se guarda en un archivo. Luego se lee el archivo línea por línea verificando que la información guardada correspondiera a la parte.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se carga una nueva parte con el archivo guardado, y se verifica que los atributos de esta parte con la parte original sean los mismo.
     */
    @Test
    public void testGuardarChasis( )
    {
        

        PrintWriter out;
        try
        {
            out = new PrintWriter( "./test/data/testChasis2.dat" );
            parte.guardar( out );

            out.close( );

            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testChasis2.dat" ) );

            // Prueba del guardado
            assertEquals( "La parte se guardó incorrectamente, el tipo de la parte no corresponde al esperado.", parte.darTipo( ), br.readLine( ) );
            String cors[] = br.readLine( ).split( ";" );
            assertEquals( "La parte se guardó incorrectamente, la coordenada 'x' no corresponde a la esperada.", parte.darX( ), Integer.parseInt( cors[ 0 ] ) );
            assertEquals( "La parte se guardó incorrectamente, la coordenada 'y' no corresponde a la esperada.", parte.darY( ), Integer.parseInt( cors[ 1 ] ) );
            assertEquals( "La parte se guardó incorrectamente", parte.darColor( ), new Color( Integer.parseInt( br.readLine( ) ) ) );

            br.close( );

            br = new BufferedReader( new FileReader( "./test/data/testChasis2.dat" ) );
            br.readLine( );

            Parte p = new DelanteraCamioneta( br );

            // Prueba de constructor de DelanteraCamioneta
            assertEquals( "La parte se cargó incorrectamente, el tipo de la parte no corresponde al esperado.", parte.darTipo( ), p.darTipo( ) );
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'x' no corresponde a la esperada.", parte.darX( ), p.darX( ) );
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'y' no corresponde a la esperada.", parte.darY( ), p.darY( ) );
            assertEquals( "La parte se cargó incorrectamente, el color no corresponde al esperado.", parte.darColor( ), p.darColor( ) );

            br.close( );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
            fail( "No debería generar error: " + e.getMessage( ) );
        }
    }

    /**
     * Prueba 15: Prueba el método guardar para Rayo. <br>
     * <b>Métodos a probar:</b> <br>
     * guardar<br>
     * Rayo<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye una parte, se guarda en un archivo. Luego se lee el archivo línea por línea verificando que la información guardada correspondiera a la parte.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se carga una nueva parte con el archivo guardado, y se verifica que los atributos de esta parte con la parte original sean los mismo.
     */
    @Test
    public void testGuardarStencil( )
    {
        setupEscenario2( );

        PrintWriter out;
        try
        {

            out = new PrintWriter( "./test/data/testStencil2.dat" );
            parte.guardar( out );

            out.close( );

            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testStencil2.dat" ) );

            // Prueba del guardado
            assertEquals( "La parte se guardó incorrectamente, el tipo de la parte no corresponde al esperado.", parte.darTipo( ), br.readLine( ) );
            String cors[] = br.readLine( ).split( ";" );
            assertEquals( "La parte se guardó incorrectamente, la coordenada 'x' no corresponde a la esperada.", parte.darX( ), Integer.parseInt( cors[ 0 ] ) );
            assertEquals( "La parte se guardó incorrectamente, la coordenada 'y' no corresponde a la esperada.", parte.darY( ), Integer.parseInt( cors[ 1 ] ) );
            assertEquals( "La parte se guardó incorrectamente, el color no corresponde al esperado.", parte.darColor( ), new Color( Integer.parseInt( br.readLine( ) ) ) );

            br.close( );

            br = new BufferedReader( new FileReader( "./test/data/testStencil2.dat" ) );
            br.readLine( );

            Parte p = new Rayo( br );

            // Prueba de constructor de Rayo
            assertEquals( "La parte se cargó incorrectamente, el tipo de la parte no corresponde al esperado.", parte.darTipo( ), p.darTipo( ) );
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'x' no corresponde a la esperada.", parte.darX( ), p.darX( ) );
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'y' no corresponde a la esperada.", parte.darY( ), p.darY( ) );
            assertEquals( "La parte se cargó incorrectamente, el color no corresponde al esperado.", parte.darColor( ), p.darColor( ) );

            br.close( );
        }
        catch( Exception e )
        {
            fail( "No debería generar error: " + e.getMessage( ) );
        }
    }

    /**
     * Prueba 16: Prueba el método guardar para Llanta. <br>
     * <b>Métodos a probar:</b> <br>
     * guardar<br>
     * Rayo<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * <b> Caso de prueba 1 : <b><br>
     * Se construye una parte, se guarda en un archivo. Luego se lee el archivo línea por línea verificando que la información guardada correspondiera a la parte.<br>
     * <b> Caso de prueba 2 : <b><br>
     * Se carga una nueva parte con el archivo guardado, y se verifica que los atributos de esta parte con la parte original sean los mismo.
     */
    @Test
    public void testGuardarLlanta( )
    {
        setupEscenario3( );

        PrintWriter out;
        try
        {
            out = new PrintWriter( "./test/data/testLlanta2.dat" );
            parte.guardar( out );

            out.close( );

            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testLlanta2.dat" ) );

            // Prueba del guardado
            assertEquals( "La parte se guardó incorrectamente, el tipo de la parte no corresponde al esperado.", parte.darTipo( ), br.readLine( ) );
            String cors[] = br.readLine( ).split( ";" );
            assertEquals( "La parte se guardó incorrectamente, la coordenada 'x' no corresponde a la esperada.", parte.darX( ), Integer.parseInt( cors[ 0 ] ) );
            assertEquals( "La parte se guardó incorrectamente, la coordenada 'y' no corresponde a la esperada.", parte.darY( ), Integer.parseInt( cors[ 1 ] ) );
            assertEquals( "La parte se guardó incorrectamente, el color no corresponde al esperado.", parte.darColor( ), new Color( Integer.parseInt( br.readLine( ) ) ) );

            br.close( );

            br = new BufferedReader( new FileReader( "./test/data/testLlanta2.dat" ) );
            br.readLine( );

            Parte p = new RinesDeLujo( br );

            // Prueba de constructor de RinesDeLujo
            assertEquals( "La parte se cargó incorrectamente, el tipo de la parte no corresponde al esperado.", parte.darTipo( ), p.darTipo( ) );
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'x' no corresponde a la esperada.", parte.darX( ), p.darX( ) );
            assertEquals( "La parte se cargó incorrectamente, la coordenada 'y' no corresponde a la esperada.", parte.darY( ), p.darY( ) );
            assertEquals( "La parte se cargó incorrectamente, el color no corresponde al esperado.", parte.darColor( ), p.darColor( ) );

            br.close( );
        }
        catch( Exception e )
        {
            fail( "No debería generar error: " + e.getMessage( ) );
        }
    }

}