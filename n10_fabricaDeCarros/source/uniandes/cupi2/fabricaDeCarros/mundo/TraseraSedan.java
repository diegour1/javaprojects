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
 * Clase que representa la parte trasera del chasis de un vehículo sedán.
 */
public class TraseraSedan extends Chasis
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante que representa el ancho de la imagen.
     */
    public final static int ANCHO = 302;

    /**
     * Constante que representa la parte trasera de un sedán.
     */
    public final static String IMAGEN = "traseraSedan.gif";

    /**
     * Constante que representa el tipo Trasera Sedan.
     */
    public final static String TIPO = "TraseraSedan";

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la parte trasera de un sedán con los valores especificados. <br>
     * <b> post: </b> Se inicializó el objeto con las coordenadas 'x' y 'y', y el color dados por parámetro.<br>
     * Se inicializó el tipo con la constante de la clase.
     * @param pX Coordenada x del chasis. pX >= 0.
     * @param pY Coordenada y del chasis. pY >= 0.
     * @param pColorCarro Color del carro. pColorCarro != null.
     */
    public TraseraSedan( int pX, int pY, Color pColorCarro )
    {
        super( pX, pY, ANCHO, IMAGEN, pColorCarro );
        tipo = TIPO;

    }

    /**
     * Crea la parte trasera de un sedán a partir de los datos contenidos en el archivo.<br>
     * <b> post: </b> Se inicializó el objeto el lector dado por parámetro.<br>
     * Se inicializó el tipo con la constante de la clase.
     * @param pBr Stream que sirve para leer el archivo. pBr != null.
     * @throws Exception Si hay problemas leyendo el archivo.
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public TraseraSedan( BufferedReader pBr ) throws Exception
    {
        super( pBr, ANCHO, IMAGEN );
        tipo = TIPO;
    }

}
