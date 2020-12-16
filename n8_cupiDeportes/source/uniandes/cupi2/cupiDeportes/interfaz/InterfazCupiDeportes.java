/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_cupiDeportes
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiDeportes.interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.cupiDeportes.mundo.Deporte;
import uniandes.cupi2.cupiDeportes.mundo.ElementoExisteException;
import uniandes.cupi2.cupiDeportes.mundo.FormatoArchivoException;
import uniandes.cupi2.cupiDeportes.mundo.CupiDeportes;
import uniandes.cupi2.cupiDeportes.mundo.Deportista;
import uniandes.cupi2.cupiDeportes.mundo.PersistenciaException;

/**
 * Ventana principal de la aplicaci�n.
 */
public class InterfazCupiDeportes extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Ruta al archivo donde se guarda la informaci�n.
     */
    private final static String DATA = "./data/cupiDeportes.data";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private CupiDeportes cupiDeportes;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la imagen del banner.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con los deportes.
     */
    private PanelDeportes panelDeportes;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con la informaci�n del deporte seleccionado.
     */
    private PanelInfoDeporte panelInfoDeporte;

    /**
     * Panel con la informaci�n del deportista seleccionado.
     */
    private PanelInfoDeportista panelInfoDeportista;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana principal de la aplicaci�n.
     */
    public InterfazCupiDeportes( )
    {
        try
        {
            cupiDeportes = new CupiDeportes( DATA );

            getContentPane( ).setLayout( new BorderLayout( ) );
            setSize( 800, 700 );
            setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
            setTitle( "CupiDeportes" );

            // Creaci�n de los paneles aqu�
            JPanel panelNorte = new JPanel( new BorderLayout( ) );
            panelImagen = new PanelImagen( );
            panelNorte.add( panelImagen, BorderLayout.NORTH );
            add( panelNorte, BorderLayout.NORTH );

            JPanel panelCentral = new JPanel( new BorderLayout( ) );
            panelDeportes = new PanelDeportes( this );
            panelCentral.add( panelDeportes, BorderLayout.NORTH );
            panelInfoDeporte = new PanelInfoDeporte( this );
            panelCentral.add( panelInfoDeporte, BorderLayout.CENTER );
            panelInfoDeportista = new PanelInfoDeportista( );
            panelCentral.add( panelInfoDeportista, BorderLayout.EAST );
            add( panelCentral, BorderLayout.CENTER );

            panelExtension = new PanelExtension( this );
            add( panelExtension, BorderLayout.SOUTH );

            panelOpciones = new PanelOpciones( this );
            add( panelOpciones, BorderLayout.WEST );

            setLocationRelativeTo( null );

            actualizarListaDeportes( );
        }
        catch( PersistenciaException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "CupiDeportes", JOptionPane.ERROR_MESSAGE );
        }

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza el panel panelDeportes con los deportes disponibles.
     */
    public void actualizarListaDeportes( )
    {
        panelDeportes.actualizarDeportes( cupiDeportes.darDeportes( ) );
    }

    /**
     * Actualiza la informaci�n que se visualiza de un deporte.
     * @param pDeporte Deporte del cual se va a mostrar la informaci�n.pDeporte != null.
     */
    public void actualizarInfoDeporte( Deporte pDeporte )
    {
        panelInfoDeporte.actualizarInfo( pDeporte );
    }

    /**
     * Actualiza la informaci�n que se visualiza del deportista.
     * @param pDeportista Deportista del cual se va a mostrar la informaci�n. pDeportista != null.
     */
    public void actualizarInfoDeportista( Deportista pDeportista )
    {
        panelInfoDeportista.actualizarInfo( pDeportista );
    }

    /**
     * Muestra el dialogo para ingresar un deporte.
     */
    public void mostrarDialogoAgregarDeporte( )
    {
        DialogoAgregarDeporte dialogo = new DialogoAgregarDeporte( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Agrega un deporte.
     * @param pNombreDeporte Nombre del deporte. pNombreDeporte != null && pNombreDeporte!= "".
     * @param pEnteRegulador Ente regulador del deporte. pEnteRegulador != null && pEnteRegulador != "".
     * @param pCantidadDeportistasRegistrados Cantidad de deportistas registrados. pCantidadDeportistasRegistrados > 0.
     * @param pRutaImagen Ruta a la imagen del deporte. pRutaImagen != null && pRutasImagen != "".
     * @throws ElementoExisteException Si ya existe un deporte con el nombre dado.
     */
    public void agregarDeporte( String pNombreDeporte, String pEnteRegulador, int pCantidadDeportistasRegistrados, String pRutaImagen ) throws ElementoExisteException
    {
        cupiDeportes.agregarDeporte( pNombreDeporte, pEnteRegulador, pCantidadDeportistasRegistrados, pRutaImagen );
        actualizarListaDeportes( );
    }

    /**
     * Muestra el dialogo para agregar un deportista sobresaliente.
     */
    public void mostrarDialogoAgregarDeportista( )
    {
        if( panelDeportes.darDeporteSeleccionado( ) == null )
        {
            JOptionPane.showMessageDialog( this, "No ha seleccionado ning�n deporte.", "Agregar deportista", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            DialogoAgregarDeportista dialogo = new DialogoAgregarDeportista( this );
            dialogo.setLocationRelativeTo( this );
            dialogo.setVisible( true );
        }
    }

    /**
     * Agrega un deportista al deporte seleccionado.
     * @param pNombreDeportista Nombre del deportista sobresaliente. pNombreDeportista != null && pNombreDeportista != "".
     * @param pEdad Edad del deportista. pEdad > 0.
     * @param pLugarResidencia Lugar de residencia del deportista. pLugarResidencia != null && pLugarResidencia != "".
     * @param pCantidadTrofeos Cantidad de trofeos ganados del deportista. pCantidadTrofeos >= 0.
     * @param pRutaImagenDeportista Ruta a la imagen del deportista. pRutaImagenDeportista != null && pRutaImagenDeportista != "".
     * @throws ElementoExisteException Si en el deporte ya existe un deportista con el nombre del que se quiere agregar.
     */
    public void agregarDeportistaSobresaliente( String pNombreDeportista, int pEdad, String pLugarResidencia, int pCantidadTrofeos, String pRutaImagenDeportista ) throws ElementoExisteException
    {
        String nombreDeporte = panelDeportes.darDeporteSeleccionado( ).darNombre( );
        cupiDeportes.agregarDeportistaSobresaliente( nombreDeporte, pNombreDeportista, pEdad, pLugarResidencia, pCantidadTrofeos, pRutaImagenDeportista );
        actualizarInfoDeporte( panelDeportes.darDeporteSeleccionado( ) );
    }

    /**
     * Elimina el deporte seleccionado.
     */
    public void eliminarDeporte( )
    {
        if( panelDeportes.darDeporteSeleccionado( ) == null )
        {
            JOptionPane.showMessageDialog( this, "No ha seleccionado ning�n deporte.", "Eliminar deporte", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            int confirmacion = JOptionPane.showConfirmDialog( this, "�Confirma que desea eliminar " + panelDeportes.darDeporteSeleccionado( ).toString( ) + "?", "Eliminar deporte", JOptionPane.YES_NO_OPTION );
            if( confirmacion == JOptionPane.YES_OPTION )
            {
                cupiDeportes.eliminarDeporte( panelDeportes.darDeporteSeleccionado( ).darNombre( ) );
                actualizarListaDeportes( );
            }
        }

    }

    /**
     * Elimina el deportista seleccionado.
     */
    public void eliminarDeportista( )
    {
        if( panelDeportes.darDeporteSeleccionado( ) == null )
        {
            JOptionPane.showMessageDialog( this, "No ha seleccionado ning�n deporte.", "Eliminar deportista", JOptionPane.ERROR_MESSAGE );
        }
        else if( panelInfoDeporte.darDeportistaSeleccionado( ) == null )
        {
            JOptionPane.showMessageDialog( this, "No ha seleccionado ning�n deportista sobresaliente del deporte.", "Eliminar deportista", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            int confirmacion = JOptionPane.showConfirmDialog( this, "�Confirma que desea eliminar el deportista " + panelInfoDeporte.darDeportistaSeleccionado( ).toString( ) + "?", "Eliminar deportista", JOptionPane.YES_NO_OPTION );
            if( confirmacion == JOptionPane.YES_OPTION )
            {
                cupiDeportes.eliminarDeportistaSobresaliente( panelDeportes.darDeporteSeleccionado( ).darNombre( ), panelInfoDeporte.darDeportistaSeleccionado( ).darNombre( ) );
                actualizarInfoDeporte( panelDeportes.darDeporteSeleccionado( ) );
            }
        }

    }

    /**
     * Actualiza la informaci�n de los deportistas a partir de un archivo.
     */
    public void actualizarInformacionDeportistas( )
    {
        JFileChooser fc = new JFileChooser( "./data/actualizacionInformacion" );
        fc.setDialogTitle( "Actualizar informaci�n deportistas" );
        int resultado = fc.showOpenDialog( this );
        if( resultado == JFileChooser.APPROVE_OPTION )
        {
            File archivo = fc.getSelectedFile( );
            if( archivo != null )
            {
                try
                {
                    cupiDeportes.actualizarInformacionDeportistas( archivo );
                    JOptionPane.showMessageDialog( this, "La informaci�n de los deportistas fue actualizada.", "Actualizar informaci�n", JOptionPane.INFORMATION_MESSAGE );
                }
                catch( FileNotFoundException e )
                {
                    JOptionPane.showMessageDialog( this, "Se present� un problema leyendo el archivo:\n" + e.getMessage( ) + ".", "Error", JOptionPane.ERROR_MESSAGE );
                }
                catch( IOException e )
                {
                    JOptionPane.showMessageDialog( this, "Se present� un problema leyendo el archivo:\n" + e.getMessage( ) + ".", "Error", JOptionPane.ERROR_MESSAGE );
                }
                catch( FormatoArchivoException e )
                {
                    JOptionPane.showMessageDialog( this, "Se present� un problema debido al formato del archivo:\n" + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
                }
                catch( ElementoExisteException e)
                {
                	JOptionPane.showMessageDialog( this, "El deportista esta repetido:\n" + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
                }
            }

        }

    }

    /**
     * Escribe el reporte de los trofeos de los deportistas detscados.
     * @param pRutaArchivo Ruta al archivo. pRutaArchivo != null && pRutaArchivo != "".
     */
    public void generarReporteTrofeos( String pRutaArchivo )
    {
        try
        {
            cupiDeportes.generarReporteTrofeos( pRutaArchivo );
            JOptionPane.showMessageDialog( this, "El reporte se gener� correctamente.", "Generar reporte", JOptionPane.INFORMATION_MESSAGE );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Generar reporte", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Este m�todo se encarga de salvar la informaci�n justo antes de cerrar la aplicaci�n.
     * Si se presenta una excepci�n en el proceso de serializaci�n del estado del mundo, este m�todo debe informar al usuario que ha ocurrido un error y preguntarle si desea salir de la aplicaci�n sin salvar la informaci�n. 
     */
    public void dispose( )
    {
    	// TODO Parte 3 punto B: Implemente el m�todo seg�n la documentaci�n.
    	
    	try
    	{
    		cupiDeportes.guardar(DATA);
    		super.dispose();
    	}
    	catch( Exception e)
    	{
    		setVisible(true);
    	
    		int respuesta = JOptionPane.showConfirmDialog(this, "Problemas salvando la informacion:\n"
    				+ e.getMessage() + "\n Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION);
    		if (respuesta == JOptionPane.YES_NO_OPTION)
    		{
    			super.dispose();
    		}
    		
    	}
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = cupiDeportes.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = cupiDeportes.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz.
     * @param args No se utilizan.
     */
    public static void main( String[] args )
    {
        InterfazCupiDeportes interfaz = new InterfazCupiDeportes( );
        interfaz.setVisible( true );
    }

}