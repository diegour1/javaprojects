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
 * Panel que contiene los botones de extensión.
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante con la acción del botón 1.
     */
    private final String OPCION_1 = "opcion 1";

    /**
     * Constante con la acción del botón 2.
     */
    private final String OPCION_2 = "opcion 2";

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
     * Botón de la extensión 1.
     */
    private JButton botonOpcion1;

    /**
     * Botón de la extensión 2.
     */
    private JButton botonOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con una referencia a la ventana principal de la aplicación.
     * @param pPrincipal Ventana principal de la aplicación - pPrincipal!=null.
     */
    public PanelExtension( InterfazHuracanes pPrincipal )
    {
        principal = pPrincipal;
        inicializar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa los componentes del panel. <br>
     * <b>post: </b> Se inicializaron y se ubicaron los componentes del panel.
     */
    private void inicializar( )
    {
        setBorder( new TitledBorder( "Puntos de Extensión" ) );

        setLayout( new FlowLayout( ) );
        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );

        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );

        add( botonOpcion1 );
        add( botonOpcion2 );
    }

    /**
     * Método se llama cuando se presiona uno de los botones.
     * @param pEvento Evento del click en el mouse.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
    }

}
