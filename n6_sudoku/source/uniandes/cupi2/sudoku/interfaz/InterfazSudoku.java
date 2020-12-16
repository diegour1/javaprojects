/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_sudoku
 * Autor: Diego Useche Reyes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.sudoku.interfaz;

import uniandes.cupi2.sudoku.mundo.Casilla;
import uniandes.cupi2.sudoku.mundo.Sudoku;
import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
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
		panelTablero.actualizar(sudoku.darCantidadFilasZona(), sudoku.darCantidadColumnasZona(), sudoku.darCasillas());
		panelTablero.moverse(sudoku.darFilaActual(), sudoku.darColumnaActual());
	}
	
	/**
	 * Metodo para la opcion cargar.
	 * post: carga en la interfaz nuevo juego de Sudoku.
	 */
	
	public void cargar() 
	{
		try
		{
			//Se crea la ventana para escoger el archivo
			JFileChooser fc = new JFileChooser("./data");
			//JFileChooser fc = new JFileChooser(getClass().getClassLoader());
			fc.setDialogTitle("Abrir archivo de Sudoku");
			
			//Se selecciona el archivo de la ventana
			File archivoSudoku = null;
			int resultado = fc.showOpenDialog(this);
			if(resultado == JFileChooser.CANCEL_OPTION)
			{
				//Si selecciona la opcion cancelar el usuario, el JFileChooser no hace nada y se cierra.
			}
			else if(resultado == JFileChooser.APPROVE_OPTION)
			{
				//se carga el sudoku con el archivo seleccionado 
				archivoSudoku = fc.getSelectedFile();
				sudoku.cargar(archivoSudoku);
				actualizarInformacion();
				//pack();
				panelOpciones.habilitarBotones();
				panelMovimiento.habilitarBotones();
			}
				
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog( this, "Formato del archivo incorrecto", "Error", JOptionPane.ERROR_MESSAGE );
		}
		
		
	}
	
	/**
	 * Metodo para la opcion reiniciar.
	 * post: reiniciar el juego de Sudoku.
	 */
	
	public void reiniciar() 
	{
		sudoku.reiniciar();
		actualizarInformacion();
		panelOpciones.habilitarBotones();
		panelMovimiento.habilitarBotones();
	}
	
	/**
	 * Metodo para la opcion validar
	 * post: valida el juego de Sudoku.
	 */
	
	public void validar() 
	{
		if(sudoku.validar())
		{
			panelTablero.mostrarSolucion();
			JOptionPane.showMessageDialog( this, "Has completado satisfactoriamente el Sudoku", "Validar", JOptionPane.INFORMATION_MESSAGE );	
		}else
		{
			panelTablero.mostrarValidacion(sudoku.darCasillas());
		}
	}
	
	/**
	 * Metodo para la opcion solucionar.
	 * post:  muestra la solucion del juego de Sudoku.
	 */
	
	public void solucionar() 
	{
		sudoku.solucionar();
		actualizarInformacion();
		panelTablero.mostrarSolucion();
		JOptionPane.showMessageDialog( this, "Has completado satisfactoriamente el Sudoku", "Validar", JOptionPane.INFORMATION_MESSAGE );
		panelOpciones.deshabilitarBotones();
		panelMovimiento.deshabilitarBotones();
	}
	/**
	 * Este metodo se encarga de llamar el metodo mover del modelo mundo
	 */
	public void mover(String pTipoMovimiento) 
	{
		try
		{
			sudoku.mover(pTipoMovimiento);
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
		if(sudoku.darCasillaActual().esPista())
		{
			JOptionPane.showMessageDialog( this, "La casilla actual es una casilla pista", "Error", JOptionPane.ERROR_MESSAGE );
		}
		else
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
					}else
					{
						 sudoku.darCasillaActual().cambiarNumeroUsuario(Integer.toString(numeroCasillaInt));
						 sudoku.darCasillaActual().verificarValidarNumero();
						 sudoku.aumentarMovimientosRealizados();
						 actualizarInformacion();
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog( this, "Debe ingresar un valor numerico entre 1 y " + sudoku.darCantidadColumnasZona()*sudoku.darCantidadFilasZona(), "Error", JOptionPane.ERROR_MESSAGE );
				}

			}
		}
	}
	
	/**
	 * Metodo que se encarga de borrar el valor del numero del usuario
	 * Si el numero del usuario es vacio no hace nada, de lo contrario lo convierte en una casilla vacia
	 */
	
	public void borrar()
	{
		if(sudoku.darCasillaActual().darNumeroUsuario().equals(Casilla.NUMERO_VACIO))
		{}
		else
		{
			try
			{
				sudoku.darCasillaActual().cambiarNumeroUsuario(Casilla.NUMERO_VACIO);
				sudoku.aumentarMovimientosRealizados();
				actualizarInformacion();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog( this, "No se puede borrar porque es una casilla pista", "Error", JOptionPane.ERROR_MESSAGE );
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
