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
import co.edu.uniandes.cupi2.subastas.mundo.Celular.Gama;

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
	private Celular celular2;

	/**
	 * El celular número 3 de la subasta.
	 */
	private Celular celular3;

	/**
	 * El celular número 4 de la subasta.
	 */
	//TODO Parte4 Punto 1: declarar el atributo según la documentación dada.
	private Celular celular4;
	

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Construye la Subasta con los cuatro celulares.<br>
	 * <b>post: </b> Se crearon los cuatro celulares con los valores por parámetro modelo, costo base y marca.
	 * Celular1 - Modelo: Galaxy Note, Precio base: 50000, Marca: Samsung, Gama: media.
	 * Celular2 - Modelo: LG Z, Precio base: 50000, Marca: LG, Gama: baja.
	 * Celular3 - Modelo: iPhone, Precio base: 50000, Marca: Apple, Gama: Alta.
	 * Celular4 - Modelo: Pixel, Precio base: 50000, Marca: Google, Gama: Alta.
	 */
	public Subasta( )
	{

		celular1 = new Celular( "Galaxy Note", 50000, "Samsung", Gama.MEDIA);
		celular2 = new Celular( "LG Z", 50000, "LG", Gama.BAJA);
		
		//TODO Parte4 Punto 2: completar el celular 3 y 4 según la documentación dada

		celular3 = new Celular( "iPhone", 50000, "Apple", Gama.ALTA);
		celular4 = new Celular( "Pixel", 50000, "Google", Gama.ALTA);
		
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
		return celular2;
	}

	/**
	 * Retorna el celular número 3 de la subasta.
	 * @return El celular número 3 de la subasta.
	 */
	public Celular darCelular3( )
	{
		return celular3;
	}

	/**
	 * Retorna el celular número 4 de la subasta.
	 * @return El celular número 4 de la subasta.
	 */
	public Celular darCelular4( )
	{
		//TODO Parte4 Punto 3: Completar el método según la documentación dada.
		return celular4;
	}


	/**
	 * Reinicia la subasta al estado inicial. Todos los celulares reinician el número de ofertas,
	 * el valor total de sus ofertas y ningún celular ha sido vendido.
	 */
	public void reiniciarSubasta( )
	{
		celular1.reiniciarNumeroOfertas( );
		celular1.reiniciarValorTotalOfertas( );
		celular1.reiniciarVendido();

		celular2.reiniciarNumeroOfertas( );
		celular2.reiniciarValorTotalOfertas( );
		celular2.reiniciarVendido();

		celular3.reiniciarNumeroOfertas( );
		celular3.reiniciarValorTotalOfertas( );
		celular3.reiniciarVendido();

		//TODO Parte4 Punto 4: Completar el método según la documentación dada.

		celular4.reiniciarNumeroOfertas( );
		celular4.reiniciarValorTotalOfertas( );
		celular4.reiniciarVendido();
	}

	/**
	 * Devuelve el número total de ofertas realizadas por los cuatro celulares.
	 * @return La sumatoria del número de ofertas realizadas por los cuatro celulares.
	 */
	public int calcularTotalOfertas( )
	{
		return celular1.darNumeroOfertas() + 
				celular2.darNumeroOfertas() + 
				celular3.darNumeroOfertas() +
				celular4.darNumeroOfertas();
	}
	
	
	/**
	 * Devuelve el número total de ofertas realizadas por los cuatro celulares.
	 * @return La sumatoria del número de ofertas realizadas por los cuatro celulares.
	 */
	public int calcularNumeroTotalOfertas( )
	{
		return celular1.darNumeroOfertas() + 
				celular2.darNumeroOfertas() + 
				celular3.darNumeroOfertas() +
				celular4.darNumeroOfertas();
	}

	/**
	 * Devuelve el valor total recaudado por las ofertas de los cuatro celulares.
	 * @return La sumatoria del valor total de las ofertas realizadas por los cuatro celulares.
	 */
	public int calcularValorTotalRecaudado( )
	{
		return celular1.darValorTotalOfertas() + 
				celular2.darValorTotalOfertas() + 
				celular3.darValorTotalOfertas() +
				celular4.darValorTotalOfertas();
	}

	/**
	 * Calcula el promedio del incremento del costo base de todos los celulares.
	 * @return La sumatoria del incremento del costo base de cada uno de los celulares divido por la cantidad de celulares.   */
	public double calcularIncrementoPromedioCostoBase( )
	{
		return (celular1.calcularIncrementoCostoBase() + 
				celular2.calcularIncrementoCostoBase() + 
				celular3.calcularIncrementoCostoBase() +
				celular4.calcularIncrementoCostoBase())/4;
	}
	
	/**
	 * Registra una oferta mínima para el celular cuyo modelo sea igual al que se pasa por parámetro.
	 * @param pModelo. parámetro que indica el modelo del celular.
	 * @return true en el caso de que se haya podido realizar el registro. false de lo contrario
	 */
	public boolean registrarOfertaMinimaCelular(String pModelo)
	{
		//TODO Parte4 Punto 5: Completar el método según la documentación dada.
		
		boolean registro = false;
		
		if(celular1.darModelo().equals(pModelo) && !(celular1.estaVendido()))
		{
			celular1.registrarOfertaMinima();
			registro = true;
		}
		else if(celular2.darModelo().equals(pModelo) && !(celular2.estaVendido()))
		{
			celular2.registrarOfertaMinima();
			registro = true;
		}
		else if(celular3.darModelo().equals(pModelo) && !(celular3.estaVendido()))
		{
			celular3.registrarOfertaMinima();
			registro = true;
		}
		else if(celular4.darModelo().equals(pModelo) && !(celular4.estaVendido()))
		{
			celular4.registrarOfertaMinima();
			registro = true;
		}
		return registro;
	}

	/**
	 * Registra una oferta moderada para el celular cuyo modelo sea igual al que se pasa por parámetro.
	 * @param pModelo. parámetro que indica el modelo del celular.
	 * @return true en el caso de que se haya podido realizar el registro. false de lo contrario.
	 */
	public boolean registrarOfertaModeradaCelular(String pModelo )
	{
		//TODO Parte4 Punto 6: Completar el método según la documentación dada.
		
		boolean registro = false;
		
		if(celular1.darModelo().equals(pModelo) && !(celular1.estaVendido()))
		{
			celular1.registrarOfertaModerada();
			registro = true;
		}
		else if(celular2.darModelo().equals(pModelo) && !(celular2.estaVendido()))
		{
			celular2.registrarOfertaModerada();
			registro = true;
		}
		else if(celular3.darModelo().equals(pModelo) && !(celular3.estaVendido()))
		{
			celular3.registrarOfertaModerada();
			registro = true;
		}
		else if(celular4.darModelo().equals(pModelo) && !(celular4.estaVendido()))
		{
			celular4.registrarOfertaModerada();
			registro = true;
		}
		return registro;
		
	}



	/**
	 * Registra una oferta abierta para el celular con el modelo dado por parámetro y la cantidad a subastar.
	 * @param pMonto Valor de la oferta. pMonto > 0.
	 * @param pModelo. parámetro que indica el modelo del celular.
	 * @return true en el caso de que se haya podido realizar el registro. false de lo contrario.
	 */
	public boolean registrarOfertaAbiertaCelular( int pMonto, String pModelo )
	{
		//TODO Parte4 Punto 7: Completar el método según la documentación dada.
		
		boolean registro = false;

		if( pMonto>0 )
		{
			if(celular1.darModelo().equals(pModelo) && !(celular1.estaVendido()) )
			{
				celular1.registrarOfertaAbierta(pMonto);
				registro = true;
			}
			else if(celular2.darModelo().equals(pModelo) && !(celular2.estaVendido()) )
			{
				celular2.registrarOfertaAbierta(pMonto);
				registro = true;
			}
			else if(celular3.darModelo().equals(pModelo) && !(celular3.estaVendido()))
			{
				celular3.registrarOfertaAbierta(pMonto);
				registro = true;
			}
			else if(celular4.darModelo().equals(pModelo) && !(celular4.estaVendido()) )
			{
				celular4.registrarOfertaAbierta(pMonto);
				registro = true;
			}
		}
		
		return registro;
		
	}
	
	/**
	 * Vende el celular cuyo modelo sea igual a que se pasa por parámetro.
	 * @param pModelo. parámetro que indica el modelo del celular.
	 * @return true en el caso de que se haya podido realizar el registro. false de lo contrario.
	 */
	//TODO Parte4 Punto 8: Crear e implementar el método venderCelular según la documentación dada y el modelo del mundo.
	
	public boolean venderCelular(String pModelo)
	{
		
		boolean registro = false;
		
		if(celular1.darModelo().equals(pModelo) && !(celular1.estaVendido()) )
		{
			celular1.vender();
			registro = true;
		}
		else if(celular2.darModelo().equals(pModelo) && !(celular2.estaVendido()))
		{
			celular2.vender();
			registro = true;
		}
		else if(celular3.darModelo().equals(pModelo) && !(celular3.estaVendido()) )
		{
			celular3.vender();
			registro = true;
		}
		else if(celular4.darModelo().equals(pModelo) && !(celular4.estaVendido()) )
		{
			celular4.vender();
			registro = true;
		}
		
		return registro;
	}

	/**
	 * Retorna el celular que mas ofertas ha tenido. En el caso de que existan 2 celulares que tengan el mismo número de ofertas, se retorna cualquiera de los 2. 
	 * @return El celular que ha tenido más ofertas. Si no hay ofertas para ningún celular, retorna null.
	 */
	//TODO Parte4 Punto 9: Crear e implementar el método darCelularConMasOfertas según la documentación dada y el modelo del mundo.
	
	public Celular darCelularConMasOfertas()
	{
		Celular celular_mas_ofertas = null; 
		
		if(celular1.darNumeroOfertas()!=0)
		{
			celular_mas_ofertas = celular1;
		}
		if(celular2.darNumeroOfertas()>celular1.darNumeroOfertas())
		{
			celular_mas_ofertas = celular2;
		}
		if(celular3.darNumeroOfertas()>celular2.darNumeroOfertas())
		{
			celular_mas_ofertas = celular3;
		}
		if(celular4.darNumeroOfertas()>celular3.darNumeroOfertas())
		{
			celular_mas_ofertas = celular4;
		}
		
		return celular_mas_ofertas;
		
	}

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * método para la extension 1
	 * @return respuesta1
	 */
	public String metodo1( )
	{
		return "Respuesta 1";
	}

	/**
	 * método para la extension 2
	 * @return respuesta2
	 */
	public String metodo2( )
	{
		return "Respuesta 2";
	}

}