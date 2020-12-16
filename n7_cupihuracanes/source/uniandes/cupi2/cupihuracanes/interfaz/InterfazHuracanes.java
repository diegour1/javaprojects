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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupihuracanes.mundo.Huracan;
import uniandes.cupi2.cupihuracanes.mundo.SistemaHuracanes;

/**
 * Ventana principal de la aplicaci�n.
 */
public class InterfazHuracanes extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante con la ruta al archivo de persistencia del sistema.
     */
    public static final String ARCHIVO_HURACANES = "./data/huracanes.txt";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia al sistema de huracanes.
     */
    private SistemaHuracanes sistemahuracanes;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel donde se muestra la lista de huracanes.
     */
    private PanelListaHuracanes panelLista;

    /**
     * Panel donde se muestran los datos de un hurac�n.
     */
    private PanelDatosHuracan panelDatos;

    /**
     * Panel donde est�n los botones para los puntos de extensi�n.
     */
    private PanelExtension panelExtension;

    /**
     * Panel de ordenamientos.
     */
    private PanelOrdenamientos panelOrdenamientos;

    /**
     * Panel de consultas.
     */
    private PanelConsultas panelConsultas;

    /**
     * Panel con el banner del ejercicio.
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz e inicializa todos sus componentes.
     * @param pArchivo Nombre del archivo de propiedades que contiene la informaci�n de los huracanes.
     */
    public InterfazHuracanes( String pArchivo )
    {
        // Crea la clase principal
        sistemahuracanes = new SistemaHuracanes( );
        cargarHuracanes( pArchivo );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "CupiHuracanes" );
        setSize( new Dimension( 800, 650 ) );
        setResizable( false );

        setLayout( new BorderLayout( ) );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        JPanel panelHuracanes = new JPanel( );
        panelHuracanes.setBorder( new TitledBorder( "Huracanes del sistema" ) );
        panelLista = new PanelListaHuracanes( this );
        panelDatos = new PanelDatosHuracan( );
        panelHuracanes.setLayout( new BorderLayout( ) );
        panelHuracanes.add( panelLista, BorderLayout.WEST );
        panelHuracanes.add( panelDatos, BorderLayout.CENTER );
        add( panelHuracanes, BorderLayout.CENTER );

        JPanel panelAcciones = new JPanel( );
        panelAcciones.setLayout( new GridLayout( 2, 1 ) );

        panelOrdenamientos = new PanelOrdenamientos( this );
        panelAcciones.add( panelOrdenamientos );
        panelConsultas = new PanelConsultas( this );
        panelAcciones.add( panelConsultas );
        add( panelAcciones, BorderLayout.EAST );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        setLocationRelativeTo( null );
        actualizarLista( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de huracanes mostrada.
     */
    private void actualizarLista( )
    {
        panelLista.refrescarLista( sistemahuracanes.darHuracanes( ) );
    }

    /**
     * Ordena los huracanes por velocidad y actualiza la lista.
     */
    public void ordenarPorVelocidad( )
    {
        sistemahuracanes.ordenarPorVelocidad( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Ordena los huracanes por nombre y actualiza la lista.
     */
    public void ordenarPorNombre( )
    {
        sistemahuracanes.ordenarPorNombre( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Ordena los huracanes por costo estimado en da�os y actualiza la lista.
     */
    public void ordenarPorCostoDanios( )
    {
        sistemahuracanes.ordenarPorDanios( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Busca un hurac�n usando el nombre. Cuando lo encuentra, lo selecciona en la lista y muestra sus datos.
     */
    public void buscar( )
    {
        String nombreBuscado = JOptionPane.showInputDialog( this, "Nombre del hurac�n" );
        if( nombreBuscado != null )
        {
            int posicion = sistemahuracanes.buscarBinarioPorNombre( nombreBuscado );

            if( posicion != -1 )
            {
                actualizarLista( );
                panelLista.seleccionar( posicion );
                Huracan p = ( Huracan )sistemahuracanes.darHuracanes( ).get( posicion );
                actualizarInformacionHuracan( p );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No se encontr� el hurac�n" );
            }
        }
    }

    /**
     * Actualiza los datos de un hurac�n en el panel correspondiente.
     * @param pHuracan es el hurac�n del cual se quieren ver los datos. pHurac�n != null
     */
    public void actualizarInformacionHuracan( Huracan pHuracan )
    {
        panelDatos.actualizarInformacionHuracan( pHuracan );
    }

    /**
     * Registra un nuevo hurac�n.
     * @param pNombre Nombre del hurac�n. pNombre != null && pNombre != "".
     * @param pCategoria Categor�a del hurac�n. 0 < pCategoria < 6.
     * @param pVelocidad Velocidad del hurac�n. pVelocidad > 0.
     * @param pCostoEstimadoDanios Costo estimado en da�os del hurac�n. pCostoEstimadoDanios > 0.
     * @param pImagen Ruta a la imagen del hurac�n. pImagen != null && pImagen != "".
     */
    public void registrarHuracan( String pNombre, int pCategoria, int pVelocidad, double pCostoEstimadoDanios, String pImagen )
    {
        boolean agrego = sistemahuracanes.registrarHuracan( pNombre, pCategoria, pVelocidad, pCostoEstimadoDanios, pImagen );
        if( !agrego )
            JOptionPane.showMessageDialog( this, "No se pudo agregar el hurac�n " + pNombre + ".\n  Ya existe un hurac�n con ese nombre.", "Registrar Hurac�n", JOptionPane.ERROR_MESSAGE );
        else
        {
            actualizarLista( );
            panelLista.seleccionar( sistemahuracanes.darHuracanes( ).size( ) - 1 );
        }
    }

    /**
     * Carga los datos de los huracanes a partir de un archivo de propiedades.
     * @param Archivo que contiene la informaci�n de los huracanes.
     */
    private void cargarHuracanes( String archivo )
    {
        try
        {
            FileInputStream fis = new FileInputStream( new File( archivo ) );
            Properties propiedades = new Properties( );
            propiedades.load( fis );

            // Cargar los huracanes
            String dato;
            String nombre;
            int categoria;
            int velocidad;
            double costoDanios;
            String imagen;
            String aux;
            dato = "total.huracanes";
            aux = propiedades.getProperty( dato );
            int cantidadHuracanes = Integer.parseInt( aux );

            for( int cont = 1; cont <= cantidadHuracanes; cont++ )
            {
                // Carga un hurac�n
                dato = "huracan" + cont + ".nombre";
                nombre = propiedades.getProperty( dato );

                dato = "huracan" + cont + ".categoria";
                categoria = Integer.parseInt( propiedades.getProperty( dato ) );

                dato = "huracan" + cont + ".velocidad";
                velocidad = Integer.parseInt( propiedades.getProperty( dato ) );

                dato = "huracan" + cont + ".costoDanios";
                costoDanios = Double.parseDouble( propiedades.getProperty( dato ) );

                dato = "huracan" + cont + ".imagen";
                imagen = propiedades.getProperty( dato );

                // S�lo se carga el hurac�n si los datos son correctos
                if( nombre != null && categoria > 0 && categoria < 6 && velocidad > 0 && costoDanios >= 0 && imagen != null )
                    sistemahuracanes.registrarHuracan( nombre, categoria, velocidad, costoDanios, imagen );
                fis.close( );
            }
        }
        catch( FileNotFoundException e )
        {
            JOptionPane.showMessageDialog( null, "El archivo de los huracanes no existe.", "Cargar huracanes", JOptionPane.ERROR_MESSAGE );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( null, "Se present� un problema al cargar las im�genes.", "Cargar huracanes", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el hurac�n con mayor velocidad y muestra sus datos en el panel de datos.
     */
    public void buscarMayorVelocidad( )
    {
        int posicion = sistemahuracanes.buscarHuracanMayorVelocidad( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
            Huracan h = ( Huracan )sistemahuracanes.darHuracanes( ).get( posicion );
            actualizarInformacionHuracan( h );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay huracanes registrados en el sistema." );
        }
    }

    /**
     * Busca el hurac�n con mayor costo estimado en da�os y muestra sus datos en el panel de datos.
     */
    public void buscarMayorCostoDanios( )
    {
        int posicion = sistemahuracanes.buscarHuracanMayorCostoDanios( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
            Huracan h = ( Huracan )sistemahuracanes.darHuracanes( ).get( posicion );
            actualizarInformacionHuracan( h );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay huracanes registrados en el sistema." );
        }
    }

    /**
     * Busca el hurac�n con menor costo estimado en da�os y muestra sus datos en el panel de datos.
     */
    public void buscarMenorCostoDanios( )
    {
        int posicion = sistemahuracanes.buscarHuracanMenorCostoDanios( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
            Huracan h = ( Huracan )sistemahuracanes.darHuracanes( ).get( posicion );
            actualizarInformacionHuracan( h );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay huracanes registrados en el sistema." );
        }
    }

    /**
     * Visualiza el di�logo para registrar un hurac�n.
     */
    public void mostrarDialogoRegistrarHuracan( )
    {

        DialogoRegistrarHuracan dialogo = new DialogoRegistrarHuracan( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );

    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = sistemahuracanes.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = sistemahuracanes.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * M�todo ejecuta la aplicaci�n, creando una nueva interfaz.
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
        InterfazHuracanes interfaz = new InterfazHuracanes( ARCHIVO_HURACANES );
        interfaz.setVisible( true );
    }

}