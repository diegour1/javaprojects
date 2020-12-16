/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_cupiTrenes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTrenes.mundo;

/**
 * Excepción que se lanza cuando se intenta agregar un elemento existente. <br>
 */
public class ElementoExisteException extends Exception
{
    /**
     * Construye la excepción con el mensaje que describe el problema.
     * @param pMensaje Mensaje que describe la causa de la excepción. pMensaje != null.
     */
    public ElementoExisteException( String pMensaje )
    {
        super( pMensaje );
    }
}
