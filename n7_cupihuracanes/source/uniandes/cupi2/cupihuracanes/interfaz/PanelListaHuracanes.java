/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiHuracanes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupihuracanes.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import uniandes.cupi2.cupihuracanes.mundo.Huracan;

/**
 * Panel donde se muestra la lista de huracanes y est�n los botones para interactuar con la lista.
 */
public class PanelListaHuracanes extends JPanel implements ListSelectionListener, ActionListener
{

	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante con la acci�n de registrar un hurac�n.
     */
	private static final String REGISTRAR_HURACAN = "REGISTRAR_HURACAN";
	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazHuracanes principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Lista con los nombres de los huracanes registrados en el sistema.
     */
    // TODO Parte 3 punto B: Declarar atributo que contiene la lista de los huracanes.
    private JList listaHuracanes;

    /**
     * Componente de desplazamiento para contener la lista gr�fica.
     */
    private JScrollPane scroll;
    
    /**
     * Bot�n para registrar un hurac�n.
     */
    private JButton botonRegistrarHuracan;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelListaHuracanes( InterfazHuracanes pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        this.setPreferredSize(new Dimension(200, 300));

        // TODO Parte 3 punto C:
        // (1) Crear la lista y (2) agregar al panel como listener de la lista
        listaHuracanes = new JList();
        scroll = new JScrollPane( listaHuracanes);
        listaHuracanes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // TODO Parte 3 punto D:
        // (1) Crear y configurar un scroll pane para que contenga la lista
        // (2) Agregar el scroll al panel en el centro (Tener en cuenta que el layout es BorderLayout)
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll, BorderLayout.CENTER);
        
        botonRegistrarHuracan = new JButton( "Registrar hurac�n" );
        botonRegistrarHuracan.addActionListener( this );
        botonRegistrarHuracan.setActionCommand( REGISTRAR_HURACAN );
        add( botonRegistrarHuracan, BorderLayout.SOUTH );
        
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de huracanes que se est� mostrando.
     * @param pLista Lista con los huracanes que deben mostrarse.
     */
    public void refrescarLista( ArrayList pLista )
    {
    	// TODO Parte 3 punto E: Completar seg�n enunciado.
        // Recuerde primero borrar los elementos de la lista actual, 
        // segundo agregar los nuevos elementos (entran como par�metro), 
        // y tercero establecer el �ndice seleccionado en el 0.
    	listaHuracanes.setListData(pLista.toArray());
    	listaHuracanes.setSelectedIndex( 0 );
    }

    /**
     * Selecciona un elemento de la lista.
     * @param pSeleccionada Posici�n del elemento que se debe seleccionar.
     */
    public void seleccionar( int pSeleccionada )
    {
        listaHuracanes.setSelectedIndex( pSeleccionada );
        listaHuracanes.ensureIndexIsVisible( pSeleccionada );
    }

    /**
     * Actualiza la informaci�n del panel de informaci�n de huracanes seg�n el hurac�n que se seleccion� en la lista de huracanes.
     * @param pEvento Evento de cambio el �tem seleccionado en la lista.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
    	// TODO Parte 3 punto F: Completar seg�n enunciado.
        // Obtenga el hurac�n seleccionado y llame a la interfaz para que actualice el panel 
        // de informaci�n de los huracanes con el hurac�n que ud. acab� de obtener.
    	if (listaHuracanes.getSelectedValue() != null)
    	{
    		Huracan h = (Huracan) listaHuracanes.getSelectedValue();
    		principal.actualizarInformacionHuracan( h );
    	}
    }

    /**
     * M�todo se llama cuando se presiona uno de los botones.
     * @param pEvento Evento del click en el mouse.
     */
	public void actionPerformed(ActionEvent pEvento) {
		String comando = pEvento.getActionCommand( );

		if( REGISTRAR_HURACAN.equals( comando ) )
        {
			
            principal.mostrarDialogoRegistrarHuracan();
        }
		
	}
}