/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_sudoku
 * Autor: Diego Useche Reyes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.sudoku.interfaz;

import uniandes.cupi2.sudoku.mundo.Sudoku;
import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Ventana principal de la aplicacion
 */

public class InterfazSudoku extends JFrame 
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Clase principal del mundo.
	 */
	private Sudoku sudoku;
	
	/**
	 *  Atributo que representa el panel Banner
	 */
	
	PanelBanner panelBanner;
	
	/**
	 *  Atributo que representa el panel Informacion
	 */
	
	PanelInformacion panelInformacion;
	
	/**
	 *  Atributo que representa el panel Tablero
	 */
	
	PanelTablero panelTablero;
	
	/**
	 *  Atributo que representa el panel Movimiento
	 */
	
	PanelMovimiento panelMovimiento;
	
	/**
	 *  Atributo que representa el panel Opciones
	 */
	
	PanelOpciones panelOpciones;
	
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Metodo constructor de la ventana principal
	 */
	
	public InterfazSudoku()
	{
		
		sudoku = new Sudoku();
		
		panelBanner = new PanelBanner();
		
		panelInformacion = new PanelInformacion ();
		
		panelTablero = new PanelTablero();
		
		panelMovimiento = new PanelMovimiento(this);
		
		panelOpciones = new PanelOpciones(this);
		
		setLayout(new BorderLayout());
		getContentPane().add(panelBanner, BorderLayout.NORTH);
		getContentPane().add(panelInformacion, BorderLayout.WEST);
		getContentPane().add(panelTablero, BorderLayout.CENTER);
		getContentPane().add(panelMovimiento, BorderLayout.EAST);
		getContentPane().add(panelOpciones, BorderLayout.SOUTH);
				
		
		setTitle("CupiSudoku");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,550);
		setResizable(false);
		setLocationRelativeTo( null );
		
	}
	
	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	
	/**
	 * Actualiza la interfaz con la información del mundo en el panel de informacion y movimiento.
	 */
	
	public void actualizarInformacion()
	{
		panelInformacion.actualizar(sudoku);
		panelMovimiento.actualizar(sudoku);
	}
	
	/**
	 * Actualiza la interfaz del panel del tablero con la imagen del sudoku correspondiente.
	 * @param pImagen ruta de la imagen correspondiente que se va a actualizar en el panel Tablero.
	 */
	
	public void actualizarImagen(String pImagen)
	{
		panelTablero.actualizar(pImagen);
	}
	
	
	/**
	 * Metodo para la opcion cargar.
	 * post: carga en la interfaz nuevo juego de Sudoku.
	 */
	
	public void cargar() 
	{
		try
		{
			String imagen = sudoku.cargar();
			actualizarInformacion();
			actualizarImagen(imagen);
			pack();
			panelOpciones.habilitarBotones();
			panelMovimiento.habilitarBotones();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog( this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
		}
		
		
	}
	
	/**
	 * Metodo para la opcion reiniciar.
	 * post: reiniciar el juego de Sudoku.
	 */
	
	public void reiniciar() 
	{
		String imagen = sudoku.reiniciar();
		actualizarInformacion();
		actualizarImagen(imagen);
	}
	
	/**
	 * Metodo para la opcion validar
	 * post: valida el juego de Sudoku.
	 */
	
	public void validar() 
	{
		String imagen = sudoku.validar();
		actualizarInformacion();
		actualizarImagen(imagen);
	}
	
	/**
	 * Metodo para la opcion solucionar.
	 * post:  muestra la solucion del juego de Sudoku.
	 */
	
	public void solucionar() 
	{
		String imagen = sudoku.solucionar();
		actualizarInformacion();
		actualizarImagen(imagen);
		JOptionPane.showMessageDialog( this, "Has completado satisfactoriamente el Sudoku", "Validar", JOptionPane.INFORMATION_MESSAGE );
		panelOpciones.deshabilitarBotones();
		panelMovimiento.deshabilitarBotones();
	}
	/**
	 * Este metodo se encarga de llamar el metodo mover del modelo mundo
	 */
	public void mover() 
	{
		try
		{
			sudoku.mover();
			actualizarInformacion();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog( this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
		}
	}
	
	/**
	 * Metodo para la opcion ingresar el numero de la casilla del panel Movimiento.
	 */
	
	public void ingresar() 
	{

		String numeroCasilla = JOptionPane.showInputDialog(this, "Ingresar numero en la casilla " + sudoku.darFilaActual() + "," +sudoku.darColumnaActual());
		if (numeroCasilla == null || numeroCasilla =="")
		{}
		else
		{
			try
			{	int numeroCasillaInt = Integer.parseInt(numeroCasilla);
				if(numeroCasillaInt > sudoku.darCantidadColumnasZona()*sudoku.darCantidadFilasZona() || numeroCasillaInt < 1)
				{
					JOptionPane.showMessageDialog( this, "El numero ingresado no es valido. Debe ser un valor entre 1 y " + sudoku.darCantidadColumnasZona()*sudoku.darCantidadFilasZona(), "Error", JOptionPane.ERROR_MESSAGE );
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog( this, "Debe ingresar un valor numerico entre 1 y " + sudoku.darCantidadColumnasZona()*sudoku.darCantidadFilasZona(), "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
	}
	
	/**
	 * Método para la extensión 1.
	 */
	public void reqFuncOpcion1a( )
	{
		String resultado = sudoku.metodo1( );
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Método para la extensión 2.
	 */
	public void reqFuncOpcion2a( )
	{
		String resultado = sudoku.metodo2( );
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}
	
	/**
	 * Este metodo ejecuta la aplicacion creando una nueva interfaz.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		InterfazSudoku interfazSudoku = new InterfazSudoku();
		interfazSudoku.setVisible(true);
	}

}
