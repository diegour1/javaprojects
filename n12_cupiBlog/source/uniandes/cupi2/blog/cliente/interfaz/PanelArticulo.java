/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_cupiBlog
 * Autor: Equipo Cupi2 2019.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.blog.cliente.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.blog.cliente.mundo.Articulo;

/**
 * Panel para la visualización de un artículo del blog.
 */
public class PanelArticulo extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazClienteBlog principal;

    /**
     * Etiqueta con el título del artículo.
     */
    private JLabel lblTitulo;

    /**
     * Etiqueta con el login del usuario del autor del artículo.
     */
    private JLabel lblLogin;

    /**
     * Etiqueta con la fecha de publicación del artículo.
     */
    private JLabel lblFechaPublicacion;

    /**
     * Etiqueta con la categoría del artículo.
     */
    private JLabel lblCategoria;

    /**
     * Campo de texto con el contenido del artículo.
     */
    private JTextArea txtContenido;

    /**
     * Panel para calificar el artículo.
     */
    private PanelCalificacion panelCalificacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel para visualizar el artículo con la ventana principal dada por parámetro.<br>
     * <b>post: </b> Se construyó el panel con la ventana principal dada por parámetro.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelArticulo( InterfazClienteBlog pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 360, 515 ) );
        setBorder( new TitledBorder( "Artículo" ) );

        // Panel auxiliar que contiene la información del artículo.
        JPanel panelTituloArt = new JPanel( );
        panelTituloArt.setPreferredSize( new Dimension( 350, 100 ) );
        panelTituloArt.setLayout( new BorderLayout( ) );

        lblTitulo = new JLabel( "Título del artículo" );
        lblTitulo.setFont( new Font( "Verdana", Font.BOLD, 20 ) );

        panelTituloArt.add( lblTitulo, BorderLayout.NORTH );

        // Panel auxiliar que contiene más información del artículo.
        JPanel panelAuxArt = new JPanel( );
        panelAuxArt.setLayout( new GridLayout( 2, 2 ) );
        panelAuxArt.setPreferredSize( new Dimension( 350, 50 ) );

        lblLogin = new JLabel( "Por: " );
        panelAuxArt.add( lblLogin );

        lblFechaPublicacion = new JLabel( "Fecha publicación: ", SwingConstants.RIGHT );
        lblFechaPublicacion.setHorizontalAlignment( JLabel.RIGHT );
        panelAuxArt.add( lblFechaPublicacion );

        panelAuxArt.add( new JLabel( ) );

        lblCategoria = new JLabel( "Categoría: ", SwingConstants.RIGHT );
        lblCategoria.setHorizontalAlignment( JLabel.RIGHT );
        panelAuxArt.add( lblCategoria );

        panelTituloArt.add( panelAuxArt, BorderLayout.CENTER );

        add( panelTituloArt, BorderLayout.NORTH );

        txtContenido = new JTextArea( "Contenido del artículo." );
        txtContenido.setWrapStyleWord( true );
        txtContenido.setLineWrap( true );
        txtContenido.setEditable( false );
        txtContenido.setBackground( Color.WHITE );
        txtContenido.setPreferredSize( new Dimension( 100, 265 ) );
        JScrollPane scroll = new JScrollPane( txtContenido, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );

        add( scroll, BorderLayout.CENTER );

        panelCalificacion = new PanelCalificacion( principal );

        add( panelCalificacion, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Se actualiza la información según el artículo que llega por parámetro.
     * <b> post: </b> Se actualizaron los campos con la información del artículo dado por parámetro.
     * @param pArticulo El artículo con la información a mostrar. pArticulo != null.
     */
    public void actualizarArticulo( Articulo pArticulo )
    {
        // Actualiza la información principal del artículo
        lblTitulo.setText( pArticulo.darTitulo( ) );
        lblLogin.setText( "Por: " + pArticulo.darLoginUsuario( ) );
        lblCategoria.setText("Categoría: " + pArticulo.darCategoria( ) );

        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd kk:mm" );
        String fecha = dateFormat.format( pArticulo.darFechaPublicacion( ) );
        lblFechaPublicacion.setText( "Fecha de publicación: " + fecha );
        
        txtContenido.setText( pArticulo.darContenido( ) );
               
        panelCalificacion.actualizarInformacion( pArticulo );
        
        if( pArticulo.darLoginUsuario( ).equals( principal.darLoginActual( ) ) )
        {
            panelCalificacion.desactivarBotones( );
        }
    }

    /**
     * Desactiva las opciones del panel.
     * <b> post: </b> Desactiva los botones de calificación y pone los textos a su valor por defecto.
     */
    public void desactivar( )
    {
        lblTitulo.setText( "Título del artículo" );
        lblLogin.setText( "Por: " );
        lblCategoria.setText( "Categoría: " );
        lblFechaPublicacion.setText( "Fecha publicación: " );
        txtContenido.setText( "Contenido del artículo: " );
        
        panelCalificacion.reiniciar( );
    }
    

}
