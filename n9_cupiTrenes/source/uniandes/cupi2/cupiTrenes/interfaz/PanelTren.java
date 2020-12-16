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
package uniandes.cupi2.cupiTrenes.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiTrenes.mundo.Tren;

/**
 * Panel con la información de un tren.
 */
public class PanelTren extends JPanel implements ActionListener
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante que representa el comando para el anterior tren.
	 */
	private static final String ANTERIOR = "Anterior";

	/**
	 * Constante que representa el comando para el siguiente tren.
	 */
	private static final String SIGUIENTE = "Siguiente";

	/**
	 * Constante que representa el comando para la ver todas las paradas del tren.
	 */
	private static final String TODAS_LAS_PARADAS = "Todas las paradas";

	/**
	 * Constante que representa el comando para buscar un tren.
	 */
	private static final String BUSCAR_RUTA = "Buscar tren";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazCupiTrenes principal;

	// -----------------------------------------------------------------
	// Atributos de interfaz
	// -----------------------------------------------------------------

	/**
	 * Etiqueta con el id del tren.
	 */
	private JLabel lblIdTren;

	/**
	 * Etiqueta con la primera parada del tren.
	 */
	private JLabel lblPrimeraParada;

	/**
	 * Etiqueta con la última parada del tren.
	 */
	private JLabel lblUltimaParada;

	/**
	 * Etiqueta con la cantidad de paradas.
	 */
	private JLabel lblCantidadParadas;

	/**
	 * Botón para buscar el tren anterior.
	 */
	private JButton btnAnterior;

	/**
	 * Botón para buscar el siguiente tren.
	 */
	private JButton btnSiguiente;

	/**
	 * Botón para visualizar todas las paradas del tren.
	 */
	private JButton btnTodasLasParadas;

	/**
	 * Botón para buscar una ruta.
	 */
	private JButton btnBuscarRuta;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del panel con la información de una ruta.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
	 */
	public PanelTren( InterfazCupiTrenes pPrincipal )
	{
		principal = pPrincipal;

		setBorder( new TitledBorder( "Información trenes" ) );
		setLayout( new BorderLayout( ) );

		JPanel panelInformacion = new JPanel( )
		{
			public void paintComponent( Graphics g )
			{
				Dimension tamanio = getSize( );
				ImageIcon imagenFondo = new ImageIcon( "data/imagenes/fondoPapel2.png" );
				g.drawImage( imagenFondo.getImage( ), 0, 0, tamanio.width, tamanio.height, null );
				setOpaque( false );
				super.paintComponent( g );

			}
		};
		panelInformacion.setLayout( new GridBagLayout( ) );
		panelInformacion.setBorder( new TitledBorder( "" ) );
		GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 12, 12 );

		Font fuente1 = new Font( "Georgia", Font.BOLD, 12 );
		Font fuente2 = new Font( "Georgia", Font.PLAIN, 15 );

		panelInformacion.add( new JLabel( ) );
		panelInformacion.add( new JLabel( ) );
		gbc.gridx = 0;

		JLabel lblId = new JLabel( "Id: " );
		lblId.setFont( fuente1 );
		panelInformacion.add( lblId, gbc );
		gbc.gridy++;

		JLabel lblOrign = new JLabel( "Primera parada: " );
		lblOrign.setFont( fuente1 );
		panelInformacion.add( lblOrign, gbc );
		gbc.gridy++;

		JLabel lblDestin = new JLabel( "Última parada: " );
		lblDestin.setFont( fuente1 );
		panelInformacion.add( lblDestin, gbc );
		gbc.gridy++;

		JLabel cantParadas = new JLabel( "Cantidad de paradas: " );
		cantParadas.setFont( fuente1 );
		panelInformacion.add( cantParadas, gbc );

		gbc.gridy = 0;
		gbc.gridx++;

		lblIdTren = new JLabel( );
		lblIdTren.setFont( fuente2 );
		panelInformacion.add( lblIdTren, gbc );
		gbc.gridy++;

		lblPrimeraParada = new JLabel( );
		lblPrimeraParada.setFont( fuente2 );
		panelInformacion.add( lblPrimeraParada, gbc );
		gbc.gridy++;

		lblUltimaParada = new JLabel( );
		lblUltimaParada.setFont( fuente2 );
		panelInformacion.add( lblUltimaParada, gbc );
		gbc.gridy++;

		lblCantidadParadas = new JLabel( );
		lblCantidadParadas.setFont( fuente2 );
		panelInformacion.add( lblCantidadParadas, gbc );

		gbc.gridy = 0;
		gbc.gridx++;

		panelInformacion.add( new JLabel( "" ), gbc );
		gbc.gridy++;
		panelInformacion.add( new JLabel( "" ), gbc );
		gbc.gridy++;
		panelInformacion.add( new JLabel( "" ), gbc );
		gbc.gridy++;

		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		add( panelInformacion, BorderLayout.CENTER );

		JPanel panelNavegacion = new JPanel( );
		panelNavegacion.setLayout( new GridBagLayout( ) );
		GridBagConstraints gbc2 = new GridBagConstraints( 0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );

		panelNavegacion.setBorder( new TitledBorder( "Opciones del tren" ) );

		btnAnterior = new JButton( "<<" );
		btnAnterior.setActionCommand( ANTERIOR );
		btnAnterior.addActionListener( this );
		panelNavegacion.add( btnAnterior, gbc2 );

		gbc2.gridx++;

		btnTodasLasParadas = new JButton( "Ver todas las paradas" );
		btnTodasLasParadas.setActionCommand( TODAS_LAS_PARADAS );
		btnTodasLasParadas.addActionListener( this );
		panelNavegacion.add( btnTodasLasParadas, gbc2 );

		gbc2.gridx++;

		btnSiguiente = new JButton( ">>" );
		btnSiguiente.setActionCommand( SIGUIENTE );
		btnSiguiente.addActionListener( this );
		panelNavegacion.add( btnSiguiente, gbc2 );

		gbc2.gridx++;

		btnBuscarRuta = new JButton( BUSCAR_RUTA );
		btnBuscarRuta.setActionCommand( BUSCAR_RUTA );
		btnBuscarRuta.addActionListener( this );
		panelNavegacion.add( btnBuscarRuta, gbc2 );
		add( panelNavegacion, BorderLayout.SOUTH );
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Actualiza el panel con la información del tren dado por parámetro.
	 * @param pDestino Destino final del tren. pDestino != "" && pDestino != null.
	 * @param pOrigen Origen del tren. pOrigen != "" && pOrigen != null.
	 * @param pHorarioLlegada Horario de llegada de la parada. pHorarioLlegada != "" && pHorarioLlegada != null.
	 * @param pHorarioSalida Horario de salida de la parada. pHorarioSalida != "" && pHorarioSalida != null.
	 * @param pIdRuta Id del tren. pIdRuta != "" && pIdRuta != null.
	 * @param pCantidadParadas Cantidad de paradas que tiene el tren. pCantidadParadas >= 2.
	 */
	public void actualizar( String pDestino, String pOrigen, String pHorarioLlegada, String pHorarioSalida, int pIdRuta, int pCantidadParadas )
	{
		lblCantidadParadas.setText( "" + pCantidadParadas );
		lblUltimaParada.setText( pDestino + " (" + pHorarioLlegada + ")" );
		lblPrimeraParada.setText( pOrigen + " (" + pHorarioSalida + ")" );
		lblIdTren.setText( "" + pIdRuta );
	}

	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Acción que generó el evento. pEvento != null.
	 */
	public void actionPerformed( ActionEvent pEvento )
	{
		String comando = pEvento.getActionCommand( );

		if( ANTERIOR.equals( comando ) )
		{
			principal.darAnteriorTren( );
		}
		else if( SIGUIENTE.equals( comando ) )
		{
			principal.darSiguienteTren( );
		}
		else if( TODAS_LAS_PARADAS.equals( comando ) )
		{
			principal.mostrarTodasLasParadas( );
		}
		else if( BUSCAR_RUTA.equals( comando ) )
		{
			principal.mostrarDialogoBuscarTren( );
		}
	}

}
