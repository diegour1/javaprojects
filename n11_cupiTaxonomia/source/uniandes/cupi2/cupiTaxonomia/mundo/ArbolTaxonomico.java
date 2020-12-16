/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase que representa el �rbol taxon�mico. <br>
 * <b> inv: </b> <br>
 * taxonRaiz != null.
 */
public class ArbolTaxonomico
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Tax�n ra�z del �rbol taxon�mico.
     */
    private Taxon taxonRaiz;

    /**
     * Ruta del archivo donde se guardar� la informaci�n del �rbol taxon�mico.
     */
    private String archivoTaxonomia;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Constructor del �rbol taxon�mico.<br>
     * <b>post: </b> El atributo archivoTaxonomia se inicializa con la ruta de archivo dada por par�metro. <br>
     * Si existe el archivo en la ruta dada por par�metro, se crea la clase a partir la informaci�n en ese archivo. <br>
     * Si el archivo no existe, se inicializa el tax�n ra�z. <br>
     * @param pRutaArchivo La ruta del archivo del cual se carga la informaci�n del �rbol taxon�mico. pRutaArchivo != null && pRutaArchivo != "".
     * @throws Exception Si no se puede abrir o leer el archivo con el estado del �rbol taxon�mico.
     */
    public ArbolTaxonomico( String pRutaArchivo ) throws Exception
    {
        archivoTaxonomia = pRutaArchivo;
        File file = new File( archivoTaxonomia );

        // Si el archivo existe: se debe recuperar de all� el estado
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
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el n�mero de taxones del �rbol taxon�mico. <br>
     * @return N�mero de taxones del �rbol taxon�mico.
     */
    public int darNumTaxones( )
    {
        // TODO Parte2 PuntoC Complete el m�todo seg�n la documentaci�n dada.
    	return taxonRaiz.darNumTaxones();
    }

    /**
     * Retorna el n�mero de seres vivos del �rbol taxon�mico. <br>
     * @return N�mero de seres vivos del �rbol taxon�mico.
     */
    public int darNumSeresVivos( )
    {
        // TODO Parte2 PuntoD Complete el m�todo seg�n la documentaci�n dada.
    	return taxonRaiz.darNumSeresVivos();
    }

    /**
     * Retorna la lista de seres vivos del tax�n con el nombre y tipo dado. <br>
     * <b> pre: </b> El tax�n con el nombre y el tipo dado existen.
     * @param pTipoTaxon Tipo del tax�n. pTipoTaxon pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombreTaxon Nombre del tax�n. pNombreTaxon != null y pNombreTaxon != "".
     * @return Lista de seres vivos que pertenecen a ese tax�n.
     */
    public ArrayList<SerVivo> darSeresVivos( int pTipoTaxon, String pNombreTaxon )
    {
        // TODO Parte2 PuntoE Complete el m�todo seg�n la documentaci�n dada.
        ArrayList<SerVivo> listaSeres = new ArrayList<SerVivo>();
        Taxon taxonActual = taxonRaiz.buscarTaxon(pNombreTaxon);
        taxonActual.buscarSeresVivos(listaSeres);
        return listaSeres;
    }

    /**
     * Retorna el tax�n ra�z del �rbol taxon�mico.
     * @return Tax�n ra�z del �rbol taxon�mico.
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
        // TODO Parte2 PuntoF Complete el m�todo seg�n la documentaci�n dada.
        // Recuerde que el nivel del tax�n est� dado por su tipo.
    	ArrayList<String> listaTaxonesTipo = new ArrayList<String>();
    	taxonRaiz.buscarTaxonesNivel(pTipoTaxon, listaTaxonesTipo);
    	return listaTaxonesTipo;
    }

    /**
     * Retorna la lista de taxones del �rbol taxon�mico. Los taxones de agregan en preorden. <br>
     * @return Lista de taxones del �rbol taxon�mico en preorden.
     */
    public ArrayList<Taxon> darTaxonesPreorden( )
    {
        // TODO Parte2 PuntoG Complete el m�todo seg�n la documentaci�n dada.
    	ArrayList<Taxon> listaTaxones = new ArrayList<Taxon>();
    	taxonRaiz.buscarTaxonesPreorden(listaTaxones);
    	return listaTaxones;
    }

    /**
     * Retorna la lista de taxones del �rbol taxon�mico Los taxones de agregan en postorden. <br>
     * @return Lista de taxones del �rbol taxon�mico en postorden.
     */
    public ArrayList<Taxon> darTaxonesPostorden( )
    {
        // TODO Parte2 PuntoH Complete el m�todo seg�n la documentaci�n dada.
    	ArrayList<Taxon> listaTaxones = new ArrayList<Taxon>();
    	taxonRaiz.buscarTaxonesPostorden(listaTaxones);
    	return listaTaxones;
    }

    /**
     * Agrega un ser vivo a un tax�n del �rbol taxon�mico. <br>
     * <b> pre: </b> El tax�n existe y es de tipo ESPECIE. <br>
     * <b> post: </b> Se ha agregado un nuevo ser vivo a un tax�n del �rbol taxon�mico.
     * @param pNombreTaxon Nombre del tax�n al que se va a agregar el ser vivo. pNombreTaxon != null && pNombreTaxon != "".
     * @param pNombreComun Nombre com�n del ser vivo a agregar. pNombreComun != null && pNombreComun != "".
     * @param pNombreCientifico Nombre cient�fico del ser vivo a agregar. pNombreCientifico != null && pNombreCientifico != "".
     * @param pCaracteristicas Caracter�sticas del ser vivo a agregar. pCaracteristicas != null && pCaracteristicas != "".
     * @param pImagen Ruta con la imagen del ser vivo a agregar. pImagen != null y pImagen != "".
     * @throws Exception Si ya existe un ser vivo con el nombre cient�fico dado.
     * @throws Exception Si el tax�n ya tiene un ser vivo.
     */
    public void agregarSerVivo( String pNombreTaxon, String pNombreComun, String pNombreCientifico, String pCaracteristicas, String pImagen ) throws Exception
    {
        // TODO Parte2 PuntoA Complete el m�todo seg�n la documentaci�n dada.
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
     * Agrega un nuevo sub-tax�n al tax�n con el nombre dado. <br>
     * <p> pre: </b> El tipo del tax�n hijo es mayor al tipo del tax�n padre. <br>
     * <b> post: </b> Se agreg� un nuevo tax�n al �rbol taxon�mico.
     * @param pNombreTaxonPadre Nombre del tax�n padre del tax�n a agregar. pNombreTaxonPadre != null && pNombreTaxonPadre != "".
     * @param pTipoTaxonHijo Tipo del tax�n a agregar. pTipoTaxonHijo pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombreTaxonHijo Nombre del tax�n a agregar. pNombreTaxonHijo != null && pNombreTaxonHijo != "".
     * @throws Exception Si ya existe un tax�n con el nombre dado.
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
            throw new Exception( "Ya existe un tax�n con el nombre " + pNombreTaxonHijo + "." );
        }
        verificarInvariante( );
    }

    /**
     * Elimina el tax�n con el nombre y el tipo dado del �rbol taxon�mico. <br>
     * <b> pre: </b> El tax�n a eliminar existe. <br>
     * <b> post: </b> Se elimin� el tax�n del �rbol taxon�mico.
     * @param pTipoTaxon Tipo del tax�n a eliminar. pTipoTaxon pertenece a {LUCA, DOMINIO, REINO, FILO, CLASE, ORDEN, FAMILIA, GENERO, ESPECIE}.
     * @param pNombreTaxon Nombre del tax�n a eliminar. pNombreTaxon != null && pNombreTaxon != "".
     */
    public void eliminarTaxon( int pTipoTaxon, String pNombreTaxon )
    {
        // TODO Parte2 PuntoB Complete el m�todo seg�n la documentaci�n dada.
    	taxonRaiz.eliminarTaxon(pTipoTaxon, pNombreTaxon);
    }

    /**
     * Guarda el estado actual del �rbol taxon�mico. <br>
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
        assert taxonRaiz != null : "El tax�n ra�z debe se diferente de null.";
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return respuesta1.
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