/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_cupiDeportes
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiDeportes.mundo;

import java.io.Serializable;

/**
 * Clase que representa un deportista. <br>
 * TODO Parte 1 punto C: Defina el invariante
 * <b> inv: </b> <br>
 * nombre != null && nombre != "" <br>
 * edad > 0 <br>
 * lugarResidencia != null && lugarResidencia != "" <br>
 * cantidadTrofeos >= 0 <br>
 * rutaImagen != null && rutaImagen != "" <br>
 */

public class Deportista implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 3525724065227912858L;

    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del deportista.
     */
    private String nombre;

    /**
     * Edad del deportista.
     */
    private int edad;

    /**
     * Lugar de residencia del deportista.
     */
    private String lugarResidencia;

    /**
     * Cantidad de trofeos ganados por deportista.
     */
    private int cantidadTrofeos;

    /**
     * Ruta a la imagen del deportista.
     */
    private String rutaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un deportista con los valores dados por parámetro. <br>
     * <b>post:</b> Se inicializaron los atributos con los valores dados por parámetros.
     * @param pNombre Nombre del deportista. pNombre != null && pNombre != "".
     * @param pEdad Edad del deportista. pEdad > 0.
     * @param pLugarResidencia Lugar de residencia del deportista. pLugarResidencia != null && pLugarResidencia != "".
     * @param pCantidadTrofeos Cantidad de trofeos ganados por el deportista. pCantidadTrofeos >= 0.
     * @param pRutaImagen Ruta a la imagen del deportista. pRutaImagen != null && pRutaImagen != "".
     */
    public Deportista( String pNombre, int pEdad, String pLugarResidencia, int pCantidadTrofeos, String pRutaImagen )
    {
        nombre = pNombre;
        edad = pEdad;
        lugarResidencia = pLugarResidencia;
        cantidadTrofeos = pCantidadTrofeos;
        rutaImagen = pRutaImagen;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del deportista.
     * @return Nombre del deportista.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la edad del deportista.
     * @return Edad del deportista.
     */
    public int darEdad( )
    {
        return edad;
    }

    /**
     * Retorna el lugar de residencia del deportista.
     * @return Lugar de residencia del deportista.
     */
    public String darLugarResidencia( )
    {
        return lugarResidencia;
    }

    /**
     * Retorna la cantidad de trofeos del deportista.
     * @return Cantidad de trofeos del deportista.
     */
    public int darCantidadTrofeos( )
    {
        return cantidadTrofeos;
    }

    /**
     * Retorna la ruta a la imagen del deportista.
     * @return Ruta a la imagen del deportista.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }

    /**
     * Cambia la edad del deportista.
     * @param pEdad Nueva edad del deportista. pEdad > 0.
     */
    public void cambiarEdad( int pEdad )
    {
        edad = pEdad;
    }

    /**
     * Cambia el lugar de residencia del deportista.
     * @param pLugarResidencia Nuevo lugar de residencia del deportista. pLugarResidencia != null && pLugarResidencia != "".
     */
    public void cambiarLugarResidencia( String pLugarResidencia )
    {
        lugarResidencia = pLugarResidencia;
    }

    /**
     * Cambia la cantidad de trofeos del deportista.
     * @param pCantidadTrofeos Nueva cantidad de trofeos del deportista. pCantidadTrofeos >= 0.
     */
    public void cambiarCantidadTrofeos( int pCantidadTrofeos )
    {
        cantidadTrofeos = pCantidadTrofeos;
    }

    /**
     * Cambia la ruta a la imagen del deportista.
     * @param pRutaImagen Nueva ruta a la imagen del deportista. pRutaImagen != null && pRutaImagen != "".
     */
    public void cambiarRutaImagen( String pRutaImagen )
    {
        rutaImagen = pRutaImagen;
    }

    /**
     * Retorna el nombre del deportista.
     * @return Nombre del deportista.
     */
    public String toString( )
    {
        return nombre;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------


    //TODO Parte 1 punto D: Documente e implemente el método verificarInvariante().
    //De ser necesario implemente métodos auxiliares.
    
    /**
     * Verifica el invariante de la clase <br>
     * <b> inv: </b> <br>
     * nombre != null && nombre != "" <br>
     * edad > 0 <br>
     * lugarResidencia != null && lugarResidencia != "" <br>
     * cantidadTrofeos >= 0 <br>
     * rutaImagen != null && rutaImagen != "" <br>
     */
    
    private void verificarInvariante()
    {
    	assert ( nombre != null && !nombre.equals( "" ) ) : "El nombre del deportista no puede ser nulo";
    	assert ( edad > 0 ) : " La edad del deportista debe ser mayor a cero";
    	assert ( lugarResidencia != null && !lugarResidencia.equals( "" ) ) : "El lugar de residencia no puede ser nulo";
    	assert ( cantidadTrofeos >= 0 ) : " La cantidad de trofeos debe ser mayor o igual a cero";
    	assert ( rutaImagen != null && !rutaImagen.equals( "" ) ): " La ruta de imagen no puede ser nula ";
    }


 


}