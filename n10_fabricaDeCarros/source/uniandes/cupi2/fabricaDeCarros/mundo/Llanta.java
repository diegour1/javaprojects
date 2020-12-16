package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;

/**
 * Clase abstracta que representa la llanta 
 */
public abstract class Llanta extends Parte
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el diametro de la llanta.
     */ 
    public final static int DIAMETRO = 80;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea la llanta con los valores especificados. <br>
     * <b> post: </b> Se inicializó la llanta con las coordenadas 'x' y 'y', y el color dados por parámetro.
     * @param pX Coordenada x de la figura. pX >= 0.
     * @param pY Coordenada y de la figura. pY >= 0.
     * @param pColor Color del esténcil. pColor != null.
     */
    
    public Llanta(int pX, int pY, Color pColor)
    {
        super(pX, pY, DIAMETRO, DIAMETRO, pColor);
    }
    
    /**
     * Crea la llanta a partir de los datos contenidos en el archivo. <br>
     * <b> post: </b> Se inicializó la llanta con las coordenadas 'x' y 'y', y el color dados por parámetro.
     * @param pBr Stream que sirve para leer el archivo. pBr !=null.
     * @throws Exception Si hay problemas leyendo el archivo.
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public Llanta( BufferedReader pBr) throws Exception
    {
        super( pBr, DIAMETRO, DIAMETRO );
    }
    
    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Dibuja la llanta  .<br>
     * <b> post: </b> La llanta fue pintada.
     * @param pG Superficie donde se debe pintar. pG!= null.
     */
    public void pintar( Graphics2D pG )
    {
        pG.setColor( Color.black );
        pG.fillOval(x, y, DIAMETRO, DIAMETRO);
        pG.setColor( Color.DARK_GRAY );
        pG.fillOval(x + DIAMETRO/5, y + DIAMETRO/5, 3*DIAMETRO/5, 3*DIAMETRO/5);
        pintarRines( pG );
    }
    
    /**
     * Dibuja los rines de la llanta. <br>
     * <b>post:</b> Se dibujó los rines de la llanta en el lienzo.
     * @param pG Superficie donde se debe pintar. pG!=null.
     */
    public abstract void pintarRines( Graphics2D pG );
}
