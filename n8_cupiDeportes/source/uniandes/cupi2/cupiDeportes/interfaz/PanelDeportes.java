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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiDeportes.mundo.Deporte;

/**
 * Panel para el manejo de los deportes.
 */
public class PanelDeportes extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para definir el action command del combo de los deportes.
     */
    private static final String COMBO_DEPORTES = "Combo deportes";
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Interfaz principal de la aplicación.
     */
    private InterfazCupiDeportes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Combo Box donde están los deportes.
     */
    // TODO Parte 6 punto A: Declare el atributo comboDeportes.
    
    private JComboBox comboDeportes;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    /**
     * Constructor del panel donde se encuentra un combo con los deportes.
     * @param pPrincipal Interfaz principal de la aplicación. pPrincipal != null.
     */
    public PanelDeportes( InterfazCupiDeportes pPrincipal )
    {
        principal = pPrincipal;
        setBorder( new TitledBorder( "Deportes" ) );
        BorderLayout layout = new BorderLayout( );
        layout.setVgap( 5 );
        layout.setHgap( 5 );
        setLayout( layout );

        // TODO Parte 6 punto B: Inicialice y agregue al panel el comboDeportes.
        
        comboDeportes = new JComboBox();
        comboDeportes.setEditable(false);
        comboDeportes.addActionListener(this);
        comboDeportes.setActionCommand(COMBO_DEPORTES);
        add(comboDeportes, BorderLayout.NORTH);
        

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza el combo box con la lista de deportes.
     * @param pDeportes Lista de deportes que estarán en el comboBox. pDeportes != null.
     */
    public void actualizarDeportes( ArrayList<Deporte> pDeportes )
    {
        comboDeportes.removeAllItems( );
        for( int i = 0; i < pDeportes.size( ); i++ )
        {
            comboDeportes.addItem( pDeportes.get( i ) );
        }
    }

    /**
     * Devuelve el deporte seleccionado.
     * @return Deporte seleccionado.
     */
    public Deporte darDeporteSeleccionado( )
    {
        return ( Deporte )comboDeportes.getSelectedItem( );
    }

    /**
     * Selecciona el deporte.
     * @param pIndice Índice del deporte a seleccionar.
     */
    public void seleccionarDeporte( int pIndice )
    {
        comboDeportes.setSelectedIndex( pIndice );
    }

    /**
     * Método en el que se tratan los eventos del diálogo. <br>
     * <b>post:</b> Cambia la información del deportista que se está mostrando de acuerdo al nuevo deportista seleccionado. 
     * @param e Parámetro que tiene encapsulado las características del elemento.
     */
    public void actionPerformed( ActionEvent e )
    {
        // TODO Parte 6 punto C: Implemente el manejo del evento con comando COMBO_DEPORTES proveniente de comboDeportes.
    	 if( e.getActionCommand( ).equals( COMBO_DEPORTES ) )
         {
    		 principal.actualizarInfoDeporte(darDeporteSeleccionado());
         }
    
    }
    

}
