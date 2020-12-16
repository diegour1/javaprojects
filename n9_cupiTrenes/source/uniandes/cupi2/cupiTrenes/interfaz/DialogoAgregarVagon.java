package uniandes.cupi2.cupiTrenes.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class DialogoAgregarVagon extends JDialog implements ActionListener
{
	
	// -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------
	
	private final static String AGREGAR = "Agregar";
	
	private final static String CANCELAR = "Cancelar";
	
	// -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------
	
	private InterfazCupiTrenes principal;
	
	
	// -------------------------------------------------------------
    // Atributos de la interfaz
    // -------------------------------------------------------------
	
//	private String claseSeleccionada;
	
	private JPanel panelDialogo;
	
	private JComboBox cbbIdTren;
	
	private JTextField txtNumeroVagones;
	
	private JTextField txtCantidadSillas;
	
	private JTextField txtPrecio;
	
	private JButton btnAgregar;
	
	private JButton btnCancelar;
	
	//JRadioButton
	
	ButtonGroup grupo;
	
	JRadioButton botonPrimeraClase;
	
	JRadioButton botonSegundaClase;
	
	JRadioButton botonNegocios;
	
	JRadioButton botonVIP;
	
    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------
	
	/**
     * Construye un diálogo para agregar un vagon.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
	
	public DialogoAgregarVagon(InterfazCupiTrenes pPrincipal)
	{
		setTitle("Nuevo Vagon");
		setLocationRelativeTo(null);
		principal = pPrincipal;
		setSize(550, 250);
		setLocationRelativeTo( principal );
		inicializarPanelDialogo( );
        add( panelDialogo );
	}
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel del diálogo.
     */
	
	public void inicializarPanelDialogo()
	{
		panelDialogo = new JPanel( );
        panelDialogo.setLayout( new BorderLayout( ) );
        panelDialogo.setBorder( new TitledBorder( "Agregar vagón" ) );
        panelDialogo.setLayout( new GridLayout( 6, 2 ) );
        
        panelDialogo.add(new JLabel("Id del tren:"));
		
		cbbIdTren = new JComboBox();
		cbbIdTren.setActionCommand( "Cambio Tren" );
        cbbIdTren.addActionListener( this );
        ArrayList idTrenes = principal.darIdsTrenes();
        for(int i = 0; i < idTrenes.size();i++)
        {
        	int id = (int) idTrenes.get(i);
        	cbbIdTren.addItem(id);
        }
    	panelDialogo.add( cbbIdTren);
		
		panelDialogo.add(new JLabel("Numero del vagon:"));
		
		txtNumeroVagones = new JTextField();
		txtNumeroVagones.setPreferredSize( new Dimension( 70, 10 ) );
        panelDialogo.add( txtNumeroVagones);
        
		panelDialogo.add(new JLabel("Cantidad de sillas:"));
		
		txtCantidadSillas = new JTextField();
		txtCantidadSillas.setPreferredSize( new Dimension( 70, 10 ) );
        panelDialogo.add( txtCantidadSillas);
        
		panelDialogo.add(new JLabel("Clase:"));
		
		JPanel panelClases = new JPanel();
		panelClases.setLayout( new GridLayout( 2, 2 ) );
		
		grupo = new ButtonGroup();
		
		botonPrimeraClase = new JRadioButton("Primera clase");
		grupo.add(botonPrimeraClase);
		panelClases.add(botonPrimeraClase);
		//botonPrimeraClase.setSelected(true);
				
		botonSegundaClase = new JRadioButton("Segunda clase");
		grupo.add(botonSegundaClase);
		panelClases.add(botonSegundaClase);
		//botonSegundaClase.setSelected(true);
		
		
		botonNegocios = new JRadioButton("Negocios");
		grupo.add(botonNegocios);
		panelClases.add(botonNegocios);
		//botonNegocios.setSelected(true);
		
		botonVIP = new JRadioButton("VIP");
		grupo.add(botonVIP);
		panelClases.add(botonVIP);
		//botonVIP.setSelected(true);
		
		panelDialogo.add(panelClases);
		
		panelDialogo.add(new JLabel("Precio:"));
		
		txtPrecio = new JTextField();
		txtPrecio.setPreferredSize( new Dimension( 70, 10 ) );
        panelDialogo.add( txtPrecio);
		
		btnAgregar = new JButton( " Agregar" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );
        panelDialogo.add( btnAgregar);
		
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelDialogo.add( btnCancelar);
        
	}

	@Override
	public void actionPerformed(ActionEvent pEvento) {
		// TODO Auto-generated method stub
		String comando = pEvento.getActionCommand();
		if(AGREGAR.equals(comando))
		{
			try
			{
				int idTren = (int) cbbIdTren.getSelectedItem();
				int numeroVagon = Integer.parseInt(txtNumeroVagones.getText());
				int cantidadSillas = Integer.parseInt(txtCantidadSillas.getText()); 
				double precio = Double.parseDouble(txtPrecio.getText());
				
				String claseSeleccionada = "";
				if(botonPrimeraClase.isSelected())
				{
					claseSeleccionada = "Primera Clase";
				}else if(botonSegundaClase.isSelected())
				{
					claseSeleccionada = "Segunda Clase";
				}else if(botonNegocios.isSelected())
				{
					claseSeleccionada = "Clase Negocios";
				}else if(botonVIP.isSelected())
				{
					claseSeleccionada = "Clase VIP";
				}
				principal.agregarVagon(idTren, numeroVagon, cantidadSillas, claseSeleccionada, precio);
				setVisible( false );
                dispose( );
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog( this, "El numero de sillas y numero del vagon deben ser un valor numérico.", "Eliminar ruta", JOptionPane.INFORMATION_MESSAGE );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(CANCELAR.equals(comando))
		{
			setVisible( false );
            dispose( );
		}
	}
	
	
	
	
}
