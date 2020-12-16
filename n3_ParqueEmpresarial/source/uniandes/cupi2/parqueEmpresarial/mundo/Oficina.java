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
     * @param pNITEmpresa NIT de la empresa. pNIT >= 0.<br>
     * @param pNumeroEmpleadosEmpresa Número de empleados de la empresa. pNumeroEmpleados >= 0.<br> 
     */
    public void ocuparOficina( String pNombreEmpresa, int pNITEmpresa, int pNumeroEmpleadosEmpresa )
    {
        empresa = new Empresa( pNombreEmpresa, pNITEmpresa, pNumeroEmpleadosEmpresa );
        libre = false;
    }

    /**
     * Desocupa la oficina. <br>
     * <b>post:</b> Empresa es igual a null y se cambió el estado de la oficina para que esté libre.
     */
    public void desocuparOficina( )
    {
        empresa = null;
        libre = true;
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
