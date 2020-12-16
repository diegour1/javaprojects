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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.blog.cliente.mundo.Articulo;

/**
 * Panel para la visualización de la lista de todos los artículos del blog.
 */
public class PanelArticulos extends JPanel implements ListSelectionListener, ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para actualizar la lista de artículos.
     */
    private final static String ACTUALIZAR = "Actualizar lista";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazClienteBlog principal;

    /**
     * Lista de artículos publicados en el blog.
     */
    private JList listaArticulos;

    /**
     * Botón actualizar lista.
     */
    private JButton btnActualizarLista;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel de artículos. <br>
     * <b> post: </b> Se crea el panel con todos sus elementos gráficos.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelArticulos( InterfazClienteBlog pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 200, 200 ) );

        TitledBorder borde = BorderFactory.createTitledBorder( "Artículos del blog" );
        setBorder( borde );

        listaArticulos = new JList( );
        listaArticulos.addListSelectionListener( this );

        JScrollPane scroll = new JScrollPane( listaArticulos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        add( scroll, BorderLayout.CENTER );

        btnActualizarLista = new JButton( ACTUALIZAR );
        btnActualizarLista.setActionCommand( ACTUALIZAR );
        btnActualizarLista.addActionListener( this );
        add( btnActualizarLista, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Limpia todos los elementos de la lista.
     */
    public void limpiarLista( )
    {
        listaArticulos.setListData( new Object[0] );
    }

    /**
     * Actualiza la lista de artículos publicados.
     * @param pArticulos La nueva lista de artículos. pArticulos != null.
     */
    public void actualizarListaArticulos( ArrayList<Articulo> pArticulos )
    {
        listaArticulos.setListData( pArticulos.toArray( ) );
    }

    // -----------------------------------------------------------------
    // Métodos del manejo de eventos
    // -----------------------------------------------------------------

    /**
     * Método para atender el evento cuando un usuario selecciona un taxón de la lista.
     * @param pEvento El evento de selección de un elemento de la lista de taxones. pEvento != null.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        Articulo articulo = ( Articulo )listaArticulos.getSelectedValue( );
        if( articulo != null )
        {
            principal.actualizarArticulo( articulo );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACTUALIZAR ) )
        {
            principal.listarTodosArticulos( );
        }
    }

}
