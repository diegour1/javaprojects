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
 * Clase abstracta que representa el est�ncil.
 */
public abstract class Estencil extends Parte
{

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el est�ncil con los valores especificados. <br>
     * <b> post: </b> Se inicializ� el est�ncil con las coordenadas 'x' y 'y', y el color dados por par�metro.
     * @param pX Coordenada x de la figura. pX >= 0.
     * @param pY Coordenada y de la figura. pY >= 0.
     * @param pAlto Alto del est�ncil. pAlto >0.
     * @param pAncho Ancho del est�ncil. pAncho > 0.
     * @param pColor Color del est�ncil. pColor != null.
     */
    public Estencil( int pX, int pY, int pAlto, int pAncho, Color pColor )
    {
        super( pX, pY, pAlto, pAncho, pColor );

    }

    /**
     * Crea el est�ncil a partir de los datos contenidos en el archivo. <br>
     * <b> post: </b> Se inicializ� el est�ncil con las coordenadas 'x' y 'y', y el color dados por par�metro.
     * @param pBr Stream que sirve para leer el archivo. pBr !=null.
     * @param pAlto El alto del est�ncil. pAlto > 0.
     * @param pAncho El ancho del est�ncil. pAncho > 0.
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
     * Dibuja el est�ncil. <br>
     * <b>post:</b> Se dibuj� el est�ncil en el lienzo.
     * @param pG Superficie donde se debe pintar. pG!=null.
     */
    public abstract void pintar( Graphics2D pG );

}
