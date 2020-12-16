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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.parqueEmpresarial.mundo.Oficina;

/**
 * Panel que representa una oficina.
 */
public class PanelOficina extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazParqueEmpresarial principal;
    
    /**
     * Representa la oficina que corresponde al panel.
     */
    private Oficina oficina;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Método constructor con parámetros.
     * @param pAncho Ancho de la oficina. pAncho > 0.
     * @param pOficina Oficina que va a ser representada. pOficina > 0.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz. pPrincipal !=null.
     */
    public PanelOficina( int pAncho, Oficina pOficina, InterfazParqueEmpresarial pPrincipal )
    {
        principal = pPrincipal;
        oficina = pOficina;
        JButton numeroOficina = new JButton( pOficina.darNumero( ) + "" );
        numeroOficina.setBorder( null );
        numeroOficina.setBorderPainted( false );
        numeroOficina.setBackground( null );
        numeroOficina.setFont( new Font( "Serif", Font.BOLD, 9 ) );
        numeroOficina.addActionListener( this );
        setLayout( new BorderLayout( ) );
        if( pOficina.estaOcupada( ) )
        {
            setBackground( Color.RED );
        }
        else
        {
            setBackground( new Color( 66, 243, 102 ) );
        }
        add( numeroOficina, BorderLayout.CENTER );
        setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
        setPreferredSize( new Dimension( pAncho, 30 ) );
    }


    /**
     * Ejecuta la acción que corresponde al botón oprimido.
     * @param pEvento Es el evento del click sobre el botón. pEvento != null.
     */
    @Override
    public void actionPerformed( ActionEvent pEvento )
    {
        principal.seleccionarOficina( oficina );        
    }
}
