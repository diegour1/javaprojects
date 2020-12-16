/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_cupiDeportes
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiDeportes.interfaz;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel que se encarga de mostrar los botones de opciones.
 */
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para agregar un deporte.
     */
    public static final String NUEVO_DEPORTE = "Agregar deporte";

    /**
     * Constante para eliminar un deporte.
     */
    public static final String ELIMINAR_DEPORTE = "Eliminar deporte";

    /**
     * Constante para agregar un deportista.
     */
    public static final String NUEVO_DEPORTISTA = "Agregar deportista";

    /**
     * Constante para el botón de eliminar deportista.
     */
    public static final String ELIMINAR_DEPORTISTA = "Eliminar deportista";

    /**
     * Constante para el botón de generar reporte.
     */
    public static final String GENERAR_REPORTE = "Generar reporte";

    /**
     * Constante para el botón de importar datos.
     */
    public static final String IMPORTAR_DATOS = "Importar datos";

    /**
     * Constante para definir el directo donde están las imágenes de los elementos.
     */
    public static final String DIRECTORIO = "data/imagenes/";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Interfaz principal de la aplicación.
     */
    private InterfazCupiDeportes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para agregar un nuevo deporte.
     */
    private JButton btnNuevoDeporte;

    /**
     * Botón para eliminar un deporte.
     */
    private JButton btnEliminarDeporte;

    /**
     * Botón para agregar un nuevo deportista.
     */
    private JButton btnNuevoDeportista;

    /**
     * Botón para eliminar un deportista.
     */
    private JButton btnEliminarDeportista;

    /**
     * Botón para generar reporte.
     */
    private JButton btnGenerarReporte;

    /**
     * Botón para leer un archivo.
     */
    private JButton btnLeerArchivo;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Interfaz principal de la aplicación. pPrincipal != null.
     */
    public PanelOpciones( InterfazCupiDeportes pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new FlowLayout( FlowLayout.CENTER, 0, 4 ) );
        setBorder( new TitledBorder( "Opciones" ) );
        setPreferredSize( new Dimension( 80, 600 ) );

        btnNuevoDeporte = new JButton( new ImageIcon( DIRECTORIO + "agregarDeporte.png" ) );
        add( btnNuevoDeporte );
        btnNuevoDeporte.addActionListener( this );
        btnNuevoDeporte.setActionCommand( NUEVO_DEPORTE );
        btnNuevoDeporte.setToolTipText( NUEVO_DEPORTE );
        btnNuevoDeporte.setPreferredSize( new Dimension( 60, 60 ) );

        btnEliminarDeporte = new JButton( new ImageIcon( DIRECTORIO + "eliminarDeporte.png" ) );
        add( btnEliminarDeporte );
        btnEliminarDeporte.addActionListener( this );
        btnEliminarDeporte.setActionCommand( ELIMINAR_DEPORTE );
        btnEliminarDeporte.setToolTipText( ELIMINAR_DEPORTE );
        btnEliminarDeporte.setPreferredSize( new Dimension( 60, 60 ) );

        btnNuevoDeportista = new JButton( new ImageIcon( DIRECTORIO + "agregarDeportista.png" ) );
        add( btnNuevoDeportista );
        btnNuevoDeportista.addActionListener( this );
        btnNuevoDeportista.setActionCommand( NUEVO_DEPORTISTA );
        btnNuevoDeportista.setToolTipText( NUEVO_DEPORTISTA );
        btnNuevoDeportista.setPreferredSize( new Dimension( 60, 60 ) );

        btnEliminarDeportista = new JButton( new ImageIcon( DIRECTORIO + "eliminarDeportista.png" ) );
        add( btnEliminarDeportista );
        btnEliminarDeportista.addActionListener( this );
        btnEliminarDeportista.setActionCommand( ELIMINAR_DEPORTISTA );
        btnEliminarDeportista.setToolTipText( ELIMINAR_DEPORTISTA );
        btnEliminarDeportista.setPreferredSize( new Dimension( 60, 60 ) );

        btnGenerarReporte = new JButton( new ImageIcon( DIRECTORIO + "Reporte.png" ) );
        add( btnGenerarReporte );
        btnGenerarReporte.addActionListener( this );
        btnGenerarReporte.setActionCommand( GENERAR_REPORTE );
        btnGenerarReporte.setToolTipText( GENERAR_REPORTE );
        btnGenerarReporte.setPreferredSize( new Dimension( 60, 60 ) );

        btnLeerArchivo = new JButton( new ImageIcon( DIRECTORIO + "CargarDatos.png" ) );
        add( btnLeerArchivo );
        btnLeerArchivo.addActionListener( this );
        btnLeerArchivo.setActionCommand( IMPORTAR_DATOS );
        btnLeerArchivo.setToolTipText( IMPORTAR_DATOS );
        btnLeerArchivo.setPreferredSize( new Dimension( 60, 60 ) );
    }
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que se encarga de tomar el control cuando se hace click en alguno de los botones.
     * @param event Evento asociado al click del botón.
     */
    public void actionPerformed( ActionEvent event )
    {
        if( event.getActionCommand( ).equals( NUEVO_DEPORTE ) )
        {
            principal.mostrarDialogoAgregarDeporte( );
        }
        else if( event.getActionCommand( ).equals( ELIMINAR_DEPORTE ) )
        {
            principal.eliminarDeporte( );
        }
        else if( event.getActionCommand( ).equals( NUEVO_DEPORTISTA ) )
        {
            principal.mostrarDialogoAgregarDeportista( );
        }
        else if( event.getActionCommand( ).equals( ELIMINAR_DEPORTISTA ) )
        {
            principal.eliminarDeportista( );
        }
        else if( event.getActionCommand( ).equals( GENERAR_REPORTE ) )
        {
            principal.generarReporteTrofeos( "./data/reporte.txt" );
        }
        else if( event.getActionCommand( ).equals( IMPORTAR_DATOS ) )
        {
            principal.actualizarInformacionDeportistas( );
        }
    }
}
