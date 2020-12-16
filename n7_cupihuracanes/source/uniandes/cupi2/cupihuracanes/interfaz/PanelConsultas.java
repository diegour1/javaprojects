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

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel donde se encuentran los botones para hacer consulta sobre el sistema.
 */
public class PanelConsultas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

	/**
	 * Constante con la acción de devolver el huracán con mayor velocidad.
	 */
    private static final String MAYOR_VELOCIDAD = "Mayor velocidad";

    /**
	 * Constante con la acción de devolver el huracán con mayor costo en daños.
	 */
    private static final String MAYOR_DANIOS = "Mayor costo en daños";

    /**
	 * Constante con la acción de devolver el huracán con menor costo en daños.
	 */
    private static final String MENOR_DANIOS = "Menor costo en daños";
    
    /**
	 * Constante con la acción para buscar un huracán.
	 */
    private static final String BUSCAR = "Buscar";
    
   
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
     * Botón para mostrar el nombre del huracán con mayor velocidad.
     */
    private JButton botonMayorVelocidad;

    /**
     * Botón para mostrar el huracán con mayor costo estimado en daños.
     */
    private JButton botonMayorDanios;

    /**
     * Botón para mostrar el huracán con menor costo estimado en daños.
     */
    private JButton botonMenorDanios;
    
    
    /**
     * Botón para realizar una búsqueda.
     */
    private JButton botonBuscar;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel e inicializa sus componentes.
     * @param pPrincipal Ventana principal de la aplicación- pPrincipal != null
     */
    public PanelConsultas( InterfazHuracanes pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridLayout( 4, 1, 10, 10 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Consultas sistema" ) ) );
        
        botonBuscar = new JButton( "Buscar huracán" );
        botonBuscar.setActionCommand( BUSCAR );
        botonBuscar.addActionListener( this );
        add( botonBuscar);
        
        // Mayor Velocidad
        botonMayorVelocidad = new JButton( "Mayor velocidad" );
        botonMayorVelocidad.addActionListener( this );
        botonMayorVelocidad.setActionCommand( MAYOR_VELOCIDAD );
        add( botonMayorVelocidad );

        // Mayor costo daños
        botonMayorDanios = new JButton( "Mayor costo daños" );
        botonMayorDanios.addActionListener( this );
        botonMayorDanios.setActionCommand( MAYOR_DANIOS );
        add( botonMayorDanios );

        // Menor costo en daños
        botonMenorDanios = new JButton( "Menor costo en daños" );
        botonMenorDanios.addActionListener( this );
        botonMenorDanios.setActionCommand( MENOR_DANIOS );
        add( botonMenorDanios );
              
        
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una acción según el botón que se haya presionado.
     * @param pEvento Evento de click sobre un botón.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( MAYOR_VELOCIDAD.equals( comando ) )
        {
            principal.buscarMayorVelocidad( );
        }
        else if( MAYOR_DANIOS.equals( comando ) )
        {
            principal.buscarMayorCostoDanios( );
        }
        else if( MENOR_DANIOS.equals( comando ) )
        {
            principal.buscarMenorCostoDanios( );
        }
        else if( BUSCAR.equals( comando ) )
        {
            principal.buscar( );
        }

    }
}