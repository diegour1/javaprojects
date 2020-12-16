package uniandes.cupi2.parqueEmpresarial.mundo;

import java.util.ArrayList;

/**
 * Clase que representa la empresa que ocupa una oficina.
 */
public class Empresa
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre de la empresa
     */
    
    private String nombre;
    
    /**
     * NIT de referencia la empresa
     */
    
    private int nit;
    
    /**
     * Numero de empleados de la empresa
     */
    
    private ArrayList<Empleado> empleados;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea una empresa con su nombre, NIT y una lista de empleados vacía. <br>
     * <b>post: </b> Los atributos: nombre y nit quedaron inicializados con los valores que llegaron por parámetro.
     *               Se inicializó la lista de empleados como una lista vacía. <br>
     * @param pNombre Nombre de la empresa. pNombre != null y pNombre != "".
     * @param pNIT NIT de la empresa. pNIT >=0 .
     */
    public Empresa( String pNombre, int pNit )
    {
         //TODO Parte2 PuntoA: Completar el método según la documentación dada.
        nombre = pNombre;
        nit = pNit;
        empleados = new ArrayList<Empleado>();
    }

    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la empresa.
     */
    
    public String darNombre()
    {
        return nombre;
    }
    
    /**
     * Retorna el nit de la empresa.
     */
    
    public int darNIT()
    {
        return nit;
    }

    /**
     * Retorna la lista de emplados de la empresa.<br>
     * <b>pre:</b> La lista de empleados se encuentra inicializada.
     * @return Lista de empleados.
     */
    public ArrayList<Empleado> darEmpleados()
    {
        //TODO Parte2 PuntoB: Completar el método según la documentación dada.
        return empleados;
    }
    

    /**
     * Retorna el numero de empleados de la empresa.
     */
    
    public int darNumeroEmpleados()
    {
        return empleados.size( );
    }
    

    /**
     * Busca el empleado de la empresa al que pertenece la cédula dada por parámetro.
     * @param pCedula Cedula del empleado. pCedula != "".
     * @return Empleado de la empresa con la cedula dada por parámetro.
     * @throws Exception Si no se encontró ningún empleado con esa cédula.
     */
    public Empleado buscarEmpleado(String pCedula) throws Exception
    {
        //TODO Parte2 PuntoD: Completar el método según la documentación dada. 
        boolean encontro = false;
        Empleado empleadoBuscado = null;
        for (Empleado empleado: empleados)
        {
            if(empleado.darCedula( ).equals( pCedula ))
            {
                empleadoBuscado = empleado;
                encontro = true;
                break;
            }            
        }
        if(!encontro)
        {
            throw new Exception("No se encontro ningun empleado con esa cedula");
        }
        return empleadoBuscado;
    }
    

    /**
     * Agrega un nuevo empleado a la empresa con un nombre y una cedula dada.
     * <b>pre: </b> La lista de empleados se encuentra inicializada.<br>
     * <b>post:</b> Se agregó un nuevo empleado a la empresa. 
     * @param pNombre El nombre del empleado. pNombre != "".
     * @param pCedula La cedula del empleado. pCedula != "".
     * @throws Exception Si ya existe un empleado en la empresa con la cedula dada por parámetro.
     */
    //TODO Parte2 PuntoE: Declarar e implementar el método agregarEmpleado según la documentación dada.

    public void agregarEmpleado(String pNombre, String pCedula) throws Exception
    {   
        boolean empleadoEncontrado = false;
        try
        {
            Empleado empleadoBuscado = buscarEmpleado(pCedula);
            empleadoEncontrado = true;
        }
        catch(Exception e)
        {
            Empleado nuevoEmpleado = new Empleado(pNombre, pCedula);
            empleados.add( nuevoEmpleado );
        }
        if(empleadoEncontrado)
        {
            throw new Exception("Ya existe un empleado con esa cedula.");   
        }
    }
    
    /**
     * Elimina un empleado dada la cedula del empleado, y retorna el empleado eliminado
     * <b>pre</b>: El empleado hace parte de los empleados de la empresa. <br>
     * <b>post</b>: El empleado con cedula dada ppr parametro es eliminado.
     * @param pCedula Cedula del empleado a eliminar. pCedula != null && pCedula!="".
     * @return El empleado eliminado.
     * @throws Exception Si el empleado sigue dentro del parque empresarial.
     */
    
  //TODO Parte2 PuntoF: Crear el contrato del método
    public Empleado eliminarEmpleado(String pCedula) throws Exception 
    {
        Empleado empleado = buscarEmpleado( pCedula );
        if(empleado.estaAdentro( ))
        {
            throw new Exception("El empleado sigue dentro del parque empresarial." );
        }
        empleados.remove( empleado );
        return empleado;
    }
    
}
