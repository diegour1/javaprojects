/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiHuracanes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.huracanes.test;

import uniandes.cupi2.cupihuracanes.mundo.Huracan;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase usada para verificar los m�todos de la clase Huracan.
 */
public class HuracanTest
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Hurac�n usado para los casos de prueba.
     */
    private Huracan huracan1;

    /**
     * Hurac�n usado para los casos de prueba.
     */
    private Huracan huracan2;

    /**
     * Hurac�n usado para los casos de prueba.
     */
    private Huracan huracan3;

    /**
     * Hurac�n usado para los casos de prueba.
     */
    private Huracan huracan4;

    // --------------------------------------------------------
    // M�todos
    // --------------------------------------------------------

    /**
     * Escenario 1: Construye huracan1 y huracan2.
     */
    @Before
    public void setupEscenario1( )
    {
        huracan1 = new Huracan( "Nombre Hurac�n 1", 1, 100, 1.1, "imagen1" );
        huracan2 = new Huracan( "Nombre hurac�n 2", 4, 100, 2.3, "imagen2" );
        huracan3 = new Huracan( "nombre Hurac�n 3", 1, 300, 1.1, "imagen3" );
        huracan4 = new Huracan( "nombre hurac�n 1", 3, 200, 3.5, "imagen4" );
    }

    /**
     * Prueba 1: Verifica el m�todo constructor. <br>
     * <b> M�todos a probar: </b> <br>
     * Hurac�n (constructor) <br>
     * darNombre <br>
     * darCategoria <br>
     * darVelocidad <br>
     * darCostoEstimadoDanios <br>
     * darImagen<br>
     * <b> Objetivo: </b> Probar que el constructor crea un hurac�n de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear un hurac�n, los atributos del objeto deben quedar con el valor correcto.
     */
    @Test
    public void testHuracan( )
    {

        assertEquals( "El nombre del hurac�n no es correcto.", "Nombre Hurac�n 1", huracan1.darNombre( ) );
        assertEquals( "La categor�a del hurac�n no es correcta.", 1, huracan1.darCategoria( ) );
        assertEquals( "La velocidad del hurac�n no es correcta.", 100, huracan1.darVelocidad( ) );
        assertEquals( "El costo estimado de da�os no es correcta.", 1.1, huracan1.darCostoEstimadoDanios( ), 0.1 );
        assertEquals( "La imagen del hurac�n no es correcta.", "imagen1", huracan1.darImagen( ) );

        assertEquals( "El nombre del hurac�n no es correcto.", "nombre hurac�n 1", huracan4.darNombre( ) );
        assertEquals( "La categor�a del hurac�n no es correcta.", 3, huracan4.darCategoria( ) );
        assertEquals( "La velocidad del hurac�n no es correcta.", 200, huracan4.darVelocidad( ) );
        assertEquals( "El costo estimado de da�os no es correcta.", 3.5, huracan4.darCostoEstimadoDanios( ), 0.1 );
        assertEquals( "La imagen del hurac�n no es correcta.", "imagen4", huracan4.darImagen( ) );
    }


    /**
     * Prueba 2: Verifica el m�todo compararPorNombre. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorNombre. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorNombre realiza la comparaci�n de dos huracanes de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un hurac�n cuyo nombre sea menor a la de otro, el resultado debe ser -1. <br>
     * 2. Al comparar un hurac�n cuyo nombre sea igual a la de otro, el resultado debe ser 0. <br>
     * 3. Al comparar un hurac�n cuyo nombre sea mayor a la de otro, el resultado debe ser 1.
     */
    //TODO Parte 2 punto D: Implementar el m�todo de prueba seg�n la documentacion.
    public void testcompararPorNombre ( )
    {
    	assertEquals( "La comparacion 1 por Nombre no es correcta ", 0, huracan1.compararPorNombre(huracan4));
    	assertEquals( "La comparacion 2 por Nombre no es correcta ", -1, huracan1.compararPorNombre(huracan2));
    	assertEquals( "La comparacion 3 por Nombre no es correcta ", 1, huracan3.compararPorNombre(huracan4));
    }

    /**
     * Prueba 3: Verifica el m�todo compararPorDanios. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorDanios. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorDanios realiza la comparaci�n de dos huracanes de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un hurac�n cuyo costo estimado en da�os sea menor a la de otro, el resultado debe ser -1. <br>
     * 2. Al comparar un hurac�n cuyo costo estimado en da�os sea igual a la de otro, el resultado debe ser 0. <br>
     * 3. Al comparar un hurac�n cuyo costo estimado en da�os sea mayor a la de otro, el resultado debe ser 1.
     */
    //TODO Parte 2 punto E: Implementar el m�todo de prueba seg�n la documentacion.
    public void testcompararPorDanios ( )
    {
    	assertEquals( "La comparacion 1 por Danios no es correcta ", 0, huracan1.compararPorDanios(huracan3));
    	assertEquals( "La comparacion 2 por Danios no es correcta ", -1, huracan1.compararPorDanios(huracan2));
    	assertEquals( "La comparacion 3 por Danios no es correcta ", 1, huracan4.compararPorDanios(huracan3));	
    }

    /**
     * Prueba 4: Verifica el m�todo compararPorVelocidad. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorVelocidad. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorVelocidad realiza la comparaci�n de dos huracanes de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un hurac�n cuya velocidad sea menor a la de otro, el resultado debe ser -1. <br>
     * 2. Al comparar un hurac�n cuya velocidad sea igual a la de otro, el resultado debe ser 0. <br>
     * 3. Al comparar un hurac�n cuya velocidad sea mayor a la de otro, el resultado debe ser 1.
     */

    //TODO Parte 2 punto F: Implementar el m�todo de prueba seg�n la documentacion.
    public void testcompararPorVelocidad ( )
    {
    	assertEquals( "La comparacion 1 por Velocidad no es correcta ", 0, huracan1.compararPorVelocidad(huracan2));
    	assertEquals( "La comparacion 2 por Velocidad no es correcta ", -1, huracan1.compararPorVelocidad(huracan3));
    	assertEquals( "La comparacion 3 por Velocidad no es correcta ", 1, huracan4.compararPorVelocidad(huracan2));	
    }
    
    /**
     * Prueba 5: Verifica el m�todo comparar <b> M�todos a probar: </b> toString <br>
     * <b> Objetivo: </b> Probar que el m�todo toString retorna la cadena de caract�res correcta
     * <b> Resultados esperados: </b> <br>
     * 1. El m�todo toString retorna la cadena de caracteres esperada
     */
    @Test
    public void testToString( )
    {
        assertEquals( "La cadena de caracteres no es correcta", "Nombre Hurac�n 1", huracan1.toString( ) );
        assertEquals( "La cadena de caracteres no es correcta", "Nombre hurac�n 2", huracan2.toString( ) );
        assertEquals( "La cadena de caracteres no es correcta", "nombre Hurac�n 3", huracan3.toString( ) );
        assertEquals( "La cadena de caracteres no es correcta", "nombre hurac�n 1", huracan4.toString( ) );
    }
}
