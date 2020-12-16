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

    //TODO Parte5 PuntoA: Crear el contrato del método buscarOficinaEmpresa
    /**
     * Busca la oficina de la empresa en el edificio dado el nombre de la empresa.<br>
     * <b>pre</b>: La lista de pisos se encuentra inicializada. <br>
     * @param pNombreEmpresa Nombre de la empresa buscada.
     * @return La oficina buscada, null si no se encuentra la oficina.
     */
    public Oficina buscarOficinaEmpresa( String pNombreEmpresa )
    {
        Oficina respuesta = null;
        for(int i=0; i<pisos.size( ) && respuesta == null; i++)
        {
            Piso piso = pisos.get( i );
            respuesta=piso.buscarOficinaEmpresa( pNombreEmpresa );
        }

        return respuesta;
    }
    
    /**
     * Asigna la oficina a una empresa en el piso dado.<br>
     * <b>pre</b>: La lista de pisos está inicializada, el piso ingresado existe en el edificio.<br>
     * <b>post</b>: Si existían oficinas disponibles en el piso seleccionado, la empresa ingresada por parámetro ocupa una oficina en el piso.
     *              Si no existían oficinas disponibles en el piso seleccionado, la empresa ingresada por parámetro ocupa cualquier oficina disponible del mismo tamaño.
     * @param pNumeroPiso Número del piso donde se desea ocupar la oficina. pNumeroPiso > 0 && pNumeroPiso <= pisos.size().
     * @param pNombreEmpresa Nombre de la empresa que desea ocupar la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @param pNITEmpresa Número del NIT de la empresa. pNITEmpresa >= 0.
     * @throws Exception - Si la empresa ya tiene una oficina en el edificio.
     *                   - Si no se pudo ocupar una oficina en el piso requerido y se le asignó una oficina del mismo tamaño en otro piso.
     *                   - Si no se pudo ocupar una oficina en el piso y no hay más oficinas del mismo tamaño libres en el edificio.
     */
     //TODO Parte5 PuntoB: Modificar la signatura y la implementación del método ocuparOficinaEnPiso para que cumpla con la documentación dada.
    public void ocuparOficinaEnPiso( int pNumeroPiso, String pNombreEmpresa, int pNITEmpresa) throws Exception
    {     
        boolean oficinaOcupadaPiso = false;
        
        for(Piso pisoTemp0:darPisos())
        {
            if(pisoTemp0.existeEmpresa( pNombreEmpresa ))
            {
                throw new Exception("La empresa ya tiene una oficina en el edificio");
            } 
        }
        
        Piso piso = darPisos( ).get( pNumeroPiso - 1);
        try
        {
            piso.ocuparOficina( pNombreEmpresa, pNITEmpresa);
            oficinaOcupadaPiso = true;
        }
        catch (Exception e)
        {
            for(Piso pisoTemp: darPisos())
            {
                for(Oficina oficinaTemp: pisoTemp.darOficinas( ))
                {
                    if(oficinaTemp.darTamano( )==piso.darOficinas()[0].darTamano( ) && !oficinaTemp.estaOcupada( ))
                    {
                        oficinaTemp.ocuparOficina( pNombreEmpresa, pNITEmpresa );
                        oficinaOcupadaPiso = true;
                        throw new Exception("Se le asigno una oficina a la empresa en otro piso");
                    }
                }
            }
        }
        if(!oficinaOcupadaPiso)
        {
            throw new Exception("No se pudo ocupar la oficina en el piso y no hay mas oficinas en el edificio desocupadas con ese tamano");
        }
    }
    

    /**
     * Desocupa la oficina que ocupa la empresa con el nombre dado por parámetro. <br>
     * <b>pre</b>: La lista de pisos está inicializada.<br>
     * <b>post</b>: Si la empresa tenía una oficina ocupada, la desocupó.
     * @param pNombreEmpresa Nombre de la empresa que ocupa la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @throws Exception - Si la empresa no tiene oficina en el edificio.
     *                   - Si la empresa tiene empleados adentro del parque empresarial.
     */
    //TODO Parte5 PuntoC: Modificar la signatura y la implementación del método desocuparOficina para que cumpla con la documentación dada.
    public void desocuparOficina( String pNombreEmpresa ) throws Exception
    {
        Oficina oficinaBuscada = buscarOficinaEmpresa( pNombreEmpresa );
        if(oficinaBuscada != null)
        {
            oficinaBuscada.desocuparOficina();
        }
        else
        {
            throw new Exception("La empresa no tiene oficina en el edificio");
        }
    }
    
    
    /**
     * Agrega un nuevo empleado con los datos dados a la empresa con el nombre ingresado por parámetro.
     * <b>pre:</b>La lista de pisos está inicializada.</br>
     * <b>post:</b>Se agregó un nuevo empleado a la empresa.
     * @param pNombreEmpresa Nombre de la empresa. pNombreEmpresa != "" && pNombreEmpresa != null.
     * @param pNombreEmpleado Nombre del empleado. pNombreEmpleado != "" && pNombreEmpleado != null.
     * @param pCedulaEmpleado Cédula del empleado. pCedulaEmpleado != "" && pCedulaEmpleado != null.
     * @throws Exception - Si la empresa no tiene oficina en el edificio.
     *                   - Si ya existe un empleado en el edificio con la misma cedula.
     *                   - Si la oficina no tiene espacio suficiente para agregar al empleado. Es decir, en caso de agregar un nuevo empleado no cumpliría con la restricción de área mínima por empleado.
     */
    public void agregarEmpleado(String pNombreEmpresa, String pNombreEmpleado, String pCedulaEmpleado) throws Exception
    {
        //TODO Parte5 PuntoD: Completar el método según la documentación dada.
        for (Piso piso: darPisos())
        {
            for(Oficina oficina: piso.darOficinas( ))
            {
                if(oficina.trabajaEnEmpresa( pCedulaEmpleado ))
                {
                    throw new Exception("Ya existe un empleado en el edificio con la misma cedula");
                }
            }
        }
        
        Oficina oficina = buscarOficinaEmpresa(pNombreEmpresa);
        if(oficina == null)
        {
            throw new Exception("La empresa no tiene oficina en el edificio");
        }
        else
        {
            oficina.agregarEmpleado( pNombreEmpleado, pCedulaEmpleado );
        }
    }
    

    /**
     * Elimina el empleado con la cédula dada. <br>
     * <b>pre:</b>La lista de pisos está inicializada.<br>
     * <b>post:</b>Se eliminó el empleado de la empresa.
     * @param pCedulaEmpleado Cédula del empleado. pCedulaEmpleado != "" && pCedulaEmpleado != null.
     * @throws Exception - Si no existe un empleado con la cédula dada.
     *                   - Si el empleado que se quiere eliminar está adentro del edificio.
     */
    //TODO Parte5 PuntoE: Declarar e implementar el método eliminarEmpleado según la documentación dada.
   
    public void eliminarEmpleado(String pCedula) throws Exception
    {
        Oficina oficinaBuscada = null;
        for(Piso pisoTemp: darPisos())
        {
            oficinaBuscada = pisoTemp.buscarOficinaEmpleado( pCedula );
            if(oficinaBuscada != null)
                break;
        }
        if(oficinaBuscada == null)
        {
            throw new Exception("No existe un empleado con la cedula dada");
        }
        else
        {
            oficinaBuscada.eliminarEmpleado( pCedula );
        }
    }
    
    
    //TODO Parte5 PuntoF: Crear el contrato del método registrarIngreso
    
    /**
     * Registra el ingreso de un empleado en el parque empresarial dada la cedula del empleado.<br>
     * <b>pre:<\b> La lista de pisos se encuentra inicializada.<br>
     * <b>post:<\b> Registra el ingreso del empleado en el parque empresarial.
     * @param pCedulaEmpleado Cedula del empleado.
     * @throws Exception Si no existe un empleado con la cedula dada en el parque empresarial.
     * @throws Exception Si el empleado ya se encuentra adentro del parque empresarial. 
     */
    
    public void registrarIngreso( String pCedulaEmpleado) throws Exception 
    {
        boolean registrado = false;
        for(int i=0;i<pisos.size( ) && !registrado;i++)
        {
            Oficina oficina = pisos.get( i ).buscarOficinaEmpleado( pCedulaEmpleado );
            if(oficina!=null)
            {
                oficina.darEmpresa( ).buscarEmpleado( pCedulaEmpleado ).registrarIngreso( );
                registrado = true;
            }
        }
        if(!registrado)
        {
            throw new Exception("No existe el empleado con cedula "+pCedulaEmpleado);
        }
    }
    
    /**
     * Registra la salida de un empleado en el parque empresarial dada la cedula del empleado.<br>
     * <b>pre:<\b> La lista de pisos se encuentra inicializada.<br>
     * <b>post:<\b> Registra la salida del empleado en el parque empresarial.
     * @param pCedulaEmpleado Cedula del empleado.
     * @throws Exception Si no existe un empleado con la cedula dada en el parque empresarial.
     * @throws Exception Si el empleado ya se encuentra fuera del parque empresarial.
     */

    //TODO Parte5 PuntoG: Crear el contrato del método registrarIngreso
    public void registrarSalida(String pCedulaEmpleado) throws Exception
    {
        boolean registrado = false;
        for(int i=0;i<pisos.size( ) && !registrado;i++)
        {
            Oficina oficina = pisos.get( i ).buscarOficinaEmpleado( pCedulaEmpleado );
            if(oficina!=null)
            {
                oficina.darEmpresa( ).buscarEmpleado( pCedulaEmpleado ).registrarSalida( );
                registrado = true;
            }
        }
        if(!registrado)
        {
            throw new Exception("No existe el empleado con cedula "+pCedulaEmpleado);
        }
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