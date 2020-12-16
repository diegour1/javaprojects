/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_subastaCelulares
 * Autor: Equipo Cupi2 - 201910
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.cupi2.subastas.test;

import co.edu.uniandes.cupi2.subastas.mundo.Celular;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Clase usada para verificar que los métodos de la clase Celular estén correctamente implementados.
 */
public class CelularTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Celular celular;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo Celular.
     */
    @Before
    public void setupEscenario1( )
    {
        celular = new Celular( "Modelo", 40000, "Marca" );
    }

    /**
     * Prueba 1: Verifica el método constructor<br>
     * <b> Métodos a probar: </b> <br>
     * darMarca<br>
     * darModelo<br>
     * darCostoBase<br>
     * darValorTotalOfertas<br>
     * darNumeroOfertas<br>
     * <b> Objetivo: </b> Probar inicialización correcta del objeto Celular<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Inicialización correcta de Celular<br>
     */
    @Test
    public void testCelular( )
    {
        assertNotNull( "El celular no debería ser nulo.", celular );
        assertEquals( "La marca no coincide.", celular.darMarca( ), "Marca" );
        assertEquals( "El modelo no coincide.", celular.darModelo( ), "Modelo" );
        assertEquals( "El costo base no coincide.", celular.darCostoBase( ), 40000 );
        assertEquals( "El valor total de ofertas debería ser 0.", celular.darValorTotalOfertas( ), 0 );
        assertEquals( "El número de ofertas debería ser 0.", celular.darNumeroOfertas( ), 0 );
    }

    /**
     * Prueba 2: Verifica el método registrarOfertaMinima<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaMinima<br>
     * darValorTotalOfertas<br>
     * darNumeroOfertas<br>
     * <b> Objetivo: </b> Probar que se registra correctamente una oferta mínima<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El valor total de ofertas aumenta en 50000<br>
     * 2. El número total de oferta aumenta en 1.
     */
    @Test
    public void testRegistrarOfertaMinima( )
    {
        celular.registrarOfertaMinima( );
        assertEquals( "El valor total de ofertas debería ser 50000.", celular.darValorTotalOfertas( ), 50000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );

        celular.registrarOfertaMinima( );
        assertEquals( "El valor total de ofertas debería ser 100000.", celular.darValorTotalOfertas( ), 100000 );
        assertEquals( "El número de ofertas debería ser 2.", celular.darNumeroOfertas( ), 2 );
    }

    /**
     * Prueba 3: Verifica el método registrarOfertaModerada<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaModerada darValorTotalOfertas darNumeroOfertas <b> Objetivo: </b> Probar que se registra correctamente una oferta moderada.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El valor total de ofertas aumenta en 100000<br>
     * 2. El número total de oferta aumenta en 1.
     */
    @Test
    public void testRegistrarOfertaModerada( )
    {
        celular.registrarOfertaModerada( );
        assertEquals( "El valor total de ofertas debería ser 100000.", celular.darValorTotalOfertas( ), 100000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );

        celular.registrarOfertaModerada( );
        assertEquals( "El valor total de ofertas debería ser 200000.", celular.darValorTotalOfertas( ), 200000 );
        assertEquals( "El número de ofertas debería ser 2.", celular.darNumeroOfertas( ), 2 );
    }

    /**
     * Prueba 3: Verifica el método registrarOfertaAbierta<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaAbierta darValorTotalOfertas darNumeroOfertas <b> Objetivo: </b> Probar que se registra correctamente una oferta abierta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El valor total de ofertas aumenta en lo especificado.<br>
     * 2. El número total de oferta aumenta en 1.
     */
    @Test
    public void testRegistrarOfertaAbierta( )
    {
        celular.registrarOfertaAbierta( 123000 );
        assertEquals( "El valor total de ofertas debería ser 123000.", celular.darValorTotalOfertas( ), 123000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );

        celular.registrarOfertaAbierta( 50000 );
        assertEquals( "El valor total de ofertas debería ser 173000.", celular.darValorTotalOfertas( ), 173000 );
        assertEquals( "El número de ofertas debería ser 2.", celular.darNumeroOfertas( ), 2 );

    }

    /**
     * Prueba 4: Verifica el método calcularIncrementoCostoBase<br>
     * <b> Métodos a probar: </b> <br>
     * calcularIncrementoCostoBase registrarOfertaAbierta registrarOfertaMinima registrarOfertaModerada <b> Objetivo: </b> Probar que se al registrar una oferta cambia el
     * incremento en el costo base.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El incremento en costo base aumenta correctamente al realizar distintas ofertas.
     */
    @Test
    public void testCalcularIncrementoCostoBase( )
    {
        celular.registrarOfertaMinima( );
        assertEquals( "El incremento en el costo base debería ser 10000.", celular.calcularIncrementoCostoBase( ), 10000 );

        celular.registrarOfertaModerada( );
        assertEquals( "El incremento en el costo base debería ser 110000.", celular.calcularIncrementoCostoBase( ), 110000 );

        celular.registrarOfertaAbierta( 90000 );
        assertEquals( "El incremento en el costo base debería ser 200000.", celular.calcularIncrementoCostoBase( ), 200000 );

    }

    /**
     * Prueba 5: Verifica el método reiniciarNumeroOfertas<br>
     * <b> Métodos a probar: </b> <br>
     * reiniciarNumeroOfertas darNumeroOfertas registrarOfertaAbierta registrarOfertaMinima registrarOfertaModerada <b> Objetivo: </b> Probar que al reiniciar el número de
     * ofertas le sea asignado el valor 0.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El número total de ofertas debe ser 0 después de ser reiniciado.
     */
    @Test
    public void testReiniciarNumeroOfertas( )
    {
        celular.registrarOfertaMinima( );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );

        celular.reiniciarNumeroOfertas( );
        assertEquals( "El número de ofertas debería ser 0.", celular.darNumeroOfertas( ), 0 );

        celular.registrarOfertaModerada( );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );

        celular.registrarOfertaAbierta( 90000 );
        assertEquals( "El número de ofertas debería ser 2.", celular.darNumeroOfertas( ), 2 );

        celular.reiniciarNumeroOfertas( );
        assertEquals( "El número de ofertas debería ser 0.", celular.darNumeroOfertas( ), 0 );
    }

    /**
     * Prueba 5: Verifica el método reiniciarValorTotalOfertas<br>
     * <b> Métodos a probar: </b> <br>
     * reiniciarValorTotalOfertas darValorTotalOfertas registrarOfertaAbierta registrarOfertaMinima registrarOfertaModerada <b> Objetivo: </b> Probar que al reiniciar el valor
     * total de ofertas, le sea asignado el valor 0.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El valor total de ofertas debe ser 0 después de ser reiniciado.
     */
    @Test
    public void testReiniciarValorTotalOfertas( )
    {
        celular.registrarOfertaMinima( );
        assertEquals( "El valor total de ofertas debería ser 50000.", celular.darValorTotalOfertas( ), 50000 );

        celular.reiniciarValorTotalOfertas( );
        assertEquals( "El valor total de ofertas debería ser 0.", celular.darValorTotalOfertas( ), 0 );

        celular.registrarOfertaModerada( );
        assertEquals( "El valor total de ofertas debería ser 100000.", celular.darValorTotalOfertas( ), 100000 );

        celular.registrarOfertaAbierta( 90000 );
        assertEquals( "El valor total de ofertas debería ser 190000.", celular.darValorTotalOfertas( ), 190000 );

        celular.reiniciarValorTotalOfertas( );
        assertEquals( "El valor total de ofertas debería ser 0.", celular.darValorTotalOfertas( ), 0 );
    }
}
