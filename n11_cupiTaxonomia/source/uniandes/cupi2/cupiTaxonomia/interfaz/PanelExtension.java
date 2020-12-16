/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiTaxonomia
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTaxonomia.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel para el manejo de extensiones.
 */
@SuppressWarnings({ "serial" })
public class PanelExtension extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para agregar un taxón.
     */
    private static final String AGREGAR_TAXON = "Agregar taxón";

    /**
     * Constante que representa el comando para agregar un ser vivo.
     */
    private final static String AGREGAR_SER = "Agregar ser vivo";

    /**
     * Constante que representa el comando para la Opción 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Constante que representa el comando para la Opción 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiTaxonomia principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para agregar un taxón.
     */
    private JButton btnAgregarTaxon;

    /**
     * Botón para agregar un ser vivo.
     */
    private JButton btnAgregarServivo;

    /**
     * Campo de texto con el número de taxones.
     */
    private JTextField txtTaxones;

    /**
     * Campo de texto con el número de seres vivos.
     */
    private JTextField txtSeresVivos;

    /**
     * Botón para la Opción 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón para la Opción 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel de extensión.
     * <b> post: </b> Se crea el panel con todos sus elementos gráficos.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelExtension( InterfazCupiTaxonomia pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 2, 4 ) );

        JLabel lbl1 = new JLabel( "Número de taxones: " );
        lbl1.setHorizontalAlignment( JLabel.CENTER );
        add( lbl1 );

        txtTaxones = new JTextField( "0" );
        txtTaxones.setEditable( false );
        txtTaxones.setHorizontalAlignment( JTextField.CENTER );
        add( txtTaxones );

        JLabel lbl2 = new JLabel( "Número de seres vivos: " );
        lbl2.setHorizontalAlignment( JLabel.CENTER );
        add( lbl2 );

        txtSeresVivos = new JTextField( "0" );
        txtSeresVivos.setEditable( false );
        txtSeresVivos.setHorizontalAlignment( JTextField.CENTER );
        add( txtSeresVivos );

        // Botón agregar taxón
        btnAgregarTaxon = new JButton( AGREGAR_TAXON );
        btnAgregarTaxon.setActionCommand( AGREGAR_TAXON );
        btnAgregarTaxon.addActionListener( this );
        add( btnAgregarTaxon );

        // Botón agregar ser vivo
        btnAgregarServivo = new JButton( AGREGAR_SER );
        btnAgregarServivo.setActionCommand( AGREGAR_SER );
        btnAgregarServivo.addActionListener( this );
        add( btnAgregarServivo );

        // Botón opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Botón opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza los campos de texto con la información dada del árbol taxonómico.
     * @param pNumTaxones Número de taxones del árbol. pNumTaxones >= 0.
     * @param pNumSeres Número de seres vivos del árbol. pNumSeres >= 0.
     */
    public void actualizar( int pNumTaxones, int pNumSeres )
    {
        txtTaxones.setText( "" + pNumTaxones );
        txtSeresVivos.setText( "" + pNumSeres );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( comando.equals( AGREGAR_TAXON ) )
        {
            String[] tipos = new String[]{ "1. Dominio", "2. Reino", "3. Filo", "4. Clase", "5. Orden", "6. Familia", "7. Género", "8. Especie" };
            String tipo = ( String )JOptionPane.showInputDialog( principal, "Tipo del taxón:", "Agregar taxón", JOptionPane.INFORMATION_MESSAGE, null, tipos, "Dominio" );

            if( tipo != null )
            {
                DialogoAgregarTaxon dialogo = new DialogoAgregarTaxon( principal, tipo );
                dialogo.setVisible( true );
            }
        }
        else if( comando.equals( AGREGAR_SER ) )
        {
            DialogoAgregarSerVivo dialogo = new DialogoAgregarSerVivo( principal );
            dialogo.setVisible( true );
        }
    }

}
