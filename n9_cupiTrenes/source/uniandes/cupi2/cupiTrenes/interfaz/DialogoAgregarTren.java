/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_cupiTrenes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTrenes.interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Diálogo para agregar un tren.
 */
public class DialogoAgregarTren extends JDialog implements ActionListener
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa el comando para agregar.
     */
    private final static String AGREGAR = "Agregar";

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiTrenes principal;

    /**
     * Cantidad de paradas del tren.
     */
    private int cantidadParadas;

    // -------------------------------------------------------------
    // Atributos de la interfaz
    // -------------------------------------------------------------

    /**
     * Campo de texto para ingresar el id del tren.
     */
    private JTextField txtIdTren;

    /**
     * Arreglo con los campos de texto para ingresar las paradas.
     */
    private JTextField[] paradas;

    /**
     * Arreglo con los comboboxes para ingresar las horas.
     */
    private JComboBox[] horas;

    /**
     * Arreglo con los comboboxes para ingresar los minutos.
     */
    private JComboBox[] minutos;

    /**
     * Botón para agregar.
     */
    private JButton btnAgregar;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Construye un diálogo para agregar un tren.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     * @param pCantidadParadas Cantidad de paradas. pCantidadParadas >= 2.
     */
    public DialogoAgregarTren( InterfazCupiTrenes pPrincipal, int pCantidadParadas )
    {
        principal = pPrincipal;
        cantidadParadas = pCantidadParadas;
        setTitle( "Agregar un tren" );
        setSize( 300, 220 + 60 * pCantidadParadas );

        paradas = new JTextField[cantidadParadas];
        horas = new JComboBox[cantidadParadas];
        minutos = new JComboBox[cantidadParadas];

        JPanel panelAgregarParadas = new JPanel( );
        panelAgregarParadas.setBorder( new TitledBorder( "Agregar paradas" ) );
        panelAgregarParadas.setLayout( new GridBagLayout( ) );

        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );

        panelAgregarParadas.add( new JLabel( "Id:" ), gbc );
        gbc.gridy++;
        txtIdTren = new JTextField( );
        txtIdTren.setPreferredSize( new Dimension( 50, 20 ) );
        panelAgregarParadas.add( txtIdTren, gbc );
        gbc.gridy++;
        panelAgregarParadas.add( new JLabel( ), gbc );
        gbc.gridy++;

        for( int i = 1; i <= cantidadParadas; i++ )
        {
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 3;
            panelAgregarParadas.add( new JLabel( "Parada " + i ), gbc );
            panelAgregarParadas.add( new JLabel( ), gbc );
            gbc.gridy++;
            paradas[ i - 1 ] = new JTextField( "" );
            paradas[ i - 1 ].setPreferredSize( new Dimension( 100, 20 ) );
            panelAgregarParadas.add( paradas[ i - 1 ], gbc );

            gbc.gridwidth = 1;
            gbc.gridx += 3;

            horas[ i - 1 ] = new JComboBox( );
            for( int j = 0; j <= 23; j++ )
            {
                if( j < 10 )
                {
                    horas[ i - 1 ].addItem( "0" + j );
                }
                else
                {
                    horas[ i - 1 ].addItem( "" + j );
                }
            }

            panelAgregarParadas.add( horas[ i - 1 ], gbc );
            gbc.gridx++;
            panelAgregarParadas.add( new JLabel( ":" ), gbc );
            gbc.gridx++;

            minutos[ i - 1 ] = new JComboBox( );
            for( int j = 0; j <= 60; j += 5 )
            {
                if( j < 10 )
                {
                    minutos[ i - 1 ].addItem( "0" + j );
                }
                else
                {
                    minutos[ i - 1 ].addItem( "" + j );
                }
            }
            panelAgregarParadas.add( minutos[ i - 1 ], gbc );
            gbc.gridx++;
        }
        gbc.gridy++;
        gbc.gridx = 1;
        panelAgregarParadas.add( new JLabel( ), gbc );

        gbc.gridy++;
        gbc.gridwidth = 5;
        btnAgregar = new JButton( " Agregar" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );
        panelAgregarParadas.add( btnAgregar, gbc );

        add( panelAgregarParadas );
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( AGREGAR.equals( comando ) )
        {
            try
            {
                int idRuta = Integer.parseInt( txtIdTren.getText( ) );
                boolean puedeAgregar = true;
                String[] paradas = new String[cantidadParadas];
                Date[] horarios = new Date[cantidadParadas];
                for( int i = 0; i < cantidadParadas; i++ )
                {
                    paradas[ i ] = this.paradas[ i ].getText( );
                    if( paradas[ i ].equals( "" ) )
                    {

                        JOptionPane.showMessageDialog( this, "Debe ingresar el nombre de todas las paradas.", "Agregare tren", JOptionPane.ERROR_MESSAGE );
                    }
                    String a = ( String )horas[ i ].getSelectedItem( );
                    String b = ( String )minutos[ i ].getSelectedItem( );
                    horarios[ i ] = new Date( 0, 0, 0, Integer.parseInt( a ), Integer.parseInt( b ) );

                    if( i > 0 && horarios[ i ].compareTo( horarios[ i - 1 ] ) < 0 )
                    {
                        JOptionPane.showMessageDialog( this, "El horario de las paradas debe estar ordenado.", "Agregar tren", JOptionPane.ERROR_MESSAGE );
                        puedeAgregar = false;
                    }
                    else if(i > 0 && horarios[ i ].compareTo( horarios[ i - 1 ] ) == 0 )
                    {
                        JOptionPane.showMessageDialog( this, "El horario de la parada ["+paradas[ i - 1 ] +"] debe diferente al de la parada ["+paradas[ i ]+"]." , "Agregar tren", JOptionPane.ERROR_MESSAGE );
                        puedeAgregar = false;
                    }
                }
                if( puedeAgregar )
                {
                    principal.agregarTren( idRuta, paradas, horarios );

                    this.dispose( );                        
                }
            }
            catch( NumberFormatException ex )
            {
                JOptionPane.showMessageDialog( this, "El identificador del tren debe ser un valor numérico.", "Agregar tren", JOptionPane.ERROR_MESSAGE );
            }
            catch( Exception pE )
            {
                JOptionPane.showMessageDialog( this, pE.getMessage(), "Agregar tren", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}
