/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiTaxonomia
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTaxonomia.interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Clase donde se coloca la imagen del encabezado.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{
    /**
     * Método constructor por defecto. <br>
     * <b> post: </b>Coloca la imagen del encabezado de la aplicación.
     */
    public PanelImagen( )
    {
        JLabel imagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "data/imagenes/banner.png" );
        // La agrega a la etiqueta
        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        add( imagen );
        setBorder( new LineBorder( Color.BLACK ) );
    }
}
