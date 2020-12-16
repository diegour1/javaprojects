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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import uniandes.cupi2.sudoku.mundo.Sudoku;

/**
 * Panel con las opciones para interactuar con el sudoku
 */

public class PanelMovimiento extends JPanel implements ActionListener
{
	 // ----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	// Constantes SubPanel CENTER
	
	 /**
     * Comando para mover en la direccion arriba izquierda.
     */
    public final static String IZQ_ARR = "IZQUIERDA_ARRIBA";
    
    /**
     * Comando para mover en la direccion arriba.
     */
    public final static String ARR = "ARRIBA";
    
    /**
     * Comando para mover en la direccion arriba derecha.
     */
    public final static String DER_ARR = "DERECHA_ARRIBA";

    /**
     * Comando para mover en la direccion izquierda.
     */
    public final static String IZQ = "IZQUIERDA";

    /**
     * Comando para mover en la direccion derecha.
     */
    public final static String DER = "DERECHA";

    /**
     * Comando para mover en la direccion abajo izquierda.
     */
    public final static String IZQ_ABA = "IZQUIERDA_ABAJO";
    

    /**
     * Comando para mover en la direccion abajo.
     */
    public final static String ABA = "ABAJO";

    /**
     * Comando para mover en la direccion abajo derecha.
     */
    public final static String DER_ABA = "DERECHA_ABAJO";
	
    // Constantes SubPanel SOUTH 

    /**
     * Comando para ingresar el valor en la casilla.
     */
    public final static String INGRESAR = "INGRESAR";
    
    /**
     * Comando para borrar el valor en la casilla.
     */
    public final static String BORRAR = "BORRAR";
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    // Atributos Subpanel CENTER
    
    /**
     * Boton movimiento izquierda arriba.
     */
    JButton btnIzqArr;
    
    /**
     * Boton movimiento arriba. 
     */
    JButton btnArr;
    
    /**
     * Boton movimiento derecha arriba.
     */
    JButton btnDerArr;
    
    /**
     * Boton movimiento izquierda.
     */
    JButton btnIzq;
    
    /**
     * Boton movimiento derecha.
     */
    JButton btnDer;
    
    /**
     * Boton movimiento derecha abajo.
     */
    JButton btnDerAba;
    
    /**
     * Boton movimiento abajo.
     */
    JButton btnAba;
    
    /**
     * Boton movimiento izquierda abajo.
     */
    JButton btnIzqAba;
    
    /**
     * Label con la imagen central 
     */
    JLabel lblCentral;
    
    
    // Atributos Subpanel SOUTH
    
    /**
     * Etiqueta que muestra si es o no pista.
     */
    
    JLabel lblPista;
    
    /**
     * Etiqueta que muestra la fila.
     */
    JLabel lblFila;
    
    /**
     * Etiqueta que muestra la columna.
     */
    JLabel lblColumna;
    
    /**
     * Check box que muestra si la casilla es o no pista.
     */
    JCheckBox cbPista;
    
    /**
     * Campo de texto que muestra la fila.
     */
    JTextField txtFila;
    
    /**
     * Campo de texto que muestra la columna.
     */
    JTextField txtColumna;
    
    /**
     * Boton para ingresar el valor en la casilla.
     */
    JButton btnIngresar;
    
    /**
     * Boton para borrar el valor en la casilla.
     */
    
    JButton btnBorrar; 
    
    //Atributos generales del panel 
    
    /**
     * Ventana principal de la aplicación.
     */
    InterfazSudoku principal;
    
    /**
     * Construye el panel con las opciones de movimiento, ingreso y eliminacion de casillas en el sudoku. 
     * @param pVentanaPrincipal Ventana principal de la aplicacion , pVentanaPrincipal != null.
     */
    
	public PanelMovimiento(InterfazSudoku pVentanaPrincipal) 
	{
		principal = pVentanaPrincipal;
		setBorder(BorderFactory.createTitledBorder("Movimiento"));
		
		//Inicializamos los atributos del SubPanel CENTER
		
		btnIzqArr = new JButton( );
		btnIzqArr.setIcon(new ImageIcon( "./data/imagenes/izqArr.png"));
		//btnIzqArr.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/izqArr.png")));
        btnIzqArr.setActionCommand( IZQ_ARR );
        btnIzqArr.addActionListener( this );
        btnIzqArr.setEnabled( false );

        btnArr = new JButton( );
		btnArr.setIcon(new ImageIcon( "./data/imagenes/arriba.png"));
		//btnArr.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/arriba.png")));
        btnArr.setActionCommand( ARR );
        btnArr.addActionListener( this );
        btnArr.setEnabled( false );
        
        btnDerArr = new JButton( );
		btnDerArr.setIcon(new ImageIcon( "./data/imagenes/derArr.png"));
        //btnDerArr.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/derArr.png")));        
        btnDerArr.setActionCommand( DER_ARR );
        btnDerArr.addActionListener( this );
        btnDerArr.setEnabled( false );
		
        btnIzq = new JButton( );
		btnIzq.setIcon(new ImageIcon( "./data/imagenes/izquierda.png"));
		//btnIzq.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/izquierda.png")));
        btnIzq.setActionCommand( IZQ );
        btnIzq.addActionListener( this );
        btnIzq.setEnabled( false );
        
        lblCentral = new JLabel( );
		lblCentral.setIcon(new ImageIcon( "./data/imagenes/centro.png"));
		//lblCentral.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/centro.png")));
		lblCentral.setHorizontalAlignment( JLabel.CENTER );
        lblCentral.setEnabled( false );
		
        btnDer = new JButton( );
		btnDer.setIcon(new ImageIcon( "./data/imagenes/derecha.png"));
        //btnDer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/derecha.png")));
        btnDer.setActionCommand( DER );
        btnDer.addActionListener( this );        
        btnDer.setEnabled( false );
        
        btnIzqAba = new JButton( );
		btnIzqAba.setIcon(new ImageIcon( "./data/imagenes/izqAb.png"));
        //btnIzqAba.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/izqAb.png")));
        btnIzqAba.setActionCommand( IZQ_ABA );
        btnIzqAba.addActionListener( this );
        btnIzqAba.setEnabled( false );
        
        btnAba = new JButton( );
		btnAba.setIcon(new ImageIcon( "./data/imagenes/abajo.png"));
		//btnAba.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/abajo.png")));
        btnAba.setActionCommand( ABA );
        btnAba.addActionListener( this );
        btnAba.setEnabled( false );

        btnDerAba = new JButton( );
		btnDerAba.setIcon(new ImageIcon( "./data/imagenes/derAb.png"));
		//btnDerAba.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./imagenes/derAb.png")));
        btnDerAba.setActionCommand( DER_ABA );
        btnDerAba.addActionListener( this );
        btnDerAba.setEnabled( false );
        
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(3,3));
        panelCenter.add(btnIzqArr);
        panelCenter.add(btnArr);
        panelCenter.add(btnDerArr);
        panelCenter.add(btnIzq);
        panelCenter.add(lblCentral);
        panelCenter.add(btnDer);
        panelCenter.add(btnIzqAba);
        panelCenter.add(btnAba);
        panelCenter.add(btnDerAba);

        //Inicializamos los atributos del SubPanel SOUTH
        
        lblPista = new JLabel("Pista");
        lblFila = new JLabel("Fila:");
        lblColumna = new JLabel("Columna:");
        
        cbPista = new JCheckBox();
        cbPista.setEnabled(false);
        txtFila = new JTextField();
        txtFila.setEditable(false);
        txtColumna = new JTextField();
        txtColumna.setEditable(false);
        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setActionCommand( INGRESAR );
        btnIngresar.addActionListener( this );
        btnIngresar.setEnabled(false);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.setActionCommand( BORRAR );
        btnBorrar.addActionListener( this ); 
        btnBorrar.setEnabled(false);
        
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(4, 2, 8, 6));
        panelSouth.add(lblPista);
        panelSouth.add(cbPista);
        panelSouth.add(lblFila);
        panelSouth.add(txtFila);
        panelSouth.add(lblColumna);
        panelSouth.add(txtColumna);
        panelSouth.add(btnIngresar);
        panelSouth.add(btnBorrar);
        
        //Inicializamos el PanelMovimiento
        
        setLayout(new BorderLayout());
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
	}
	
	/**
	 * Actualiza algunos valores del modelo mundo en los textFields del panel.
	 * @param pSudoku Instancia del modelo mundo que llega por parametro.
	 */
	public void actualizar(Sudoku pSudoku) 
	{
		cbPista.setSelected(pSudoku.darCasillaActual().esPista());
		txtFila.setText(Integer.toString(pSudoku.darFilaActual()));
		txtColumna.setText(Integer.toString(pSudoku.darColumnaActual()));
	}

	/**
     * Habilita todos los botones del movimiento cuando se carga un juego de Sudoku.
     */
    
	public void habilitarBotones( )
    {
    	btnIzqArr.setEnabled( true );
    	btnArr.setEnabled( true );
    	btnDerArr.setEnabled( true );
    	btnIzq.setEnabled( true );
    	lblCentral.setEnabled( true );
    	btnDer.setEnabled( true );
    	btnIzqAba.setEnabled( true );
    	btnAba.setEnabled( true );
    	btnDerAba.setEnabled( true );
    	btnIngresar.setEnabled( true );
    	btnBorrar.setEnabled( true );  
    }
	
	/**
     * Deshabilita todos los botones del movimiento cuando se resuelve un juego de Sudoku.
     */
    
	public void deshabilitarBotones( )
    {
    	btnIzqArr.setEnabled( false );
    	btnArr.setEnabled( false );
    	btnDerArr.setEnabled( false );
    	btnIzq.setEnabled( false );
    	lblCentral.setEnabled( false );
    	btnDer.setEnabled( false );
    	btnIzqAba.setEnabled( false );
    	btnAba.setEnabled( false );
    	btnDerAba.setEnabled( false );
    	btnIngresar.setEnabled( false );
    	btnBorrar.setEnabled( false );  
    }
	
    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento!=null.
     */
	
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		if (comando.equals(IZQ_ARR))
			principal.mover(IZQ_ARR);
		else if(comando.equals(ARR))
			principal.mover(ARR);
		else if(comando.equals(DER_ARR))
			principal.mover(DER_ARR);
		else if(comando.equals(DER))
			principal.mover(DER);
		else if(comando.equals(IZQ))
			principal.mover(IZQ);
		else if(comando.equals(IZQ_ABA))
			principal.mover(IZQ_ABA);	
		else if(comando.equals(ABA))
			principal.mover(ABA);
		else if(comando.equals(DER_ABA))
			principal.mover(DER_ABA);
		else if(comando.equals(INGRESAR))
			principal.ingresar();
		else if(comando.equals(BORRAR))
			principal.borrar();
	}

}
