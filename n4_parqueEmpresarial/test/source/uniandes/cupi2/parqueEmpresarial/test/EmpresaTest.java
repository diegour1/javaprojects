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

import uniandes.cupi2.parqueEmpresarial.mundo.Empleado;
import uniandes.cupi2.parqueEmpresarial.mundo.Empresa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Clase usada para verificar que los métodos de la clase Empresa estén correctamente implementados.
 */
public class EmpresaTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Empresa empresa;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva empresa con su nombre, NIT y número de empleados definidos.
     */
    @Before
    public void setupEscenario1( )
    {
        empresa = new Empresa( "nombreEmpresa1", 10 );
    }
    
    public void setupEscenario2( )
    {
        empresa = new Empresa( "nombreEmpresa1", 10 );
        for(int i=0;i<100;i++){
            try
            {
                empresa.agregarEmpleado( "empleado"+i, "000"+i );
            }
            catch( Exception e )
            {
                fail("No debe generar excepción. Revise el método agregarEmpleado");
            }
        }
    }

    /**
     * Prueba 1: Construye la empresa.<br>
     * <b> Métodos a probar: </b> <br>
     * darNombre<br>
     * darNIT<br>
     * darEmpleados <br>
     * darNumeroEmpleados<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente la empresa con los parámetros esperados.
     */
    @Test
    public void testEmpresa( )
    {
        setupEscenario1( );
        assertEquals( "El nombre de la empresa no ha sido inicializado correctamente.", "nombreEmpresa1", empresa.darNombre( ) );
        assertEquals( "El NIT de la empresa no ha sido inicializado correctamente.", 10, empresa.darNIT( ) );
        assertEquals( "El número de empleados de la empresa no ha sido inicializado correctamente.", 0, empresa.darNumeroEmpleados( ) );
        assertNotNull("La lista de empleados no se inicializó.", empresa.darEmpleados( ));
    }
    
    /**
     * Prueba 2: Agrega un nuevo empleado a la empresa.<br>
     * <b>Métodos a probar:</b><br>
     * agregarEmpleado<br>
     * buscarEmpleado<br>
     * <b>Caso de prueba 1:</b><br>
     * Se agrega correctamente un empleado.<br>
     * <b>Caso de prueba 2:</b><br>
     * Se intenta agregar un empleado con la cedula de un empleado existente.
     */
    @Test
    public void testAgregarEmpleado(){
        // Caso de prueba 1
        try
        {
            empresa.agregarEmpleado( "empleado1", "1234" );
            assertEquals("No se agregó correctamente al empleado.", 1, empresa.darNumeroEmpleados( ));
            
        }
        catch( Exception e )
        {
           fail("No debe generar excepción.");
        }
        
        // Caso de prueba 2
        try
        {
            empresa.agregarEmpleado( "empleado", "1234" );
            fail("Debe generar excepción");
            
        }
        catch( Exception e )
        {
            assertEquals("No se debió agregar al empleado.", 1, empresa.darNumeroEmpleados( ));
        }
    }
    
    /**
     * Prueba 2: Busca un nuevo empleado de la empresa usando la cédula.<br>
     * <b>Métodos a probar:</b><br>
     * buscarEmpleado<br>
     * <b>Caso de prueba 1:</b><br>
     * Se busca un empleado existente.<br>
     * <b>Caso de prueba 2:</b><br>
     * Se busca un empleado no existente.
     */
    @Test
    public void testBuscarEmpleado(){
        setupEscenario2( );
        
        // Caso de prueba 1
        for(int i=0;i<empresa.darNumeroEmpleados( );i++){
            try
            {
                Empleado buscado = empresa.buscarEmpleado( "000"+i );
                assertNotNull("No se encontró al empleado.", buscado);
                assertEquals("El elemento retornado no es el buscado.", "empleado"+i, buscado.darNombre( ));
                assertEquals("El elemento retornado no es el buscado.", "000"+i, buscado.darCedula( ));
            }
            catch( Exception e )
            {
                fail("No debería generar excepción.");
            }
        }
        
        // Caso de prueba 2
        try
        {
            empresa.buscarEmpleado( "000101" );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            //Debe generar excepción
        }
    }

    /**
     * Prueba 2: Prueba el método darNumeroEmpleados.<br>
     * <b>Métodos a probar:</b><br>
     * darNumeroEmpleados<br>
     * <b>Caso de prueba 1:</b><br>
     * No hay empleados.<br>
     * <b>Caso de prueba 2:</b><br>
     * Hay varios empleados.
     */
    @Test
    public void testDarNumeroEmpleados(){
        // Caso de prueba 1
        assertEquals("El valor retornado no es correcto.",0,empresa.darNumeroEmpleados( ));
        
        // Caso de prueba 2
        setupEscenario2( );
        assertEquals("El valor retornado no es correcto.",100,empresa.darNumeroEmpleados( ));
    }
    

    /**
     * Prueba 3: Prueba el método eliminarEmpleado.<br>
     * <b>Métodos a probar:</b><br>
     * eliminarEmpleado<br>
     * buscarEmpleado<br>
     * darNumeroEmpleados<br>
     * <b>Caso de prueba 1:</b><br>
     * Elimina un empleado existente.<br>
     * <b>Caso de prueba 2:</b><br>
     * Intenta eliminar un empleado no existente.
     */
    @Test
    public void testEliminarEmpleado(){
        setupEscenario2( );
        // Caso de prueba 1
        int totalEmpleados = empresa.darNumeroEmpleados( );
        while(totalEmpleados-->1){
            try
            {
                String cedula =  "000"+(totalEmpleados) ;
                empresa.eliminarEmpleado( cedula );
                try
                {
                    empresa.buscarEmpleado( cedula );
                }
                catch( Exception e )
                {
                    // Debe generar excepción.
                }
                assertEquals("No se eliminó correctamente al empleado.", totalEmpleados, empresa.darNumeroEmpleados( ));
            }
            catch( Exception e )
            {
                fail("No debería generar excepción: "+e.getMessage( ));
            }
        }
        
        // Caso de prueba 2
        setupEscenario2( );
        try
        {
            empresa.eliminarEmpleado( "000100" );
            fail("Debe generar excepción.");
        }
        catch( Exception e )
        {
            assertEquals("No debió eliminar al empleado.", 100, empresa.darNumeroEmpleados( ));
        }
    }
}
