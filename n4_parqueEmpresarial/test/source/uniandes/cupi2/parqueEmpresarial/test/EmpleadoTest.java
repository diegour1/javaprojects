package uniandes.cupi2.parqueEmpresarial.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.parqueEmpresarial.mundo.Empleado;

public class EmpleadoTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Empleado empleado;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva oficina con tama�o definido.
     */
    @Before
    public void setupEscenario1( )
    {
        empleado = new Empleado( "empleado1", "123456789" );
    }

    /**
     * Prueba 1: Construye el empleado. <br>
     * <b> M�todos a probar: </b> <br>
     * darCedula<br>
     * darNombre<br>
     * estaAdentro<br>
     * darRegistro<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente el empleado con los par�metros esperados. <br>
     */
    @Test
    public void testEmpleado( )
    {
        assertEquals("No se inicializ� correctamente el nombre.", "empleado1", empleado.darNombre( ));
        assertEquals("No se inicializ� correctamente la c�dula.","123456789", empleado.darCedula( ));
        assertFalse("El empleado debe inicializarse como afuera del edificio.", empleado.estaAdentro( ));
        assertEquals("No se inicializ� correctamente el registro.","",empleado.darRegistro( ));
    }
    
    /**
     * Prueba 2: Registra el ingreso del empleado.
     * <b>M�todos a probar: </b><br>
     * registrarIngreso<br>
     * estaAdentro<br>
     * darRegistro<br>
     * <b>Caso de prueba 1: </b> <br>
     * Se registra correctamente el ingreso del empleado. <br>
     * <b>Caso de prueba 2: </b><br>
     * Se intenta registrar el ingreso del empleado estando adentro.
     */
    @Test
    public void testRegistrarIngreso(){
        // Caso de prueba 1
        
        try
        {
            empleado.registrarIngreso( );
            assertTrue("No se registro el ingreso del empleado.", empleado.estaAdentro( ));
            assertTrue("No se registro el ingreso del empleado.", empleado.darRegistro( ).contains( "INGRESO EXITOSO" ));
        }
        catch( Exception e )
        {
            fail("Debi� registrar el ingreso.");
        }
        
        // Caso de prueba 2
        try
        {
            empleado.registrarIngreso( );
            fail("No debi� registrar el ingreso.");
        }
        catch( Exception e )
        {
            assertTrue("No debi� modificar el ingreso del empleado.", empleado.estaAdentro( ));
            assertTrue("No registro el intento de ingreso del empleado.", empleado.darRegistro( ).contains( "INGRESO FALLIDO" ));
        }
        
    }
    
    
    /**
     * Prueba 3: Registra la salida del empleado.
     * <b>M�todos a probar: </b><br>
     * registrarSalida<br>
     * estaAdentro<br>
     * darRegistro<br>
     * <b>Caso de prueba 1: </b> <br>
     * Se intenta registrar la salida del empleado estando afuera.
     * <b>Caso de prueba 2: </b><br>
     * Se registra correctamente la salida del empleado. <br>
     */
    @Test
    public void testRegistrarSalida(){
        // Caso de prueba 1
        
        try
        {
            empleado.registrarSalida( );
            fail("No debi� registrar la salida.");
        }
        catch( Exception e )
        {
            assertTrue("El empleado debe estar fuera del edificio.", !empleado.estaAdentro( ));
            assertTrue("No se registro el intento de salida del empleado.", empleado.darRegistro( ).contains( "SALIDA FALLIDA" ));
        }
        
        // Caso de prueba 2
        try
        {
            empleado.registrarIngreso( );
            empleado.registrarSalida( );
            
            assertTrue("No se registro la salida del empleado.", !empleado.estaAdentro( ));
            assertTrue("No se registro el ingreso del empleado.", empleado.darRegistro( ).contains( "SALIDA EXITOSA" ));
        }
        catch( Exception e )
        {
           fail("No debe generar excepci�n");
        }
        
    }
}
