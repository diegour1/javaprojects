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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Panel con la imagen.
 */
public class PanelImagen extends JPanel
{
    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

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
        setPreferredSize( new Dimension( 800, 150 ) );
        setBackground( Color.WHITE );

        ImageIcon icono = new ImageIcon( "./data/imagenes/Encabezado.JPG" );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );
        etiquetaImagen.setVerticalAlignment( JLabel.CENTER );
        etiquetaImagen.setIcon( icono );

        setBorder( new LineBorder( Color.black ) );

        add( etiquetaImagen, BorderLayout.CENTER );
    }
}
