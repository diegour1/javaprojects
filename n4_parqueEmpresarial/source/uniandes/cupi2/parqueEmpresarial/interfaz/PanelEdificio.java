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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import uniandes.cupi2.parqueEmpresarial.mundo.Piso;

/**
 * Panel que representa la estructura del edificio.
 */
public class PanelEdificio extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazParqueEmpresarial principal;
    
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Panel donde se visualiza el edificio.
     */
    private JPanel panelCentral;

    /**
     * Scroll del panel central.
     */
    private JScrollPane scroll;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz. pPrincipal !=null.
     */
    public PanelEdificio(InterfazParqueEmpresarial pPrincipal)
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        // Creación de los paneles aquí
        panelCentral = new JPanel( );
        scroll = new JScrollPane( );
        scroll.setViewportView( panelCentral );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );

        add( scroll, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la visualización del panel.
     * @param pPisos Pisos del edificio. pPisos!=null.
     */
    public void actualizar( ArrayList<Piso> pPisos )
    {
        int numPisos = pPisos.size( );

        // Panel Central
        panelCentral.removeAll( );
        panelCentral.setLayout( new BorderLayout( ) );
        panelCentral.setBackground( new Color( 152, 204, 255 ) );

        // Panel Estructura que contiene toda la estructura del edificio
        JPanel panelEstructura = new JPanel( );
        GridBagLayout gbEstructura = new GridBagLayout( );
        GridBagConstraints gbcEstructura = new GridBagConstraints( );
        panelEstructura.setLayout( gbEstructura );
        panelEstructura.setBackground( new Color( 152, 204, 255 ) );

        // Panel edificio que contiene el edificio
        JPanel edificio = new JPanel( );
        GridBagLayout gbEdificio = new GridBagLayout( );
        GridBagConstraints gbcEdificio = new GridBagConstraints( );
        edificio.setLayout( gbEdificio );
        Border compuesto;
        Border bevelSuperio = BorderFactory.createRaisedBevelBorder( );
        Border bevelInferior = BorderFactory.createLoweredBevelBorder( );
        compuesto = BorderFactory.createCompoundBorder( bevelSuperio, bevelInferior );
        edificio.setBorder( compuesto );
        edificio.setBackground( new Color( 180, 175, 145 ) );

        // Panel pisosEdificio que contiene los pisos del edificio
        JPanel pisosEdificio = new JPanel( );
        GridBagLayout gbPisosEdificio = new GridBagLayout( );
        GridBagConstraints gbcPisosEdificio = new GridBagConstraints( );
        pisosEdificio.setLayout( gbPisosEdificio );
        pisosEdificio.setBackground( new Color( 180, 175, 145 ) );
        pisosEdificio.setPreferredSize( new Dimension( 350, numPisos * 40 ) );

        // Panel base que contiene la base del edificio
        JPanel base = new JPanel( );
        GridBagLayout gbBase = new GridBagLayout( );
        base.setLayout( gbBase );
        JLabel imagen = new JLabel( );
        imagen.setIcon( new ImageIcon( "data/imagenes/base.jpg" ) );
        base.setBorder( BorderFactory.createRaisedBevelBorder( ) );
        base.setPreferredSize( new Dimension( 450, 30 ) );
        base.add( imagen );

        // Construcción de los pisos
        gbcPisosEdificio.weightx = 1;
        gbcPisosEdificio.weighty = 1;
        gbcPisosEdificio.gridx = 0;

        for( int i = 0; i < numPisos; i++ )
        {
            gbcPisosEdificio.gridy = i;
            pisosEdificio.add( new PanelPiso( ( Piso )pPisos.get( numPisos - i - 1 ), principal ), gbcPisosEdificio );
        }

        // Agregamos los pisos al edificio
        gbcEdificio.gridx = 0;
        gbcEdificio.gridy = 1;
        gbEdificio.setConstraints( pisosEdificio, gbcEdificio );
        edificio.add( pisosEdificio );

        // Agregamos el edificio y la base al panel estructura
        gbcEstructura.gridy = 0;
        gbEstructura.setConstraints( edificio, gbcEstructura );
        panelEstructura.add( edificio );

        gbcEstructura.gridx = 0;
        gbcEstructura.gridy = 1;
        gbEstructura.setConstraints( base, gbcEstructura );
        panelEstructura.add( base );

        // Agregamos el panelEstructura al panel central
        panelCentral.add( panelEstructura, BorderLayout.SOUTH );

        validate( );
        repaint( );
    }
}
