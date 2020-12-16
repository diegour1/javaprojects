/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_subastaCelulares
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
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Representa el precio de oferta mínima que puede hacerse sobre la gama alta.
	 */
	
	public final static int OFERTA_MIN_GAMA_ALTA = 60000;

	/**
	 * Representa el precio de oferta mínima que puede hacerse sobre la gama media.
	 */
	// TODO Parte2 Punto 1: cree la constante según la documentación
	
	public final static int OFERTA_MIN_GAMA_MEDIA = 40000;


	/**
	 * Representa el precio de oferta mínima que puede hacerse sobre la gama baja.
	 */
	// TODO Parte2 Punto 2: cree la constante según la documentación

	public final static int OFERTA_MIN_GAMA_BAJA = 20000;
	
	/**
	 * Representa el precio de oferta moderada que puede hacerse sobre la gama baja.
	 */
	// TODO Parte2 Punto 3: cree la constante según la documentación\
	
	public final static int OFERTA_MODERADA_GAMA_BAJA = 40000;
	
	/**
	 * Representa el precio de oferta moderada que puede hacerse sobre la gama media.
	 */
	// TODO Parte2 Punto 4: cree la constante según la documentación

	public final static int OFERTA_MODERADA_GAMA_MEDIA = 60000;
	/**
	 * Representa el precio de oferta moderada que puede hacerse sobre la gama alta.
	 */
	// TODO Parte2 Punto 5: cree la constante según la documentación
	
	public final static int OFERTA_MODERADA_GAMA_ALTA = 80000;

	// -----------------------------------------------------------------
	// Enumeraciones
	// -----------------------------------------------------------------
	/**
	 * Define las posibles gamas de los celulares.
	 */
	//TODO Parte3 Punto 1: Crear la enumeración según la documentación dada
	
	public enum Gama
	{
		BAJA,
		MEDIA,
		ALTA
	}


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
	private int valorTotalOfertas;

	/**
	 * El número de ofertas realizadas por el celular.
	 */
	private int numeroOfertas;

	/**
	 * Gama del celular
	 */
	private Gama gama;

	/**
	 *Atributo que indica si el celular ya ha sido vendido.
	 */
	//TODO Parte3 Punto 3: completar la enumeración según la documentación dada
	
	private boolean vendido;


	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Crea un celular con los valores que llegan como parámetro<br>
	 * <b>post: </b> Se inicializaron los atributos modelo, costoBase, Gama, marca con
	 * los valores recibidos como parámetros. <br> El número de ofertas y el valor
	 * total de las ofertas se inicializaron en cero. <br> vendido se inicializa como
	 * falso.
	 * 
	 * @param pModelo    Modelo del celular. pModelo != null && !pModelo.equals("").
	 * @param pCostoBase    Costo base del celular. pCostoBase>0.
	 * @param pMarca    Marca del celular. pMarca != null && !pMarca.equals("").
	 * @param pGama    Gama del celular. pGama != null.
	 */
	public Celular( String pModelo, int pCostoBase, String pMarca, Gama pGama )
	{
		//TODO Parte3 Punto 4: Completar el método según la documentación.
		modelo = pModelo;
		costoBase = pCostoBase;
		marca = pMarca;
		gama = pGama;
		numeroOfertas = 0;
		valorTotalOfertas = 0;
		vendido = false;
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
		return costoBase;
	}

	/**
	 * Retorna la marca del celular.
	 * @return Marca del celular.
	 */
	public String darMarca( )
	{
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
	 * Retorna el tipo de gama al que el celular pertenece.
	 * @return el tipo de gama.
	 */
	public Gama darGama( )
	{
		//TODO Parte3 Punto 5:  Completar el método según la documentación dada.
		return gama;
	}

	/**
	 * Retorna si el celular ha sido vendido.
	 * @return true si el celular fue vendido, false de lo contrario.
	 */
	public boolean estaVendido()
	{
		return vendido;
	}

	/**
	 * Registra una oferta mínima por el celular si el celular no ha sido vendido.
	 * <br>
	 * <b>post: </b> Se adiciona al valor total de ofertar la suma de 
	 * OFERTA_MIN_GAMA_BAJA en caso de que el celular sea de gama baja,
	 * OFERTA_MIN_GAMA_MEDIA en caso de que sea de gama media y 
	 * OFERTA_MIN_GAMA_ALTA en el caso de que sea de gama alta. Se incrementa
	 * el número de ofertas en 1.
	 * @return true si se logro hacer el registro, false de lo contrario.
	 */
	public boolean registrarOfertaMinima( )
	{
		//TODO Parte3 Punto 7:  Completar el método según la documentación dada.
		
		boolean registro = false;
		if(estaVendido() == false && gama == Gama.BAJA)
		{
			valorTotalOfertas+=OFERTA_MIN_GAMA_BAJA;
			numeroOfertas++;
			registro = true;
		} 
		else if(estaVendido() == false && gama == Gama.MEDIA)
		{
			valorTotalOfertas+=OFERTA_MIN_GAMA_MEDIA;
			numeroOfertas++;
			registro = true;
		}
		else if(estaVendido() == false && gama == Gama.ALTA)
		{
			valorTotalOfertas+=OFERTA_MIN_GAMA_ALTA;
			numeroOfertas++;
			registro = true;
		}
		return registro;
	}

	/**
	 * Registra una oferta moderada por el celular si el celular no ha sido vendido.
	 * <br>
	 * <b>post: </b> Se adiciona al valor total de ofertar la suma de 
	 * OFERTA_MODERADA_GAMA_BAJA en caso de que el celular sea de gama baja,
	 * OFERTA_MODERADA_GAMA_MEDIA en caso de que sea de gama media y 
	 * OFERTA_MODERADA_GAMA_ALTA en el caso de que sea de gama alta. Se incrementa
	 * el número de ofertas en 1.
	 * @return true si se logro hacer el registro, false de lo contrario.
	 */
	public boolean registrarOfertaModerada( )
	{
		//TODO Parte3 Punto 8:  Completar el método según la documentación dada.
		
		boolean registro = false;
		if(estaVendido() == false && gama == Gama.BAJA)
		{
			valorTotalOfertas+=OFERTA_MODERADA_GAMA_BAJA;
			numeroOfertas++;
			registro = true;
		} 
		else if(estaVendido() == false && gama == Gama.MEDIA)
		{
			valorTotalOfertas+=OFERTA_MODERADA_GAMA_MEDIA;
			numeroOfertas++;
			registro = true;
		}
		else if(estaVendido() == false && gama == Gama.ALTA)
		{
			valorTotalOfertas+=OFERTA_MODERADA_GAMA_ALTA;
			numeroOfertas++;
			registro = true;
		}
		return registro;
	}

	/**
	 * Registra una nueva oferta abierta para el celular. si el monto introducido por
	 * parámetro es menor o igual a 0 o si el celular se ha vendido no se realiza el
	 * registro.  <br>
	 * <b>post: </b> Se adiciona al valor total de las ofertas el monto recibido por
	 * parámetro y se incrementa el número de ofertas en 1.
	 * @param pMonto Monto ofertado por el Celular.
	 * @return true si se logró registrar la subasta, false de lo contrario.
	 */
	public boolean registrarOfertaAbierta( int pMonto )
	{
		//TODO Parte3 Punto 9:  Completar el método según la documentación dada.
		
		boolean registro = false;
		if (pMonto > 0 && estaVendido() == false)
		{
			valorTotalOfertas+=pMonto;
			numeroOfertas++;
			registro = true;
		}
		return registro;
	}
	
	/**
	 * Vende el celular si este no ha sido vendido previamente. <br>
	 * <b>post: </b> El celular queda vendido.
	 * @return true si se logró vender el celular, false de lo contrario.
	 */
	public boolean vender() 
	{
		//TODO Parte3 Punto 10: Completar el método según la documentación dada.
		if(vendido == false)
		{
			vendido = true;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Calcula la diferencia entre el valor total de las ofertas y el costo base del celular.
	 * @return Incremento del costo base.
	 */
	public int calcularIncrementoCostoBase( )
	{
		return valorTotalOfertas-costoBase;
	}

	/**
	 * Se reinicia el número de ofertas. <br>
	 * <b>post: </b> numeroOfertas = 0.
	 */
	public void reiniciarNumeroOfertas( )
	{
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
	
	/**
	 * Se reinicia la venta del celular. <br>
	 * <b>post: </b> el celular no se ha vendido.
	 */
	public void reiniciarVendido( )
	{
		//TODO Parte3 Punto 11: Completar el método según la documentación dada.
		vendido = false;
	}

}