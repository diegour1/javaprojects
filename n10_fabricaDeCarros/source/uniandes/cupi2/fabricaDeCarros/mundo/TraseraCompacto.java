package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.Color;
import java.io.BufferedReader;


/**
 * Clase que representa la parte trasera del chasis de una compacto.
 */
public class TraseraCompacto extends Chasis
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante que representa el ancho de la imagen.
     */
    public final static int ANCHO = 215;

    /**
     * Constante que representa la imagen de la parte trasera de una compacto.
     */
    public final static String IMAGEN = "traseraCompacto.gif";

    /**
     * Constante que representa el tipo Trasera Compacto.
     */
    public final static String TIPO = "TraseraCompacto";

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la parte trasera de una compacto con los valores especificados.<br>
     * <b> post: </b> Se inicializó el objeto con las coordenadas 'x' y 'y', y el color dados por parámetro.<br>
     * Se inicializó el tipo con la constante de la clase.
     * @param pX Coordenada en x del chasis. pX >= 0.
     * @param pY Coordenada en y del chasis. pY >= 0.
     * @param pColorCarro Color del carro. pColorCarro != null.
     */
    public TraseraCompacto( int pX, int pY, Color pColorCarro )
    {
        super( pX, pY, ANCHO, IMAGEN, pColorCarro );
        tipo = TIPO;

    }

    /**
     * Crea la parte trasera de una compacto a partir de los datos contenidos en el archivo.<br>
     * <b> post: </b> Se inicializó el objeto con el lector de texto dado por parámetro.<br>
     * Se inicializó el tipo con la constante de la clase.
     * @param pBr Stream que sirve para leer el archivo. pBr != null
     * @throws Exception Si hay problemas leyendo el archivo.
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public TraseraCompacto( BufferedReader pBr ) throws Exception
    {
        super( pBr, ANCHO, IMAGEN );
        tipo = TIPO;
    }
}
