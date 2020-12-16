/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
	 * Constante con la acci�n de devolver el hurac�n con mayor velocidad.
	 */
    private static final String MAYOR_VELOCIDAD = "Mayor velocidad";

    /**
	 * Constante con la acci�n de devolver el hurac�n con mayor costo en da�os.
	 */
    private static final String MAYOR_DANIOS = "Mayor costo en da�os";

    /**
	 * Constante con la acci�n de devolver el hurac�n con menor costo en da�os.
	 */
    private static final String MENOR_DANIOS = "Menor costo en da�os";
    
    /**
	 * Constante con la acci�n para buscar un hurac�n.
	 */
    private static final String BUSCAR = "Buscar";
    
   
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazHuracanes principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para mostrar el nombre del hurac�n con mayor velocidad.
     */
    private JButton botonMayorVelocidad;

    /**
     * Bot�n para mostrar el hurac�n con mayor costo estimado en da�os.
     */
    private JButton botonMayorDanios;

    /**
     * Bot�n para mostrar el hurac�n con menor costo estimado en da�os.
     */
    private JButton botonMenorDanios;
    
    
    /**
     * Bot�n para realizar una b�squeda.
     */
    private JButton botonBuscar;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel e inicializa sus componentes.
     * @param pPrincipal Ventana principal de la aplicaci�n- pPrincipal != null
     */
    public PanelConsultas( InterfazHuracanes pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridLayout( 4, 1, 10, 10 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Consultas sistema" ) ) );
        
        botonBuscar = new JButton( "Buscar hurac�n" );
        botonBuscar.setActionCommand( BUSCAR );
        botonBuscar.addActionListener( this );
        add( botonBuscar);
        
        // Mayor Velocidad
        botonMayorVelocidad = new JButton( "Mayor velocidad" );
        botonMayorVelocidad.addActionListener( this );
        botonMayorVelocidad.setActionCommand( MAYOR_VELOCIDAD );
        add( botonMayorVelocidad );

        // Mayor costo da�os
        botonMayorDanios = new JButton( "Mayor costo da�os" );
        botonMayorDanios.addActionListener( this );
        botonMayorDanios.setActionCommand( MAYOR_DANIOS );
        add( botonMayorDanios );

        // Menor costo en da�os
        botonMenorDanios = new JButton( "Menor costo en da�os" );
        botonMenorDanios.addActionListener( this );
        botonMenorDanios.setActionCommand( MENOR_DANIOS );
        add( botonMenorDanios );
              
        
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una acci�n seg�n el bot�n que se haya presionado.
     * @param pEvento Evento de click sobre un bot�n.
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