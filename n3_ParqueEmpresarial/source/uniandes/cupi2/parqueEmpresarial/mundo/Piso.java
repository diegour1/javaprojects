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
 * Clase que representa un piso del edificio.
 */
public class Piso
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Cantidad m�xima de oficinas en el piso.
     */
    // TODO Parte2 PuntoA: Agregue la constante CANTIDAD_MAXIMA_OFICINAS que determina el n�mero m�ximo de oficinas en el piso. En el modelo del mundo (ModeloConceptual.jpg)
    // se encuentra el tipo y valor exacto de la constante.
    
    public static final int CANTIDAD_MAXIMA_OFICINAS = 15;

    /**
     * �rea total del piso.
     */
    public static final double AREA_PISO = 1000.00;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Oficinas del piso.
     */
    // TODO Parte2 PuntoB: Declare la asociaci�n oficinas como una contenedora de tama�o fijo.
    
    private Oficina[] oficinas;

    /**
     * Cantidad de oficinas del piso.
     */
    private int cantidadOficinas;

    /**
     * N�mero del piso.
     */
    private int numero;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un piso con sus respectivas oficinas y se asigna el n�mero del piso al cual pertenece.<br>
     * <b>post: </b> Los atributos: pCantidadOficinas y pNumero quedaron inicializados con los valores que llegaron por par�metro.<br>
     * El arreglo de oficinas est� inicializado y todas las oficinas est�n creadas<br>
     * Cada oficina se cre� de la siguiente manera: <br>
     * - El tama�o de la oficina es AREA_PISO / cantidadOficinas. <br>
     * - El n�mero de la oficina est� compuesto por <numero Piso> * 100 + 1 + <posici�n en el arreglo>.
     * @param pCantidadOficinas Cantidad de oficinas del piso. pCantidadOficinas > 0 && pCantidadOficinas <= CANTIDAD_MAXIMA_OFICINAS.<br>
     * @param pNumero N�mero del piso. pNumero > 0 <br>
     */
    public Piso( int pCantidadOficinas, int pNumero )
    {
        // TODO Parte2 PuntoC: Complete el m�todo constructor de la clase seg�n la documentaci�n del m�todo.
        
        cantidadOficinas = pCantidadOficinas;
        numero = pNumero;
        oficinas = new Oficina[pCantidadOficinas];
        
        for(int i=0; i < pCantidadOficinas; i++)
        {
            oficinas[i] = new Oficina(AREA_PISO/pCantidadOficinas, pNumero*100 + (i+1));
        }
        
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de oficinas que tiene el piso.
     * @return Cantidad de oficinas del piso.
     */
    public int darCantidadOficinas( )
    {
        // TODO Parte2 PuntoD: Complete el m�todo darCantidadOficinas seg�n la documentaci�n del m�todo.
        
        return cantidadOficinas;
    }

    /**
     * Retorna el n�mero del piso.
     * @return N�mero del piso.
     */
    public int darNumero( )
    {
        // TODO Parte2 PuntoE: Complete el m�todo darNumero seg�n la documentaci�n del m�todo.
    
        return numero;
    }

    /**
     * Retorna la lista de oficinas. <br>
     * <b>pre:<b/> La lista de oficinas est� inicializada y todas las oficinas est�n creadas.
     * @return Oficinas del piso.
     */
    public Oficina[] darOficinas( )
    {
        // TODO Parte2 PuntoF: Complete el m�todo darOficinas seg�n la documentaci�n del m�todo.
        
        return oficinas;
    }
    
    /**
     * Asigna la primera oficina desocupada a una empresa usando los datos dados por par�metro. <br>
     * <b>pre</b>: La lista de oficinas est� inicializada y todas las oficinas est�n creadas. <br>
     * La empresa no tiene otra oficina ocupada. <br>
     * <b>post</b>: La oficina ha sido ocupada. <br>
     * @param pNombreEmpresa Nombre de la empresa que ocupar� la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @param pNITEmpresa NIT de la empresa. pNIT >= 0.
     * @param pNumeroEmpleadosEmpresa N�mero de empleados de la empresa. pNumeroEmpleados >= 0.
     * @return True si se ocup� la oficina, false si todas las oficinas ya estaban ocupadas.
     */
    public boolean ocuparOficina( String pNombreEmpresa, int pNITEmpresa, int pNumeroEmpleadosEmpresa )
    {
        // TODO Parte2 PuntoG: Complete el m�todo ocuparOficina seg�n la documentaci�n del m�todo.
        
        boolean ocupada = false;
        for(Oficina oficina:darOficinas( ))
        {
            if(!oficina.estaOcupada( ))
            {
                oficina.ocuparOficina( pNombreEmpresa, pNITEmpresa, pNumeroEmpleadosEmpresa );
                ocupada = true;
                break;
            }
        }
        
        return ocupada;
        
    }



    /**
     * Indica si la empresa con nombre dado ocupa una oficina en el piso.<br>
     * <b>pre</b>: La lista de oficinas est� inicializada. <br>
     * @param pNombreEmpresa Nombre de la empresa buscada. pNombreEmpresa != null & pNombreEmpresa != "".
     * @return True si la empresa existe en el piso, false de lo contrario.
     */
    public boolean existeEmpresa( String pNombreEmpresa )
    {
        // TODO Parte2 PuntoH: Complete el m�todo existeEmpresa seg�n la documentaci�n del m�todo.
        
        boolean existe = false;
        for(Oficina oficina:darOficinas( ))
        {
            if(oficina.darEmpresa( ) != null && oficina.darEmpresa( ).darNombre( ).equals( pNombreEmpresa ) )
            {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    /**
     * Retorna la cantidad de oficinas ocupadas en el piso.<br>
     * <b>pre:<b/> La lista de oficinas est� inicializada y todas las oficinas est�n creadas.<br>
     * @return Cantidad de oficinas ocupadas en el piso.
     */
    public int darCantidadOficinasOcupadas( )
    {
        // TODO Parte2 PuntoI: Complete el m�todo darCantidadOficinasOcupadas seg�n la documentaci�n del m�todo.
        int cantidadOficinasOcupadas = 0;
        for(Oficina oficina:darOficinas( ))
        {
            if(oficina.estaOcupada( ) )
            {
                cantidadOficinasOcupadas++;
            }
        }
        return cantidadOficinasOcupadas;
    }



    /**
     * Desocupa la oficina que ocupa la empresa con el nombre dado.<br>
     * <b>pre</b>: La lista de oficinas est� inicializada. <br>
     * La empresa tiene una oficina ocupada en el piso.<br>
     * <b>post</b>: La oficina ha sido desocupada.
     * @param pNombreEmpresa Nombre de la empresa que desocupar� la oficina. pNombreEmpresa != null, pNombreEmpresa != "".
     */
    public void desocuparOficina( String pNombreEmpresa )
    {
        // TODO Parte2 PuntoJ: Complete el m�todo desocuparOficina seg�n la documentaci�n del m�todo.
        for(Oficina oficina:darOficinas( ))
        {
            if(oficina.darEmpresa() != null && oficina.darEmpresa( ).darNombre( ).equals( pNombreEmpresa ) )
            {
                oficina.desocuparOficina( );
            }
        }
    }

}
