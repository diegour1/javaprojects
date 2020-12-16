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

package uniandes.cupi2.cupiTaxonomia.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiTaxonomia.mundo.SerVivo;

/**
 * Panel que contiene la información de los seres vivos del árbol taxonómico.
 */
@SuppressWarnings({ "rawtypes", "serial","unchecked" })
public class PanelSeresVivos extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando de ver en detalle un ser vivo.
     */
    private final static String VER = "Ver detalle";

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Lista con los seres vivos.
     */
    private JList listaSeresVivos;

    /**
     * Panel con un scroll que contiene la lista de seres vivos.
     */
    private JScrollPane scroll;

    /**
     * Botón para ver la información de un ser vivo.
     */
    private JButton btnVer;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel de visualización de los seres vivos.
     * <b> post: </b> Se crea el panel con todos sus elementos gráficos.
     */
    public PanelSeresVivos( )
    {
        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 5, 0, 5 ), new TitledBorder( " Seres vivos " ) ) );
        setPreferredSize( new Dimension( 250, 0 ) );

        listaSeresVivos = new JList( );
        listaSeresVivos.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

        DefaultListCellRenderer renderer = new SeresVivosListRenderer( );
        listaSeresVivos.setCellRenderer( renderer );

        scroll = new JScrollPane( listaSeresVivos );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );

        btnVer = new JButton( VER );
        btnVer.setActionCommand( VER );
        btnVer.addActionListener( this );

        add( scroll, BorderLayout.CENTER );
        add( btnVer, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de libros con la lista recibida por parámetro.
     * @param pNuevaLista La lista con los libros. pNuevaLista != null.
     */
    public void refrescar( ArrayList pNuevaLista )
    {
        listaSeresVivos.setListData( pNuevaLista.toArray( ) );
        if( !pNuevaLista.isEmpty( ) )
        {
            listaSeresVivos.setSelectedIndex( 0 );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( VER ) )
        {
            if( listaSeresVivos.getSelectedValue( ) != null )
            {
                SerVivo ser = ( SerVivo )listaSeresVivos.getSelectedValue( );
                DialogoVerSerVivo dialogo = new DialogoVerSerVivo( ser );
                dialogo.setLocationRelativeTo( this );
                dialogo.setVisible( true );
            }
        }
    }
}
