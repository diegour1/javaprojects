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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Diálogo para registrar un nuevo usuario al blog.
 */
public class DialogoRegistrarUsuario extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para registrar el usuario.
     */
    private static final String REGISTRAR_USUARIO = "Registrar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazClienteBlog principal;

    /**
     * Campo de texto para el login del usuario.
     */
    private JTextField txtLogin;

    /**
     * Campo de texto para el nombre del usuario.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para el apellido del usuario.
     */
    private JTextField txtApellido;

    /**
     * Botón ingresar al blog.
     */
    private JButton btnIngresarBlog;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un diálogo para registrar un usuario.<br>
     * <b> post: </b> Se crea el diálogo con todos sus elementos gráficos.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoRegistrarUsuario( InterfazClienteBlog pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Registrar usuario" );
        setSize( 300, 200 );
        setLayout( new BorderLayout( ) );

        setLocationRelativeTo( null );

        JPanel panelCampos = new JPanel( );
        panelCampos.setLayout( new GridLayout( 3, 2, 10, 10 ) );
        panelCampos.setBorder( new TitledBorder( "Campos" ) );

        JLabel labNombreUsuario = new JLabel( "Login:" );
        txtLogin = new JTextField( );
        panelCampos.add( labNombreUsuario );
        panelCampos.add( txtLogin );

        JLabel labNombres = new JLabel( "Nombre:" );
        txtNombre = new JTextField( );
        panelCampos.add( labNombres );
        panelCampos.add( txtNombre );

        JLabel labApellidos = new JLabel( "Apellido:" );
        txtApellido = new JTextField( );
        panelCampos.add( labApellidos );
        panelCampos.add( txtApellido );

        add( panelCampos, BorderLayout.CENTER );

        btnIngresarBlog = new JButton( REGISTRAR_USUARIO );
        btnIngresarBlog.setActionCommand( REGISTRAR_USUARIO );
        btnIngresarBlog.addActionListener( this );
        add( btnIngresarBlog, BorderLayout.SOUTH );
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
        String comando = pEvento.getActionCommand( );
        if( comando.equals( REGISTRAR_USUARIO ) )
        {
            String login = txtLogin.getText( );
            String nombre = txtNombre.getText( );
            String apellido = txtApellido.getText( );
            if( login != null && !login.equals( "" ) && nombre != null && !nombre.equals( "" ) && apellido != null && !apellido.equals( "" ) )
            {
                principal.registrarUsuario( login, nombre, apellido );
                this.dispose( );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Por favor ingrese todos los datos.", "Registrar usuario", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }
}
