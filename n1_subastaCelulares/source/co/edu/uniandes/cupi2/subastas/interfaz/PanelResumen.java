/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_subastaCelulares
 * Autor: Equipo Cupi2 - 201910
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.cupi2.subastas.interfaz;

import co.edu.uniandes.cupi2.subastas.mundo.Subasta;
import javax.swing.border.*;
import javax.swing.*;
import java.io.Serializable;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * Panel con la informaci�n general de la subasta.
 */
public class PanelResumen extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Etiqueta que muestra el incremento promedio.
     */
    private JLabel lblIncrementoPromedio;

    /**
     * Etiqueta que muestra el total de ofertas.
     */
    private JLabel lblTotalOfertas;

    /**
     * Etiqueta que muestra el total recaudado.
     */
    private JLabel lblTotalRecaudado;

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazSubasta principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con la informaci�n general de la subasta.
     * @param pVentanaPrincipal Ventana principal de la aplicaci�n.
     */
    public PanelResumen( InterfazSubasta pVentanaPrincipal )
    {
        principal = pVentanaPrincipal;

        setBorder( BorderFactory.createTitledBorder( "Resumen" ) );

        lblIncrementoPromedio = new JLabel( "Incremento promedio costo base: $" );

        lblTotalOfertas = new JLabel( "N�mero total de ofertas: " );

        lblTotalRecaudado = new JLabel( "Total recaudado: $" );

        setLayout( new GridLayout( 3, 1 ) );
        add( lblIncrementoPromedio );
        add( lblTotalOfertas );
        add( lblTotalRecaudado );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la interfaz con la informaci�n del mundo.
     */
    public void actualizar( Subasta subasta )
    {
        final double incrementoPromedio = subasta.calcularIncrementoPromedioCostoBase( );
        if( incrementoPromedio > 0 )
        {
            lblIncrementoPromedio.setText( "Incremento promedio costo base: $" + subasta.calcularIncrementoPromedioCostoBase( ) );
        }
        else
        {
            lblIncrementoPromedio.setText( "Incremento promedio costo base: $0" );
        }
        lblTotalOfertas.setText( "N�mero total de ofertas: " + subasta.calcularNumeroTotalOfertas( ) );
        lblTotalRecaudado.setText( "Total recaudado: $" + subasta.calcularValorTotalRecaudado( ) );
    }

}