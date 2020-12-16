/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_subastaCelulares
 * Autor: Equipo Cupi2 - 201910
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.cupi2.subastas.interfaz;

import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Panel con la imagen del encabezado.
 */
public class PanelBanner extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la imagen de banner.
     */
    private JLabel lblImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con el banner.
     */
    public PanelBanner( )
    {

        lblImagen = new JLabel( );
        lblImagen.setHorizontalAlignment( JLabel.CENTER );
        lblImagen.setVerticalAlignment( JLabel.CENTER );
        lblImagen.setIcon( new ImageIcon( "./data/Encabezado.jpg" ) );

        setLayout( new BorderLayout( ) );
        add( lblImagen, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

}