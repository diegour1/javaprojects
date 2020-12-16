package uniandes.cupi2.blog.servidor.mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

import uniandes.cupi2.blog.cliente.mundo.*;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id:
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_CupiBlog
 * Autor: Diego Useche Reyes - 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

/**
 * Es la clase que se va encargar de mantener el estado del usuario y enviar los mensajes al usuario.
 * socket != null. <br>
 * in != null. <br>
 * out != null. <br>
 */

public class ManejadorComunicadorUsuario extends Thread
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el separador de un comando.
     */
    public static final String SEPARADOR_COMANDO = ";;;";
    
    /**
     * Constante que representa el separador de los parámetros.
     */
    public static final String SEPARADOR_PARAMETROS = ":::";

    /**
     * Constante que representa el mensaje LOGIN para que un usuario ingrese al sistema.
     */
    public static final String LOGIN = "LOGIN";

    /**
     * Constante que representa el mensaje REGISTRAR, para que un usuario se registre en el sistema.
     */
    public static final String REGISTRAR = "REGISTRAR";
    
    /**
     * Constante que representa el mensaje REGISTRADO, para indicar que un usuario fue registrado en el sistema.
     */
    public static final String REGISTRADO = "REGISTRADO";
    
    /**
     * Constante que representa el mensaje LISTA_ARTICULOS, para iniciar el envío de la información de los artículos.
     */
    public static final String LISTA_ARTICULOS = "LISTA_ARTICULOS";

    /**
     * Constante que representa el mensaje ARTICULOS, para indicar de cuantos artículos se está enviando información.
     */
    public static final String ARTICULOS = "ARTICULOS";

    /**
     * Constante que representa el mensaje ARTICULO, para notificar el envío de la información de un artículo.
     */
    public static final String ARTICULO = "ARTICULO";

    /**
     * Constante que representa el mensaje PUBLICAR_ARTICULO, para publicar un artículo.
     */
    public static final String PUBLICAR_ARTICULO = "PUBLICAR_ARTICULO";
    
    /**
     * Constante que representa el mensaje CALIFICAR, para enviar la calificación de un artículo.
     */
    public static final String CALIFICAR = "CALIFICAR";

    /**
     * Constante que representa el mensaje ESTADISTICAS, para solicitar las estadísticas del promedio de las calificaciones de los artículos de un usuario.
     */
    public static final String ESTADISTICAS = "ESTADISTICAS";
    
    /**
     * Constante que representa el mensaje BUSQUEDA_CATEGORIA, para solicitar la búsqueda de los artículos de una categoría.
     */
    public static final String BUSQUEDA_CATEGORIA = "BUSQUEDA_CATEGORIA";

    /**
     * Constante que representa el mensaje LOGOUT, para notificar el cierre de sesión de un usuario.
     */
    public static final String LOGOUT = "LOGOUT";
    
    /**
     * Constante que representa el mensaje ERROR, que se utiliza en para notificar un error en cualquiera de las peticiones.
     */
    public static final String ERROR = "ERROR";
    
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
	/**
     * Es el servidor en el que se encuentra este manejador
     */
	private ServidorBlog servidor;
	
    /**
     * Referencia al objeto que permite el acceso a la base de datos
     */
	private AdministradorBlog admonBlog;
	
    /**
     * Usuario al que está asociado este manejador
     */
	private Usuario usuario;
	
	/**
	 * Direccion IP del usuario
	 */
	private String direccionIp;
	
	/**
	 * El socket que esta conectado al cliente
	 */
	private Socket socketUsuario;
	
	/**
	 * Es el stream para leer los mensajes enviados por el usuario. 
	 */
	private BufferedReader inUsuario;
	
	/**
	 * Es el stream para enviar mensajes al usuario
	 */
	private PrintWriter outUsuario;
	
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	/**
	 * Construye el manejador que se encargara de la comunicacion con un usuario
	 * Al construir el manejador se preparan tambien los streams para la comunicacion con el usuario.
	 * @param pServidorBlog Es el servidor que se encuentra en este manejador - servidorBlog!=null.
	 * @param pSocket Es el socket que esta conectando el usuario - pSocket != null.
	 * @throws IOException Lanza este tipo de excepcion si hay problemas estableciendo la conexion con el usuario. 
	 */
	public ManejadorComunicadorUsuario(ServidorBlog pServidorBlog, Socket pSocket) throws CupiBlogComunicacionException 
	{
		servidor = pServidorBlog;
		admonBlog = servidor.darAdministradorContenido();
		socketUsuario = pSocket;
		try
		{
			inUsuario = new BufferedReader( new InputStreamReader (socketUsuario.getInputStream()));
			outUsuario = new PrintWriter(socketUsuario.getOutputStream(), true);	
		}
		catch(IOException e)
		{
			e.printStackTrace();
			throw new CupiBlogComunicacionException( "No se pueden inicializar los canales de comunicación." );
		}
		verificarInvariante();
	}

    // -----------------------------------------------------------------
    // Métodos de recepción
    // -----------------------------------------------------------------
	
	/**
	 * Metodo encargado de procesar un mensaje proveniente del usuario
	 */
	
	public boolean procesarMensaje() throws CupiBlogComunicacionException, CupiBlogProtocoloException
	{
		try
		{
			boolean logout = false;
			String linea = inUsuario.readLine();
			if( linea == null)
			{
				throw new CupiBlogComunicacionException( "El usuario no se ha podido conectar." );
			}
			
			String [] partes = linea.split(SEPARADOR_COMANDO);
			String comando = partes[0];
			String[] parametros = {""};
			if (partes.length > 1)
			{
				parametros = partes[1].split(SEPARADOR_PARAMETROS);
			}
			
			//El servidor recibe una solicitud de conexion.
			if(comando.equals(LOGIN))
			{
				String login = parametros[0];
				
			}
			
			
			
		}
		catch (IOException e)
		{
            String mensaje = "Error al leer el mensaje del servidor: " + e.getMessage( ) + ".";
            if( e.getMessage( ).equals( "Connection reset" ) )
            {
                mensaje = "Se perdió la conexión con el usuario.";
            }
            throw new CupiBlogComunicacionException( mensaje );	
		}
	}
	/**
     *  @param * @return Retorna la información del jugador
     * @throws BatallaNavalException Se lanza esta excepción si hay problemas consultando a la base de datos o se recibe un mensaje con un formato inesperado
     */
	
	/**
	 * Obtiene la información de un usuario a partir del mensaje que envió cuando entró al blog
	 * @param info El mensaje que fue enviado - info es de la forma "LOGIN;;;<nombreusuario>"
	 * @return Retorna la informacion del jugador
	 * @throws CupiBlogPersistenciaException Lanza una excepcion si hay un problema consultando la base de datos
	 * @throws CupiBlogProtocoloException Lanza una excepcion si recibe el mesj con un formato inesperado.
	 */
	private RegistroUsuario consultarUsuario(String info) throws CupiBlogPersistenciaException, CupiBlogProtocoloException
	{
		String[] info1 = info.split(SEPARADOR_COMANDO);
		if(info1[0].equals(LOGIN))
		{
			String username = info1[0].split(SEPARADOR_PARAMETROS)[0];
			try
			{
				RegistroUsuario reg1 = admonBlog.consultarRegistroUsuario(username); 
				return reg1;
			}
			catch (SQLException e)
			{
				throw new CupiBlogPersistenciaException( "Hubo un problema leyendo la información del jugador: " + e.getMessage( ) );
			}
			
		}
		else
		{
			throw new CupiBlogProtocoloException( "El mensaje no tiene el formato esperado" );
		}
	}

	public Usuario darUsuario() {
		return null;
	}

	public void responderAdios() {	
	}

	public void desconectar() {
		
	}
	
	private void verificarInvariante() 
	{
		
	}


}
