/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
 * Diálogo para registrar un huracán.
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
     * Constante con la acción del botón de registrar un huracán. 
     */
    private static final String REGISTRAR = "RegistrarHuracan";

    /**
     * Constante con la acción del botón de buscar una imagen.
     */
    private static final String BUSCAR = "BuscarImagen";
    
    /**
     * Constante con la acción del botón de cerrar el diálogo.
     */
    private static final String CERRAR = "CERRAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazHuracanes principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo para la ruta hasta la imagen del huracán.
     */
    private JTextField txtImagen;

    /**
     * Campo para el nombre del huracán.
     */
    private JTextField txtNombre;

    /**
     * Campo para la categoría del huracán.
     */
    private JTextField txtCategoria;

    /**
     * Campo para la velocidad del huracán.
     */
    private JTextField txtVelocidad;

    /**
     * Campo para el costo estimado en daños del huracán.
     */
    private JTextField txtDanios;

    /**
     * Etiqueta para la imagen del huracán.
     */
    private JLabel etiquetaImagen;

    /**
     * Etiqueta para el nombre del huracán.
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta para la categoría del huracán.
     */
    private JLabel etiquetaCategoria;

    /**
     * Etiqueta para el costo estimado en daños del huracán.
     */
    private JLabel etiquetaDanios;

    /**
     * Etiqueta para la velocidad del huracán.
     */
    private JLabel etiquetaVelocidad;

    /**
     * Botón que se usa para registrar un huracán.
     */
    private JButton botonRegistrar;

    /**
     * Botón que se usa para seleccionar la imagen del huracán.
     */
    private JButton botonExaminar;
    
    /**
     * Botón que se usa para cerrar el diálogo.
     */
    private JButton botonCerrar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo e inicializa sus componentes.
     * @param pPrincipal Ventana principal de la aplicación.
     */
    public DialogoRegistrarHuracan( InterfazHuracanes pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new GridBagLayout( ) );
        setSize( new Dimension( 600, 170 ) );
        setTitle("Registrar huracán");

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

        // Categoría
        etiquetaCategoria = new JLabel( "Categoría: " );
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

        // Costo en daños
        etiquetaDanios = new JLabel( "Costo en Daños: " );
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

        // Botón agregar
        JPanel panelBoton = new JPanel( );
        botonRegistrar = new JButton( "Registrar huracán" );
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
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que se ejecuta cuando se hace click sobre un botón.
     * @param pEvento Evento del click sobre el botón.
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
                    JOptionPane.showMessageDialog( null, "La ruta de la imagen no es válida. Se utilizará una imagen por defecto.", "Agregar Huracán", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    try
                    {
                        BufferedImage bImagen = ImageIO.read( archivo );
                        if( bImagen == null )
                        {
                            imagen = RUTA_SIN_IMAGEN;
                            JOptionPane.showMessageDialog( null, "La ruta de la imagen no es válida. Se utilizará una imagen por defecto.", "Agregar Huracán", JOptionPane.INFORMATION_MESSAGE );
                        }
                    }
                    catch( IOException e )
                    {
                        imagen = RUTA_SIN_IMAGEN;
                        JOptionPane.showMessageDialog( null, "La ruta de la imagen no es válida. Se utilizará una imagen por defecto.", "Agregar Huracán", JOptionPane.INFORMATION_MESSAGE );
                    }
                }

                if( nombre == null || nombre.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar el nombre del huracán.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( categoria < 1 || categoria > 5 )
                {
                    JOptionPane.showMessageDialog( this, "La categoría del huracán ingresada es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( danios < 0 )
                {
                    JOptionPane.showMessageDialog( this, "El costo estimado en daños del huracán ingresado es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( velocidad < 0 )
                {
                    JOptionPane.showMessageDialog( this, "La velocidad del huracán ingresada es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( imagen == null || imagen.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar la imagen del huracán.", "Error", JOptionPane.ERROR_MESSAGE );
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
                JOptionPane.showMessageDialog( this, "La categoría debe ser un número entero. Los daños y la velocidad deben ser números reales.", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( BUSCAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data" );
            fc.setDialogTitle( "Buscar imagen de huracán." );
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
