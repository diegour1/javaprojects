/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueEmpresarial
 * Autor: Equipo Cupi2 - 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.parqueEmpresarial.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.parqueEmpresarial.mundo.Edificio;
import uniandes.cupi2.parqueEmpresarial.mundo.Piso;

/**
 * Clase usada para verificar que los m�todos de la clase Edificio est�n correctamente implementados.
 */
public class EdificioTest 
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Edificio edificio;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Edificio vac�o.
     */
    @Before
    public void setupEscenario1( )
    {
        edificio = new Edificio( );
    }

    /**
     * Escenario 2: Construye un nuevo Edificio con un piso y dos oficinas ocupadas.
     */
    private void setupEscenario2( )
    {
        try{

            edificio = new Edificio( );
            edificio.agregarPiso( 2 );
            edificio.ocuparOficinaEnPiso( 1, "empresa1", 1 );
            edificio.ocuparOficinaEnPiso( 1, "empresa2", 2 );
        }
        catch(Exception e){
            fail("No debe generar excepci�n.");
        }

    }

    /**
     * Escenario 3: Construye un nuevo Edificio con dos pisos y dos oficinas ocupadas.
     */
    private void setupEscenario3( )
    {
        try
        {
            edificio = new Edificio( );
            edificio.agregarPiso( 2 );
            edificio.agregarPiso( 2 );
            edificio.ocuparOficinaEnPiso( 1, "empresa1", 1 );
            edificio.agregarEmpleado( "empresa1", "Emp1", "1234" );
            edificio.ocuparOficinaEnPiso( 2, "empresa2", 2 );
            edificio.agregarEmpleado( "empresa2", "Emp2", "1235" );
            edificio.agregarEmpleado( "empresa2", "Emp3", "1236" );
        }
        catch( Exception e )
        {
            fail("No debe generar excepci�n.");
        }

    }

    /**
     * Escenario 4: Construye un nuevo edificio con oficinas ocupadas, tama�o definido y empleados.
     */
    private void setupEscenario4( )
    {
        setupEscenario3( );
        try
        {
            edificio.agregarEmpleado( "empresa1","empleado1", "001" );
            edificio.buscarOficinaEmpresa( "empresa1" ).darEmpresa( ).buscarEmpleado( "001" ).registrarIngreso( );
            
            edificio.agregarEmpleado("empresa2", "empleado2", "002" );
        }
        catch( Exception e )
        {
            fail("No deber�a generar excepci�n. Revise los m�todos agregarEmpleado y buscarOficinaEmpresa.");
        }
    }
    /**
     * Prueba 1: Construye el edificio. <br>
     * <b> M�todos a probar: </b> <br>
     * darPisos<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente el Edificio con los par�metros esperados.<br>
     */
    @Test
    public void testEdificio( )
    {
        assertNotNull( "No se inicializan correctamente los pisos de edificio.", edificio.darPisos( ) );
    }

    /**
     * Prueba 2: Verifica que retorne correctamente las oficinas ocupadas.<br>
     * <b> M�todos a probar: </b> <br>
     * darOficinasOcupadas<br>
     * <b> Objetivo: </b> Probar que el m�todo darOficinasOcupadas est� bien implementado.<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se ocupan dos oficinas.
     */
    @Test
    public void testDarOficinasOcupadas( )
    {
        setupEscenario2( );
        assertEquals( "No se ocuparon correctamente las oficinas.", 2, edificio.darOficinasOcupadas( ).size( ) );
    }
    /**
     * Prueba 3: Obtener el porcentaje de ocupaci�n del edificio.<br>
     * <b> M�todos a probar: </b> <br>
     * darPorcentajeOcupacion<br>
     * desocuparOficina<br>
     * <b> Caso de prueba 1: </b> <br>
     * El edificio tiene oficinas ocupadas. <br>
     * <b> Caso de prueba 2: </b> <br>
     * El edificio no tiene pisos.
     */
    @Test
    public void testDarPorcentajeOcupacion( )
    {
        try
        {
            setupEscenario2( );
            assertEquals( "No se calcula correctamente el porcentaja con oficinas ocupadas.", ( double )100.0, edificio.darPorcentajeOcupacion( ), 0.001 );
            edificio.desocuparOficina( "empresa1" );
            assertEquals( "No se calcula correctamente el porcentaja con oficinas ocupadas.", ( double )50.0, edificio.darPorcentajeOcupacion( ), 0.001 );
            edificio.desocuparOficina( "empresa2" );
            assertEquals( "No se calcula correctamente el porcentaja con oficinas ocupadas.", ( double )0.0, edificio.darPorcentajeOcupacion( ), 0.001 );
        }
        catch( Exception e )
        {
            fail("No debe generar excepci�n.");
        }

    }

    /**
     * Prueba 4: Agregar un piso al edificio.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarPiso<br>
     * darPisos<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se agrega un piso correctamente
     */
    @Test
    public void testAgregarPiso( )
    {

        edificio.agregarPiso( 5 );
        assertEquals( "El tama�o del arreglo no aument� como esperado.", 1, edificio.darPisos( ).size( ) );
        assertEquals( "No se agreg� el piso con el n�mero de oficinas esperado.", 5, ( ( Piso )edificio.darPisos( ).get( 0 ) ).darCantidadOficinas( ) );

        edificio.agregarPiso( 10 );
        assertEquals( "El tama�o del arreglo no aument� como esperado.", 2, edificio.darPisos( ).size( ) );
        assertEquals( "No se agreg� el piso con el n�mero de oficinas esperado.", 10, ( ( Piso )edificio.darPisos( ).get( 1 ) ).darCantidadOficinas( ) );

    }

    /**
     * Prueba 5. Prueba el m�todo ocuparOficinaEnPiso.<br>
     * <b> M�todos a probar: </b> <br>
     * ocuparOficinaEnPiso<br>
     * agregarPiso<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se ocupa la oficina correctamente.<br>
     * <b> Caso de prueba 2: </b> <br>
     * Todas las oficinas del piso est�n ocupadas pero hay una de igual tama�o disponible.<br>
     * <b> Caso de prueba 3: </b> <br>
     * No hay oficinas disponibles en el piso ni en el edificio que sean del mismo tama�o.
     * <b> Caso de prueba 4: </b> <br>
     * La empresa ya tiene una oficina en el edificio.
     */
    @Test
    public void testOcuparOficinaEnPiso( )
    {
        edificio.agregarPiso( 2 );
        edificio.agregarPiso( 1 );
        edificio.agregarPiso( 2 );
        edificio.agregarPiso( 1 );
        try
        {
            edificio.ocuparOficinaEnPiso( 2, "empresa1", 1 );
            Piso piso = edificio.buscarPisoOficina( "empresa1" );
            assertNotNull("Se deber�a haber agregado la oficina exitosamente.");
            assertEquals("No se ocupo una oficina en el piso indicado.",2,piso.darNumero( ));
        }
        catch( Exception e )
        {
            fail("Se deber�a haber agregado la oficina exitosamente.");
        }
        
        // Caso de prueba 2
        try{
            edificio.ocuparOficinaEnPiso( 2, "empresa2", 2 );
            fail("Debe generar excepci�n.");
        }
        catch(Exception e){
            assertEquals("No reasign� la oficina", 2, edificio.darOficinasOcupadas( ).size( ));
            assertTrue("No reasign� correctamente la oficina.", edificio.darOficinasOcupadas( ).get( 0 ).darTamano( ) == edificio.darOficinasOcupadas( ).get( 1 ).darTamano( ));
            assertEquals("No reasign� correctamente la oficina",401, edificio.buscarOficinaEmpresa( "empresa2" ).darNumero( ));
        }
        
        // Caso de prueba 3
        try
        {
            edificio.ocuparOficinaEnPiso( 2, "empresa3", 3 );
            fail("Debe generar excepci�n.");
        }
        catch( Exception e )
        {
            assertNull("No debi� asignar oficina a la empresa.", edificio.buscarOficinaEmpresa( "empresa3" ));
            assertEquals("No debi� modificar la asignaci�n de oficinas.", 2, edificio.darOficinasOcupadas( ).size( ));
        }
        
        // Caso de prueba 4
        try
        {
            edificio.ocuparOficinaEnPiso( 1, "empresa1", 1 );
            fail("Debe generar excepci�n.");
        }
        catch( Exception e )
        {
            assertEquals("No debi� modificar la asignaci�n de oficinas.", 2, edificio.darOficinasOcupadas( ).size( ));
            Piso piso = edificio.buscarPisoOficina( "empresa1" );
            assertEquals("No se debi� modificar la oficina de la empresa.",2,piso.darNumero( ));
        }
    }

    /**
     * Prueba 6: Prueba el m�todo buscarPisoOficina.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarPisoOficina<br>
     * agregarPiso<br>
     * desocuparOficina<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se busca oficina no existente. <br>
     * <b> Caso de prueba 2: </b> <br>
     * Se busca oficina existente.
     */
    @Test
    public void testBuscarPisoOficina( )
    {
        setupEscenario2( );
        edificio.agregarPiso( 2 );
        assertEquals( "No hace la correcta b�squeda de una oficina.", 1, edificio.buscarPisoOficina( "empresa1" ).darNumero( ) );
        try
        {
            edificio.desocuparOficina( "empresa1" );
            assertNull( "No se hace el correcto control de oficina no existente.", edificio.buscarPisoOficina( "empresa1" ) );
        }
        catch( Exception e )
        {
            fail("No debe generar excepci�n.");
        }
    }

    /**
     * Prueba 7: Desocupar una oficina dado un nombre.<br>
     * <b> M�todos a probar: </b> <br>
     * desocuparOficina<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se desocupa una oficina no existente.<br>
     * <b> Caso de prueba 2: </b> <br>
     * Se desocupa una oficina existente.
     * <b> Caso de prueba 2: </b> <br>
     * Intenta desocupar una oficina con empleados adentro del edificio.
     */
    @Test
    public void testDesocuparOficina( )
    {
        setupEscenario2( );
        try
        {
            edificio.desocuparOficina( "empresa1" );
            assertNull("No desocupa correctamente la oficina.", edificio.buscarOficinaEmpresa( "empresa1" ));
            edificio.desocuparOficina( "empresa2" ) ;
            assertNull("No desocupa correctamente la oficina.", edificio.buscarOficinaEmpresa( "empresa2" ));
            assertEquals("No desocupa correctamente las oficinas.",0, edificio.darOficinasOcupadas( ).size( ));
        }
        catch( Exception e )
        {
            fail("No debe generar excepci�n.");
        }
        try
        {
            edificio.desocuparOficina( "empresa1" );
            fail("Debe generar excepci�n.");
        }
        catch( Exception e )
        {
            // Debe generar excepci�n
        }
        try
        {
            edificio.desocuparOficina( "empresa2" );
            fail("Debe generar excepci�n.");
        }
        catch( Exception e )
        {
            // Debe generar excepci�n
        }
        
        setupEscenario4( );
        try
        {
            edificio.desocuparOficina( "empresa1" );
            fail("Debe generar excepci�n.");
        }
        catch( Exception e )
        {
           assertNotNull("No debi� eliminar la oficina.", edificio.buscarOficinaEmpresa( "empresa1" ));
        }

    }

    /**
     * Prueba 8: Buscar piso con mayor de empleados.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarPisoConMayorNumeroDeEmpleados<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se busca el piso con mayor n�mero de empleados.
     */
    @Test
    public void testBuscarPisoConMayorNumeroDeEmpleados( )
    {
        setupEscenario3( );
        assertEquals( "No obtiene el piso con m�s empleados.", 2, edificio.buscarPisoConMayorNumeroDeEmpleados( ).darNumero( ) );

    }
    

    /**
     * Prueba 9: Buscar oficina de empresa.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarOficinaEmpresa<br>
     * <b> Caso de prueba 1: </b> <br>
     * Busca la oficina de una empresa que no tiene oficina en el edificio.
     * <b> Caso de prueba 2: </b> <br>
     * Busca la oficina de una empresa que tiene oficina en el edificio.
     */
    @Test
    public void testBuscarOficinaEmpresa( )
    {
        setupEscenario3( );
        // Caso de prueba 1
        assertNull("No debe encontrar ninguna oficina.", edificio.buscarOficinaEmpresa( "empresa0" ));
        
        // Caso de prueba 2
        assertNotNull("No encontr� oficina.", edificio.buscarOficinaEmpresa( "empresa1" ));
        assertNotNull("No encontr� la oficina correcta.", edificio.buscarOficinaEmpresa( "empresa1" ).darEmpresa( ));
        assertEquals("No encontr� la oficina correcta.","empresa1", edificio.buscarOficinaEmpresa( "empresa1" ).darEmpresa( ).darNombre( ) );
        
        assertNotNull("No encontr� oficina.", edificio.buscarOficinaEmpresa( "empresa2" ));
        assertNotNull("No encontr� la oficina correcta.", edificio.buscarOficinaEmpresa( "empresa2" ).darEmpresa( ));
        assertEquals("No encontr� la oficina correcta.","empresa2", edificio.buscarOficinaEmpresa( "empresa2" ).darEmpresa( ).darNombre( ) );
        
    }
    

    /**
     * Prueba 10: Agregar empleado a una empresa.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarEmpleado<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se intenta agregar un empleado a una empresa que no tiene oficina en el edificio.
     * <b> Caso de prueba 2: </b> <br>
     * Se intenta agregar un empleado que ya trabaja en el edificio.
     * <b> Caso de prueba 3: <b><br>
     * Se agrega correctamente un empleado.
     * <b> Caso de prueba 4: <b><br>
     * Si la empresa no puede garantizar el espacio minimo para los empleados en caso de recibir uno nuevo.
     */
    @Test
    public void testAgregarEmpleado( )
    {
        setupEscenario4( );
        // Caso de prueba 1
        try
        {
            edificio.agregarEmpleado( "empresa3", "empleado1", "001" );
            fail("Deber�a generar excepci�n");
        }
        catch( Exception e )
        {
            // Debe generar excepci�n
        }
        // Caso de prueba 2
        try
        {
            edificio.agregarEmpleado( "empresa2", "empleado1", "001" );
            fail("Deber�a generar excepci�n");
        }
        catch( Exception e )
        {
         // Debe generar excepci�n
        }
        // Caso de prueba 3
        try
        {
            edificio.agregarEmpleado( "empresa1", "empleado3", "003" );
        }
        catch( Exception e )
        {
            fail("No deber�a generar excepci�n.");
        }
        // Caso de prueba 4
        for(int i=4;i<63;i++){
            try
            {
                edificio.agregarEmpleado( "empresa1", "empleado"+i, "00"+i );
            }
            catch( Exception e )
            {
               fail("No deber�a generar excepcipon.");
            }
        }
        try
        {
            edificio.agregarEmpleado( "empresa1", "empleado65", "0065" );
            fail("Deber�a generar excepci�n");
        }
        catch( Exception e )
        {
            // Debe generar excepci�n
        }
        
    }


    /**
     * Prueba 11: Eliminar un empleado.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarEmpleado<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se intenta eliminar un empleado que no existe.
     * <b> Caso de prueba 2: </b> <br>
     * Se intenta eliminar un empleado que esta adentro del edificio.
     * <b> Caso de prueba 3: <b><br>
     * Se elimina correctamente el empleado.
     */
    @Test
    public void testEliminarEmpleado( ){
        setupEscenario4( );
        
        // Caso de prueba 1
        try
        {
            edificio.eliminarEmpleado( "003" );
            fail("Debe generar excepci�n.");
        }
        catch( Exception e )
        {
            // Debe generar excepci�n
        }
        // Caso de prueba 2
        try
        {
            edificio.eliminarEmpleado( "001" );
            fail("Debe generar excepci�n.");
        }
        catch( Exception e )
        {
            // Debe generar excepci�n
        }
        // Caso de prueba 3
        try
        {
            edificio.eliminarEmpleado( "002" );
        }
        catch( Exception e )
        {
            fail("No debe generar excepci�n.");
        }
        
    }


    /**
     * Prueba 11: Registrar el ingreso de un empleado.<br>
     * <b> M�todos a probar: </b> <br>
     * registrarIngreso<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se intenta ingresar un empleado que esta adentro del edificio.
     * <b> Caso de prueba 2: </b> <br>
     * Se ingresa correctamente un empleado.
     */
    @Test
    public void testRegistrarIngreso( ){
        setupEscenario4( );
        // Caso de prueba 1
        try
        {
            edificio.registrarIngreso( "001" );
            fail("Debe generar excepci�n");
        }
        catch( Exception e )
        {
            // Debe generar excepci�n
        }
        
        // Caso de prueba 2
        try
        {
            edificio.registrarIngreso( "002" );
        }
        catch( Exception e )
        {
            fail("No debe generar excepci�n");
        }
    }
    

    /**
     * Prueba 12: Registrar la salida de un empleado.<br>
     * <b> M�todos a probar: </b> <br>
     * registrarSalida<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se intenta registrar la salida un empleado que esta afuera del edificio.
     * <b> Caso de prueba 2: </b> <br>
     * Se registra correctamente la salida de un empleado.
     */
    @Test
    public void testRegistrarSalida( ){
        setupEscenario4( );
        // Caso de prueba 1
        try
        {
            edificio.registrarSalida( "002" );
            fail("Debe generar excepci�n");
        }
        catch( Exception e )
        {
            // Debe generar excepci�n
        }
        
        // Caso de prueba 2
        try
        {
            edificio.registrarSalida( "001" );
        }
        catch( Exception e )
        {
            fail("No debe generar excepci�n");
        }
    }
}