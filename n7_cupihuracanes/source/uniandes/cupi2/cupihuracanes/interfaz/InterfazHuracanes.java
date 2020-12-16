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
 * Ventana principal de la aplicación.
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
     * Panel donde se muestran los datos de un huracán.
     */
    private PanelDatosHuracan panelDatos;

    /**
     * Panel donde están los botones para los puntos de extensión.
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
     * @param pArchivo Nombre del archivo de propiedades que contiene la información de los huracanes.
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
    // Métodos
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
     * Ordena los huracanes por costo estimado en daños y actualiza la lista.
     */
    public void ordenarPorCostoDanios( )
    {
        sistemahuracanes.ordenarPorDanios( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Busca un huracán usando el nombre. Cuando lo encuentra, lo selecciona en la lista y muestra sus datos.
     */
    public void buscar( )
    {
        String nombreBuscado = JOptionPane.showInputDialog( this, "Nombre del huracán" );
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
                JOptionPane.showMessageDialog( this, "No se encontró el huracán" );
            }
        }
    }

    /**
     * Actualiza los datos de un huracán en el panel correspondiente.
     * @param pHuracan es el huracán del cual se quieren ver los datos. pHuracán != null
     */
    public void actualizarInformacionHuracan( Huracan pHuracan )
    {
        panelDatos.actualizarInformacionHuracan( pHuracan );
    }

    /**
     * Registra un nuevo huracán.
     * @param pNombre Nombre del huracán. pNombre != null && pNombre != "".
     * @param pCategoria Categoría del huracán. 0 < pCategoria < 6.
     * @param pVelocidad Velocidad del huracán. pVelocidad > 0.
     * @param pCostoEstimadoDanios Costo estimado en daños del huracán. pCostoEstimadoDanios > 0.
     * @param pImagen Ruta a la imagen del huracán. pImagen != null && pImagen != "".
     */
    public void registrarHuracan( String pNombre, int pCategoria, int pVelocidad, double pCostoEstimadoDanios, String pImagen )
    {
        boolean agrego = sistemahuracanes.registrarHuracan( pNombre, pCategoria, pVelocidad, pCostoEstimadoDanios, pImagen );
        if( !agrego )
            JOptionPane.showMessageDialog( this, "No se pudo agregar el huracán " + pNombre + ".\n  Ya existe un huracán con ese nombre.", "Registrar Huracán", JOptionPane.ERROR_MESSAGE );
        else
        {
            actualizarLista( );
            panelLista.seleccionar( sistemahuracanes.darHuracanes( ).size( ) - 1 );
        }
    }

    /**
     * Carga los datos de los huracanes a partir de un archivo de propiedades.
     * @param Archivo que contiene la información de los huracanes.
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
                // Carga un huracán
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

                // Sólo se carga el huracán si los datos son correctos
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
            JOptionPane.showMessageDialog( null, "Se presentó un problema al cargar las imágenes.", "Cargar huracanes", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el huracán con mayor velocidad y muestra sus datos en el panel de datos.
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
     * Busca el huracán con mayor costo estimado en daños y muestra sus datos en el panel de datos.
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
     * Busca el huracán con menor costo estimado en daños y muestra sus datos en el panel de datos.
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
     * Visualiza el diálogo para registrar un huracán.
     */
    public void mostrarDialogoRegistrarHuracan( )
    {

        DialogoRegistrarHuracan dialogo = new DialogoRegistrarHuracan( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );

    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = sistemahuracanes.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
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
     * Método ejecuta la aplicación, creando una nueva interfaz.
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