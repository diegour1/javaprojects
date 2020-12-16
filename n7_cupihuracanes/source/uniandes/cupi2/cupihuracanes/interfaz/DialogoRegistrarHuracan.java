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
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Di�logo para registrar un hurac�n.
 */
public class DialogoRegistrarHuracan extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

	/**
	 * Constante con la ruta de la imagen predefinida.
	 */
    private static final String RUTA_SIN_IMAGEN = "./data/imagenes/sinImagen.png";

    /**
     * Constante con la acci�n del bot�n de registrar un hurac�n. 
     */
    private static final String REGISTRAR = "RegistrarHuracan";

    /**
     * Constante con la acci�n del bot�n de buscar una imagen.
     */
    private static final String BUSCAR = "BuscarImagen";
    
    /**
     * Constante con la acci�n del bot�n de cerrar el di�logo.
     */
    private static final String CERRAR = "CERRAR";

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
     * Campo para la ruta hasta la imagen del hurac�n.
     */
    private JTextField txtImagen;

    /**
     * Campo para el nombre del hurac�n.
     */
    private JTextField txtNombre;

    /**
     * Campo para la categor�a del hurac�n.
     */
    private JTextField txtCategoria;

    /**
     * Campo para la velocidad del hurac�n.
     */
    private JTextField txtVelocidad;

    /**
     * Campo para el costo estimado en da�os del hurac�n.
     */
    private JTextField txtDanios;

    /**
     * Etiqueta para la imagen del hurac�n.
     */
    private JLabel etiquetaImagen;

    /**
     * Etiqueta para el nombre del hurac�n.
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta para la categor�a del hurac�n.
     */
    private JLabel etiquetaCategoria;

    /**
     * Etiqueta para el costo estimado en da�os del hurac�n.
     */
    private JLabel etiquetaDanios;

    /**
     * Etiqueta para la velocidad del hurac�n.
     */
    private JLabel etiquetaVelocidad;

    /**
     * Bot�n que se usa para registrar un hurac�n.
     */
    private JButton botonRegistrar;

    /**
     * Bot�n que se usa para seleccionar la imagen del hurac�n.
     */
    private JButton botonExaminar;
    
    /**
     * Bot�n que se usa para cerrar el di�logo.
     */
    private JButton botonCerrar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el di�logo e inicializa sus componentes.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public DialogoRegistrarHuracan( InterfazHuracanes pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new GridBagLayout( ) );
        setSize( new Dimension( 600, 170 ) );
        setTitle("Registrar hurac�n");

        JPanel panelDatos = new JPanel( new GridBagLayout( ) );

        // Nombre
        etiquetaNombre = new JLabel( "Nombre: " );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelDatos.add( etiquetaNombre, gbc );
        txtNombre = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;

        panelDatos.add( txtNombre, gbc );

        // Categor�a
        etiquetaCategoria = new JLabel( "Categor�a: " );
        etiquetaCategoria.setBorder( new EmptyBorder( 0, 5, 0, 0 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.EAST;

        panelDatos.add( etiquetaCategoria, gbc );
        txtCategoria = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panelDatos.add( txtCategoria, gbc );

        // Velocidad
        etiquetaVelocidad = new JLabel( "Velocidad: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelDatos.add( etiquetaVelocidad, gbc );
        txtVelocidad = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        panelDatos.add( txtVelocidad, gbc );

        // Costo en da�os
        etiquetaDanios = new JLabel( "Costo en Da�os: " );
        etiquetaDanios.setBorder( new EmptyBorder( 0, 5, 0, 0 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 1;
        panelDatos.add( etiquetaDanios, gbc );
        txtDanios = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.ipadx = 160;
        panelDatos.add( txtDanios, gbc );

        // Imagen
        etiquetaImagen = new JLabel( "Imagen: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelDatos.add( etiquetaImagen, gbc );
        txtImagen = new JTextField( "" );
        botonExaminar = new JButton( "Examinar" );
        botonExaminar.setActionCommand( BUSCAR );
        botonExaminar.addActionListener( this );

        // Bot�n agregar
        JPanel panelBoton = new JPanel( );
        botonRegistrar = new JButton( "Registrar hurac�n" );
        botonRegistrar.setActionCommand( REGISTRAR );
        botonRegistrar.addActionListener( this );
        panelBoton.add( botonRegistrar );
        
        botonCerrar = new JButton( "Cerrar" );
        botonCerrar.setActionCommand( CERRAR );
        botonCerrar.addActionListener( this );
        panelBoton.add( botonCerrar );

        JPanel panelImagen = new JPanel( new GridLayout( ) );

        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        panelImagen.add( txtImagen );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        panelImagen.add( botonExaminar );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelDatos.add( panelImagen, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add( panelDatos, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add( panelBoton, gbc );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * M�todo que se ejecuta cuando se hace click sobre un bot�n.
     * @param pEvento Evento del click sobre el bot�n.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( REGISTRAR.equals( comando ) )
        {
            try
            {
                String nombre = txtNombre.getText( );
                int categoria = Integer.parseInt( txtCategoria.getText( ) );
                String imagen = txtImagen.getText( );
                double danios = Double.parseDouble( txtDanios.getText( ) );
                int velocidad = Integer.parseInt( txtVelocidad.getText( ) );

                File archivo = new File( imagen );
                if( !archivo.exists( ) )
                {
                    imagen = RUTA_SIN_IMAGEN;
                    JOptionPane.showMessageDialog( null, "La ruta de la imagen no es v�lida. Se utilizar� una imagen por defecto.", "Agregar Hurac�n", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    try
                    {
                        BufferedImage bImagen = ImageIO.read( archivo );
                        if( bImagen == null )
                        {
                            imagen = RUTA_SIN_IMAGEN;
                            JOptionPane.showMessageDialog( null, "La ruta de la imagen no es v�lida. Se utilizar� una imagen por defecto.", "Agregar Hurac�n", JOptionPane.INFORMATION_MESSAGE );
                        }
                    }
                    catch( IOException e )
                    {
                        imagen = RUTA_SIN_IMAGEN;
                        JOptionPane.showMessageDialog( null, "La ruta de la imagen no es v�lida. Se utilizar� una imagen por defecto.", "Agregar Hurac�n", JOptionPane.INFORMATION_MESSAGE );
                    }
                }

                if( nombre == null || nombre.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar el nombre del hurac�n.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( categoria < 1 || categoria > 5 )
                {
                    JOptionPane.showMessageDialog( this, "La categor�a del hurac�n ingresada es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( danios < 0 )
                {
                    JOptionPane.showMessageDialog( this, "El costo estimado en da�os del hurac�n ingresado es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( velocidad < 0 )
                {
                    JOptionPane.showMessageDialog( this, "La velocidad del hurac�n ingresada es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( imagen == null || imagen.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar la imagen del hurac�n.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    principal.registrarHuracan( nombre, categoria, velocidad, danios, imagen );

                    txtNombre.setText( "" );
                    txtCategoria.setText( "" );
                    txtImagen.setText( "" );
                    txtDanios.setText( "" );
                    txtVelocidad.setText( "" );
                    this.dispose();
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "La categor�a debe ser un n�mero entero. Los da�os y la velocidad deben ser n�meros reales.", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( BUSCAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data" );
            fc.setDialogTitle( "Buscar imagen de hurac�n." );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                String imagen = fc.getSelectedFile( ).getAbsolutePath( );
                txtImagen.setText( imagen );
            }
        }
        else if (CERRAR.equals(comando))
        {
        	this.dispose();
        }

    }

}
