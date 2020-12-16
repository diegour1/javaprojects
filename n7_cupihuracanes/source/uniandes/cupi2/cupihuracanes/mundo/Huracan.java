/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiHuracanes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupihuracanes.mundo;

/**
 * Clase que representa un huracán. <br>
 * TODO Parte 1 punto A: Definir y documentar el invariante de la clase.
 */
public class Huracan
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Nombre del huracán.
     */
    private String nombre;

    /**
     * Categoría del huracán según el sistema Saffir-Simpson.
     */
    private int categoria;

    /**
     * Velocidad del viento en km/h.
     */
    private int velocidad;

    /**
     * Costo estimado en daños expresado en millones de dólares.
     */
    private double costoEstimadoDanios;

    /**
     * Ruta donde se encuentra la imagen del huracán.
     */
    private String imagen;

    // --------------------------------------------------------
    // Constructores
    // --------------------------------------------------------

    /**
     * Construye un nuevo huracán con los valores dados por parámetro. <br>
     * <b>post: </b> Se construyó un huracán con los parámetros indicados.
     * @param pNombre Nombre del huracán. pNombre != null && pNombre != "".
     * @param pCategoria Categoría del huracán. 1 <= pCategoria <= 5.
     * @param pVelocidad Velocidad del viento. 0 <= pVelocidad.
     * @param pCostoEstimadoDanios Costo estimado de daños. 0 <= pCostoEstimadoDanios.
     * @param pImagen Ruta de la imagen del huracán. pImagen != null && pImagen != "".
     */
    public Huracan( String pNombre, int pCategoria, int pVelocidad, double pCostoEstimadoDanios, String pImagen )
    {
        nombre = pNombre;
        categoria = pCategoria;
        velocidad = pVelocidad;
        costoEstimadoDanios = pCostoEstimadoDanios;
        imagen = pImagen;
    }

    // --------------------------------------------------------
    // Métodos
    // --------------------------------------------------------

    /**
     * Retorna el nombre del huracán.
     * @return Nombre del huracán.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la categoría del huracán.
     * @return Categoría del huracán.
     */
    public int darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna la velocidad del huracán.
     * @return Velocidad del huracán.
     */
    public int darVelocidad( )
    {
        return velocidad;
    }

    /**
     * Retorna el costo estimado en daños del huracán.
     * @return Costo estimado en daños del huracán.
     */
    public double darCostoEstimadoDanios( )
    {
        return costoEstimadoDanios;
    }

    /**
     * Retorna la ruta de la imagen del huracán.
     * @return Imagen del huracán.
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Compara dos huracanes según el nombre. <br>
     * @param pNombre Huracán contra el cual se está comparando. pHuracan != null. <br>
     * @return Retorna 0 si los huracanes tienen el mismo nombre. <br>
     *         Retorna número entero menor a 0 si el huracán pHuracan tiene un valor MAYOR para el nombre. <br>
     *         Retorna número entero mayor a 0 si el huracán pHuracan tiene un valor MENOR para el nombre. <br>
     */
    public int compararPorNombre( String pNombre )
    {
    	// TODO Parte 2 punto A: Completar según documentación.
    	return nombre.compareToIgnoreCase(pNombre);
    }

    /**
     * Compara dos huracanes según los daños materiales estimados. <br>
     * @param pHuracan Huracán contra el cual se está comparando. pHuracan != null. <br>
     * @return Retorna 0 si los huracanes tienen el mismo costo estimado en daños. <br>
     *         Retorna -1 si el huracán pHuracan tiene un valor MAYOR para el costo estimado en daños. <br>
     *         Retorna 1 si el huracán pHuracan tiene un valor MENOR para el costo estimado en daños. <br>
     */
    public int compararPorDanios( Huracan pHuracan )
    {
    	// TODO Parte 2 punto B: Completar según documentación.
    	if (costoEstimadoDanios == pHuracan.costoEstimadoDanios)
    		return 0;
    	else if (costoEstimadoDanios > pHuracan.costoEstimadoDanios)
    		 return 1;
    	else
    		return -1;
    }

    /**
     * Compara dos huracanes según la velocidad. <br>
     * @param pHuracan Huracán contra el cual se está comparando. pHuracan != null. <br>
     * @return Retorna 0 si los huracanes tienen la misma velocidad. <br>
     *         Retorna -1 si el huracán pHuracan tiene un valor MENOR para la velocidad. <br>
     *         Retorna 1 si el huracán pHuracan tiene un valor MAYOR para la velocidad. <br>
     */
    public int compararPorVelocidad( Huracan pHuracan )
    {
    	// TODO Parte 2 punto C: Completar según documentación.
    	if (velocidad == pHuracan.velocidad )
    		return 0;
    	else if (velocidad > pHuracan.velocidad )
    		return 1;
    	else 
    		return -1;
    }

    /**
     * Retorna una cadena con el nombre del huracán.
     * @return Retorna la representación del huracán en una cadena de caracteres.
     */
    public String toString( )
    {
    	// TODO Parte 3 punto A:  Completar según documentación.
    	return nombre;
    }

    // --------------------------------------------------------
    // Invariantes
    // --------------------------------------------------------

    // TODO Parte 1 punto B: Declarar, implementar y documentar el método verificarInvariante.
    // Si utiliza métodos auxiliares, declárelos e impleméntelos en esta sección.

}
