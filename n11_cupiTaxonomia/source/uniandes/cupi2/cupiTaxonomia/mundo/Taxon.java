/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiTaxonomia
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiTaxonomia.mundo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa un taxón del árbol taxonómico. <br>
 * <b> inv: </b> <br>
 * nombre != null && nombre != "". <br>
 * tipo pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}. <br>
 * La lista de subtaxones está inicializada. <br>
 * Si el tipo del taxón no es ESPECIE no puede tener un ser vivo. <br>
 * Si el tipo del taxón es ESPECIE no puede tener sub-taxones. <br>
 * El tipo de los sub-taxones corresponde al siguiente tipo en la jerarquía taxonómica. <br>
 */
public class Taxon implements Serializable
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa al tipo LUCA.
     */
    public final static int LUCA = 0;

    /**
     * Constante que representa al tipo Dominio.
     */
    public final static int DOMINIO = 1;

    /**
     * Constante que representa al tipo Reino.
     */
    public final static int REINO = 2;

    /**
     * Constante que representa al tipo Filo.
     */
    public final static int FILO = 3;

    /**
     * Constante que representa al tipo Clase.
     */
    public final static int CLASE = 4;

    /**
     * Constante que representa al tipo Orden.
     */
    public final static int ORDEN = 5;

    /**
     * Constante que representa al tipo Familia.
     */
    public final static int FAMILIA = 6;

    /**
     * Constante que representa al tipo Género.
     */
    public final static int GENERO = 7;

    /**
     * Constante que representa al tipo Especie.
     */
    public final static int ESPECIE = 8;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Constante de serialización de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Nombre del taxón.
     */
    private String nombre;

    /**
     * Tipo del taxón.
     */
    private int tipo;

    /**
     * Lista de los sub-taxones del taxón.
     */
    private ArrayList<Taxon> subTaxones;

    /**
     * Ser vivo del taxón.
     */
    private SerVivo serVivo;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Construye una taxón vacío. <br>
     * <b> post: </b> Se inicializa su tipo en LUCA. <br>
     * Se inicializa su nombre en "Último antepasado común universal". <br>
     * La lista de sub-taxones se inicializa vacía. <br>
     * Se inicializa el ser vivo en null.
     */
    public Taxon( )
    {
        tipo = LUCA;
        nombre = "Último antepasado común universal";

        subTaxones = new ArrayList<Taxon>( );
        serVivo = null;

        verificarInvariante( );
    }

    /**
     * Inicializa un Taxón con la información dada por parámetro. <br>
     * <b> post: </b> El taxón se inicializó con los valores de tipo y nombre dados por parámetro. <br>
     * La lista de sub-taxones se inicializa vacía y el ser vivo en null. <br>
     * @param pTipo Tipo del taxón. pTipo pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombre Nombre del taxón. pNombre != null && pNombre != "".
     */
    public Taxon( int pTipo, String pNombre )
    {
        tipo = pTipo;
        nombre = pNombre;

        subTaxones = new ArrayList<Taxon>( );
        serVivo = null;

        verificarInvariante( );
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el nombre del taxón.
     * @return Nombre del taxón.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el tipo del taxón.
     * @return Tipo del taxón.
     */
    public int darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna la lista de sub-taxones del taxón.
     * @return Lista de sub-taxones del taxón.
     */
    public ArrayList<Taxon> darSubTaxones( )
    {
        return subTaxones;
    }

    /**
     * Retorna el ser vivo del taxón.
     * @return Ser vivo del taxón.
     */
    public SerVivo darSerVivo( )
    {
        return serVivo;
    }

    /**
     * Retorna el número de taxones del sub-árbol que tiene al taxón actual como raíz. <br>
     * @return Número de taxones del sub-árbol que tiene al taxón actual como raíz.
     */
    public int darNumTaxones( )
    {
        // TODO Parte1 PuntoA Complete el método según la documentación dada.
    	if(darTipo() == ESPECIE)
    	{
    		return 1;
    	}
    	else
    	{
    		int pesoAcum = 1;
    		for( int i = 0; i  < darSubTaxones().size(); i++)
    		{
    			Taxon subTaxon = (Taxon) darSubTaxones().get(i);
    			pesoAcum += subTaxon.darNumTaxones();
    		}
    		return pesoAcum;
    	}
    	
    }

    /**
     * Retorna el número de seres vivos del sub-árbol que tiene al taxón actual como raíz. <br>
     * @return Número de seres vivos del sub-árbol que tiene al taxón actual como raíz.
     */
    public int darNumSeresVivos( )
    {
        // TODO Parte1 PuntoB Complete el método según la documentación dada.
    	if(darTipo() == ESPECIE && darSerVivo() != null)
    	{
    		return 1;
    	} 
    	else if(darTipo() == ESPECIE && darSerVivo() == null)
    	{
    		return 0;
    	}
    	else
    	{
    		int numeroSeresVivos = 0;
    		for(int i = 0; i <  darSubTaxones().size(); i++)
    		{
    			Taxon subTaxon = (Taxon) darSubTaxones().get(i);
    			numeroSeresVivos += subTaxon.darNumSeresVivos();
    		}
    		return numeroSeresVivos;
    	}
    }

    /**
     * Agrega un nuevo taxón a la lista de sub-taxones del taxón actual. <br>
     * <b> pre: </b> El taxón no es de tipo ESPECIE. <br>
     * <b> post: </b> Se ha agregado un nuevo taxón a la lista de sub-taxones.
     * @param pTipo Tipo del taxón. pTipo pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombreTaxon Nombre del taxón. pNombreTaxon != null && pNombreTaxon != "".
     */
    public void agregarSubTaxon( int pTipo, String pNombreTaxon )
    {
        Taxon nuevo = new Taxon( pTipo, pNombreTaxon );
        subTaxones.add( nuevo );
    }

    /**
     * Agrega un ser vivo al taxón actual. <br>
     * <b> pre: </b> El taxón es de tipo ESPECIE. <br>
     * <b> post: </b> El atributo serVivo ha sido inicializado con los valores dados por parámetro.
     * @param pNombreComun Nombre común del ser vivo. pNombreComun != null && pNombreComun != "".
     * @param pNombreCientifico Nombre científico del ser vivo. pNombreCientifico != null && pNombreCientifico != "".
     * @param pCaracteristicas Características del ser vivo. pCaracteristicas != null && pCaracteristicas != "".
     * @param pImagen Ruta con la imagen del ser vivo. pImagen != null && pImagen != "".
     * @throws Exception Si el taxón ya tiene un ser vivo asociado.
     */
    public void agregarSerVivo( String pNombreComun, String pNombreCientifico, String pCaracteristicas, String pImagen ) throws Exception
    {
        if( serVivo == null )
        {
            serVivo = new SerVivo( pNombreComun, pNombreCientifico, pCaracteristicas, pImagen );
            verificarInvariante( );
        }
        else
        {
            throw new Exception( "La especie " + nombre + " ya tiene un ser vivo asignado." );
        }
    }

    /**
     * Busca un taxón con el nombre dado por parámetro. <br>
     * @param pNombreTaxon Nombre del taxón a buscar. pNombreTaxon != null && pNombreTaxon != "".
     * @return Taxón con el nombre dado, null en caso de que no se encuentre.
     */
    public Taxon buscarTaxon( String pNombreTaxon )
    {
        // TODO Parte1 PuntoC Complete el método según la documentación dada.
    	if(nombre.equalsIgnoreCase(pNombreTaxon))
    	{
    		return this;
    	}
    	else
    	{
    		for(int i = 0; i < subTaxones.size(); i++)
    		{
    			Taxon taxonHijo = (Taxon) subTaxones.get(i);
    			Taxon taxonTemp = taxonHijo.buscarTaxon(pNombreTaxon);
    			if(taxonTemp != null)
    			{
    				return taxonTemp;
    			}   			
    		}
    		return null;
    	}    	
    }

    /**
     * Busca al ser vivo con el nombre científico dado por parámetro. <br>
     * @param pNombreCientifico Nombre científico del ser vivo a buscar. pNombreCientifico != null && pNombreCientifico != "".
     * @return Ser vivo con el nombre científico dado, null en caso de que no se encuentre.
     */
    public SerVivo buscarSerVivo( String pNombreCientifico )
    {
        // TODO Parte1 PuntoD Complete el método según la documentación dada.
    	if(darTipo() == ESPECIE)
    	{
    		SerVivo servivoBuscado = darSerVivo();
    		if (servivoBuscado !=null && servivoBuscado.darNombreCientifico().equals(pNombreCientifico))
    		{
    			return servivoBuscado;
    		}
    	}
    	else
    	{
    		for(Taxon actual: subTaxones)
    		{
    			SerVivo serVivoTemp = actual.buscarSerVivo(pNombreCientifico);
    			if(serVivoTemp != null)
    			{
    				return serVivoTemp;
    			}
    		}
    	}
    	return null;	
    }

    /**
     * Agrega los seres vivos del taxón o de sus sub-taxones a la lista dada por parámetro. <br>
     * @param pListaSeres La lista donde se agregan los seres vivos. pListaSeres != null.
     */
    public void buscarSeresVivos( ArrayList<SerVivo> pListaSeres )
    {
        // TODO Parte1 PuntoE Complete el método según la documentación dada.
    	if(darTipo() == ESPECIE && darSerVivo() != null)
    	{
    		pListaSeres.add(darSerVivo());
    	} 
    	else if(darTipo() == ESPECIE && darSerVivo() == null)
    	{
    	}
    	else if(darSubTaxones()!=null)
    	{
    		for(int i = 0; i <  darSubTaxones().size(); i++)
    		{
    			Taxon subTaxon = (Taxon) darSubTaxones().get(i);
    			subTaxon.buscarSeresVivos(pListaSeres);
    		}
    	}
    	
    }

    /**
     * Retorna una lista con el taxón actual y sus sub-taxones. <br>
     * Los taxones se agregan en preorden. <br>
     * @param pListaTaxones La lista de taxones donde se acumula la respuesta. pListaTaxones != null.
     */
    public void buscarTaxonesPreorden( ArrayList<Taxon> pListaTaxones )
    {
        // TODO Parte1 PuntoF Complete el método según la documentación dada.
    	pListaTaxones.add(this);
    	for(Taxon actual:subTaxones)
    	{
    		actual.buscarTaxonesPreorden(pListaTaxones);
    	}
    }

    /**
     * Retorna una lista con el taxón actual y sus sub-taxones. <br>
     * Los taxones se agregan en postorden. <br>
     * @param pListaTaxones La lista de taxones donde se acumula la respuesta. pListaTaxones != null.
     */
    public void buscarTaxonesPostorden( ArrayList<Taxon> pListaTaxones )
    {
        // TODO Parte1 PuntoG Complete el método según la documentación dada.
    	for(Taxon actual:subTaxones)
        {
    		if (actual.darSubTaxones() != null)
    			actual.buscarTaxonesPostorden(pListaTaxones);
    		else
    			pListaTaxones.add(actual);
        }
    	pListaTaxones.add(this);
    }

    /**
     * Retorna una lista con los nombres de los taxones del tipo dado por parámetro. <br>
     * @param pTipo Tipo del taxón que se quiere buscar. pTipo pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pListaTaxones La lista de los nombres donde se acumula la respuesta. pListaTaxones != null.
     */
    public void buscarTaxonesNivel( int pTipo, ArrayList<String> pListaTaxones )
    {
        // TODO Parte1 PuntoH Complete el método según la documentación dada.
    	ArrayList<Taxon> listaPreorden = new ArrayList<Taxon>();
    	buscarTaxonesPreorden(listaPreorden);
    	for(Taxon actual: listaPreorden)
    	{
    		if(actual.darTipo()==pTipo)
    		{
    			pListaTaxones.add(actual.darNombre());
    		}
    	}
    }

    /**
     * Retorna el taxón con el nombre dado y tipo dados por parámetro. <br>
     * @param pTipo Tipo del taxón que se quiere buscar. pTipo pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombreTaxon Nombre del taxón buscado. pNombreTaxon != null && pNombreTaxon != "".
     * @return Taxón con nombre dado y cuyo nivel se encuentra en la distancia dada, null en caso de que no se encuentre.
     */
    public Taxon buscarTaxonNivel( int pTipo, String pNombreTaxon )
    {
        // TODO Parte1 PuntoI Complete el método según la documentación dada.
    	if(nombre.equalsIgnoreCase(pNombreTaxon) && darTipo() == pTipo)
    	{
    		return this;
    	}
    	else
    	{
    		for(int i = 0; i < subTaxones.size(); i++)
    		{
    			Taxon taxonHijo = (Taxon) subTaxones.get(i);
    			Taxon taxonTemp = taxonHijo.buscarTaxonNivel(pTipo, pNombreTaxon);
    			if(taxonTemp != null)
    			{
    				return taxonTemp;
    			}   			
    		}
    		return null;
    	}   
    }

    /**
     * Elimina un taxón del sub-árbol que tiene como raíz al taxón actual. <br>
     * <b> pre: </b> El taxón padre y el taxón a eliminar existen. <br>
     * <b> post: </b> Se eliminó el taxón del sub-árbol. <br>
     * Si el taxón que se eliminó tenía sub-taxones, estos también fueron eliminados. <br>
     * @param pTipo Tipo del taxón que se quiere eliminar. pTipo pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombreTaxon Nombre del taxón a eliminar. pNombreTaxon != null && pNombreTaxon != "".
     */
    public void eliminarTaxon( int pTipo, String pNombreTaxon )
    {
        // TODO Parte1 PuntoJ Complete el método según la documentación dada.
    	ArrayList<Taxon> listaPreorden = new ArrayList<Taxon>();
    	ArrayList<Taxon> listaNivelPadre= new ArrayList<Taxon>();
    	buscarTaxonesPreorden(listaPreorden);
    	for(Taxon actual: listaPreorden)
    	{
    		if(actual.darTipo()==pTipo-1)
    		{
    			listaNivelPadre.add(actual);
    		}
    	}
    	for(Taxon taxonPadre: listaNivelPadre)
    	{
    		if(taxonPadre.darSubTaxones()!=null)
    		{
    			for(Taxon taxonHijo: taxonPadre.darSubTaxones())
    			{
    				if(taxonHijo.darNombre().equals(pNombreTaxon))
    				{
    					taxonPadre.darSubTaxones().remove(taxonHijo);
    					break;
    				}
    			}
    		}else{}
    	}
    }

    /**
     * Retorna una cadena con el tipo y el nombre del taxón.
     * @return La representación del taxón en String: <tipo del taxón>: <nombre del taxón>.
     */
    public String toString( )
    {
        String toString = darNombreTipo( ) + ": " + nombre;
        return toString;
    }

    /**
     * Retorna el nombre del tipo del taxón.
     * @return Nombre del tipo del taxón.
     */
    private String darNombreTipo( )
    {
        String nombreTipo = "";

        if( tipo == LUCA )
        {
            nombreTipo = "LUCA";
        }
        else if( tipo == DOMINIO )
        {
            nombreTipo = "Dominio";
        }
        else if( tipo == REINO )
        {
            nombreTipo = "Reino";
        }
        else if( tipo == FILO )
        {
            nombreTipo = "Filo";
        }
        else if( tipo == CLASE )
        {
            nombreTipo = "Clase";
        }
        else if( tipo == ORDEN )
        {
            nombreTipo = "Orden";
        }
        else if( tipo == FAMILIA )
        {
            nombreTipo = "Familia";
        }
        else if( tipo == GENERO )
        {
            nombreTipo = "Género";
        }
        else
        {
            nombreTipo = "Especie";
        }

        return nombreTipo;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica la invariante de la clase <br>
     * <b> inv: </b> <br>
     * nombre != null && nombre != "". <br>
     * tipo pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}. <br>
     * La lista de subtaxones está inicializada. <br>
     * Si el tipo del taxón no es ESPECIE no puede tener un ser vivo. <br>
     * Si el tipo del taxón es ESPECIE no puede tener sub-taxones. <br>
     * El tipo de los sub-taxones corresponde al siguiente tipo en la jerarquía taxonómica. <br>
     */
    private void verificarInvariante( )
    {
        assert nombre != null && !nombre.isEmpty( ) : "El nombre del taxón debe ser inicializado.";
        assert tipo == LUCA || tipo == DOMINIO || tipo == REINO || tipo == FILO || tipo == CLASE || tipo == ORDEN || tipo == FAMILIA || tipo == GENERO || tipo == ESPECIE : "El tipo del taxón debe ser inicializado correctamente.";
        assert subTaxones != null : "La lista de sub-taxones debe estar inicializada.";

        if( tipo != ESPECIE )
        {
            assert serVivo == null : "El taxón no debería tener un ser vivo.";
        }
        else
        {
            assert subTaxones.isEmpty( ) : "El taxón no debería tener sub-taxones.";
        }

        for( int i = 0; i < subTaxones.size( ); i++ )
        {
            Taxon taxon = ( Taxon )subTaxones.get( i );
            assert taxon.tipo == tipo + 1 : "El tipo de los sub-taxones es incorrecto.";
        }
    }
}