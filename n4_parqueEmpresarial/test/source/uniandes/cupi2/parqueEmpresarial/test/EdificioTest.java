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

package uniandes.cupi2.parqueEmpresarial.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.parqueEmpresarial.mundo.Edificio;
import uniandes.cupi2.parqueEmpresarial.mundo.Piso;

/**
 * Clase usada para verificar que los métodos de la clase Edificio estén correctamente implementados.
 */
public class EdificioTest 
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Edificio edificio;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Edificio vacío.
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
            fail("No debe generar excepción.");
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
            fail("No debe generar excepción.");
        }

    }

    /**
     * Escenario 4: Construye un nuevo edificio con oficinas ocupadas, tamaño definido y empleados.
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
            fail("No debería generar excepción. Revise los métodos agregarEmpleado y buscarOficinaEmpresa.");
        }
    }
    /**
     * Prueba 1: Construye el edificio. <br>
     * <b> Métodos a probar: </b> <br>
     * darPisos<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente el Edificio con los parámetros esperados.<br>
     */
    @Test
    public void testEdificio( )
    {
        assertNotNull( "No se inicializan correctamente los pisos de edificio.", edificio.darPisos( ) );
    }

    /**
     * Prueba 2: Verifica que retorne correctamente las oficinas ocupadas.<br>
     * <b> Métodos a probar: </b> <br>
     * darOficinasOcupadas<br>
     * <b> Objetivo: </b> Probar que el método darOficinasOcupadas esté bien implementado.<br>
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
     * Prueba 3: Obtener el porcentaje de ocupación del edificio.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail("No debe generar excepción.");
        }

    }

    /**
     * Prueba 4: Agregar un piso al edificio.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarPiso<br>
     * darPisos<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se agrega un piso correctamente
     */
    @Test
    public void testAgregarPiso( )
    {

        edificio.agregarPiso( 5 );
        assertEquals( "El tamaño del arreglo no aumentó como esperado.", 1, edificio.darPisos( ).size( ) );
        assertEquals( "No se agregó el piso con el número de oficinas esperado.", 5, ( ( Piso )edificio.darPisos( ).get( 0 ) ).darCantidadOficinas( ) );

        edificio.agregarPiso( 10 );
        assertEquals( "El tamaño del arreglo no aumentó como esperado.", 2, edificio.darPisos( ).size( ) );
        assertEquals( "No se agregó el piso con el número de oficinas esperado.", 10, ( ( Piso )edificio.darPisos( ).get( 1 ) ).darCantidadOficinas( ) );

    }

    /**
     * Prueba 5. Prueba el método ocuparOficinaEnPiso.<br>
     * <b> Métodos a probar: </b> <br>
     * ocuparOficinaEnPiso<br>
     * agregarPiso<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se ocupa la oficina correctamente.<br>
     * <b> Caso de prueba 2: </b> <br>
     * Todas las oficinas del piso están ocupadas pero hay una de igual tamaño disponible.<br>
     * <b> Caso de prueba 3: </b> <br>
     * No hay oficinas disponibles en el piso ni en el edificio que sean del mismo tamaño.
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
            assertNotNull("Se debería haber agregado la oficina exitosamente.");
            assertEquals("No se ocupo una oficina en el piso indicado.",2,piso.darNumero( ));
        }
        catch( Exception e )
        {
            fail("Se debería haber agregado la oficina exitosamente.");
        }
        
        // Caso de prueba 2
        try{
            edificio.ocuparOficinaEnPiso( 2, "empresa2", 2 );
            fail("Debe generar excepción.");
        }
        catch(Exception e){
            assertEquals("No reasignó la oficina", 2, edificio.darOficinasOcupadas( ).size( ));
            assertTrue("No reasignó correctamente la oficina.", edificio.darOficinasOcupadas( ).get( 0 ).darTamano( ) == edificio.darOficinasOcupadas( ).get( 1 ).darTamano( ));
            assertEquals("No reasignó correctamente la oficina",401, edificio.buscarOficinaEmpresa( "empresa2" ).darNumero( ));
        }
        
        // Caso de prueba 3
        try
        {
            edificio.ocuparOficinaEnPiso( 2, "empresa3", 3 );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            assertNull("No debió asignar oficina a la empresa.", edificio.buscarOficinaEmpresa( "empresa3" ));
            assertEquals("No debió modificar la asignación de oficinas.", 2, edificio.darOficinasOcupadas( ).size( ));
        }
        
        // Caso de prueba 4
        try
        {
            edificio.ocuparOficinaEnPiso( 1, "empresa1", 1 );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            assertEquals("No debió modificar la asignación de oficinas.", 2, edificio.darOficinasOcupadas( ).size( ));
            Piso piso = edificio.buscarPisoOficina( "empresa1" );
            assertEquals("No se debió modificar la oficina de la empresa.",2,piso.darNumero( ));
        }
    }

    /**
     * Prueba 6: Prueba el método buscarPisoOficina.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertEquals( "No hace la correcta búsqueda de una oficina.", 1, edificio.buscarPisoOficina( "empresa1" ).darNumero( ) );
        try
        {
            edificio.desocuparOficina( "empresa1" );
            assertNull( "No se hace el correcto control de oficina no existente.", edificio.buscarPisoOficina( "empresa1" ) );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción.");
        }
    }

    /**
     * Prueba 7: Desocupar una oficina dado un nombre.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail("No debe generar excepción.");
        }
        try
        {
            edificio.desocuparOficina( "empresa1" );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            // Debe generar excepciòn
        }
        try
        {
            edificio.desocuparOficina( "empresa2" );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            // Debe generar excepciòn
        }
        
        setupEscenario4( );
        try
        {
            edificio.desocuparOficina( "empresa1" );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
           assertNotNull("No debió eliminar la oficina.", edificio.buscarOficinaEmpresa( "empresa1" ));
        }

    }

    /**
     * Prueba 8: Buscar piso con mayor de empleados.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarPisoConMayorNumeroDeEmpleados<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se busca el piso con mayor número de empleados.
     */
    @Test
    public void testBuscarPisoConMayorNumeroDeEmpleados( )
    {
        setupEscenario3( );
        assertEquals( "No obtiene el piso con más empleados.", 2, edificio.buscarPisoConMayorNumeroDeEmpleados( ).darNumero( ) );

    }
    

    /**
     * Prueba 9: Buscar oficina de empresa.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertNotNull("No encontró oficina.", edificio.buscarOficinaEmpresa( "empresa1" ));
        assertNotNull("No encontró la oficina correcta.", edificio.buscarOficinaEmpresa( "empresa1" ).darEmpresa( ));
        assertEquals("No encontró la oficina correcta.","empresa1", edificio.buscarOficinaEmpresa( "empresa1" ).darEmpresa( ).darNombre( ) );
        
        assertNotNull("No encontró oficina.", edificio.buscarOficinaEmpresa( "empresa2" ));
        assertNotNull("No encontró la oficina correcta.", edificio.buscarOficinaEmpresa( "empresa2" ).darEmpresa( ));
        assertEquals("No encontró la oficina correcta.","empresa2", edificio.buscarOficinaEmpresa( "empresa2" ).darEmpresa( ).darNombre( ) );
        
    }
    

    /**
     * Prueba 10: Agregar empleado a una empresa.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail("Debería generar excepción");
        }
        catch( Exception e )
        {
            // Debe generar excepción
        }
        // Caso de prueba 2
        try
        {
            edificio.agregarEmpleado( "empresa2", "empleado1", "001" );
            fail("Debería generar excepción");
        }
        catch( Exception e )
        {
         // Debe generar excepción
        }
        // Caso de prueba 3
        try
        {
            edificio.agregarEmpleado( "empresa1", "empleado3", "003" );
        }
        catch( Exception e )
        {
            fail("No debería generar excepción.");
        }
        // Caso de prueba 4
        for(int i=4;i<63;i++){
            try
            {
                edificio.agregarEmpleado( "empresa1", "empleado"+i, "00"+i );
            }
            catch( Exception e )
            {
               fail("No debería generar excepcipon.");
            }
        }
        try
        {
            edificio.agregarEmpleado( "empresa1", "empleado65", "0065" );
            fail("Debería generar excepción");
        }
        catch( Exception e )
        {
            // Debe generar excepción
        }
        
    }


    /**
     * Prueba 11: Eliminar un empleado.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            // Debe generar excepción
        }
        // Caso de prueba 2
        try
        {
            edificio.eliminarEmpleado( "001" );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            // Debe generar excepción
        }
        // Caso de prueba 3
        try
        {
            edificio.eliminarEmpleado( "002" );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción.");
        }
        
    }


    /**
     * Prueba 11: Registrar el ingreso de un empleado.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail("Debe generar excepción");
        }
        catch( Exception e )
        {
            // Debe generar excepción
        }
        
        // Caso de prueba 2
        try
        {
            edificio.registrarIngreso( "002" );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción");
        }
    }
    

    /**
     * Prueba 12: Registrar la salida de un empleado.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail("Debe generar excepción");
        }
        catch( Exception e )
        {
            // Debe generar excepción
        }
        
        // Caso de prueba 2
        try
        {
            edificio.registrarSalida( "001" );
        }
        catch( Exception e )
        {
            fail("No debe generar excepción");
        }
    }
}