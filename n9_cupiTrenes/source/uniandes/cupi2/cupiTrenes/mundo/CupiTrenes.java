/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_cupiTrenes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTrenes.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa el manejador de trenes CupiTrenes.<br>
 * <b>inv:</b><br>
 * No hay dos trenes con el mismo id.<br>
 */
public class CupiTrenes implements Serializable
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante de serializaci�n de la clase.
     */
    private static final long serialVersionUID = 8200346310786852815L;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El primer tren CupiTrenes.
     */
    // TODO Parte2 PuntoH: Declarar el atributo que guarda la referencia al primer tren.
    
    private Tren primerTren;

    /**
     * Ruta donde se guarda el archivo con la informaci�n del mundo.
     */
    private String rutaArchivo;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Constructor del manejador de los trenes.<br>
     * <b>post:</b> El archivo que est� identificado con pRutaArchivo queda cargado en el sistema.<br>
     * Si existe un archivo con la informaci�n del mundo, crea la clase a partir esta informaci�n.
     * @param pRutaArchivo La ruta del archivo del cu�l se carga la informaci�n de los trenes. pRutaArchivo != null && pRutaArchivo != "".
     * @throws PersistenciaException Si se presenta alg�n problema cargando el archivo.
     */
    public CupiTrenes( String pRutaArchivo ) throws PersistenciaException
    {
        rutaArchivo = pRutaArchivo;
        abrir( );
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el primer tren.
     * @return Primer tren.
     */
    // TODO Parte2 PuntoI: Agregar el m�todo darPrimerTren de acuerdo a la documentaci�n.
    
    public Tren darPrimerTren()
    {
    	return primerTren;
    }

    /**
     * Retorna el total de sillas disponibles en todos los trenes.
     * @return Cantidad de sillas disponibles.
     */
    public int darTotalSillasDisponibles( )
    {
        // TODO Parte2 PuntoJ: Completar el m�todo darTotalSillasDisponibles de acuerdo a la documentaci�n.
    	
    	int totalSillasDisponiblesTrenes = 0;
    	Tren trenActual = primerTren;
    	if(trenActual == null)
    	{
    	}
    	else
    	{
    		while(trenActual != null)
    		{
    			totalSillasDisponiblesTrenes += trenActual.darCantidadSillasDisponibles();
    			trenActual = trenActual.darSiguiente();
    		}
    	}
    	return totalSillasDisponiblesTrenes;
    }

    /**
     * Retorna el total de dinero recaudado.
     * @return Total recaudado.
     */
    public double darTotalRecaudo( )
    {
        // TODO Parte2 PuntoK: Completar el m�todo darTotalRecaudo de acuerdo a la documentaci�n.
    	
    	double totalDineroRecaudado = 0;
    	Tren trenActual = primerTren;
    	if(trenActual == null)
    	{
    	}
    	else
    	{
    		while(trenActual != null)
    		{
    			totalDineroRecaudado += trenActual.darCantidadRecaudada();
    			trenActual = trenActual.darSiguiente();
    		}
    	}
    	return totalDineroRecaudado;
    }
    
    /**
     * Retorna los identificadores de todos los trenes.
     * @return Los identificadores de los trenes.
     */
    public ArrayList<Integer> darIdTrenes( )
    {
        ArrayList<Integer> identificadores = new ArrayList<Integer>( );
        
        Tren actual = primerTren;
        while( actual != null )
        {
            identificadores.add( actual.darId( ) );
            actual = actual.darSiguiente( );
        }
        
        return identificadores;
    }
    
    /**
     * Retorna los n�meros de los vagones de un tren con un id dado.
     * @return Una lista con los n�meros de los vagones de un tren.
     * @param pIdTren El identificador del tren. pIdTren != null && pIdTren >= 0.
     */
    public ArrayList<Integer> darNumerosVagones( int pIdTren )
    {
        Tren trenBuscado = buscarTrenPorId( pIdTren );
        return trenBuscado.darNumerosVagones( );
    }

    /**
     * Recupera el estado a partir del archivo serializado.<br>
     * <b>post:</b> El archivo queda cargado en el sistema.
     * @throws PersistenciaException Si se presenta alg�n problema al cargar la informaci�n.
     */
    public void abrir( ) throws PersistenciaException
    {
        File archivo = new File( rutaArchivo );
        if( archivo.exists( ) )
        {
            try
            {
                ObjectInputStream ois = new ObjectInputStream( new FileInputStream( archivo ) );
                primerTren = ( Tren )ois.readObject( );
                ois.close( );
            }
            catch( Exception e )
            {
                primerTren = null;
                throw new PersistenciaException( "Error fatal: imposible restaurar el estado del programa (" + e.getMessage( ) + ")." );
            }
        }
        else
        {
            primerTren = null;
        }

    }

    /**
     * Busca un tren que tenga como paradas el origen y destino dados por par�metro en ese orden.
     * @param pOrigen Origen buscado. pRrigen != null && pRrigen != "".
     * @param pDestino Destino buscado. pDestino != null && pDestino != "".
     * @return Tren que tiene dentro de sus paradas el origen y destino dados, null si no se encuentra un tren con las caracter�sticas dadas.
     */
    public Tren buscarTrenPorParadas( String pOrigen, String pDestino )
    {
        // TODO Parte2 PuntoL: Completar el m�todo buscarTrenPorParadas de acuerdo a la documentaci�n.
    	
    	Tren trenActual = primerTren;
    	Tren trenBuscado = null;
    	
    	if(trenActual == null)
    	{
    	}
    	else
    	{
    		while(trenActual != null)
    		{
    			for(int i = 0; i < trenActual.darParadas().size(); i++)
    			{
    				for(int j = i+1; j < trenActual.darParadas().size(); j++)
    				{
    					if(trenActual.darParadas().get(i).darNombre().equals(pOrigen) && trenActual.darParadas().get(j).darNombre().equals(pDestino))
    					{
    						trenBuscado = trenActual;
    					}
    				}
    			}
    			trenActual = trenActual.darSiguiente();
    		}
    	}
    	return trenBuscado;
    }

    /**
     * Retorna el tren con el id dado de par�metro.
     * @param pIdTren Id del tren a buscar.
     * @return Tren buscado, null en caso de no encontrarla.
     */
    public Tren buscarTrenPorId( int pIdTren )
    {
        // TODO Parte2 PuntoM: Completar el m�todo buscarTrenPorId de acuerdo a la documentaci�n.
    	
    	Tren trenActual = primerTren;
    	Tren trenBuscado = null;
    	
    	if(trenActual == null)
    	{
    	}
    	else
    	{
    		while(trenActual != null)
    		{
    			if(trenActual.darId() == pIdTren)
    			{
    				trenBuscado = trenActual;
    			}
    			trenActual = trenActual.darSiguiente();
    		}
    	}
    	return trenBuscado;
    }

    /**
     * Agrega un nuevo tren con la informaci�n dada por par�metro. <br>
     * <b>pre: </b> El arreglo de nombres y el arreglo de horarios de paradas tienen el mismo tama�o y los arreglos est�n ordenados.
     * <b>post:</b> Se agreg� el nuevo tren a la lista y �sta se encuentra ordenada ascendentemente por hora de la parada de origen (hora de salida).
     * @param pIdTren Id del tren a agregar.
     * @param pNombresParadas Arreglo con los nombres de las paradas del tren. pNombresParadas != null.
     * @param pHorariosParadas Arreglo con los horarios de las paradas del tren. pHorariosParadas != null.
     * @throws ElementoExisteException Si ya existe un tren con el id ingresado por par�metro.
     * @throws ParseException 
     */
    public void agregarTren( int pIdTren, String[] pNombresParadas, Date[] pHorariosParadas ) throws ElementoExisteException
    {
        // TODO Parte2 PuntoN: Completar el m�todo agregarTren de acuerdo a la documentaci�n.
    
    	Tren trenAgregar = new Tren(pIdTren);
    	for(int i = 0; i < pNombresParadas.length; i++)
    	{
    		Parada paradaI = new Parada(pNombresParadas[i], pHorariosParadas[i]);
    		trenAgregar.agregarParada(paradaI);
    	}
    	SimpleDateFormat formato = new SimpleDateFormat( "HH:mm" );
    	Date horarioSalidaAgregar;
		try {
			horarioSalidaAgregar = formato.parse(trenAgregar.darHorarioSalida());
			if(primerTren == null)
	    	{
	    		primerTren = trenAgregar;
	    	}
	    	else
	    	{
	    		Tren trenAnterior = null;
	    		Tren trenActual = primerTren;
	    		Tren trenAnteriorIns = null;
	    		Tren trenActualIns = primerTren;
	    		while(trenActual != null )
	    		{
	    			Date horarioSalidaActual;
					try {
						horarioSalidaActual = formato.parse(trenActual.darHorarioSalida());
						if(trenActual.darId() != pIdTren && horarioSalidaActual.compareTo(horarioSalidaAgregar) < 0 && trenActual.darSiguiente() != null)
		    			{
		    				trenAnteriorIns = trenAnterior;
		    				trenActualIns = trenActual;
		    			}
						else if(trenActual.darId() != pIdTren && horarioSalidaActual.compareTo(horarioSalidaAgregar) > 0 && trenActual.darSiguiente() == null)
						{
							trenAnteriorIns = trenAnterior;
							trenActualIns = trenActual;						}
						else if(trenActual.darId() != pIdTren && horarioSalidaActual.compareTo(horarioSalidaAgregar) < 0 && trenActual.darSiguiente() == null)
						{
							trenAnteriorIns = trenActual;
							trenActualIns = null;						}
		    			else if(trenActual.darId() == pIdTren)
		    			{
		    				throw new ElementoExisteException("Ya existe un tren con el Id dado");
		    			}
						trenAnterior = trenActual;
	    				trenActual = trenActual.darSiguiente();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			
	    		}
	    		if(trenAnteriorIns !=null && trenActualIns != null && trenActualIns.darId() != pIdTren)
				{
					trenAgregar.cambiarSiguiente(trenActualIns);
					trenActualIns.cambiarAnterior(trenAgregar);
					trenAnteriorIns.cambiarSiguiente(trenAgregar);
					trenAgregar.cambiarAnterior(trenAnteriorIns);
				}
	    		else if(trenAnteriorIns !=null && trenActualIns == null && trenAnteriorIns.darId() != pIdTren)
	    		{
	    			trenAnteriorIns.cambiarSiguiente(trenAgregar);
					trenAgregar.cambiarAnterior(trenAnteriorIns);
	    		}
	    		else if(trenAnteriorIns ==null && trenActualIns.darId() != pIdTren)
	    		{
	    			primerTren = trenAgregar;
					primerTren.cambiarSiguiente(trenActualIns);
					trenActualIns.cambiarAnterior(primerTren);
				}	
				else
				{
					throw new ElementoExisteException("Ya existe un tren con el Id dado");
				}
	    	}
	    	verificarInvariante();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * Agrega un nuevo vag�n con las caracter�sticas dadas al tren con el id dado.<br>
     * <b>post:</b> Se agreg� el vag�n a la lista de vagones del tren indicado.
     * @param pIdTren Id del tren al cual se quiere agregar el vag�n.
     * @param pNumeroVagon N�mero del vag�n a agregar.
     * @param pCantidadSillas Cantidad de sillas en el vag�n. pCantidadSillas >= 0.
     * @param pClase Clase del compartimiento. pClase != null && pClase != "" && (pClase ==PRIMERA_CLASE || pClase == SEGUNDA_CLASE).
     * @param pPrecio Precio del tiquete en el vag�n. pPrecio >= 0.
     * @throws ElementoExisteException Lanza la excepci�n si ya existe un vag�n con ese n�mero.
     * @throws ElementoNoExisteException Lanza la excepci�n si no existe un tren con ese id.
     */
    public void agregarVagon( int pIdTren, int pNumeroVagon, int pCantidadSillas, String pClase, double pPrecio ) throws ElementoExisteException, ElementoNoExisteException
    {
        Tren actual = buscarTrenPorId( pIdTren );
        if( actual != null )
        {
            actual.agregarVagon( pNumeroVagon, pCantidadSillas, pClase, pPrecio );
        }
        else
        {
            throw new ElementoNoExisteException( "No existe un tren con ID " + pIdTren + "." );
        }
    }

    /**
     * Elimina el tren con el id dado por par�metro.<br>
     * <b>post:</b> Se elimin� el tren de la lista de trenes.
     * @param idTren Id del tren a eliminar.
     * @throws ElementoNoExisteException Lanza una excepci�n si no existe ninguna tren con el id dado.
     */
    public void eliminarTren( int pIdTren ) throws ElementoNoExisteException
    {
        // TODO Parte2 PuntoO: Completar el m�todo eliminarTren de acuerdo a la documentaci�n.
    	
    	if(primerTren == null)
    	{
    		throw new ElementoNoExisteException("No existe el tren: " + pIdTren);
    	}
    	else if(primerTren.darId() == pIdTren)
    	{
    		primerTren = primerTren.darSiguiente();
    	}
    	else
    	{
    		Tren trenAnterior = primerTren;
    		while(trenAnterior.darSiguiente() != null && trenAnterior.darSiguiente().darId() != pIdTren)
    		{
    			trenAnterior = trenAnterior.darSiguiente();
    		}
    		if(trenAnterior.darSiguiente() == null)
    		{
    			throw new ElementoNoExisteException("No existe el tren: " + pIdTren);
    		}
    		else
    		{	
        		if(trenAnterior.darSiguiente().darSiguiente()!=null)
        		{
        			trenAnterior.darSiguiente().darSiguiente().cambiarAnterior(trenAnterior);	
        		}
        		trenAnterior.cambiarSiguiente(trenAnterior.darSiguiente().darSiguiente());
    		}
    	}
    	
    }

    /**
     * Elimina el vag�n con el n�mero dado que se encuentra en el tren con la id dada. <br>
     * <b>post:</b> Se elimin� el vag�n de la lista de vagones del tren indicado.
     * @param pIdTren Id del tren al que pertenece el vag�n a eliminar.
     * @param pNumVagon N�mero del vag�n que se quiere eliminar.
     * @throws ElementoNoExisteException Lanza una excepci�n si el tren o el vag�n no existe.
     */
    public void eliminarVagon( int pIdTren, int pNumVagon ) throws ElementoNoExisteException
    {
        try
        {
            buscarTrenPorId( pIdTren ).eliminarVagon( pNumVagon );
        }
        catch( NullPointerException e )
        {
            throw new ElementoNoExisteException( "No existe una ruta con id " + pIdTren + "." );
        }
    }

    /**
     * Vende un tiquete del tren con el id dado en el vag�n con el n�mero dado por par�metro. <br>
     * <b>post:</b> Se aument� la cantidad recaudada con el precio del tiquete y se disminuy� en uno la cantidad de sillas disponibles en el vag�n.<br>
     * @param pIdTren Id del tren en el que se va a vender el tiquete.
     * @param pNumVagon N�mero del vag�n donde se quiere vender el tiquete.
     * @return True si el tiquete fue vendido, false de lo contrario.
     * @throws ElementoNoExisteException Lanza una excepci�n si no existe una ruta con el id dado o si no existe un vag�n con el n�mero dado
     */
    public boolean venderTiquete( int pIdTren, int pNumVagon ) throws ElementoNoExisteException
    {
        Tren ruta = buscarTrenPorId( pIdTren );
        if( ruta == null )
        {
            throw new ElementoNoExisteException( "No existe una ruta con id " + pIdTren + "." );
        }
        return ruta.venderTiquete( pNumVagon );

    }

    /**
     * Genera un reporte con la informaci�n de los trenes y el recaudo de cupiTrenes.<br>
     * <b>post:</b> El reporte fue guardado en un el archivo pNombreArchivo en la ubicaci�n rutaArchivo.<br>
     * @param pRutaNombre Nombre de la ruta donde se va a guardar el archivo. pRutaNombre != "" && pRutaNombre != null.
     * @param pNombreArchivo Nombre del archivo a guardar. pNombreArchivo != "" && pNombreArchivo != null.
     * @throws FileNotFoundException Lanza una excepci�n si la ruta del archivo no existe.
     */
    public void generarReporte( String pRutaNombre, String pNombreArchivo ) throws FileNotFoundException
    {
        File directorioReporte = new File( pRutaNombre );
        if( !directorioReporte.exists( ) )
        {
            directorioReporte.mkdirs( );
        }

        File archivoReporte = new File( directorioReporte, pNombreArchivo );
        PrintWriter out = new PrintWriter( archivoReporte );

        out.println( "------- REPORTE CUPITRENES -------- " );
        out.println( );
        Date fechaActual = new Date( System.currentTimeMillis( ) );
        SimpleDateFormat sdf = new SimpleDateFormat( "dd MMM yyyy HH:mm:ss " );

        out.println( "Generado el: " + sdf.format( fechaActual ).toString( ) );
        out.println( "Total recaudado: " + darTotalRecaudo( ) );
        out.println( "Sillas disponibles: " + darTotalSillasDisponibles( ) );

        out.println( );
        out.println( "---- Reporte detallado ----" );
        out.println( );

        Tren actual = primerTren;

        while( actual != null )
        {
            actual.imprimirDetallesTren( out );
            actual = actual.darSiguiente( );
        }

        out.close( );
    }

    /**
     * M�todo que guarda el estado del mundo en un archivo serializado.<br>
     * <b>post:</b> El estado del mundo fue guardado en rutaArchivo.<br>
     * @param pRutaArchivo La ruta del archivo en donde se va a guardar el estado del mundo. pRutaArchivo != "" && pRutaArchivo != null.
     * @throws PersistenciaException Se lanza excepci�n si ocurre alg�n problema al guardar.
     */
    public void guardar( String pRutaArchivo ) throws PersistenciaException
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( pRutaArchivo ) );
            oos.writeObject( primerTren );
            oos.close( );
        }
        catch( IOException e )
        {
            throw new PersistenciaException( "Error al guardar el estado del mundo." );
        }
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv:</b><br>
     * Existe una ruta de archivo. rutaArchivo != null. <br>
     * La ruta del archivo no es una cadena vac�a. rutaArchivo != "". <br>
     * No hay dos trenes con el mismo id.<br>
     */
    private void verificarInvariante( )
    {
        assert rutaArchivo != null : "La ruta del archivo no puede ser null.";
        assert !rutaArchivo.equals( "" ) : "La ruta del archivo no puede ser vac�a.";
        assert !hayIdsRepetidos( ) : "Hay m�s de un tren con el mismo id.";
    }

    /**
     * Verifica si hay dos trenes con el mismo id.
     * @return True si hay dos trenes con el mismo id, false de lo contrario.
     */
    private boolean hayIdsRepetidos( )
    {
        boolean respuesta = false;
        Tren ruta1 = primerTren;
        while( ruta1 != null && !respuesta )
        {
            Tren ruta2 = ruta1.darSiguiente( );
            while( ruta2 != null )
            {
                if( ruta2.darId( ) == ruta1.darId( ) )
                    respuesta = true;
                ruta2 = ruta2.darSiguiente( );
            }
            ruta1 = ruta1.darSiguiente( );
        }
        return respuesta;
    }

    // -------------------------------------------------------------
    // M�todos de extensi�n
    // -------------------------------------------------------------

    /**
     * M�todo para la extensi�n1.
     * @return repuesta1.
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