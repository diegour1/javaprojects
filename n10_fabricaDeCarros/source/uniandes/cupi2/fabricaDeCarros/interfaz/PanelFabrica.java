/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: fabricaDeCarros
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.fabricaDeCarros.interfaz;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.fabricaDeCarros.mundo.IParte;

/**
 * Panel en el que se despliega el lienzo de dibujo.
 */
public class PanelFabrica extends JPanel implements MouseListener, MouseMotionListener
{
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazFabricaDeCarros principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel.<br>
     * <b> post: </b> Se inicializa el panel con la interfaz de fábrica de carros dada por parámetro.
     * @param pInterfazPrincipal Ventana principal de la aplicación. pInterfazPrincipal != null.
     */
    public PanelFabrica( InterfazFabricaDeCarros pInterfazPrincipal )
    {
        principal = pInterfazPrincipal;

        addMouseListener( this );
        addMouseMotionListener( this );

        setDoubleBuffered( true );
        setBorder( new TitledBorder( "" ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Este método se encarga de actualizar la visualización la fábrica.
     */
    public void actualizar( )
    {
        repaint( );
    }

    /**
     * Este es el método que se encarga de actualizar la visualización de la fábrica.
     * @param pG Superficie del panel. pG!=null.
     */
    public void update( Graphics2D pG )
    {
        pG.setStroke( new BasicStroke( 1 ) );
        pG.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        pG.setColor( getBackground( ) );
        pG.fillRect( 0, 0, getWidth( ), getHeight( ) );

        // Dibujar las figuras
        principal.pintarPartes( pG );
        IParte sombreada = principal.darSombreado( );
        if( sombreada != null )
        {
            sombreada.pintarSombreada( pG );
        }

        IParte seleccionada = principal.darSeleccionada( );
        if( seleccionada != null )
        {
            seleccionada.pintarSeleccionada( pG );
        }
    }

    /**
     * Este es el método llamado por la máquina virtual cuando hay que repintar el panel. <br>
     * super.paintComponent( pG ) no sabe pintar las figuras, así que hay que sobrecargar el método.
     * @param pG Superficie del panel. pG !=null.
     */
    public void paintComponent( Graphics pG )
    {
        super.paintComponent( pG );
        update( ( Graphics2D )pG );
    }

    /**
     * Este método se llama cuando se hace clic sobre la superficie del panel fábrica. <br>
     * Dependiendo de la opción seleccionada se debe agregar una figura a la fábrica o se debe seleccionar una de las figuras existentes. <br>
     * @param pEvento Evento del clic sobre el panel mapa. pEvento!= null.
     */
    public void mouseClicked( MouseEvent pEvento )
    {
        if( pEvento.getButton( ) == MouseEvent.BUTTON1 )
        {
            String opcion = principal.darOpcionSeleccionada( );
            if(! opcion.equals( PanelBotones.NINGUNA) &&! opcion.equals( PanelBotones.BORRAR))
            {
                int x = pEvento.getX( );
                int y = pEvento.getY( );

                if( opcion.equals( PanelBotones.SELECCIONAR) )
                {
                    //TODO Parte11 PuntoA. Complete el método.
                    //En este punto el método se encarga de indicarle a l ventana principal que debe seleccionar la parte con las coordenadas del evento.
                    principal.seleccionar( x, y );
                }
                else
                {
                    int xReal = x;
                    int yReal = y;

                    principal.cambiarSeleccionada( null );
                    principal.agregarParte( xReal, yReal );
                }
            }
        }
    }

    /**
     * Este método no se implementa.
     * @param pEvento El evento. pEvento!= null.
     */
    public void mousePressed( MouseEvent pEvento )
    {
        // No se requiere
    }

    /**
     * Este método no se implementa.
     * @param pEvento El evento. pEvento!= null.
     */
    public void mouseReleased( MouseEvent pEvento )
    {
        // No se requiere
    }

    /**
     * Este método no se implementa.
     * @param pEvento El evento. pEvento!= null.
     */
    public void mouseEntered( MouseEvent pEvento )
    {
        // No se requiere
    }

    /**
     * Este método se llama cuando el mouse sale del área del panel.
     * @param pEvento El evento. pEvento!= null.
     */
    public void mouseExited( MouseEvent pEvento )
    {
        principal.cambiarSombreada( null );
        actualizar( );
    }

    /**
     * Este método no se implementa.
     * @param pEvento El evento. pEvento!= null.
     */
    public void mouseDragged( MouseEvent pEvento )
    {
        // No se requiere
    }

    /**
     * Este método se llama cuando se mueve el mouse sobre la superficie del panel. <br>
     * @param pEvento Evento de movimiento sobre el panel. pEvento!= null.
     */
    public void mouseMoved( MouseEvent pEvento )
    {
        int x = pEvento.getX( );
        int y = pEvento.getY( );
        principal.calcularSombra( x, y );
        actualizar( );
    }
}
