/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_cupiBlog
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.blog.cliente.mundo;

import java.util.ArrayList;

/**
 * Interfaz que le permite a la interfaz gráfica actualizarse ante varios eventos en el mundo.
 */
public interface IObservadorEventos
{

    /**
     * Método que notifica una actualización de la lista de los artículos.
     * @param pArticulos La lista de artículos obtenida. pArticulos != null.
     */
    public void actualizarListaArticulos( ArrayList<Articulo> pArticulos );
    
    /**
     * Notifica el inicio de sesión del usuario.
     * @param pEstadoSesion El estado de sesión del usuario. pEstadoSesion != null.
     */
    public void cambiarEstadoSesion( boolean pEstadoSesion );

    /**
     * Método que notifica la llegada de un mensaje del servidor.
     * @param pMensaje El mensaje del cual se debe notificar. pMensaje != null.
     * @param pTitulo Titulo del mensaje que se va a notificar. pTitulo != null && pTItulo != "".
     */
    public void notificarMensaje( String pMensaje, String pTitulo );

    /**
     * Método que notifica una excepción.
     * @param pExcepcion La excepción que llega en el mensaje. pExcepcion != null.
     */
    public void notificarExcepcion( Exception pExcepcion );
    
    /**
     * Método que notifica una nueva calificación.
     * @param pArticulo El artículo que ha sido calificado. pArticulo != null.
     */
    public void notificarCalificacion( Articulo pArticulo );
}
