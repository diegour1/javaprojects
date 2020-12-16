/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_parqueEmpresarial
 * Autor: Equipo Cupi2 - 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.parqueEmpresarial.test;

import uniandes.cupi2.parqueEmpresarial.mundo.Empresa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * Clase usada para verificar que los m�todos de la clase Empresa est�n correctamente implementados.
 */
public class EmpresaTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Empresa empresa;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva empresa con su nombre, NIT y n�mero de empleados definidos.
     */
    @Before
    public void setupEscenario1( )
    {
        empresa = new Empresa( "nombreEmpresa1", 10, 100 );

    }

    /**
     * Prueba 1: Construye la empresa.<br>
     * <b> M�todos a probar: </b> <br>
     * darNombre<br>
     * darNIT<br>
     * darNumeroEmpleados<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente la empresa con los par�metros esperados.
     */
    @Test
    public void testEmpresa( )
    {
        assertEquals( "El nombre de la empresa no ha sido inicializado correctamente.", "nombreEmpresa1", empresa.darNombre( ) );
        assertEquals( "El NIT de la empresa no ha sido inicializado correctamente.", 10, empresa.darNIT( ) );
        assertEquals( "El n�mero de empleados de la empresa no ha sido inicializado correctamente.", 100, empresa.darNumeroEmpleados( ) );
    }
}
