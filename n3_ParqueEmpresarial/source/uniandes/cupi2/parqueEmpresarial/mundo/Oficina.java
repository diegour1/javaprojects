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
     * Tama�o de la oficina.
     */
    private double tamano;

    /**
     * Indica si la oficina est� libre u ocupada.
     */
    private boolean libre;

    /**
     * N�mero de la oficina.
     */
    private int numero;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una oficina con el tama�o de la oficina.<br>
     * <b>post: </b> Los atributos: pTamano y pNumero quedaron inicializados con los valores que llegaron por par�metro, <br>
     * la empresa qued� inicializada en null y la oficina qued� con estado libre.<br>
     * @param pTamano Tama�o de la oficina. pTamano > 0.
     * @param pNumero n�mero de la oficina. pNumero > 0. <br>         
     */
    public Oficina( double pTamano, int pNumero )
    {
        tamano = pTamano;
        libre = true;
        numero = pNumero;
        empresa = null;
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * Retorna el tama�o de la oficina.
     * @return Tama�o de la oficina.
     */
    public double darTamano( )
    {
        return tamano;
    }

    /**
     * Retorna el n�mero de la oficina.
     * @return N�mero de la oficina.
     */
    public int darNumero( )
    {
        return numero;
    }

    /**
     * Indica si la oficina est� ocupada.
     * @return True si la oficina est� ocupada, false de lo contrario.
     */
    public boolean estaOcupada( )
    {
        return !libre;
    }

    /**
     * Indica si la oficina est� ocupada por la empresa con el nombre dado.
     * @param pNombreEmpresa Nombre de la otra empresa buscada. pNombreEmpresa != null, pNombreEmpresa != "".
     * @return True si est� ocupada por la empresa, false de lo contrario.
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
     * Asigna la oficina a una empresa con los datos dados por par�metro. <br>
     * <b>post</b>: Se cre� y se asign� la empresa con la informaci�n dada y se cambi� el estado de la oficina para que no est� libre.
     * @param pNombreEmpresa Nombre de al empresa que va a ocupar la oficina. pNombreEmpresa != null && pNombreEmpresa != "".<br>
     * @param pNITEmpresa NIT de la empresa. pNIT >= 0.<br>
     * @param pNumeroEmpleadosEmpresa N�mero de empleados de la empresa. pNumeroEmpleados >= 0.<br> 
     */
    public void ocuparOficina( String pNombreEmpresa, int pNITEmpresa, int pNumeroEmpleadosEmpresa )
    {
        empresa = new Empresa( pNombreEmpresa, pNITEmpresa, pNumeroEmpleadosEmpresa );
        libre = false;
    }

    /**
     * Desocupa la oficina. <br>
     * <b>post:</b> Empresa es igual a null y se cambi� el estado de la oficina para que est� libre.
     */
    public void desocuparOficina( )
    {
        empresa = null;
        libre = true;
    }

    /**
     * M�todo que devuelve la la informaci�n de la oficina.<br>
     * @return Cadena con el siguiente formato: <n�mero oficina> - <nombre empresa> - Empleados: <n�mero empleados>.
     */
    public String toString( )
    {
        return darNumero( ) + " - " + darEmpresa( ).darNombre( ) + " - Empleados:" + darEmpresa( ).darNumeroEmpleados( );
    }
}
