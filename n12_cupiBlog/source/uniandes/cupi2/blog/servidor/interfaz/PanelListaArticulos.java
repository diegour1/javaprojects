package uniandes.cupi2.blog.servidor.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class PanelListaArticulos extends JPanel 
{
	
	// -------------------------------------------------------------
    // Atributos del panel
    // -------------------------------------------------------------
	
	/**
     * JScrollPane donde muestra la lista de usuarios conectados.
     */
	
	private JScrollPane scrollListaArticulos;
	
	// -------------------------------------------------------------
    // Constructor del panel
    // -------------------------------------------------------------	
		

	public PanelListaArticulos()  
	{	
		
		setBorder(new TitledBorder("Lista Articulos"));	
		setLayout(new BorderLayout());
		
		//se inicializa el scroll
		scrollListaArticulos = new JScrollPane();
		scrollListaArticulos.setPreferredSize(new Dimension(300, 500));
		
		//Se agregan los componentes al panel 
		add(scrollListaArticulos, BorderLayout.CENTER);
	}

	// -------------------------------------------------------------
    // Metodos del panel
    // -------------------------------------------------------------	
	
}
