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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase que representa el árbol taxonómico. <br>
 * <b> inv: </b> <br>
 * taxonRaiz != null.
 */
public class ArbolTaxonomico
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Taxón raíz del árbol taxonómico.
     */
    private Taxon taxonRaiz;

    /**
     * Ruta del archivo donde se guardará la información del árbol taxonómico.
     */
    private String archivoTaxonomia;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Constructor del árbol taxonómico.<br>
     * <b>post: </b> El atributo archivoTaxonomia se inicializa con la ruta de archivo dada por parámetro. <br>
     * Si existe el archivo en la ruta dada por parámetro, se crea la clase a partir la información en ese archivo. <br>
     * Si el archivo no existe, se inicializa el taxón raíz. <br>
     * @param pRutaArchivo La ruta del archivo del cual se carga la información del árbol taxonómico. pRutaArchivo != null && pRutaArchivo != "".
     * @throws Exception Si no se puede abrir o leer el archivo con el estado del árbol taxonómico.
     */
    public ArbolTaxonomico( String pRutaArchivo ) throws Exception
    {
        archivoTaxonomia = pRutaArchivo;
        File file = new File( archivoTaxonomia );

        // Si el archivo existe: se debe recuperar de allí el estado
        if( file.exists( ) )
        {
            try
            {
                ObjectInputStream ois = new ObjectInputStream( new FileInputStream( file ) );
                taxonRaiz = ( Taxon )ois.readObject( );
                ois.close( );
                verificarInvariante( );
            }
            catch( Exception e )
            {
                throw new Exception( "Error fatal: imposible restaurar el estado del programa (" + e.getMessage( ) + ")." );
            }
        }
        else
        {
            taxonRaiz = new Taxon( );
            verificarInvariante( );
        }
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el número de taxones del árbol taxonómico. <br>
     * @return Número de taxones del árbol taxonómico.
     */
    public int darNumTaxones( )
    {
        // TODO Parte2 PuntoC Complete el método según la documentación dada.
    	return taxonRaiz.darNumTaxones();
    }

    /**
     * Retorna el número de seres vivos del árbol taxonómico. <br>
     * @return Número de seres vivos del árbol taxonómico.
     */
    public int darNumSeresVivos( )
    {
        // TODO Parte2 PuntoD Complete el método según la documentación dada.
    	return taxonRaiz.darNumSeresVivos();
    }

    /**
     * Retorna la lista de seres vivos del taxón con el nombre y tipo dado. <br>
     * <b> pre: </b> El taxón con el nombre y el tipo dado existen.
     * @param pTipoTaxon Tipo del taxón. pTipoTaxon pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombreTaxon Nombre del taxón. pNombreTaxon != null y pNombreTaxon != "".
     * @return Lista de seres vivos que pertenecen a ese taxón.
     */
    public ArrayList<SerVivo> darSeresVivos( int pTipoTaxon, String pNombreTaxon )
    {
        // TODO Parte2 PuntoE Complete el método según la documentación dada.
        ArrayList<SerVivo> listaSeres = new ArrayList<SerVivo>();
        Taxon taxonActual = taxonRaiz.buscarTaxon(pNombreTaxon);
        taxonActual.buscarSeresVivos(listaSeres);
        return listaSeres;
    }

    /**
     * Retorna el taxón raíz del árbol taxonómico.
     * @return Taxón raíz del árbol taxonómico.
     */
    public Taxon darTaxonRaiz( )
    {
        return taxonRaiz;
    }


    /**
     * Retorna la lista con los nombres de los taxones del tipo dado.
     * @param pTipoTaxon Tipo de los taxones. pTipoTaxon pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @return Lista con los nombres de los taxones del tipo dado.
     */
    public ArrayList<String> darTaxonesTipo( int pTipoTaxon )
    {
        // TODO Parte2 PuntoF Complete el método según la documentación dada.
        // Recuerde que el nivel del taxón está dado por su tipo.
    	ArrayList<String> listaTaxonesTipo = new ArrayList<String>();
    	taxonRaiz.buscarTaxonesNivel(pTipoTaxon, listaTaxonesTipo);
    	return listaTaxonesTipo;
    }

    /**
     * Retorna la lista de taxones del árbol taxonómico. Los taxones de agregan en preorden. <br>
     * @return Lista de taxones del árbol taxonómico en preorden.
     */
    public ArrayList<Taxon> darTaxonesPreorden( )
    {
        // TODO Parte2 PuntoG Complete el método según la documentación dada.
    	ArrayList<Taxon> listaTaxones = new ArrayList<Taxon>();
    	taxonRaiz.buscarTaxonesPreorden(listaTaxones);
    	return listaTaxones;
    }

    /**
     * Retorna la lista de taxones del árbol taxonómico Los taxones de agregan en postorden. <br>
     * @return Lista de taxones del árbol taxonómico en postorden.
     */
    public ArrayList<Taxon> darTaxonesPostorden( )
    {
        // TODO Parte2 PuntoH Complete el método según la documentación dada.
    	ArrayList<Taxon> listaTaxones = new ArrayList<Taxon>();
    	taxonRaiz.buscarTaxonesPostorden(listaTaxones);
    	return listaTaxones;
    }

    /**
     * Agrega un ser vivo a un taxón del árbol taxonómico. <br>
     * <b> pre: </b> El taxón existe y es de tipo ESPECIE. <br>
     * <b> post: </b> Se ha agregado un nuevo ser vivo a un taxón del árbol taxonómico.
     * @param pNombreTaxon Nombre del taxón al que se va a agregar el ser vivo. pNombreTaxon != null && pNombreTaxon != "".
     * @param pNombreComun Nombre común del ser vivo a agregar. pNombreComun != null && pNombreComun != "".
     * @param pNombreCientifico Nombre científico del ser vivo a agregar. pNombreCientifico != null && pNombreCientifico != "".
     * @param pCaracteristicas Características del ser vivo a agregar. pCaracteristicas != null && pCaracteristicas != "".
     * @param pImagen Ruta con la imagen del ser vivo a agregar. pImagen != null y pImagen != "".
     * @throws Exception Si ya existe un ser vivo con el nombre científico dado.
     * @throws Exception Si el taxón ya tiene un ser vivo.
     */
    public void agregarSerVivo( String pNombreTaxon, String pNombreComun, String pNombreCientifico, String pCaracteristicas, String pImagen ) throws Exception
    {
        // TODO Parte2 PuntoA Complete el método según la documentación dada.
    	if(taxonRaiz.buscarSerVivo(pNombreCientifico) != null)
    	{
    		throw new Exception("Ya existe un ser vivo con el nombre cientifico dado");
    	}
    	else if (taxonRaiz.buscarTaxon(pNombreTaxon).darSerVivo() != null)
    	{
    		throw new Exception("El Taxon ya tiene asignado un ser vivo");
    	}
    	else
    	{
    		Taxon taxonPadre = taxonRaiz.buscarTaxon(pNombreTaxon);
    		taxonPadre.agregarSerVivo(pNombreComun, pNombreCientifico, pCaracteristicas, pImagen);
    	}
    	verificarInvariante();
    }

    /**
     * Agrega un nuevo sub-taxón al taxón con el nombre dado. <br>
     * <p> pre: </b> El tipo del taxón hijo es mayor al tipo del taxón padre. <br>
     * <b> post: </b> Se agregó un nuevo taxón al árbol taxonómico.
     * @param pNombreTaxonPadre Nombre del taxón padre del taxón a agregar. pNombreTaxonPadre != null && pNombreTaxonPadre != "".
     * @param pTipoTaxonHijo Tipo del taxón a agregar. pTipoTaxonHijo pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombreTaxonHijo Nombre del taxón a agregar. pNombreTaxonHijo != null && pNombreTaxonHijo != "".
     * @throws Exception Si ya existe un taxón con el nombre dado.
     */
    public void agregarTaxon( String pNombreTaxonPadre, int pTipoTaxonHijo, String pNombreTaxonHijo ) throws Exception
    {
        Taxon taxon = taxonRaiz.buscarTaxon( pNombreTaxonHijo );
        if( taxon == null )
        {
            Taxon padre = taxonRaiz.buscarTaxonNivel( pTipoTaxonHijo - 1, pNombreTaxonPadre );
            padre.agregarSubTaxon( pTipoTaxonHijo, pNombreTaxonHijo );
        }
        else
        {
            throw new Exception( "Ya existe un taxón con el nombre " + pNombreTaxonHijo + "." );
        }
        verificarInvariante( );
    }

    /**
     * Elimina el taxón con el nombre y el tipo dado del árbol taxonómico. <br>
     * <b> pre: </b> El taxón a eliminar existe. <br>
     * <b> post: </b> Se eliminó el taxón del árbol taxonómico.
     * @param pTipoTaxon Tipo del taxón a eliminar. pTipoTaxon pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombreTaxon Nombre del taxón a eliminar. pNombreTaxon != null && pNombreTaxon != "".
     */
    public void eliminarTaxon( int pTipoTaxon, String pNombreTaxon )
    {
        // TODO Parte2 PuntoB Complete el método según la documentación dada.
    	taxonRaiz.eliminarTaxon(pTipoTaxon, pNombreTaxon);
    }

    /**
     * Guarda el estado actual del árbol taxonómico. <br>
     * @param pRutaArchivo Ruta del archivo en donde se va a guardar el estado del mundo. pRutaArchivo != null & pRutaArchivo != "".
     * @throws Exception Si hay problemas al tratar de guardar el estado actual.
     */
    public void guardar( String pRutaArchivo ) throws Exception
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( pRutaArchivo ) );
            oos.writeObject( taxonRaiz );
            oos.close( );
        }
        catch( IOException e )
        {
            throw new Exception( "Error al salvar: " + e.getMessage( ) + "." );
        }
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica la invariante de la clase <br>
     * <b> inv: </b><br>
     * taxonRaiz != null <br>
     */
    private void verificarInvariante( )
    {
        assert taxonRaiz != null : "El taxón raíz debe se diferente de null.";
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

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