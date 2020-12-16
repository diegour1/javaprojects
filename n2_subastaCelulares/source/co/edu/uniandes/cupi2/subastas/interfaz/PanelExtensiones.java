/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_subastaCelulares
 * Autor: Equipo Cupi2 - 201910
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.cupi2.subastas.interfaz;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * Panel con las opciones de extensi�n.
 */
public class PanelExtensiones extends JPanel implements ActionListener {

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	
	/**
	 * Comando para la opci�n 1.
	 */
	public final static String OPCION_1 = "OPCION_1";
	
	/**
	 * Comando para la opci�n 2.
	 */
	public final static String OPCION_2 = "OPCION_2";
	
	/**
	 * Comando para reiniciar la subasta.
	 */
	public final static String REINICIAR_SUBASTA = "REINICIAR_SUBASTA";
	
	/**
	 * Comando para indicar cual es el celular com mayor numero de ofertas.
	 */
	public final static String MAYOR_OFERTAS = "MAYOR_OFERTAS";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Bot�n opci�n 1. 
	 */
	private JButton btnExt1;
	/**
	 * Bot�n opci�n 2. 
	 */
	private JButton btnExt2;
	/**
	 * Bot�n reiniciar subasta 
	 */
	private JButton btnReiniciarSubasta;
	/**
	 * Bot�n Mayor Ofertas 
	 */
	private JButton btnMayorOfertas;

	/**
	 * Ventana principal de la aplicaci�n
	 */
	private InterfazSubasta principal;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	
	/**
	 * Construye el panel con las opciones de extensi�n.
	 * @param pVentanaPrincipal Ventana principal de la aplicaci�n.
	 */
	public PanelExtensiones(InterfazSubasta pVentanaPrincipal) {
		principal = pVentanaPrincipal;

        setBorder( BorderFactory.createTitledBorder( "Extensiones" ) );

		btnExt1 = new JButton("Opci�n 1");
		btnExt1.setActionCommand(OPCION_1);
		btnExt1.addActionListener(this);
		btnExt1.setIcon(new ImageIcon("./data/opc1.png"));

		btnExt2 = new JButton("Opci�n 2");
		btnExt2.setActionCommand(OPCION_2);
		btnExt2.addActionListener(this);
		btnExt2.setIcon(new ImageIcon("./data/opc2.png"));

		btnReiniciarSubasta = new JButton("Reiniciar subasta");
		btnReiniciarSubasta.setActionCommand(REINICIAR_SUBASTA);
		btnReiniciarSubasta.addActionListener(this);
		btnReiniciarSubasta.setIcon(new ImageIcon("./data/restart.png"));
		
		
		btnMayorOfertas = new JButton("Celular con mas ofertas");
		btnMayorOfertas.setActionCommand(MAYOR_OFERTAS);
		btnMayorOfertas.addActionListener(this);

		setLayout(new GridLayout(1, 4));
		add(btnReiniciarSubasta);
		add(btnExt1);
		add(btnExt2);
		add(btnMayorOfertas);

	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Manejo de eventos del usuario.
	 * @param e Evento de usuario. e != null.
	 */
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(OPCION_1)) {
			principal.reqFuncOpcion1a();
		} else if (comando.equals(OPCION_2)) {
			principal.reqFuncOpcion2a();
		} else if (comando.equals(REINICIAR_SUBASTA)) {
			principal.reiniciarSubasta();
		}else if (comando.equals(MAYOR_OFERTAS)) {
			principal.mayorOfertas();
		}

	}

}