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

package co.edu.uniandes.cupi2.subastas.interfaz;

import co.edu.uniandes.cupi2.subastas.mundo.Subasta;
import java.awt.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazSubasta extends JFrame
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Clase principal del mundo.
	 */
	private Subasta subasta;

	/**
	 * Panel con la información del celular 1.
	 */
	private PanelProducto producto1;

	/**
	 * Panel con la información del celular 2.
	 */
	private PanelProducto producto2;

	/**
	 * Panel con la información del celular 3.
	 */
	private PanelProducto producto3;

	/**
	 * Panel con la información del celular 4.
	 */
	private PanelProducto producto4;

	/**
	 * Panel con imagen del banner.
	 */
	private PanelBanner panelBanner;

	/**
	 * Panel con las opciones de extensión.
	 */
	private PanelExtensiones panelExtensiones;

	/**
	 * Panel con la información general de la subasta.
	 */
	private PanelResumen panelResumen;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor de la ventana principal.
	 */
	public InterfazSubasta( )
	{

		setTitle( "Subasta celulares" );

		subasta = new Subasta( );

		producto1 = new PanelProducto( this, 1 );

		producto2 = new PanelProducto( this, 2 );

		producto3 = new PanelProducto( this, 3 );

		producto4 = new PanelProducto( this, 4 );

		panelBanner = new PanelBanner( );

		panelExtensiones = new PanelExtensiones( this );

		panelResumen = new PanelResumen( this );

		JPanel panelCelulares = new JPanel( );
		panelCelulares.setLayout( new GridLayout( 1, 4 ) );
		panelCelulares.add( producto1 );
		panelCelulares.add( producto2 );
		panelCelulares.add( producto3 );
		panelCelulares.add( producto4 );

		JPanel panelInferior = new JPanel( );
		panelInferior.setLayout( new BorderLayout( ) );

		panelInferior.add( panelResumen, BorderLayout.CENTER );
		panelInferior.add( panelExtensiones, BorderLayout.SOUTH );

		setLayout( new BorderLayout( ) );
		getContentPane( ).add( panelBanner, BorderLayout.NORTH );
		getContentPane( ).add( panelCelulares, BorderLayout.CENTER );
		getContentPane( ).add( panelInferior, BorderLayout.SOUTH );

		setSize( 1020, 750 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable(false);
		setLocationRelativeTo( null );
		actualizarPaneles( );
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Registra una oferta dado el número del celular por el cual se quiere realizar la oferta y el tipo de oferta.
	 * @param pNumCelular El número del celular a ofertar.
	 * @param pTipoOferta El tipo de oferta. pTipoOferta=(TIPO_OFERTA_MINIMA|TIPO_OFERTA_MODERADA).
	 */
	public void registrarOferta( int pNumCelular, int pTipoOferta )
	{
		boolean x = false;
		if( pNumCelular == 1 )
		{
			if( pTipoOferta == PanelProducto.TIPO_OFERTA_MINIMA )
			{
				x = subasta.registrarOfertaMinimaCelular(subasta.darCelular1().darModelo() );
			}
			else if( pTipoOferta == PanelProducto.TIPO_OFERTA_MODERADA )
			{
				x = subasta.registrarOfertaModeradaCelular( subasta.darCelular1().darModelo() );
			}
		}
		else if( pNumCelular == 2 )
		{
			if( pTipoOferta == PanelProducto.TIPO_OFERTA_MINIMA )
			{
				x = subasta.registrarOfertaMinimaCelular( subasta.darCelular2().darModelo() );
			}
			else if( pTipoOferta == PanelProducto.TIPO_OFERTA_MODERADA )
			{
				x = subasta.registrarOfertaModeradaCelular( subasta.darCelular2().darModelo() );
			}
		}
		else if( pNumCelular == 3 )
		{
			if( pTipoOferta == PanelProducto.TIPO_OFERTA_MINIMA )
			{
				x = subasta.registrarOfertaMinimaCelular( subasta.darCelular3().darModelo() );
			}
			else if( pTipoOferta == PanelProducto.TIPO_OFERTA_MODERADA )
			{
				x = subasta.registrarOfertaModeradaCelular( subasta.darCelular3().darModelo() );
			}
		}else if( pNumCelular == 4 )
		{
			if( pTipoOferta == PanelProducto.TIPO_OFERTA_MINIMA )
			{
				x = subasta.registrarOfertaMinimaCelular( subasta.darCelular4().darModelo() );
			}
			else if( pTipoOferta == PanelProducto.TIPO_OFERTA_MODERADA )
			{
				x = subasta.registrarOfertaModeradaCelular( subasta.darCelular4().darModelo() );
			}
		}
		actualizarPaneles( );
		if (!x)
		{
			JOptionPane.showMessageDialog( this, "no se pudo registrar la oferta: no se puede registrar una oferta si este ya esta vendido.", "Error", JOptionPane.ERROR_MESSAGE );
		}else
		{
			JOptionPane.showMessageDialog( this, "Oferta registrada para el celular " + pNumCelular );
		}

	}

	/**
	 * Registrar una oferta abierta.
	 * @param pNumCelular Número del celular por el cual se registra la oferta.
	 * @param pValorOferta El valor de la oferta. pValorOferta > 0.
	 */
	public void registrarOfertaAbierta( int pNumCelular, int pValorOferta )
	{
		boolean res = true;
		if( pNumCelular == 1 )
		{
			res  = subasta.registrarOfertaAbiertaCelular( pValorOferta, subasta.darCelular1().darModelo() );
			if(subasta.darCelular1().estaVendido() && res) {
				JOptionPane.showMessageDialog( this, "no se puede registrar la oferta si el celular ya se vendio","Error",JOptionPane.ERROR_MESSAGE );
				return;
			}
		}
		else if( pNumCelular == 2 )
		{
			res  = subasta.registrarOfertaAbiertaCelular( pValorOferta, subasta.darCelular2().darModelo() );
			if(subasta.darCelular2().estaVendido() && res) {
				JOptionPane.showMessageDialog( this, "no se puede registrar la oferta si el celular ya se vendio","Error",JOptionPane.ERROR_MESSAGE );
				return;
			}
		}
		else if( pNumCelular == 3 )
		{
			res  = subasta.registrarOfertaAbiertaCelular( pValorOferta, subasta.darCelular3().darModelo() );
			if(subasta.darCelular3().estaVendido() && res) {
				JOptionPane.showMessageDialog( this, "no se puede registrar la oferta si el celular ya se vendio","Error",JOptionPane.ERROR_MESSAGE );
				return;
			}
		}
		else if( pNumCelular == 4 )
		{
			res  = subasta.registrarOfertaAbiertaCelular( pValorOferta, subasta.darCelular4().darModelo() );
			if(subasta.darCelular4().estaVendido() && res) {
				JOptionPane.showMessageDialog( this, "no se puede registrar la oferta si el celular ya se vendio","Error",JOptionPane.ERROR_MESSAGE );
				return;
			}
		}
		actualizarPaneles( );
		if (res)
		{
			JOptionPane.showMessageDialog( this, "Oferta registrada para el celular " + pNumCelular );
		}else if(!res)
		{
			JOptionPane.showMessageDialog( this, "Introduzca un valor valido","Error",JOptionPane.ERROR_MESSAGE );
		}
	}

	/**
	 * Reinicia la subasta y actualiza la interfaz.
	 */
	public void reiniciarSubasta( )
	{
		subasta.reiniciarSubasta( );
		actualizarPaneles( );
	}

	/**
	 * Actualiza la interfaz con la información del mundo.
	 */
	private void actualizarPaneles( )
	{
		producto1.actualizar( subasta.darCelular1( ) );
		producto2.actualizar( subasta.darCelular2( ) );
		producto3.actualizar( subasta.darCelular3( ) );
		producto4.actualizar( subasta.darCelular4( ) );
		panelResumen.actualizar( subasta );
	}

	public void mayorOfertas() {
		if (subasta.darCelularConMasOfertas() == null)
		{
			JOptionPane.showMessageDialog( this, "No hay un celular con al menos una oferta ", "Celular con mayor cantidad de ofertas", JOptionPane.INFORMATION_MESSAGE );
		}else
		JOptionPane.showMessageDialog( this, "el celular con mayor cantidad de ofertas es el: " + subasta.darCelularConMasOfertas().darModelo(), " Celular con mayor cantidad de ofertas", JOptionPane.INFORMATION_MESSAGE );
	}

	public void vender(int numTelefono) {
		boolean v = false;

		if(numTelefono == 1)
		{
			v = subasta.venderCelular(subasta.darCelular1().darModelo());
		}
		if(numTelefono == 2)
		{
			v = subasta.venderCelular(subasta.darCelular2().darModelo());
		}
		if(numTelefono == 3)
		{
			v = subasta.venderCelular(subasta.darCelular3().darModelo());
		}
		if(numTelefono == 4)
		{
			v = subasta.venderCelular(subasta.darCelular4().darModelo());
		}
		actualizarPaneles();

		if(v) {
			JOptionPane.showMessageDialog( this, "se vendio el celular con exito.", "Vendido", JOptionPane.INFORMATION_MESSAGE );
		}else {
			JOptionPane.showMessageDialog( this, "no se pudo vender el celular: no se puede vender un celular si ya esta vendido.", "Error", JOptionPane.ERROR_MESSAGE );
		}
	}

	/**
	 * Método para la extensión 1.
	 */
	public void reqFuncOpcion1a( )
	{
		String resultado = subasta.metodo1( );
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Método para la extensión 2.
	 */
	public void reqFuncOpcion2a( )
	{
		String resultado = subasta.metodo2( );
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	// -----------------------------------------------------------------
	// Main
	// -----------------------------------------------------------------

	/**
	 * Este método ejecuta la aplicación, creando una nueva interfaz.
	 * @param args
	 */
	public static void main( String[] args )
	{
		InterfazSubasta interfazSubasta = new InterfazSubasta( );
		interfazSubasta.setVisible( true );
	}



}