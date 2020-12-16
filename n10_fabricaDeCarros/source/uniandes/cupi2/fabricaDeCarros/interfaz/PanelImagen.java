/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: fabricaDeCarros
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.fabricaDeCarros.interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Clase donde se coloca la imagen encabezado.
 */
public class PanelImagen extends JPanel
{

    /**
     * Crea el panel de encabezado agregando la imagen.
     */
    public PanelImagen( )
    {
        JLabel imagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "data/imagenes/titulo.jpg" );

        // La agrega a la etiqueta
        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        add( imagen );

        setBackground( Color.WHITE );
        setBorder( new LineBorder( Color.BLACK ) );
    }
}
