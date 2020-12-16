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
import java.awt.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazSubasta extends JFrame
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Subasta subasta;

    /**
     * Panel con la información del celular 1.
     */
    private PanelProducto producto1;

    /**
     * Panel con la información del celular 2.
     */
    private PanelProducto producto2;

    /**
     * Panel con la información del celular 3.
     */
    private PanelProducto producto3;

    /**
     * Panel con imagen del banner.
     */
    private PanelBanner panelBanner;

    /**
     * Panel con las opciones de extensión.
     */
    private PanelExtensiones panelExtensiones;

    /**
     * Panel con la información general de la subasta.
     */
    private PanelResumen panelResumen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana principal.
     */
    public InterfazSubasta( )
    {

        setTitle( "Subasta celulares" );

        subasta = new Subasta( );

        producto1 = new PanelProducto( this, 1 );

        producto2 = new PanelProducto( this, 2 );

        producto3 = new PanelProducto( this, 3 );

        panelBanner = new PanelBanner( );

        panelExtensiones = new PanelExtensiones( this );

        panelResumen = new PanelResumen( this );

        JPanel panelCelulares = new JPanel( );
        panelCelulares.setLayout( new GridLayout( 1, 3 ) );
        panelCelulares.add( producto1 );
        panelCelulares.add( producto2 );
        panelCelulares.add( producto3 );

        JPanel panelInferior = new JPanel( );
        panelInferior.setLayout( new BorderLayout( ) );

        panelInferior.add( panelResumen, BorderLayout.CENTER );
        panelInferior.add( panelExtensiones, BorderLayout.SOUTH );

        setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelBanner, BorderLayout.NORTH );
        getContentPane( ).add( panelCelulares, BorderLayout.CENTER );
        getContentPane( ).add( panelInferior, BorderLayout.SOUTH );

        setSize( 800, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        actualizarPaneles( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Registra una oferta dado el número del celular por el cual se quiere realizar la oferta y el tipo de oferta.
     * @param pNumCelular El número del celular a ofertar.
     * @param pTipoOferta El tipo de oferta. pTipoOferta=(TIPO_OFERTA_MINIMA|TIPO_OFERTA_MODERADA).
     */
    public void registrarOferta( int pNumCelular, int pTipoOferta )
    {
        if( pNumCelular == 1 )
        {
            if( pTipoOferta == PanelProducto.TIPO_OFERTA_MINIMA )
            {
                subasta.registrarOfertaMinimaCelular1( );
            }
            else if( pTipoOferta == PanelProducto.TIPO_OFERTA_MODERADA )
            {
                subasta.registrarOfertaModeradaCelular1( );
            }
        }
        else if( pNumCelular == 2 )
        {
            if( pTipoOferta == PanelProducto.TIPO_OFERTA_MINIMA )
            {
                subasta.registrarOfertaMinimaCelular2( );
            }
            else if( pTipoOferta == PanelProducto.TIPO_OFERTA_MODERADA )
            {
                subasta.registrarOfertaModeradaCelular2( );
            }
        }
        else if( pNumCelular == 3 )
        {
            if( pTipoOferta == PanelProducto.TIPO_OFERTA_MINIMA )
            {
                subasta.registrarOfertaMinimaCelular3( );
            }
            else if( pTipoOferta == PanelProducto.TIPO_OFERTA_MODERADA )
            {
                subasta.registrarOfertaModeradaCelular3( );
            }
        }
        actualizarPaneles( );
        JOptionPane.showMessageDialog( this, "Oferta registrada para el celular " + pNumCelular );
    }

    /**
     * Registrar una oferta abierta.
     * @param pNumCelular Número del celular por el cual se registra la oferta.
     * @param pValorOferta El valor de la oferta. pValorOferta > 0.
     */
    public void registrarOfertaAbierta( int pNumCelular, int pValorOferta )
    {
        if( pNumCelular == 1 )
        {
            subasta.registrarOfertaAbiertaCelular1( pValorOferta );
        }
        else if( pNumCelular == 2 )
        {
            subasta.registrarOfertaAbiertaCelular2( pValorOferta );
        }
        else if( pNumCelular == 3 )
        {
            subasta.registrarOfertaAbiertaCelular3( pValorOferta );
        }
        actualizarPaneles( );
        JOptionPane.showMessageDialog( this, "Oferta registrada para el celular " + pNumCelular );
    }

    /**
     * Reinicia la subasta y actualiza la interfaz.
     */
    public void reiniciarSubasta( )
    {
        subasta.reiniciarSubasta( );
        actualizarPaneles( );
    }

    /**
     * Actualiza la interfaz con la información del mundo.
     */
    private void actualizarPaneles( )
    {
        producto1.actualizar( subasta.darCelular1( ) );
        producto2.actualizar( subasta.darCelular2( ) );
        producto3.actualizar( subasta.darCelular3( ) );
        panelResumen.actualizar( subasta );
    }

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1a( )
    {
        String resultado = subasta.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2a( )
    {
        String resultado = subasta.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param args
     */
    public static void main( String[] args )
    {
        try
        {
            for( LookAndFeelInfo info : UIManager.getInstalledLookAndFeels( ) )
            {
                if( "Nimbus".equals( info.getName( ) ) )
                {
                    UIManager.setLookAndFeel( info.getClassName( ) );
                    break;
                }
            }
        }
        catch( Exception e )
        {
        }
        InterfazSubasta interfazSubasta = new InterfazSubasta( );
        interfazSubasta.setVisible( true );
    }

}