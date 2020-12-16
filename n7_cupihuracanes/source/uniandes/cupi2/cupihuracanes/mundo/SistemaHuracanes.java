/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
     * Construye un nuevo sistema de meteorolog�a vac�o.
     */
    public SistemaHuracanes( )
    {
        huracanes = new ArrayList( );
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * Registrar un nuevo hurac�n en el sistema. 
     * <b> post: </b> El hurac�n fue agregado exitosamente al sistema (Si no exist�a otro hurac�n con el mismo nombre).
     * @param pNombre Nombre del hurac�n. pNombre != null && pNombre !="".
     * @param pCategoria Categor�a del hurac�n. 1 <= pCategoria <= 5.
     * @param pVelocidad Velocidad del viento. 0 <= pVelocidad.
     * @param pCostoEstimadoDanios Costo estimado de da�os. 0 <= pCostoEstimadoDanios.
     * @param pImagen Ruta a la imagen del hurac�n. pImagen != null && pImagen !="".
     * @return True si el hurac�n fue agregado, false de lo contrario.
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
     * <b>post: </b>La lista de huracanes est� ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre( )
    {
    	// TODO Parte 2 punto G: Completar seg�n documentaci�n.
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
     * Ordena descendentemente la lista de huracanes por velocidad del viento usando el algoritmo de inserci�n. <br>
     * <b>post: </b>La lista de huracanes est� ordenada por velocidad del viento (orden descendente).
     */
    public void ordenarPorVelocidad( )
    {
    	// TODO Parte 2 punto H:  Completar seg�n documentaci�n.  
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
     * Ordena ascendentemente la lista de huracanes por edad usando el algoritmo de selecci�n. <br>
     * <b>post: </b>La lista de huracanes est� ordenada por edad (orden ascendente).
     */
    public void ordenarPorDanios( )
    {
    	// TODO Parte 2 punto I: Completar seg�n documentaci�n.  
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
     * Busca un hurac�n seg�n su nombre y retorna la posici�n en la que se encuentra.
     * @param pNombre es el nombre del hurac�n buscado. pNombre!=null.
     * @return Posici�n donde se encuentra el hurac�n con el nombre dado. 
     * 		   Si no se encuentra ning�n hurac�n con ese nombre retorna -1.
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
     * Busca un hurac�n dado su nombre utilizando una b�squeda binaria. <br>
     * <b>pre: </b> La lista de huracanes se encuentra ordenada por nombre.
     * @param pNombre es el nombre del hurac�n que se va a buscar. pNombre != null && pNombre != "".
     * @return Posici�n del hurac�n con el nombre dado. 
     * 		   Si el hurac�n no existe, retorna -1.
     */
    public int buscarBinarioPorNombre( String pNombre )
    {
    	// TODO Parte 2 punto J: Completar seg�n documentaci�n.
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
     * Busca el hurac�n que tenga el mayor costo estimado en da�os.
     * @return Posici�n donde se encuentra el hurac�n con el mayor costo estimado en da�os. 
     * 		   Si no hay huracanes en el sistema, retorna -1.
     */
    public int buscarHuracanMayorCostoDanios( )
    {
    	// TODO Parte 2 punto K: Completar seg�n documentaci�n.
   
    }

    /**
     * Busca el hurac�n que tenga el menor costo estimado en da�os.
     * @return Posici�n donde se encuentra el hurac�n con el menor costo estimado en da�os. 
     * 		   Si no hay huracanes en el sistema, retorna -1.
     */
    public int buscarHuracanMenorCostoDanios( )
    {
    	// TODO Parte 2 punto L: Completar seg�n documentaci�n.
    	
    }

    /**
     * Busca el hurac�n que tenga la mayor velocidad.
     * @return Posici�n donde se encuentra el hurac�n con la mayor velocidad.
     * 		   Si no hay huracanes en el sistema, retorna -1.
     */
    public int buscarHuracanMayorVelocidad( )
    {
    	// TODO Parte 2 punto M: Completar seg�n documentaci�n.
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Parte 1 punto D: Declarar, implementar y documentar el m�todo verificarInvariante.
    // Si utiliza m�todos auxiliares, decl�relos e implem�ntelos en esta secci�n.

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}