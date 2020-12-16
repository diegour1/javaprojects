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

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import uniandes.cupi2.cupiTaxonomia.mundo.SerVivo;

/**
 * Clase que renderiza los seres vivos en la lista.
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class SeresVivosListRenderer extends DefaultListCellRenderer
{
    /**
     * Método que permite escalar correctamente las imágenes de los seres vivos.
     * @param pLista La lista que se va a pintar. pLista != null.
     * @param pObjeto El valor retornado por pLista.getModel().getElementAt(pIndice). pObjeto != null.
     * @param pIndice El índice de la celda. pIndice >= 0.
     * @param pSeleccionado Indica si la celda especificada está seleccionada. pSelecciona != null.
     * @param pCeldaEnFoco Indica si la celda especificada tiene el foco. pCeldaEnFoco != null.
     * @return Label con la imagen del ser vivo renderizada.
     */
    public Component getListCellRendererComponent( JList pLista, Object pObjeto, int pIndice, boolean pSeleccionado, boolean pCeldaEnFoco )
    {
        JLabel label = ( JLabel )super.getListCellRendererComponent( pLista, pObjeto, pIndice, pSeleccionado, pCeldaEnFoco );

        try
        {
            SerVivo ser = ( SerVivo )pObjeto;
            BufferedImage img = ImageIO.read( new File( ser.darRutaImagen( ) ) );
            ImageIcon icono = new ImageIcon( img.getScaledInstance( 50, 50, Image.SCALE_SMOOTH ) );
            label.setIcon( icono );
        }
        catch( IOException e )
        {
            // No es posible poner la imagen
        }

        return label;
    }
}
