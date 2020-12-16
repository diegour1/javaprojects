/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
        empresa = new Empresa( "nombreEmpresa1", 10, 100 );

    }

    /**
     * Prueba 1: Construye la empresa.<br>
     * <b> Métodos a probar: </b> <br>
     * darNombre<br>
     * darNIT<br>
     * darNumeroEmpleados<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se construye correctamente la empresa con los parámetros esperados.
     */
    @Test
    public void testEmpresa( )
    {
        assertEquals( "El nombre de la empresa no ha sido inicializado correctamente.", "nombreEmpresa1", empresa.darNombre( ) );
        assertEquals( "El NIT de la empresa no ha sido inicializado correctamente.", 10, empresa.darNIT( ) );
        assertEquals( "El número de empleados de la empresa no ha sido inicializado correctamente.", 100, empresa.darNumeroEmpleados( ) );
    }
}
