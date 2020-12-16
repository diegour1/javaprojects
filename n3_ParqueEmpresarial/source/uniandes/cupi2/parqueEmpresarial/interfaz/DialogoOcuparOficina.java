/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_parqueEmpresarial
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
 * Diálogo para ocupar una oficina.
 */
public class DialogoOcuparOficina extends JDialog implements ActionListener
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
     * Etiqueta número del piso.
     */
    private JLabel etiquetaNumeroPiso;

    /**
     * Etiqueta nombre de la empresa.
     */
    private JLabel etiquetaNombreEmpresa;

    /**
     * Etiqueta NIT de la empresa.
     */
    private JLabel etiquetaNITEmpresa;

    /**
     * Etiqueta número de empleados de la empresa.
     */
    private JLabel etiquetaNumeroEmpleadosEmpresa;

    /**
     * Campo de texto donde se coloca el número del piso.
     */
    private JComboBox comboNumeroPiso;

    /**
     * Campo de texto donde se coloca el nombre de la empresa.
     */
    private JTextField txtNombreEmpresa;

    /**
     * Campo de texto donde se coloca el NIT de la empresa.
     */
    private JTextField txtNITEmpresa;

    /**
     * Campo de texto donde se coloca el número de empleados de la empresa.
     */
    private JTextField txtNumeroEmpleadosEmpresa;

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
     * @param pCantidadPisos Cantidad de pisos existentes en el edificio.
     */
    public DialogoOcuparOficina( InterfazParqueEmpresarial pPrincipal, int pCantidadPisos )
    {
        super( pPrincipal, true );
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setTitle( "Ocupar Oficina" );
        setResizable( false );

        JPanel informacion = new JPanel( );
        informacion.setLayout( new GridLayout( 5, 2 ) );

        etiquetaNumeroPiso = new JLabel( " Número piso " );
        etiquetaNumeroPiso.setHorizontalAlignment( JLabel.LEFT );

        etiquetaNombreEmpresa = new JLabel( " Nombre empresa " );
        etiquetaNombreEmpresa.setHorizontalAlignment( JLabel.LEFT );

        etiquetaNITEmpresa = new JLabel( " NIT empresa " );
        etiquetaNITEmpresa.setHorizontalAlignment( JLabel.LEFT );

        etiquetaNumeroEmpleadosEmpresa = new JLabel( " Número empleados Empresa " );
        etiquetaNumeroEmpleadosEmpresa.setHorizontalAlignment( JLabel.LEFT );

        String[] listaPisos = new String[pCantidadPisos];
        for( int i = 0; i < pCantidadPisos; i++ )
        {
            listaPisos[ i ] = "" + ( i + 1 );
        }
        comboNumeroPiso = new JComboBox( listaPisos );

        txtNombreEmpresa = new JTextField( );
        txtNombreEmpresa.setHorizontalAlignment( JLabel.LEFT );

        txtNITEmpresa = new JTextField( );
        txtNITEmpresa.setHorizontalAlignment( JLabel.LEFT );

        txtNumeroEmpleadosEmpresa = new JTextField( );
        txtNumeroEmpleadosEmpresa.setHorizontalAlignment( JLabel.LEFT );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );

        informacion.add( etiquetaNumeroPiso );
        informacion.add( comboNumeroPiso );
        informacion.add( etiquetaNombreEmpresa );
        informacion.add( txtNombreEmpresa );
        informacion.add( etiquetaNITEmpresa );
        informacion.add( txtNITEmpresa );
        informacion.add( etiquetaNumeroEmpleadosEmpresa );
        informacion.add( txtNumeroEmpleadosEmpresa );
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
            String strPiso;
            int numeroPiso = 0;
            String nombreEmpresa = "";
            String strNITEmpresa = "-1";
            int nitEmpresa = -1;
            String strNumeroEmpleadosEmpresa = "-1";
            int numeroEmpleadosEmpresa = -1;
            strPiso = ( String )comboNumeroPiso.getSelectedItem( );
            nombreEmpresa = txtNombreEmpresa.getText( );
            strNITEmpresa = txtNITEmpresa.getText( );
            strNumeroEmpleadosEmpresa = txtNumeroEmpleadosEmpresa.getText( );
            if( !strPiso.equals( "" ) && !nombreEmpresa.equals( "" ) && !strNITEmpresa.equals( "" ) && !strNumeroEmpleadosEmpresa.equals( "" ) )
            {
                try
                {
                    nitEmpresa = Integer.parseInt( strNITEmpresa );
                    numeroEmpleadosEmpresa = Integer.parseInt( strNumeroEmpleadosEmpresa );
                    numeroPiso = Integer.parseInt( strPiso );
                    if( nitEmpresa < 0 )
                    {
                        JOptionPane.showMessageDialog( this, "El NIT debe ser un valor positivo.", "Ocupar oficina", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        if( numeroEmpleadosEmpresa < 0 )
                        {
                            JOptionPane.showMessageDialog( this, "El número de empleados debe ser un valor positivo.", "Ocupar oficina", JOptionPane.ERROR_MESSAGE );
                           
                        }
                        else
                        {
                            principal.ocuparOficina( numeroPiso, nombreEmpresa, nitEmpresa, numeroEmpleadosEmpresa );
                            dispose( );
                        }
                    }
                }
                catch( NumberFormatException e1 )
                {
                    JOptionPane.showMessageDialog( this, "El NIT y el número de empleados deben ser valores numéricos.", "Ocupar oficina", JOptionPane.ERROR_MESSAGE );
                }

            }
            else
            {
                JOptionPane.showMessageDialog( this, "Todos los campos deben estar llenos.", "Ocupar oficina", JOptionPane.ERROR_MESSAGE );
            }

        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
