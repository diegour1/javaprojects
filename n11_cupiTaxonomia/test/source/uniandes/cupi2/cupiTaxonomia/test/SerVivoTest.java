/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiTaxonomia
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiTaxonomia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import uniandes.cupi2.cupiTaxonomia.mundo.*;

/**
 * Clase usada para verificar la correcta implementación de la clase SerVivo.
 */
public class SerVivoTest
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private SerVivo serVivo;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un ser vivo.
     */
    @Before
    public void setupEscenario1( )
    {
        serVivo = new SerVivo( "Nombre Común", "Nombre Científico", "Características", "Imagen" );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * SerVivo <br>
     * darNombreComun <br>
     * darNombreCientifico <br>
     * darCaracteristicas <br>
     * darRutaImagen <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Crea correctamente un ser vivo con los datos dados por parámetro.
     */
    @Test
    public void testSerVivo( )
    {
        setupEscenario1( );

        assertNotNull( "El nombre común del ser vivo no fue inicializado.", serVivo.darNombreComun( ) );
        assertEquals( "El nombre común del ser vivo no fue inicializado correctamente.", "Nombre Común", serVivo.darNombreComun( ) );
        assertNotNull( "El nombre científico del ser vivo no fue inicializado.", serVivo.darNombreCientifico( ) );
        assertEquals( "El nombre científico del ser vivo no fue inicializado correctamente.", "Nombre Científico", serVivo.darNombreCientifico( ) );
        assertNotNull( "Las características del ser vivo no fueron inicializadas.", serVivo.darCaracteristicas( ) );
        assertEquals( "Las características del ser vivo no fueron inicializadas correctamente.", "Características", serVivo.darCaracteristicas( ) );
        assertNotNull( "La ruta de la imagen del ser vivo no fue inicializada.", serVivo.darRutaImagen( ) );
        assertEquals( "La ruta de la imagen del ser vivo no fue inicializada correctamente", "Imagen", serVivo.darRutaImagen( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método toString de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * toString <br>
     * darNombreComun <br>
     * darNombreCientifico <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Retorna correctamente el valor de la clase.
     */
    @Test
    public void testToString( )
    {
        setupEscenario1( );

        String toString = serVivo.toString( );
        String esperado = serVivo.darNombreCientifico( ) + " - " + serVivo.darNombreComun( );
        assertNotNull( "La representación en String del ser vivo no debería ser nula.", toString( ) );
        assertEquals( "La representación en String del ser vivo no es correcta.", esperado, toString );
    }
}