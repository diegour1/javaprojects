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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Clase abstracta que representa una parte del chasis.
 */
public abstract class Chasis extends Parte
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el alto del chasis.
     */
    public final static int ALTO = 200;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Figura que representa el chasis.
     */
    private BufferedImage figuraChasis;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------
    /**
     * Crea un chasis con los valores especificados.<br>
     * <b> post: </b> Se inicializó el chasis con las coordenadas 'x' y 'y', la imagen y el color dados por parámetro.
     * @param pX Coordenada x del chasis. pX >= 0.
     * @param pY Coordenada y del chasis. pY >= 0.
     * @param pAncho Ancho de la imagen. pAncho > 0.
     * @param pColorCarro Color del carro. pColorCarro != null.
     * @param pImagen Nombre de la Imagen que representa el chasis incluyendo la extensión (p.e. delanteraCompacto.png). pImagen!= null && !pImagen.equals("").
     */
    public Chasis( int pX, int pY, int pAncho, String pImagen, Color pColorCarro )
    {
        super( pX, pY, ALTO, pAncho, pColorCarro );
        cargarImagen( pImagen );

    }

    /**
     * Crea un chasis a partir de los datos contenidos en el archivo.<br>
     * <b> post: </b> Se inicializó el chasis con el lector de texto, el ancho y la imagen dada por parámetro.
     * @param pBr Stream que sirve para leer el archivo. pBr != null.
     * @param pAncho Ancho de la imagen. pAncho > 0.
     * @param pImagen Nombre del archivo con la figura. pImagen != null y !pImagen.equals("").
     * @throws Exception Si hay problemas leyendo el archivo.
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public Chasis( BufferedReader pBr, int pAncho, String pImagen ) throws Exception
    {
        super( pBr, ALTO, pAncho );
        cargarImagen( pImagen );
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Carga la imagen con el nombre especificado.<br>
     * <b> post: </b> La imagen fue cargada en la figura del chasis.
     * @param pImagen Nombre de la imagen a ser cargada. pImagen !=null && !pImagen.equals("").
     */
    public void cargarImagen( String pImagen )
    {
        try
        {
            figuraChasis = ImageIO.read( new File( "data" + File.separator + "imagenes" + File.separator + pImagen ) );
        }
        catch( IOException e )
        {
            figuraChasis = new BufferedImage( 1, 1, BufferedImage.TYPE_INT_RGB );
        }
    }

    /**
     * Dibuja el chasis .<br>
     * <b> post: </b> El chasis fue pintado.
     * @param pG Superficie donde se debe pintar. pG!= null.
     */
    public void pintar( Graphics2D pG )
    {
        pG.drawImage( figuraChasis, x, y, ancho, alto, color, null );

    }
}
