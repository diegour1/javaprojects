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

    /**
     * Asigna la oficina a una empresa en el piso dado.<br>
     * <b>pre</b>: La lista de pisos est� inicializada, el piso ingresado existe en el edificio y la empresa no existe en el edificio.<br>
     * <b>post</b>: Si exist�an oficinas disponibles en el piso seleccionado, la empresa ingresada por par�metro ocupa una oficina en el piso.
     * @param pNumeroPiso N�mero del piso donde se desea ocupar la oficina. pNumeroPiso > 0 && pNumeroPiso <= pisos.size().
     * @param pNombreEmpresa Nombre de la empresa que desea ocupar la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @param pNITEmpresa N�mero del NIT de la empresa. pNITEmpresa >= 0.
     * @param pNumeroEmpleadosEmpresa N�mero de empleados que tiene la empresa. pNumeroEmpleadosEmpresa >= 0.
     * @return True si se ocup� la oficina, false de lo contrario.
     */
    public boolean ocuparOficinaEnPiso( int pNumeroPiso, String pNombreEmpresa, int pNITEmpresa, int pNumeroEmpleadosEmpresa )
    {
        // TODO Parte3 PuntoI: Complete el m�todo ocuparOficinaEnPiso seg�n la documentaci�n del m�todo.
        
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
     * Desocupa la oficina que ocupa la empresa con el nombre dado por par�metro. <br>
     * <b>pre</b>: La lista de pisos est� inicializada.<br>
     * <b>post</b>: Si la empresa ten�a una oficina ocupada, la desocup�.
     * @param pNombreEmpresa Nombre de la empresa que ocupa la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @return True si desocup� la oficina, false si la empresa no ten�a ninguna oficina ocupada.
     */
    public boolean desocuparOficina( String pNombreEmpresa )
    {
        // TODO Parte3 PuntoJ: Complete el m�todo desocuparOficina seg�n la documentaci�n del m�todo.
        
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