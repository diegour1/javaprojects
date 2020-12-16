/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiHuracanes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupihuracanes.interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel donde se encuentran los botones para realizar los ordenamientos de la lista de huracanes.
 */
public class PanelOrdenamientos extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

	/**
	 * Constante de la acción de ordenar la lista por nombre.
	 */
    private static final String ORDENAR_NOMBRE = "OrdenarNombre";

    /**
	 * Constante de la acción de ordenar la lista por costo en daños.
	 */
    private static final String ORDENAR_COSTO_DANIOS = "OrdenarCostoDanios";

    /**
	 * Constante de la acción de ordenar la lista por velocidad.
	 */
    private static final String ORDENAR_VELOCIDAD = "OrdenarVelocidad";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazHuracanes principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
   
    /**
     * Botón para ordenar la lista de huracanes por nombre.
     */
    private JButton botonOrdenarNombre;

    /**
     * Botón para ordenar la lista de huracanes por costo estimado en daños.
     */
    private JButton botonOrdenarCostoDanios;

    /**
     * Botón para ordenar la lista de huracanes por velocidad.
     */
    private JButton botonOrdenarVelocidad;

    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null
     */
    public PanelOrdenamientos( InterfazHuracanes pPrincipal )
    {
        principal = pPrincipal;

        setPreferredSize( new Dimension( 200, 0 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Ordenamientos" ) ) );
        setLayout( new GridBagLayout( ) );

        botonOrdenarNombre = new JButton( "Ordenar por nombre" );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        botonOrdenarNombre.setActionCommand( ORDENAR_NOMBRE );
        botonOrdenarNombre.addActionListener( this );
        add( botonOrdenarNombre, gbc );

        botonOrdenarCostoDanios = new JButton( "Ordenar por costo en daños" );
        botonOrdenarCostoDanios.setActionCommand( ORDENAR_COSTO_DANIOS );
        botonOrdenarCostoDanios.addActionListener( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        add( botonOrdenarCostoDanios, gbc );

        botonOrdenarVelocidad = new JButton( "Ordenar por velocidad" );
        botonOrdenarVelocidad.setActionCommand( ORDENAR_VELOCIDAD );
        botonOrdenarVelocidad.addActionListener( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        add( botonOrdenarVelocidad, gbc );

    }

    /**
     * Ejecuta una acción según el botón que se haya presionado.
     * @param pEvento Evento de click sobre un botón.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( ORDENAR_VELOCIDAD.equals( comando ) )
        {
            principal.ordenarPorVelocidad( );
        }
        else if( ORDENAR_NOMBRE.equals( comando ) )
        {
            principal.ordenarPorNombre( );
        }
        else if( ORDENAR_COSTO_DANIOS.equals( comando ) )
        {
            principal.ordenarPorCostoDanios( );
        }
        
    }
}
