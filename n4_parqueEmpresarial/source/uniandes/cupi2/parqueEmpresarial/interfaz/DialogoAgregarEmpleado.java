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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Diálogo para agregar un empleado.
 */
public class DialogoAgregarEmpleado extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando aceptar.
     */
    private static final String ACEPTAR = "Aceptar";

    /**
     * Comando cancelar.
     */
    private static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto donde se coloca el nombre de la empresa.
     */
    private JTextField txtNombreEmpresa;

    /**
     * Campo de texto donde se coloca el nombre del empleado.
     */
    private JTextField txtNombreEmpleado;

    /**
     * Campo de texto donde se coloca la cédula del empleado.
     */
    private JTextField txtCedulaEmpleado;

    /**
     * Botón aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Interfaz principal.
     */
    private InterfazParqueEmpresarial principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de diálogo.
     * @param pPrincipal Representa la clase principal de la interfaz. pPrincipal!=null.
     */
    public DialogoAgregarEmpleado( InterfazParqueEmpresarial pPrincipal )
    {
        super( pPrincipal, true );
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setTitle( "Agregar Empleado" );
        setResizable( false );

        JPanel informacion = new JPanel( );
        informacion.setLayout( new GridLayout( 4, 2 ) );

        JLabel etiquetaNombreEmpresa = new JLabel( "Empresa :" );
        etiquetaNombreEmpresa.setHorizontalAlignment( JLabel.LEFT );

        JLabel etiquetaNombreEmpleado = new JLabel( "Nombre empleado : " );
        etiquetaNombreEmpleado.setHorizontalAlignment( JLabel.LEFT );

        JLabel etiquetaCedulaEmpleado = new JLabel( "Cédula empleado : " );
        etiquetaCedulaEmpleado.setHorizontalAlignment( JLabel.LEFT );


        txtNombreEmpresa = new JTextField( );
        txtNombreEmpresa.setHorizontalAlignment( JLabel.LEFT );

        txtNombreEmpleado = new JTextField( );
        txtNombreEmpleado.setHorizontalAlignment( JLabel.LEFT );

        txtCedulaEmpleado = new JTextField( );
        txtCedulaEmpleado.setHorizontalAlignment( JLabel.LEFT );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );

        informacion.add( etiquetaNombreEmpresa );
        informacion.add( txtNombreEmpresa );
        informacion.add( etiquetaNombreEmpleado );
        informacion.add( txtNombreEmpleado );
        informacion.add( etiquetaCedulaEmpleado );
        informacion.add( txtCedulaEmpleado );
        informacion.add( btnAceptar );
        informacion.add( btnCancelar );

        add( informacion, BorderLayout.CENTER );
        pack( );
        setLocationRelativeTo( null );
    }
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento!=null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            String nombreEmpresa = "";
            String nombreEmpleado = "";
            String cedulaEmpleado = "";
            nombreEmpresa = txtNombreEmpresa.getText( ).trim( );
            nombreEmpleado = txtNombreEmpleado.getText( ).trim( );
            cedulaEmpleado = txtCedulaEmpleado.getText( ).trim( );
            if( !nombreEmpresa.equals( "" ) && !nombreEmpleado.equals( "" ) && !cedulaEmpleado.equals( "" ) )
            {
                for(char c: cedulaEmpleado.toCharArray( )){
                    if(!Character.isDigit( c )){
                        JOptionPane.showMessageDialog( this, "La cedula debe contener solo números.", "Agregar Empleado", JOptionPane.ERROR_MESSAGE );        
                        return;
                    }
                }
                setVisible( false );
                if(!principal.agregarEmpleado( nombreEmpresa, nombreEmpleado, cedulaEmpleado )){
                    setVisible( true );
                }
                else{
                    dispose( );
                }

            }
            else
            {
                JOptionPane.showMessageDialog( this, "Todos los campos deben estar llenos.", "Agregar Empleado", JOptionPane.ERROR_MESSAGE );
            }

        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
