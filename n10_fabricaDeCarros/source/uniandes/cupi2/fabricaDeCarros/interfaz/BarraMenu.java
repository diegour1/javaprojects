/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: fabricaDeCarros
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.fabricaDeCarros.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Barra que contiene los menús de la aplicación.
 */
public class BarraMenu extends JMenuBar implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante que representa Abrir.
     */
    private static final String ABRIR = "Abrir";
    /**
     * Constante que representa Guardar.
     */
    //TODO Parte10 PuntoA. Agregue la constante de Guardar.
    private static final String GUARDAR = "Guardar";
    
    /**
     * Constante que representa GuardarComo.
     */
    //TODO Parte10 PuntoB. Agregue la constante de GuardarComo.
    private static final String GUARDAR_COMO = "GuardarComo";
    /**
     * Constante que representa Nuevo.
     */
    //TODO Parte10 PuntoC. Agregue la constante de Nuevo.
    private static final String NUEVO = "Nuevo";
    /**
     * Constante que representa Salir.
     */
    //TODO Parte10 PuntoD. Agregue la constante de Salir.
    private static final String SALIR = "Salir";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    /**
     * Ventana principal de la aplicación.
     */
    private InterfazFabricaDeCarros principal;
    
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Menú Archivo.
     */
    private JMenu menuArchivo;

    /**
     * Opción Nuevo del menú Archivo.
     */
    //TODO Parte10 PuntoD. Agregue el atributo para el item Nuevo.
    private JMenuItem itemNuevo;

    /**
     * Opción Abrir del menú Archivo.
     */
    private JMenuItem itemAbrir;

    /**
     * Opción Guardar del menú Archivo.
     */
    //TODO Parte10 PuntoE. Agregue el atributo para el item Guardar.
    private JMenuItem itemSalvar;

    /**
     * Opción Guardar Como del menú Archivo.
     */
    //TODO Parte10 PuntoF. Agregue el atributo para el item GuardarComo.
    private JMenuItem itemSalvarComo;
    /**
     * Opción Salir del menú Archivo.
     */
    //TODO Parte10 PuntoG. Agregue el atributo para el item Salir.
    private JMenuItem itemSalir;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la barra de menú.<br>
     * <b> post: </b> Se inicializó la barra de menú con la interfaz de fabrica de carros dada por patámetro.
     * @param pInterfazPrincipal Es una referencia a la clase principal de la interfaz. pInterfazPrincipal !=null.
     */
    public BarraMenu( InterfazFabricaDeCarros pInterfazPrincipal )
    {
        principal = pInterfazPrincipal;

        menuArchivo = new JMenu( "Archivo" );
        menuArchivo.setMnemonic( KeyEvent.VK_A );
        add( menuArchivo );

        //TODO Parte10 PuntoH. Inicialice todos los nuevos items y agreguelos a la barra.
        //Verifique que la interfaz luzca como en el documento de descripción.

        itemNuevo = new JMenuItem( "Nuevo" );
        itemNuevo.setActionCommand( NUEVO );
        itemNuevo.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK ) );
        itemNuevo.setMnemonic( KeyEvent.VK_N );
        itemNuevo.addActionListener( this );
        menuArchivo.add( itemNuevo );
        
        itemAbrir = new JMenuItem( "Abrir" );
        itemAbrir.setActionCommand( ABRIR );
        itemAbrir.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.CTRL_MASK ) );
        itemAbrir.setMnemonic( KeyEvent.VK_A );
        itemAbrir.addActionListener( this );
        menuArchivo.add( itemAbrir );
        
        itemSalvar = new JMenuItem( "Guardar" );
        itemSalvar.setActionCommand( GUARDAR );
        itemSalvar.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK ) );
        itemSalvar.setMnemonic( KeyEvent.VK_S );
        itemSalvar.addActionListener( this );
        menuArchivo.add( itemSalvar );
        
        itemSalvarComo = new JMenuItem( "Guardar como" );
        itemSalvarComo.setActionCommand( GUARDAR_COMO );
//        itemSalvarComo.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK ) );
//        itemSalvarComo.setMnemonic( KeyEvent.VK_S );
        itemNuevo.addActionListener( this );
        menuArchivo.add( itemSalvarComo );
        
        menuArchivo.addSeparator( );

        itemSalir = new JMenuItem( "Salir" );
        itemSalir.setActionCommand( SALIR );
//        itemSalir.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK ) );
//        itemSalir.setMnemonic( KeyEvent.VK_S );
        itemSalir.addActionListener( this );
        menuArchivo.add( itemSalir );


    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta la acción que corresponde a la opción del menú que fue seleccionada.
     * @param pEvento Es el evento de seleccionar una opción del menú. pEvento !=null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( ABRIR.equals( comando ) )
        {
            principal.abrir( );
        }
        //TODO Parte10 PuntoI. Agregue las modificaciones para hacer funcionar los items que creó.
        if( NUEVO.equals( comando ) )
        {
            principal.reiniciar();
        }
        if( GUARDAR.equals( comando ) )
        {
            principal.guardar( );
        }
        if( GUARDAR_COMO.equals( comando ) )
        {
            principal.guardarComo( );
        }
        if( SALIR.equals( comando ) )
        {
            principal.dispose( );
        } 
    }

}
