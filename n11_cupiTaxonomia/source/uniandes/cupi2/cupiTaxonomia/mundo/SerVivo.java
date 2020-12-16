/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiTaxonomia
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiTaxonomia.mundo;

import java.io.Serializable;

/**
 * Clase que representa un ser vivo del árbol taxonómico.
 */
public class SerVivo implements Serializable
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Constante de serialización de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Nombre común del ser vivo.
     */
    private String nombreComun;

    /**
     * Nombre científico del ser vivo.
     */
    private String nombreCientifico;

    /**
     * Características del ser vivo.
     */
    private String caracteristicas;

    /**
     * Ruta con la imagen del ser vivo.
     */
    private String rutaImagen;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Construye un nuevo ser vivo con la información dada por parámetro. <br>
     * <b> post: </b> El ser vivo se inicializó con los valores de nombre común, nombre científico, características e imagen dados por parámetro.
     * @param pNombreComun Nombre común del ser vivo. pNombreComun != null y pNombreComun != "".
     * @param pNombreCientifico Nombre científico del ser vivo. pNombreCientifico != null y pNombreCientifico != "".
     * @param pCaracteristicas Características del ser vivo. pCaracteristicas != null y pCaracteristicas != "".
     * @param pImagen Ruta con la imagen del ser vivo. pImagen != null y pImagen != "".
     */
    public SerVivo( String pNombreComun, String pNombreCientifico, String pCaracteristicas, String pImagen )
    {
        nombreComun = pNombreComun;
        nombreCientifico = pNombreCientifico;
        caracteristicas = pCaracteristicas;
        rutaImagen = pImagen;
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna las características del ser vivo.
     * @return Características del ser vivo.
     */
    public String darCaracteristicas( )
    {
        return caracteristicas;
    }
    
    /**
     * Retorna el nombre común del ser vivo.
     * @return Nombre común del ser vivo.
     */
    public String darNombreComun( )
    {
        return nombreComun;
    }

    /**
     * Retorna el nombre científico del ser vivo.
     * @return Nombre científico del ser vivo.
     */
    public String darNombreCientifico( )
    {
        return nombreCientifico;
    }


    /**
     * Retorna la ruta de la imagen del ser vivo.
     * @return Ruta de la imagen del ser vivo.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }

    /**
     * Retorna una cadena con el nombre científico y el nombre común del ser vivo.
     * @return La representación del ser vivo en String: <nombreCientifico> - <nombreComun>.
     */
    public String toString( )
    {
        return nombreCientifico + " - " + nombreComun;
    }
}