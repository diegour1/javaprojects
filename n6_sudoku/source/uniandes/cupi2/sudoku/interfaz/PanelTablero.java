/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_sudoku
 * Autor: Equipo Cupi2 2019, Diego Useche Reyes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sudoku.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.sudoku.mundo.Casilla;

/**
 * Panel con las casillas del sudoku organizadas en un tablero cuadrado.
 */
public class PanelTablero extends JPanel {

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
     * Representa el color que toman las casillas cuando el Sudoku es resuelto.
     */
    private final static Color COLOR_EXITO = new Color( 87, 150, 38 );

    /**
     * Representa el color que toman las casillas cuando el Sudoku tiene errores.
     */
    private final static Color COLOR_ERROR = new Color( 200, 1, 1 );

    /**
     * Representa el color que toman las casillas cuando están vacías.
     */
    private final static Color COLOR_VACIO = new Color( 229, 132, 15 );
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Matriz con las zonas del tablero.
	 */
	private JPanel[][] zonas;

	/**
	 * Matriz que contiene los campos de texto que conforman el tablero del sudoku.
	 */
	private JTextField[][] tablero;


	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	/**
	 * Constructor de la clase.
	 */
	public PanelTablero() {

	}
	
	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	
	/**
	 * Actualiza el tablero con la información de las casillas dadas por parámetro. 
	 * Este método quita todos los elementos del panel y los vuelve a agregar según corresponda de acuerdo a la información dada por parámetro.
	 * @param pFilasZona Cantidad de filas que tiene una zona. pFilasZona>=2.
	 * @param pColumnasZona Cantidad de columnas que tiene una zona. pColumnasZona >=2.
	 * @param pCasillas Casillas del sudoku. pCasillas != null.
	 */
	public void actualizar(int pFilasZona, int pColumnasZona, Casilla[][] pCasillas){
		removeAll(); //Quitar todos los componentes del panel
		setLayout(new GridLayout(pColumnasZona, pFilasZona));
		
		// Crear un borde para que el sudoku se vea cuadrado
		
		TitledBorder borde = new TitledBorder( "Tablero" );
		int width = getWidth();
		int height = getHeight();
		//int max = pFilasZona*pColumnasZona*38;
		int max = Math.max(width, height);
		max = pFilasZona*pColumnasZona*45;
		max= Math.min(max, width);
		max=Math.min(max, height);
		int hMargin = Math.abs((max - height)/2);
		int wMargin = Math.abs((max-width)/2);
		setBorder((Border) new CompoundBorder(borde, BorderFactory.createEmptyBorder(hMargin, wMargin, hMargin, wMargin)));

		//Crear el tablero
		
		//TODO Parte3 PuntoA: Inicializar el atributo zonas
		zonas = new JPanel[pColumnasZona][pFilasZona];
		
		//TODO Parte3 PuntoB: Inicializar el atributo tablero
		tablero = new JTextField[pColumnasZona*pFilasZona][pColumnasZona*pFilasZona];
		
		for (int i = 0; i < pColumnasZona; i++) {
			for (int j = 0; j < pFilasZona; j++) {
				zonas[i][j] = new JPanel();
				crearZona(zonas[i][j], i,j, pFilasZona, pColumnasZona, pCasillas);
				add(zonas[i][j]);
			}
		}
		
		revalidate();
		repaint();
	}
	
	/**
	 * Crea los campos de textos correspondientes a la zona que inicia en pFila y pColumna. 
	 * Los campos de texto son agregados al panel pPanelZona en la ubicación que le corresponde. 
	 * @param pPanelZona panel donde se deben ubicar los campos de texto de la zona. pPanelZona != null.
	 * @param pFila Fila donde inicia la zona (fila de la casilla superior izquierda de la zona). pFila>=0.
	 * @param pColumna Columna donde inicia la zona (columna de la casilla superior izquierda de la zona). pColumna >=0.
	 * @param pFilasZona Cantidad de filas que hay en una zona.
	 * @param pColumnasZona Cantidad de columnas que hay en una zona.
	 * @param pCasillas Casillas del sudoku.
	 */
	public void crearZona(JPanel pPanelZona, int pFila, int pColumna, int pFilasZona, int pColumnasZona, Casilla[][] pCasillas){
		
		//TODO Parte3 PuntoC: Asignar el layout correspondiente a pPanelZona
		pPanelZona.setLayout(new GridLayout(pFilasZona, pColumnasZona));
		
		for(int i=0; i< pFilasZona; i++){
			for(int j=0; j<pColumnasZona; j++){
				JTextField txt = new JTextField();
				txt.setEditable(false);
				int fila = pFila*pFilasZona + i + 1;
				int columna = pColumna*pColumnasZona + j +1;
				Casilla casillaActual = pCasillas[fila-1][columna-1];
				tablero[fila-1][columna-1] = txt;
				
				//TODO Parte3 PuntoD:Actualizar el texto que se debe mostrar de acuerdo a la casilla actual.
				txt.setText(""+pCasillas[fila-1][columna-1].darNumeroUsuario());
				
				Font tipoLetra = txt.getFont( );
                Font nuevoTipoLetra = new Font( tipoLetra.getName( ), Font.PLAIN, tipoLetra.getSize( ) + 3 );

                txt.setHorizontalAlignment( JTextField.CENTER );  
                txt.setFont( nuevoTipoLetra );
				
                //TODO Parte3 PuntoE: Agregar el campo de texto a la zona (pPanelZona)
                pPanelZona.add(txt);
			
                // Se cambia el look and feel de acuerdo a la información de la casilla
                //TODO Parte3 PuntoF: Cambiar el estilo del campo de texto de la casilla según las reglas descritas en la descripción.
                
				if(pCasillas[fila-1][columna-1].darNumeroUsuario().equals(Casilla.NUMERO_VACIO))
				{
					txt.setBackground(COLOR_VACIO);
				}
				else if(pCasillas[fila-1][columna-1].esPista())
				{
					txt.setFont( new Font("Helvetica", Font.BOLD, 14) );
					txt.setBackground(Color.WHITE);
				}
			}
		}
		pPanelZona.setBorder(new BevelBorder( BevelBorder.RAISED));
	}
	

	/**
	 * Mueve el indicador de la casilla actual 
	 * @param pFila la fila de la casilla actual.
	 * @param pColumna la columna de la casilla actual.
	 */
	public void moverse(int pFila, int pColumna) {
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j].setBorder(new LineBorder(Color.DARK_GRAY));
			}
		}

		tablero[pFila][pColumna].setBorder(new LineBorder(Color.BLUE,2));
	}
	
	 /**
     * Se aplica el estilo del tablero solucionado.
     */
    public void mostrarSolucion( )
    {
        for( int i = 0; i < tablero.length; i++ )
        {
            for( int j = 0; j < tablero[i].length; j++ )
            {
            	
            	tablero[ i ][ j ].setBackground( COLOR_EXITO );
            }
        }
    }
    
    /**
     * Se aplica el estilo al tablero validado.
     */
    
    public void mostrarValidacion(Casilla[][] pCasillas )
    {
        for( int i = 0; i < tablero.length; i++ )
        {
            for( int j = 0; j < tablero[0].length; j++ )
            {
            	if(pCasillas[i][j].darNumeroUsuario().equals(Casilla.NUMERO_VACIO)==true || pCasillas[i][j].esPista()==true)
            	{}
            	else
            	{
            		if(pCasillas[i][j].darValidarNumero())
            		{
            			tablero[ i ][ j ].setBackground( COLOR_EXITO );
            		}else{
            			tablero[ i ][ j ].setBackground( COLOR_ERROR );
            		}
				}
            }
        }
    }
    


}
