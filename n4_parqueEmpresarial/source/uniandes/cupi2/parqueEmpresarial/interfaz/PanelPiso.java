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

package uniandes.cupi2.parqueEmpresarial.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import uniandes.cupi2.parqueEmpresarial.mundo.Piso;

/**
 * Panel que representa un piso.
 */
public class PanelPiso extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Método constructor con parámetros.
     * @param pPiso Piso que va a ser representado pPiso!=null.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz. pPrincipal !=null.
     */
    public PanelPiso( Piso pPiso, InterfazParqueEmpresarial pPrincipal  )
    {
        int numOficinas = pPiso.darCantidadOficinas( );

        GridBagLayout gbPiso = new GridBagLayout( );
        GridBagConstraints gbcPiso = new GridBagConstraints( );
        setLayout( gbPiso );
        setBackground( new Color( 180, 175, 145 ) );
        setPreferredSize( new Dimension( 330, 40 ) );

        // Se agregan las oficinas al piso
        gbcPiso.fill = GridBagConstraints.HORIZONTAL;
        gbcPiso.weightx = 1;
        gbcPiso.weighty = 1;
        gbcPiso.gridy = 0;
        for( int i = 0; i < numOficinas; i++ )
        {
            gbcPiso.gridx = i;
            PanelOficina panelOficina =  new PanelOficina( 280 / numOficinas, pPiso.darOficinas( )[ i ], pPrincipal );
            add(panelOficina , gbcPiso );
        }
    }
}
