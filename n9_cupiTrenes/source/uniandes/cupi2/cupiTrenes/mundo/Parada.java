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

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa una parada del tren.<br>
 * <b>inv:</b><br>
 * nombre != null && nombre != "".<br>
 * horario != null.<br>
 */
public class Parada implements Serializable
{

    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante de serialización de la clase.
     */
    private static final long serialVersionUID = -6927689312444540009L;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Nombre de la parada.
     */
    private String nombre;

    /**
     * Horario de llegada del tren a la parada.
     */
    private Date horario;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Constructor de la clase. <br>
     * <b>post: </b>Se construye una nueva parada con la información dada por parámetro.
     * @param pNombre Nombre de la parada. pNombre != null && pNombre != "".
     * @param pHorario Horario de llegada del tren a la parada. pHorario != null.
     */
    public Parada( String pNombre, Date pHorario )
    {
        nombre = pNombre;
        horario = pHorario;
        verificarInvariante( );
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el nombre de la parada.
     * @return Nombre de la parada.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la hora de llegada del tren a la parada con el formato HH:mm.
     * @return Hora de llegada del tren a la parada.
     */
    public String darHorario( )
    {
        SimpleDateFormat formato = new SimpleDateFormat( "HH:mm" );
        return formato.format( horario ).toString( );
    }

    /**
     * Verifica el invariante de la clase.<br>
     * <b>inv:</b><br>
     * nombre != null && nombre != "".<br>
     * horario != null.<br>
     */
    private void verificarInvariante( )
    {
        assert nombre != null && nombre != "" : "El nombre no puede ser null ni vacío.";
        assert horario != null : "El horario  no puede ser null.";
    }
}
