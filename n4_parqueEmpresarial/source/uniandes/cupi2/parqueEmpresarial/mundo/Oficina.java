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

/**
 * Clase que representa una oficina.
 */
public class Oficina
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    public final static double AREA_MIN_EMPLEADO = 8.0; 
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Empresa que ocupa la oficina.
     */
    private Empresa empresa;

    /**
     * Tamaño de la oficina.
     */
    private double tamano;

    /**
     * Indica si la oficina está libre u ocupada.
     */
    private boolean libre;

    /**
     * Número de la oficina.
     */
    private int numero;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una oficina con el tamaño de la oficina.<br>
     * <b>post: </b> Los atributos: pTamano y pNumero quedaron inicializados con los valores que llegaron por parámetro, <br>
     * la empresa quedó inicializada en null y la oficina quedó con estado libre.<br>
     * @param pTamano Tamaño de la oficina. pTamano > 0.
     * @param pNumero número de la oficina. pNumero > 0. <br>         
     */
    public Oficina( double pTamano, int pNumero )
    {
        tamano = pTamano;
        libre = true;
        numero = pNumero;
        empresa = null;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la empresa que ocupa la oficina.
     * @return Empresa que ocupa la oficina. Puede ser null.
     */
    public Empresa darEmpresa( )
    {
        return empresa;
    }

    /**
     * Retorna el tamaño de la oficina.
     * @return Tamaño de la oficina.
     */
    public double darTamano( )
    {
        return tamano;
    }

    /**
     * Retorna el número de la oficina.
     * @return Número de la oficina.
     */
    public int darNumero( )
    {
        return numero;
    }

    /**
     * Indica si la oficina está ocupada.
     * @return True si la oficina está ocupada, false de lo contrario.
     */
    public boolean estaOcupada( )
    {
        return !libre;
    }

    /**
     * Indica si la oficina está ocupada por la empresa con el nombre dado.
     * @param pNombreEmpresa Nombre de la otra empresa buscada. pNombreEmpresa != null, pNombreEmpresa != "".
     * @return True si está ocupada por la empresa, false de lo contrario.
     */
    public boolean estaOcupadaPor( String pNombreEmpresa )
    {
        boolean iguales = false;
        if( empresa != null )
        {
            iguales = empresa.darNombre( ).equals( pNombreEmpresa );
        }
    
        return iguales;
    }

    /**
     * Asigna la oficina a una empresa con los datos dados por parámetro. <br>
     * <b>post</b>: Se creó y se asignó la empresa con la información dada y se cambió el estado de la oficina para que no esté libre.
     * @param pNombreEmpresa Nombre de al empresa que va a ocupar la oficina. pNombreEmpresa != null && pNombreEmpresa != "".<br>
     * @param pNITEmpresa NIT de la empresa. pNIT >= 0.
     * @throws Exception Si la oficina está ocupada.
     */
    public void ocuparOficina( String pNombreEmpresa, int pNITEmpresa ) throws Exception
    {
        //TODO Parte3 PuntoA: Completar el método según la documentación dada.
        if(estaOcupada())
        {
            throw new Exception("La oficina se encuentra ocupada");
        }
        else
        {
            empresa = new Empresa( pNombreEmpresa, pNITEmpresa);
            libre = false;
        }      
    }
    
    /**
     * Desocupa la oficina. <br>
     * <b>post:</b> Empresa es igual a null y se cambió el estado de la oficina para que esté libre.
     * @throws Exception - Si la oficina esta libre.
     *                   - Si la empresa tiene empleados adentro del parque empresarial.
     */
    public void desocuparOficina( ) throws Exception
    {
        //TODO Parte3 PuntoB: Completar el método según la documentación dada.
        if(!estaOcupada())
        {
            throw new Exception("La oficina esta libre");
        }
        for(Empleado empleado: darEmpresa( ).darEmpleados( ))
        {
            if(empleado.estaAdentro( ))
            {
                throw new Exception("La empresa tiene empleados adentro del parque empresarial");
            }
        }
        empresa = null;
        libre = true;
    }
    
    /**
     * Indica si un empleado trabaja en la empresa que ocupa la oficina.
     * @param pCedula Cédula del empleado que se está buscando. pCedula != null && pCedula != "".
     * @return True si en la empresa que ocupa la oficina trabaja un empleado con la cédula dada, false en caso contrario.
     */
    public boolean trabajaEnEmpresa(String pCedula)
    {
        boolean respuesta = false;
        for(int i=0;estaOcupada( ) && i<empresa.darEmpleados( ).size( ) && !respuesta; i++)
        {
            respuesta = empresa.darEmpleados( ).get( i ).darCedula( ).equals( pCedula );
        }
        return respuesta;
    }


    /**
     * Agrega un empleado a la empresa que ocupa la oficina.
     * <b>pre:</b>La oficina está ocupada por una empresa.
     * <b>post:</b> Se agregó un nuevo empleado a la empresa que ocupa la oficina. 
     * @param pNombre El nombre del empleado. pNombre != "".
     * @param pCedula La cedula del empleado. pCedula != "".
     * @return El Empleado que se agregó a la empresa.
     * @throws Exception - Si la oficina no tiene espacio suficiente para agregar al empleado. Es decir, en caso de agregar un nuevo empleado no cumpliría con la restricción de área mínima por empleado.
     *                   - Si ya existe un empleado en la empresa con la cedula dada por parámetro.
     */
    //TODO Parte3 PuntoC: Declarar e implementar el método agregarEmpleado segun la documentación dada y el modelo del mundo.
    public void agregarEmpleado(String pNombre, String pCedula) throws Exception 
    {
        if(darTamano()<AREA_MIN_EMPLEADO)
        {
            throw new Exception("La oficina no tiene espacio suficiente para agregar al empleado");
        }
        else
        {
            empresa.agregarEmpleado( pNombre, pCedula );
            tamano -= AREA_MIN_EMPLEADO;
        } 
    }
    
    /**
     * Elimina el empleado con cédula ingresada por parámetro de la empresa que ocupa la oficina.
     * @param pCedula Cédula del empleado. pCedula != "" && pCedula != null.
     * @throws Exception - Si en la empresa que ocupa la oficina no existe un empleado con la cédula dada.
     *                   - Si el empleado que se quiere eliminar está adentro del edificio.
     */
    public void eliminarEmpleado(String pCedula) throws Exception 
    {
        empresa.eliminarEmpleado( pCedula );
    }
    
    /**
     * Método que devuelve la la información de la oficina.<br>
     * @return Cadena con el siguiente formato: <número oficina> - <nombre empresa> - Empleados: <número empleados>.
     */
    public String toString( )
    {
        return darNumero( ) + " - " + darEmpresa( ).darNombre( ) + " - Empleados:" + darEmpresa( ).darNumeroEmpleados( );
    }
}
