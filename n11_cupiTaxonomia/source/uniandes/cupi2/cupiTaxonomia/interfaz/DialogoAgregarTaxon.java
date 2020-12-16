/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiTaxonomia
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiTaxonomia.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Di�logo para agregar un nuevo tax�n.
 */
@SuppressWarnings({ "rawtypes", "serial","unchecked" })
public class DialogoAgregarTaxon extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para agregar.
     */
    private final static String AGREGAR = "Agregar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazCupiTaxonomia principal;

    /**
     * Tipo del tax�n a agregar.
     */
    private int tipoTaxon;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * ComboBox que guarda los posibles taxones padres.
     */
    private JComboBox comboPadres;

    /**
     * Campo de texto con el nombre del tax�n.
     */
    private JTextField txtNombre;

    /**
     * Bot�n Agregar.
     */
    private JButton btnAgregar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye un di�logo para agregar un tax�n.
     * <b> post: </b> Se crea el di�logo con todos sus elementos gr�ficos.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     * @param pTipo Tipo del tax�n a agregar. pTipo != null && pTipo != "".
     */
    public DialogoAgregarTaxon( InterfazCupiTaxonomia pPrincipal, String pTipo )
    {
        principal = pPrincipal;

        String[] info = pTipo.split( ". " );
        tipoTaxon = Integer.parseInt( info[ 0 ] );

        setLayout( new BorderLayout( ) );
        setSize( 250, 120 );
        setModal( true );
        setLocationRelativeTo( principal );
        setTitle( "Agregar " + info[ 1 ] );
        setResizable( false );

        JPanel panel1 = new JPanel( );
        panel1.setPreferredSize( new Dimension( 0, 50 ) );
        panel1.setLayout( new GridLayout( 2, 2 ) );

        ArrayList listaPadres = principal.darTaxonesTipo( tipoTaxon - 1 );

        panel1.add( new JLabel( " Padre: " ) );
        comboPadres = new JComboBox( listaPadres.toArray( ) );
        panel1.add( comboPadres );

        panel1.add( new JLabel( " Nombre: " ) );
        txtNombre = new JTextField( );
        panel1.add( txtNombre );

        JPanel panel2 = new JPanel( );
        panel2.setLayout( new BorderLayout( ) );

        add( panel1, BorderLayout.CENTER );

        btnAgregar = new JButton( AGREGAR );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        add( btnAgregar, BorderLayout.SOUTH );
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
        if( comando.equals( AGREGAR ) )
        {
            String padre = ( String )comboPadres.getSelectedItem( );
            String nombre = txtNombre.getText( );

            if( padre != null && !padre.isEmpty( ) && nombre != null && !nombre.isEmpty( ) )
            {
                principal.agregarTaxon( padre, tipoTaxon, nombre );
                this.dispose( );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Por favor ingrese la informaci�n completa del tax�n.", "Agregar tax�n", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}