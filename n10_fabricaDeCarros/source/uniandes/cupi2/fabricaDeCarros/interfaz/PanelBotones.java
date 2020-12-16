/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: fabricaDeCarros
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.fabricaDeCarros.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

/**
 * Este es el panel donde se encuentran los botones y controles de la aplicación.
 */
public class PanelBotones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el color de fondo.
     */
    private static final String COLOR_FONDO = "Fondo";

    /**
     * Constante que representa el botón seleccionar.
     */
    public static final String SELECCIONAR = "Seleccionar";

    /**
     * Constante que representa ningún botón seleccionado.
     */
    public static final String NINGUNA = "Ninguna";

    /**
     * Constante que representa ningún botón borrar.
     */
    public static final String BORRAR = "Borrar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazFabricaDeCarros principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Arreglo de botones.
     */
    private JToggleButton[] botones;

    /**
     * Grupo de los botones.
     */
    private ButtonGroup grupo;

    /**
     * Botón para elegir el color del carro.
     */
    private JButton btnColorCarro;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes.<br>
     * <b> post: </b> Se inicializa el panel con la interfaz de fábrica de carros dada por parámetro.
     * @param pInterfazPrincipal Es una referencia a la clase principal de la interfaz. pInterfazPrincipal !=null.
     */
    public PanelBotones( InterfazFabricaDeCarros pInterfazPrincipal )
    {
        String dirImagenes = "." + File.separator + "data" + File.separator + "imagenes" + File.separator;

        principal = pInterfazPrincipal;

        setBorder( new TitledBorder( "" ) );

        ArrayList tipos = new ArrayList( );
        tipos.add( SELECCIONAR );
        tipos.add( BORRAR );
        tipos.addAll( pInterfazPrincipal.darOpcionesSeleccion( ) );
        botones = new JToggleButton[tipos.size( ) ];
        grupo = new ButtonGroup( );
        String tipo;
        for( int i = 0; i < tipos.size( ); i++ )
        {
            tipo = ( String )tipos.get( i );
            botones[ i ] = new JToggleButton( new ImageIcon( dirImagenes + "boton" + tipo + ".gif" ) );
            botones[ i ].setPreferredSize( new Dimension( 50, 50 ) );
            botones[ i ].setToolTipText( tipo );
            botones[ i ].setActionCommand( tipo );
            if( tipo.equals( BORRAR ) )
            {
                botones[ i ].addActionListener( this );
            }
            grupo.add( botones[ i ] );
        }

        btnColorCarro = new JButton( " " );
        btnColorCarro.setActionCommand( COLOR_FONDO );
        btnColorCarro.setBackground( new Color( 200, 0, 0 ) );
        btnColorCarro.addActionListener( this );
        btnColorCarro.setToolTipText( "Color Fondo" );

        setLayout( new GridBagLayout( ) );
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 2, 2, 2, 2 ), 0, 0 );

        int b = 0;
        int tam = botones.length;
        for( int i = 0; i < tam + 1 / 2; i++ )
        {
            for( int j = 0; j < 2; j++ )
            {
                if( b != tam )
                {

                    gbc.gridx = j;
                    gbc.gridy = i;
                    add( botones[ b ], gbc );
                    b++;
                }

            }
        }

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = botones.length / 2 + 1;
        add( btnColorCarro, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la opción seleccionada.
     * @return La opción seleccionada en este panel.
     */
    public String darOpcionSeleccionada( )
    {
        ArrayList opciones = principal.darOpcionesSeleccion( );
        String tipoSeleccionado = NINGUNA;
        if(botones[0].isSelected( ))
        {
            tipoSeleccionado = SELECCIONAR;
        }
        else if(botones[1].isSelected( ))
        {
            tipoSeleccionado = BORRAR;
        }
        else
        {
            boolean seleccionado = false;
            for( int i = 2; i < botones.length && !seleccionado; i++ )
            {
                seleccionado = botones[ i ].isSelected( );
                if( seleccionado )
                {
                    tipoSeleccionado = (String) opciones.get( i-2 );
                }
            }
        }
        return tipoSeleccionado;
    }
    /**
     * Retorna el color elegido para el fondo de los carros.
     * @return Color de fondo.
     */
    public Color darColorFondo( )
    {
        return btnColorCarro.getBackground( );
    }

    /**
     * Ejecuta la acción que corresponde al botón oprimido.
     * @param pEvento Es el evento del click sobre un botón. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( BORRAR.equals( comando ) )
        {
            principal.eliminar( );
        }
        else if( COLOR_FONDO.equals( comando ) )
        {
            Color colorFondo = JColorChooser.showDialog( this, "Color del fondo", btnColorCarro.getBackground( ) );
            btnColorCarro.setBackground( colorFondo );
        }
    }

}
