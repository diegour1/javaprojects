/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_cupiTrenes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTrenes.test;

import java.util.Date;

import uniandes.cupi2.cupiTrenes.mundo.Parada;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Clase usada para verificar la correcta implementación de Parada.
 */
public class ParadaTest
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Parada parada;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea una nueva parada.
     */
    @Before
    public void setupEscenario1( )
    {
        Date horario = new Date( );
        horario.setHours( 2 );
        horario.setMinutes( 0 );
        parada = new Parada( "Munich", horario );
    }
    
    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Parada <br>
     * darNombre <br>
     * darHorario <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Construye correctamente la parada del escenario 1, cada uno de los valores corresponde al esperado.
     */
    @Test
    public void testParada( )
    {
        assertEquals( "No inicializó el nombre de la parada correctamente.", "Munich", parada.darNombre( ) );
        assertEquals( "No inicializó el horario de la parada correctamente.", "02:00", parada.darHorario( ) );
    }

}
