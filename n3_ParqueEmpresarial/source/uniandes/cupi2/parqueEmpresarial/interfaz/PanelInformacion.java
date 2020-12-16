/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_parqueEmpresarial
 * Autor: Equipo Cupi2 - 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.parqueEmpresarial.interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.parqueEmpresarial.mundo.Oficina;

/**
 * Panel de manejo de extensiones.
 */
public class PanelInformacion extends JPanel 
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;


    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Lista de oficinas ocupadas.
     */
    private JList listaOficinasOcupadas;

    /**
     * Scroll para la lista de oficinas ocupadas.
     */
    private JScrollPane scroll;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal. pPrincipal!=null.
     * @param pOficinasOcupadas oficinas ocupadas del edificio. pOficinasOcupadas!=null.
     */
    public PanelInformacion( InterfazParqueEmpresarial pPrincipal, ArrayList pOficinasOcupadas )
    {
        setBorder( new TitledBorder( "Oficinas Ocupadas" ) );
        GridBagLayout gb = new GridBagLayout( );
        GridBagConstraints gbc = new GridBagConstraints( );
        setLayout( gb );

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weighty = 1;

        listaOficinasOcupadas = new JList( );
        scroll = new JScrollPane( listaOficinasOcupadas );
        scroll.setPreferredSize( new Dimension( 145, 425 ) );
        add( scroll, gbc );
    }

    /**
     * Actualiza la lista de las oficinas Ocupadas con la información que entra por parámetro.
     * @param pOficinasOcupadas Lista con las oficinas Ocupadas. pOficinasOcupadas != null
     */
    public void llenarListaOficinasOcupadas( ArrayList<Oficina> pOficinasOcupadas )
    {
        listaOficinasOcupadas.removeAll( );
        listaOficinasOcupadas.setListData( pOficinasOcupadas.toArray( ) );
    }
   

}
