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
package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintWriter;

/**
 ** Clase que contiene los contratos de Parte.
 */
public interface IParte
{

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el alto de la figura.
     * @return Alto de la figura.
     */
    public int darAlto( );

    /**
     * Retorna el ancho de la figura.
     * @return Ancho de la figura.
     */
    public int darAncho( );

    /**
     * Retorna el color de la figura.
     * @return Color de la figura.
     */
    public Color darColor( );

    /**
     * Retorna el tipo de la figura.
     * @return Tipo de la figura.
     */
    public String darTipo( );

    /**
     * Retorna la coordenada x de la figura.
     * @return Coordenada x de la figura.
     */
    public int darX( );

    /**
     * Retorna la coordenada y de la figura.
     * @return Coordenada y de la figura.
     */
    public int darY( );

    /**
     * Cambia la coordenada x de la figura.
     * @param pX Nueva coordenada x de la figura. pX >= 0.
     */
    public void cambiarX( int pX );

    /**
     * Cambia la coordenada y de la figura.
     * @param pY Nueva coordenada y de la figura. pY >= 0.
     */
    public void cambiarY( int pY );

    /**
     * Cambia el ancho de la figura.
     * @param pAncho Nuevo ancho de la figura. pAncho > 0.
     */
    public void cambiarAncho( int pAncho );

    /**
     * Cambia el alto de la figura.
     * @param pAlto Nuevo alto de la figura. pAlto > 0.
     */
    public void cambiarAlto( int pAlto );

    /**
     * Cambia el color de la figura.
     * @param pColor Nuevo color de la figura representado en un número de código RGB. pColor >= 0.
     */
    public void cambiarColor( int pColor );

    /**
     * Indica si un punto está dentro de una figura o no.
     * @param pX Coordenada x del punto. pX >= 0.
     * @param pY Coordenada y del punto. pY >= 0.
     * @return Retorna true si el punto está dentro de la figura, false en caso contrario.
     */
    public boolean estaDentro( int pX, int pY );

    /**
     * Guarda la figura en un archivo. <br>
     * <b>post: </b> Se guardó la figura en el archivo.
     * @param pOut Stream donde se va a guardar la figura. pOut!=null.
     */
    public void guardar( PrintWriter pOut );

    /**
     * Dibuja la figura. <br>
     * <b>post: </b> Se dibujó la figura en el lienzo.
     * @param pG La superficie donde se debe pintar. pG!=null.
     */
    //TODO Parte1 PuntoA. Realice la declaración del método pintar.
    //Siga la descripción del diagrama UML de clases.
    public void pintar( Graphics2D pG);
    /**
     * Pinta la figura como seleccionada.<br>
     * <b>post: </b> Se dibujó el contorno de la figura seleccionada en el lienzo.
     * @param pG Superficie donde se pinta el rectángulo. pG!=null.
     */
    public void pintarSeleccionada( Graphics2D pG );

    /**
     * Dibuja la figura sombreada.<br>
     * <b>post: </b> Se dibujó la figura sombreada en el lienzo.
     * @param pG Superficie donde se debe pintar. g!=null.
     */
    public void pintarSombreada( Graphics2D pG );
}