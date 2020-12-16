/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_subastaCelulares
 * Autor: Equipo Cupi2 - 201910
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.cupi2.subastas.mundo;

/**
 * Clase que representa un celular en la subasta.
 */
public class Celular
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El modelo del celular.
     */
    private String modelo;

    /**
     * El costo base del celular.
     */
    private int costoBase;

    /**
     * La marca del celular.
     */
    private String marca;

    /**
     * El valor del total de ofertas por el celular.
     */
    
    // TODO Parte2 PuntoA: Declarar el atributo para modelar el valor total de las ofertas (valor entero).
    private int valorTotalOfertas;
    
    /**
     * El número de ofertas realizadas por el celular.
     */
    
    // TODO Parte2 PuntoB: Declarar el atributo para modelar el número de ofertas realizadas (valor entero).
    private int numeroOfertas;
    
    
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
	 * Crea un celular con los valores que llegan como parámetro<br>
	 * <b>post: </b> Se inicializaron los atributos modelo, costoBase, marca con los valores recibidos como parámetros. <br>
	 * El número de ofertas y el valor total de las ofertas se inicializaron en cero. <br>
	 * @param pModelo Modelo del celular. pModelo != null && !pModelo.equals("").
	 * @param pCostoBase Costo base del celular. pCostoBase>0.
	 * @param pMarca Marca del celular. pMarca != null && !pMarca.equals("").
	 */
	public Celular( String pModelo, int pCostoBase, String pMarca )
	{
	    modelo = pModelo;
	    costoBase = pCostoBase;
	    marca = pMarca;
	    //TODO Parte2 PuntoC: Completar el método según la documentación. El valor total de ofertas y y el número de ofertas
	    //deben inicializarse en cero.
	    valorTotalOfertas = 0;
	    numeroOfertas = 0;
	    
	}
	
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------


	/**
     * Retorna el modelo del celular.
     * @return Modelo del celular.
     */
    public String darModelo( )
    {
        return modelo;
    }

    /**
     * Retorna el costo base del celular.
     * @return Costo base del celular.
     */
    public int darCostoBase( )
    {
    	 //TODO Parte2 PuntoD: Implementar el método según la documentación
    	return costoBase;
    }

    /**
     * Retorna la marca del celular.
     * @return Marca del celular.
     */
    public String darMarca( )
    {
    	//TODO Parte2 PuntoE: Implementar el método según la documentación
    	return marca;
    }

    /**
     * Retorna el valor del total de ofertas por el celular.
     * @return el valor del total de ofertas por el celular.
     */
    public int darValorTotalOfertas( )
    {
        return valorTotalOfertas;
    }

    /**
     * Retorna el número de ofertas realizadas por el celular.
     * @return el número de ofertas realizadas por el celular.
     */
    public int darNumeroOfertas( )
    {
        return numeroOfertas;
    }

    /**
     * Registra una oferta mínima por el celular.<br>
     * <b>post: </b> Se adiciona al valor total de las ofertas la suma de $50.000 y se incrementa el número de ofertas en 1.
     */
    public void registrarOfertaMinima( )
    {
        valorTotalOfertas = valorTotalOfertas + 50000;
        numeroOfertas = numeroOfertas + 1;
    }

    /**
     * Registra una oferta moderada por el celular.<br>
     * <b>post: </b> Se adiciona al valor total de las ofertas la suma de $100.000 y se incrementa el número de ofertas en 1.
     */
    public void registrarOfertaModerada( )
    {
    	//TODO Parte2 PuntoF: Implementar el método según la documentación
    	valorTotalOfertas = valorTotalOfertas + 100000;
    	numeroOfertas = numeroOfertas + 1;
    }

    /**
     * Registra una nueva oferta abierta para el celular. <br>
     * <b>post: </b> Se adiciona al valor total de las ofertas el monto recibido por parámetro y se incrementa el número de ofertas en 1.
     * @param pMonto Monto ofertado por el Celular. pMonto > 0.
     */
    public void registrarOfertaAbierta( int pMonto )
    {
    	//TODO Parte2 PuntoG: Implementar el método según la documentación
    	valorTotalOfertas = valorTotalOfertas + pMonto;
    	numeroOfertas = numeroOfertas + 1;
    }

    /**
     * Calcula la diferencia entre el valor total de las ofertas y el costo base del celular.
     * @return Incremento del costo base.
     */
    public int calcularIncrementoCostoBase( )
    {
    	//TODO Parte2 PuntoH: Implementar el método según la documentación
    	return valorTotalOfertas - costoBase;
    }

    /**
     * Se reinicia el número de ofertas. <br>
     * <b>post: </b> numeroOfertas = 0.
     */
    public void reiniciarNumeroOfertas( )
    {
    	//TODO Parte2 PuntoI: Implementar el método según la documentación
    	numeroOfertas = 0;
    }

    /**
     * Se reinicia el valor total de las ofertas. <br>
     * <b>post: </b> valorTotalOfertas = 0.
     */
    public void reiniciarValorTotalOfertas( )
    {
        valorTotalOfertas = 0;
    }

}