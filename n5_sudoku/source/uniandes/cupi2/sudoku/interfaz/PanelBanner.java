package uniandes.cupi2.sudoku.interfaz;

import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;


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

        setLayout( new BorderLayout( ) );
        add( lblImagen, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

}
