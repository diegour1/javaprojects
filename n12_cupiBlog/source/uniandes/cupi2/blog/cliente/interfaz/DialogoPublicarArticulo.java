/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_cupiBlog
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.blog.cliente.interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.blog.cliente.mundo.Articulo;

/**
 * Di�logo para publicar un art�culo.
 */
public class DialogoPublicarArticulo extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para publicar art�culo.
     */
    private static final String PUBLICAR_ARTICULO = "Publicar";

    /**
     * Constante que representa el comando para cancelar la publicaci�n de un art�culo.
     */
    private static final String CANCELAR_PUBLICAR_ARTICULO = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazClienteBlog principal;

    /**
     * Combo box para la categor�a del art�culo.
     */
    private JComboBox cbbCategoria;
    
    /**
     * Campo de texto para el t�tulo del art�culo.
     */
    private JTextField txtTituloArticulo;

    /**
     * Campo de texto para el contenido del art�culo.
     */
    private JTextArea txtContenido;

    /**
     * Bot�n publicar el art�culo.
     */
    private JButton btnAceptarPublicacion;

    /**
     * Bot�n cancelar la publicaci�n del art�culo.
     */
    private JButton btnCancelarPublicacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un di�logo para publicar un art�culo.<br>
     * <b> post: </b> Se crea el di�logo con todos sus elementos gr�ficos.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public DialogoPublicarArticulo( InterfazClienteBlog pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Publicar art�culo" );
        setSize( 400, 300 );
        setResizable( false );
        setLayout( new BorderLayout( ) );

        setLocationRelativeTo( null );

        JPanel panelCampos = new JPanel( );
        panelCampos.setLayout( new GridBagLayout( ) );
        panelCampos.setBorder( new TitledBorder( "Campos" ) );

        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labTituloArticulo = new JLabel( "T�tulo:" );
        gbc.ipadx = 50;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCampos.add( labTituloArticulo, gbc );

        txtTituloArticulo = new JTextField( );
        gbc.ipadx = 150;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelCampos.add( txtTituloArticulo, gbc );

        JLabel labCategoria = new JLabel( "Categor�a:" );
        gbc.ipadx = 50;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelCampos.add( labCategoria, gbc );

        cbbCategoria = new JComboBox( Articulo.CATEGORIAS );
        gbc.ipadx = 150;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelCampos.add( cbbCategoria, gbc );

        JLabel labContenido = new JLabel( "Contenido:" );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 50;
        gbc.ipady = 100;
        panelCampos.add( labContenido, gbc );

        txtContenido = new JTextArea( );
        txtContenido.setWrapStyleWord( true );
        txtContenido.setLineWrap( true );
        JScrollPane scroll = new JScrollPane( txtContenido, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 150;
        gbc.ipady = 100;

        panelCampos.add( scroll, gbc );

        add( panelCampos, BorderLayout.CENTER );

        // El panel con los botones de aceptar y cancelar
        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 1, 2 ) );

        btnAceptarPublicacion = new JButton( PUBLICAR_ARTICULO );
        btnAceptarPublicacion.setActionCommand( PUBLICAR_ARTICULO );
        btnAceptarPublicacion.addActionListener( this );
        panelBotones.add( btnAceptarPublicacion, BorderLayout.SOUTH );

        btnCancelarPublicacion = new JButton( CANCELAR_PUBLICAR_ARTICULO );
        btnCancelarPublicacion.setActionCommand( CANCELAR_PUBLICAR_ARTICULO );
        btnCancelarPublicacion.addActionListener( this );
        panelBotones.add( btnCancelarPublicacion, BorderLayout.SOUTH );

        add( panelBotones, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        
        if( comando.equals( PUBLICAR_ARTICULO ) )
        {
            String titulo = txtTituloArticulo.getText( );
            String categoria = ( String )cbbCategoria.getSelectedItem( );
            String contenido = txtContenido.getText( );
            if( contenido.length( ) > 10000 )
            {
                JOptionPane.showMessageDialog( this, "El contenido del blog debe ser menor a 10000 caracteres", "Publicar art�culo", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                if( titulo != null && !titulo.equals( "" ) && contenido != null && !contenido.equals( "" ) )
                {
                    principal.publicarArticulo( titulo, categoria, contenido );
                    this.dispose( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Por favor ingrese todo los datos.", "Publicar art�culo", JOptionPane.INFORMATION_MESSAGE );
                }
            }
        }
        else if( comando.equals( CANCELAR_PUBLICAR_ARTICULO ) )
        {
            this.dispose( );
        }
    }
}
