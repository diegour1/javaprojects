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
import java.io.BufferedReader;

/**
 * Clase abstracta que representa el esténcil.
 */
public abstract class Estencil extends Parte
{

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el esténcil con los valores especificados. <br>
     * <b> post: </b> Se inicializó el esténcil con las coordenadas 'x' y 'y', y el color dados por parámetro.
     * @param pX Coordenada x de la figura. pX >= 0.
     * @param pY Coordenada y de la figura. pY >= 0.
     * @param pAlto Alto del esténcil. pAlto >0.
     * @param pAncho Ancho del esténcil. pAncho > 0.
     * @param pColor Color del esténcil. pColor != null.
     */
    public Estencil( int pX, int pY, int pAlto, int pAncho, Color pColor )
    {
        super( pX, pY, pAlto, pAncho, pColor );

    }

    /**
     * Crea el esténcil a partir de los datos contenidos en el archivo. <br>
     * <b> post: </b> Se inicializó el esténcil con las coordenadas 'x' y 'y', y el color dados por parámetro.
     * @param pBr Stream que sirve para leer el archivo. pBr !=null.
     * @param pAlto El alto del esténcil. pAlto > 0.
     * @param pAncho El ancho del esténcil. pAncho > 0.
     * @throws Exception Si hay problemas leyendo el archivo.
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public Estencil( BufferedReader pBr, int pAlto, int pAncho ) throws Exception
    {
        super( pBr, pAlto, pAncho );
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Dibuja el esténcil. <br>
     * <b>post:</b> Se dibujó el esténcil en el lienzo.
     * @param pG Superficie donde se debe pintar. pG!=null.
     */
    public abstract void pintar( Graphics2D pG );

}
