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
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiTrenes.mundo.Vagon;

/**
 * Panel de información del vagón.
 */
public class PanelVagon extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para ir al primer vagón.
     */
    private static final String PRIMERO = "Primer vagón";

    /**
     * Constante que representa el comando para ir al siguiente vagón.
     */
    private static final String SIGUIENTE = "Siguiente vagón";

    /**
     * Constante que representa el comando para vender un tiquete.
     */
    private static final String VENDER = "Vender tiquete";

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
     * Panel para la navegación de vagones.
     */
    private JPanel panelNavegacion;

    /**
     * Panel con la información del vagón.
     */
    private JPanel panelInformacion;

    /**
     * Etiqueta con el número del vagón.
     */
    private JLabel lblNumero;

    /**
     * Etiqueta con la clase del vagón.
     */
    private JLabel lblClase;
    
    /**
     * Etiqueta con la cantidad total de sillas.
     */
    private JLabel lblCantidadTotalSillas;

    /**
     * Etiqueta con la cantidad de sillas disponibles.
     */
    private JLabel lblCantidadSillasDisponibles;

    /**
     * Etiqueta con el precio del tiquete en el vagón.
     */
    private JLabel lblPrecio;

    /**
     * Botón para seleccionar el primer vagón.
     */
    private JButton btnPrimero;

    /**
     * Botón para seleccionar el siguiente vagón.
     */
    private JButton btnSiguiente;

    /**
     * Botón para vender.
     */
    private JButton btnVender;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel con la información del vagón.
     * @param pPrincipal Ventana principal de la aplicación de cupiTrenes. pPrincipal != null.
     */
    public PanelVagon( InterfazCupiTrenes pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Información vagón" ) );
        setLayout( new BorderLayout( ) );

        inicializarPanelInformacion( );
        add( panelInformacion, BorderLayout.CENTER );

        inicializarPanelNavegacion( );
        add( panelNavegacion, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel de información.
     */
    public void inicializarPanelInformacion( )
    {
        panelInformacion = new JPanel( )
        {

            // Sobre-escribe el método paintComponent para poder pintar la imagen de fondo del panel.

            public void paintComponent( Graphics g )
            {
                Dimension tamanio = getSize( );
                ImageIcon imagenFondo = new ImageIcon( "data/imagenes/fondoPapel2.png" );
                g.drawImage( imagenFondo.getImage( ), 0, 0, tamanio.width, tamanio.height, null );
                setOpaque( false );
                super.paintComponent( g );

            }
        };
        panelInformacion.setLayout( new GridLayout( 8, 4 ) );

        Font fuente1 = new Font( "Georgia", Font.BOLD, 10 );
        Font fuente2 = new Font( "Georgia", Font.PLAIN, 14 );
        JLabel lblNum = new JLabel( "Número" );
        lblNum.setFont( new Font( "Georgia", Font.BOLD, 12 ) );
        panelInformacion.add( lblNum );
        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );
        JLabel lblClas = new JLabel( "" );
        lblClas.setFont( fuente1 );
        panelInformacion.add( lblClas );

        lblNumero = new JLabel( "" );
        lblNumero.setFont( new Font( "Georgia", Font.BOLD, 11 ) );
        panelInformacion.add( lblNumero );
        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );
        lblClase = new JLabel( "" );
        lblClase.setFont( new Font( "Georgia", Font.BOLD, 11 ) );
        panelInformacion.add( lblClase );

        panelInformacion.add( new JLabel( "" ) );
        JLabel lblTotalSillas = new JLabel( "Total de sillas:" );
        panelInformacion.add( lblTotalSillas );
        lblTotalSillas.setFont( fuente1 );
        lblCantidadTotalSillas = new JLabel( "" );
        lblCantidadTotalSillas.setFont( fuente2 );
        panelInformacion.add( lblCantidadTotalSillas );
        panelInformacion.add( new JLabel( "" ) );
        
        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );
        
        panelInformacion.add( new JLabel( "" ) );
        JLabel lblSillasDisponibles = new JLabel( "Sillas disponibles:" );
        lblSillasDisponibles.setFont( fuente1 );
        panelInformacion.add( lblSillasDisponibles );
        lblCantidadSillasDisponibles = new JLabel( "" );
        lblCantidadSillasDisponibles.setFont( fuente2 );
        panelInformacion.add( lblCantidadSillasDisponibles );
        panelInformacion.add( new JLabel( "" ) );
        
        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );

        panelInformacion.add( new JLabel( "" ) );
        JLabel lblValorTiquete = new JLabel( "Valor tiquete:   " );
        lblValorTiquete.setFont( fuente1 );
        panelInformacion.add( lblValorTiquete );
        lblPrecio = new JLabel( "" );
        lblPrecio.setFont( fuente2 );
        panelInformacion.add( lblPrecio );
        panelInformacion.add( new JLabel( "" ) );

        panelInformacion.setOpaque( false );
    }

    /**
     * Inicializa el panel de navegación.
     */
    public void inicializarPanelNavegacion( )
    {
        panelNavegacion = new JPanel( );
        panelNavegacion.setLayout( new GridLayout( 1, 3 ) );
        panelNavegacion.setBorder( new TitledBorder( "Selección de vagón" ) );

        btnPrimero = new JButton( PRIMERO );
        btnPrimero.setActionCommand( PRIMERO );
        btnPrimero.addActionListener( this );
        panelNavegacion.add( btnPrimero );

        btnSiguiente = new JButton( SIGUIENTE );
        btnSiguiente.setActionCommand( SIGUIENTE );
        btnSiguiente.addActionListener( this );
        panelNavegacion.add( btnSiguiente );

        btnVender = new JButton( VENDER );
        btnVender.setActionCommand( VENDER );
        btnVender.addActionListener( this );
        panelNavegacion.add( btnVender );

    }

    /**
     * Actualiza el panel con la información del vagón dada por parámetro.
     * @param pNumeroVagon Número del vagón.
     * @param pClaseVagon Clase del compartimiento. pClaseVagon != null && pClaseVagon != "" && (pClaseVagon ==PRIMERA_CLASE || pClaseVagon == SEGUNDA_CLASE ).
     * @param pCantidadSillasDisponibles Cantidad de sillas disponibles en el vagón. pCantidadSillasDisponibles >= 0.
     * @param pPrecioSilla Precio del tiquete. pPrecioSilla > 0.
     * @param pSillasTotales Total de sillas en el vagón. pSillasTotales > 0.
     */
    public void actualizar( int pNumeroVagon, String pClaseVagon, int pCantidadSillasDisponibles, double pPrecioSilla, int pSillasTotales )
    {

        lblNumero.setText( "" + pNumeroVagon );
        lblClase.setText( "" + pClaseVagon );
        lblCantidadTotalSillas.setText( "" + pSillasTotales );
        lblCantidadSillasDisponibles.setText( "  " + pCantidadSillasDisponibles );
        lblPrecio.setText( "  $" + pPrecioSilla );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( SIGUIENTE.equals( pEvento.getActionCommand( ) ) )
        {
            principal.darSiguienteVagon( );
        }
        else if( PRIMERO.equals( pEvento.getActionCommand( ) ) )
        {
            principal.darPrimerVagon( );
        }
        else if( VENDER.equals( pEvento.getActionCommand( ) ) )
        {
            principal.venderTiquete( );
        }
    }

}
