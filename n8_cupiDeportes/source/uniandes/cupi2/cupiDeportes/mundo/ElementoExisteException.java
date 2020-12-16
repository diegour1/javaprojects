package uniandes.cupi2.cupiDeportes.mundo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ElementoExisteException extends Exception {
	
	//Constantes
	
	public static final String DEPORTE_REPETIDO = "Deporte";
	public static final String DEPORTISTA_REPETIDO = "Deportista";
	private static final String LOG_FILE = "./data/error.log";
	
	//Atributos
	
	private String tipoElementoRepetido;
	private String nombreElementoRepetido;
	
	//Constructor

	public ElementoExisteException (String pTipoElementoRepetido, String pNombreElementoRepetido)
	{
		super("El " + pTipoElementoRepetido + pNombreElementoRepetido + " esta repetido");
		registrarError();
		tipoElementoRepetido = pTipoElementoRepetido;
		nombreElementoRepetido = pNombreElementoRepetido;
	}
	
	//Metodos 
	
	public void registrarError()
	{
		try
		{
			FileWriter out = new FileWriter(LOG_FILE, true);
			PrintWriter log = new PrintWriter( out );
			log.println("----------------------------------------------------------");
			log.println("CupiDeportes.java:" + new Date().toString() );
			log.println("----------------------------------------------------------");
			printStackTrace(log);
			log.close();
			out.close();
		}
		catch (IOException e)
		{
			printStackTrace();
			e.printStackTrace();
		}
	}

}
