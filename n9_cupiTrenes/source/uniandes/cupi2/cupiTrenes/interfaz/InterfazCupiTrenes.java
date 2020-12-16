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

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import uniandes.cupi2.cupiTrenes.mundo.CupiTrenes;
import uniandes.cupi2.cupiTrenes.mundo.ElementoNoExisteException;
import uniandes.cupi2.cupiTrenes.mundo.PersistenciaException;
import uniandes.cupi2.cupiTrenes.mundo.Vagon;
import uniandes.cupi2.cupiTrenes.mundo.Tren;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazCupiTrenes extends JFrame
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Ruta del archivo en donde se va a guardar la información.
     */
    public static final String RUTA_ARCHIVO = "data/cupiTrenes.data";
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private CupiTrenes cupiTrenes;

    /**
     * Tren que se está visualizando.
     */
    private Tren trenActual;

    /**
     * Vagón que se está visualizando.
     */
    private Vagon vagonActual;

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
     * Panel con la información y acciones.
     */
    private PanelInformacionAcciones panelInformacionAcciones;

    /**
     * Panel que muestra la información de un tren.
     */
    private PanelTren panelTren;

    /**
     * Panel que muestra la información de un vagón.
     */
    private PanelVagon panelVagon;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal.<br>
     * <b>post: </b> Construye la ventana con todos su paneles.
     */
    public InterfazCupiTrenes( )
    {
    	try 
    	{
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
        try
        {
            // Crea la clase principal
            cupiTrenes = new CupiTrenes( RUTA_ARCHIVO );
        }
        catch( PersistenciaException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }

        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 770, 700 );
        setTitle( "CupiTrenes" );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setLocationRelativeTo( null );

        // Creación de los paneles aquí
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        panelInformacionAcciones = new PanelInformacionAcciones( this );
        add( panelInformacionAcciones, BorderLayout.WEST );

        JPanel auxPanelInformacion = new JPanel( );
        auxPanelInformacion.setLayout( new BorderLayout( ) );

        panelTren = new PanelTren( this );
        auxPanelInformacion.add( panelTren, BorderLayout.NORTH );

        panelVagon = new PanelVagon( this );
        auxPanelInformacion.add( panelVagon, BorderLayout.CENTER );

        add( auxPanelInformacion, BorderLayout.CENTER );

        trenActual = cupiTrenes.darPrimerTren( );
        if( trenActual != null )
        {
            vagonActual = trenActual.darPrimerVagon( );
        }
        actualizarPaneles( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la lista de ids de todos los trenes.
     * @return La lista de ids de los trenes.
     */
    public ArrayList darIdsTrenes( )
    {
        return cupiTrenes.darIdTrenes( );
    }

    /**
     * Retorna la lista de números de los vagones de un tren dado.
     * @param pIdTren El identificador del tren. pIdTren != null && pIdTren >= 0.
     * @return La lista de números de los vagones del tren.
     */
    public ArrayList darNumerosVagones( int pIdTren )
    {
        return cupiTrenes.darNumerosVagones( pIdTren );
    }

    /**
     * Muestra el siguiente tren al actual, si éste existe.
     */
    public void darSiguienteTren( )
    {
        if( trenActual == null || trenActual.darSiguiente( ) == null )
        {
            JOptionPane.showMessageDialog( this, "No existe ningún tren que salga más tarde.", "Dar siguiente tren", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            trenActual = trenActual.darSiguiente( );
            if( trenActual != null )
            {
                vagonActual = trenActual.darPrimerVagon( );
            }
            actualizarPaneles( );
        }
    }

    /**
     * Muestra el tren anterior al actual, si éste existe.
     */
    public void darAnteriorTren( )
    {
        if( trenActual == null || trenActual.darAnterior( ) == null )
        {
            JOptionPane.showMessageDialog( this, "No existe ningún tren que salga más temprano.", "Dar tren anterior", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            trenActual = trenActual.darAnterior( );
            if( trenActual != null )
            {
                vagonActual = trenActual.darPrimerVagon( );
            }
            actualizarPaneles( );
        }

    }

    /**
     * Muestra el primer vagón del tren actual.
     */
    public void darPrimerVagon( )
    {
        if( trenActual != null )
        {
            vagonActual = trenActual.darPrimerVagon( );
            if( vagonActual != null )
            {
                actualizarPaneles( );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No hay vagones en el tren.", "Dar primer vagón", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }

    /**
     * Muestra el siguiente vagón al actual, si éste existe.
     */
    public void darSiguienteVagon( )
    {
        if( vagonActual == null || vagonActual.darSiguiente( ) == null )
        {
            JOptionPane.showMessageDialog( this, "No existe otro vagón en el tren.", "Dar siguiente vagón", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            vagonActual = vagonActual.darSiguiente( );
            actualizarPaneles( );
        }
    }

    /**
     * Agrega un nuevo tren con los valores dados por parámetro.
     * 
     * @param pIdTren ID del tren a agregar. pIdRuta > 0.
     * @param pNombresParadas Arreglo con los nombres las paradas de la ruta. pNombresParadas != null.
     * @param pHorariosParadas Arreglo con los horarios de la ruta. pHorariosParadas != null.
     * @return true si pudo agregar el tren, false de lo contrario.
     * @throws Exception 
     */
    public boolean agregarTren( int pIdTren, String[] pNombresParadas, Date[] pHorariosParadas ) throws Exception
    {

        cupiTrenes.agregarTren( pIdTren, pNombresParadas, pHorariosParadas );
        trenActual = cupiTrenes.buscarTrenPorId( pIdTren );
        if( trenActual != null )
        {
            vagonActual = trenActual.darPrimerVagon( );
        }
        actualizarPaneles( );
        return true;

    }

    /**
     * Agrega un nuevo vagón con las características dadas por parámetro.
     * 
     * @param pIdRuta Id del tren al que se le agregará un nuevo vagón para que haga el recorrido.
     * @param pNumeroVagon Número del vagón a agregar.
     * @param pCantidadSillas Cantidad de sillas  en el vagón. pCantidadSillas >= 0.
     * @param pClase Clase del compartimiento. pClase != null && pClase != "" && (pClase pertenece a { Primera Clase, Segunda Clase, Negocios, VIP } ).
     * @param pPrecio Precio del tiquete. pPrecio > 0.
     * @throws Exception 
     */
    public void agregarVagon( int pIdRuta, int pNumeroVagon, int pCantidadSillas, String pClase, double pPrecio ) throws Exception
    {
        cupiTrenes.agregarVagon( pIdRuta, pNumeroVagon, pCantidadSillas, pClase, pPrecio );
        vagonActual = cupiTrenes.buscarTrenPorId( pIdRuta ).buscarVagon( pNumeroVagon );
        actualizarPaneles( );
    }

    /**
     * Elimina el tren con el id ingresado por el usuario.
     */
    public void eliminarTren( )
    {

        try
        {
            String res = JOptionPane.showInputDialog( this, "Ingrese el id del tren que desea eliminar ", "Eliminar tren", JOptionPane.PLAIN_MESSAGE );
            if( res != null )
            {
                int idTren = Integer.parseInt( res );
                if( !res.equalsIgnoreCase( "" ) )
                {

                    cupiTrenes.eliminarTren( idTren );
                    trenActual = cupiTrenes.darPrimerTren( );
                    if( trenActual != null )
                    {
                        vagonActual = trenActual.darPrimerVagon( );
                    }
                    else
                    {
                        vagonActual = null;
                    }

                    actualizarPaneles( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar el id de un tren para ser eliminado.", "Eliminar tren", JOptionPane.ERROR_MESSAGE );

                }
            }
        }
        catch( ElementoNoExisteException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar tren", JOptionPane.ERROR_MESSAGE );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar un valor numérico.", "Eliminar tren", JOptionPane.ERROR_MESSAGE );

        }
    }

    /**
     * Elimina el vagón con las características dadas por parámetro.
     * 
     * @param idRuta Id del tren al cual pertenece el vagón a eliminar.
     * @param numVagon Número del vagón a eliminar. numVagon >= 0.
     * @return true si logró eliminar el vagón. False de lo contrario.
     */
    public boolean eliminarVagon( int idRuta, int numVagon )
    {
        try
        {
            cupiTrenes.eliminarVagon( idRuta, numVagon );
            if( trenActual != null )
            {
                vagonActual = trenActual.darPrimerVagon( );
            }
            actualizarPaneles( );

            return true;
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar vagón", JOptionPane.ERROR_MESSAGE );
            return false;
        }
    }

    /**
     * Vende el tiquete correspondiente al tren y al vagón que está siendo mostrado actualmente.<br>
     * <b>post: </b> El vagón actual tiene una silla disponible menos.
     */
    public void venderTiquete( )
    {
        try
        {
            if( vagonActual == null )
            {
                JOptionPane.showMessageDialog( this, "No existe ningún vagon en el tren seleccionado.", "Vender tiquete", JOptionPane.INFORMATION_MESSAGE );
            }
            else if( cupiTrenes.venderTiquete( trenActual.darId( ), vagonActual.darNumero( ) ) )
            {
                actualizarPaneles( );
                JOptionPane.showMessageDialog( this, "El tiquete fue vendido.", "Vender tiquete", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No existen sillas disponibles.", "Vender tiquete", JOptionPane.ERROR_MESSAGE );
            }
        }
        catch( ElementoNoExisteException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Vender tiquete", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Genera el reporte con la información de cupiTrenes.<br>
     * <b>post: </b> El archivo de texto con la información de cupiTrenes fue creado.
     */
    public void generarReporte( )
    {
        JFileChooser chooser = new JFileChooser( "./data" );
        int opcion = chooser.showSaveDialog( this );
        if( opcion == JFileChooser.APPROVE_OPTION )
        {
            String pathArchivo = chooser.getSelectedFile( ).getParent( );
            String nombreArchivo = chooser.getSelectedFile( ).getName( );
            if( !nombreArchivo.endsWith( ".txt" ) )
            {
                nombreArchivo = nombreArchivo + ".txt";
            }
            try
            {
                cupiTrenes.generarReporte( pathArchivo, nombreArchivo );
                JOptionPane.showMessageDialog( this, "El reporte fue generado exitosamente.", "Generar reporte", JOptionPane.INFORMATION_MESSAGE );

            }
            catch( FileNotFoundException e )
            {
                JOptionPane.showMessageDialog( this, "Problemas al crear el archivo del reporte.", "Generar reporte", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Busca un tren que tenga como paradas el origen y destino dados por parámetro en ese orden.
     * 
     * @param pOrigen Origen buscado. pOrigen != null && pOrigen != "".
     * @param pDestino Destino buscado. pDestino != null && pDestino != "".
     * @return el tren buscado.
     */
    public Tren buscarTren( String pOrigen, String pDestino )
    {
        Tren encontrado = cupiTrenes.buscarTrenPorParadas( pOrigen, pDestino );
        if( encontrado != null )
        {
            trenActual = encontrado;
            if( trenActual != null )
            {
                vagonActual = trenActual.darPrimerVagon( );
            }
            actualizarPaneles( );
        }
        return encontrado;
    }

    /**
     * Muestra el diálogo que permite buscar un tren.
     */
    public void mostrarDialogoBuscarTren( )
    {
        DialogoBuscarTren dialogo = new DialogoBuscarTren( this );
        setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el diálogo que permite agregar un tren.
     */
    public void mostrarDialogoAgregarTren( )
    {
        try
        {
            String cantStr = JOptionPane.showInputDialog( this, "Ingrese la cantidad de paradas del tren.", "Agregar tren", JOptionPane.PLAIN_MESSAGE );
            if( cantStr != null )
            {
                int cantidadParadas = Integer.parseInt( cantStr );

                if( cantidadParadas < 2 )
                {
                    JOptionPane.showMessageDialog( this, "Un tren debe tener por lo menos dos paradas.", "Agregar tren", JOptionPane.ERROR_MESSAGE );
                }
                else if( cantidadParadas > 10 )
                {
                    JOptionPane.showMessageDialog( this, "No puede exceder a 10 paradas por tren.", "Agregar tren", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    DialogoAgregarTren dialogo = new DialogoAgregarTren( this, cantidadParadas );
                    dialogo.setLocationRelativeTo( this );
                    dialogo.setVisible( true );
                }
            }
        }
        catch( NumberFormatException ex )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar un valor numérico.", "Agregar tren", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra el diálogo que permite agregar un vagón.
     */
    public void mostrarDialogoAgregarVagon( )
    {
        DialogoAgregarVagon dialogo = new DialogoAgregarVagon( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el diálogo que permite eliminar un vagón.
     */
    public void mostrarDialogoEliminarVagon( )
    {
        DialogoEliminarVagon dialogo = new DialogoEliminarVagon( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra todas las paradas del tren actual.
     */
    public void mostrarTodasLasParadas( )
    {
        if( trenActual != null )
        {
            DialogoMostrarParadasTren dialogo = new DialogoMostrarParadasTren( trenActual.darParadas( ), trenActual.darParadas( ).size( ), trenActual.darId( ) );
            dialogo.setLocationRelativeTo( this );
            dialogo.setVisible( true );
        }
    }

    /**
     * Actualiza los páneles para que muestren la información del vagón actual y del tren actual.
     */
    public void actualizarPaneles( )
    {

        panelInformacionAcciones.actualizar( cupiTrenes.darTotalRecaudo( ), cupiTrenes.darTotalSillasDisponibles( ) );
        if( trenActual != null )
        {
            if( vagonActual != null )
            {
                panelVagon.actualizar( vagonActual.darNumero( ), vagonActual.darClase( ), vagonActual.darCantidadSillasDisponibles( ), vagonActual.darPrecio( ), vagonActual.darCantidadTotalSillas( ) );
            }
            else
            {
                panelVagon.actualizar( 0, "", 0, 0, 0 );

            }
            panelTren.actualizar( trenActual.darDestino( ), trenActual.darOrigen( ), trenActual.darHorarioLlegada( ), trenActual.darHorarioSalida( ), trenActual.darId( ), trenActual.darParadas( ).size( ) );

        }
        else
        {
            panelTren.actualizar( "Destino indefinido", "Origen indefinido", "Horario indefinido", "Horario indefinido", 0, 0 );
            panelVagon.actualizar( 0, "", 0, 0, 0 );

        }

    }

    /**
     * Método que se llama cuando se cierra la ventana principal de la aplicación.<br>
     * Antes de cerrar se guarda el estado de cupiTrenes.<br>
     * Si se produce un error se muestra un mensaje que informe al usuario.
     */
    public void dispose( )
    {
        try
        {
            cupiTrenes.guardar( RUTA_ARCHIVO );
            super.dispose( );
        }
        catch( Exception e )
        {
            setVisible( true );
            int respuesta = JOptionPane.showConfirmDialog( this, "Problemas salvando la información de cupiTrenes:\n" + e.getMessage( ) + "." + "\n¿Quiere cerrar el programa sin salvar?.", "Error", JOptionPane.YES_NO_OPTION );
            if( respuesta == JOptionPane.YES_OPTION )
            {
                super.dispose( );
            }
        }
    }

    // -----------------------------------------------------------------
    // Puntos de extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = cupiTrenes.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = cupiTrenes.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * 
     * @param pArgs Los argumentos de ejecución de la aplicación. pArgs != null
     */
    public static void main( String[] pArgs )
    {
    	
        InterfazCupiTrenes interfaz = new InterfazCupiTrenes( );
        interfaz.setVisible( true );
    }

}
