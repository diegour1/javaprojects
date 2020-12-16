/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_CupiBlog
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.blog.cliente.mundo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Clase que representa a un cliente del blog.<br>
 * <b>inv: </b><br>
 * manejadorEventos != null. <br>
 * La lista de artículos está inicializada. <br>
 */
public class ClienteBlog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Usuario del blog.
     */
    private Usuario usuario;

    /**
     * Artículo actual.
     */
    private Articulo articuloActual;

    /**
     * Lista de artículos que se han publicado.
     */
    private ArrayList<Articulo> articulos;

    /**
     * Observador de eventos del cliente.
     */
    private IObservadorEventos observadorEventos;

    /**
     * Manejador de la comunicación con el servidor.
     */
    private ManejadorComunicacionServidor comunicacion;

    /**
     * Dirección IP del servidor.
     */
    private String ipServidor;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * El constructor del cliente del blog. <br>
     * <b> post: </b> Los atributos observadoEventos e IpServidor se inicializaron con los valores dados por parámetro. <br>
     * El usuario y el artículo actual se inicializaron en null. <br>
     * La lista de artículos quedó inicializada. <br>
     * @param pObservador El observador de los eventos del cliente. pObservador != null.
     * @param pIpServidor La dirección IP del servidor al cual se va a conectar el cliente. pIpSevidor != null && pIpServidor != "".
     */
    public ClienteBlog( IObservadorEventos pObservador, String pIpServidor )
    {
        observadorEventos = pObservador;
        usuario = null;
        articuloActual = null;
        ipServidor = pIpServidor;

        articulos = new ArrayList<Articulo>( );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna al usuario del blog.
     * @return Usuario del blog.
     */
    public Usuario darUsuario( )
    {
        return usuario;
    }

    /**
     * Retorna el artículo actual.
     * @return Artículo actual.
     */
    public Articulo darArticuloActual( )
    {
        return articuloActual;
    }

    /**
     * Retorna la lista de artículos publicados del blog.
     * @return Lista de artículos publicados.
     */
    public ArrayList<Articulo> darListaArticulos( )
    {
        return articulos;
    }

    /**
     * Modifica al usuario del blog por el dado por parámetro. <br>
     * <b> post: </b> El usuario fue modificado por el usuario dado por parámetro.
     * @param pUsuario El nuevo usuario cliente. pUsuario != null.
     */
    public void modificarUsuario( Usuario pUsuario )
    {
        usuario = pUsuario;
    }

    /**
     * Modifica el artículo actual por el dado por parámetro. <br>
     * <b> post: </b> El artículo actual fue modificado por el dado por parámetro.
     * @param pArticuloActual El nuevo artículo. pArticuloActual != null.
     */
    public void modificarArticuloActual( Articulo pArticuloActual )
    {
        articuloActual = pArticuloActual;
    }

    /**
     * Modifica el contenido de la lista de artículos. <br>
     * <b> post: </b> La lista de artículos fue modificada por la lista dada por parámetro.
     * @param pArticulos La nueva lista de artículos. pArticulos != null.
     */
    public void modificarListaArticulos( ArrayList<Articulo> pArticulos )
    {
        articulos.clear( );
        articulos.addAll( pArticulos );
        observadorEventos.actualizarListaArticulos( articulos );
    }

    /**
     * Reinicia el estado del cliente. <br>
     * <b> post: </b> Los valores de usuario y articuloActual son nulos. <br>
     * La lista de artículos ya no tiene elementos.
     */
    public void reiniciar( )
    {
        usuario = null;
        articuloActual = null;

        articulos.clear( );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos de conexión
    // -----------------------------------------------------------------

    /**
     * Establece la conexión con el servidor. <br>
     * @throws CupiBlogComunicacionException Si no puede establecer una conexión con el servidor.
     */
    private void iniciarConexion( ) throws CupiBlogComunicacionException
    {
        try
        {
            Socket socket = new Socket( );
            socket.connect( new InetSocketAddress( ipServidor, 9999 ), 5000 );
            comunicacion = new ManejadorComunicacionServidor( this, socket );
        }
        catch( UnknownHostException e )
        {
            throw new CupiBlogComunicacionException( "No hay conexión con el host." );
        }
        catch( IOException e )
        {
            String mensaje = "No se pudo establecer la conexión con el servidor.";
            if( e.getMessage( ).equals( "connect timed out" ) )
            {
                mensaje += " El servidor no está disponible. \n Inténtelo de nuevo más tarde, o con otra dirección IP.";
            }
            throw new CupiBlogComunicacionException( mensaje );
        }
    }
    /**
     * Inicia la sesión del usuario. <br>
     * Si la comunicación con el servidor no existe, debe crearla.
     * @param pLoginUsuario El login del usuario que va a iniciar sesión. pLoginUsuario != null && pLoginUsuario != "".
     * @throws CupiBlogComunicacionException Si no se puede establecer una conexión con el servidor.
     * @throws CupiBlogProtocoloException Si no se cumple con el protocolo establecido.
     */
    public void iniciarSesion( String pLoginUsuario ) throws CupiBlogComunicacionException, CupiBlogProtocoloException
    {
        if( comunicacion == null )
        {
            iniciarConexion( );
        }
        reiniciar( );
        comunicacion.iniciarSesion( pLoginUsuario );
        listarArticulos( );
    }

    /**
     * Busca los artículos que pertenecen a la categoría dada por parámetro.<br>
     * <b>pre: </b>La comunicación con el servidor debe estar establecida.<br>
     * @param pCategoria La categoría deseada. pCategoria != null && pCategoria pertenece a Articulo.CATEGORIAS.
     * @throws CupiBlogComunicacionException Si no se puede establecer una conexión con el servidor.
     * @throws CupiBlogProtocoloException Si no se cumple con el protocolo establecido.
     */
    public void buscarArticulosCategoria( String pCategoria ) throws CupiBlogComunicacionException, CupiBlogProtocoloException
    {
        comunicacion.buscarArticulosCategoria( pCategoria );
    }

    /**
     * Califica al artículo dado con la calificación dada.<br>
     * <b>pre: </b>La comunicación con el servidor debe estar establecida.<br>
     * @param pCalificacion Calificación del artículo. pCalificacion >= 0 && pCalificacion <= 5.
     * @throws CupiBlogComunicacionException Si no se puede establecer una conexión con el servidor.
     * @throws CupiBlogProtocoloException Si no se cumple con el protocolo establecido.
     */
    public void calificarArticulo( int pCalificacion ) throws CupiBlogComunicacionException, CupiBlogProtocoloException
    {
        comunicacion.calificarArticulo( articuloActual, pCalificacion );
    }

    /**
     * Lista todos los artículos del blog por orden cronológico.<br>
     * <b>pre: </b> La comunicación con el servidor debe estar establecida. <br>
     * @throws CupiBlogComunicacionException Si no se puede establecer una conexión con el servidor.
     * @throws CupiBlogProtocoloException Si no se cumple con el protocolo establecido.
     */
    public void listarArticulos( ) throws CupiBlogComunicacionException, CupiBlogProtocoloException
    {
        comunicacion.solicitarListaArticulos( );
    }

    /**
     * Publica un nuevo artículo con título, categoría y contenido dados.<br>
     * <b> pre: </b> La comunicación con el servidor debe estar establecida.<br>
     * @param pTitulo Título del artículo. pTitulo != null && pTitulo != "".
     * @param pCategoria Categoría del artículo. pCategoria != null && pCategoria pertenece a Articulo.CATEGORIAS.
     * @param pContenido Contenido del artículo. pContenido != null && pContenido != "".
     * @throws CupiBlogComunicacionException Si no se puede establecer una conexión con el servidor.
     * @throws CupiBlogProtocoloException Si no se cumple con el protocolo establecido.
     */
    public void publicarArticulo( String pTitulo, String pCategoria, String pContenido ) throws CupiBlogComunicacionException, CupiBlogProtocoloException
    {
        comunicacion.publicarArticulo( pTitulo, pCategoria, pContenido );
    }

    /**
     * Solicita las estadísticas de publicaciones del usuario.<br>
     * <b>pre: </b>La comunicación con el servidor debe estar establecida. El usuario del cliente debe estar configurado.<br>
     * @throws CupiBlogProtocoloException Si no se cumple con el protocolo establecido.
     * @throws CupiBlogComunicacionException Si no se puede establecer una conexión con el servidor.
     */
    public void solicitarEstadisticas( ) throws CupiBlogComunicacionException, CupiBlogProtocoloException
    {
        comunicacion.solicitarEstadisticasUsuario( );
    }

    /**
     * Notifica al manejador de eventos la recepción de la información de estadísticas del usuario.
     * @param pNumeroArticulos Número de artículos publicados por el usuario. pNumeroArticulos >= 0.
     * @param pPromedioCalificacion Número de comentarios publicados por el usuario. pPromedioCalificacion >= 0.
     */
    public void notificarResultadosEstadisticas( int pNumeroArticulos, double pPromedioCalificacion )
    {
        String mensaje = "Usted ha publicado:\n";
        mensaje += pNumeroArticulos + " Artículo(s). \n Y el promedio de sus calificaciones es: \n";
        mensaje += pPromedioCalificacion + ".";

        notificarMensaje( mensaje, "Estadísticas" );
    }

    /**
     * Notifica un nuevo mensaje proveniente del servidor.
     * @param pMensaje El mensaje proveniente del servidor. pMensaje != null && pMensaje != "".
     * @param pTitulo Titulo del mensaje que se va a notificar. pTitulo != null && pTItulo != "".
     */
    public void notificarMensaje( String pMensaje, String pTitulo )
    {
        observadorEventos.notificarMensaje( pMensaje, pTitulo );
    }

    /**
     * Notifica una nueva excepción en la comunicación con el servidor.
     * @param pExcepcion La excepción que ocurrió con la comunicación con el servidor. pExcepcion != null.
     */
    public void notificarExcepcion( Exception pExcepcion )
    {
        observadorEventos.notificarExcepcion( pExcepcion );
    }

    /**
     * Notifica la calificación de un artículo.
     * @param pArticulo El artículo calificado. pArticulo != null.
     */
    public void notificarCalificacion( Articulo pArticulo )
    {
        observadorEventos.notificarCalificacion( pArticulo );
    }

    /**
     * Registra un usuario con login, nombre y apellido dados e inicia su sesión. <br>
     * Si la comunicación con el servidor no existe, debe crearla.
     * @param pLogin Login del usuario con el cuál iniciar sesión. pLogin != null && pLogin != "".
     * @param pNombre Nombres del usuario. pNombre != null && pNombre != "".
     * @param pApellido Apellidos del usuario. pApellido != null && pApellido != "".
     * @throws CupiBlogComunicacionException Si no se puede establecer una conexión con el servidor.
     * @throws CupiBlogProtocoloException Si no se cumple con el protocolo establecido.
     */
    public void registrarUsuario( String pLogin, String pNombre, String pApellido ) throws CupiBlogComunicacionException, CupiBlogProtocoloException
    {
        if( comunicacion == null )
        {
            iniciarConexion( );
        }
        reiniciar( );
        comunicacion.registrarUsuario( pLogin, pNombre, pApellido );
        observadorEventos.cambiarEstadoSesion( true );
        listarArticulos( );
    }

    /**
     * Cierra la sesión del usuario del cliente del blog.
     * @throws IOException Si se produce un error al comunicarse con el servidor.
     */
    public void cerrarSesion( ) throws IOException
    {
        if( comunicacion != null )
        {
            comunicacion.cerrarSesion( );
            observadorEventos.cambiarEstadoSesion( false );
            comunicacion = null;
        }
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica la invariante de la clase. <br>
     * <b>inv: </b> <br>
     * manejadorEventos != null.<br>
     * articulos != null.<br>
     */
    private void verificarInvariante( )
    {
        assert observadorEventos != null : "El manejador de eventos debe existir.";
        assert articulos != null : "La lista de los artículos debe estar inicializada.";
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
     * Método para la extensión 2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

}