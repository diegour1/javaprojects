/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_sudoku
 * Autor: Equipo Cupi2 2019, Diego Useche
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sudoku.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import uniandes.cupi2.sudoku.interfaz.PanelMovimiento;


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
	
	/**
	 * int que registra el numero de movimientos realizados
	 */
	private int movimientosRealizados;
	
	/**
	 * Arreglo 2D de casillas del sudoku.
	 */
	private Casilla[][] casillas;


    // ----------------------------------------------------------------
    // Constructor
    // ----------------------------------------------------------------

    /**
     * Crea un nuevo juego de sudoku. <br>
     * <b>post: </b> Se inicializaron los atributos cantidadFilaZona y cantidadColumnasZona con valores aleatorios entre 2 y 4. La fila actual y la columna actual se inicializaron en 0.
     */
	public Sudoku()
	{
		cantidadColumnasZona = generarNumeroAleatorio(2, 4);
		cantidadFilasZona = generarNumeroAleatorio(2, 4);
		filaActual = 0;
		columnaActual = 0;
		movimientosRealizados = 0;
		casillas = new Casilla[cantidadColumnasZona*cantidadFilasZona][cantidadColumnasZona*cantidadFilasZona];
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
	 * @return Casilla con filaActual y columnaActual dadas.
	 */
	public Casilla darCasillaActual()
	{
		return casillas[filaActual][columnaActual];
	}
	
	/**
	 * Retorna el arreglo de casillas.
	 * @return casillas , el cual es el arreglo de casillas del sudoku.
	 */
	public Casilla[][] darCasillas()
	{
		return casillas;
	}

	/**
	 * Retorna el tamanio del sudoku
	 * @return un entero que representa el tamanio del sudoku, o numero de filas y columnas totales.
	 */
	public int darTamanioSudoku()
	{
		return cantidadColumnasZona*cantidadFilasZona;
	}
	
	/**
	 * A partir de un archivo carga las propiedades del juego de sudoku.
	 * <b>post:</b> Las propiedades del juego de Sudoku han sido cargadas.
	 * @param arch el archivo del cual se carga la info del sudoku. 
	 * @return Las propiedades del juego de sudoku cargado.
	 * @throws Exception Si el formato del juego de Sudoku cargado no cumple con el formato de archivo esperado.
	 */
	public Properties cargarInfoSudoku( File arch ) throws Exception
	{
		Properties datos = new Properties();
		FileInputStream in = new FileInputStream(arch);
		try
		{
			datos.load(in);
			in.close();
		}
		catch(Exception e)
		{
			throw new Exception("Formato invalido");
		}
		return datos;
	}
	
	/**
	 * A partir de un archivo, carga las propiedades del archivo, y a partir de las propiedades crea un nuevo juego de Sudoku con us atributos.
	 * <b>post:</b> Se cambiaron los atributos cantidadFilaZona y cantidadColumnasZona con los valores del archivo. La fila actual, la columna actual y los movimientos realizados se reiniciaron en 0.
	 * <b>post:</b> Se inicializaron las casillas del sudoku tomando la parte de entera de (cantidadFilaZona*cantidadColumnasZona)/3 como casillas pistas en cada zona.
	 * <b>post:</b> Cada casilla se inicializa con su numeroSolucion, el numeroUsuario se inicializa igual al numeroSolucion si es pista, si no es el numero usuario se inicializa en "".
	 * @param arch archivo del cual se carga el sudoku.
	 * @throws Exception Si el archivo no tiene el formato esperado. 
	 */
	public void cargar( File arch ) throws Exception
	{
		Properties pDatos = cargarInfoSudoku( arch );
		cantidadFilasZona = Integer.parseInt(pDatos.getProperty("sudoku.M"));
		cantidadColumnasZona = Integer.parseInt(pDatos.getProperty("sudoku.N"));
		columnaActual = 0;
		filaActual = 0;
		movimientosRealizados = 0;
		casillas = new Casilla[cantidadFilasZona*cantidadColumnasZona][cantidadFilasZona*cantidadColumnasZona];
		
		for(int i=0; i<cantidadFilasZona*cantidadColumnasZona;i++){
			String filai = pDatos.getProperty("sudoku.fila"+(i+1));
			for(int j=0; j<cantidadFilasZona*cantidadColumnasZona;j++){
				String numeroCasillaIJ = filai.substring(j,j+1);
				casillas[i][j] = new Casilla(numeroCasillaIJ,Casilla.NUMERO_VACIO);
			}
		}
		
		
		for(int i = 0; i< cantidadColumnasZona; i++)
		{
			for(int j = 0; j < cantidadFilasZona;j++)
			{
				try
				{
					if(cantidadColumnasZona*cantidadFilasZona==4)
					{
						int casillaPistaFila = generarNumeroAleatorio(i*cantidadFilasZona, (i+1)*(cantidadFilasZona));
						int casillaPistaColumna = generarNumeroAleatorio(j*cantidadColumnasZona, (j+1)*(cantidadColumnasZona));
						String filapistai = pDatos.getProperty("sudoku.fila"+(casillaPistaFila+1));
						String numeroCasillaPistaIJ = filapistai.substring(casillaPistaColumna, casillaPistaColumna+1 );						
						casillas[casillaPistaFila][casillaPistaColumna].cambiarNumeroUsuario(numeroCasillaPistaIJ);
						casillas[casillaPistaFila][casillaPistaColumna].verificarValidarNumero();
						casillas[casillaPistaFila][casillaPistaColumna].cambiarAPista();
					}
					else
					{
						int k = 0;
						while(k < Math.min(cantidadColumnasZona, cantidadFilasZona))
						{
							int casillaPistaFila = generarNumeroAleatorio(i*cantidadFilasZona, (i+1)*(cantidadFilasZona));
							int casillaPistaColumna = generarNumeroAleatorio(j*cantidadColumnasZona, (j+1)*(cantidadColumnasZona));
							String filapistai = pDatos.getProperty("sudoku.fila"+(casillaPistaFila+1));
							String numeroCasillaPistaIJ = filapistai.substring(casillaPistaColumna, casillaPistaColumna+1 );
							if(casillas[casillaPistaFila][casillaPistaColumna].darNumeroUsuario().equals(Casilla.NUMERO_VACIO))
							{
								casillas[casillaPistaFila][casillaPistaColumna].cambiarNumeroUsuario(numeroCasillaPistaIJ); 
								casillas[casillaPistaFila][casillaPistaColumna].cambiarAPista();
								casillas[casillaPistaFila][casillaPistaColumna].verificarValidarNumero();
								k++;
							}
						}
					}
				}
				catch(Exception e)
				{
					throw new Exception("Error de formato");
				}
				
			}
		}
	}


	/**
	 * Cambia la fila actual y la columna actual de acuerdo al tipoDeMovimiento asignado desde la interfaz.
	 * <b>post:</b>Se generó un nuevo valor para la fila actual y la columna actual.
	 * @param String con el tipo de movimiento que asigna el usuario desde la interfaz.
	 * @throws Exception Si el movimiento esperado se sale del tablero de sudoku. 
	 */
	public void mover(String pTipoMovimiento) throws Exception{
		
		if (pTipoMovimiento.equals(PanelMovimiento.IZQ_ARR))
			if(filaActual==0 || columnaActual==0){
				throw new Exception("No te puedes mover en esa dirección.");
			}else{
				filaActual--;
				columnaActual--;
			}	
		else if(pTipoMovimiento.equals(PanelMovimiento.ARR))
			if(filaActual==0){
				throw new Exception("No te puedes mover en esa dirección.");
			}else{
				filaActual--;
			}	
		else if(pTipoMovimiento.equals(PanelMovimiento.DER_ARR))
			if(filaActual==0 || columnaActual==darTamanioSudoku()-1){
				throw new Exception("No te puedes mover en esa dirección.");
			}else{
				filaActual--;
				columnaActual++;
			}	
		else if(pTipoMovimiento.equals(PanelMovimiento.DER))
			if(columnaActual==darTamanioSudoku()-1){
				throw new Exception("No te puedes mover en esa dirección.");
			}else{
				columnaActual++;
			}	
		else if(pTipoMovimiento.equals(PanelMovimiento.IZQ))
			if(columnaActual==0){
				throw new Exception("No te puedes mover en esa dirección.");
			}else{
				columnaActual--;
			}	
		else if(pTipoMovimiento.equals(PanelMovimiento.IZQ_ABA))
			if(filaActual==darTamanioSudoku()-1 || columnaActual==0){
				throw new Exception("No te puedes mover en esa dirección.");
			}else{
				filaActual++;
				columnaActual--;
			}		
		else if(pTipoMovimiento.equals(PanelMovimiento.ABA))
			if(filaActual==darTamanioSudoku()-1){
				throw new Exception("No te puedes mover en esa dirección.");
			}else{
				filaActual++;
			}	
		else if(pTipoMovimiento.equals(PanelMovimiento.DER_ABA))
			if(filaActual==darTamanioSudoku()-1 || columnaActual==darTamanioSudoku()-1){
				throw new Exception("No te puedes mover en esa dirección.");
			}else{
				filaActual++;
				columnaActual++;
			}		
		}

	/**
	 * Reinicia a 0 los valores de filaActual y columnaActual.
	 * Reinicia en "" el numeroUsuario de las casillas que no son pista, lo cual reinicia el tablero cargado anteriormente.
	 * <b>pre:</b> Un juego de Sudoku ha sido cargado.
	 * <b>post:</b>La fila actual y la columna actual se reiniciaron en 0, y el numero usuario de las casillas que no son pista.
	 */
	
	public void reiniciar(){
		filaActual = 0;
		columnaActual = 0;
		movimientosRealizados = 0;
		for(int i=0; i<darTamanioSudoku();i++){
			for(int j=0; j<darTamanioSudoku();j++){
				try
				{
					casillas[i][j].cambiarNumeroUsuario(Casilla.NUMERO_VACIO);
				}
				catch (Exception e)
				{
					//La exception aparece por casillas pista, a las cuales no se les hace nada.					
				}
			}
		}	
	}

	/**
	 * 
	 * Soluciona el sudoku al usuario, al cambiar el numero usuario por el numero solucion en todas las casillas.
	 * <b>pre:</b> Un juego de sudoku ha sido cargado.
	 */
	public void solucionar(){
		for(int i=0; i<darTamanioSudoku();i++){
			for(int j=0; j<darTamanioSudoku();j++){
				try
				{
					casillas[i][j].cambiarNumeroUsuario(casillas[i][j].darNumeroSolucion());
				}
				catch (Exception e)
				{
					//La exception aparece por casillas pista, a las cuales no se les hace nada.
				}
			}
		}	
	}

	/**
	 * Valida si el juego de Sudoku esta resuelto.
	 * Retorna true si los numeroUsuario son iguales a numeroSolucion en todas las casillas false de lo contrario
	 * @return boolean de validacion de todo el sudoku. 
	 */
	public boolean validar( )
    {
		for(int i=0; i<darTamanioSudoku();i++){
			for(int j=0; j<darTamanioSudoku();j++){
				if(!casillas[i][j].darValidarNumero())
				{
					return false;
				}
			}
		}
		return true;
    }

	/**
	 * Retorna un número total de casillas en blanco del tablero, casillas con numero usuario = "".
	 * @return el total de casillas en blanco del tablero.
	 */
	public int contarCasillasEnBlanco() {
		int numeroCasillasEnBlanco = 0;
		for(int i=0; i<darTamanioSudoku();i++){
			for(int j=0; j<darTamanioSudoku();j++){
				if(casillas[i][j].darNumeroUsuario().equals(Casilla.NUMERO_VACIO))
					{
						numeroCasillasEnBlanco++;
					}
				}
			}
		return numeroCasillasEnBlanco;
	}
	
	/**
	 * Retorna el numero de pistas iniciales del tablero de sudoku.
	 * @return el total de casillas pista del tablero.
	 */
	public int contarPistasIniciales() {
		return (int) Math.floor(darTamanioSudoku()/3)*darTamanioSudoku();
	}

	/**
	 * Aumenta el numero de movimientos realizados por el usuario en uno.
	 */
    public void aumentarMovimientosRealizados() {
		movimientosRealizados++;
	}
	
	
	/**
	 * Retorna un número de movimientos realizados por el usuario. 
	 * @return Numero de movimientos del juego de sudoku.
	 */
    public int darMovimientosRealizados() {
		return movimientosRealizados;
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
