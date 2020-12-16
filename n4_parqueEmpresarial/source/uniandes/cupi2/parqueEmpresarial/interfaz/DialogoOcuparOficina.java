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
 * Di�logo para ocupar una oficina.
 */
public class DialogoOcuparOficina extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n.
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
     * Etiqueta n�mero del piso.
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
     * Campo de texto donde se coloca el n�mero del piso.
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
     * Bot�n aceptar.
     */
    private JButton btnAceptar;

    /**
     * Bot�n cancelar.
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
     * Constructor de di�logo.
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
        informacion.setLayout( new GridLayout( 4, 2 ) );

        etiquetaNumeroPiso = new JLabel( " N�mero piso " );
        etiquetaNumeroPiso.setHorizontalAlignment( JLabel.LEFT );

        etiquetaNombreEmpresa = new JLabel( " Nombre empresa " );
        etiquetaNombreEmpresa.setHorizontalAlignment( JLabel.LEFT );

        etiquetaNITEmpresa = new JLabel( " NIT empresa " );
        etiquetaNITEmpresa.setHorizontalAlignment( JLabel.LEFT );


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
        informacion.add( btnAceptar );
        informacion.add( btnCancelar );

        add( informacion, BorderLayout.CENTER );
        pack( );
        setLocationRelativeTo( null );
    }
    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento!=null.
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
            strPiso = ( String )comboNumeroPiso.getSelectedItem( );
            nombreEmpresa = txtNombreEmpresa.getText( );
            strNITEmpresa = txtNITEmpresa.getText( );
            if( !strPiso.equals( "" ) && !nombreEmpresa.equals( "" ) && !strNITEmpresa.equals( "" ) )
            {
                try
                {
                    nitEmpresa = Integer.parseInt( strNITEmpresa );
                    numeroPiso = Integer.parseInt( strPiso );
                    if( nitEmpresa < 0 )
                    {
                        JOptionPane.showMessageDialog( this, "El NIT debe ser un valor positivo.", "Ocupar oficina", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                            principal.ocuparOficina( numeroPiso, nombreEmpresa, nitEmpresa );
                            dispose( );
                    }
                }
                catch( NumberFormatException e1 )
                {
                    JOptionPane.showMessageDialog( this, "El NIT y el n�mero de empleados deben ser valores num�ricos.", "Ocupar oficina", JOptionPane.ERROR_MESSAGE );
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
