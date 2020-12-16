/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_cupiDeportes
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiDeportes.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiDeportes.mundo.Deporte;
import uniandes.cupi2.cupiDeportes.mundo.Deportista;

/**
 * Panel para para visualizar la información de un deporte.
 */
public class PanelInfoDeporte extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para definir el action command del combo de las deportistas.
     */
    private static final String COMBO_DEPORTISTAS = "Combo deportistas";

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Label con el nombre del deporte.
     */
    private JLabel lblNombreDeporte;

    /**
     * Label con el ente regulador.
     */
    private JLabel lblEnteRegulador;

    /**
     * Label con el número de deportistas registrados.
     */
    private JLabel lblDeportistasRegistrados;

    /**
     * Campo de texto con el nombre del deporte.
     */
    private JTextField txtNombreDeporte;

    /**
     * Campo de texto con el ente regulador.
     */
    private JTextField txtEnteRegulador;

    /**
     * Campo de texto con el número de deportistas registrados.
     */
    private JTextField txtDeportistasRegistrados;

    /**
     * Label deportistas.
     */
    private JLabel lblDeportistas;

    /**
     * Combo con los deportistas sobresalientes.
     */
    private JComboBox comboDeportistasSobresalientes;

    /**
     * Panel con la imagen del deporte.
     */
    private JPanel panelImagen;

    /**
     * Label con la imagen del deporte.
     */
    private JLabel lblImagen;

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiDeportes principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelInfoDeporte( InterfazCupiDeportes pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new java.awt.BorderLayout( ) );
        setBorder( new TitledBorder( "Deporte" ) );

        setPreferredSize( new Dimension( 320, 150 ) );
        // Panel Imagen
        panelImagen = new JPanel( );
        panelImagen.setPreferredSize( new Dimension( 110, 195 ) );
        panelImagen.setLayout( new BorderLayout( ) );
        add( panelImagen, java.awt.BorderLayout.NORTH );

        lblImagen = new JLabel( );
        lblImagen.setHorizontalAlignment( JLabel.CENTER );
        lblImagen.setVerticalAlignment( JLabel.CENTER );
        panelImagen.add( lblImagen, BorderLayout.CENTER );

        JPanel granPanel = new JPanel( );
        granPanel.setPreferredSize( new Dimension( 400, 195 ) );
        granPanel.setLayout( new BorderLayout( ) );
        add( granPanel, java.awt.BorderLayout.CENTER );
        JPanel panelInformacion = new JPanel( );
        GridLayout layout = new GridLayout( 4, 2 );
        layout.setVgap( 8 );
        layout.setHgap( 8 );
        panelInformacion.setLayout( layout );

        lblNombreDeporte = new JLabel( "Nombre:" );
        panelInformacion.add( lblNombreDeporte );

        txtNombreDeporte = new JTextField( );
        txtNombreDeporte.setEditable( false );
        panelInformacion.add( txtNombreDeporte );

        lblEnteRegulador = new JLabel( "Ente regulador:" );
        panelInformacion.add( lblEnteRegulador );

        txtEnteRegulador = new JTextField( );
        txtEnteRegulador.setEditable( false );
        panelInformacion.add( txtEnteRegulador );

        lblDeportistasRegistrados = new JLabel( "Deportistas registrados:" );
        panelInformacion.add( lblDeportistasRegistrados );

        txtDeportistasRegistrados = new JTextField( );
        txtDeportistasRegistrados.setEditable( false );
        panelInformacion.add( txtDeportistasRegistrados );

        lblDeportistas = new JLabel( "Deportistas sobresalientes:" );
        panelInformacion.add( lblDeportistas );
        comboDeportistasSobresalientes = new JComboBox( );
        comboDeportistasSobresalientes.addActionListener( this );
        comboDeportistasSobresalientes.setActionCommand( COMBO_DEPORTISTAS );
        panelInformacion.add( comboDeportistasSobresalientes );

        granPanel.add( panelInformacion, java.awt.BorderLayout.NORTH );

    }

    /**
     * Actualiza la información presentada por el panel.
     * @param pDeporte Deporte del cual se va a obtener la información. pDeporte != null.
     */
    public void actualizarInfo( Deporte pDeporte )
    {
        if( pDeporte != null )
        {
            lblImagen.setIcon( new ImageIcon( pDeporte.darRutaImagen( ) ) );
            txtNombreDeporte.setText( pDeporte.darNombre( ) );
            txtEnteRegulador.setText( pDeporte.darEnteRegulador( ) );
            txtDeportistasRegistrados.setText( pDeporte.darCantidadDeportistasRegistrados( ) + "" );
            comboDeportistasSobresalientes.removeAllItems( );
            for( int i = 0; i < pDeporte.darDeportistasSobresalientes( ).size( ); i++ )
            {
                comboDeportistasSobresalientes.addItem( pDeporte.darDeportistasSobresalientes( ).get( i ) );
            }
        }
        else
        {
            lblImagen.setIcon( new ImageIcon( "" ) );
            txtNombreDeporte.setText( "" );
            txtEnteRegulador.setText( "" );
            txtDeportistasRegistrados.setText( "" );
            comboDeportistasSobresalientes.removeAllItems( );
        }
    }

    /**
     * Devuelve El deportista seleccionado.
     * @return Deportista seleccionado.
     */
    public Deportista darDeportistaSeleccionado( )
    {
        return ( Deportista )comboDeportistasSobresalientes.getSelectedItem( );
    }

    /**
     * Método en el que se tratan los eventos del diálogo.
     * @param e Parámetro que tiene encapsulado las características del elemento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ).equals( COMBO_DEPORTISTAS ) )
        {
            principal.actualizarInfoDeportista( darDeportistaSeleccionado( ) );
        }
    }

}
