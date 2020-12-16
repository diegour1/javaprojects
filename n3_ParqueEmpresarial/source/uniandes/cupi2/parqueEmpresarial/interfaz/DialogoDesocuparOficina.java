/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
import javax.swing.JPanel;

/**
 * Di�logo para desocupar una oficina.
 */
public class DialogoDesocuparOficina extends JDialog implements ActionListener
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
     * Etiqueta nombreEmpresa.
     */
    private JLabel nombreEmpresa;

    /**
     * Combo con los nombres de las oficinas ocupadas.
     */
    private JComboBox comboOficinasOcupadas;

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
     */
    public DialogoDesocuparOficina( InterfazParqueEmpresarial pPrincipal)
    {
        super( pPrincipal, true );
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setTitle( "Desocupar oficina" );
        setResizable( false );

        JPanel informacion = new JPanel( );
        informacion.setLayout( new GridLayout( 2, 1 ) );

        nombreEmpresa = new JLabel( " Nombre empresa:" );
        nombreEmpresa.setHorizontalAlignment( JLabel.LEFT );
        comboOficinasOcupadas = new JComboBox( pPrincipal.darNombresOficinasOcupadas( )) ;
        comboOficinasOcupadas.addActionListener( this );
        comboOficinasOcupadas.setSelectedIndex( 0 );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );

        informacion.add( nombreEmpresa );
        informacion.add( comboOficinasOcupadas );
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
     * Manejo de los eventos de los botones
     * @param pEvento Acci�n que gener� el evento. pEvento!=null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            String nombreOficina = ( String )comboOficinasOcupadas.getSelectedItem( );
            principal.desocuparOficina(nombreOficina );
            dispose( );
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
