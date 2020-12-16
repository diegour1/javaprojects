/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_sudoku
 * Autor: Diego Useche Reyes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package uniandes.cupi2.sudoku.interfaz;

import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Panel con la imagen superior de la interfaz.
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
        lblImagen.setIcon( new ImageIcon( "./data/imagenes/banner.png" ) );
        //lblImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/banner.png")));

        setLayout( new BorderLayout( ) );
        add( lblImagen, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

}
