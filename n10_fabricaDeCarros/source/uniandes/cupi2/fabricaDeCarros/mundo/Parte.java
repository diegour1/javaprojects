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
package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase abstracta que representa una parte del carro.
 */
public abstract class Parte implements IParte
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Ancho de la parte.
     */
    protected int ancho;

    /**
     * Alto de la parte.
     */
    protected int alto;

    /**
     * Coordenada x de la parte.
     */
    protected int x;

    /**
     * Coordenada y de la parte.
     */
    protected int y;

    /**
     * Color de la parte.
     */
    protected Color color;

    /**
     * Tipo de la parte.
     */
    protected String tipo;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Crea la parte con los valores especificados.<br>
     * El atributo tipo debe ser inicializado en el constructor de cada clase heredada.<br>
     * <b> post: </b> Se inicializó la parte con las coordenadas 'x' y 'y', el ancho, el alto y el color dados por parámetro.
     * @param pX Coordenada x de la figura. pX >= 0.
     * @param pY Coordenada y de la figura. pY >= 0.
     * @param pAlto Alto de la figura. pAlto >= 0.
     * @param pAncho Ancho de la figura. pAncho >= 0.
     * @param pColorCarro Color del carro. pColorCarro != null.
     */
    public Parte( int pX, int pY, int pAlto, int pAncho, Color pColorCarro )
    {
        x = pX;
        y = pY;
        alto = pAlto;
        ancho = pAncho;
        color = pColorCarro;
        verificarInvariante( );
    }

    /**
     * Crea la parte a partir de los datos contenidos en el archivo.
     * @param pBr Stream que sirve para leer el archivo. pBr!=null.
     * @param pAlto Altura de la figura. pAlto >= 0.
     * @param pAncho Ancho de la figura. pAncho >= 0.
     * @throws Exception Si hay problemas leyendo el archivo.
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public Parte( BufferedReader pBr, int pAlto, int pAncho ) throws Exception
    {
        String lineaPuntos = pBr.readLine( );
        String strColor;
        try
        {
            inicializarPuntos( lineaPuntos );
            strColor = pBr.readLine( );
        }
        catch( IOException fie )
        {
            throw new Exception( "Error al leer el archivo." );
        }
        alto = pAlto;
        ancho = pAncho;
        color = new Color( Integer.parseInt( strColor ) );
        verificarInvariante( );
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el alto de la parte.
     * @return Alto de la parte.
     */
    public int darAlto( )
    {
        return alto;
    }

    /**
     * Retorna el ancho de la parte.
     * @return Ancho de la parte.
     */
    public int darAncho( )
    {
        return ancho;
    }

    /**
     * Retorna el color de la parte.
     * @return Color de la parte.
     */
    public Color darColor( )
    {
        return color;
    }

    /**
     * Retorna el tipo de la parte.
     * @return Tipo de la parte.
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna la coordenada x de la parte.
     * @return Coordenada x de la parte.
     */
    public int darX( )
    {
        return x;
    }

    /**
     * Retorna la coordenada y de la parte.
     * @return Coordenada y de la parte.
     */
    public int darY( )
    {
        return y;
    }

    /**
     * Cambia el ancho de la parte.
     * @param pAncho Nuevo ancho de la parte. pAncho >=0.
     */
    public void cambiarAncho( int pAncho )
    {
        ancho = pAncho;
    }

    /**
     * Cambia el alto de la parte.
     * @param pAlto Nuevo alto de la parte. pAlto >= 0.
     */
    public void cambiarAlto( int pAlto )
    {
        alto = pAlto;
    }

    /**
     * Cambia el color de la parte..
     * @param pColor Nuevo color de la figura representado en un número de código RGB. pColor >= 0.
     */
    public void cambiarColor( int pColor )
    {

        color = new Color( pColor );

    }

    /**
     * Cambia la coordenada x de la figura.
     * @param pX Nueva coordenada x de la figura. pX >= 0.
     */
    public void cambiarX( int pX )
    {
        x = pX;
    }

    /**
     * Cambia la coordenada y de la parte.
     * @param pY Nueva coordenada y de la parte. pY >= 0.
     */
    public void cambiarY( int pY )
    {
        y = pY;
    }

    /**
     * Indica si un punto está dentro de una figura o no.
     * @param pX Coordenada x del punto. pX >= 0.
     * @param pY Coordenada y del punto. pY >= 0.
     * @return Retorna true si el punto está dentro de la parte, false en caso contrario.
     */
    public boolean estaDentro( int pX, int pY )
    {
        Rectangle2D rectangulo = new Rectangle2D.Double( x, y, ancho, alto );
        return rectangulo.contains( pX, pY );
    }

    /**
     * Este método sirve para guardar una parte en un archivo.
     * @param pOut Stream donde se va a guardar la parte. pOut!=null.
     */
    public void guardar( PrintWriter pOut )
    {
        pOut.println( darTipo( ) );
        pOut.println( "" + x + ";" + y );
        pOut.println( color.getRGB( ) );
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Inicializa los puntos de la parte a partir de la línea que para por parámetro. <br>
     * <b>post: </b> x, y tienen nuevos valores.
     * @param pLineaPuntos Línea del archivo donde se encuentran los puntos. pLineaPuntos != null y !pLineaPuntos.equals("").
     * @throws Exception Si hay errores de formato.
     * @throws Exception Si hay error al leer la línea.
     */
    private void inicializarPuntos( String pLineaPuntos ) throws Exception
    {
        String[] strValores = pLineaPuntos.split( ";" );
        if( strValores.length != 2 )
        {
            throw new Exception( "Error al leer la línea " + pLineaPuntos + "." );
        }
        try
        {
            x = Integer.parseInt( strValores[ 0 ] );
            y = Integer.parseInt( strValores[ 1 ] );
        }
        catch( NumberFormatException nfe )
        {
            throw new Exception( "Error al leer la línea " + pLineaPuntos + "." );
        }
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    //TODO Parte2 PuntoA. Realice el contrato y declaración del método abstracto pintar.
    //Siga la descripción del diagrama UML de clases.
    public abstract void pintar( Graphics2D pG);
    
    /**
     * Pinta la parte como seleccionada. <br>
     * <b>post: </b> Se dibujó el contorno de la parte seleccionada en el lienzo.
     * @param pG Superficie donde se pinta el rectángulo. pG!=null.
     */
    public void pintarSeleccionada( Graphics2D pG )
    {
        pG.setColor( Color.black );
        float[] dash = { 30, 10, 10, 10 };
        BasicStroke stroke = new BasicStroke( 5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dash, 0 );
        pG.setStroke( stroke );
        pG.drawRect( x, y, ancho, alto );
        pG.setStroke( new BasicStroke( 1 ) );
        pG.setColor( color );
    }

    /**
     * Pinta la parte como seleccionada. <br>
     * <b>post: </b> Se dibujó el contorno de la parte seleccionada en el lienzo.
     * @param pG Superficie donde se pinta el rectángulo. pG!=null.
     */
    public void pintarSombreada( Graphics2D pG )
    {
        pintar( pG );
    }

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv: </b><br>
     * x>=0<br>
     * y>=0 <br>
     * ancho>=0 <br>
     * alto >=0.<br>
     */
    public void verificarInvariante( )
    {
        assert ( x >= 0 ) : "La coordenada x es inválida";
        assert ( y >= 0 ) : "La coordenada y es inválida";
        assert ( ancho >= 0 ) : "El ancho es inválido";
        assert ( alto >= 0 ) : "El alto es inválido";
    }

}