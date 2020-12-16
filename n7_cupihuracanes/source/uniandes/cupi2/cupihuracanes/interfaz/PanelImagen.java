/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiHuracanes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupihuracanes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con la imagen.
 */
public class PanelImagen extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la ruta de la imagen.
     */
    public final static String RUTA = "data/Cupihuracanes1.jpg";

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
     * Constructor del Panel.
     */
    public PanelImagen( )
    {
        setLayout( new BorderLayout( ) );
        setBackground( Color.WHITE );

        // Etiqueta Logo de la pizzería
        ImageIcon icono = new ImageIcon( RUTA );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );
        etiquetaImagen.setVerticalAlignment( JLabel.CENTER );
        etiquetaImagen.setIcon( new ImageIcon( RUTA ) );

        add( etiquetaImagen, BorderLayout.CENTER );
    }

}
