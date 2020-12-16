/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_subastaCelulares
 * Autor: Equipo Cupi2 - 201910
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.cupi2.subastas.interfaz;

import co.edu.uniandes.cupi2.subastas.mundo.Subasta;
import co.edu.uniandes.cupi2.subastas.mundo.Celular;
import javax.swing.border.*;
import javax.swing.*;
import java.io.Serializable;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;

/**
 * Panel con la información de un producto.
 */
public class PanelProducto extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para realizar una oferta.
     */
    public final static String REALIZAR_OFERTA = "REALIZAR_OFERTA";

    /**
     * Constante para la oferta mínima.
     */
    public final static int TIPO_OFERTA_MINIMA = 1;

    /**
     * Constante para la oferta moderada.
     */
    public final static int TIPO_OFERTA_MODERADA = 2;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Identificador del número de celular para el que se muestra la información.
     */
    private int numTelefono;

    /**
     * Etiqueta que muestra el modelo del celular.
     */
    private JLabel lblModelo;

    /**
     * Etiqueta que muestra el costo base del celular.
     */
    private JLabel lblCostoBase;

    /**
     * Etiqueta que muestra la marca del celular.
     */
    private JLabel lblMarca;

    /**
     * Etiqueta que muestra el número de ofertas realizadas por el celular.
     */
    private JLabel lblNoOfertas;

    /**
     * Etiqueta que muestra el valor total de las ofertas realizadas por el celular.
     */
    private JLabel lblValorTotal;

    /**
     * Campo de texto para el valor del modelo del celular.
     */
    private JTextField txtModelo;

    /**
     * Campo de texto para el valor del coto base del celular.
     */
    private JTextField txtCostoBase;

    /**
     * Campo de texto para el valor de la marca del celular.
     */
    private JTextField txtMarca;

    /**
     * Campo de texto para el valor del número de ofertas celular.
     */
    private JTextField txtNoOfertas;

    /**
     * Campo de texto para el valor del valor total del celular.
     */
    private JTextField txtValorTotal;

    /**
     * Etiqueta que muestra la imagen del celular.
     */
    private JLabel imgTelefono;

    /**
     * Botón que registra una oferta por el celular.
     */
    private JButton btnOferta;

    /**
     * Separador.
     */
    private JSeparator separador;

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazSubasta principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los productos de la subasta
     * @param pVentanaPrincipal Ventana principal de la aplicación. pVentanaPrincipal != null
     * @param pNumTelefono Numero del telefono a mostrar
     */
    public PanelProducto( InterfazSubasta pVentanaPrincipal, int pNumTelefono )
    {
        principal = pVentanaPrincipal;

        // setBorder(BorderFactory.createTitledBorder("Celular"));

        numTelefono = pNumTelefono;

        lblModelo = new JLabel( "Modelo:" );

        lblCostoBase = new JLabel( "Costo base($):" );

        lblMarca = new JLabel( "Marca:" );

        lblNoOfertas = new JLabel( "Número de ofertas:" );

        lblValorTotal = new JLabel( "Valor total ofertas($):" );

        imgTelefono = new JLabel( );
        imgTelefono.setHorizontalAlignment( JLabel.CENTER );
        imgTelefono.setVerticalAlignment( JLabel.CENTER );
        imgTelefono.setIcon( new ImageIcon( "./data/celular" + numTelefono + ".png" ) );

        btnOferta = new JButton( "Ofertar" );
        btnOferta.setActionCommand( REALIZAR_OFERTA );
        btnOferta.addActionListener( this );
        btnOferta.setIcon( new ImageIcon( "./data/saco.png" ) );

        separador = new JSeparator( );

        txtModelo = new JTextField( );
        txtModelo.setEditable( false );
        txtCostoBase = new JTextField( );
        txtCostoBase.setEditable( false );
        txtMarca = new JTextField( );
        txtMarca.setEditable( false );
        txtNoOfertas = new JTextField( );
        txtNoOfertas.setEditable( false );
        txtValorTotal = new JTextField( );
        txtValorTotal.setEditable( false );

        JPanel pnlInformacion = new JPanel( );
        pnlInformacion.setLayout( new GridLayout( 6, 1 ) );
        pnlInformacion.add( lblModelo );
        pnlInformacion.add( txtModelo );
        pnlInformacion.add( lblMarca );
        pnlInformacion.add( txtMarca );
        pnlInformacion.add( lblCostoBase );
        pnlInformacion.add( txtCostoBase );
        pnlInformacion.add( lblNoOfertas );
        pnlInformacion.add( txtNoOfertas );
        pnlInformacion.add( lblValorTotal );
        pnlInformacion.add( txtValorTotal );
        pnlInformacion.add( separador );
        pnlInformacion.add( new JSeparator( ) );

        JPanel pnlBoton = new JPanel( );
        pnlBoton.setLayout( new BorderLayout( ) );

        pnlBoton.add( btnOferta, BorderLayout.CENTER );

        setLayout( new BorderLayout( ) );
        add( pnlInformacion, BorderLayout.NORTH );
        add( imgTelefono, BorderLayout.CENTER );
        add( pnlBoton, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Registra una oferta por el celular .
     */
    private void realizarOferta( )
    {
        Object[] possibilities = { "Mínima", "Moderada", "Abierta" };
        String tipoOferta = ( String )JOptionPane.showInputDialog( this, "¿Qué tipo de oferta desea hacer?", "Tipo de oferta", JOptionPane.QUESTION_MESSAGE, null, possibilities, "Mínima" );
        if( tipoOferta != null )
            if( tipoOferta.equals( "Mínima" ) )
            {
                principal.registrarOferta( numTelefono, TIPO_OFERTA_MINIMA );
            }
            else if( tipoOferta.equals( "Moderada" ) )
            {
                principal.registrarOferta( numTelefono, TIPO_OFERTA_MODERADA );
            }
            else if( tipoOferta.equals( "Abierta" ) )
            {
                String valor = JOptionPane.showInputDialog( this, "Valor Deseado" );
                if( valor != null )
                {
                    try
                    {
                        principal.registrarOfertaAbierta( numTelefono, Integer.valueOf( valor ).intValue( ) );
                    }
                    catch( NumberFormatException e )
                    {
                        JOptionPane.showMessageDialog( this, "Formato inválido", "Tipo de oferta", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                    JOptionPane.showMessageDialog( this, "Debe ingresar un valor", "Tipo de oferta", JOptionPane.ERROR_MESSAGE );
            }
    }

    /**
     * Actualiza la información del panel.
     * @param pTelefono Telefono de donde se obtiene la información. pTelefono != null.
     */
    public void actualizar( Celular pTelefono )
    {
        txtModelo.setText( pTelefono.darModelo( ) );
        txtCostoBase.setText( pTelefono.darCostoBase( ) + "" );
        txtMarca.setText( pTelefono.darMarca( ) );
        txtNoOfertas.setText( +pTelefono.darNumeroOfertas( ) + "" );
        txtValorTotal.setText( +pTelefono.darValorTotalOfertas( ) + "" );
    }

    /**
     * Manejo de eventos del usuario
     * @param e Evento de usuario. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( REALIZAR_OFERTA ) )
        {
            realizarOferta( );
        }

    }

}