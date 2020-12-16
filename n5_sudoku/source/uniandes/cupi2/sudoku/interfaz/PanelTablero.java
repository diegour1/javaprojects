package uniandes.cupi2.sudoku.interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.sudoku.mundo.Sudoku;

public class PanelTablero extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la imagen del sudoku
     */
    private JLabel lblImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con la imagen del tablero de sudoku.
     */
    public PanelTablero()
    {
    	lblImagen = new JLabel( );
        setLayout( new BorderLayout( ) );
    }
    
	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
    
    /**
     * Metodo que se encarga de actualizar el panel del tablero con la imagen del sudoku que sale por parametro
     * @param pImagen ruta de la imagen que llega por parametro.
     */
    public void actualizar(String pImagen)
    {
        lblImagen.setIcon( new ImageIcon( pImagen ) );
        lblImagen.setHorizontalAlignment( JLabel.CENTER );
        add(lblImagen, BorderLayout.CENTER);
    }
}
