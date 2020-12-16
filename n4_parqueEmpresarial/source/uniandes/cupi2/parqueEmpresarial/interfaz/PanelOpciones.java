/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
     * Constante para la serializaci�n.
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
     * Comando de dar porcentaje de ocupaci�n.
     */
    private static final String PORCENTAJE_OCUPACION = "Porcentaje de ocupaci�n";

    /**
     * Comando de buscar oficina.
     */
    private static final String BUSCAR_OFICINA = "Buscar oficina";

    /**
     * Comando de desocupar oficina.
     */
    private static final String DESOCUPAR_OFICINA = "Desocupar oficina";

    /**
     * Comando de buscar piso con m�s empleados.
     */
    private static final String MAS_EMPLEADOS = "Buscar piso con m�s empleados";

    /**
     * Comando de agregar empleado
     */
    private static final String AGREGAR_EMPLEADO = "Agregar empleado";
    
    /**
     * Comando de eliminar empleado
     */
    private static final String ELIMINAR_EMPLEADO = "Eliminar empleado";
    
    /**
     * Comando Opci�n 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opci�n 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazParqueEmpresarial principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n agregar piso.
     */
    private JButton btnAgregarPiso;

    /**
     * Bot�n ocupar oficina.
     */
    private JButton btnOcuparOficina;

    /**
     * Bot�n porcentaje ocupaci�n.
     */
    private JButton btnPorcentajeOcupacion;

    /**
     * Bot�n buscar oficina.
     */
    private JButton btnBuscarOficina;

    /**
     * Bot�n desocupar oficina.
     */
    private JButton btnDesocuparOficina;

    /**
     * Bot�n buscar pisos con el mismo n�mero de oficinas.
     */
    private JButton btnMismasOficinas;

    /**
     * Bot�n para agregar empleado.
     */
    private JButton btnAgregarEmpleado;
    
    /**
     * Bot�n para eliminar empleado.
     */
    private JButton btnEliminarEmpleado;
    
    /**
     * Bot�n Opci�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n Opci�n 2.
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

        // Bot�n agregar piso
        btnAgregarPiso = new JButton( "Agregar piso" );
        btnAgregarPiso.setActionCommand( AGREGAR_PISO );
        btnAgregarPiso.setPreferredSize( new Dimension( 178, 40 ) );
        btnAgregarPiso.addActionListener( this );
        gbc.gridy = 0;
        gb.setConstraints( btnAgregarPiso, gbc );
        add( btnAgregarPiso, gbc );

        // Bot�n ocupar oficina
        btnOcuparOficina = new JButton( "Ocupar oficina" );
        btnOcuparOficina.setActionCommand( OCUPAR_OFICINA );
        btnOcuparOficina.setPreferredSize( new Dimension( 178, 40 ) );
        btnOcuparOficina.addActionListener( this );
        btnOcuparOficina.setEnabled( false );
        gbc.gridy = 1;
        gb.setConstraints( btnOcuparOficina, gbc );
        add( btnOcuparOficina, gbc );

        // Bot�n porcentaje ocupaci�n
        btnPorcentajeOcupacion = new JButton( "Porcentaje ocupaci�n" );
        btnPorcentajeOcupacion.setActionCommand( PORCENTAJE_OCUPACION );
        btnPorcentajeOcupacion.setPreferredSize( new Dimension( 178, 40 ) );
        btnPorcentajeOcupacion.addActionListener( this );
        gbc.gridy = 2;
        add( btnPorcentajeOcupacion, gbc );

        // Bot�n buscar oficina
        btnBuscarOficina = new JButton( "Buscar oficina" );
        btnBuscarOficina.setActionCommand( BUSCAR_OFICINA );
        btnBuscarOficina.setPreferredSize( new Dimension( 178, 40 ) );
        btnBuscarOficina.addActionListener( this );
        gbc.gridy = 3;
        add( btnBuscarOficina, gbc );

        // Bot�n desocupar oficina
        btnDesocuparOficina = new JButton( "Desocupar oficina" );
        btnDesocuparOficina.setActionCommand( DESOCUPAR_OFICINA );
        btnDesocuparOficina.setPreferredSize( new Dimension( 178, 40 ) );
        btnDesocuparOficina.addActionListener( this );
        gbc.gridy = 4;
        add( btnDesocuparOficina, gbc );

        // Bot�n agregar empleado
        btnAgregarEmpleado = new JButton( AGREGAR_EMPLEADO );
        btnAgregarEmpleado.setActionCommand( AGREGAR_EMPLEADO );
        btnAgregarEmpleado.setPreferredSize( new Dimension( 178, 40 ) );
        btnAgregarEmpleado.addActionListener( this );
        gbc.gridy = 5;
        add( btnAgregarEmpleado, gbc );
        
        // Bot�n eliminar empleado
        btnEliminarEmpleado = new JButton( ELIMINAR_EMPLEADO );
        btnEliminarEmpleado.setActionCommand( ELIMINAR_EMPLEADO );
        btnEliminarEmpleado.setPreferredSize( new Dimension( 178, 40 ) );
        btnEliminarEmpleado.addActionListener( this );
        gbc.gridy = 6;
        add( btnEliminarEmpleado, gbc );

        // Bot�n buscar piso con m�s empleados
        btnMismasOficinas = new JButton( "Piso con m�s empleados" );
        btnMismasOficinas.setActionCommand( MAS_EMPLEADOS );
        btnMismasOficinas.setPreferredSize( new Dimension( 178, 40 ) );
        btnMismasOficinas.addActionListener( this );
        gbc.gridy = 7;
        add( btnMismasOficinas, gbc );

        // Bot�n opci�n 1
        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.setPreferredSize( new Dimension( 178, 40 ) );
        btnOpcion1.addActionListener( this );
        gbc.gridy = 8;
        add( btnOpcion1, gbc );

        // Bot�n opci�n 2
        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.setPreferredSize( new Dimension( 178, 40 ) );
        btnOpcion2.addActionListener( this );
        gbc.gridy = 9;
        add( btnOpcion2, gbc );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Habilita el bot�n OcuparOficina.
     */
    public void habilitarBotonOcuparOficina( )
    {
        btnOcuparOficina.setEnabled( true );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento!=null.
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
