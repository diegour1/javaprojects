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
package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;

/**
 * Clase que representa la pintura de una teselaci�n.
 */
public class Teselacion extends Estencil
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el alto de la imagen.
     */
    public final static int ALTO = 40;

    /**
     * Constante que representa el ancho de la imagen.
     */
    public final static int ANCHO = 100;

    /**
     * Constante que representa el tipo Teselacion.
     */
    public final static String TIPO = "Teselacion";

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el est�ncil con patr�n de teselaci�n con los valores especificados.<br>
     * <b> post: </b> Se inicializ� el est�ncil con las coordenadas 'x' y 'y', y el color dados por par�metro.<br>
     * Se inicializ� el tipo con la constante de la clase.
     * @param pX Coordenada x de la figura. pX >= 0.
     * @param pY Coordenada y de la figura. pY >= 0.
     * @param pColor Color del est�ncil. pColor != null.
     */
    public Teselacion( int pX, int pY, Color pColor )
    {
        super( pX, pY, ALTO, ANCHO, pColor );
        tipo = TIPO;
    }

    /**
     * Crea el est�ncil con patr�n de teselaci�n a partir de los datos contenidos en el archivo.<br>
     * <b> post: </b> Se inicializ� el est�ncil con el lector de texto por par�metro.<br>
     * Se inicializ� el tipo con la constante de la clase.
     * @param pBr Stream que sirve para leer el archivo. pBr!=null.
     * @throws Exception Si hay problemas leyendo el archivo.
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public Teselacion( BufferedReader pBr ) throws Exception
    {
        super( pBr, ALTO, ANCHO );
        tipo = TIPO;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Dibuja el est�ncil de patr�n teselaci�n.<br>
     * <b>post: </b> Se dibuj� el est�ncil en el lienzo.
     * @param pG Superficie donde se debe pintar. pG!=null.
     */
    public void pintar( Graphics2D pG )
    {
        pG.setColor( color );
        int puntoX = x;
        int puntoY = y;
        int anchoCuadrado = ANCHO / 8;
        int altoCuadrado = ALTO / 6;
        for( int j = 0; j < 6; j++ )
        {
            puntoX = x + anchoCuadrado * j / 2;
            for( int i = 0; i < 8; i++ )
            {
                if( ( i % 2 == 0 && j % 2 == 0 ) || ( i % 2 == 1 && j % 2 == 1 ) )
                {
                    int[] puntosX = { puntoX, puntoX + anchoCuadrado, puntoX + anchoCuadrado * 3 / 2, puntoX + anchoCuadrado / 2 };
                    int[] puntosY = { puntoY, puntoY, puntoY + altoCuadrado, puntoY + altoCuadrado };
                    pG.fillPolygon( puntosX, puntosY, 4 );
                }
                puntoX += anchoCuadrado;
            }
            puntoY += altoCuadrado;

        }

    }

}
