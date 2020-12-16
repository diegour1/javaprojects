/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
    // TODO Parte3 PuntoA: Declare la asociaci�n pisos como una contenedora de tama�o variable.
    private ArrayList<Piso> pisos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el edificio nuevo con sus pisos vac�os.<br>
     * <b>post: </b> El atributo pisos qued� inicializado.<br>
     */
    public Edificio( )
    {
        // TODO Parte3 PuntoB: Complete el m�todo constructor de la clase.
        pisos = new ArrayList<Piso>();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la lista de pisos del edificio.
     * @return Pisos del edificio.
     */
    public ArrayList<Piso> darPisos( )
    {
        // TODO Parte3 PuntoC: Complete el m�todo darPisos seg�n la documentaci�n del m�todo.
        return pisos;
    }

    /**
     * Retorna una lista con las oficinas ocupadas del edificio.<br>
     * <b>pre</b>: La lista de pisos est� inicializada.<br>
     * @return Oficinas ocupadas del edificio.
     */
    public ArrayList<Oficina> darOficinasOcupadas( )
    {
        // TODO Parte3 PuntoD: Complete el m�todo darOficinasOcupadas seg�n la documentaci�n del m�todo.
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
     * Retorna el porcentaje de ocupaci�n del edificio.<br>
     * El porcentaje se calcula teniendo en cuenta la cantidad de oficinas ocupadas y el total de oficinas del edificio<br>
     * <b>pre</b>: La lista de pisos est� inicializada.<br>
     * @return Porcentaje de ocupaci�n del edificio (de 0.0 a 100.0).
     */
    public double darPorcentajeOcupacion( )
    {
        // TODO Parte3 PuntoE: Complete el m�todo darPorcentajeOcupacion seg�n la documentaci�n del m�todo.
        
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
     * <b>pre</b>: La lista de pisos est� inicializada.
     * @param pNombreEmpresa Nombre de la empresa que ocupa la oficina. pNombreEmpresa != null & pNombreEmpresa != "".
     * @return Piso donde se encuentra la oficina ocupada por la empresa. Si la empresa no tiene oficina retorna null.
     */
    public Piso buscarPisoOficina( String pNombreEmpresa )
    {
        // TODO Parte3 PuntoF: Complete el m�todo buscarPisoOficina seg�n la documentaci�n del m�todo.
        
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
     * Busca el piso que contenga el mayor n�mero de empleados. <br>
     * <b>pre</b>: La lista de pisos est� inicializada.<br>
     * @return Piso con mayor el n�mero de empleados.<br>
     *         En caso de haber m�s de un piso con el mayor de empleados, se retorna el primer piso encontrado.<br>
     *         Si no hay ning�n empleado en el edificio, retorna null.
     */
    public Piso buscarPisoConMayorNumeroDeEmpleados( )
    {
        // TODO Parte3 PuntoG: Complete el m�todo buscarPisoConMayorNumeroDeEmpleados seg�n la documentaci�n del m�todo.
        
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
     * <b>pre</b>: La lista de pisos est� inicializada. La cantidad de oficinas es v�lida<br>
     * <b>post</b>: Se cre� y se agreg� un piso con el n�mero de oficinas dado.
     * @param pCantidadOficinas N�mero de oficinas que debe tener el piso. pCantidadOficinas >= 0 && pCantidadOficinas <= CANTIDAD_MAXIMA_OFICINAS .
     */
    public void agregarPiso( int pCantidadOficinas )
    {
        // TODO Parte3 PuntoH: Complete el m�todo agregarPiso seg�n la documentaci�n del m�todo.
        Piso piso = new Piso(pCantidadOficinas, darPisos( ).size( ) + 1 );
        pisos.add( piso );      
    }

    //TODO Parte5 PuntoA: Crear el contrato del m�todo buscarOficinaEmpresa
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
     * <b>pre</b>: La lista de pisos est� inicializada, el piso ingresado existe en el edificio.<br>
     * <b>post</b>: Si exist�an oficinas disponibles en el piso seleccionado, la empresa ingresada por par�metro ocupa una oficina en el piso.
     *              Si no exist�an oficinas disponibles en el piso seleccionado, la empresa ingresada por par�metro ocupa cualquier oficina disponible del mismo tama�o.
     * @param pNumeroPiso N�mero del piso donde se desea ocupar la oficina. pNumeroPiso > 0 && pNumeroPiso <= pisos.size().
     * @param pNombreEmpresa Nombre de la empresa que desea ocupar la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @param pNITEmpresa N�mero del NIT de la empresa. pNITEmpresa >= 0.
     * @throws Exception - Si la empresa ya tiene una oficina en el edificio.
     *                   - Si no se pudo ocupar una oficina en el piso requerido y se le asign� una oficina del mismo tama�o en otro piso.
     *                   - Si no se pudo ocupar una oficina en el piso y no hay m�s oficinas del mismo tama�o libres en el edificio.
     */
     //TODO Parte5 PuntoB: Modificar la signatura y la implementaci�n del m�todo ocuparOficinaEnPiso para que cumpla con la documentaci�n dada.
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
     * Desocupa la oficina que ocupa la empresa con el nombre dado por par�metro. <br>
     * <b>pre</b>: La lista de pisos est� inicializada.<br>
     * <b>post</b>: Si la empresa ten�a una oficina ocupada, la desocup�.
     * @param pNombreEmpresa Nombre de la empresa que ocupa la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @throws Exception - Si la empresa no tiene oficina en el edificio.
     *                   - Si la empresa tiene empleados adentro del parque empresarial.
     */
    //TODO Parte5 PuntoC: Modificar la signatura y la implementaci�n del m�todo desocuparOficina para que cumpla con la documentaci�n dada.
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
     * Agrega un nuevo empleado con los datos dados a la empresa con el nombre ingresado por par�metro.
     * <b>pre:</b>La lista de pisos est� inicializada.</br>
     * <b>post:</b>Se agreg� un nuevo empleado a la empresa.
     * @param pNombreEmpresa Nombre de la empresa. pNombreEmpresa != "" && pNombreEmpresa != null.
     * @param pNombreEmpleado Nombre del empleado. pNombreEmpleado != "" && pNombreEmpleado != null.
     * @param pCedulaEmpleado C�dula del empleado. pCedulaEmpleado != "" && pCedulaEmpleado != null.
     * @throws Exception - Si la empresa no tiene oficina en el edificio.
     *                   - Si ya existe un empleado en el edificio con la misma cedula.
     *                   - Si la oficina no tiene espacio suficiente para agregar al empleado. Es decir, en caso de agregar un nuevo empleado no cumplir�a con la restricci�n de �rea m�nima por empleado.
     */
    public void agregarEmpleado(String pNombreEmpresa, String pNombreEmpleado, String pCedulaEmpleado) throws Exception
    {
        //TODO Parte5 PuntoD: Completar el m�todo seg�n la documentaci�n dada.
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
     * Elimina el empleado con la c�dula dada. <br>
     * <b>pre:</b>La lista de pisos est� inicializada.<br>
     * <b>post:</b>Se elimin� el empleado de la empresa.
     * @param pCedulaEmpleado C�dula del empleado. pCedulaEmpleado != "" && pCedulaEmpleado != null.
     * @throws Exception - Si no existe un empleado con la c�dula dada.
     *                   - Si el empleado que se quiere eliminar est� adentro del edificio.
     */
    //TODO Parte5 PuntoE: Declarar e implementar el m�todo eliminarEmpleado seg�n la documentaci�n dada.
   
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
    
    
    //TODO Parte5 PuntoF: Crear el contrato del m�todo registrarIngreso
    
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

    //TODO Parte5 PuntoG: Crear el contrato del m�todo registrarIngreso
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
     * M�todo para la extensi�n 1.
     * @return respuesta1.
     */
    public String metodo1( )

    {
        return "Respuesta 1.";
    }

    /**
     * M�todo para la extensi�n2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

}