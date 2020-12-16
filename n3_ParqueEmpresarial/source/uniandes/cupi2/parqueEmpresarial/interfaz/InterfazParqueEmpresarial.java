/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_parqueEmpresarial
 * Autor: Equipo Cupi2 - 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueEmpresarial.interfaz;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.parqueEmpresarial.interfaz.DialogoDesocuparOficina;
import uniandes.cupi2.parqueEmpresarial.mundo.Edificio;
import uniandes.cupi2.parqueEmpresarial.mundo.Oficina;
import uniandes.cupi2.parqueEmpresarial.mundo.Piso;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazParqueEmpresarial extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Edificio edificio;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de la estructura del edificio.
     */
    private PanelEdificio panelEdificio;

    /**
     * Panel con las extensiones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel de información.
     */
    private PanelInformacion panelInformacion;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Interfaz principal de la aplicación. <br>
     * <b>post: </b> Ventana principal de la aplicación.
     */
    public InterfazParqueEmpresarial( )
    {
        // Crea la clase principal
        edificio = new Edificio( );

        // Construye la forma
        getContentPane( ).setLayout( new BorderLayout( ) );
        setSize( 800, 630 );
        setTitle( "Parque Empresarial" );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Creación de los paneles aquí
        add( new PanelImagen( ), BorderLayout.NORTH );
        panelEdificio = new PanelEdificio( );
        add( panelEdificio, BorderLayout.CENTER );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.WEST );

        panelInformacion = new PanelInformacion( this, edificio.darPisos( ) );
        add( panelInformacion, BorderLayout.EAST );

        // Centrar la ventana
        setLocationRelativeTo( null );
        actualizar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Devuelve un arreglo con los nombres de las oficinas ocupadas.
     * @return Arreglo con los nombres de las oficinas ocupadas.
     */
    public String[] darNombresOficinasOcupadas( )
    {
        ArrayList<Oficina> oficinas = edificio.darOficinasOcupadas( );
        String[] lista = new String[oficinas.size( )];
        for( int i = 0; i < oficinas.size( ); i++ )
        {
            lista[ i ] = ( ( Oficina )oficinas.get( i ) ).darEmpresa( ).darNombre( );
        }
        return lista;
    }

    /**
     * Muestra el porcentaje de ocupación del edificio.
     */
    public void darPorcentajeOcupacion( )
    {
        JOptionPane.showMessageDialog( this, "El porcentaje de ocupación del edificio es: " + formatearValorReal( edificio.darPorcentajeOcupacion( ) ) + "%.", "Porcentaje de Ocupación", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método que busca el número del piso donde se encuentra la oficina ocupada por la empresa con el nombre dado.
     */
    public void buscarOficina( )
    {
        String nombre = JOptionPane.showInputDialog( this, "Nombre de la empresa.", "Buscar oficina", JOptionPane.QUESTION_MESSAGE );
        if( nombre != null )
        {
            Piso piso = edificio.buscarPisoOficina( nombre );
            if( piso == null )
                JOptionPane.showMessageDialog( this, "La empresa no tiene oficina en el edificio.", "Buscar oficina", JOptionPane.INFORMATION_MESSAGE );
            else
                JOptionPane.showMessageDialog( this, "La empresa tiene su oficina en el piso " + piso.darNumero( ) + ".", "Buscar oficina", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Busca el piso que contenga el mayor número de empleados.<br>
     * En caso de haber más de un piso con número igual de empleados, se toma en cuenta el primer piso encontrado.
     */
    public void buscarPisoConMayorNumeroDeEmpleados( )
    {
        if( edificio.darPisos( ).size( ) == 0 )
        {
            JOptionPane.showMessageDialog( this, "La empresa no tiene pisos en el edificio.", "Piso con más empleados", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            Piso piso = edificio.buscarPisoConMayorNumeroDeEmpleados( );
            if( piso != null )
            {
                JOptionPane.showMessageDialog( this, "El piso con mayor número de empleados es el piso " + piso.darNumero( ) + ".", "Piso con más empleados", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No hay ningún empleado en el edificio.", "Piso con más empleados", JOptionPane.INFORMATION_MESSAGE );

            }
        }
    }

    /**
     * Método que muestra el diálogo para desocupar una oficina.
     */
    public void mostrarDialogoDesocuparOficina( )
    {
        if( edificio.darOficinasOcupadas( ).size( ) != 0 )
        {
            DialogoDesocuparOficina dialogo = new DialogoDesocuparOficina( this );
            dialogo.setVisible( true );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "El edificio no tiene oficinas para desocupar. ", "Desocupar Oficina", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Método que muestra el diálogo para ocupar una oficina.
     */
    public void mostrarDialogoOcuparOficina( )
    {
        DialogoOcuparOficina dialogo = new DialogoOcuparOficina( this, edificio.darPisos( ).size( ) );
        dialogo.setVisible( true );
    }

    /**
     * Método que procesa el ingreso de un nuevo piso al edificio.
     */
    public void agregarPiso( )
    {
        String valor = JOptionPane.showInputDialog( this, "Cantidad de oficinas del piso", "Agregar piso", JOptionPane.QUESTION_MESSAGE );
        if( valor != null )
        {
            try

            {
                int tamanio = Integer.valueOf( valor ).intValue( );
                if( tamanio > 0 && tamanio <= Piso.CANTIDAD_MAXIMA_OFICINAS )
                {
                    edificio.agregarPiso( Integer.valueOf( valor ).intValue( ) );
                    JOptionPane.showMessageDialog( this, "El piso fue agregado exitosamente.", "Agregar piso", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Ingrese una cantidad de oficinas válida.", "Agregar piso", JOptionPane.INFORMATION_MESSAGE );

                }

            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "La cantidad de oficinas debe ser un valor numérico.", "Agregar piso", JOptionPane.ERROR_MESSAGE );
            }
        }
        actualizar( );
    }

    /**
     * Método que se encarga de asignar la oficina a una empresa en el piso dado.
     * @param pNumeroPiso Número del piso donde se desea ocupar la oficina. pNumeroPiso > 0.
     * @param pNombreEmpresa Nombre de la empresa que desea ocupar la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @param pNITEmpresa Número del NIT de la empresa. pNITEmpresa >= 0.
     * @param pNumeroEmpleadosEmpresa Número de empleados que tiene la empresa. pNumeroEmpleadosEmpresa >= 0.
     */
    public void ocuparOficina( int pNumeroPiso, String pNombreEmpresa, int pNITEmpresa, int pNumeroEmpleadosEmpresa )
    {
        if( pNumeroPiso <= edificio.darPisos( ).size( ) && pNumeroPiso > 0 )
        {

            if( edificio.buscarPisoOficina( pNombreEmpresa ) == null )
            {
                if( edificio.ocuparOficinaEnPiso( pNumeroPiso, pNombreEmpresa, pNITEmpresa, pNumeroEmpleadosEmpresa ) )
                {
                    panelInformacion.llenarListaOficinasOcupadas( edificio.darOficinasOcupadas( ) );
                    actualizar( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "El piso está lleno. No se pudo ocupar la oficina.", "Ocupar Oficina", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "La empresa " + pNombreEmpresa + " ya tiene una oficina en el edificio.", "Ocupar Oficina", JOptionPane.INFORMATION_MESSAGE );
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Ingrese un número de piso válido.", "Ocupar Oficina", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Método que desocupa la oficina que ocupa la empresa con el nombre dado por parámetro.
     * @param pNombreEmpresa Nombre de la empresa que se desocupará la oficina que la contiene. pNombreEmpresa != "" && pNombreEmpresa != null.
     */
    public void desocuparOficina( String pNombreEmpresa )
    {
        try
        {
            if( edificio.desocuparOficina( pNombreEmpresa ) )
            {
                actualizar( );
                panelInformacion.llenarListaOficinasOcupadas( edificio.darOficinasOcupadas( ) );
                JOptionPane.showMessageDialog( this, "La oficina fue desocupada satisfactoriamente.", "Desocupar Oficina", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "La empresa no tiene una oficina en el edificio.", "Desocupar Oficina", JOptionPane.WARNING_MESSAGE );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "El edificio no tiene oficinas ocupadas. ", "Desocupar Oficina", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Actualiza la visualización de la interfaz. <br>
     * <b>post: </b> Se actualiza la visualización.
     */
    private void actualizar( )
    {
        ArrayList<Piso> pisos = edificio.darPisos( );
        if( pisos.size( ) > 0 )
        {
            panelOpciones.habilitarBotonOcuparOficina( );
        }
        panelEdificio.actualizar( pisos );
    }

    /**
     * Formatea el valor que entra por parámetro a un tamaño específico.
     * @param pValor valor que se desear formatear. pValor>0
     * @return Valor en formato específico.
     */
    private String formatearValorReal( double pValor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ##.##" );
        df.setMinimumFractionDigits( 1 );
        return df.format( pValor );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = edificio.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = edificio.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Método ejecuta la aplicación, creando una nueva interfaz.
     * @param pArgs Argumentos para la ejecución.
     */
    public static void main( String[] pArgs )
    {
        InterfazParqueEmpresarial interfaz = new InterfazParqueEmpresarial( );
        interfaz.setVisible( true );
    }

}