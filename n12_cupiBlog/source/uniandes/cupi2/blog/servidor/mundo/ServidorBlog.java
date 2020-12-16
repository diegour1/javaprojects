/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_CupiBlog
 * Autor: Equipo Cupi2 2019, Diego Useche Reyes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.blog.servidor.mundo;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

import uniandes.cupi2.blog.servidor.interfaz.InterfazServidorBlog;

/**
 * El Servidor CupiBlog es el que se encarga de recibir conexiones de los usuarios. <br>
 * <b>inv:</b><br>
 * receptor!= null <br>
 * config!=null <br>
 * adminResultados!=null <br>
 * encuentros!=null <br>
 */

public class ServidorBlog 
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	/**
	 * Es el punto en el cual los usuarios piden conexiones
	 */
	ServerSocket receptor;
	
	/**
     * Es el conjunto de propiedades que contienen la configuración de la aplicación
     */
	Properties config;
	
	
	/**
     * Es el administrador que permite registrar los registros de los usuarios sobre la base de datos
     */	
	AdministradorBlog adminBlog;
	
    /**
     * Es una colección con los usuarios que se están actualmente conectados.
     */
    private Collection usuarios;
    
    /**
     * Interfax principal servidor
     */
    private InterfazServidorBlog principal;
	
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

	ServidorBlog(String archivo, InterfazServidorBlog padre) throws SQLException, Exception 
	{
		principal = padre;
		usuarios = new Vector();
		cargarConfiguracion(archivo);
		adminBlog = new AdministradorBlog(archivo);
		adminBlog.conectarABD();
		adminBlog.inicializarTablas();
		adminBlog.desconectarBD();
		
	}

    // -----------------------------------------------------------------
    // Metodos 
    // -----------------------------------------------------------------
	
	/**
     * Carga la configuración a partir de un archivo de propiedades
     * @param archivo El archivo de propiedades que contiene la configuración que requiere el servidor - archivo != null y el archivo debe contener la propiedad
     *        "servidor.puerto" y las propiedades que requiere el administrador de resultados
     * @throws Exception Se lanza esta excepción si hay problemas cargando el archivo de propiedades
     */
	
	private void cargarConfiguracion(String archivo) throws Exception
	{
		FileInputStream fis = new FileInputStream(archivo);
		config = new Properties();
		config.load(fis);
		fis.close();
	}
	
    /**
     * Retorna al administrador de resultados
     * @return adminResultados;
     */
	
	public AdministradorBlog darAdministradorContenido()
	{
		return adminBlog;
	}
    /**
     * Este método se encarga de recibir todas las conexiones entrantes.
     */
	
	public void recibirConexiones()
	{
		String aux = config.getProperty("servidor.puerto");
		int puerto = Integer.parseInt(aux);
		try
		{
			receptor = new ServerSocket(puerto);
			while(true)
			{
				//Esperar una nueva conexion
				Socket socketNuevoUsuario = receptor.accept();
				//Crear un nuevo Usuario
				try
				{
					ManejadorUsuario manejador = new ManejadorUsuario();
					manejador.iniciarManejador();
					if(!revisarUsuarioPreviamenteConectado(manejador.darJugador().darNombre())){
						usuarios.add(manejador);
						principal.actualizar();
					}else{manejador.responderAdios();}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				receptor.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * Cierra el ServerSocket que esta escuchando.
	 */
	
    private void cerrarConexion() 
    {
    	try
    	{
    		if(!receptor.isClosed())
    		{
    			receptor.close();
    		}
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	
	}
    
    /**
     * Revisa si un usuario está previamente conectado.
     * @param pNombre Nombre del usuario que está previamente conectado.
     * @return Si el usuario esta conectado
     */
    public boolean revisarUsuarioPreviamenteConectado(String pNombre)
    {
    	for(Iterator iter = usuarios.iterator(); iter.hasNext();)
    	{
    		ManejadorUsuario usuario = (ManejadorUsuario) iter.next();
    		if(usuario.darUsuario().darNombre().equals(nombre)){
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Devuelve la lista de los jugadores conectados.
     * @return La lista de los conectados.
     */
    
    public Collection darConectados()
    {
    	Collection nombreConectados = new ArrayList();
    	for( Iterator iter = usuarios.iterator(); iter.hasNext();)
    	{
    		ManejadorUsuario manejador = (ManejadorUsuario) iter.next();
    		nombreConectados.add(manejador.darUsuario().darNombre());
    	}
    	return nombreConectados;
    }
    
    /**
     * El usuario está pidiendo desconexión.
     * @param pNombreUsuario Nombre del cliente que se está desconectando.
     */
    
    public void usuarioDesconecto(String pNombreUsuario)
    {
    	ManejadorUsuario manejadorDef = null;
        boolean encontro = false;
        for( Iterator iter = usuarios.iterator( ); iter.hasNext( ); )
        {
            ManejadorUsuario manejador = ( ManejadorUsuario )iter.next( );
            if( manejador.darUsuario( ).darNombre( ).equals( pNombreUsuario ) )
            {
                manejadorDef = manejador;
                encontro = true;
            }
        }
        if(encontro)
        {
        	try
        	{
        		manejadorDef.desconectar();
        		usuarios.remove(manejadorDef);
        		principal.actualizar();
        	}
        	catch (IOException e)
        	{
        		e.printStackTrace();
        	}
        }
    }

	/**
     * Método para la extensión 1.
     * @return respuesta1.
     */
	
	public String metodo1() 
	{
		return "Respuesta 1";
	}
	
    /**
     * Método para la extensión 2.
     * @return respuesta2.
     */
	
	public String metodo2() 
	{
		return "Respuesta 2";
	}
}
