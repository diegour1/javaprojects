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
 * Excepción que se lanza cuando se busca un elemento que no existe.
 */
public class ElementoNoExisteException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    /**
     * Construye la excepción con el mensaje que describe el problema.
     * @param pMensaje Mensaje que describe la causa de la excepción. pMensaje != null.
     */
    public ElementoNoExisteException( String pMensaje )
    {
        super( pMensaje );
    }
}
