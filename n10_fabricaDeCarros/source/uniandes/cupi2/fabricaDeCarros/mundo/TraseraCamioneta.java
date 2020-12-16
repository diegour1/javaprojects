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
import java.io.BufferedReader;

/**
 * Clase que representa la parte trasera del chasis de una camioneta.
 */
public class TraseraCamioneta extends Chasis
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante que representa el ancho de la imagen.
     */
    public final static int ANCHO = 301;

    /**
     * Constante que representa la imagen de la parte trasera de una camioneta.
     */
    public final static String IMAGEN = "traseraCamioneta.gif";

    /**
     * Constante que representa el tipo Trasera Camioneta.
     */
    public final static String TIPO = "TraseraCamioneta";

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la parte trasera de una camioneta con los valores especificados.<br>
     * <b> post: </b> Se inicializó el objeto con las coordenadas 'x' y 'y', y el color dados por parámetro.<br>
     * Se inicializó el tipo con la constante de la clase.
     * @param pX Coordenada en x del chasis. pX >= 0.
     * @param pY Coordenada en y del chasis. pY >= 0.
     * @param pColorCarro Color del carro. pColorCarro != null.
     */
    public TraseraCamioneta( int pX, int pY, Color pColorCarro )
    {
        super( pX, pY, ANCHO, IMAGEN, pColorCarro );
        tipo = TIPO;

    }

    /**
     * Crea la parte trasera de una camioneta a partir de los datos contenidos en el archivo.<br>
     * <b> post: </b> Se inicializó el objeto con el lector de texto dado por parámetro.<br>
     * Se inicializó el tipo con la constante de la clase.
     * @param pBr Stream que sirve para leer el archivo. pBr != null
     * @throws Exception Si hay problemas leyendo el archivo.
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public TraseraCamioneta( BufferedReader pBr ) throws Exception
    {
        super( pBr, ANCHO, IMAGEN );
        tipo = TIPO;
    }

}
