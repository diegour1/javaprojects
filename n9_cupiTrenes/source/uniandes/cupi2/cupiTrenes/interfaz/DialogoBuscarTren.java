/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_cupiTrenes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTrenes.interfaz;

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

import uniandes.cupi2.cupiTrenes.mundo.Tren;

/**
 * Diálogo para buscar un tren.
 */
public class DialogoBuscarTren extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para buscar un tren.
     */
    private static final String BUSCAR = "Buscar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiTrenes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto para el origen del tren.
     */
    private JTextField txtOrigen;

    /**
     * Campo de texto para el destino del tren.
     */
    private JTextField txtDestino;

    /**
     * Botón para buscar.
     */
    private JButton btnBuscar;
    

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo para buscar un tren.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoBuscarTren( InterfazCupiTrenes pPrincipal )
    {
        principal = pPrincipal;
        setTitle( "Buscar tren" );
        setSize( 300, 200 );
        
        setLocationRelativeTo( principal );

        JPanel panelDialogo = new JPanel( );
        panelDialogo.setLayout( new BorderLayout( ) );
        panelDialogo.setBorder( new TitledBorder( "Buscar tren" ) );

        JPanel panelIngreso = new JPanel( );
        panelIngreso.setLayout( new GridLayout( 4, 2 ) );

        panelIngreso.add( new JLabel( ) );
        panelIngreso.add( new JLabel( ) );

        panelIngreso.add( new JLabel( "Origen: " ) );
        txtOrigen = new JTextField( );
        panelIngreso.add( txtOrigen );

        panelIngreso.add( new JLabel( "Destino:" ) );
        txtDestino = new JTextField( );
        panelIngreso.add( txtDestino );

        panelIngreso.add( new JLabel( ) );
        panelIngreso.add( new JLabel( ) );

        panelDialogo.add( panelIngreso, BorderLayout.CENTER );

        btnBuscar = new JButton( "Buscar" );
        btnBuscar.setActionCommand( BUSCAR );
        btnBuscar.addActionListener( this );
        panelDialogo.add( btnBuscar, BorderLayout.SOUTH );
        add( panelDialogo );
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
        if( BUSCAR.equals( comando ) )
        {
            String origen = txtOrigen.getText( );
            String destino = txtDestino.getText( );
            if( origen.equals( "" ) || destino.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Los campos de origen y destino no pueden estar vacíos.", "Buscar tren", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                Tren rutaTren = principal.buscarTren( origen, destino );
                if( rutaTren == null )
                {
                	JOptionPane.showMessageDialog( this, "No existen ningún tren que vaya de " + origen + " a " + destino + ".", "Buscar tren", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                	dispose( );
                }
            }
        }
    }
}
