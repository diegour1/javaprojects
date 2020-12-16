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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.parqueEmpresarial.mundo.Oficina;

/**
 * Panel que representa una oficina.
 */
public class PanelOficina extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Método constructor con parámetros.
     * @param pAncho Ancho de la oficina. pAncho > 0.
     * @param pOficina Oficina que va a ser representada. pOficina > 0.
     */
    public PanelOficina( int pAncho, Oficina pOficina )
    {
        JLabel numeroOficina = new JLabel( pOficina.darNumero( ) + "" );
        numeroOficina.setFont( new Font( "Serif", Font.BOLD, 9 ) );
        if( pOficina.estaOcupada( ) )
        {
            setBackground( Color.RED );
            add( numeroOficina );
        }
        else
        {
            setBackground( new Color( 66, 243, 102 ) );
            add( numeroOficina );
        }
        setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
        setPreferredSize( new Dimension( pAncho, 30 ) );
    }
}
