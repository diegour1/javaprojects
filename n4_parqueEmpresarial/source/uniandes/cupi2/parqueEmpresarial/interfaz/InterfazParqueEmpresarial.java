/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueEmpresarial
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
        setSize( 950, 650 );
        setTitle( "Parque Empresarial" );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Creación de los paneles aquí
        add( new PanelImagen( ), BorderLayout.NORTH );
        panelEdificio = new PanelEdificio( this );
        add( panelEdificio, BorderLayout.CENTER );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.WEST );

        panelInformacion = new PanelInformacion( this );
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
            {
                panelInformacion.cambiarOficinaSeleccionada( edificio.buscarOficinaEmpresa( nombre ) );
                actualizar( );
                JOptionPane.showMessageDialog( this, "La empresa tiene su oficina en el piso " + piso.darNumero( ) + ".", "Buscar oficina", JOptionPane.INFORMATION_MESSAGE );
            }
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
        String nombreEmpresa = JOptionPane.showInputDialog( this, "Ingresa el nombre de la empresa" );
        if(nombreEmpresa != null && !nombreEmpresa.equals( "" ))
        {
            desocuparOficina( nombreEmpresa );
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
                    panelInformacion.cambiarOficinaSeleccionada( edificio.darPisos( ).get( edificio.darPisos( ).size( ) -1 ).darOficinas( )[0]);
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
     */
    public void ocuparOficina( int pNumeroPiso, String pNombreEmpresa, int pNITEmpresa )
    {
        if( pNumeroPiso <= edificio.darPisos( ).size( ) && pNumeroPiso > 0 )
        {


            try
            {
                edificio.ocuparOficinaEnPiso( pNumeroPiso, pNombreEmpresa, pNITEmpresa );
                panelInformacion.cambiarOficinaSeleccionada( edificio.buscarOficinaEmpresa( pNombreEmpresa ) );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Ocupar Oficina", JOptionPane.INFORMATION_MESSAGE );
            }
            actualizar( );
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
            edificio.desocuparOficina( pNombreEmpresa );
            actualizar( );
            JOptionPane.showMessageDialog( this, "La oficina fue desocupada satisfactoriamente.", "Desocupar Oficina", JOptionPane.INFORMATION_MESSAGE );

        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Desocupar Oficina", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Método que se encarga de agregar un empleado a una empresa dada.
     * @param pNombreEmpresa Nombre de la empresa que desea ocupar la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @param pNombreEmpleado Nombre del empleado que se va a agregar. pNombreEmpleado != null && pNombreEmpleado != "".
     * @param pCedulaEmpleado Cédula del empleado que se va a agregar. pCedulaEmpleado != null && pCedulaEmpleado != "".
     * @return True si se agregó el empleado, false en caso contrario.
     */
    public boolean agregarEmpleado( String pNombreEmpresa, String pNombreEmpleado, String pCedulaEmpleado )
    {
        try
        {
            edificio.agregarEmpleado( pNombreEmpresa, pNombreEmpleado, pCedulaEmpleado );
            actualizar( );
            JOptionPane.showMessageDialog( this, "El empleado se agregó satisfactoriamente.", "Agregar empleado", JOptionPane.INFORMATION_MESSAGE );
            return true;
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar Empleado", JOptionPane.ERROR_MESSAGE );
            return false;
        }        
    }


    /**
     * Método que se encarga de eliminar un empleado.
     */
    public void eliminarEmpleado( )
    {
        try
        {
            String cedula = JOptionPane.showInputDialog( "Cédula del empleado:" );
            if(cedula != null){
                edificio.eliminarEmpleado( cedula );
                actualizar( );
                JOptionPane.showMessageDialog( this, "El empleado se eliminó satisfactoriamente.", "Agregar empleado", JOptionPane.INFORMATION_MESSAGE );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar Empleado", JOptionPane.ERROR_MESSAGE );
        }        
    }

    /**
     * Registra un ingreso o una salida de un empleado de una empresa.
     * @param pCedulaEmpleado Cedula del empleado. pCedulaEmpleado != null && pCedulaEmpleado != "".
     * @param pRegistro 1 para entrada y -1 para salida. pRegistro == 1 || pRegistro == -1
     */
    public void registrar( String pCedulaEmpleado, int pRegistro){
        switch( pRegistro )
        {
            case 1:
                try
                {
                    edificio.registrarIngreso(  pCedulaEmpleado );
                }
                catch( Exception e )
                {
                   JOptionPane.showMessageDialog( this, e.getMessage( ), "Registrar ingreso", JOptionPane.ERROR_MESSAGE );
                }
                break;

            case -1:
                try
                {
                    edificio.registrarSalida( pCedulaEmpleado );
                }
                catch( Exception e )
                {
                    JOptionPane.showMessageDialog( this, e.getMessage( ), "Registrar salida", JOptionPane.ERROR_MESSAGE );
                }
                break;
        }
        actualizar( );
    }

    /**
     * Muestra la información de la oficina dada.<br>
     * @param pOficina Oficina seleccionada. pOficina != null.
     */
    public void seleccionarOficina(Oficina pOficina){
        panelInformacion.cambiarOficinaSeleccionada(pOficina);
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
        panelInformacion.actualizar( );
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