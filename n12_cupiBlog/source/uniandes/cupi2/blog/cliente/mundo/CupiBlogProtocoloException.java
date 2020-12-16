/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_cupiLatinChat
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.blog.cliente.mundo;

/**
 * Clase que representa una excepción de protocolo en la comunicación entre cliente y servidor.
 */
public class CupiBlogProtocoloException extends Exception
{

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa una nueva excepción de protocolo en la comunicación entre cliente y servidor.
     * @param pMensaje Mensaje de la excepción. pMensaje != null && pMensaje != "".
     */
    public CupiBlogProtocoloException( String pMensaje )
    {
        super( pMensaje );
    }

}
