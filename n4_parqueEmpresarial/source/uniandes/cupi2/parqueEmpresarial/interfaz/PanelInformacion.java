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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.parqueEmpresarial.mundo.Empleado;
import uniandes.cupi2.parqueEmpresarial.mundo.Oficina;

/**
 * Panel de manejo de extensiones.
 */
public class PanelInformacion extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante para la acción del botón registrar ingreso.
     */
    private static final String REGISTRAR_INGRESO = "Registrar ingreso";

    /**
     * Constante para la acción del botón registrar salida.
     */
    private static final String REGISTRAR_SALIDA = "Registrar salida";

    /**
     * Constante para la acción del botón ver registro.
     */
    private static final String VER_REGISTRO = "Ver registro";



    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazParqueEmpresarial principal;
    
    /**
     * Oficina seleccionada.
     */
    private Oficina oficina;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Lista de oficinas ocupadas.
     */
    private JList listaEmpleados;

    /**
     * Scroll para la lista de empleados.
     */
    private JScrollPane scroll;

    /**
     * Etiqueta para el numero de oficina
     */
    private JTextField lblNumeroOficina;

    /**
     * Etiqueta para el tamaño de la oficina.
     */
    private JTextField lblTamanio;

    /**
     * Etiqueta para el nombre de la empresa.
     */
    private JTextField lblNombreEmpresa;

    /**
     * Etiqueta para el nit de la empresa.
     */
    private JTextField lblNitEmpresa;

    /**
     * Botón para registrar el ingreso de un empleado.
     */
    private JButton btnRegistrarIngreso;

    /**
     * Botón para registrar la salida de un empleado.
     */
    private JButton btnRegistrarSalida;

    /**
     * Botón para ver el registro de un empleado.
     */
    private JButton btnVerRegistro;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal. pPrincipal!=null.
     */
    public PanelInformacion( InterfazParqueEmpresarial pPrincipal )
    {
        principal = pPrincipal;
        setBorder( new TitledBorder( "Información" ) );
        setLayout( new BorderLayout( ) );

        JPanel panelAux = new JPanel( new GridLayout( 4, 2, 0, 15 ) );
        panelAux.add( new JLabel( "# Oficina:" ) );
        lblNumeroOficina = new JTextField( "--" );
        lblNumeroOficina.setEnabled( false );
        panelAux.add( lblNumeroOficina );
        panelAux.add( new JLabel( "Tamaño:" ) );
        lblTamanio = new JTextField( "--" );
        lblTamanio.setEnabled( false );
        panelAux.add( lblTamanio );
        panelAux.add( new JLabel( "Empresa:" ) );
        lblNombreEmpresa = new JTextField( "--" );
        lblNombreEmpresa.setEnabled( false );
        panelAux.add( lblNombreEmpresa );
        panelAux.add( new JLabel( "NIT:" ) );
        lblNitEmpresa = new JTextField( "--" );
        lblNitEmpresa.setEnabled( false );
        panelAux.add( lblNitEmpresa );

        add(panelAux, BorderLayout.CENTER);

        listaEmpleados = new JList( );
        scroll = new JScrollPane( listaEmpleados);
        scroll.setPreferredSize( new Dimension( 200, 200 ) );

        JPanel panelBotones = new JPanel( new GridLayout( 3, 1 ) );
        btnRegistrarIngreso = new JButton( REGISTRAR_INGRESO );
        btnRegistrarIngreso.setActionCommand( REGISTRAR_INGRESO );
        btnRegistrarIngreso.addActionListener( this );

        btnRegistrarSalida = new JButton( REGISTRAR_SALIDA );
        btnRegistrarSalida.setActionCommand( REGISTRAR_SALIDA );
        btnRegistrarSalida.addActionListener( this );

        btnVerRegistro = new JButton( VER_REGISTRO );
        btnVerRegistro.setActionCommand( VER_REGISTRO );
        btnVerRegistro.addActionListener( this );

        panelBotones.add( btnRegistrarIngreso );
        panelBotones.add( btnRegistrarSalida );
        panelBotones.add( btnVerRegistro );


        JPanel panelEmpleados = new JPanel(new BorderLayout( ) );
        panelEmpleados.setBorder( new TitledBorder( "Empleados" ) );
        panelEmpleados.add( scroll, BorderLayout.CENTER );
        panelEmpleados.add( panelBotones, BorderLayout.SOUTH );


        add( panelEmpleados, BorderLayout.SOUTH );
    }


    /**
     * Actualiza la información mostrada con la información de la oficina dada por parámetro.
     * @param pOficina Oficina seleccionada. pOficina != null
     */
    public void cambiarOficinaSeleccionada( Oficina pOficina )
    {
        oficina = pOficina;
        if(oficina!=null){
            lblNitEmpresa.setText( oficina.darEmpresa( ) != null ? oficina.darEmpresa( ).darNIT( )+"": "--" );
            lblNombreEmpresa.setText( oficina.darEmpresa( ) != null ? oficina.darEmpresa( ).darNombre( )+"": "--" );
            lblNumeroOficina.setText( oficina.darNumero( )+"" );
            lblTamanio.setText( String.format( "%.2f mts", oficina.darTamano( ) ) );

           
            listaEmpleados.setListData(oficina.estaOcupada( ) ? oficina.darEmpresa( ).darEmpleados( ).toArray(  ) : new Empleado[]{} );
            listaEmpleados.setSelectedIndex( listaEmpleados.getModel( ).getSize( )-1 );
            boolean activados = oficina.estaOcupada( ) && oficina.darEmpresa( ).darNumeroEmpleados( )>0;
            btnRegistrarIngreso.setEnabled( activados );
            btnRegistrarSalida.setEnabled( activados );
            btnVerRegistro.setEnabled( activados );

        }


    }

    /**
     * Actualiza la información mostrada de la oficina seleccionada.
     */
    public void actualizar(){
        cambiarOficinaSeleccionada( oficina );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento!=null.
     */
    @Override
    public void actionPerformed( ActionEvent pEvento ){
        Empleado empleado = ( Empleado )listaEmpleados.getSelectedValue( );
        switch( pEvento.getActionCommand( ) )
        {
            case REGISTRAR_INGRESO:
                principal.registrar( empleado.darCedula( ), 1 );
                break;

            case REGISTRAR_SALIDA:
                principal.registrar( empleado.darCedula( ), -1 );
                break;
            case VER_REGISTRO:
                JOptionPane.showMessageDialog( principal, empleado+" :\n"+empleado.darRegistro( ),"Registro de entradas y salidas", JOptionPane.INFORMATION_MESSAGE );
                break;
        }
        
    }


}
