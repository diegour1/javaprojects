/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_cupiDeportes
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiDeportes.mundo;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.imageio.ImageIO;

/**
 * Clase que se encarga de administrar el sistema de CupiDeportes.<br>
 * <b>inv:</b><br>
 * deportes != null. <br>
 * No existen dos o más deportes con el mismo nombre.<br>
 */
public class CupiDeportes
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista con los deportes.
     */
    private ArrayList<Deporte> deportes;
    
    /**
     * Atributo para guardar archivo
     */

    private String nombreArchivo;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nuevo sistema de deportes. <br>
     * Si el archivo indicado no existe, se crea una lista de deportes vacía.<br>
     * Si el archivo existe, se carga la información de los deportes y su deportistas.
     * @param pNombreArchivo Nombre del archivo que contiene los datos serializados. pNombreArchivo != null && pNombreArchivo != "".
     * @throws PersistenciaException Se lanza una excepción si hay algún error cargando los datos del archivo.
     */
    public CupiDeportes( String pNombreArchivo ) throws PersistenciaException
    {
    	// TODO Parte 3 punto C: Implemente el método según la documentación.
    	
    	nombreArchivo = pNombreArchivo;
    	File archivo = new File(nombreArchivo);
    	
    	if(archivo.exists())
    	{
    		try
    		{
    			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
    			deportes = (ArrayList) ois.readObject();
    			ois.close();
    		}
    		catch (Exception e)
    		{
    			throw new PersistenciaException( "Error cargando los datos del archivo (" + e.getMessage( ) + ")" );
            }
    	}
    	else 
    	{
    		deportes = new ArrayList();
    	}
    
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la lista con todos los deportes.
     * @return Lista con los deportes.
     */
    public ArrayList<Deporte> darDeportes( )
    {
        return deportes;
    }

    /**
     * Agrega un deporte con la información dada a la lista de deportes. <br>
     * <b>post: </b> Se agregó el deporte a la lista.
     * @param pNombreDeporte Nombre del deporte. pNombreDeporte != null && pNombreDeporte != "".
     * @param pEnteRegulador Ente regulador del deporte. pEnteRegulador != null && pEnteRegulador != "".
     * @param pCantidadDeportistasRegistrados Cantidad de deportistas registrados. pCantidadDeportistasRegistrados > 0.
     * @param pRutaImagen Ruta a la imagen del deporte. pRutaImagen != null && pRutasImagen != "".
     * @throws ElementoExisteException Lanza una excepción si ya existe un deporte con el nombre dado.
     */
    public void agregarDeporte( String pNombreDeporte, String pEnteRegulador, int pCantidadDeportistasRegistrados, String pRutaImagen ) throws ElementoExisteException
    {
        if( existeDeporte( pNombreDeporte ) )
        {
        	throw new ElementoExisteException( ElementoExisteException.DEPORTE_REPETIDO, pNombreDeporte );
//			throw new ElementoExisteException("El" + pNombreDeporte + "ya esta en la base de datos ");
        }
        else
        {
            Deporte deporteNuevo = new Deporte( pNombreDeporte, pEnteRegulador, pCantidadDeportistasRegistrados, pRutaImagen );
            deportes.add( deporteNuevo );
        }
        verificarInvariante( );
    }

    /**
     * Elimina el deporte con nombre dado de la lista de deportes. <b>post: </b> Se eliminó el deporte de la lista.
     * @param pNombreDeporte Nombre del deporte a eliminar. pNombreDeporte != null && pNombreDeporte != "".
     */
    public void eliminarDeporte( String pNombreDeporte )
    {
        boolean encontro = false;
        for( int i = 0; i < deportes.size( ) && !encontro; i++ )
        {
            Deporte deporteActual = deportes.get( i );
            if( deporteActual.darNombre( ).equals( pNombreDeporte ) )
            {
                deportes.remove( i );
                encontro = true;
            }
        }
        verificarInvariante( );
    }

    /**
     * Agrega un deportista sobresaliente a un deporte con la información dada por parámetro. <br>
     * <b>post: </b> Se agregó el deportista sobresaliente al deporte correspondiente.
     * @param pNombreDeporte Nombre del deporte. pNombreDeporte != null && pNombreDeporte != "".
     * @param pNombreDeportista Nombre del deportista sobresaliente. pNombreDeportista != null && pNombreDeportista != "".
     * @param pEdad Edad del deportista. pEdad > 0.
     * @param pLugarResidencia Lugar de residencia del deportista. pLugarResidencia != null && pLugarResidencia != "".
     * @param pCantidadTrofeos Cantidad de trofeos ganados por el deportista. pCantidadTrofeos >= 0.
     * @param pRutaImagenDeportista Ruta a la imagen del deportista. pRutaImagenDeportista != null && pRutaImagenDeportista != "".
     * @throws ElementoExisteException Lanza una excepción si en el deporte ya existe un deportista con el nombre dado.
     */
    public void agregarDeportistaSobresaliente( String pNombreDeporte, String pNombreDeportista, int pEdad, String pLugarResidencia, int pCantidadTrofeos, String pRutaImagenDeportista ) throws ElementoExisteException
    {
        //TODO Parte 4 punto D: Implemente el método según la documentación.  
    	
    	for( Deporte deporteActual : deportes)
    	{
    		if( deporteActual.darNombre().equals(pNombreDeporte) )	
    		{
    			if ( !deporteActual.existeDeportistaSobresaliente(pNombreDeportista) )
    			{

        			Deportista deportistaActual = new Deportista( pNombreDeportista, pEdad, pLugarResidencia, pCantidadTrofeos, pRutaImagenDeportista);
        			deporteActual.agregarDeportistaSobresaliente(deportistaActual);	
    			}
    			else
    			{
    	        	throw new ElementoExisteException( ElementoExisteException.DEPORTISTA_REPETIDO, pNombreDeportista );			
//        			throw new ElementoExisteException("Error: El " + pNombreDeportista + " ya es parte de los deportistas sobresalientes");    				
    			}
    		}
    		
    	}
    }
    
    
    /**
     * Elimina el deportista sobresaliente con el nombre especificado del deporte que tiene el nombre dado por parámetro. <br>
     * <b>post: </b> Se eliminó el deportista sobresaliente del deporte correspondiente.
     * @param pNombreDeporte Nombre del deporte. pNombreDeporte != null && pNombreDeporte != "".
     * @param pNombreDeportista Nombre del deportista a eliminar. pNombreDeportista != null && pNombreDeportista != "".
     */
    public void eliminarDeportistaSobresaliente( String pNombreDeporte, String pNombreDeportista )
    {
        boolean encontro = false;
        for( int i = 0; i < deportes.size( ) && !encontro; i++ )
        {
            Deporte deporteActual = deportes.get( i );
            if( deporteActual.darNombre( ).equals( pNombreDeporte ) )
            {
                deporteActual.eliminarDeportistaSobresaliente( pNombreDeportista );
                encontro = true;
            }
        }
        verificarInvariante( );
    }

    /**
     * Verifica si existe un deporte con el nombre dado.
     * @param pNombreDeporte Nombre del deporte. pNombreDeporte != null && pNombreDeporte != "".
     * @return True si existe el deporte, false en caso contrario.
     */
    public boolean existeDeporte( String pNombreDeporte )
    {
        boolean existe = false;

        for( int i = 0; i < deportes.size( ) && !existe; i++ )
        {
            Deporte deporteActual = deportes.get( i );
            if( deporteActual.darNombre( ).equals( pNombreDeporte ) )
            {
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Retorna el deportista sobresaliente que tiene el mayor número de trofeos. <br>
     * Si hay dos o más deportistas con el mismo número de trofeos y ambos son máximos, retorna cualquiera.
     * @return Retorna el deportista que más tiene trofeos. Si no hay deportistas retorna null.
     */
    public Deportista darDeportistaMasTrofeos( )
    {
        Deportista masTrofeos = null;
        int cantidadMax = 0;
        if( deportes.size( ) != 0 )
        {
            for( int i = 0; i < deportes.size( ); i++ )
            {
                Deporte deporteActual = deportes.get( i );
                Deportista deportistaActualMas = deporteActual.darDeportistaMasTrofeos( );
                if( deportistaActualMas.darCantidadTrofeos( ) > cantidadMax )
                {
                    masTrofeos = deportistaActualMas;
                    cantidadMax = deportistaActualMas.darCantidadTrofeos( );
                }
            }
        }
        return masTrofeos;
    }

    /**
     * Retorna el total de trofeos.
     * @return Cantidad total de trofeos.
     */
    public int darTotalTrofeos( )
    {
        int total = 0;

        for( int i = 0; i < deportes.size( ); i++ )
        {
            Deporte deporteActual = deportes.get( i );
            total += deporteActual.darTotalTrofeos( );
        }

        return total;
    }

    /**
     * Serializa el ArrayList de deportes en el archivo cuya ruta entra como parámetro.
     * @param pRutaArchivo Ruta del archivo donde se va guardar. pRutaArchivo != null && pRutaArchivo != "".
     * @throws PersistenciaException Lanza una excepción si se presenta un problema al momento de guardar el archivo.
     */
    public void guardar( String pRutaArchivo ) throws PersistenciaException
    {
        // TODO Parte 3 punto A: Implemente el método según la documentación.
    	
    	try
    	{
    		nombreArchivo = pRutaArchivo;
    		File f = new File (nombreArchivo);
    		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( f ) );
    		oos.writeObject(deportes);
    		oos.close();
    	}
    	catch( IOException e)
    	{
    		throw new PersistenciaException( "Error al salvar:" + e.getMessage( ) );
    	}
    	
    	verificarInvariante();
    }

    /**
     * Actualiza la información de un deportista.
     * @param pLinea Línea de texto con la información para actualizar un deportista. pLinea != null && pLinea != "".
     * @throws FormatoArchivoException Lanza excepción si la línea de texto no cumple con el formato definido para actualizar la información de un deportista.
     */
    private void actualizarDeportista( String pLinea ) throws FormatoArchivoException, ElementoExisteException
    {
        // TODO Parte 5 punto B: Implemente el método según la documentación.
    	 	
    	if(pLinea != null && pLinea != "")
    	{

    		String linea = pLinea;
        	System.out.println(linea);
        	String [] datos = linea.split(";");
    		int edadTemp = Integer.parseInt(datos[2]);
    		int trofeosTemp = Integer.parseInt(datos[4]);
    		try
    		{
        		agregarDeportistaSobresaliente(datos[0], datos[1], edadTemp, datos[3], trofeosTemp, datos[5]);	
    		}
    		catch (ElementoExisteException e)
    		{
    			throw new ElementoExisteException(ElementoExisteException.DEPORTISTA_REPETIDO, datos[1]);
    		}
    	}
    	else
    	{
    		throw new FormatoArchivoException("La linea de texto no tiene el formato esperado");
    	}
    	
    }	

/*    	
    	if ( datos.length == 6 )
    	{
    		int edadTemp = Integer.parseInt(datos[2]);
    		int trofeosTemp = Integer.parseInt(datos[4]);
    		agregarDeportistaSobresaliente(datos[0], datos[1], edadTemp, datos[3], trofeosTemp, datos[5]);
    	}
    	else
    	{
    		throw new FormatoArchivoException("La linea de texto no cumple con el formato definido para actualizar la informacion de un deportista");
    	}
*/
    

    
    /**
     * Actualiza la información de los deportistas a partir de un archivo de texto.
     * @param pArchivo Archivo del cual se cargará la información. pArchivo != null.
     * @throws FormatoArchivoException Si el archivo no cumple con el formato definido para actualizar la información.
     * @throws IOException Si hay problemas de lectura del archivo para actualizar la información.
     */
    public void actualizarInformacionDeportistas( File pArchivo ) throws FormatoArchivoException, IOException, ElementoExisteException
    {
        // TODO Parte 5 punto C: Implemente el método según la documentación.
    	
    	String archivoName = pArchivo.getName();
    	File archivo = pArchivo;
    	
    	if( archivoName.endsWith(".txt") )
    	{
    		try
    		{
    			FileReader fr = new FileReader(archivo);
    			BufferedReader br = new BufferedReader(fr);
    			
    			String linea1 = br.readLine();
    			int numeroDeportistas = Integer.parseInt(linea1);
    			
    			for(int i = 1; i <= numeroDeportistas; i++)
    			{
    				String linea = br.readLine();
    				try
    				{
        				actualizarDeportista(linea);
    				}
    				catch(ElementoExisteException e)
    				{
    					throw new ElementoExisteException(ElementoExisteException.DEPORTISTA_REPETIDO, "Algun");
    				}
    			}
    			br.close();
    			fr.close();
    		}
    		catch (IOException e )
    		{
    			throw new IOException( "Error al actualizar la informacion: " + e.getMessage() );
    		}
    	}
    	else
    	{
    		throw new FormatoArchivoException("El archivo no cumple con el formato .txt");
    	}
    }

    /**
     * Genera el informe de los trofeos de los deportistas.
     * @param pRutaArchivo Ruta donde se desea guardar el archivo con el reporte. pRutaArchivo != null && pRutaArchivo != "".
     * @throws IOException Si ocurre un error en la generación del reporte.
     */
    public void generarReporteTrofeos( String pRutaArchivo ) throws IOException
    {
        // TODO Parte 5 punto A: Implemente el método según la documentación.
    	
    	try
    	{
    		File archivo = new File(pRutaArchivo);
    		PrintWriter pw = new PrintWriter(archivo);
    		pw.println("******************************************************************************************");
    		pw.println("CupiDeportes - Reporte Trofeos");
    		pw.println("******************************************************************************************");
    		pw.println("Fecha:\t" + new Date().toString() );
    		pw.println("Deportista con mas trofeos:" + darDeportistaMasTrofeos() );
    		pw.println("Total trofeos:\t" + darTotalTrofeos() );
    		pw.close();
    	}
    	catch (IOException e)
    	{
    		throw new IOException( "Error en la generacion del reporte: " + e.getMessage() );
    	}
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase: <br>
     * deportes != null <br>
     * No existen dos o más deportes con el mismo nombre.<br>
     */
    private void verificarInvariante( )
    {
        assert deportes != null : "La lista de deportes es nula.";
        assert buscarDeportesConElMismoNombre( ) == false : "Hay deportes con el mismo nombre.";
    }

    /**
     * Revisa si hay dos deportes con el mismo nombre.
     * @return Retorna true si hay dos deportes con el mismo nombre. Retorna false en caso contrario.
     */
    private boolean buscarDeportesConElMismoNombre( )
    {
        for( int i = 0; i < deportes.size( ); i++ )
        {
            Deporte deporte1 = deportes.get( i );

            for( int j = i + 1; j < deportes.size( ); j++ )
            {
                Deporte deporte2 = deportes.get( j );
                if( deporte1.equals( deporte2 ) )
                    return true;
            }
        }

        return false;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}