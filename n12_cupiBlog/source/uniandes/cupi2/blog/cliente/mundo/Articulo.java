/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_cupiBlog
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.blog.cliente.mundo;

import java.util.Date;

/**
 * La clase que representa un artículo del blog.<br>
 * <b>inv:</b><br>
 * usuario != null && !usuario.equals(""). <br>
 * titulo != null && !titulo.equals(""). <br>
 * categoria != null && categoria pertenece a alguna constante del arreglo CATEGORIAS. <br>
 * contenido != null && !contenido.equals(""). <br>
 * fechaPublicacion != null. <br>
 */
public class Articulo
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Arreglo de constantes que representan las posibles categorías del artículo.
     */
    public final static String[] CATEGORIAS = { "Música", "Televisión", "Cine", "Mascotas", "Comics", "Viajes", "Vida diaria", "Otros" };

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Login del usuario que publicó del artículo.
     */
    private String loginUsuario;

    /**
     * Título del artículo.
     */
    private String titulo;

    /**
     * Categoría del artículo.
     */
    private String categoria;

    /**
     * Texto del contenido del artículo.
     */
    private String contenido;

    /**
     * Fecha de publicación del artículo.
     */
    private Date fechaPublicacion;
    
    /**
     * Calificación acumulada del artículo.
     */
    private int calificacionAcumulada;
    
    /**
     * Cantidad de veces que el artículo ha sido calificado.
     */
    private int vecesCalificado;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Inicializa el artículo del blog con la información dada por parámetro. <br>
     * <b> post: </b> El artículo del blog se construyó con los valores de usuario, título, categoría, contenido y fecha de publicación dados por parámetro. <br>
     * @param pLoginUsuario Login del usuario autor del artículo. pUsuario != null && pUsuario != "".
     * @param pTitulo Título del artículo. pTitulo != null && pTitulo != "".
     * @param pCategoria Categoría del artículo. pCategoria != null && pCategoria pertenece a CATEGORIAS.
     * @param pContenido Texto con el contenido del artículo. pContenido != null && pContenido != "".
     * @param pFechaPublicacion Fecha de publicación del artículo. pFechaPublicacion != null.
     * @param pCalificacionAcumulada Calificación acumulada del artículo. pCalificacionAcumulada >= 0.
     * @param pVecesCalificado Veces que se ha calificado el artículo. pVecesCalificado >= 0.
     */
    public Articulo( String pLoginUsuario, String pTitulo, String pCategoria, String pContenido, Date pFechaPublicacion, int pCalificacionAcumulada, int pVecesCalificado )
    {
        loginUsuario = pLoginUsuario;
        titulo = pTitulo;
        categoria = pCategoria;
        contenido = pContenido;
        fechaPublicacion = pFechaPublicacion;
        calificacionAcumulada = pCalificacionAcumulada;
        vecesCalificado = pVecesCalificado;

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el login del usuario autor del artículo.
     * @return Login del usuario autor del artículo.
     */
    public String darLoginUsuario( )
    {
        return loginUsuario;
    }

    /**
     * Retorna el título del artículo.
     * @return Título del artículo.
     */
    public String darTitulo( )
    {
        return titulo;
    }
    
    /**
     * Retorna la calificación acumulada.
     * @return Calificación acumulada del artículo.
     */
    public int darCalificacionAcumulada( )
    {
        return calificacionAcumulada;
    }

    /**
     * Retorna la categoría del artículo.
     * @return Categoría del artículo.
     */
    public String darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna el texto del contenido del artículo.
     * @return Contenido del artículo.
     */
    public String darContenido( )
    {
        return contenido;
    }

    /**
     * Retorna la fecha de publicación del artículo.
     * @return Fecha de publicación del artículo.
     */
    public Date darFechaPublicacion( )
    {
        return fechaPublicacion;
    }
    
    /**
     * Retorna las veces que ha sido calificado el artículo.
     * @return Retorna las veces que el artículo ha sido calificado.
     */
    public int darVecesCalificado( )
    {
        return vecesCalificado;
    }
    
    /**
     * Retorna el promedio de calificaciones del artículo.
     * @return Promedio de calificaciones.
     */
    public double darPromedioCalificaciones( )
    {
        double promedio = 0;
        if( vecesCalificado != 0 )
        {
            promedio = ( double ) calificacionAcumulada / vecesCalificado;
        }
        return promedio;
    }

    /**
     * Retorna una cadena con el título del artículo y el usuario autor.
     * @return La representación del artículo en String: <titulo> ( Por: <usuario> ).
     */
    public String toString( )
    {
        return titulo + " ( Por: " + loginUsuario + " )";
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Revisa la invariante de la clase.<br>
     * <b>inv:</b><br>
     * usuario != null && !usuario.equals(""). <br>
     * titulo != null && !titulo.equals(""). <br>
     * categoria != null && categoria pertenece a alguna constante del arreglo CATEGORIAS. <br>
     * contenido != null && !contenido.equals(""). <br>
     * fechaPublicacion != null. <br>
     */
    private void verificarInvariante( )
    {
        assert loginUsuario != null && !loginUsuario.equals( "" ) : "El usuario autor del artículo no puede tener un valor nulo o vacío.";
        assert titulo != null && !titulo.equals( "" ) : "El título del artículo no puede tener un valor nulo o vacío.";
        assert categoria != null && !categoria.equals( "" ) && categoriaPerteneceAArreglo( ) : "La categoría del artículo no tiene un valor válido.";
        assert contenido != null && !contenido.equals( "" ) : "El contenido del artículo no puede tener un valor nulo o vacío.";
        assert fechaPublicacion != null : "La fecha de publicación del artículo no puede tener un valor nulo.";
    }

    /**
     * Indica si la categoría pertenece al arreglo CATEGORIAS.
     * @return true si la categoría pertenece al arreglo CATEGORIAS. False de lo contrario.
     */
    private boolean categoriaPerteneceAArreglo( )
    {
        boolean pertenece = false;

        for( int i = 0; i < CATEGORIAS.length; i++ )
        {
            if( categoria.equals( CATEGORIAS[ i ] ) )
            {
                pertenece = true;
            }
        }

        return pertenece;
    }

}