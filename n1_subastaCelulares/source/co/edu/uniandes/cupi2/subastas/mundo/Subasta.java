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
 * Clase que representa la subasta.
 */
public class Subasta
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El celular número 1 de la subasta.
     */
    private Celular celular1;

    /**
     * El celular número 2 de la subasta.
     */
    // TODO Parte3 PuntoA: Declarar el atributo para modelar el celular número 2.
    
    private Celular celular2;

    /**
     * El celular número 3 de la subasta.
     */
    // TODO Parte3 PuntoB: Declarar el atributo para modelar el celular número 3.
    
    private Celular celular3;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Contruye la Subasta con los tres celulares.<br>
     * <b>post: </b> Se crearon los tres celulares con los valores por parámetro modelo, costo base y marca.
     * Celular1 - Modelo: Galaxy Note, Precio base: 50000, Marca: Samsung.
     * Celular2 - Modelo: LG Z, Precio base: 50000, Marca: LG.
     * Celular3 - Modelo: iPhone, Precio base: 50000, Marca: Apple.
     */
    public Subasta( )
    {

        celular1 = new Celular( "Galaxy Note", 50000, "Samsung" );

        // TODO Parte3 PuntoC: Crear el celular 2 y el celular 3.
        
        celular2 = new Celular( "LG Z", 50000, "LG");
        celular3 = new Celular( "iPhone", 50000, "Apple");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Retorna el celular número 1 de la subasta.
     * @return El celular número 1 de la subasta.
     */
    public Celular darCelular1( )
    {
        return celular1;
    }

    /**
     * Retorna el celular número 2 de la subasta.
     * @return El celular número 2 de la subasta.
     */
    public Celular darCelular2( )
    {
    	//TODO Parte3 PuntoD: Completar el método según la documentación.
    	return celular2;
    }

    /**
     * Retorna el celular número 3 de la subasta.
     * @return El celular número 3 de la subasta.
     */
    public Celular darCelular3( )
    {
    	//TODO Parte3 PuntoE: Completar el método según la documentación.
    	return celular3;
    }

    /**
	 * Reinicia la subasta al estado inicial. Todos los celulares reinician el número de ofertas y el valor total de sus ofertas.
	 */
	public void reiniciarSubasta( )
	{
	    celular1.reiniciarNumeroOfertas( );
	    celular1.reiniciarValorTotalOfertas( );
	
	    // TODO Parte3 PuntoF: Reiniciar el celular 2 y el celular 3.
	    celular2.reiniciarNumeroOfertas();
	    celular2.reiniciarValorTotalOfertas();
	    
	    celular3.reiniciarNumeroOfertas();
	    celular3.reiniciarValorTotalOfertas();
	    
	}

	/**
     * Devuelve el número total de ofertas realizadas por los tres celulares.
     * @return La sumatoria del número de ofertas realizadas por los tres celulares.
     */
    public int calcularNumeroTotalOfertas( )
    {
    	//TODO Parte3 PuntoG: Completar el método según la documentación.
    	return celular1.darNumeroOfertas() + celular2.darNumeroOfertas() + celular3.darNumeroOfertas(); 
    }

    /**
     * Devuelve el valor total recaudado por las ofertas de los tres celulares.
     * @return La sumatoria del valor total de las ofertas realizadas por los tres celulares.
     */
    public int calcularValorTotalRecaudado( )
    {
    	//TODO Parte3 PuntoH: Completar el método según la documentación.
    	return celular1.darValorTotalOfertas() + celular2.darValorTotalOfertas() + celular3.darValorTotalOfertas();
    }

    /**
     * Calcula el promedio del incremento del costo base de todos los celulares.
     * @return La sumatoria del incremento del costo base de cada uno de los celulares divido por la cantidad de celulares.   
     */
    public double calcularIncrementoPromedioCostoBase( )
    {
    	//TODO Parte3 PuntoI: Completar el método según la documentación.
    	return (celular1.calcularIncrementoCostoBase() + celular2.calcularIncrementoCostoBase() + celular3.calcularIncrementoCostoBase())/3;
    }

    /**
     * Registra una oferta mínima para el celular 1.
     */
    public void registrarOfertaMinimaCelular1( )
    {
        celular1.registrarOfertaMinima( );
    }

    /**
     * Registra una oferta moderada para el celular 1.
     */
    public void registrarOfertaModeradaCelular1( )
    {
        celular1.registrarOfertaModerada( );
    }

    /**
     * Registra una oferta abierta con el valor dado por parámetro para el celular 1.
     * @param pMonto Valor de la oferta. pMonto > 0.
     */
    public void registrarOfertaAbiertaCelular1( int pMonto )
    {
        celular1.registrarOfertaAbierta( pMonto );
    }

    /**
     * Registra una oferta mínima para el celular 2.
     */
    public void registrarOfertaMinimaCelular2( )
    {
    	//TODO Parte3 PuntoJ: Completar el método según la documentación.
    	celular2.registrarOfertaMinima( );
    }

    /**
     * Registra una oferta moderada para el celular 2.
     */
    public void registrarOfertaModeradaCelular2( )
    {
    	//TODO Parte3 PuntoK: Completar el método según la documentación.
    	celular2.registrarOfertaModerada( );
    }

    /**
     * Registra una oferta abierta con el valor dado por parámetro para el celular 2.
     * @param pMonto Valor de la oferta. pMonto > 0.
     */
    public void registrarOfertaAbiertaCelular2( int pMonto )
    {
    	//TODO Parte3 PuntoL: Completar el método según la documentación.
    	celular2.registrarOfertaAbierta( pMonto );
    }

    /**
     * Registra una oferta mínima para el celular 3.
     */
    public void registrarOfertaMinimaCelular3( )
    {
    	//TODO Parte3 PuntoM: Completar el método según la documentación.
    	celular3.registrarOfertaMinima( );
    }

    /**
     * Registra una oferta moderada para el celular 3.
     */
    public void registrarOfertaModeradaCelular3( )
    {
    	//TODO Parte3 PuntoN: Completar el método según la documentación.
    	celular3.registrarOfertaModerada( );
    }

    /**
     * Registra una oferta abierta con el valor dado por parámetro para el celular 3.
     * @param pMonto Valor de la oferta. pMonto > 0.
     */
    public void registrarOfertaAbiertaCelular3( int pMonto )
    {
    	//TODO Parte3 PuntoO: Completar el método según la documentación.
    	celular3.registrarOfertaAbierta( pMonto );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}