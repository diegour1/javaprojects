/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_subastaCelulares
 * Autor: Equipo Cupi2 - 201910
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.cupi2.subastas.test;



import static org.junit.Assert.*;

import org.junit.*;

import co.edu.uniandes.cupi2.subastas.mundo.Celular;
import co.edu.uniandes.cupi2.subastas.mundo.Celular.Gama;


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
        celular = new Celular( "Modelo", 40000, "Marca", Gama.BAJA );
    }
    
    /**
     * Construye un nuevo Celular.
     */
    private void setupEscenario2( )
    {
        celular = new Celular( "Modelo", 40000, "Marca", Gama.MEDIA );
    }
    
    /**
     * Construye un nuevo Celular.
     */
    private void setupEscenario3( )
    {
        celular = new Celular( "Modelo", 40000, "Marca", Gama.ALTA );
    }

    /**
     * Prueba 1: Verifica el método inicializar<br>
     * <b> Métodos a probar: </b> <br>
     * inicializar<br>
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
    public void testInicializar( )
    {
        assertNotNull( "El celular no debería ser nulo.", celular );
        assertEquals( "La marca no coincide.", celular.darMarca( ), "Marca" );
        assertEquals( "El modelo no coincide.", celular.darModelo( ), "Modelo" );
        assertEquals( "El costo base no coincide.", celular.darCostoBase( ), 40000 );
        assertEquals( "El valor total de ofertas debería ser 0.", celular.darValorTotalOfertas( ), 0 );
        assertEquals( "El número de ofertas debería ser 0.", celular.darNumeroOfertas( ), 0 );
        assertEquals("El tipo de celular debe ser de gama BAJA.", celular.darGama(), Gama.BAJA);
        assertEquals("el celular no deberia estar vendido", celular.estaVendido(), false);
        
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
        assertEquals( "El valor total de ofertas debería ser 20000.", celular.darValorTotalOfertas( ), 20000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );

        celular.registrarOfertaMinima( );
        assertEquals( "El valor total de ofertas debería ser 40000.", celular.darValorTotalOfertas( ), 40000 );
        assertEquals( "El número de ofertas debería ser 2.", celular.darNumeroOfertas( ), 2 );
        
        boolean resp= celular.vender();
        assertEquals( "el celular se debio haber vendido", resp, true );
        
        resp = celular.registrarOfertaMinima( );
        assertEquals( "no se debio hacer el registro de la oferta", resp, false );
        assertEquals( "El valor total de ofertas debería ser 40000.", celular.darValorTotalOfertas( ), 40000 );
        assertEquals( "El número de ofertas debería ser 2.", celular.darNumeroOfertas( ), 2 );
        
        //Pruebas con gama media
        setupEscenario2();
        celular.registrarOfertaMinima( );
        assertEquals( "El valor total de ofertas debería ser 40000.", celular.darValorTotalOfertas( ), 40000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );
        
      //Pruebas con gama alta
        setupEscenario3();
        celular.registrarOfertaMinima( );
        assertEquals( "El valor total de ofertas debería ser 60000.", celular.darValorTotalOfertas( ), 60000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );
        
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

        celular.registrarOfertaModerada();
        assertEquals( "El valor total de ofertas debería ser 40000.", celular.darValorTotalOfertas( ), 40000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );

        celular.registrarOfertaModerada( );
        assertEquals( "El valor total de ofertas debería ser 80000.", celular.darValorTotalOfertas( ), 80000 );
        assertEquals( "El número de ofertas debería ser 2.", celular.darNumeroOfertas( ), 2 );
        
        boolean resp= celular.vender();
        assertEquals( "el celular se debio haber vendido", resp, true );
        
        resp = celular.registrarOfertaModerada( );
        assertEquals( "no se debio hacer el registro de la oferta", resp, false );
        assertEquals( "El valor total de ofertas debería ser 80000.", celular.darValorTotalOfertas( ), 80000 );
        assertEquals( "El número de ofertas debería ser 2.", celular.darNumeroOfertas( ), 2 );
        
        //Pruebas con gama media
        setupEscenario2();
        celular.registrarOfertaModerada( );
        assertEquals( "El valor total de ofertas debería ser 60000.", celular.darValorTotalOfertas( ), 60000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );
        
        //Pruebas con gama alta
        setupEscenario3();
        celular.registrarOfertaModerada( );
        assertEquals( "El valor total de ofertas debería ser 80000.", celular.darValorTotalOfertas( ), 80000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );
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

        boolean resp = celular.registrarOfertaAbierta( 100000 );
        assertTrue("se debio haber registrado la oferta",resp);
        assertEquals( "El valor total de ofertas debería ser 100000.", celular.darValorTotalOfertas( ), 100000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 1 );
        
        boolean resp2 = celular.registrarOfertaAbierta( 100000 );
        assertTrue("se debio haber registrado la oferta",resp2);
        assertEquals( "El valor total de ofertas debería ser 200000.", celular.darValorTotalOfertas( ), 200000 );
        assertEquals( "El número de ofertas debería ser 1.", celular.darNumeroOfertas( ), 2 );
        
        celular.vender();

        boolean resp3 = celular.registrarOfertaAbierta( 50000 );
        assertFalse("se debio haber vendido el celular",resp3);
        assertEquals( "El valor total de ofertas debería ser 200000.", celular.darValorTotalOfertas( ), 200000 );
        assertEquals( "El número de ofertas debería ser 2.", celular.darNumeroOfertas( ), 2 );

    }
    
    /** 
     * Prueba 4: verifica que el metodo vender este correcto <br>
     * <b> metodos a probar: </b> <br>
     * vender <b>Objetivo : vender un producto de forma correcta.
     * <b> Resultados esperados: </b> <br>
     * 1. El celular se logro vender de forma correcta.
     */
    @Test
    public void testVender()
    {
    	
    	assertFalse("el celular no se ha vendido", celular.estaVendido());
    	assertTrue("el celular se logro vender correctamente", celular.vender());
    	assertTrue("el estado del celular es vendido", celular.estaVendido());
    	assertFalse("el celular no se puede vender 2 veces", celular.vender());
    	
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
        assertEquals( "El incremento en el costo base debería ser -20000.", celular.calcularIncrementoCostoBase( ), -20000 );

        celular.registrarOfertaModerada( );
        assertEquals( "El incremento en el costo base debería ser 20000.", celular.calcularIncrementoCostoBase( ), 20000 );

        celular.registrarOfertaAbierta( 90000 );
        assertEquals( "El incremento en el costo base debería ser 110000.", celular.calcularIncrementoCostoBase( ), 110000 );

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
        assertEquals( "El valor total de ofertas debería ser 20000.", celular.darValorTotalOfertas( ), 20000 );

        celular.reiniciarValorTotalOfertas( );
        assertEquals( "El valor total de ofertas debería ser 0.", celular.darValorTotalOfertas( ), 0 );

        celular.registrarOfertaModerada( );
        assertEquals( "El valor total de ofertas debería ser 40000.", celular.darValorTotalOfertas( ), 40000 );

        celular.registrarOfertaAbierta( 90000 );
        assertEquals( "El valor total de ofertas debería ser 130000.", celular.darValorTotalOfertas( ), 130000 );

        celular.reiniciarValorTotalOfertas( );
        assertEquals( "El valor total de ofertas debería ser 0.", celular.darValorTotalOfertas( ), 0 );
    }
    
    /**
     * Prueba 6: Verifica el método reiniciarVendido<br>
     * <b> Métodos a probar: </b> <br>
     * <b> Objetivo: </b> Probar que al reiniciar
     * el celular, este no se haya vendido aun.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. el celular fue vendido de forma exitosa y al reiniciarse aparece como sin vender
     */
    @Test
    public void testReiniciarVendido( )
    {    	
    	assertFalse("el celular no se debe haber vendido", celular.estaVendido());
    	assertTrue("el celular se logro vender correctamente", celular.vender());
    	assertTrue("el celular se logro vender correctamente", celular.estaVendido());
    	celular.reiniciarVendido();
    	
    	assertFalse("el celular no se debe haber vendido", celular.estaVendido());
    	
    }
}
