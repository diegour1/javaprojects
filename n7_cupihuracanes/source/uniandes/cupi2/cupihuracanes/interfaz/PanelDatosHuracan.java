/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiHuracanes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupihuracanes.interfaz;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.cupihuracanes.mundo.Huracan;

/**
 * Panel donde se muestran los datos de un hurac�n.
 */
public class PanelDatosHuracan extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que indica la altura que debe tener la imagen de un hurac�n.
     */
    private static final int ALTURA = 200;

    /**
     * Cosntante que indica el ancho que debe tener la imagen de un hurac�n.
     */
    private static final int ANCHO = 200;
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta donde se muestra la imagen del hurac�n.
     */
    private JLabel etiquetaImagen;

    /**
     * Etiqueta para el nombre del hurac�n.
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta para la categor�a del hurac�n.
     */
    private JLabel etiquetaCategoria;

    /**
     * Etiqueta donde se muestra el costo estimado en da�os del hurac�n.
     */
    private JLabel etiquetaDanios;

    /**
     * Etiqueta para la velocidad del hurac�n.
     */
    private JLabel etiquetaVelocidad;

    /**
     * Campo para el nombre del hurac�n.
     */
    private JTextField txtNombre;

    /**
     * Campo para la categor�a del hurac�n.
     */
    private JTextField txtCategoria;

    /**
     * Campo para el costo estimado en da�os del hurac�n.
     */
    private JTextField txtDanios;

    /**
     * Campo para la velocidad del hurac�n.
     */
    private JTextField txtVelocidad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes.
     */
    public PanelDatosHuracan( )
    {
        setLayout( new GridBagLayout( ) );
        etiquetaNombre = new JLabel( "Nombre: " );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( etiquetaNombre, gbc );

        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( txtNombre, gbc );

        etiquetaCategoria = new JLabel( "Categor�a: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( etiquetaCategoria, gbc );

        txtCategoria = new JTextField( );
        txtCategoria.setEditable( false );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( txtCategoria, gbc );

        etiquetaVelocidad = new JLabel( "Velocidad: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( etiquetaVelocidad, gbc );

        txtVelocidad = new JTextField( );
        txtVelocidad.setEditable( false );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( txtVelocidad, gbc );

        etiquetaDanios = new JLabel( "Costo da�os: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( etiquetaDanios, gbc );

        txtDanios = new JTextField( );
        txtDanios.setEditable( false );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets( 5, 0, 5, 0 );
        add( txtDanios, gbc );

        etiquetaImagen = new JLabel( );
        etiquetaImagen.setBorder( new LineBorder( Color.BLACK, 1 ) );
        etiquetaImagen.setMinimumSize( new Dimension( 230, 153 ) );
        etiquetaImagen.setMaximumSize( new Dimension( 230, 153 ) );

        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 5;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        add( etiquetaImagen, gbc );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza los datos del hurac�n en los campos.
     * @param pHuracan Hurac�n del que se quieren mostrar los datos - pHuracan!= null.
     */
    public void actualizarInformacionHuracan( Huracan pHuracan )
    {
        try
        {
            String imagen = pHuracan.darImagen( );
            BufferedImage bImagen = ImageIO.read( new File( imagen ) );

            Image laImagen = null;
            laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
            etiquetaImagen.setIcon( new ImageIcon( laImagen ) );
            
            txtNombre.setText( pHuracan.darNombre( ) );
            txtCategoria.setText( "" + pHuracan.darCategoria( ) );
            txtVelocidad.setText( "" + pHuracan.darVelocidad( ) + "km/h" );
            txtDanios.setText( "" + pHuracan.darCostoEstimadoDanios( ) + " MUS" );

            validate( );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( null, "La ruta de la imagen ingresada no es v�lida. Operaci�n cancelada.", "Agregar hurac�n", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Limpia todos los campos.
     */
    public void limpiarDatos( )
    {
        etiquetaImagen.setIcon( null );
        txtNombre.setText( "" );
        txtCategoria.setText( "" );
        txtVelocidad.setText( "" );
        txtDanios.setText( "" );
    }
}