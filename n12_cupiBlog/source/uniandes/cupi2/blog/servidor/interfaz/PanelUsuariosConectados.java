package uniandes.cupi2.blog.servidor.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class PanelUsuariosConectados extends JPanel implements ActionListener
{
	// -------------------------------------------------------------
    // Constantes del panel
    // -------------------------------------------------------------
	
	/**
     * Constante para el boton actualizar.
     */
	
	public static final String ACTUALIZAR = "ACTUALIZAR";
	
	// -------------------------------------------------------------
    // Atributos del panel
    // -------------------------------------------------------------

	/**
     * Ventana principal de la interfaz servidor
     */
	
	private InterfazServidorBlog principalServidor;
	
	/**
     * Boton actualizar lista de usuarios conectados.
     */
	
	private JButton btnActualizar;
	
	/**
     * JScrollPane donde muestra la lista de usuarios conectados.
     */
	
	private JScrollPane scrollListaUsuarios;
	
	// -------------------------------------------------------------
    // Constructor del panel
    // -------------------------------------------------------------	
		

	public PanelUsuariosConectados(InterfazServidorBlog interfazServidorBlog)  
	{	
		principalServidor = interfazServidorBlog;
		
		setBorder(new TitledBorder("Usuarios Conectados"));	
		setLayout(new BorderLayout());
		
		//se inicializa el scroll
		scrollListaUsuarios = new JScrollPane();
		scrollListaUsuarios.setPreferredSize(new Dimension(263, 500));
		scrollListaUsuarios.getViewport( );
		
		//se inicializa el boton actualizar
		
		btnActualizar = new JButton("Actualizar Lista");
		btnActualizar.addActionListener(this);
		btnActualizar.setActionCommand(ACTUALIZAR);
		
		//Se agregan los componentes al panel 
		add(scrollListaUsuarios, BorderLayout.CENTER);
		add(btnActualizar, BorderLayout.SOUTH);
	}

	// -------------------------------------------------------------
    // Metodos del panel
    // -------------------------------------------------------------	
	
	
	
	public void actionPerformed(ActionEvent evento)
	{
		String comando = evento.getActionCommand( );

        if( ACTUALIZAR.equals( comando ) )
        {
            principalServidor.actualizarUsuarios( );
        }
	}

}
