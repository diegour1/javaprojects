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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Diálogo para eliminar un nuevo vagón.
 */
public class DialogoEliminarVagon extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para eliminar.
     */
    private static final String ELIMINAR = "Eliminar";

    /**
     * Constante que representa el comando de cambio en el combobox que contienes los ids de los trenes.
     */
    private static final String CAMBIO_TREN = "Cambio tren";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La ventana principal de la aplicación.
     */
    private InterfazCupiTrenes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel del diálogo.
     */
    private JPanel panelDialogo;

    /**
     * Combobox que guarda los identificadores de los trenes.
     */
    private JComboBox cbbIdTrenes;

    /**
     * Combobox que guarda los números de los vagones de un tren.
     */
    private JComboBox cbbNumVagones;

    /**
     * Botón para eliminar.
     */
    private JButton btnEliminar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo para eliminar un vagón.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoEliminarVagon( InterfazCupiTrenes pPrincipal )
    {
        setTitle( "Eliminar vagón" );
        setLocationRelativeTo( null );
        principal = pPrincipal;
        setSize( 300, 200 );
        setLocationRelativeTo( principal );
        inicializarPanelDialogo( );
        add( panelDialogo );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel del diálogo.
     */
    public void inicializarPanelDialogo( )
    {
        panelDialogo = new JPanel( );
        panelDialogo.setLayout( new BorderLayout( ) );
        panelDialogo.setBorder( new TitledBorder( "Eliminar vagón" ) );

        panelDialogo.add( new JLabel( "Ingrese los datos del vagón que desea eliminar" ), BorderLayout.NORTH );

        JPanel panelIngreso = new JPanel( );
        panelIngreso.setLayout( new GridLayout( 4, 2 ) );

        panelIngreso.add( new JLabel( ) );
        panelIngreso.add( new JLabel( ) );

        cbbNumVagones = new JComboBox( );
        panelIngreso.add( new JLabel( "Id tren: " ) );
        cbbIdTrenes = new JComboBox( );
        cbbIdTrenes.setActionCommand( CAMBIO_TREN );
        cbbIdTrenes.addActionListener( this );
        ArrayList idTrenes = principal.darIdsTrenes( );
        int id;
        for( int i = 0; i < idTrenes.size( ); i++ )
        {
            id = ( int )idTrenes.get( i );
            cbbIdTrenes.addItem( id );
        }
        panelIngreso.add( cbbIdTrenes );

        panelIngreso.add( new JLabel( "Número vagón:" ) );
        panelIngreso.add( cbbNumVagones );

        panelIngreso.add( new JLabel( ) );
        panelIngreso.add( new JLabel( ) );

        panelDialogo.add( panelIngreso, BorderLayout.CENTER );

        btnEliminar = new JButton( "Eliminar" );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );
        panelDialogo.add( btnEliminar, BorderLayout.SOUTH );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( ELIMINAR.equals( pEvento.getActionCommand( ) ) )
        {
            try
            {
                boolean pudoEliminar = principal.eliminarVagon( ( int )cbbIdTrenes.getSelectedItem( ), ( int )cbbNumVagones.getSelectedItem( ) );
                if ( pudoEliminar )
                {
                	JOptionPane.showMessageDialog( this, "El vagón " + ( int )cbbNumVagones.getSelectedItem( ) + " fue eliminado.", "Eliminar Vagón", JOptionPane.INFORMATION_MESSAGE );
                	dispose( );
                }
            }
            catch( NumberFormatException ex )
            {
                JOptionPane.showMessageDialog( this, "El identificador del tren debe ser un valor numérico.", "Eliminar ruta", JOptionPane.INFORMATION_MESSAGE );
            }
        }
        if( CAMBIO_TREN.equals( pEvento.getActionCommand( ) ) )
        {
            if( cbbNumVagones.getItemCount( ) > 0 )
            {
                cbbNumVagones.removeAllItems( );                
            }
            
            int idTren = ( int )cbbIdTrenes.getSelectedItem( );
            ArrayList numerosVagones = principal.darNumerosVagones( idTren );
            int numero;
            for( int i = 0; i < numerosVagones.size( ); i++ )
            {
                numero = ( int )numerosVagones.get( i );
                cbbNumVagones.addItem( numero );
            }
        }
    }
}
