/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_subastaCelulares
 * Autor: Equipo Cupi2 - 201910
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.cupi2.subastas.test;

import co.edu.uniandes.cupi2.subastas.mundo.Subasta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.edu.uniandes.cupi2.subastas.mundo.Celular.Gama;


/**
 * Clase usada para verificar que los m�todos de la clase Subasta est�n correctamente implementados.
 */
public class SubastaTest 
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Clase donde se har�n las pruebas.
	 */
	private Subasta subasta;

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva Subasta.
	 */
	@Before
	public void setupEscenario1( )
	{
		subasta = new Subasta( );
	}

	/**
	 * Prueba 1: Verifica el m�todo inicializar<br>
	 * <b> M�todos a probar: </b> <br>
	 * inicializar<br>
	 * darCelular1<br>
	 * darCelular2<br>
	 * darCelular3<br>
	 * darCelular4<br>
	 * <b> Objetivo: </b> Probar inicializaci�n correcta del objeto Subasta<br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Inicializaci�n correcta de Subasta<br>
	 * 2. Inicializaci�n correcta de cada uno de los celulares.
	 */
	@Test
	public void testInicializar( )
	{
		assertNotNull( "La subasta  no deber�a ser nula.", subasta );

		assertNotNull( "Deber�a existir el celular1.", subasta.darCelular1( ) );
		assertEquals( "El modelo del celular1 no corresponde.", subasta.darCelular1( ).darModelo( ), "Galaxy Note" );
		assertEquals( "El precio base del celular1 no corresponde.", subasta.darCelular1( ).darCostoBase( ), 50000 );
		assertEquals( "La marca del celular1 no corresponde.", subasta.darCelular1( ).darMarca( ), "Samsung" );
		assertEquals( "La Gama del celular1 no corresponde.", subasta.darCelular1( ).darGama(), Gama.MEDIA);

		assertNotNull( "Deber�a existir el celular2.", subasta.darCelular2( ) );
		assertEquals( "El modelo del celular2 no corresponde.", subasta.darCelular2( ).darModelo( ), "LG Z" );
		assertEquals( "El precio base del celular2 no corresponde.", subasta.darCelular2( ).darCostoBase( ), 50000 );
		assertEquals( "La marca del celular2 no corresponde.", subasta.darCelular2( ).darMarca( ), "LG" );
		assertEquals( "La Gama del celular2 no corresponde.", subasta.darCelular2( ).darGama(), Gama.BAJA);

		assertNotNull( "Deber�a existir el celular3.", subasta.darCelular3( ) );
		assertEquals( "El modelo del celular3 no corresponde.", subasta.darCelular3( ).darModelo( ), "iPhone" );
		assertEquals( "El precio base del celular3 no corresponde.", subasta.darCelular3( ).darCostoBase( ), 50000 );
		assertEquals( "La marca del celular3 no corresponde.", subasta.darCelular3( ).darMarca( ), "Apple" );
		assertEquals( "La Gama del celular3 no corresponde.", subasta.darCelular3( ).darGama(), Gama.ALTA);

		assertNotNull( "Deber�a existir el celular4.", subasta.darCelular4( ) );
		assertEquals( "El modelo del celular4 no corresponde.", subasta.darCelular4( ).darModelo( ), "Pixel" );
		assertEquals( "El precio base del celular4 no corresponde.", subasta.darCelular4( ).darCostoBase( ), 50000 );
		assertEquals( "La marca del celular4 no corresponde.", subasta.darCelular4( ).darMarca( ), "Google" );
		assertEquals( "La Gama del celular4 no corresponde.", subasta.darCelular4( ).darGama(), Gama.ALTA);

	}

	/**
	 * Prueba 2: Verifica el m�todo registrarOfertaMinimaCelular<br>
	 * <b> M�todos a probar: </b> <br>
	 * registrarOfertaMinimaCelular<br>
	 * darCelular<br>
	 * <b> Objetivo: </b> Probar que se registren correctamente las ofertas m�nimas para todos los celulares.<br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Se registran correctamente las ofertas m�nimas para todos los celulares.
	 */
	@Test
	public void testRegistrarOfertaMinimaCelular( )
	{

		subasta.registrarOfertaMinimaCelular( "Galaxy Note" );
		assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular1( ).darValorTotalOfertas( ), 40000 );
		assertEquals( "El n�mero total de ofertas no corresponde.", subasta.darCelular1( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaMinimaCelular( "Galaxy Note" );
		assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular1( ).darValorTotalOfertas( ), 80000 );
		assertEquals( "El n�mero total de ofertas no corresponde.", subasta.darCelular1( ).darNumeroOfertas( ), 2 );
		
		subasta.registrarOfertaMinimaCelular("LG Z" );
		assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular2( ).darValorTotalOfertas( ), 20000 );
		assertEquals( "El n�mero total de ofertas no corresponde.", subasta.darCelular2( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaMinimaCelular("LG Z" );
		assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular2( ).darValorTotalOfertas( ), 40000 );
		assertEquals( "El n�mero total de ofertas no corresponde.", subasta.darCelular2( ).darNumeroOfertas( ), 2 );
		
		subasta.registrarOfertaMinimaCelular("iPhone");
		assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular3( ).darValorTotalOfertas( ), 60000 );
		assertEquals( "El n�mero total de ofertas no corresponde.", subasta.darCelular3( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaMinimaCelular( "iPhone" );
		assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular3( ).darValorTotalOfertas( ), 120000 );
		assertEquals( "El n�mero total de ofertas no corresponde.", subasta.darCelular3( ).darNumeroOfertas( ), 2 );
		
		subasta.registrarOfertaMinimaCelular( "Pixel");
		assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular4( ).darValorTotalOfertas( ), 60000 );
		assertEquals( "El n�mero total de ofertas no corresponde.", subasta.darCelular4( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaMinimaCelular("Pixel" );
		assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular4( ).darValorTotalOfertas( ), 120000 );
		assertEquals( "El n�mero total de ofertas no corresponde.", subasta.darCelular4( ).darNumeroOfertas( ), 2 );

	}



	/**
	 * Prueba 5: Verifica el m�todo registrarOfertaModeradaCelular<br>
	 * <b> M�todos a probar: </b> <br>
	 * registrarOfertaModeradaCelular1<br>
	 * darCelular1,<br>
	 * darCelular2,<br>
	 * darCelular3,<br>
	 * darCelular4,<br>
	 * <b> Objetivo: </b> Probar que se registren correctamente las ofertas moderadas para los celulares.<br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Se registran correctamente las ofertas moderadas para todos los celulares.
	 */
	@Test
	public void testRegistrarOfertaModeradaCelular( )
	{

		subasta.registrarOfertaModeradaCelular( "Galaxy Note" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 60000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaModeradaCelular( "Galaxy Note" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 120000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 2 );
		
		subasta.registrarOfertaModeradaCelular( "LG Z" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 40000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaModeradaCelular( "LG Z" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 80000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 2 );
		
		subasta.registrarOfertaModeradaCelular( "iPhone" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 80000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaModeradaCelular( "iPhone" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 160000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 2 );
		
		subasta.registrarOfertaModeradaCelular( "Pixel" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular4( ).darValorTotalOfertas( ), 80000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular4( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaModeradaCelular( "Pixel" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular4( ).darValorTotalOfertas( ), 160000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular4( ).darNumeroOfertas( ), 2 );
	}

	/**
	 * Prueba 8: Verifica el m�todo registrarOfertaAbiertaCelular<br>
	 * <b> M�todos a probar: </b> <br>
	 * registrarOfertaAbiertaCelular<br>
	 * darCelular1<br>
	 * darCelular2<br>
	 * darCelular3<br>
	 * darCelular4<br>
	 * <b> Objetivo: </b> Probar que se registren correctamente las ofertas abiertas para todos los celulares.<br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Se registran correctamente las ofertas abiertas para todos los celulares.
	 */
	@Test
	public void testRegistrarOfertaAbiertaCelular( )
	{

		subasta.registrarOfertaAbiertaCelular( 60000, "Galaxy Note" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 60000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaAbiertaCelular( 28000, "Galaxy Note" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 88000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 2 );

		subasta.registrarOfertaAbiertaCelular( 40000, "LG Z" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 40000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaAbiertaCelular( 36000, "LG Z" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 76000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 2 );

		subasta.registrarOfertaAbiertaCelular( 50000, "iPhone" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 50000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaAbiertaCelular( 27000, "iPhone" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 77000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 2 );

		subasta.registrarOfertaAbiertaCelular( 50000, "Pixel" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular4( ).darValorTotalOfertas( ), 50000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular4( ).darNumeroOfertas( ), 1 );

		subasta.registrarOfertaAbiertaCelular( 27000, "Pixel" );
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular4( ).darValorTotalOfertas( ), 77000 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular4( ).darNumeroOfertas( ), 2 );

	}


	/**
	 * Prueba 11: Verifica el m�todo reiniciarSubasta<br>
	 * <b> M�todos a probar: </b> <br>
	 * reiniciarSubasta<br>
	 * registrarOfertaAbiertaCelular<br>
	 * darCelular1<br>
	 * darCelular2<br>
	 * darCelular3<br>
	 * darCelular4<br>
	 * <b> Objetivo: </b> Probar que al reiniciar subasta, se reinicien los valores en todos los celulares.<br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. El valor total ofertado y el n�mero de ofertas de cada celular es 0.<br>
	 */
	@Test
	public void testReiniciarSubasta( )
	{

		subasta.registrarOfertaAbiertaCelular( 60000, "Galaxy Note" );
		subasta.registrarOfertaAbiertaCelular( 70000, "LG Z" );
		subasta.registrarOfertaAbiertaCelular( 80000, "iPhone" );

		subasta.reiniciarSubasta( );

		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 0 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 0 );
		assertFalse("El celular no se debio haber vendido",subasta.darCelular1().estaVendido());

		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 0 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 0 );
		assertFalse("El celular no se debio haber vendido",subasta.darCelular2().estaVendido());

		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 0 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 0 );
		assertFalse("El celular no se debio haber vendido",subasta.darCelular3().estaVendido());
		
		assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular4( ).darValorTotalOfertas( ), 0 );
		assertEquals( "El n�mero total de ofertas no correpsonde.", subasta.darCelular4( ).darNumeroOfertas( ), 0 );
		assertFalse("El celular no se debio haber vendido",subasta.darCelular4().estaVendido());

	}

	/**
	 * Prueba 12: Verifica el m�todo calcularNumeroTotalOfertas<br>
	 * <b> M�todos a probar: </b> <br>
	 * calcularNumeroTotalOfertas<br>
	 * registrarOfertaAbiertaCelular<br>
	 * <b> Objetivo: </b> Probar que al calcular el n�mero total de ofertas, se realice la suma de todos los celulares.<br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. El n�mero total de ofertas es la suma de los 4 celulares.<br>
	 */
	@Test
	public void testCalcularNumeroTotalOfertas( )
	{
		assertEquals( "El n�mero total de ofertas deber�a ser 0.", subasta.calcularNumeroTotalOfertas( ), 0 );

		subasta.registrarOfertaAbiertaCelular( 60000,  "Galaxy Note" );
		assertEquals( "El n�mero total de ofertas deber�a ser 1.", subasta.calcularNumeroTotalOfertas( ), 1 );

		subasta.registrarOfertaAbiertaCelular( 70000, "LG Z" );
		assertEquals( "El n�mero total de ofertas deber�a ser 2.", subasta.calcularNumeroTotalOfertas( ), 2 );

		subasta.registrarOfertaAbiertaCelular( 80000, "iPhone" );
		assertEquals( "El n�mero total de ofertas deber�a ser 3.", subasta.calcularNumeroTotalOfertas( ), 3 );

		subasta.registrarOfertaModeradaCelular( "Galaxy Note" );
		assertEquals( "El n�mero total de ofertas deber�a ser 4.", subasta.calcularNumeroTotalOfertas( ), 4 );

		subasta.registrarOfertaModeradaCelular( "LG Z" );
		assertEquals( "El n�mero total de ofertas deber�a ser 5.", subasta.calcularNumeroTotalOfertas( ), 5 );

		subasta.registrarOfertaModeradaCelular( "iPhone" );
		assertEquals( "El n�mero total de ofertas deber�a ser 6.", subasta.calcularNumeroTotalOfertas( ), 6 );

		subasta.registrarOfertaMinimaCelular( "Galaxy Note" );
		assertEquals( "El n�mero total de ofertas deber�a ser 7.", subasta.calcularNumeroTotalOfertas( ), 7 );

		subasta.registrarOfertaMinimaCelular( "LG Z" );
		assertEquals( "El n�mero total de ofertas deber�a ser 8.", subasta.calcularNumeroTotalOfertas( ), 8 );

		subasta.registrarOfertaMinimaCelular( "iPhone" );
		assertEquals( "El n�mero total de ofertas deber�a ser 9.", subasta.calcularNumeroTotalOfertas( ), 9 );

	}

	/**
	 * Prueba 13: Verifica el m�todo calcularValorTotalRecaudado<br>
	 * <b> M�todos a probar: </b> <br>
	 * calcularValorTotalRecaudado<br>
	 * registrarOfertaAbiertaCelular<br>
	 * <b> Objetivo: </b> Probar que al calcular el valor total recaudado, se realice la suma de todos los celulares.<br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. El valor total recaudado es la suma del recaudo los 4 celulares.<br>
	 */
	@Test
	public void testCalcularValorTotalRecaudado( )
	{
		assertEquals( "El valor total de ofertas deber�a ser 0.", subasta.calcularValorTotalRecaudado( ), 0 );

		subasta.registrarOfertaAbiertaCelular( 60000, "Galaxy Note" );
		assertEquals( "El valor total recaudado deber�a ser 60000.", subasta.calcularValorTotalRecaudado( ), 60000 );

		subasta.registrarOfertaAbiertaCelular( 70000, "LG Z" );
		assertEquals( "El valor total recaudado deber�a ser 130000.", subasta.calcularValorTotalRecaudado( ), 130000 );

		subasta.registrarOfertaAbiertaCelular( 80000, "iPhone" );
		assertEquals( "El valor total recaudado deber�a ser 210000.", subasta.calcularValorTotalRecaudado( ), 210000 );

		subasta.registrarOfertaModeradaCelular( "Galaxy Note" );
		assertEquals( "El valor total recaudado deber�a ser 270000.", subasta.calcularValorTotalRecaudado( ), 270000 );

		subasta.registrarOfertaModeradaCelular( "LG Z" );
		assertEquals( "El valor total recaudado deber�a ser 310000.", subasta.calcularValorTotalRecaudado( ), 310000 );

		subasta.registrarOfertaModeradaCelular( "iPhone" );
		assertEquals( "El valor total recaudado deber�a ser 390000.", subasta.calcularValorTotalRecaudado( ), 390000 );
		
		subasta.registrarOfertaModeradaCelular( "Pixel" );
		assertEquals( "El valor total recaudado deber�a ser 470000.", subasta.calcularValorTotalRecaudado( ), 470000 );

		subasta.registrarOfertaMinimaCelular("Galaxy Note" );
		assertEquals( "El valor total recaudado deber�a ser 510000.", subasta.calcularValorTotalRecaudado( ), 510000 );

		subasta.registrarOfertaMinimaCelular( "LG Z" );
		assertEquals( "El valor total recaudado deber�a ser 530000.", subasta.calcularValorTotalRecaudado( ), 530000 );

		subasta.registrarOfertaMinimaCelular( "iPhone" );
		assertEquals( "El valor total recaudado deber�a ser 590000.", subasta.calcularValorTotalRecaudado( ), 590000 );
		
		subasta.registrarOfertaMinimaCelular( "Pixel" );
		assertEquals( "El valor total recaudado deber�a ser 650000.", subasta.calcularValorTotalRecaudado( ), 650000 );
	}

	/**
	 * Prueba 14: verifica el m�todo calcularIncrementoPromedioCostoBase<br>
	 * <b> M�todos a probar: </b> <br>
	 * calcularIncrementoPromedioCostoBase<br>
	 * registrarOfertaAbiertaCelular1<br>
	 * registrarOfertaAbiertaCelular2<br>
	 * registrarOfertaAbiertaCelular3<br>
	 * <b> Objetivo: </b> Probar que al calcular el incremento promedio costo base, se calcule el promedio.<br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. El incremento promedio fue calculado correctamente.
	 */
	@Test
	public void testCalcularIncrementoPromedioCostoBase( )
	{
		subasta.registrarOfertaAbiertaCelular( 60000, "Galaxy Note" );
		subasta.registrarOfertaAbiertaCelular( 70000, "LG Z"  );
		subasta.registrarOfertaAbiertaCelular( 80000, "iPhone" );
		subasta.registrarOfertaAbiertaCelular( 70000,"Pixel" );
		

		assertEquals( "El incremento promedio deber�a ser 20000.", subasta.calcularIncrementoPromedioCostoBase( ), 20000, 0.1 );
		subasta.registrarOfertaModeradaCelular( "Galaxy Note" );

		assertEquals( "El incremento promedio deber�a ser 35000.", subasta.calcularIncrementoPromedioCostoBase( ), 35000, 0.1 );
		subasta.registrarOfertaModeradaCelular( "LG Z"  );

		assertEquals( "El incremento promedio deber�a ser 45000.", subasta.calcularIncrementoPromedioCostoBase( ), 45000, 0.1 );
		subasta.registrarOfertaModeradaCelular( "iPhone" );

		assertEquals( "El incremento promedio deber�a ser 65000.", subasta.calcularIncrementoPromedioCostoBase( ), 65000, 0.1 );
		subasta.registrarOfertaMinimaCelular( "Galaxy Note" );

		assertEquals( "El incremento promedio deber�a ser 75000.", subasta.calcularIncrementoPromedioCostoBase( ), 75000, 0.1 );
		subasta.registrarOfertaMinimaCelular("LG Z"  );
		
		assertEquals( "El incremento promedio deber�a ser 80000.", subasta.calcularIncrementoPromedioCostoBase( ), 80000, 0.1 );
		subasta.registrarOfertaMinimaCelular( "iPhone" );
		
		assertEquals( "El incremento promedio deber�a ser 95000.", subasta.calcularIncrementoPromedioCostoBase( ), 95000, 0.1 );

	}
	
	
	/**
	 * Prueba 15: verifica el m�todo darCelularConMasOfertas<br>
	 * <b> M�todos a probar: </b> <br>
	 * registrarOfertaAbiertaCelular<br>
	 * <b> Objetivo: </b> Probar que la subasta devuelva el celular con las ofertas.<br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. El incremento promedio fue calculado correctamente.
	 */
	@Test
	public void testDarCelularConMasOfertas( )
	{
		
		assertNull("deber�a retornar null", subasta.darCelularConMasOfertas());
		subasta.registrarOfertaAbiertaCelular( 60000, "Galaxy Note" );		

		assertEquals( "deber�a retornar el celular 1", subasta.darCelularConMasOfertas().darModelo(), subasta.darCelular1().darModelo());
		
		subasta.registrarOfertaModeradaCelular( "LG Z"  );
		subasta.registrarOfertaModeradaCelular( "LG Z" );

		assertEquals( "deber�a retornar el celular 2", subasta.darCelularConMasOfertas().darModelo(), subasta.darCelular2().darModelo());

		subasta.registrarOfertaModeradaCelular( "iPhone" );
		subasta.registrarOfertaModeradaCelular( "iPhone" );
		subasta.registrarOfertaModeradaCelular( "iPhone" );
		
		assertEquals( "deber�a retornar el celular 3", subasta.darCelularConMasOfertas().darModelo(), subasta.darCelular3().darModelo());
		
		subasta.registrarOfertaModeradaCelular( "Pixel" );
		subasta.registrarOfertaModeradaCelular( "Pixel" );
		subasta.registrarOfertaModeradaCelular( "Pixel" );
		subasta.registrarOfertaModeradaCelular( "Pixel" );
		
		assertEquals( "deber�a retornar el celular 4", subasta.darCelularConMasOfertas().darModelo(), subasta.darCelular4().darModelo());
		
		subasta.registrarOfertaModeradaCelular( "iPhone" );
		
		assertNotNull("deberia retornar un celular debido a que tiene el mismo numero de ofertas", subasta.darCelularConMasOfertas() );

	}
	
	

}
