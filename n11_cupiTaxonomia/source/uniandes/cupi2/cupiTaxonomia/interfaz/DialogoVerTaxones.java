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

package uniandes.cupi2.cupiTaxonomia.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Di�logo para ver la lista de taxones del �rbol taxon�mico.
 */
@SuppressWarnings({ "rawtypes", "serial","unchecked" })
public class DialogoVerTaxones extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Lista con los taxones.
     */
    private JList listaTaxones;

    /**
     * Panel con un scroll que contiene la lista de taxones.
     */
    private JScrollPane scroll;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del di�logo que muestra la lista de taxones.
     * <b> post: </b> Se crea el di�logo con todos sus elementos gr�ficos.
     * @param pTaxones Lista de taxones a mostrar. pTaxones != null
     */
    public DialogoVerTaxones( ArrayList pTaxones )
    {
        setLayout( new BorderLayout( ) );
        setSize( 300, 280 );
        setModal( true );
        setTitle( "Ver taxones" );
        setResizable( false );

        listaTaxones = new JList( pTaxones.toArray( ) );
        scroll = new JScrollPane( listaTaxones );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        add( scroll, BorderLayout.CENTER );
    }
}