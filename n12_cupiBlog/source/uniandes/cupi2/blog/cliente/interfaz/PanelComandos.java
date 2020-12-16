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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.blog.cliente.mundo.Articulo;

/**
 * Panel para el manejo de comandos.
 */
public class PanelComandos extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para publicar un artículo.
     */
    private static final String PUBLICAR_ARTICULO = "PUBLICAR_ARTICULO";

    /**
     * Constante que representa el comando para buscar un artículo por el nombre de la categoría.
     */
    private static final String BUSCAR_ARTICULO_CATEGORIA = "BUSCAR_ARTICULO_CATEGORIA";

    /**
     * Constante que representa el comando para buscar un artículo por el nombre de la categoría.
     */
    private static final String LISTAR_TODOS_ARTICULOS = "LISTAR_TODOS_ARTICULOS";

    /**
     * Constante que representa el comando para mostrar las estadísticas del usuario.
     */
    private static final String ESTADISTICAS = "ESTADISTICAS";

    /**
     * Constante que representa el comando para la opción 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Constante que representa el comando para la opción 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazClienteBlog principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para publicar un artículo.
     */
    private JButton btnPublicarArticulo;

    /**
     * Botón para buscar un artículo por la categoría.
     */
    private JButton btnBuscarCategoria;

    /**
     * Botón para mostrar las estadísticas.
     */
    private JButton btnEstadisticas;

    /**
     * Botón Opción 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel de comandos. <br>
     * <b> post: </b> Se crea el panel con todos sus elementos gráficos.
     * @param pPrincipal La interfaz del blog. pPrincipal != null.
     */
    public PanelComandos( InterfazClienteBlog pPrincipal )
    {
        principal = pPrincipal;

        setBorder( null );
        setLayout( new GridLayout( 0, 5 ) );

        // Botón para publicar un artículo
        btnPublicarArticulo = new JButton( "Publicar artículo" );
        btnPublicarArticulo.setActionCommand( PUBLICAR_ARTICULO );
        btnPublicarArticulo.addActionListener( this );
        add( btnPublicarArticulo );

        // Botón para buscar artículos por categoría
        btnBuscarCategoria = new JButton( "Buscar" );
        btnBuscarCategoria.setActionCommand( BUSCAR_ARTICULO_CATEGORIA );
        btnBuscarCategoria.addActionListener( this );
        add( btnBuscarCategoria );

        // Botón para mostrar las estadísticas del usuario
        btnEstadisticas = new JButton( "Estadisticas" );
        btnEstadisticas.setActionCommand( ESTADISTICAS );
        btnEstadisticas.addActionListener( this );
        add( btnEstadisticas );

        // Botón opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Botón opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Activa y desactiva los botones según el estado de la sesión.
     * @param pAbierta El estado de la sesión. pAbierta != null.
     */
    public void sesionAbierta( boolean pAbierta )
    {
        btnPublicarArticulo.setEnabled( pAbierta );
        btnBuscarCategoria.setEnabled( pAbierta );
        btnEstadisticas.setEnabled( pAbierta );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( PUBLICAR_ARTICULO.equals( pEvento.getActionCommand( ) ) )
        {
            DialogoPublicarArticulo dialogo = new DialogoPublicarArticulo( principal );
            dialogo.setVisible( true );
        }
        else if( BUSCAR_ARTICULO_CATEGORIA.equals( pEvento.getActionCommand( ) ) )
        {
            JComboBox categorias = new JComboBox( Articulo.CATEGORIAS );
            JOptionPane.showMessageDialog( null, categorias, "Seleccione una categoría", JOptionPane.QUESTION_MESSAGE );
            String categoria = ( String )categorias.getSelectedItem( );
            if( categoria != null )
            {
                principal.buscarArticuloPorCategoria( categoria );
            }
        }
        else if( ESTADISTICAS.equals( pEvento.getActionCommand( ) ) )
        {
            principal.solicitarEstadisticas( );
        }
        else if( OPCION_1.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }

    }

}
