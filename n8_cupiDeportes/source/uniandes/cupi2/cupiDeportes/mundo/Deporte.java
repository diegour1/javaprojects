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
import java.util.ArrayList;

/**
 * Clase que representa un deporte.<br>
 * TODO Parte 1 punto A: Defina el invariante
 * nombre != null && nombre != "" <br>
 * enteRegulador != null && enteRegulador != "" <br>
 * cantidadDeportistasRegistrados > 0 <br>
 * rutaImagen != null && rutaImagen != "" <br>
 */
public class Deporte implements Serializable
{
    
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = -8659162802685356289L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del deporte.
     */
    private String nombre;

    /**
     * Ente regulador del deporte.
     */
    private String enteRegulador;

    /**
     * Cantidad de deportistas registrados en el deporte.
     */
    private int cantidadDeportistasRegistrados;

    /**
     * Ruta a la imagen del deporte.
     */
    private String rutaImagen;

    /**
     * Lista con los deportistas sobresalientes.
     */
    private ArrayList<Deportista> deportistasSobresalientes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un deporte con los valores dados por parámetro. <br>
     * <b>post: </b> Se inicializaron los atributos con los datos dados por parámetro. Se crea una lista de deportistas vacía. <br>
     * @param pNombre Nombre del deporte. pNombre != null && pNombre != "".
     * @param pEnteRegulador Ente regulador del deporte. pEnteRegulador != null && pEnteRegulador != "".
     * @param pCantidadDeportistasRegistrados Cantidad de deportistas registrados en el deporte. pCantidadDeportistasRegistrados > 0.
     * @param pRutaImagen Ruta a la imagen del deporte. pRutaImagen != null && pRutaImagen != "".
     */
    public Deporte( String pNombre, String pEnteRegulador, int pCantidadDeportistasRegistrados, String pRutaImagen )
    {
        nombre = pNombre;
        enteRegulador = pEnteRegulador;
        cantidadDeportistasRegistrados = pCantidadDeportistasRegistrados;
        rutaImagen = pRutaImagen;
        deportistasSobresalientes = new ArrayList<Deportista>( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del deporte.
     * @return Nombre del deporte.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el ente regulador del deporte.
     * @return Ente regulador del deporte.
     */
    public String darEnteRegulador( )
    {
        return enteRegulador;
    }

    /**
     * Retorna la cantidad de deportistas registrados.
     * @return Cantidad de deportistas registrados.
     */
    public int darCantidadDeportistasRegistrados( )
    {
        return cantidadDeportistasRegistrados;
    }

    /**
     * Retorna la ruta a la imagen del deporte.
     * @return Ruta a la imagen del deporte.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }

    /**
     * Retorna una lista con los deportistas sobresalientes.
     * @return Deportistas sobresalientes del deporte.
     */
    public ArrayList<Deportista> darDeportistasSobresalientes( )
    {
        return deportistasSobresalientes;
    }

    /**
     * Agrega un deportista sobresaliente.
     * @param pDeportista Deportista a agregar a la lista de deportistas sobresalientes. pDeportista != null.<br>
     *        <b>post: </b> Se agregó el deportista sobresaliente a la lista.
     * @throws ElementoExisteException Lanza una excepción si ya existe un deportista sobresaliente con el nombre del que se quiere agregar.
     */
    public void agregarDeportistaSobresaliente( Deportista pDeportista ) throws ElementoExisteException
    {
    	//TODO Parte 4 punto A: Implemente el método según la documentación.
    	
    	if ( !existeDeportistaSobresaliente(pDeportista.darNombre()) )
    	{
    		deportistasSobresalientes.add(pDeportista);
    	}
    	else
    	{
    		throw new ElementoExisteException(ElementoExisteException.DEPORTISTA_REPETIDO, pDeportista.darNombre());
    	}
    	verificarInvariante();
    }

    /**
     * Elimina el deportista sobresaliente con el nombre dado. <br>
     * <b>post: </b> Se eliminó el deportista sobresaliente de la lista.
     * @param pNombreDeportista Nombre del deportista a eliminar. pNombreDeportista != null && pNombreDeportista != "".
     */
    public void eliminarDeportistaSobresaliente( String pNombreDeportista )
    {
        boolean termino = false;
        for( int i = 0; i < deportistasSobresalientes.size( ) && !termino; i++ )
        {
            Deportista deportistaActual = deportistasSobresalientes.get( i );
            if( deportistaActual.darNombre( ).equals( pNombreDeportista ) )
            {
                deportistasSobresalientes.remove( i );
                termino = true;
            }
        }

    }

    /**
     * Verifica si existe o no un deportista sobresaliente con el nombre dado.
     * @param pNombreDeportista Nombre del deportista. pNombreDeportista != null && pNombreDeportista != "".
     * @return True si existe un deportista sobresaliente con el nombre dado por parámetro. False de lo contrario.
     */
    public boolean existeDeportistaSobresaliente( String pNombreDeportista )
    {
        boolean existe = false;

        for( int i = 0; i < deportistasSobresalientes.size( ) && !existe; i++ )
        {
            Deportista deportistaActual = ( Deportista )deportistasSobresalientes.get( i );
            if( deportistaActual.darNombre( ).equals( pNombreDeportista ) )
            {
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Retorna el deportista que tiene el mayor número de trofeos ganados. Si hay dos o más deportistas con el mismo número de trofeos y son máximos, retorna cualquiera.
     * @return El deportista con mayor número de trofeos. Si no hay deportistas retorna null.
     */
    public Deportista darDeportistaMasTrofeos( )
    {
        Deportista masTrofeos = null;
        int cantidadMaxima = 0;
        for( int i = 0; i < deportistasSobresalientes.size( ); i++ )
        {
            Deportista deportistaActual = deportistasSobresalientes.get( i );
            if( deportistaActual.darCantidadTrofeos( ) > cantidadMaxima )
            {
                cantidadMaxima = deportistaActual.darCantidadTrofeos( );
                masTrofeos = deportistaActual;
            }

        }
        return masTrofeos;
    }

    /**
     * Retorna el total de trofeos de los deportistas sobresalientes.
     * @return total de trofeos.
     */
    public int darTotalTrofeos( )
    {
        int total = 0;

        for( int i = 0; i < deportistasSobresalientes.size( ); i++ )
        {
            Deportista deportistaActual = deportistasSobresalientes.get( i );
            total += deportistaActual.darCantidadTrofeos( );
        }

        return total;
    }

    /**
     * Retorna el nombre del deporte.
     * @return Nombre del deporte.
     */
    public String toString( )
    {
        return nombre;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    //TODO Parte 1 punto B: Documente e implemente el método verificarInvariante().
    //De ser necesario implemente métodos auxiliares.
    
    /**
     * Verifica el invariante de la clase
     * <b> inv: </b> <br>
     * nombre != null && nombre != "" <br>
     * enteRegulador != null && enteRegulador != "" <br>
     * cantidadDeportistasRegistrados > 0 <br>
     * rutaImagen != null && rutaImagen != "" <br>
     */
    private void verificarInvariante()
    {
    	assert ( nombre != null && !nombre.equals( "" ) ) : "El nombre del deporte no puede ser nulo";
    	assert ( enteRegulador != null && !enteRegulador.equals( "" ) ) : "El ente regulador no puede ser nulo";
    	assert ( cantidadDeportistasRegistrados > 0 ) : " La cantidad de deportistas registrados debe ser mayor a cero";
    	assert ( rutaImagen != null && !rutaImagen.equals( "" ) ): " La ruta de imagen no puede ser nula ";
    }

}