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
package uniandes.cupi2.parqueEmpresarial.mundo;

import java.util.ArrayList;

/**
 * Clase que representa el edificio de oficinas.
 */
public class Edificio
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Pisos del edificio.
     */
    // TODO Parte3 PuntoA: Declare la asociación pisos como una contenedora de tamaño variable.
    private ArrayList<Piso> pisos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el edificio nuevo con sus pisos vacíos.<br>
     * <b>post: </b> El atributo pisos quedó inicializado.<br>
     */
    public Edificio( )
    {
        // TODO Parte3 PuntoB: Complete el método constructor de la clase.
        pisos = new ArrayList<Piso>();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la lista de pisos del edificio.
     * @return Pisos del edificio.
     */
    public ArrayList<Piso> darPisos( )
    {
        // TODO Parte3 PuntoC: Complete el método darPisos según la documentación del método.
        return pisos;
    }

    /**
     * Retorna una lista con las oficinas ocupadas del edificio.<br>
     * <b>pre</b>: La lista de pisos está inicializada.<br>
     * @return Oficinas ocupadas del edificio.
     */
    public ArrayList<Oficina> darOficinasOcupadas( )
    {
        // TODO Parte3 PuntoD: Complete el método darOficinasOcupadas según la documentación del método.
        ArrayList<Oficina> oficinasOcupadas = new ArrayList<Oficina>();
        for(Piso piso:darPisos( ))
        {
            for(Oficina oficina:piso.darOficinas( ) )
            {
                if(oficina.estaOcupada( ) )
                {
                    oficinasOcupadas.add( oficina );
                }
            }
        }
        return oficinasOcupadas;
    }

    /**
     * Retorna el porcentaje de ocupación del edificio.<br>
     * El porcentaje se calcula teniendo en cuenta la cantidad de oficinas ocupadas y el total de oficinas del edificio<br>
     * <b>pre</b>: La lista de pisos está inicializada.<br>
     * @return Porcentaje de ocupación del edificio (de 0.0 a 100.0).
     */
    public double darPorcentajeOcupacion( )
    {
        // TODO Parte3 PuntoE: Complete el método darPorcentajeOcupacion según la documentación del método.
        
        double porcentajeOcupacion;
        int numeroOficinasEdificio = 0;
        for(Piso piso:darPisos( ))
        {
            numeroOficinasEdificio += piso.darCantidadOficinas( );
        }
        porcentajeOcupacion = (((double) darOficinasOcupadas( ).size( ))/ (double) numeroOficinasEdificio)*100;
        return porcentajeOcupacion;
        
    }

    /**
     * Retorna el piso donde se encuentra la oficina ocupada por la empresa con el nombre dado.<br>
     * <b>pre</b>: La lista de pisos está inicializada.
     * @param pNombreEmpresa Nombre de la empresa que ocupa la oficina. pNombreEmpresa != null & pNombreEmpresa != "".
     * @return Piso donde se encuentra la oficina ocupada por la empresa. Si la empresa no tiene oficina retorna null.
     */
    public Piso buscarPisoOficina( String pNombreEmpresa )
    {
        // TODO Parte3 PuntoF: Complete el método buscarPisoOficina según la documentación del método.
        
        Piso pisoEmpresa = null;
        
        for(Piso piso:darPisos( ))
        {
            if(piso.existeEmpresa( pNombreEmpresa ) )
            {
                pisoEmpresa = piso;
                break;
            }
        }
        
        return pisoEmpresa;

    }

    /**
     * Busca el piso que contenga el mayor número de empleados. <br>
     * <b>pre</b>: La lista de pisos está inicializada.<br>
     * @return Piso con mayor el número de empleados.<br>
     *         En caso de haber más de un piso con el mayor de empleados, se retorna el primer piso encontrado.<br>
     *         Si no hay ningún empleado en el edificio, retorna null.
     */
    public Piso buscarPisoConMayorNumeroDeEmpleados( )
    {
        // TODO Parte3 PuntoG: Complete el método buscarPisoConMayorNumeroDeEmpleados según la documentación del método.
        
        Piso PisoConMayorNumeroDeEmpleados = null;
        int numeroDeEmpleadosMayorPiso = 0;
        
        for(Piso piso:darPisos( ))
        {
            int numeroDeEmpleadosPiso = 0;
            for(Oficina oficina:piso.darOficinas( ))
            {
                if(oficina.darEmpresa( ) != null)
                {
                    numeroDeEmpleadosPiso += oficina.darEmpresa( ).darNumeroEmpleados( );   
                }
            }
            if (numeroDeEmpleadosPiso>numeroDeEmpleadosMayorPiso)
            {
                numeroDeEmpleadosMayorPiso = numeroDeEmpleadosPiso;
                PisoConMayorNumeroDeEmpleados = piso;
            }
        }
        return PisoConMayorNumeroDeEmpleados;
    }

    /**
     * Agrega un piso al edificio.<br>
     * <b>pre</b>: La lista de pisos está inicializada. La cantidad de oficinas es válida<br>
     * <b>post</b>: Se creó y se agregó un piso con el número de oficinas dado.
     * @param pCantidadOficinas Número de oficinas que debe tener el piso. pCantidadOficinas >= 0 && pCantidadOficinas <= CANTIDAD_MAXIMA_OFICINAS .
     */
    public void agregarPiso( int pCantidadOficinas )
    {
        // TODO Parte3 PuntoH: Complete el método agregarPiso según la documentación del método.
        Piso piso = new Piso(pCantidadOficinas, darPisos( ).size( ) + 1 );
        pisos.add( piso );      
    }

    /**
     * Asigna la oficina a una empresa en el piso dado.<br>
     * <b>pre</b>: La lista de pisos está inicializada, el piso ingresado existe en el edificio y la empresa no existe en el edificio.<br>
     * <b>post</b>: Si existían oficinas disponibles en el piso seleccionado, la empresa ingresada por parámetro ocupa una oficina en el piso.
     * @param pNumeroPiso Número del piso donde se desea ocupar la oficina. pNumeroPiso > 0 && pNumeroPiso <= pisos.size().
     * @param pNombreEmpresa Nombre de la empresa que desea ocupar la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @param pNITEmpresa Número del NIT de la empresa. pNITEmpresa >= 0.
     * @param pNumeroEmpleadosEmpresa Número de empleados que tiene la empresa. pNumeroEmpleadosEmpresa >= 0.
     * @return True si se ocupó la oficina, false de lo contrario.
     */
    public boolean ocuparOficinaEnPiso( int pNumeroPiso, String pNombreEmpresa, int pNITEmpresa, int pNumeroEmpleadosEmpresa )
    {
        // TODO Parte3 PuntoI: Complete el método ocuparOficinaEnPiso según la documentación del método.
        
        boolean oficinaOcupadaPiso = false;
        
        Piso piso = darPisos( ).get( pNumeroPiso - 1);
        
        piso.ocuparOficina( pNombreEmpresa, pNITEmpresa, pNumeroEmpleadosEmpresa );
        
        if (piso.existeEmpresa( pNombreEmpresa ))
        {
            oficinaOcupadaPiso = true;
        }
        
        return oficinaOcupadaPiso;

    }

    /**
     * Desocupa la oficina que ocupa la empresa con el nombre dado por parámetro. <br>
     * <b>pre</b>: La lista de pisos está inicializada.<br>
     * <b>post</b>: Si la empresa tenía una oficina ocupada, la desocupó.
     * @param pNombreEmpresa Nombre de la empresa que ocupa la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @return True si desocupó la oficina, false si la empresa no tenía ninguna oficina ocupada.
     */
    public boolean desocuparOficina( String pNombreEmpresa )
    {
        // TODO Parte3 PuntoJ: Complete el método desocuparOficina según la documentación del método.
        
        boolean desocupoOficina = false;
        
        Piso piso = buscarPisoOficina( pNombreEmpresa );
        if(piso != null)
        {
            piso.desocuparOficina( pNombreEmpresa );
            desocupoOficina = true;
        }
        
        return desocupoOficina; 
        
    }

    /**
     * Método para la extensión 1.
     * @return respuesta1.
     */
    public String metodo1( )

    {
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

}