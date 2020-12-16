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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.fabricaDeCarros.mundo.FabricaDeCarros;
import uniandes.cupi2.fabricaDeCarros.mundo.IParte;
import uniandes.cupi2.fabricaDeCarros.mundo.Parte;


/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazFabricaDeCarros extends JFrame
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private FabricaDeCarros fabricaDeCarros;

    /**
     * Parte actualmente seleccionada.
     */
    private IParte seleccionada;

    /**
     * Parte que se está creando y se muestra.
     */
    private IParte sombreada;

    /**
     * Ruta donde se cargó o salvó un archivo.
     */
    private String ultimoDirectorio;

    /**
     * Arreglo con las diferentes opciones de selección.
     * 
     */
    private ArrayList opcionesSeleccion;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que contiene la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel donde se muestran los botones para controlar la aplicación.
     */
    private PanelBotones panelBotones;

    /**
     * Panel en el que se muestra y edita la fábrica.
     */
    private PanelFabrica panelFabrica;

    /**
     * Barra del menú.
     */
    private BarraMenu barraMenu;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva interfaz con sus diferentes páneles. <br>
     * <b> post: </b> Se inicializaron los atributos de la fábrica de carros.
     */
    public InterfazFabricaDeCarros( )
    {
        // Crea la clase principal
        fabricaDeCarros = new FabricaDeCarros( );
        inicializarOpcionesSeleccion( );

        ultimoDirectorio = "./data";

        // Construye la forma
        setLayout( new BorderLayout( ) );
        setTitle( "Fábrica de Carros" );
        barraMenu = new BarraMenu( this );
        setJMenuBar( barraMenu );
        setSize( 900, 750 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setResizable( false );

        // Creación de los paneles aquí
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        JPanel auxPanelInformacion = new JPanel( );
        auxPanelInformacion.setLayout( new BorderLayout( ) );

        panelBotones = new PanelBotones( this );
        auxPanelInformacion.add( panelBotones, BorderLayout.WEST );

        panelFabrica = new PanelFabrica( this );
        auxPanelInformacion.add( panelFabrica, BorderLayout.CENTER );

        add( auxPanelInformacion, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Abre un diseño por medio de un archivo seleccionado por el usuario. <br>
     * <b>post: </b>Se cargó la fábrica que estaba guardada.
     */
    public void abrir( )
    {
        boolean abrir = pedirConfirmacion( );
        if( abrir )
        {
            JFileChooser fc = new JFileChooser( ultimoDirectorio );
            fc.setDialogTitle( "Abrir fábrica" );
            fc.setFileSelectionMode( JFileChooser.FILES_ONLY );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );

            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                File seleccionado = fc.getSelectedFile( );
                ultimoDirectorio = seleccionado.getParentFile( ).getAbsolutePath( );
                try
                {
                    fabricaDeCarros.abrir( seleccionado.getAbsolutePath( ) );
                    panelFabrica.actualizar( );
                }
                catch( Exception e )
                {
                    JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
    }

    /**
     * Agrega una parte del tipo seleccionado en el panel de botones. <br>
     * <b>post:</b> Se agregó la parte y se redibujó la fábrica.
     * @param pX La coordenada x del punto superior izquierdo de la parte. pX >= 0.
     * @param pY La coordenada y del punto superior izquierdo de la parte. pY >= 0.
     */
    public void agregarParte( int pX, int pY )
    {
        String opcion = darOpcionSeleccionada( );
        Color color = panelBotones.darColorFondo( );
        Parte nuevaParte = null;
        nuevaParte = fabricaDeCarros.crearParte( opcion, pX, pY, color );

        fabricaDeCarros.agregarParte( nuevaParte );
        sombreada = null;
        panelFabrica.actualizar( );
    }

    /**
     * Calcula la sombra de la parte actual seleccionada.
     * @param pX La coordenada x del punto. pX >= 0.
     * @param pY La coordenada y del punto. pY >= 0.
     */
    public void calcularSombra( int pX, int pY )
    {
        String opcion = darOpcionSeleccionada( );

        if( PanelBotones.SELECCIONAR.equals( opcion ) )
        {
            if( seleccionada != null )
            {
                sombreada = fabricaDeCarros.crearParte( seleccionada.darTipo( ), pX, pY, seleccionada.darColor( ) );
            }
        }
        else 
        {
            sombreada = fabricaDeCarros.crearParte( opcion, pX, pY, panelBotones.darColorFondo( ) );
        }
        cambiarSombreada( sombreada );
    }

    /**
     * Cambia la posición de la parte con las características dadas al nuevo punto de coordenadas dadas.<br>
     * <b>post: </b> La parte con las características indicadas se encuentra en la nueva posición.
     * @param pXActual Coordenada en x donde se encuentra la parte a cambiar de posición. pXActual >= 0.
     * @param pYActual Coordenada en y donde se encuentra la parte a cambiar de posición. pYActual >= 0.
     * @param pNuevoX Nueva coordenada en x donde se desea posicionar la parte. pNuevoX >= 0.
     * @param pNuevoY Nueva coordenada en y donde se desea posicionar la parte. pNuevoY >= 0.
     */
    public void cambiarPosicionParte( int pXActual, int pYActual, int pNuevoX, int pNuevoY )
    {
        fabricaDeCarros.cambiarPosicionParte( pXActual, pYActual, pNuevoX, pNuevoY );
        seleccionada = null;
        sombreada = null;
    }

    /**
     * Cambia la parte seleccionada.
     * @param pF Nueva parte seleccionada. pF != null.
     */
    public void cambiarSeleccionada( Parte pF )
    {
        seleccionada = pF;
    }

    /**
     * Cambia la parte sombreada.
     * @param pF Nueva parte sombreada. pF != null.
     */
    public void cambiarSombreada( IParte pF )
    {
        sombreada = pF;
    }

    /**
     * Retorna la lista de opciones de selección.
     * @return Lista de opciones de selección.
     */
    public ArrayList darOpcionesSeleccion( )
    {
        return opcionesSeleccion;
    }

    /**
     * Retorna la opción seleccionada en el panel de botones.
     * @return Opción seleccionada. Puede ser alguno de los tipos de partes, Ninguna, Seleccionar o Borrar.
     */
    public String darOpcionSeleccionada( )
    {
        return panelBotones.darOpcionSeleccionada( );
    }

    /**
     * Retorna la parte seleccionada.
     * @return Parte seleccionada.
     */
    public IParte darSeleccionada( )
    {
        return seleccionada;
    }

    /**
     * Retorna la parte a ser pintada sombreada.
     * @return Parte a ser pintada sombreada.
     */
    public IParte darSombreado( )
    {

        return sombreada;
    }

    /**
     * Método llamado al intentar cerrar la aplicación. Pregunta si se desea guardar el diseño actual.<br>
     * <b>post :</b> Se cerró la aplicación y se guardó el diseño si el usuario lo especificó.
     */
    @Override
    public void dispose( )
    {

        int seleccion = JOptionPane.showConfirmDialog( this, "Está cerrando la fábrica de carros.\n ¿Desea guardar el diseño actual?", "Cerrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
        if( seleccion == JOptionPane.YES_OPTION )
        {
            guardar( );
        }
        super.dispose( );
    }

    /**
     * Intenta eliminar la parte seleccionada. <br>
     * <b>post: </b> Si había una parte seleccionada, entonces esta se elimina.
     */
    public void eliminar( )
    {
        if( seleccionada != null )
        {
            fabricaDeCarros.eliminarParte( seleccionada.darX( ), seleccionada.darY( ) );
            seleccionada = null;
            panelFabrica.actualizar( );
        }
    }

    /**
     * Guarda la fábrica en el archivo del que se había cargado o donde se había salvado la última vez. <br>
     * Si se trata de una fábrica nueva y no se ha guardado, entonces se pregunta el nombre del archivo donde se guardará. <br>
     * <b>post: </b> Se guardó la fábrica.
     */
    public void guardar( )
    {
        String nombreArchivo = fabricaDeCarros.darRutaArchivo( );
        if( nombreArchivo == null )
        {
            guardarComo( );
        }
        else
        {
            try
            {
                fabricaDeCarros.guardar( );
            }
            catch( IOException e )
            {
                JOptionPane.showMessageDialog( this, "Hubo problemas guardando el archivo:\n" + e.getMessage( ), "Guardar", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Guarda la fábrica en un archivo cuyo nombre se pregunta usuario. <br>
     * <b>post:</b> Se guardó la fábrica en un archivo cuyo nombre se pregunta al usuario.
     */
    public void guardarComo( )
    {
        JFileChooser fc = new JFileChooser( ultimoDirectorio );
        fc.setDialogTitle( "Guardar como" );
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY );
        fc.setMultiSelectionEnabled( false );

        boolean termine = false;

        int resultado = fc.showSaveDialog( this );

        while( !termine )
        {
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                File seleccionado = fc.getSelectedFile( );
                ultimoDirectorio = seleccionado.getParentFile( ).getAbsolutePath( );

                int respuesta = JOptionPane.YES_OPTION;

                // Si el archivo ya existe hay que pedir confirmación para sobrescribirlo
                if( seleccionado.exists( ) )
                {
                    respuesta = JOptionPane.showConfirmDialog( this, "¿Desea sobrescribir el archivo seleccionado?", "Guardar Como", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE );
                }

                // Si la respuesta fue positiva (o si no fue necesario hacer la pregunta) se graba el archivo
                if( respuesta == JOptionPane.YES_OPTION )
                {
                    try
                    {
                        fabricaDeCarros.guardar( seleccionado.getAbsolutePath( ) );
                        termine = true;
                    }
                    catch( IOException e )
                    {
                        JOptionPane.showMessageDialog( this, "Hubo problemas guardando el archivo:\n" + e.getMessage( ), "Guardar Como", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    resultado = fc.showSaveDialog( this );
                }
            }
            else
            {
                termine = true;
            }
        }
    }

    /**
     * Inicializa la lista de opciones de selección.<br>
     * <b>post :</b> Se inicializaron las opciones de selección.
     */
    public void inicializarOpcionesSeleccion( )
    {
        opcionesSeleccion = fabricaDeCarros.darTipos( );
    }

    /**
     * Solicita una confirmación para realizar una acción que haría que el trabajo se perdiera. <br>
     * Presenta una ventana con las opciones "Si","No" y "Cancelar". <br>
     * Si se selecciona "Si", entonces se salva el archivo actual. <br>
     * Si se selecciona "No", el archivo no se salva y se retorna true. <br>
     * Si se selecciona "Cancelar", el archivo no se salva pero se retorna false para que la acción no se realice.
     * @return true si la acción se debe realizar, false en caso contrario.
     */
    private boolean pedirConfirmacion( )
    {
        boolean cerrar = true;

        int respuesta = JOptionPane.showConfirmDialog( this, "Desea guardar el archivo actual antes de continuar?", "Guardar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE );

        if( respuesta == JOptionPane.YES_OPTION )
        {
            guardar( );
        }
        else if( respuesta == JOptionPane.NO_OPTION )
        {
            // No hace nada
        }
        else if( respuesta == JOptionPane.CANCEL_OPTION )
        {
            cerrar = false;
        }
        return cerrar;
    }

    /**
     * Pinta todas las partes del diseño de la fábrica de carros.
     * @param pG Graphics sobre el que se va a pintar las partes. pG != null.
     */
    public void pintarPartes( Graphics2D pG )
    {
        fabricaDeCarros.pintarPartes( pG );
    }

    /**
     * Reinicia la fábrica después de pedir una confirmación. <br>
     * <b>post:</b> Se reinició la fábrica.
     */
    public void reiniciar( )
    {
        boolean reiniciar = pedirConfirmacion( );
        if( reiniciar )
        {
            fabricaDeCarros.reiniciar( );
            panelFabrica.actualizar( );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Realiza las acciones posibles cuando está seleccionada la opción de SELECCIONAR. <br>
     * Si no había una parte seleccionada, busca la parte que contiene los puntos dados y la selecciona. <br>
     * Si había una parte seleccionada y los puntos dados se encuentran dentro de la misma parte, ésta se des-selecciona.<br>
     * Si había una parte seleccionada y los puntos dados no se encuentran dentro de la misma parte, cambia el lugar de la parte.
     * @param pX Coordenada x del punto. pX >= 0.
     * @param pY Coordenada y del punto. pY >= 0.
     */
    public void seleccionar( int pX, int pY )
    {
        if( seleccionada == null )
        {
            seleccionada = fabricaDeCarros.buscarParte( pX, pY );
        }
        else
        {
            IParte nSeleccionada = fabricaDeCarros.buscarParte( pX, pY );
            if( nSeleccionada != null && nSeleccionada.equals( seleccionada ) )
            {
                seleccionada = null;
                sombreada = null;
            }
            else
            {
                cambiarPosicionParte( seleccionada.darX( ), seleccionada.darY( ), pX, pY );
            }
        }
        panelFabrica.actualizar( );
    }

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = fabricaDeCarros.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = fabricaDeCarros.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación, creando una nueva interfaz.
     * @param pArgs Argumentos de iniciación de la aplicación pArgs !=null.
     */
    public static void main( String[] pArgs )
    {
        // Unifica la interfaz para Mac y para Windows.
        try 
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
     
        InterfazFabricaDeCarros interfaz = new InterfazFabricaDeCarros( );
        interfaz.setVisible( true );
    }
}
