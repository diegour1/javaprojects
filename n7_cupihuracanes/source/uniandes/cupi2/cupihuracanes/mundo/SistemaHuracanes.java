/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiHuracanes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupihuracanes.mundo;

import java.util.ArrayList;

/**
 * Clase que se encarga de manejar, organizar, cargar y salvar los huracanes. <br>
 * TODO Parte 1 punto C: Definir y documentar el invariante de la clase.
 */
public class SistemaHuracanes
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Arreglo de huracanes.
     */
    private ArrayList huracanes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo sistema de meteorología vacío.
     */
    public SistemaHuracanes( )
    {
        huracanes = new ArrayList( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la lista de huracanes.
     * @return Lista de huracanes.
     */
    public ArrayList darHuracanes( )
    {
        return huracanes;
    }
    
    /**
     * Registrar un nuevo huracán en el sistema. 
     * <b> post: </b> El huracán fue agregado exitosamente al sistema (Si no existía otro huracán con el mismo nombre).
     * @param pNombre Nombre del huracán. pNombre != null && pNombre !="".
     * @param pCategoria Categoría del huracán. 1 <= pCategoria <= 5.
     * @param pVelocidad Velocidad del viento. 0 <= pVelocidad.
     * @param pCostoEstimadoDanios Costo estimado de daños. 0 <= pCostoEstimadoDanios.
     * @param pImagen Ruta a la imagen del huracán. pImagen != null && pImagen !="".
     * @return True si el huracán fue agregado, false de lo contrario.
     */
    public boolean registrarHuracan( String pNombre, int pCategoria, int pVelocidad, double pCostoEstimadoDanios, String pImagen )
    {
        int huracanBuscado = buscarHuracan( pNombre );
        boolean agregado = false;
        if( huracanBuscado == -1 )
        {
            Huracan nuevoHuracan = new Huracan( pNombre, pCategoria, pVelocidad, pCostoEstimadoDanios, pImagen );
            huracanes.add( nuevoHuracan );
            agregado = true;
        }

           return agregado;
    }

    /**
     * Ordena ascendentemente la lista de huracanes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de huracanes está ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre( )
    {
    	// TODO Parte 2 punto G: Completar según documentación.
    	int i = huracanes.size( ) - 1 ;
    	while( i > 0 )
    	{
    		int j = 0;
    		while (j < i)
    		{
    			Huracan huracanTempJ = (Huracan) huracanes.get(j);
    			Huracan huracanTempJmas1 = (Huracan) huracanes.get(j+1);
    			
    			if (huracanTempJ.compararPorNombre(huracanTempJmas1.darNombre())>0)
    			{
    				Huracan temp = huracanTempJ;
    				huracanes.set(j, huracanTempJmas1);
    				huracanes.set(j+1, temp);
    			}
    			j++;
    		}
    		i--;
    	}
    }

    /**
     * Ordena descendentemente la lista de huracanes por velocidad del viento usando el algoritmo de inserción. <br>
     * <b>post: </b>La lista de huracanes está ordenada por velocidad del viento (orden descendente).
     */
    public void ordenarPorVelocidad( )
    {
    	// TODO Parte 2 punto H:  Completar según documentación.  
    	for( int i = 1; i < huracanes.size( ); i++)
    	{
    		Huracan huracanTempI = (Huracan) huracanes.get(i);
    		boolean termino = false;
    		
    		for ( int j = i; j>0 && !termino; j--)
    		{
    			Huracan huracanTempJmenos1 = (Huracan) huracanes.get(j-1);
    			
    			if( huracanTempJmenos1.compararPorVelocidad(huracanTempI)>0)
    			{
    				huracanes.set(j, huracanTempJmenos1);
    				huracanes.set(j-1, huracanTempI);
    			}
    			else
    				termino = true;
    		}
    		
    	}
    	
    }

    /**
     * Ordena ascendentemente la lista de huracanes por edad usando el algoritmo de selección. <br>
     * <b>post: </b>La lista de huracanes está ordenada por edad (orden ascendente).
     */
    public void ordenarPorDanios( )
    {
    	// TODO Parte 2 punto I: Completar según documentación.  
    	for( int i = 1; i < huracanes.size( ); i++)
    	{
    		Huracan huracanTempI = (Huracan) huracanes.get(i);
    		boolean termino = false;
    		
    		for ( int j = i; j>0 && !termino; j--)
    		{
    			Huracan huracanTempJmenos1 = (Huracan) huracanes.get(j-1);
    			
    			if( huracanTempJmenos1.compararPorDanios(huracanTempI)>0)
    			{
    				huracanes.set(j, huracanTempJmenos1);
    				huracanes.set(j-1, huracanTempI);
    			}
    			else
    				termino = true;
    		}
    		
    	}	
    	
    }
    
    /**
     * Busca un huracán según su nombre y retorna la posición en la que se encuentra.
     * @param pNombre es el nombre del huracán buscado. pNombre!=null.
     * @return Posición donde se encuentra el huracán con el nombre dado. 
     * 		   Si no se encuentra ningún huracán con ese nombre retorna -1.
     */
    public int buscarHuracan( String pNombre )
    {
        int posicion = -1;
        boolean termine = false;

        for( int i = 0; i < huracanes.size( ) && !termine; i++ )
        {
            Huracan huracanPosicion = ( Huracan )huracanes.get( i );
            String nombreHuracan = huracanPosicion.darNombre( );

            // Los nombres son iguales
            if( nombreHuracan.equalsIgnoreCase( pNombre ) )
            {
                posicion = i;
                termine = true;
            }
        }

        return posicion;
    }

    /**
     * Busca un huracán dado su nombre utilizando una búsqueda binaria. <br>
     * <b>pre: </b> La lista de huracanes se encuentra ordenada por nombre.
     * @param pNombre es el nombre del huracán que se va a buscar. pNombre != null && pNombre != "".
     * @return Posición del huracán con el nombre dado. 
     * 		   Si el huracán no existe, retorna -1.
     */
    public int buscarBinarioPorNombre( String pNombre )
    {
    	// TODO Parte 2 punto J: Completar según documentación.
    	int encontre = -1;
    	int inicio = 0;
    	int fin = huracanes.size() - 1;
    	while (inicio <= fin && encontre != -1)
    	{
    		int medio = (inicio + fin)/2;
    		Huracan huracanTempMedio = (Huracan) huracanes.get(medio);
    		if (huracanTempMedio.darNombre() == pNombre)
    		{
    			encontre = medio;
    		}
    		else if (huracanTempMedio.compararPorNombre(pNombre)>0)
    		{
    			fin = medio - 1;
    		}
    		else
    		{
    			inicio = medio + 1;
    		}
    	}
    	return encontre;
    }

    /**
     * Busca el huracán que tenga el mayor costo estimado en daños.
     * @return Posición donde se encuentra el huracán con el mayor costo estimado en daños. 
     * 		   Si no hay huracanes en el sistema, retorna -1.
     */
    public int buscarHuracanMayorCostoDanios( )
    {
    	// TODO Parte 2 punto K: Completar según documentación.
   
    }

    /**
     * Busca el huracán que tenga el menor costo estimado en daños.
     * @return Posición donde se encuentra el huracán con el menor costo estimado en daños. 
     * 		   Si no hay huracanes en el sistema, retorna -1.
     */
    public int buscarHuracanMenorCostoDanios( )
    {
    	// TODO Parte 2 punto L: Completar según documentación.
    	
    }

    /**
     * Busca el huracán que tenga la mayor velocidad.
     * @return Posición donde se encuentra el huracán con la mayor velocidad.
     * 		   Si no hay huracanes en el sistema, retorna -1.
     */
    public int buscarHuracanMayorVelocidad( )
    {
    	// TODO Parte 2 punto M: Completar según documentación.
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Parte 1 punto D: Declarar, implementar y documentar el método verificarInvariante.
    // Si utiliza métodos auxiliares, declárelos e impleméntelos en esta sección.

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}