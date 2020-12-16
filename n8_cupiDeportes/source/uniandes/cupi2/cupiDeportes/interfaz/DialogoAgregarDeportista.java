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
 * Dialogo para agregar un deportista.
 */
public class DialogoAgregarDeportista extends JDialog implements ActionListener
{
    // -----------------------------------------------
    // Constantes
    // -----------------------------------------------

    /**
     * Constante agregar deportista.
     */
    private final static String AGREGAR = "Agregar deportista";

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
     * Etiqueta edad.
     */
    private JLabel lblEdad;

    /**
     * Etiqueta lugar de residencia.
     */
    private JLabel lblLugarResidencia;

    /**
     * Etiqueta trofeos ganados.
     */
    private JLabel lblTrofeosGanados;

    /**
     * Etiqueta Imagen.
     */
    private JLabel labelImagen;

    /**
     * Campo de texto nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto edad.
     */
    private JTextField txtEdad;

    /**
     * Campo de texto lugar de residencia.
     */
    private JTextField txtLugarResidencia;

    /**
     * Campo de texto trofeos ganados.
     */
    private JTextField txtTrofeosGanados;

    /**
     * Texto con la ruta de la imagen.
     */
    private JTextField txtImagen;

    /**
     * Panel con la información del deportista.
     */
    private JPanel panelInfo;

    /**
     * Botón para agregar deportista.
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
     * Crea el dialogo para agregar un deportista.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAgregarDeportista( InterfazCupiDeportes pPrincipal )
    {
        super( pPrincipal, true );

        principal = pPrincipal;
        setTitle( "Agregar deportista" );
        setLayout( new java.awt.BorderLayout( ) );

        panelInfo = new JPanel( );
        panelInfo.setPreferredSize( new Dimension( 450, 200 ) );

        panelInfo.setBorder( new TitledBorder( "Información" ) );
        GridLayout layout = new GridLayout( 5, 2, -175, 30 );
        layout.setVgap( 10 );
        panelInfo.setLayout( layout );

        lblNombre = new JLabel( "Nombre: " );
        panelInfo.add( lblNombre );
        txtNombre = new JTextField( );
        panelInfo.add( txtNombre );

        lblEdad = new JLabel( "Edad: " );
        panelInfo.add( lblEdad );
        txtEdad = new JTextField( );
        panelInfo.add( txtEdad );

        lblLugarResidencia = new JLabel( "Lugar de residencia: " );
        panelInfo.add( lblLugarResidencia );
        txtLugarResidencia = new JTextField( );
        panelInfo.add( txtLugarResidencia );

        lblTrofeosGanados = new JLabel( "Trofeos ganados: " );
        panelInfo.add( lblTrofeosGanados );
        txtTrofeosGanados = new JTextField( );
        panelInfo.add( txtTrofeosGanados );

        labelImagen = new JLabel( "Imagen: " );
        panelInfo.add( labelImagen );

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
            String edadSt = txtEdad.getText( );
            String imagen = txtImagen.getText( );
            String lugarResidencia = txtLugarResidencia.getText( );
            String trofeosSt = txtTrofeosGanados.getText( );

            if( nombre.equals( "" ) || edadSt.equals( "" ) || lugarResidencia.equals( "" ) || imagen.equals( "" ) || trofeosSt.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Datos incompletos", "Agregar deportista", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    int edad = Integer.parseInt( edadSt );
                    int trofeos = Integer.parseInt( trofeosSt );
                    if( edad <= 0 || trofeos < 0 )
                    {
                        JOptionPane.showMessageDialog( this, "Edad y trofeos ganados deben ser números positivos.", "Agregar deportista", JOptionPane.ERROR_MESSAGE );
                    }
                    else 
                    {
                    	principal.agregarDeportistaSobresaliente( nombre, edad, lugarResidencia, trofeos, imagen );
                    	dispose( );
                    } 
                  
                }
                catch( NumberFormatException e2 )
                {
                    JOptionPane.showMessageDialog( this, "Edad y trofeos ganados deben ser números.", "Agregar deportista", JOptionPane.ERROR_MESSAGE );
                }
                catch( ElementoExisteException e3 )
                {
                    JOptionPane.showMessageDialog( this, "El deportista " + nombre + " ya existe.", "Agregar deportista", JOptionPane.ERROR_MESSAGE );
                    return;
                }
            }
        }
        if( e.getActionCommand( ).equals( EXAMINAR ) )
        {
            JFileChooser fc = new JFileChooser( "./data/imagenes" );
            fc.setDialogTitle( "Buscar Imagen..." );
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
                        JOptionPane.showMessageDialog( this, "El archivo seleccionado no es una imagen válida.", "Agregar deportista", JOptionPane.ERROR_MESSAGE );
                    }
                    
                }
                catch( IOException e1 )
                {
                    JOptionPane.showMessageDialog( this, "Error al leer la imagen.", "Agregar deportista", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
    }
}
