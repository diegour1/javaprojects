/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_sudoku
 * Autor: Diego Useche Reyes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.sudoku.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones del Sudoku
 */

public class PanelOpciones extends JPanel implements ActionListener 
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	
	/**
	 * Comando para cargar.
	 */
	public final static String CARGAR = "CARGAR";
	
	/**
	 * Comando para reiniciar.
	 */
	public final static String REINICIAR = "REINICIAR";
	
	/**
	 * Comando para validar.
	 */
	public final static String VALIDAR = "VALIDAR";
	
	/**
	 * Comando para solucionar.
	 */
	public final static String SOLUCIONAR = "SOLUCIONAR";
	
	/**
	 * Comando para la opción 1.
	 */
	public final static String OPCION_1 = "OPCION_1";
	
	/**
	 * Comando para la opción 1.
	 */
	public final static String OPCION_2 = "OPCION_2";
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Botón cargar. 
	 */
	private JButton btnCargar;
	
	/**
	 * Botón reiniciar. 
	 */
	private JButton btnReiniciar;
	
	/**
	 * Botón validar. 
	 */
	private JButton btnValidar;
	
	/**
	 * Botón solucionar. 
	 */
	private JButton btnSolucionar;
	
	/**
	 * Botón opción 1. 
	 */
	private JButton btnExt1;
	/**
	 * Botón opción 2. 
	 */
	private JButton btnExt2;
	
	/**
	 * Ventana principal de la aplicación
	 */
	private InterfazSudoku principal;
	
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	
	/**
	 * Construye el panel con las opciones del sudoku
	 * @param interfazSudoku Ventana principal de la aplicación.
	 */
	
	public PanelOpciones(InterfazSudoku interfazSudoku) 
	{
		principal = interfazSudoku;
		
		setBorder( new TitledBorder( "Opciones" ) );
		
		// Creamos los botones
		
		btnCargar = new JButton("Cargar");
		btnCargar.setActionCommand(CARGAR);
		btnCargar.addActionListener(this);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setActionCommand(REINICIAR);
		btnReiniciar.addActionListener(this);
		btnReiniciar.setEnabled( false );
		
		btnValidar = new JButton("Validar");
		btnValidar.setActionCommand(VALIDAR);
		btnValidar.addActionListener(this);
		btnValidar.setEnabled( false );
		
		btnSolucionar = new JButton("Solucionar");
		btnSolucionar.setActionCommand(SOLUCIONAR);
		btnSolucionar.addActionListener(this);
		btnSolucionar.setEnabled( false );
		
		btnExt1 = new JButton("Opción 1");
		btnExt1.setActionCommand(OPCION_1);
		btnExt1.addActionListener(this);
		btnExt1.setEnabled( false );
		
		btnExt2 = new JButton("Opción 2");
		btnExt2.setActionCommand(OPCION_2);
		btnExt2.addActionListener(this);
		btnExt2.setEnabled( false );
		
		// Creamos el layout y agregamos los botones
		
		setLayout( new GridLayout(1, 6) );
		add(btnCargar);
		add(btnReiniciar);
		add(btnValidar);
		add(btnSolucionar);
		add(btnExt1);
		add(btnExt2);
	}
	
	/**
     * Habilita todos los botones excepto el boton CARGAR que ya esta habilitado.
     */
    public void habilitarBotones( )
    {
    	btnReiniciar.setEnabled( true );
    	btnValidar.setEnabled( true );
    	btnSolucionar.setEnabled( true );
    	btnExt1.setEnabled( true );
    	btnExt2.setEnabled( true );
    }
    
    /**
     * Deshabilita los botones de VALIDAR y SOLUCIONAR cuando se resuelve el sudoku.
     */
    public void deshabilitarBotones( )
    {
    	btnValidar.setEnabled( false );
    	btnSolucionar.setEnabled( false );
    }
    
    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento!=null.
     */
    
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		if (comando.equals(CARGAR))
			principal.cargar();
		else if(comando.equals(REINICIAR))
			principal.reiniciar();
		else if(comando.equals(VALIDAR))
			principal.validar();
		else if(comando.equals(SOLUCIONAR))
			principal.solucionar();
		else if(comando.equals(OPCION_1))
			principal.reqFuncOpcion1a( );
		else if(comando.equals(OPCION_2))
			principal.reqFuncOpcion2a( );	
	}
}
