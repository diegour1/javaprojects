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
    // Métodos
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
	 * Cambia los valores de los atributos por números aleatorios.
	 * <b>post:</b> Se cambiaron los atributos cantidadFilaZona y cantidadColumnasZona con valores aleatorios entre 2 y 4. La fila actual y la columna actual se reiniciaron en 0.
	 * @return Ruta de la imagen del sudoku cargado.
	 * @throws Exception Si un número aleatoriamente generado entre 0 y 10 es igual a 5.
	 */
	public String cargar( ) throws Exception
	{
		int aleatorio = generarNumeroAleatorio(0, 10);
		if(aleatorio==5){
			throw new Exception("Formato inválido.");
		}
		cantidadColumnasZona = generarNumeroAleatorio(2, 4);
		cantidadFilasZona = generarNumeroAleatorio(2, 4);
		return reiniciar();
	}


	/**
	 * Cambia la fila actual y la columna actual por valores aleatorios.
	 * <b>post:</b>Se generó un nuevo valor para la fila actual y la columna actual.
	 * @throws Exception Si un número aleatoriamente generado entre 0 y 10 es igual a 5.
	 */
	public void mover() throws Exception{
		int aleatorio = generarNumeroAleatorio(0, 10);
		if(aleatorio==5){
			throw new Exception("No te puedes mover en esa dirección.");
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
	 * Retorna un número aleatorio entre 0 y el total de casillas del tablero.
	 * @return Número aleatorio entre 0 y el total de casillas del tablero.
	 */
	public int contarCasillasEnBlanco() {
		return generarNumeroAleatorio(0, cantidadColumnasZona*cantidadFilasZona*cantidadColumnasZona*cantidadFilasZona +1);
	}
	
	/**
	 * Retorna un número aleatorio entre 0 y el total de casillas del tablero.
	 * @return Número aleatorio entre 0 y el total de casillas del tablero.
	 */
	public int contarPistasIniciales() {
		return generarNumeroAleatorio(0, cantidadColumnasZona*cantidadFilasZona*cantidadColumnasZona*cantidadFilasZona +1);
	}

	/**
	 * Retorna un número aleatorio entre 0 y el total de casillas del tablero*2.
	 * @return Número aleatorio entre 0 y el total de casillas del tablero*2.
	 */
    public int darMovimientosRealizados() {
		return generarNumeroAleatorio(0, cantidadColumnasZona*cantidadFilasZona*cantidadColumnasZona*cantidadFilasZona*2 +1);
	}


	/**
     * Genera un número entero aleatorio entre pLimiteInferior y pLimiteSuperior - 1
     * @param pLimiteInferior Límite inferior para el cual se va a generar el número aleatorio. 
     * @param pLimiteSuperior Límite superior para el cual se va a generar el número aleatorio.
     * @return Número entero entre pLimiteInferior y pLimiteSuperior - 1
     */
    private int generarNumeroAleatorio( int pLimiteInferior, int pLimiteSuperior )
    {
        return new Random().nextInt(pLimiteSuperior-pLimiteInferior) + pLimiteInferior;
    }

    /**
     * Método para la extensión 1.
     * @return respuesta1.
     */
    public String metodo1( )

    {
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

    
}
