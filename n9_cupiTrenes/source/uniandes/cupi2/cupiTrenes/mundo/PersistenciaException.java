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
 * Esta excepción se lanza cuando se presenta un error al leer o escribir el archivo con la información del estado del mundo. <br>
 * El mensaje asociado con la excepción debe describir el problema que se presentó.
 */
public class PersistenciaException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye la excepción con el mensaje que describe el problema.
     * @param pMensaje Mensaje que describe la causa de la excepción. pMensaje != null.
     */
    public PersistenciaException( String pMensaje )
    {
        super( pMensaje );
    }
}
