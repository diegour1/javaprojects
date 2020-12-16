package uniandes.cupi2.parqueEmpresarial.mundo;

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
    
    private int numeroEmpleados;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea una empresa con su nombre, NIT y número de empleados. <br>
     * <b>post: </b> Los atributos: pNombre, pNIT y pNumeroEmpleados quedaron
     * inicializados con los valores que llegaron por parámetro.<br>
     * @param pNombre Nombre de la empresa. pNombre != null y pNombre != "".
     * @param pNIT NIT de la empresa. pNIT >=0 .
     * @param pNumeroEmpleados Número de empleados de la empresa. pNumeroEmpleados
     * >=0.
     */
    
    public Empresa(String pNombre, int pNIT, int pNumeroEmpleados)
    {
        nombre = pNombre;
        nit = pNIT;
        numeroEmpleados = pNumeroEmpleados;
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
     * Retorna el numero de empleados de la empresa.
     */
    
    public int darNumeroEmpleados()
    {
        return numeroEmpleados;
    }
    
}
