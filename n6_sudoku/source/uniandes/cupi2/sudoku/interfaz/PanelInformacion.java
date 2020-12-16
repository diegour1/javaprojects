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

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.sudoku.mundo.Sudoku;

/**
 * Panel con la información del sudoku.
 */

public class PanelInformacion extends JPanel
{
	// -------------------------------------------------------------
    // Atributos de la interfaz
    // -------------------------------------------------------------
	
	/**
     * Etiqueta que muestra el nombre del sudoku.
     */
	private JLabel labNombre;
	
	/**
     * Etiqueta que muestra el numero de pistas del sudoku.
     */
	private JLabel labNumeroPistas;
	
	/**
     * Etiqueta que muestra el numero de casillas en blanco.
     */
	private JLabel labCasillasBlanco;
	
	/**
     * Etiqueta que muestra el numero de movimientos realizados.
     */
	private JLabel labMovimientosRealizados;

	/**
     * Campo de texto para el nombre del sudoku.
     */
	private JTextField txtNombre;
	
	/**
     * Campo de texto para el numero de pistas del sudoku.
     */
	private JTextField txtNumeroPistas;
	
	/**
     * Campo de texto para el numero de casillas en blanco.
     */
	private JTextField txtCasillasBlanco;
	
	/**
     * Campo de texto para el numero de movimientos realizados.
     */
	private JTextField txtMovimientosRealizados;
	
	// -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------
	
	/**
     * Construye un panel de informacion del sudoku.
     */
	
	public PanelInformacion()
	{
		setBorder( new TitledBorder( "Información" ) );
		setLayout( new GridLayout(4, 2, 15, 30 ) );
		
		// Inicializamos los Label y TextField
		
		labNombre = new JLabel("Nombre");
		labNumeroPistas = new JLabel("No. pistas iniciales");
		labCasillasBlanco = new JLabel("Casillas en blanco");
		labMovimientosRealizados = new JLabel("Movimientos realizados");
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNumeroPistas = new JTextField();
		txtNumeroPistas.setEditable(false);
		txtCasillasBlanco = new JTextField();
		txtCasillasBlanco.setEditable(false);
		txtMovimientosRealizados = new JTextField();
		txtMovimientosRealizados.setEditable(false);
		
		// Agregamos en orden los Label y TextField al panel
		
		add(labNombre);
		add(txtNombre);
		add(labNumeroPistas);
		add(txtNumeroPistas);
		add(labCasillasBlanco);
		add(txtCasillasBlanco);
		add(labMovimientosRealizados);
		add(txtMovimientosRealizados);
		
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	
	public void actualizar(Sudoku pSudoku) 
	{
		txtNombre.setText("Sudoku " + pSudoku.darCantidadFilasZona() + "x"  + pSudoku.darCantidadColumnasZona());
		txtNumeroPistas.setText(Integer.toString(pSudoku.contarPistasIniciales()));
		txtCasillasBlanco.setText(Integer.toString(pSudoku.contarCasillasEnBlanco()));
		txtMovimientosRealizados.setText(Integer.toString(pSudoku.darMovimientosRealizados()));
	}

}
