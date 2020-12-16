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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiDeportes.mundo.ElementoExisteException;

/**
 * Dialogo para agregar un deporte.
 */
public class DialogoAgregarDeporte extends JDialog implements ActionListener
{
    // -----------------------------------------------
    // Constantes
    // -----------------------------------------------

    /**
     * Constante agregar deporte.
     */
    private final static String AGREGAR = "Agregar deporte";

    /**
     * Constante examinar.
     */
    private final static String EXAMINAR = "Examinar";

    // -----------------------------------------------
    // Atributos
    // -----------------------------------------------

    /**
     * Etiqueta nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta ente regulaor.
     */
    private JLabel lblEnteRegulador;

    /**
     * Etiqueta deportistas registrados.
     */
    private JLabel lblDeportistasRegistrados;

    /**
     * Etiqueta Imagen.
     */
    private JLabel lblImagen;

    /**
     * Campo de texto Nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto ente regulador.
     */
    private JTextField txtEnteRegulador;

    /**
     * Campo de texto deportistas registrados.
     */
    private JTextField txtDeportistasRegistrados;

    /**
     * Texto con la ruta de la imagen.
     */
    private JTextField txtImagen;

    /**
     * Panel con la información del deporte.
     */
    private JPanel panelInfo;

    /**
     * Botón para agregar el deporte.
     */
    private JButton btnAgregar;

    /**
     * Botón para ingresar la ruta de la imagen.
     */
    private JButton btnExaminar;

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiDeportes principal;

    // -----------------------------------------------
    // Métodos
    // -----------------------------------------------

    /**
     * Crea el dialogo para ingresar un deporte.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAgregarDeporte( InterfazCupiDeportes pPrincipal )
    {
        super( pPrincipal, true );

        principal = pPrincipal;
        setTitle( "Agregar deporte" );
        setLayout( new java.awt.BorderLayout( ) );

        panelInfo = new JPanel( );
        panelInfo.setPreferredSize( new Dimension( 500, 180 ) );

        panelInfo.setBorder( new TitledBorder( "Información" ) );
        GridLayout layout = new GridLayout( 4, 2, -175, 30 );
        layout.setVgap( 10 );
        panelInfo.setLayout( layout );

        lblNombre = new JLabel( "Nombre: " );
        panelInfo.add( lblNombre );
        txtNombre = new JTextField( );
        panelInfo.add( txtNombre );

        lblEnteRegulador = new JLabel( "Ente regulador: " );
        panelInfo.add( lblEnteRegulador );
        txtEnteRegulador = new JTextField( );
        panelInfo.add( txtEnteRegulador );

        lblDeportistasRegistrados = new JLabel( "Deportistas registrados: " );
        panelInfo.add( lblDeportistasRegistrados );
        txtDeportistasRegistrados = new JTextField( );
        panelInfo.add( txtDeportistasRegistrados );

        lblImagen = new JLabel( "Imagen: " );
        panelInfo.add( lblImagen );

        BorderLayout border = new BorderLayout( );
        border.setHgap( 5 );
        border.setVgap( 5 );

        JPanel panelRutaImagen = new JPanel( border );
        txtImagen = new JTextField( );
        panelRutaImagen.add( txtImagen, BorderLayout.CENTER );

        btnExaminar = new JButton( EXAMINAR );
        btnExaminar.setActionCommand( EXAMINAR );
        btnExaminar.addActionListener( this );
        panelRutaImagen.add( btnExaminar, BorderLayout.EAST );

        panelInfo.add( panelRutaImagen );

        add( panelInfo, BorderLayout.NORTH );

        btnAgregar = new JButton( AGREGAR );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );
        add( btnAgregar, BorderLayout.SOUTH );

        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }

    /**
     * Método que recoge las acciones sobre los objetos que está escuchando.
     * @param e Evento que se realizó.
     */
    public void actionPerformed( ActionEvent e )
    {

        if( e.getActionCommand( ).equals( AGREGAR ) )
        {
            String nombre = txtNombre.getText( );
            String enteRegulador = txtEnteRegulador.getText( );
            String imagen = txtImagen.getText( );
            String deportistasRegistradosStr = txtDeportistasRegistrados.getText( );

            if( nombre.equals( "" ) || enteRegulador.equals( "" ) || deportistasRegistradosStr.equals( "" ) || imagen.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Datos incompletos.", "Agregar deporte", JOptionPane.ERROR_MESSAGE );
                return;
            }

            try
            {
                int deportistasRegistrados = Integer.parseInt( deportistasRegistradosStr );
                if( deportistasRegistrados <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "Deportistas registrados deber ser un número positivo.", "Agregar deporte", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    principal.agregarDeporte( nombre, enteRegulador, deportistasRegistrados, imagen );
                    dispose( );
                }
            }
            catch( ElementoExisteException e1 )
            {
                JOptionPane.showMessageDialog( this, "Ya existe un deporte con el nombre " + nombre, "Agregar deporte", JOptionPane.ERROR_MESSAGE );

            }
            catch( NumberFormatException e2 )
            {
                JOptionPane.showMessageDialog( this, "Deportistas registrados deber ser un número.", "Agregar deporte", JOptionPane.ERROR_MESSAGE );
            }

        }
        if( e.getActionCommand( ).equals( EXAMINAR ) )
        {
            JFileChooser fc = new JFileChooser( "./data/imagenes" );
            fc.setDialogTitle( "Buscar imagen..." );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                String imagen = fc.getSelectedFile( ).getName( );
                try
                {
                    Image variableImagen = (ImageIO.read(new File( "./data/imagenes/"+imagen)));
                    
                    if(variableImagen != null)
                    {
                        txtImagen.setText( "./data/imagenes/"+imagen );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El archivo seleccionado no es una imagen válida.", "Agregar deporte", JOptionPane.ERROR_MESSAGE );
                    }
                    
                }
                catch( IOException e1 )
                {
                    JOptionPane.showMessageDialog( this, "Error al leer la imagen.", "Agregar deporte", JOptionPane.ERROR_MESSAGE );
                }
            }
        }

    }

}
