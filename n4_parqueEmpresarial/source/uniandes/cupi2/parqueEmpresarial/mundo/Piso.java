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
 * Clase que representa un piso del edificio.
 */
public class Piso
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Cantidad máxima de oficinas en el piso.
     */
    // TODO Parte2 PuntoA: Agregue la constante CANTIDAD_MAXIMA_OFICINAS que determina el número máximo de oficinas en el piso. En el modelo del mundo (ModeloConceptual.jpg)
    // se encuentra el tipo y valor exacto de la constante.
    
    public static final int CANTIDAD_MAXIMA_OFICINAS = 15;

    /**
     * Área total del piso.
     */
    public static final double AREA_PISO = 1000.00;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Oficinas del piso.
     */
    // TODO Parte2 PuntoB: Declare la asociación oficinas como una contenedora de tamaño fijo.
    
    private Oficina[] oficinas;

    /**
     * Cantidad de oficinas del piso.
     */
    private int cantidadOficinas;

    /**
     * Número del piso.
     */
    private int numero;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un piso con sus respectivas oficinas y se asigna el número del piso al cual pertenece.<br>
     * <b>post: </b> Los atributos: pCantidadOficinas y pNumero quedaron inicializados con los valores que llegaron por parámetro.<br>
     * El arreglo de oficinas está inicializado y todas las oficinas están creadas<br>
     * Cada oficina se creó de la siguiente manera: <br>
     * - El tamaño de la oficina es AREA_PISO / cantidadOficinas. <br>
     * - El número de la oficina está compuesto por <numero Piso> * 100 + 1 + <posición en el arreglo>.
     * @param pCantidadOficinas Cantidad de oficinas del piso. pCantidadOficinas > 0 && pCantidadOficinas <= CANTIDAD_MAXIMA_OFICINAS.<br>
     * @param pNumero Número del piso. pNumero > 0 <br>
     */
    public Piso( int pCantidadOficinas, int pNumero )
    {
        // TODO Parte2 PuntoC: Complete el método constructor de la clase según la documentación del método.
        
        cantidadOficinas = pCantidadOficinas;
        numero = pNumero;
        oficinas = new Oficina[pCantidadOficinas];
        
        for(int i=0; i < pCantidadOficinas; i++)
        {
            oficinas[i] = new Oficina(AREA_PISO/pCantidadOficinas, pNumero*100 + (i+1));
        }
        
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de oficinas que tiene el piso.
     * @return Cantidad de oficinas del piso.
     */
    public int darCantidadOficinas( )
    {
        // TODO Parte2 PuntoD: Complete el método darCantidadOficinas según la documentación del método.
        
        return cantidadOficinas;
    }

    /**
     * Retorna el número del piso.
     * @return Número del piso.
     */
    public int darNumero( )
    {
        // TODO Parte2 PuntoE: Complete el método darNumero según la documentación del método.
    
        return numero;
    }

    /**
     * Retorna la lista de oficinas. <br>
     * <b>pre:<b/> La lista de oficinas está inicializada y todas las oficinas están creadas.
     * @return Oficinas del piso.
     */
    public Oficina[] darOficinas( )
    {
        // TODO Parte2 PuntoF: Complete el método darOficinas según la documentación del método.
        
        return oficinas;
    }
   
    /**
     * Asigna la primera oficina desocupada a una empresa usando los datos dados por parámetro. <br>
     * <b>pre</b>: La lista de oficinas está inicializada y todas las oficinas están creadas. <br>
     * La empresa no tiene otra oficina ocupada. <br>
     * <b>post</b>: La oficina ha sido ocupada. <br>
     * @param pNombreEmpresa Nombre de la empresa que ocupará la oficina. pNombreEmpresa != null && pNombreEmpresa != "".
     * @param pNITEmpresa NIT de la empresa. pNIT >= 0.
     * @throws Exception Si todas las oficinas ya estaban ocupadas.
     */
    public void ocuparOficina( String pNombreEmpresa, int pNITEmpresa ) throws Exception
    {
        //TODO Parte4 PuntoA: Complete el método ocuparOficina según la documentación dada.
        boolean ocupada = false;
        for(Oficina oficina:darOficinas( ))
        {
            if(!oficina.estaOcupada( ))
            {
                oficina.ocuparOficina( pNombreEmpresa, pNITEmpresa);
                ocupada = true;
                break;
            }
        }
        if(ocupada == false)
        {
            throw new Exception("Todas las oficinas ya estaban ocupadas");
        }
    }



    /**
     * Indica si la empresa con nombre dado ocupa una oficina en el piso.<br>
     * <b>pre</b>: La lista de oficinas está inicializada. <br>
     * @param pNombreEmpresa Nombre de la empresa buscada. pNombreEmpresa != null & pNombreEmpresa != "".
     * @return True si la empresa existe en el piso, false de lo contrario.
     */
    public boolean existeEmpresa( String pNombreEmpresa )
    {
        // TODO Parte2 PuntoH: Complete el método existeEmpresa según la documentación del método.
        
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
     * <b>pre:<b/> La lista de oficinas está inicializada y todas las oficinas están creadas.<br>
     * @return Cantidad de oficinas ocupadas en el piso.
     */
    public int darCantidadOficinasOcupadas( )
    {
        // TODO Parte2 PuntoI: Complete el método darCantidadOficinasOcupadas según la documentación del método.
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
     * <b>pre</b>: - La lista de oficinas está inicializada. <br>
     *             - La empresa tiene una oficina ocupada en el piso.<br>
     * <b>post</b>: La oficina ha sido desocupada.
     * @param pNombreEmpresa Nombre de la empresa que desocupará la oficina. pNombreEmpresa != null, pNombreEmpresa != "".
     * @throws Exception - Si la empresa tiene empleados adentro del parque empresarial.
     */
    public void desocuparOficina( String pNombreEmpresa ) throws Exception
    {
      //TODO Parte4 PuntoB: Complete el método desocuparOficina según la documentación dada.
        for(Oficina oficina:darOficinas( ))
        {
            if(oficina.darEmpresa() != null && oficina.darEmpresa( ).darNombre( ).equals( pNombreEmpresa ) )
            {
                oficina.desocuparOficina( );
            }
        }
    }
    
    
    /**
     * Busca la oficina en la que trabaja el empleado con la cédula dada por parámetro.
     * @param pCedula Cédula del empleado. pCedula != "" && pCedula != null.
     * @return Oficina en la que trabaja el empleado o null si el empleado no trabaja en el piso. 
     */
    public Oficina buscarOficinaEmpleado(String pCedula){
        Oficina respuesta = null;
        for( int i = 0; i < oficinas.length && respuesta == null; i++ )
        {
            Oficina oficina = oficinas[ i ];
            
            if(oficina.trabajaEnEmpresa( pCedula ))
            {
                respuesta = oficina;
            }
        }
        return respuesta;
    }
    
    // TODO Parte4 PuntoC: Crear el contrato del método buscarOficinaEmpresa.
    
    /**
     * Busca la oficina que ocupa la empresa con el nombre de la empresa dado por parametro.
     * @param pNombreEmpresa Nombre de la empresa. pNombreEmpresa != "" && pNombreEmpresa != null.
     * @return Oficina que se encuentra ocupada por la empresa o null si la oficina se encuentra desocupada. 
     */
    
    public Oficina buscarOficinaEmpresa( String pNombreEmpresa )
    {
        Oficina respuesta = null;
        for(int j=0; j<oficinas.length && respuesta == null; j++)
        {
            Oficina oficina = oficinas[ j ];
            if(oficina.estaOcupadaPor( pNombreEmpresa ))
            {
                respuesta = oficina;
            }
        }
        return respuesta;
    }

}
