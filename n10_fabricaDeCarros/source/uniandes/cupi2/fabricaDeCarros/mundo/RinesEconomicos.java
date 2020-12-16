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
import java.io.BufferedReader;

/**
 * Clase que representa la llanta con rines económicos.
 */
public class RinesEconomicos extends Llanta
{
    /**
     * Constante que representa el tipo RinesEconomicos.
     */
    public final static String TIPO = "RinesEconomicos";

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea la llanta con los valores especificados.<br>
     * <b> post: </b> Se inicializó el rin con las coordenadas 'x' y 'y', y el color dados por parámetro.<br>
     * Se inicializó el tipo con la constante de la clase.
     * @param pX Coordenada x de la figura. pX >= 0.
     * @param pY Coordenada y de la figura. pY >= 0.
     * @param pColorCarro Color del carro. pColorCarro != null.
     */
    public RinesEconomicos( int pX, int pY, Color pColorCarro )
    {
        super( pX, pY, pColorCarro );
        tipo = TIPO;
    }

    /**
     * Crea la llanta a partir de los datos contenidos en el archivo.<br>
     * <b> post: </b> Se inicializó el rin con el editor de texto dado por parámetro.<br>
     * Se inicializó el tipo con la constante de la clase.
     * @param pBr Stream que sirve para leer el archivo. pBr!=null.
     * @throws Exception Si hay problemas leyendo el archivo.
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public RinesEconomicos( BufferedReader pBr ) throws Exception
    {
        super( pBr );
        tipo = TIPO;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Dibuja los rines de la llanta.<br>
     * <b> post: </b> El rin se dibujó.
     * @param pG Superficie donde se debe pintar. pG!=null.
     */
    public void pintarRines( Graphics2D pG )
    {
        pG.setColor( new Color( 14, 14, 14 ) );
        pG.fillOval( x + 3 * DIAMETRO / 10, y + 3 * DIAMETRO / 10, +4 * DIAMETRO / 10, +4 * DIAMETRO / 10 );

        double cos = 0.829;
        double sin = 0.559;
        int d1 = DIAMETRO / 5;
        int d2 = d1 / 3;
        int radio = DIAMETRO / 2;
        int radio2 = DIAMETRO / 2 - d2 - d1;

        pG.setColor( Color.DARK_GRAY );

        BasicStroke stroke = new BasicStroke( ( float ) ( DIAMETRO / 8.6 ) );
        pG.setStroke( stroke );
        int a = ( int ) ( radio2 * sin );
        int b = ( int ) ( radio2 * cos );

        int puntox1 = x + radio;
        int puntox2 = x + radio + b;
        int puntox3 = x + radio - b;
        int puntoy1 = y + d1 + d2;
        int puntoy2 = y + radio - a;
        int puntoy3 = y + radio + a;
        int puntoy4 = y + ancho - d2 - d1;

        pG.drawLine( puntox1, puntoy1, puntox1, puntoy4 );
        pG.drawLine( puntox2, puntoy2, puntox3, puntoy3 );
        pG.drawLine( puntox3, puntoy2, puntox2, puntoy3 );

        pG.setStroke( stroke );
        pG.setColor( Color.gray );
        pG.drawOval( x + radio - d1 / 5, y + radio - d1 / 5, d1 * 2 / 5, d1 * 2 / 5 );

        stroke = new BasicStroke( DIAMETRO / 15 );
        pG.setStroke( stroke );
        pG.setColor( new Color( 25, 25, 25 ) );
        pG.drawOval( x + radio - d1 / 8, y + radio - d1 / 8, d1 / 4, d1 / 4 );
        pG.setColor( null );
    }
}
