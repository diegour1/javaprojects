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

/**
 * Clase que representa el vagón de un tren. <br>
 * <b>inv:</b><br>
 * La cantidad de sillas disponibles es mayor o igual a 0. <br>
 * La clase pertenece a alguno de los valores del arreglo de constantes. <br>
 * El precio es mayor o igual a 0. <br>
 * El número de vagón es mayor a 0.<br>
 */
public class Vagon implements Serializable
{

    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante de serialización de la clase.
     */
    private static final long serialVersionUID = 9015954459189238070L;

    /**
     * Arreglo de constantes que contiene las clases posibles para un vagón.
     */
    public final static String[] CLASES = { "Primera clase", "Segunda clase", "Negocios", "VIP" };

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Número del vagón.
     */
    private int numero;
    
    /**
     * Cantidad total de sillas en el vagón.
     */
    private int cantidadTotalSillas;

    /**
     * Cantidad de sillas disponibles en el vagón.
     */
    private int cantidadSillasDisponibles;

    /**
     * Clase del vagón.
     */
    private String clase;

    /**
     * Precio de un tiquete.
     */
    private double precio;

    /**
     * Siguiente vagón.
     */
    // TODO Parte1 PuntoA: Declarar el atributo que referencia el siguiente vagón.
    
    private Vagon siguienteVagon; 
    

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Constructor de la clase. <br>
     * <b>post: </b>Se construye un nuevo vagón con la información dada por parámetro.
     * @param pNumero Número del vagón. pNumero > 0.
     * @param pCantidadSillas Cantidad de sillas en el vagón. pCantidadSillasDisponibles >= 0.
     * @param pClase Clase del vagón. pClase pertenece a CLASES.
     * @param pPrecio Precio de un tiquete. pPrecio >= 0.
     */
    public Vagon( int pNumero, int pCantidadSillas, String pClase, double pPrecio )
    {
        numero = pNumero;
        cantidadTotalSillas = pCantidadSillas;
        cantidadSillasDisponibles = pCantidadSillas;
        clase = pClase;
        precio = pPrecio;
        // TODO Parte1 PuntoB: Inicializar el atributo siguienteVagon en null.
        siguienteVagon = null;
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el número del vagón.
     * @return Número del vagón.
     */
    public int darNumero( )
    {
        return numero;
    }
    
    /**
     * Retorna la cantidad total de sillas en el vagón.
     * @return Cantidad total de sillas.
     */
    public int darCantidadTotalSillas( )
    {
        return cantidadTotalSillas;
    }

    /**
     * Retorna la cantidad de sillas disponibles en el vagón.
     * @return Cantidad de sillas disponibles.
     */
    public int darCantidadSillasDisponibles( )
    {
        return cantidadSillasDisponibles;
    }

    /**
     * Retorna la clase del vagón.
     * @return Clase del vagón.
     */
    public String darClase( )
    {
        return clase;
    }

    /**
     * Retorna el precio de un tiquete.
     * @return Precio de un tiquete.
     */
    public double darPrecio( )
    {
        return precio;
    }

    /**
     * Retorna el siguiente vagón.
     * @return Siguiente vagón.
     */
    // TODO Parte1 PuntoC: Agregar el método darSiguiente de acuerdo a la documentación.
    public Vagon darSiguiente( )
    {
    	return siguienteVagon;
    }

    /**
     * Cambia el siguiente vagón por el vagón dado por parámetro.<br>
     * <b>post:</b> El vagón siguiente fue cambiado por el vagón dado por parámetro.<br>
     * @param pSiguienteVagon Vagón a asignar como siguiente. pSiguienteVagon != null.
     */
    // TODO Parte1 PuntoD: Agregar el método cambiarSiguiente de acuerdo a la documentación.
    public void cambiarSiguiente( Vagon pSiguienteVagon )
    {
    	siguienteVagon = pSiguienteVagon;
    }

    /**
     * Vende un tiquete en el vagón si hay sillas disponibles.<br>
     * <b>post:</b> Se disminuye en 1 la cantidad de sillas disponibles.<br>
     * @return True si el tiquete fue vendido, false de lo contrario.
     */
    public boolean venderTiquete( )
    {
        boolean vendido = false;
        if( cantidadSillasDisponibles > 0 )
        {
            cantidadSillasDisponibles--;
            vendido = true;
        }

        return vendido;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Método que verifica el invariante de la clase. <br>
     * <b>inv:</b><br>
     * La cantidad de sillas disponibles es mayor o igual a 0. <br>
     * La clase pertenece a alguno de los valores del arreglo de constantes. <br>
     * El precio es mayor o igual a 0. <br>
     * El número de vagón es mayor a 0.<br>
     */
    private void verificarInvariante( )
    {
        assert cantidadSillasDisponibles >= 0 : "El número de sillas no puede ser negativo.";
        assert clase != null && clase != "" && clasePerteneceAConstante( ) : "La clase del vagón no es válida.";
        assert precio >= 0 : "El precio no puede ser negativo.";
        assert numero > 0 : "El número de vagón debe ser positivo.";
    }

    /**
     * Retorna true si la clase del vagón pertenece a alguna constante de CLASES, false de lo contrario.
     * @return True si la clase del vagón pertenece a alguna constante de CLASES, false de lo contrario.
     */
    private boolean clasePerteneceAConstante( )
    {
        boolean pertenece = false;
        for( int i = 0; i < CLASES.length && !pertenece; i++ )
        {
            if( CLASES[ i ].equals( clase ) )
            {
                pertenece = true;
            }
        }
        return pertenece;
    }
}