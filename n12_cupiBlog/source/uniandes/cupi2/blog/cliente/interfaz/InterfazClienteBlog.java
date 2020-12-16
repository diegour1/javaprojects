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

package uniandes.cupi2.blog.cliente.interfaz;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import uniandes.cupi2.blog.cliente.mundo.Articulo;
import uniandes.cupi2.blog.cliente.mundo.ClienteBlog;
import uniandes.cupi2.blog.cliente.mundo.CupiBlogComunicacionException;
import uniandes.cupi2.blog.cliente.mundo.CupiBlogProtocoloException;
import uniandes.cupi2.blog.cliente.mundo.IObservadorEventos;
import uniandes.cupi2.blog.servidor.interfaz.InterfazServidorBlog;

/**
 * Ventana principal de la aplicación cliente del blog.
 */
public class InterfazClienteBlog extends JFrame implements IObservadorEventos
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private ClienteBlog blog;

    /**
     * Login del usuario actual.
     */
    private String loginActual;

    /**
     * Panel con la lista de artículos.
     */
    private PanelArticulos panelArticulos;

    /**
     * Panel con la información del artículo a mostrar.
     */
    private PanelArticulo panelArticulo;

    /**
     * Panel con los comandos del blog.
     */
    private PanelComandos panelComandos;

    /**
     * Panel con la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la interfaz del cliente del blog. <br>
     * <b>post: </b> La interfaz es creada.
     */
    public InterfazClienteBlog( )
    {
        // Crea la clase principal
        String ipServidor = ( String )JOptionPane.showInputDialog( null, "La dirección IP del servidor", "" );
        if( ipServidor == null )
        {
            dispose( );
        }
        else
        {
            if( ipServidor.length( ) == 0 )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar la dirección IP del Servidor al cual se desea conectar.", "Dirección ip del servidor", JOptionPane.INFORMATION_MESSAGE );
            }

            blog = new ClienteBlog( this, ipServidor );

            // Construye la forma
            setTitle( "CupiBlog" );
            setLayout( new BorderLayout( ) );
            setSize( 875, 700 );
            setResizable( true );
            setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

            // Crea los paneles
            panelImagen = new PanelImagen( );
            add( panelImagen, BorderLayout.NORTH );

            panelArticulos = new PanelArticulos( this );
            add( panelArticulos, BorderLayout.WEST );

            panelArticulo = new PanelArticulo( this );
            add( panelArticulo, BorderLayout.CENTER );

            panelComandos = new PanelComandos( this );
            add( panelComandos, BorderLayout.SOUTH );

            // Centrar la ventana
            setLocationRelativeTo( null );

            // Inicia la sesión del usuario.
            String loginSesion = ( String )JOptionPane.showInputDialog( null, "Escriba su login para ingresar" );
            if( loginSesion != null && !loginSesion.equals( "" ) )
            {
                iniciarSesion( loginSesion );
            }
            else
            {
                JOptionPane.showMessageDialog( null, "Debe ingresar un login para iniciar sesión.", "Iniciar sesión", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el login del usuario actual.
     * @return Login del usuario actual.
     */
    public String darLoginActual( )
    {
        return loginActual;
    }

    /**
     * Solicita al servidor el inicio de sesión del usuario con login dado. <br>
     * Si se produce un error porque el login no se encuentra en el sistema, entonces se registra el usuario. <br>
     * Si se produce otro tipo de error, se cierra la interfaz.
     * <b> pre: </b> El blog está inicializado.
     * <b> post: </b> El login actual es el login del usuario que inició sesión.
     * @param pLogin El nombre del usuario a ingresar. pLogin != null && pLogin != "".
     */
    public void iniciarSesion( String pLogin )
    {
        try
        {
            blog.iniciarSesion( pLogin );
            loginActual = pLogin;
            cambiarEstadoSesion( true );
        }
        catch( CupiBlogComunicacionException e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ), "Iniciar sesión", JOptionPane.ERROR_MESSAGE );
            this.dispose( );
        }
        catch( CupiBlogProtocoloException e )
        {
            int resp = JOptionPane.showConfirmDialog( null, "Su login no se encuentra en el sistema. ¿Desea registrarse?", "Iniciar sesión", JOptionPane.YES_NO_OPTION );
            if( resp == JOptionPane.YES_OPTION )
            {
                DialogoRegistrarUsuario dialogoRegistrar = new DialogoRegistrarUsuario( this );
                dialogoRegistrar.setVisible( true );
            }
            else if( resp == JOptionPane.NO_OPTION )
            {
                this.dispose( );
            }
        }
    }

    /**
     * Actualiza la información a mostrar del artículo.
     * <b> pre: </b> El blog está inicializado. 
     * @param pArticulo El artículo a mostrar en el panel. pArticulo != null.
     */
    public void actualizarArticulo( Articulo pArticulo )
    {
        try
        {
            blog.modificarArticuloActual( pArticulo );
            panelArticulo.actualizarArticulo( pArticulo );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ), "Actualizar artículo", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca los artículos que pertenezcan a la categoría dada.
     * <b> pre: </b> El blog está inicializado.
     * @param pCategoria La categoría a buscar. pCategoria != null && pCategoria pertenece a Articulo.CATEGORIAS.
     */
    public void buscarArticuloPorCategoria( String pCategoria )
    {
        try
        {
            blog.buscarArticulosCategoria( pCategoria );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ), "Buscar artículo", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Califica el artículo actual con la calificación dada por parámetro.
     * <b> pre: </b> El blog está inicializado.
     * @param pCalificacion La calificación que se le da al artículo. pCalificacion >= 0.
     */
    public void calificarArticulo( int pCalificacion )
    {
        try
        {
            blog.calificarArticulo( pCalificacion );
            JOptionPane.showMessageDialog( this, "Se ha calificado correctamente el artículo.", "Calificar artículo", JOptionPane.INFORMATION_MESSAGE );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ), "Calificar artículo", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Solicita al servidor la lista de todos los artículos.
     * <b> pre: </b> El blog está inicializado.
     */
    public void listarTodosArticulos( )
    {
        try
        {
            blog.listarArticulos( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ), "Listar artículos", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Solicita al servidor las estadísticas del usuario.
     * <b> pre: </b> El blog está inicializado.
     */
    public void solicitarEstadisticas( )
    {
        try
        {
            blog.solicitarEstadisticas( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ), "Mostrar estadísticas", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Publica un artículo con los datos dados en el blog.
     * <b> pre: </b> El blog está inicializado.
     * @param pTitulo El título del artículo. pTitulo != null && pTitulo != "".
     * @param pCategoria La categoría del artículo. pCategoria != null && pCategoria pertenece a Articulo.CATEGORIAS.
     * @param pContenido El contenido del artículo. pContenido != null && pContenido != "".
     */
    public void publicarArticulo( String pTitulo, String pCategoria, String pContenido )
    {
        try
        {
            blog.publicarArticulo( pTitulo, pCategoria, pContenido );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ), "Publicar artículo", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Envía al servidor la solicitud de registrar un nuevo usuario con los datos dados.
     * <b> pre: </b> El blog está inicializado.
     * @param pLogin El nombre del usuario a ingresar. pLogin != null && pLogin != "".
     * @param pNombre El nombre de pila del usuario. pNombre != null && pNombre != "".
     * @param pApellido Los apellidos del usuario. pApellido != null && pApellido != "".
     */
    public void registrarUsuario( String pLogin, String pNombre, String pApellido )
    {
        try
        {
            blog.registrarUsuario( pLogin, pNombre, pApellido );
            loginActual = pLogin;
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ), "Registrar usuario", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Cierra la sesión del usuario.
     * <b> pre: </b> El blog está inicializado.
     */
    public void cerrarSesion( )
    {
        try
        {
            if( loginActual != null )
            {
                blog.cerrarSesion( );
            }
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Cerrar sesión", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * El método que se llama al cerrar la aplicación. <br>
     * Se cierra la sesión del usuario.
     */
    public void dispose( )
    {
        int resp = JOptionPane.showConfirmDialog( null, "¿Está seguro que quiere salir del programa?", "Cerrar sesión", JOptionPane.YES_NO_OPTION );
        if( resp == JOptionPane.YES_OPTION )
        {
            cerrarSesion( );
            super.dispose( );
        }
    }

    // -----------------------------------------------------------------
    // Métodos de observador
    // -----------------------------------------------------------------

    /**
     * Actualiza los artículos en el panel de artículos según la lista dada por parámetro.
     * @param pArticulos La lista de artículos. pArticulos != null.
     */
    public void actualizarListaArticulos( ArrayList<Articulo> pArticulos )
    {
        panelArticulos.actualizarListaArticulos( pArticulos );
    }

    /**
     * Notifica al usuario la notificación de un mensaje.
     * @param pMensaje El mensaje que se va a notificar. pMensaje != null && pMensaje != "".
     * @param pTitulo Titulo del mensaje que se va a notificar. pTitulo != null && pTItulo != "".
     */
    public void notificarMensaje( String pMensaje, String pTitulo )
    {
        JOptionPane.showMessageDialog( this, pMensaje, pTitulo, JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Muestra la información de la excepción.
     * @param pExcepcion La excepción de la aplicación. pExcepcion != null.
     */
    public void notificarExcepcion( Exception pExcepcion )
    {
        JOptionPane.showMessageDialog( this, pExcepcion.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
    }

    /**
     * Notifica el inicio de sesión del usuario. <br>
     * Cuando el usuario inicia sesión, se visualiza la ventana principal. <br>
     * Cuando el usuario cierra sesión, se limpia la lista de artículos y se desactivan las opciones del panel del artículo.
     * <b> pre: </b> PanelComandos, PanelArticulo y PanerlArticulos están inicializados.
     * @param pEstadoSesion El estado de sesión del usuario. pEstadoSesion != null.
     */
    public void cambiarEstadoSesion( boolean pEstadoSesion )
    {
        setVisible( true );
        panelComandos.sesionAbierta( pEstadoSesion );
        if( !pEstadoSesion )
        {
            panelArticulo.desactivar( );
            panelArticulos.limpiarLista( );
        }
    }

    /**
     * Notifica la calificación de un artículo.
     * <b> pre: </b> El panel artículo está inicializado.
     * @param pArticulo El artículo que se va a calificar. pArticulo != null.
     */
    public void notificarCalificacion( Articulo pArticulo )
    {
        panelArticulo.actualizarArticulo( pArticulo );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * <b> pre: </b> El blog está inicializado.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = blog.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     * <b> pre: </b> El blog está inicializado.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = blog.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz. <br>
     * No se visualiza la interfaz.
     * @param pArgs Los argumentos de ejecución de la aplicación. pArgs != null.
     */
    public static void main( String[] pArgs )
    {
        // Unifica la interfaz para Mac y para Windows.
    	InterfazServidorBlog interfazServidorBlog = new InterfazServidorBlog();
    	interfazServidorBlog.setVisible(true);
    	
    	try 
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        new InterfazClienteBlog( );
        
    }

}