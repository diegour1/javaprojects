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

import co.edu.uniandes.cupi2.subastas.mundo.Subasta;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase usada para verificar que los métodos de la clase Subasta estén correctamente implementados.
 */
public class SubastaTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Subasta subasta;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye una nueva Subasta.
     */
    @Before
    public void setupEscenario1( )
    {
        subasta = new Subasta( );
    }

    /**
     * Prueba 1: Verifica el método constructor<br>
     * <b> Métodos a probar: </b> <br>
     * darCelular1<br>
     * darCelular2<br>
     * darCelular3<br>
     * <b> Objetivo: </b> Probar inicialización correcta del objeto Subasta<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Inicialización correcta de Subasta<br>
     * 2. Inicialización correcta de cada uno de los celulares.
     */
    @Test
    public void testSubasta( )
    {
        assertNotNull( "La subasta  no debería ser nula.", subasta );

        assertNotNull( "Debería existir el celular1.", subasta.darCelular1( ) );
        assertEquals( "El modelo del celular1 no corresponde.", subasta.darCelular1( ).darModelo( ), "Galaxy Note" );
        assertEquals( "El precio base del celular1 no corresponde.", subasta.darCelular1( ).darCostoBase( ), 50000 );
        assertEquals( "La marca del celular1 no corresponde.", subasta.darCelular1( ).darMarca( ), "Samsung" );

        assertNotNull( "Debería existir el celular2.", subasta.darCelular2( ) );
        assertEquals( "El modelo del celular2 no corresponde.", subasta.darCelular2( ).darModelo( ), "LG Z" );
        assertEquals( "El precio base del celular2 no corresponde.", subasta.darCelular2( ).darCostoBase( ), 50000 );
        assertEquals( "La marca del celular2 no corresponde.", subasta.darCelular2( ).darMarca( ), "LG" );

        assertNotNull( "Debería existir el celular3.", subasta.darCelular3( ) );
        assertEquals( "El modelo del celular3 no corresponde.", subasta.darCelular3( ).darModelo( ), "iPhone" );
        assertEquals( "El precio base del celular3 no corresponde.", subasta.darCelular3( ).darCostoBase( ), 50000 );
        assertEquals( "La marca del celular3 no corresponde.", subasta.darCelular3( ).darMarca( ), "Apple" );
    }

    /**
     * Prueba 2: Verifica el método registrarOfertaMinimaCelular1<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaMinimaCelular1<br>
     * darCelular1<br>
     * <b> Objetivo: </b> Probar que se registren correctamente las ofertas mínimas para el celular 1.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registran correctamente las ofertas mínimas para el celular 1.
     */
    @Test
    public void testRegistrarOfertaMinimaCelular1( )
    {
        subasta.registrarOfertaMinimaCelular1( );
        assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular1( ).darValorTotalOfertas( ), 50000 );
        assertEquals( "El número total de ofertas no corresponde.", subasta.darCelular1( ).darNumeroOfertas( ), 1 );

        subasta.registrarOfertaMinimaCelular1( );
        assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular1( ).darValorTotalOfertas( ), 100000 );
        assertEquals( "El número total de ofertas no corresponde.", subasta.darCelular1( ).darNumeroOfertas( ), 2 );

    }

    /**
     * Prueba 3: Verifica el método registrarOfertaMinimaCelular2<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaMinimaCelular2<br>
     * darCelular2<br>
     * <b> Objetivo: </b> Probar que se registren correctamente las ofertas mínimas para el celular 2.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registran correctamente las ofertas mínimas para el celular 2.
     */
    @Test
    public void testRegistrarOfertaMinimaCelular2( )
    {
        subasta.registrarOfertaMinimaCelular2( );
        assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular2( ).darValorTotalOfertas( ), 50000 );
        assertEquals( "El número total de ofertas no corresponde.", subasta.darCelular2( ).darNumeroOfertas( ), 1 );

        subasta.registrarOfertaMinimaCelular2( );
        assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular2( ).darValorTotalOfertas( ), 100000 );
        assertEquals( "El número total de ofertas no corresponde.", subasta.darCelular2( ).darNumeroOfertas( ), 2 );
    }

    /**
     * Prueba 4: Verifica el método registrarOfertaMinimaCelular3<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaMinimaCelular3<br>
     * darCelular3<br>
     * <b> Objetivo: </b> Probar que se registren correctamente las ofertas mínimas para el celular 3.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registran correctamente las ofertas mínimas para el celular 3.
     */
    @Test
    public void testRegistrarOfertaMinimaCelular3( )
    {
        subasta.registrarOfertaMinimaCelular3( );
        assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular3( ).darValorTotalOfertas( ), 50000 );
        assertEquals( "El número total de ofertas no corresponde.", subasta.darCelular3( ).darNumeroOfertas( ), 1 );

        subasta.registrarOfertaMinimaCelular3( );
        assertEquals( "El valor total de ofertas no corresponde.", subasta.darCelular3( ).darValorTotalOfertas( ), 100000 );
        assertEquals( "El número total de ofertas no corresponde.", subasta.darCelular3( ).darNumeroOfertas( ), 2 );
    }

    /**
     * Prueba 5: Verifica el método registrarOfertaModeradaCelular1<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaModeradaCelular1<br>
     * darCelular1<br>
     * <b> Objetivo: </b> Probar que se registren correctamente las ofertas moderadas para el celular 1.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registran correctamente las ofertas moderadas para el celular1.
     */
    @Test
    public void testRegistrarOfertaModeradaCelular1( )
    {
        subasta.registrarOfertaModeradaCelular1( );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 100000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 1 );

        subasta.registrarOfertaModeradaCelular1( );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 200000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 2 );
    }

    /**
     * Prueba 6: Verifica el método registrarOfertaModeradaCelular2<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaModeradaCelular2<br>
     * darCelular2<br>
     * <b> Objetivo: </b> Probar que se registren correctamente las ofertas moderadas para el celular 2.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registran correctamente las ofertas moderadas para el celular2.
     */
    @Test
    public void testRegistrarOfertaModeradaCelular2( )
    {
        subasta.registrarOfertaModeradaCelular2( );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 100000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 1 );

        subasta.registrarOfertaModeradaCelular2( );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 200000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 2 );
    }

    /**
     * Prueba 7: Verifica el método registrarOfertaModeradaCelular3<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaModeradaCelular3<br>
     * darCelular3<br>
     * <b> Objetivo: </b> Probar que se registren correctamente las ofertas moderadas para el celular 3.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registran correctamente las ofertas moderadas para el celular3.
     */
    @Test
    public void testRegistrarOfertaModeradaCelular3( )
    {
        subasta.registrarOfertaModeradaCelular3( );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 100000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 1 );

        subasta.registrarOfertaModeradaCelular3( );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 200000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 2 );
    }

    /**
     * Prueba 8: Verifica el método registrarOfertaAbiertaCelular1<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaAbiertaCelular1<br>
     * darCelular1<br>
     * <b> Objetivo: </b> Probar que se registren correctamente las ofertas abiertas para el celular 1.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registran correctamente las ofertas abiertas para el celular 1.
     */
    @Test
    public void testRegistrarOfertaAbiertaCelular1( )
    {
        subasta.registrarOfertaAbiertaCelular1( 60000 );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 60000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 1 );

        subasta.registrarOfertaAbiertaCelular1( 28000 );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 88000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 2 );

    }

    /**
     * Prueba 9: Verifica el método registrarOfertaAbiertaCelular2<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaAbiertaCelular2<br>
     * darCelular2<br>
     * <b> Objetivo: </b> Probar que se registren correctamente las ofertas abiertas para el celular 2.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registran correctamente las ofertas abiertas para el celular 2.
     */
    @Test
    public void testRegistrarOfertaAbiertaCelular2( )
    {
        subasta.registrarOfertaAbiertaCelular2( 40000 );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 40000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 1 );

        subasta.registrarOfertaAbiertaCelular2( 36000 );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 76000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 2 );

    }

    /**
     * Prueba 10: Verifica el método registrarOfertaAbiertaCelular3<br>
     * <b> Métodos a probar: </b> <br>
     * registrarOfertaAbiertaCelular3<br>
     * darCelular3<br>
     * <b> Objetivo: </b> Probar que se registren correctamente las ofertas abiertas para el celular 3.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registran correctamente las ofertas abiertas para el celular 3.
     */
    @Test
    public void testRegistrarOfertaAbiertaCelular3( )
    {
        subasta.registrarOfertaAbiertaCelular3( 50000 );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 50000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 1 );

        subasta.registrarOfertaAbiertaCelular3( 27000 );
        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 77000 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 2 );

    }
    /**
     * Prueba 11: Verifica el método reiniciarSubasta<br>
     * <b> Métodos a probar: </b> <br>
     * reiniciarSubasta<br>
     * registrarOfertaAbiertaCelular1<br>
     * registrarOfertaAbiertaCelular2<br>
     * registrarOfertaAbiertaCelular3<br>
     * darCelular1<br>
     * darCelular2<br>
     * darCelular3<br>
     * <b> Objetivo: </b> Probar que al reiniciar subasta, se reinicien los valores en todos los celulares.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El valor total ofertado y el número de ofertas de cada celular es 0.<br>
     */
    @Test
    public void testReiniciarSubasta( )
    {
        subasta.registrarOfertaAbiertaCelular1( 60000 );
        subasta.registrarOfertaAbiertaCelular2( 70000 );
        subasta.registrarOfertaAbiertaCelular3( 80000 );

        subasta.reiniciarSubasta( );

        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular1( ).darValorTotalOfertas( ), 0 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular1( ).darNumeroOfertas( ), 0 );

        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular2( ).darValorTotalOfertas( ), 0 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular2( ).darNumeroOfertas( ), 0 );

        assertEquals( "El valor total de ofertas no correpsonde.", subasta.darCelular3( ).darValorTotalOfertas( ), 0 );
        assertEquals( "El número total de ofertas no correpsonde.", subasta.darCelular3( ).darNumeroOfertas( ), 0 );
    }

    /**
     * Prueba 12: Verifica el método calcularNumeroTotalOfertas<br>
     * <b> Métodos a probar: </b> <br>
     * calcularNumeroTotalOfertas<br>
     * registrarOfertaAbiertaCelular1<br>
     * registrarOfertaAbiertaCelular2<br>
     * registrarOfertaAbiertaCelular3<br>
     * <b> Objetivo: </b> Probar que al calcular el número total de ofertas, se realice la suma de todos los celulares.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El número total de ofertas es la suma de los 3 celulares.<br>
     */
    @Test
    public void testCalcularNumeroTotalOfertas( )
    {
        assertEquals( "El número total de ofertas debería ser 0.", subasta.calcularNumeroTotalOfertas( ), 0 );

        subasta.registrarOfertaAbiertaCelular1( 60000 );
        assertEquals( "El número total de ofertas debería ser 1.", subasta.calcularNumeroTotalOfertas( ), 1 );

        subasta.registrarOfertaAbiertaCelular2( 70000 );
        assertEquals( "El número total de ofertas debería ser 2.", subasta.calcularNumeroTotalOfertas( ), 2 );

        subasta.registrarOfertaAbiertaCelular3( 80000 );
        assertEquals( "El número total de ofertas debería ser 3.", subasta.calcularNumeroTotalOfertas( ), 3 );

        subasta.registrarOfertaModeradaCelular1( );
        assertEquals( "El número total de ofertas debería ser 4.", subasta.calcularNumeroTotalOfertas( ), 4 );

        subasta.registrarOfertaModeradaCelular2( );
        assertEquals( "El número total de ofertas debería ser 5.", subasta.calcularNumeroTotalOfertas( ), 5 );

        subasta.registrarOfertaModeradaCelular3( );
        assertEquals( "El número total de ofertas debería ser 6.", subasta.calcularNumeroTotalOfertas( ), 6 );

        subasta.registrarOfertaMinimaCelular1( );
        assertEquals( "El número total de ofertas debería ser 7.", subasta.calcularNumeroTotalOfertas( ), 7 );

        subasta.registrarOfertaMinimaCelular2( );
        assertEquals( "El número total de ofertas debería ser 8.", subasta.calcularNumeroTotalOfertas( ), 8 );

        subasta.registrarOfertaMinimaCelular3( );
        assertEquals( "El número total de ofertas debería ser 9.", subasta.calcularNumeroTotalOfertas( ), 9 );

    }

    /**
     * Prueba 13: Verifica el método calcularValorTotalRecaudado<br>
     * <b> Métodos a probar: </b> <br>
     * calcularValorTotalRecaudado<br>
     * registrarOfertaAbiertaCelular1<br>
     * registrarOfertaAbiertaCelular2<br>
     * registrarOfertaAbiertaCelular3<br>
     * <b> Objetivo: </b> Probar que al calcular el valor total recaudado, se realice la suma de todos los celulares.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El valor total recaudado es la suma del recaudo los 3 celulares.<br>
     */
    @Test
    public void testCalcularValorTotalRecaudado( )
    {
        assertEquals( "El valor total de ofertas debería ser 0.", subasta.calcularValorTotalRecaudado( ), 0 );

        subasta.registrarOfertaAbiertaCelular1( 60000 );
        assertEquals( "El valor total recaudado debería ser 60000.", subasta.calcularValorTotalRecaudado( ), 60000 );

        subasta.registrarOfertaAbiertaCelular2( 70000 );
        assertEquals( "El valor total recaudado debería ser 130000.", subasta.calcularValorTotalRecaudado( ), 130000 );

        subasta.registrarOfertaAbiertaCelular3( 80000 );
        assertEquals( "El valor total recaudado debería ser 210000.", subasta.calcularValorTotalRecaudado( ), 210000 );

        subasta.registrarOfertaModeradaCelular1( );
        assertEquals( "El valor total recaudado debería ser 310000.", subasta.calcularValorTotalRecaudado( ), 310000 );

        subasta.registrarOfertaModeradaCelular2( );
        assertEquals( "El valor total recaudado debería ser 410000.", subasta.calcularValorTotalRecaudado( ), 410000 );

        subasta.registrarOfertaModeradaCelular3( );
        assertEquals( "El valor total recaudado debería ser 510000.", subasta.calcularValorTotalRecaudado( ), 510000 );

        subasta.registrarOfertaMinimaCelular1( );
        assertEquals( "El valor total recaudado debería ser 560000.", subasta.calcularValorTotalRecaudado( ), 560000 );

        subasta.registrarOfertaMinimaCelular2( );
        assertEquals( "El valor total recaudado debería ser 610000.", subasta.calcularValorTotalRecaudado( ), 610000 );

        subasta.registrarOfertaMinimaCelular3( );
        assertEquals( "El valor total recaudado debería ser 660000.", subasta.calcularValorTotalRecaudado( ), 660000 );
    }

    /**
     * Prueba 14: verifica el método calcularIncrementoPromedioCostoBase<br>
     * <b> Métodos a probar: </b> <br>
     * calcularIncrementoPromedioCostoBase<br>
     * registrarOfertaAbiertaCelular1<br>
     * registrarOfertaAbiertaCelular2<br>
     * registrarOfertaAbiertaCelular3<br>
     * <b> Objetivo: </b> Probar que al calcular el incremento promedio costo base, se calcule el promedio.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El incremento promedio fue calculado correctamente.
     */
    @Test
    public void testCalcularIncrementoPromedioCostoBase( )
    {
        subasta.registrarOfertaAbiertaCelular1( 60000 );
        subasta.registrarOfertaAbiertaCelular2( 70000 );
        subasta.registrarOfertaAbiertaCelular3( 80000 );

        assertEquals( "El incremento promedio debería ser 20000.", subasta.calcularIncrementoPromedioCostoBase( ), 20000, 0.1 );
        subasta.registrarOfertaModeradaCelular1( );

        assertEquals( "El incremento promedio debería ser 53333.", subasta.calcularIncrementoPromedioCostoBase( ), 53333, 0.1 );
        subasta.registrarOfertaModeradaCelular2( );

        assertEquals( "El incremento promedio debería ser 86666.", subasta.calcularIncrementoPromedioCostoBase( ), 86666, 0.1 );
        subasta.registrarOfertaModeradaCelular3( );

        assertEquals( "El incremento promedio debería ser 120000.", subasta.calcularIncrementoPromedioCostoBase( ), 120000, 0.1 );
        subasta.registrarOfertaMinimaCelular1( );

        assertEquals( "El incremento promedio debería ser 136666.", subasta.calcularIncrementoPromedioCostoBase( ), 136666, 0.1 );
        subasta.registrarOfertaMinimaCelular2( );

        assertEquals( "El incremento promedio debería ser 153333.", subasta.calcularIncrementoPromedioCostoBase( ), 153333, 0.1 );
        subasta.registrarOfertaMinimaCelular3( );
        assertEquals( "El incremento promedio debería ser 170000.", subasta.calcularIncrementoPromedioCostoBase( ), 170000, 0.1 );

    }

}
