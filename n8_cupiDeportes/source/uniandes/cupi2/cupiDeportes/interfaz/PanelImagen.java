/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_cupiDeportes
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiDeportes.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con la imagen banner.
 */
public class PanelImagen extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la imagen.
     */
    private JLabel etiquetaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     */
    public PanelImagen( )
    {
        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 800, 165 ) );

        ImageIcon icono = new ImageIcon( "data/imagenes/Encabezado.jpg" );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );
        etiquetaImagen.setVerticalAlignment( JLabel.CENTER );
        etiquetaImagen.setIcon( icono );

        add( etiquetaImagen, BorderLayout.CENTER );
    }
}
