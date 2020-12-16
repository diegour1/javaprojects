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

package uniandes.cupi2.parqueEmpresarial.mundo;

import java.util.Date;

/**
 * Clase que representa un empleado.
 */
public class Empleado
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del empleado
     */
    private String nombre;

    /**
     * Cedula del empleado.
     */
    private String cedula;

    /**
     * Registro de entradas y salidas del empleado.
     */
    private String registro;

    /**
     * Atributo que indica si el empleado se encuentra adentro del parque empresarial.
     */
    private boolean adentro;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un empleado.<br>
     * <b>post: </b> Los atributos: nombre y cedula quedaron inicializados con los valores que llegaron por parámetro, <br>
     * El registro se inicializo como una cadena vacia y el empleado incio afuera del parque empresarial.<br>
     * @param pNombre Nombre del empleado. pNombre != ""
     * @param pCedula Cedula del empleado. pCedula != "" <br>         
     */
    public Empleado( String pNombre, String pCedula )
    {
        //TODO Parte1 PuntoA: Completar el método según la documentación dada.
        nombre = pNombre;
        cedula = pCedula;
        registro = "";
        adentro = false;
    }

    //TODO Parte1 PuntoB: Crear el contrato del método
    /**
     * Retorna el nombre del empleado
     * @return Nombre del empleado
     */
    public String darNombre( )
    {
        return nombre;
    }

    //TODO Parte1 PuntoC: Crear el contrato del método
    /**
     * Retorna la cedula del empleado. <br>
     * @return Cadena con la cedula del empleado
     */
    public String darCedula( )
    {
        return cedula;
    }

    //TODO Parte1 PuntoD: Crear el contrato del método
    
    /**
     * Retorna si el empleado se encuentra dentro del parque empresarial. <br>
     * @return True si el empleado se encuentra dentro del parque empresarial, false de lo contrario
     */
    
    public boolean estaAdentro( )
    {
        return adentro;
    }

    /**
     * Retorna el registro de entradas en el parque empresarial del empleado. <br>
     * @return Cadena con el registro de entradas del empleado
     */
    
    //TODO Parte1 PuntoE: Crear el contrato del método
    public String darRegistro( )
    {
        return registro;
    }
    
    /**
     * Registra la hora de entrada de un empleado en el parque empresarial. <br>
     * <b>post</b>: Se registro la entrada del empleado en el parque empresarial, se cambia el estado adentro a true.
     * @throws Exception Si el empleado ya se encuentra dentro del edificio.
     */

    //TODO Parte1 PuntoF: Crear el contrato del método
    public void registrarIngreso() throws Exception{
        if(adentro){
            registro+= "["+new Date( )+"] INGRESO FALLIDO.\n";
            throw new Exception("El empleado ya se encuentra adentro del parque empresarial.");
        }
        adentro = true;
        registro+= "["+new Date( )+"] INGRESO EXITOSO.\n";
    }

    /**
     * Registra la hora de salida de un empleado en el parque empresarial. <br>
     * <b>post</b>: Se registro la hora de salida del empleado en el parque empresarial, se cambia el estado adentro a false.
     * @throws Exception Si el empleado ya se encuentra fuera del edificio.
     */
    
    //TODO Parte1 PuntoG: Crear el contrato del método
    public void registrarSalida() throws Exception{
        if(!adentro){
            registro+= "["+new Date( )+"] SALIDA FALLIDA.\n";
            throw new Exception("El empleado no se encuentra adentro del parque empresarial.");
        }
        adentro = false;
        registro+= "["+new Date( )+"] SALIDA EXITOSA.\n";
    }

    /**
     * Método que devuelve la la información del empleado.<br>
     * @return Cadena con el siguiente formato: nombre ( CC. número cedula ). Precedido de * si el empleado se encuentra adentro del edificio.
     */
    @Override
    public String toString( )
    {
        return (adentro?"*":"")+nombre+" ( CC. "+cedula+")";
    }


}
