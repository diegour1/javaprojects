/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_sudoku
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sudoku.mundo;

import java.util.Random;

/**
 * Juego de Sudoku.
 */
public class Sudoku {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	/**
	 * Cantidad de filas que hay en una zona.
	 */
	private int cantidadFilasZona;
	
	/**
	 * Cantidad de columnas que hay en una zona.
	 */
	private int cantidadColumnasZona;
	
	/**
	 * Fila actual que se encuentra seleccionada.
	 */
	private int filaActual;
	
	/**
	 * Columna actual que se encuentra seleccionada.
	 */
	private int columnaActual;


    // ----------------------------------------------------------------
    // Constructor
    // ----------------------------------------------------------------

    /**
     * Crea un nuevo juego de sudoku. <br>
     * <b>post: </b> Se inicializaron los atributos cantidadFilaZona y cantidadColumnasZona con valores aleatorios entre 2 y 4. La fila actual y la columna actual se inicializaron en 0.
     */
	public Sudoku(){
		cantidadColumnasZona = generarNumeroAleatorio(2, 4);
		cantidadFilasZona = generarNumeroAleatorio(2, 4);
		filaActual = 0 ;
		columnaActual = 0;
	}


    // ----------------------------------------------------------------
    // M�todos
    // ----------------------------------------------------------------

    /**
     * Retorna la cantidad de filas que hay por zona.
     * @return Cantidad de filas por zona.
     */
	public int darCantidadFilasZona(){
		return cantidadFilasZona;
	}

    /**
     * Retorna la cantidad de columnas que hay por zona.
     * @return Cantidad de columnas por zona.
     */
	public int darCantidadColumnasZona(){
		return cantidadColumnasZona;
	}

	/**
	 * Retorna la fila actualmente seleccionada.
	 * @return Fila actualmente seleccionada.
	 */
	public int darFilaActual(){
		return filaActual;
	}

	/**
	 * Retorna la columna actualmente seleccionada.
	 * @return Columna actualmente seleccionada.
	 */
	public int darColumnaActual(){
		return columnaActual;
	}

	/**
	 * Retorna la casilla actual.
	 * @return Casilla aleatoria.
	 */
	public Casilla darCasillaActual(){
		Casilla casilla = new Casilla();
		int aleatorio = generarNumeroAleatorio(0, 2);
		if(aleatorio == 1){
			casilla.cambiarAPista();
		}
		return casilla;
	}

	/**
	 * Cambia los valores de los atributos por n�meros aleatorios.
	 * <b>post:</b> Se cambiaron los atributos cantidadFilaZona y cantidadColumnasZona con valores aleatorios entre 2 y 4. La fila actual y la columna actual se reiniciaron en 0.
	 * @return Ruta de la imagen del sudoku cargado.
	 * @throws Exception Si un n�mero aleatoriamente generado entre 0 y 10 es igual a 5.
	 */
	public String cargar( ) throws Exception
	{
		int aleatorio = generarNumeroAleatorio(0, 10);
		if(aleatorio==5){
			throw new Exception("Formato inv�lido.");
		}
		cantidadColumnasZona = generarNumeroAleatorio(2, 4);
		cantidadFilasZona = generarNumeroAleatorio(2, 4);
		return reiniciar();
	}


	/**
	 * Cambia la fila actual y la columna actual por valores aleatorios.
	 * <b>post:</b>Se gener� un nuevo valor para la fila actual y la columna actual.
	 * @throws Exception Si un n�mero aleatoriamente generado entre 0 y 10 es igual a 5.
	 */
	public void mover() throws Exception{
		int aleatorio = generarNumeroAleatorio(0, 10);
		if(aleatorio==5){
			throw new Exception("No te puedes mover en esa direcci�n.");
		}

		filaActual = generarNumeroAleatorio(0, cantidadFilasZona*cantidadFilasZona);
		columnaActual = generarNumeroAleatorio(0, cantidadColumnasZona*cantidadColumnasZona);
	}

	/**
	 * Reinicia a 0 los valores de filaActual y columnaActual.
	 * <b>post:</b>La fila actual y la columna actual se reiniciaron en 0.
	 * @return Ruta de la imagen del sudoku actualmente cargado.
	 */
	public String reiniciar(){
		filaActual = 0;
		columnaActual = 0;
		return "./data/imagenes/sudoku"+cantidadColumnasZona+"x"+cantidadFilasZona+".png";
	}

	/**
	 * Retorna la ruta a la imagen del sudoku solucionado.
	 * @return Ruta de la imagen del sudoku solucionado.
	 */
	public String solucionar(){
		return "./data/imagenes/sudoku"+cantidadColumnasZona+"x"+cantidadFilasZona+"-solucionado.png";
	}

	/**
	 * Retorna la ruta de la imagen del sudoku validado.
	 * @return Ruta de la imagen del sudoku validado.
	 */
	public String validar( )
    {
		int aleatorio = generarNumeroAleatorio(0, 2);
		if(aleatorio == 1){
			return "./data/imagenes/sudoku"+cantidadColumnasZona+"x"+cantidadFilasZona+".png";
		}
		return "./data/imagenes/sudoku"+cantidadColumnasZona+"x"+cantidadFilasZona+"-invalido.png";
    }

	/**
	 * Retorna un n�mero aleatorio entre 0 y el total de casillas del tablero.
	 * @return N�mero aleatorio entre 0 y el total de casillas del tablero.
	 */
	public int contarCasillasEnBlanco() {
		return generarNumeroAleatorio(0, cantidadColumnasZona*cantidadFilasZona*cantidadColumnasZona*cantidadFilasZona +1);
	}
	
	/**
	 * Retorna un n�mero aleatorio entre 0 y el total de casillas del tablero.
	 * @return N�mero aleatorio entre 0 y el total de casillas del tablero.
	 */
	public int contarPistasIniciales() {
		return generarNumeroAleatorio(0, cantidadColumnasZona*cantidadFilasZona*cantidadColumnasZona*cantidadFilasZona +1);
	}

	/**
	 * Retorna un n�mero aleatorio entre 0 y el total de casillas del tablero*2.
	 * @return N�mero aleatorio entre 0 y el total de casillas del tablero*2.
	 */
    public int darMovimientosRealizados() {
		return generarNumeroAleatorio(0, cantidadColumnasZona*cantidadFilasZona*cantidadColumnasZona*cantidadFilasZona*2 +1);
	}


	/**
     * Genera un n�mero entero aleatorio entre pLimiteInferior y pLimiteSuperior - 1
     * @param pLimiteInferior L�mite inferior para el cual se va a generar el n�mero aleatorio. 
     * @param pLimiteSuperior L�mite superior para el cual se va a generar el n�mero aleatorio.
     * @return N�mero entero entre pLimiteInferior y pLimiteSuperior - 1
     */
    private int generarNumeroAleatorio( int pLimiteInferior, int pLimiteSuperior )
    {
        return new Random().nextInt(pLimiteSuperior-pLimiteInferior) + pLimiteInferior;
    }

    /**
     * M�todo para la extensi�n 1.
     * @return respuesta1.
     */
    public String metodo1( )

    {
        return "Respuesta 1.";
    }

    /**
     * M�todo para la extensi�n2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

    
}
