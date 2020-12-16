/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueEmpresarial
 * Autor: Equipo Cupi2 - 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.parqueEmpresarial.interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones.
 */
public class PanelOpciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando de agregar nuevo piso.
     */
    private static final String AGREGAR_PISO = "Agregar piso";

    /**
     * Comando de ocupar nueva oficina.
     */
    private static final String OCUPAR_OFICINA = "Ocupar oficina";

    /**
     * Comando de dar porcentaje de ocupación.
     */
    private static final String PORCENTAJE_OCUPACION = "Porcentaje de ocupación";

    /**
     * Comando de buscar oficina.
     */
    private static final String BUSCAR_OFICINA = "Buscar oficina";

    /**
     * Comando de desocupar oficina.
     */
    private static final String DESOCUPAR_OFICINA = "Desocupar oficina";

    /**
     * Comando de buscar piso con más empleados.
     */
    private static final String MAS_EMPLEADOS = "Buscar piso con más empleados";

    /**
     * Comando de agregar empleado
     */
    private static final String AGREGAR_EMPLEADO = "Agregar empleado";
    
    /**
     * Comando de eliminar empleado
     */
    private static final String ELIMINAR_EMPLEADO = "Eliminar empleado";
    
    /**
     * Comando Opción 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazParqueEmpresarial principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón agregar piso.
     */
    private JButton btnAgregarPiso;

    /**
     * Botón ocupar oficina.
     */
    private JButton btnOcuparOficina;

    /**
     * Botón porcentaje ocupación.
     */
    private JButton btnPorcentajeOcupacion;

    /**
     * Botón buscar oficina.
     */
    private JButton btnBuscarOficina;

    /**
     * Botón desocupar oficina.
     */
    private JButton btnDesocuparOficina;

    /**
     * Botón buscar pisos con el mismo número de oficinas.
     */
    private JButton btnMismasOficinas;

    /**
     * Botón para agregar empleado.
     */
    private JButton btnAgregarEmpleado;
    
    /**
     * Botón para eliminar empleado.
     */
    private JButton btnEliminarEmpleado;
    
    /**
     * Botón Opción 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal. pPrincipal!=null.
     */
    public PanelOpciones( InterfazParqueEmpresarial pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Opciones" ) );
        GridBagLayout gb = new GridBagLayout( );
        GridBagConstraints gbc = new GridBagConstraints( );
        setLayout( gb );

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weighty = 1;

        // Botón agregar piso
        btnAgregarPiso = new JButton( "Agregar piso" );
        btnAgregarPiso.setActionCommand( AGREGAR_PISO );
        btnAgregarPiso.setPreferredSize( new Dimension( 178, 40 ) );
        btnAgregarPiso.addActionListener( this );
        gbc.gridy = 0;
        gb.setConstraints( btnAgregarPiso, gbc );
        add( btnAgregarPiso, gbc );

        // Botón ocupar oficina
        btnOcuparOficina = new JButton( "Ocupar oficina" );
        btnOcuparOficina.setActionCommand( OCUPAR_OFICINA );
        btnOcuparOficina.setPreferredSize( new Dimension( 178, 40 ) );
        btnOcuparOficina.addActionListener( this );
        btnOcuparOficina.setEnabled( false );
        gbc.gridy = 1;
        gb.setConstraints( btnOcuparOficina, gbc );
        add( btnOcuparOficina, gbc );

        // Botón porcentaje ocupación
        btnPorcentajeOcupacion = new JButton( "Porcentaje ocupación" );
        btnPorcentajeOcupacion.setActionCommand( PORCENTAJE_OCUPACION );
        btnPorcentajeOcupacion.setPreferredSize( new Dimension( 178, 40 ) );
        btnPorcentajeOcupacion.addActionListener( this );
        gbc.gridy = 2;
        add( btnPorcentajeOcupacion, gbc );

        // Botón buscar oficina
        btnBuscarOficina = new JButton( "Buscar oficina" );
        btnBuscarOficina.setActionCommand( BUSCAR_OFICINA );
        btnBuscarOficina.setPreferredSize( new Dimension( 178, 40 ) );
        btnBuscarOficina.addActionListener( this );
        gbc.gridy = 3;
        add( btnBuscarOficina, gbc );

        // Botón desocupar oficina
        btnDesocuparOficina = new JButton( "Desocupar oficina" );
        btnDesocuparOficina.setActionCommand( DESOCUPAR_OFICINA );
        btnDesocuparOficina.setPreferredSize( new Dimension( 178, 40 ) );
        btnDesocuparOficina.addActionListener( this );
        gbc.gridy = 4;
        add( btnDesocuparOficina, gbc );

        // Botón agregar empleado
        btnAgregarEmpleado = new JButton( AGREGAR_EMPLEADO );
        btnAgregarEmpleado.setActionCommand( AGREGAR_EMPLEADO );
        btnAgregarEmpleado.setPreferredSize( new Dimension( 178, 40 ) );
        btnAgregarEmpleado.addActionListener( this );
        gbc.gridy = 5;
        add( btnAgregarEmpleado, gbc );
        
        // Botón eliminar empleado
        btnEliminarEmpleado = new JButton( ELIMINAR_EMPLEADO );
        btnEliminarEmpleado.setActionCommand( ELIMINAR_EMPLEADO );
        btnEliminarEmpleado.setPreferredSize( new Dimension( 178, 40 ) );
        btnEliminarEmpleado.addActionListener( this );
        gbc.gridy = 6;
        add( btnEliminarEmpleado, gbc );

        // Botón buscar piso con más empleados
        btnMismasOficinas = new JButton( "Piso con más empleados" );
        btnMismasOficinas.setActionCommand( MAS_EMPLEADOS );
        btnMismasOficinas.setPreferredSize( new Dimension( 178, 40 ) );
        btnMismasOficinas.addActionListener( this );
        gbc.gridy = 7;
        add( btnMismasOficinas, gbc );

        // Botón opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.setPreferredSize( new Dimension( 178, 40 ) );
        btnOpcion1.addActionListener( this );
        gbc.gridy = 8;
        add( btnOpcion1, gbc );

        // Botón opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.setPreferredSize( new Dimension( 178, 40 ) );
        btnOpcion2.addActionListener( this );
        gbc.gridy = 9;
        add( btnOpcion2, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Habilita el botón OcuparOficina.
     */
    public void habilitarBotonOcuparOficina( )
    {
        btnOcuparOficina.setEnabled( true );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento!=null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( OPCION_1.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( AGREGAR_PISO.equals( pEvento.getActionCommand( ) ) )
        {
            principal.agregarPiso( );
        }
        else if( OCUPAR_OFICINA.equals( pEvento.getActionCommand( ) ) )
        {
            principal.mostrarDialogoOcuparOficina( );
        }
        else if( PORCENTAJE_OCUPACION.equals( pEvento.getActionCommand( ) ) )
        {
            principal.darPorcentajeOcupacion( );
        }
        else if( BUSCAR_OFICINA.equals( pEvento.getActionCommand( ) ) )
        {
            principal.buscarOficina( );
        }
        else if( DESOCUPAR_OFICINA.equals( pEvento.getActionCommand( ) ) )
        {
            principal.mostrarDialogoDesocuparOficina( );
        }
        else if( MAS_EMPLEADOS.equals( pEvento.getActionCommand( ) ) )
        {
            principal.buscarPisoConMayorNumeroDeEmpleados( );
        }
        else if(AGREGAR_EMPLEADO.equals( pEvento.getActionCommand( ) )){
            new DialogoAgregarEmpleado( principal ).setVisible( true );
        }
        else if(ELIMINAR_EMPLEADO.equals( pEvento.getActionCommand( ) )){
            principal.eliminarEmpleado( );
        }
    }

}
