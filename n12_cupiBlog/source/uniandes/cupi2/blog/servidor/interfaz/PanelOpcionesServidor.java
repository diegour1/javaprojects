package uniandes.cupi2.blog.servidor.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOpcionesServidor extends JPanel implements ActionListener
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	
	/**
	 * Comando para la opción 1.
	 */
	public final static String OPCION_1 = "OPCION_1";
	
	/**
	 * Comando para la opción 1.
	 */
	public final static String OPCION_2 = "OPCION_2";
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	/**
	 * Botón opción 1. 
	 */
	private JButton btnExt1;
	/**
	 * Botón opción 2. 
	 */
	private JButton btnExt2;
	
	/**
	 * Ventana principal de la aplicación
	 */
	private InterfazServidorBlog principal;
	
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	
	/**
	 * Construye el panel con las opciones del sudoku
	 * @param interfazSudoku Ventana principal de la aplicación.
	 */
	
	public PanelOpcionesServidor(InterfazServidorBlog interfazServidor) 
	{
		principal = interfazServidor;
		
		setBorder( new TitledBorder( "Opciones" ) );
		
		// Creamos los botones
		
		btnExt1 = new JButton("Opción 1");
		btnExt1.setActionCommand(OPCION_1);
		btnExt1.addActionListener(this);
		
		btnExt2 = new JButton("Opción 2");
		btnExt2.setActionCommand(OPCION_2);
		btnExt2.addActionListener(this);
		
		// Creamos el layout y agregamos los botones
		
		setLayout( new GridLayout(1, 2) );
		add(btnExt1);
		add(btnExt2);
	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	
    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento!=null.
     */
    
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		if(comando.equals(OPCION_1))
			principal.reqFuncOpcion1a();
		else if(comando.equals(OPCION_2))
			principal.reqFuncOpcion2a();	
	}
}
