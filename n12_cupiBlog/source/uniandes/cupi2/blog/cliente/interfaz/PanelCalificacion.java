/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_cupiBlog
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.blog.cliente.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.blog.cliente.mundo.Articulo;

/**
 * Panel para calificar un artículo.
 */
public class PanelCalificacion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa ruta de la imagen.
     */
    public final static String RUTA = "data/imagenes/";

    /**
     * Comando que representa calificación de 5 estrellas.
     */
    public final static String CINCO_ESTELLAS = "5";

    /**
     * Comando que representa calificación de 4 estrellas.
     */
    public final static String CUATRO_ESTELLAS = "4";

    /**
     * Comando que representa calificación de 3 estrellas.
     */
    public final static String TRES_ESTELLAS = "3";

    /**
     * Comando que representa calificación de 2 estrellas.
     */
    public final static String DOS_ESTELLAS = "2";

    /**
     * Comando que representa calificación de 1 estrella.
     */
    public final static String UNA_ESTELLA = "1";

    /**
     * Comando que representa calificación de 0 estrellas.
     */
    public final static String CERO_ESTELLAS = "0";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazClienteBlog principal;

    /**
     * Botón 5 estrellas.
     */
    private JButton btn5Estrellas;

    /**
     * Botón 4 estrellas.
     */
    private JButton btn4Estrellas;

    /**
     * Botón 3 estrellas.
     */
    private JButton btn3Estrellas;

    /**
     * Botón 2 estrellas.
     */
    private JButton btn2Estrellas;

    /**
     * Botón 1 estrella.
     */
    private JButton btn1Estrellas;

    /**
     * Botón 0 estrellas.
     */
    private JButton btn0Estrellas;

    /**
     * Etiqueta para el promedio de calificaciones.
     */
    private JLabel lblPromCalificaciones;

    /**
     * Etiqueta para la veces calificado.
     */
    private JLabel lblVecesCalificado;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel de calificaciones del artículo con la ventana principal dada por parámetro.<br>
     * <b>post: </b> Se construyó el panel con la ventana principal dada por parámetro.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelCalificacion( InterfazClienteBlog pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new GridLayout( 0, 2 ) );
        setPreferredSize( new Dimension( 350, 150 ) );

        JPanel panelCalificar = new JPanel( );
        panelCalificar.setLayout( new GridLayout( 6, 2 ) );
        panelCalificar.setBorder( new TitledBorder( "Calificar este artículo:" ) );

        btn0Estrellas = new JButton( );
        btn0Estrellas.setIcon( new ImageIcon( RUTA + "0_estrellas.png" ) );
        btn0Estrellas.setContentAreaFilled( false );
        btn0Estrellas.setOpaque( false );
        btn0Estrellas.setActionCommand( CERO_ESTELLAS );
        btn0Estrellas.addActionListener( this );
        btn0Estrellas.setEnabled( false );
        panelCalificar.add( btn0Estrellas );
        panelCalificar.add(  new JLabel(  ) );

        btn1Estrellas = new JButton( );
        btn1Estrellas.setIcon( new ImageIcon( RUTA + "1_estrellas.png" ) );
        btn1Estrellas.setContentAreaFilled( false );
        btn1Estrellas.setOpaque( false );
        btn1Estrellas.setActionCommand( UNA_ESTELLA );
        btn1Estrellas.addActionListener( this );
        btn1Estrellas.setEnabled( false );
        panelCalificar.add( btn1Estrellas );
        panelCalificar.add(  new JLabel( ) );

        btn2Estrellas = new JButton( );
        btn2Estrellas.setIcon( new ImageIcon( RUTA + "2_estrellas.png" ) );
        btn2Estrellas.setContentAreaFilled( false );
        btn2Estrellas.setOpaque( false );
        btn2Estrellas.setActionCommand( DOS_ESTELLAS );
        btn2Estrellas.addActionListener( this );
        btn2Estrellas.setEnabled( false );
        panelCalificar.add( btn2Estrellas );
        panelCalificar.add(  new JLabel( ) );

        btn3Estrellas = new JButton( );
        btn3Estrellas.setIcon( new ImageIcon( RUTA + "3_estrellas.png" ) );
        btn3Estrellas.setContentAreaFilled( false );
        btn3Estrellas.setOpaque( false );
        btn3Estrellas.setActionCommand( TRES_ESTELLAS );
        btn3Estrellas.addActionListener( this );
        btn3Estrellas.setEnabled( false );
        panelCalificar.add( btn3Estrellas );
        panelCalificar.add(  new JLabel( ) );

        btn4Estrellas = new JButton( );
        btn4Estrellas.setIcon( new ImageIcon( RUTA + "4_estrellas.png" ) );
        btn4Estrellas.setContentAreaFilled( false );
        btn4Estrellas.setOpaque( false );
        btn4Estrellas.setActionCommand( CUATRO_ESTELLAS );
        btn4Estrellas.addActionListener( this );
        btn4Estrellas.setEnabled( false );
        panelCalificar.add( btn4Estrellas );
        panelCalificar.add(  new JLabel( ) );

        btn5Estrellas = new JButton( );
        btn5Estrellas.setIcon( new ImageIcon( RUTA + "5_estrellas.png" ) );
        btn5Estrellas.setContentAreaFilled( false );
        btn5Estrellas.setOpaque( false );
        btn5Estrellas.setActionCommand( CINCO_ESTELLAS );
        btn5Estrellas.addActionListener( this );
        btn5Estrellas.setEnabled( false );
        panelCalificar.add( btn5Estrellas );
        panelCalificar.add(  new JLabel( ) );

        add( panelCalificar );

        JPanel panelInformacion = new JPanel( );
        panelInformacion.setLayout( new GridLayout( 4, 1 ) );
        panelInformacion.setBorder( new TitledBorder( "Un poco más sobre este artículo:" ) );

        panelInformacion.add( new JLabel( "Promedio de calificaciones:" ) );

        panelInformacion.add( new JLabel( ) );

        lblPromCalificaciones = new JLabel( );
        lblPromCalificaciones.setIcon( new ImageIcon( RUTA + "0_estrellas.png" ) );
        panelInformacion.add( lblPromCalificaciones );

        panelInformacion.add( new JLabel( ) );
        panelInformacion.add( new JLabel( "Cantidad de calificaciones:" ) );
        panelInformacion.add( new JLabel( ) );
        lblVecesCalificado = new JLabel( "0" );
        panelInformacion.add( lblVecesCalificado );

        add( panelInformacion );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Desactiva los botones del panel.
     */
    public void desactivarBotones( )
    {
        btn0Estrellas.setEnabled( false );
        btn1Estrellas.setEnabled( false );
        btn2Estrellas.setEnabled( false );
        btn3Estrellas.setEnabled( false );
        btn4Estrellas.setEnabled( false );
        btn5Estrellas.setEnabled( false );
    }

    /**
     * Actualiza la información sobre el promedio y las veces que el artículo ha sido calificado.
     * @param pArticulo El artículo calificado. pArticulo != null.
     */
    public void actualizarInformacion( Articulo pArticulo )
    {
        btn0Estrellas.setEnabled( true );
        btn1Estrellas.setEnabled( true );
        btn2Estrellas.setEnabled( true );
        btn3Estrellas.setEnabled( true );
        btn4Estrellas.setEnabled( true );
        btn5Estrellas.setEnabled( true );

        double promedio = pArticulo.darPromedioCalificaciones( );

        if( promedio > 0 && promedio <= 1.5 )
        {
            lblPromCalificaciones.setIcon( new ImageIcon( RUTA + "1_estrellas.png" ) );
        }
        else if( promedio > 1.5 && promedio <= 2.5 )
        {
            lblPromCalificaciones.setIcon( new ImageIcon( RUTA + "2_estrellas.png" ) );
        }
        else if( promedio > 2.5 && promedio <= 3.5 )
        {
            lblPromCalificaciones.setIcon( new ImageIcon( RUTA + "3_estrellas.png" ) );
        }
        else if( promedio > 3.5 && promedio <= 4.5 )
        {
            lblPromCalificaciones.setIcon( new ImageIcon( RUTA + "4_estrellas.png" ) );
        }
        else if( promedio > 4.5 )
        {
            lblPromCalificaciones.setIcon( new ImageIcon( RUTA + "5_estrellas.png" ) );
        }

        lblVecesCalificado.setText( pArticulo.darVecesCalificado( ) + "" );
    }

    /**
     * Desactiva los botones del panel y reinicia la información.
     */
    public void reiniciar( )
    {
        desactivarBotones( );

        lblPromCalificaciones.setIcon( new ImageIcon( RUTA + "0_estrellas.png" ) );
        lblVecesCalificado.setText( "0" );
    }


    /**
     * Maneja los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( CERO_ESTELLAS ) )
        {
            principal.calificarArticulo( 0 );
        }
        else if( comando.equals( UNA_ESTELLA ) )
        {
            principal.calificarArticulo( 1 );
        }
        else if( comando.equals( DOS_ESTELLAS ) )
        {
            principal.calificarArticulo( 2 );
        }
        else if( comando.equals( TRES_ESTELLAS ) )
        {
            principal.calificarArticulo( 3 );
        }
        else if( comando.equals( CUATRO_ESTELLAS ) )
        {
            principal.calificarArticulo( 4 );
        }
        else if( comando.equals( CINCO_ESTELLAS ) )
        {
            principal.calificarArticulo( 5 );
        }

    }

}
