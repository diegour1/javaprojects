/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
 * Diálogo para agregar un nuevo taxón.
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
     * Ventana principal de la aplicación.
     */
    private InterfazCupiTaxonomia principal;

    /**
     * Tipo del taxón a agregar.
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
     * Campo de texto con el nombre del taxón.
     */
    private JTextField txtNombre;

    /**
     * Botón Agregar.
     */
    private JButton btnAgregar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye un diálogo para agregar un taxón.
     * <b> post: </b> Se crea el diálogo con todos sus elementos gráficos.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     * @param pTipo Tipo del taxón a agregar. pTipo != null && pTipo != "".
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
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
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
                JOptionPane.showMessageDialog( this, "Por favor ingrese la información completa del taxón.", "Agregar taxón", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}