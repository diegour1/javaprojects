/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_sudoku
 * Autor: Diego Useche 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sudoku.mundo;

public class Casilla {
	
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante que indica que la casillaUsuario esta aun vacia. 
	 */
	
	public static final String NUMERO_VACIO = "";
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * String que indica el numero correcto que corresponde a la casilla asignada
	 */
	
	private String numeroSolucion;
	
	/**
	 * String que indica el numero que asigno el usuario a la casilla puede ser "". 
	 */
	
	private String numeroUsuario;
	
	
	/**
	 * Indica si la casilla es una casilla pista (casilla escogida al comenzar el juego para 
	 * que su número correcto sea visible a lo largo de todo el juego).
	 */

	private boolean pista;
	
	/**
	 * Indica si el numeroUsuario es igual al numeroSolucion, true si numeroUsuario=numeroSolucion false de lo contrario. 
	 */
	
	private boolean validarNumero;
	

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye una casilla. Se inicializa validarNumero de acuerdo a la condicion de validarNumero <br>
	 * @param pNumeroSolucion numero correcto de la casilla que llega por parametro. pNumeroSolucion!=null && pNumeroSolucion!=null.
	 * @param pNumeroUsuario numero que asigna el usuario a la casilla. pNumeroUsuario!=null.
	 * <b> post: </b> Se creó una casilla que no es una casilla pista. <br>
	 */
	public Casilla( String pNumeroSolucion, String pNumeroUsuario )
	{
		pista = false;
		numeroSolucion = pNumeroSolucion;
		numeroUsuario = pNumeroUsuario;
		validarNumero = (numeroSolucion.equals(numeroUsuario))?true:false;
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
	 * Retorna el string del numeroSolucion correcto que corresponde a esa casilla.
	 * @return el numero que corresponde a esa casilla.
	 */
	
	public String darNumeroSolucion()
	{
		return numeroSolucion;
	}
	
	/**
	 * Retorna el numero que asigna el usuario a esa casilla, String vacio "", si el usuario no ha asignado a la casilla.
	 * @return el numero que corresponde a esa casilla, "" si ningun numero corresponde.
	 */
	
	public String darNumeroUsuario()
	{
		return numeroUsuario;
	}
	
	
	/**
	 * Cambia el numero de la casilla asignada por el usuario por el numero que le llega por parametro.
	 * @param pNumeroUsuario numeroUsuario que le llega por parametro para cambiar el numero de la casilla.
	 * @throws Exception si al intentar cambiar la casilla, la casilla es pista.
	 * <b> post: </b> El numero de la casilla del usuario ha sido cambiado <br> 
	 * 
	 */
	public void cambiarNumeroUsuario(String pNumeroUsuario) throws Exception
	{
		if(esPista())
		{
			throw new Exception("No se puede cambiar el numero porque la casilla es pista");		
		}else
		{
			numeroUsuario = pNumeroUsuario;
		}
	}

	/**
	 * Cambia la casilla a una casilla pista.<br>
	 * <b> post: </b> La casilla ahora es una casilla pista. <br> 
	 */
	public void cambiarAPista( )
	{
		pista = true;
	}
	
	/**
	 * Cambia a true validarNumero si numeroUsuario=numeroSolucion, false de lo contrario 
	 * validacion de la casilla, si el numeroSolucion es igual al numeroUsuario
	 */
	public void verificarValidarNumero( )
	{
		if(numeroUsuario.equals(numeroSolucion))
		{
			validarNumero = true;
		}else{
			validarNumero = false;
		}
	}
	
	/**
	 * Retorna el boolean de la validacion de la casilla, si el numeroSolucion es igual al numeroUsuario
	 * @return boolean , true si el numeroUsuario es igual al numeroSolucion false de lo contrario,
	 */
	public boolean darValidarNumero( )
	{
		return validarNumero;
	}
}
