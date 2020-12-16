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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiDeportes.mundo.Deportista;

/**
 * Panel para para visualizar la información de un deportista.
 */
public class PanelInfoDeportista extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Label con el nombre del deportista.
     */
    private JLabel lblNombreDeportista;

    /**
     * Campo de texto para el nombre del deportista.
     */
    private JTextField txtNombreDeportista;

    /**
     * Label con la edad del deportista.
     */
    private JLabel lblEdad;

    /**
     * Campo de texto con la edad del deportista.
     */
    private JTextField txtEdad;

    /**
     * Label con el lugar de residencia del deportista.
     */
    private JLabel lblLugarResidencia;

    /**
     * Campo de texto para el lugar de residencia del deportista.
     */
    private JTextField txtLugarResidencia;

    /**
     * Label Para la cantidad de trofeos ganados.
     */
    private JLabel lblTrofeosGanados;

    /**
     * Campo de texto con los trofeos ganados.
     */
    private JTextField txtTrofeosGanados;

    /**
     * Panel con la imagen del deportista.
     */
    private JPanel panelImagen;

    /**
     * Label con la imagen del deportista.
     */
    private JLabel lblImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor del panel.
     */
    public PanelInfoDeportista( )
    {
        setLayout( new java.awt.BorderLayout( ) );
        setBorder( new TitledBorder( "Deportista" ) );

        setPreferredSize( new Dimension( 350, 150 ) );
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

        lblNombreDeportista = new JLabel( "Nombre:" );
        panelInformacion.add( lblNombreDeportista );

        txtNombreDeportista = new JTextField( );
        txtNombreDeportista.setEditable( false );
        panelInformacion.add( txtNombreDeportista );

        lblEdad = new JLabel( "Edad:" );
        panelInformacion.add( lblEdad );

        txtEdad = new JTextField( );
        txtEdad.setEditable( false );
        panelInformacion.add( txtEdad );

        lblLugarResidencia = new JLabel( "Lugar de residencia:" );
        panelInformacion.add( lblLugarResidencia );

        txtLugarResidencia = new JTextField( );
        txtLugarResidencia.setEditable( false );
        panelInformacion.add( txtLugarResidencia );

        lblTrofeosGanados = new JLabel( "Trofeos ganados:" );
        panelInformacion.add( lblTrofeosGanados );

        txtTrofeosGanados = new JTextField( );
        txtTrofeosGanados.setEditable( false );
        panelInformacion.add( txtTrofeosGanados );

        granPanel.add( panelInformacion, BorderLayout.NORTH );

    }

    /**
     * Actualiza la información presentada por el panel.
     * @param pDeportista Deportista del cual se va a obtener la información. pDeportista != null.
     */
    public void actualizarInfo( Deportista pDeportista )
    {
        if( pDeportista != null )
        {
            lblImagen.setIcon( new ImageIcon( pDeportista.darRutaImagen( ) ) );
            txtNombreDeportista.setText( pDeportista.darNombre( ) );
            txtEdad.setText( String.valueOf( pDeportista.darEdad( ) ) );
            txtTrofeosGanados.setText( String.valueOf( pDeportista.darCantidadTrofeos( ) ) );
            txtLugarResidencia.setText( pDeportista.darLugarResidencia( ) );

        }
        else
        {
            lblImagen.setIcon( new ImageIcon( "" ) );
            txtNombreDeportista.setText( "" );
            txtEdad.setText( "" );
            txtTrofeosGanados.setText( "" );
            txtLugarResidencia.setText( "" );
        }

    }

}
