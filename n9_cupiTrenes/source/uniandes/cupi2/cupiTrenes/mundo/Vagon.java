/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase que representa el vag�n de un tren. <br>
 * <b>inv:</b><br>
 * La cantidad de sillas disponibles es mayor o igual a 0. <br>
 * La clase pertenece a alguno de los valores del arreglo de constantes. <br>
 * El precio es mayor o igual a 0. <br>
 * El n�mero de vag�n es mayor a 0.<br>
 */
public class Vagon implements Serializable
{

    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante de serializaci�n de la clase.
     */
    private static final long serialVersionUID = 9015954459189238070L;

    /**
     * Arreglo de constantes que contiene las clases posibles para un vag�n.
     */
    public final static String[] CLASES = { "Primera clase", "Segunda clase", "Negocios", "VIP" };

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * N�mero del vag�n.
     */
    private int numero;
    
    /**
     * Cantidad total de sillas en el vag�n.
     */
    private int cantidadTotalSillas;

    /**
     * Cantidad de sillas disponibles en el vag�n.
     */
    private int cantidadSillasDisponibles;

    /**
     * Clase del vag�n.
     */
    private String clase;

    /**
     * Precio de un tiquete.
     */
    private double precio;

    /**
     * Siguiente vag�n.
     */
    // TODO Parte1 PuntoA: Declarar el atributo que referencia el siguiente vag�n.
    
    private Vagon siguienteVagon; 
    

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Constructor de la clase. <br>
     * <b>post: </b>Se construye un nuevo vag�n con la informaci�n dada por par�metro.
     * @param pNumero N�mero del vag�n. pNumero > 0.
     * @param pCantidadSillas Cantidad de sillas en el vag�n. pCantidadSillasDisponibles >= 0.
     * @param pClase Clase del vag�n. pClase pertenece a CLASES.
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
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el n�mero del vag�n.
     * @return N�mero del vag�n.
     */
    public int darNumero( )
    {
        return numero;
    }
    
    /**
     * Retorna la cantidad total de sillas en el vag�n.
     * @return Cantidad total de sillas.
     */
    public int darCantidadTotalSillas( )
    {
        return cantidadTotalSillas;
    }

    /**
     * Retorna la cantidad de sillas disponibles en el vag�n.
     * @return Cantidad de sillas disponibles.
     */
    public int darCantidadSillasDisponibles( )
    {
        return cantidadSillasDisponibles;
    }

    /**
     * Retorna la clase del vag�n.
     * @return Clase del vag�n.
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
     * Retorna el siguiente vag�n.
     * @return Siguiente vag�n.
     */
    // TODO Parte1 PuntoC: Agregar el m�todo darSiguiente de acuerdo a la documentaci�n.
    public Vagon darSiguiente( )
    {
    	return siguienteVagon;
    }

    /**
     * Cambia el siguiente vag�n por el vag�n dado por par�metro.<br>
     * <b>post:</b> El vag�n siguiente fue cambiado por el vag�n dado por par�metro.<br>
     * @param pSiguienteVagon Vag�n a asignar como siguiente. pSiguienteVagon != null.
     */
    // TODO Parte1 PuntoD: Agregar el m�todo cambiarSiguiente de acuerdo a la documentaci�n.
    public void cambiarSiguiente( Vagon pSiguienteVagon )
    {
    	siguienteVagon = pSiguienteVagon;
    }

    /**
     * Vende un tiquete en el vag�n si hay sillas disponibles.<br>
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
     * M�todo que verifica el invariante de la clase. <br>
     * <b>inv:</b><br>
     * La cantidad de sillas disponibles es mayor o igual a 0. <br>
     * La clase pertenece a alguno de los valores del arreglo de constantes. <br>
     * El precio es mayor o igual a 0. <br>
     * El n�mero de vag�n es mayor a 0.<br>
     */
    private void verificarInvariante( )
    {
        assert cantidadSillasDisponibles >= 0 : "El n�mero de sillas no puede ser negativo.";
        assert clase != null && clase != "" && clasePerteneceAConstante( ) : "La clase del vag�n no es v�lida.";
        assert precio >= 0 : "El precio no puede ser negativo.";
        assert numero > 0 : "El n�mero de vag�n debe ser positivo.";
    }

    /**
     * Retorna true si la clase del vag�n pertenece a alguna constante de CLASES, false de lo contrario.
     * @return True si la clase del vag�n pertenece a alguna constante de CLASES, false de lo contrario.
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