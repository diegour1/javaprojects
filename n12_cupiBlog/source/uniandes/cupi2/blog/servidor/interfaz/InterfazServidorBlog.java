/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_CupiBlog
 * Autor: Diego Useche Reyes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.blog.servidor.interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import uniandes.cupi2.blog.servidor.mundo.ServidorBlog;

/**
 * Ventana principal del servidor del Blog.
 */

public class InterfazServidorBlog extends JFrame
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	* Clase principal del mundo servidor.
	*/
	private ServidorBlog servidorBlog;
			
	/**
	*  Atributo que representa el panel Usuarios Conectados.
	*/
			
	PanelUsuariosConectados panelUsuariosConectados;
			
	/**
	*  Atributo que representa el panel Lista Articulos.
	*/
			
	PanelListaArticulos panelListaArticulos;
			
	/**
	*  Atributo que representa el panel Opciones Servidor
	*/
			
	PanelOpcionesServidor panelOpcionesServidor;
				
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Metodo constructor de la ventana principal del servidor.
	 */
	
	public InterfazServidorBlog()
	{
		
		servidorBlog = new ServidorBlog();
		
		panelUsuariosConectados = new PanelUsuariosConectados(this);
		
		panelListaArticulos = new PanelListaArticulos();
		
		panelOpcionesServidor = new PanelOpcionesServidor (this);
		
		setLayout(new BorderLayout());
		getContentPane().add(panelUsuariosConectados, BorderLayout.WEST);
		getContentPane().add(panelListaArticulos, BorderLayout.CENTER);
		getContentPane().add(panelOpcionesServidor, BorderLayout.SOUTH);		
		
		setTitle("Servidor Blog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550,550);
		setResizable(false);
		setLocationRelativeTo( null );
		
	}
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------	

	/**
	 * Metodo encargado de actualizar la lista de usuarios conectados en la interfaz servidor.
	 */
	
	public void actualizarUsuarios() 
	{
		
	}

	/**
	 * Método para la extensión 1.
	 */
	
	public void reqFuncOpcion1a() 
	{
		String resultado = servidorBlog.metodo1();
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Método para la extensión 2.
	 */
	
	public void reqFuncOpcion2a() 
	{
		String resultado = servidorBlog.metodo2();
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );		
	}

	public void actualizar() {
		// TODO Auto-generated method stub
		
	}		
		
}