/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_sudoku
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sudoku.mundo;

public class Casilla {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Indica si la casilla es una casilla pista (casilla escogida al comenzar el juego para 
	 * que su número correcto sea visible a lo largo de todo el juego).
	 */
	private boolean pista;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye una casilla. <br>
	 * <b> post: </b> Se creó una casilla que no es una casilla pista. <br>
	 */
	public Casilla( )
	{
		pista = false;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	/**
	 * Indica si la casilla es una casilla pista (casilla escogida al comenzar el juego para 
	 * que su número correcto sea visible a lo largo de todo el juego).
	 * @return true si la casilla es una casilla pista y false de lo contrario.
	 */
	public boolean esPista( )
	{
		return pista;
	}

	/**
	 * Cambia la casilla a una casilla pista.<br>
	 * <b> post: </b> La casilla ahora es una casilla pista. <br> 
	 */
	public void cambiarAPista( )
	{
		pista = true;
	}
}
