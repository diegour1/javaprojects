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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel que contiene la información general y las acciones.
 */
public class PanelInformacionAcciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constate que representa el comando para agregar un tren.
     */
    private final static String AGREGAR_TREN = "Agregar tren";

    /**
     * Constate que representa el comando para eliminar un tren.
     */
    private final static String ELIMINAR_TREN = "Eliminar tren";

    /**
     * Constate que representa el comando para agregar un vagón.
     */
    private final static String AGREGAR_VAGON = "Agregar vagón";

    /**
     * Constate que representa el comando para eliminar un vagón.
     */
    private final static String ELIMINAR_VAGON = "Eliminar vagón";

    /**
     * Constate que representa el comando para generar un reporte.
     */
    private final static String GENERAR_REPORTE = "Generar reporte";

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
     * Etiqueta con la cantidad recaudada.
     */
    private JLabel lblRecaudo;

    /**
     * Etiqueta con la cantidad de sillas disponibles.
     */
    private JLabel lblDisponibles;

    /**
     * Botón para agregar tren.
     */
    private JButton btnAgregarTren;

    /**
     * Botón para eliminar tren.
     */
    private JButton btnEliminarTren;

    /**
     * Botón para agregar vagón.
     */
    private JButton btnAgregarVagon;

    /**
     * Botón para eliminar vagón.
     */
    private JButton btnEliminarVagon;

    /**
     * Botón para generar reporte.
     */
    private JButton btnGenerarReporte;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel con la información de las rutas del tren. <br>
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelInformacionAcciones( InterfazCupiTrenes pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Información general" ) );
        setLayout( new BorderLayout( ) );

        JPanel panelInformacion = new JPanel( )
        {
            public void paintComponent( Graphics g )
            {
                Dimension tamanio = getSize( );
                ImageIcon imagenFondo = new ImageIcon( "data/imagenes/ferrocarril.png" );
                g.drawImage( imagenFondo.getImage( ), 0, 0, tamanio.width, tamanio.height, null );
                setOpaque( false );
                super.paintComponent( g );

            }
        };

        panelInformacion.setLayout( new GridLayout( 3, 2 ) );

        Font fuente1 = new Font( "Andalus", Font.BOLD, 16 );
        panelInformacion.setOpaque( false );

        panelInformacion.add( new JLabel( ) );
        panelInformacion.add( new JLabel( ) );

        JLabel lblRecaudoTotal = new JLabel( "Recaudo total: " );
        lblRecaudoTotal.setForeground( Color.yellow );
        lblRecaudoTotal.setFont( fuente1 );
        panelInformacion.add( lblRecaudoTotal );
        lblRecaudo = new JLabel( );
        lblRecaudo.setForeground( Color.white );
        lblRecaudo.setFont( fuente1 );
        panelInformacion.add( lblRecaudo );

        JLabel lblSillasDisponibles = new JLabel( "Sillas disponibles: " );
        lblSillasDisponibles.setForeground( Color.yellow );
        lblSillasDisponibles.setFont( fuente1 );
        panelInformacion.add( lblSillasDisponibles );
        lblDisponibles = new JLabel( );
        lblDisponibles.setForeground( Color.WHITE );
        lblDisponibles.setFont( fuente1 );
        panelInformacion.add( lblDisponibles );

        add( panelInformacion, BorderLayout.CENTER );

        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 5, 1, 4, 2 ) );
        panelBotones.setBorder( new TitledBorder( "Acciones" ) );

        btnAgregarTren = new JButton( "Agregar tren" );
        btnAgregarTren.setActionCommand( AGREGAR_TREN );
        btnAgregarTren.addActionListener( this );
        panelBotones.add( btnAgregarTren );

        btnEliminarTren = new JButton( " Eliminar tren" );
        btnEliminarTren.setActionCommand( ELIMINAR_TREN );
        btnEliminarTren.addActionListener( this );
        panelBotones.add( btnEliminarTren );

        btnAgregarVagon = new JButton( "Agregar vagón" );
        btnAgregarVagon.setActionCommand( AGREGAR_VAGON );
        btnAgregarVagon.addActionListener( this );
        panelBotones.add( btnAgregarVagon );

        btnEliminarVagon = new JButton( " Eliminar vagón" );
        btnEliminarVagon.setActionCommand( ELIMINAR_VAGON );
        btnEliminarVagon.addActionListener( this );
        panelBotones.add( btnEliminarVagon );

        btnGenerarReporte = new JButton( "Generar reporte" );
        btnGenerarReporte.setActionCommand( GENERAR_REPORTE );
        btnGenerarReporte.addActionListener( this );
        panelBotones.add( btnGenerarReporte );

        add( panelBotones, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza el panel de información.
     * @param pTotalRecaudo Total de dinero recaudado a mostrar. pTotalRecaudo >= 0.
     * @param pTotalSillasDisponibles Número total de sillas disponibles a mostrar. pTotalSillasDisponibles >= 0.
     */
    public void actualizar( double pTotalRecaudo, int pTotalSillasDisponibles )
    {
        lblRecaudo.setText( "$" + pTotalRecaudo );
        lblDisponibles.setText( "" + pTotalSillasDisponibles );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( AGREGAR_TREN ) )
        {
            principal.mostrarDialogoAgregarTren( );
        }
        else if( comando.equals( ELIMINAR_TREN ) )
        {
            principal.eliminarTren( );
        }
        else if( comando.equals( AGREGAR_VAGON ) )
        {
            principal.mostrarDialogoAgregarVagon( );
        }
        else if( comando.equals( ELIMINAR_VAGON ) )
        {
            principal.mostrarDialogoEliminarVagon( );
        }
        else if( comando.equals( GENERAR_REPORTE ) )
        {
            principal.generarReporte( );
        }
    }

}
