/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_cupiDeportes
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiDeportes.test;

import uniandes.cupi2.cupiDeportes.mundo.Deportista;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Clase usada para verificar que los m�todos de la clase Deportista est�n correctamente implementados.
 */
public class DeportistaTest 
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Deportista deportista;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo deportista.s
     */
    @Before
    public void setupEscenario1( )
    {

        deportista = new Deportista( "James", 23, "Madrid", 39, "imagen" );

    }

    /**
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
     * constructor<br>
     * darNombre<br>
     * darLugarResidencia<br>
     * darCantidadTrofeos<br>
     * darRutaImagen<br>
     * darEdad<br>
     * <b> Objetivo: </b> Probar inicializaci�n correcta del objeto Deportista<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Inicializaci�n correcta de Deportista<br>
     */
    @Test
    public void testConstructor( )
    {
        assertEquals( "El nombre del deportista es incorrecto.", "James", deportista.darNombre( ) );
        assertEquals( "La edad del deportista es incorrecta.", 23, deportista.darEdad( ) );
        assertEquals( "El lugar de residencia del deportista es incorrecto.", "Madrid", deportista.darLugarResidencia( ) );
        assertEquals( "La ruta a la imagen del deportista es incorrecta.", "imagen", deportista.darRutaImagen( ) );
        assertEquals( "La cantidad de trofeos del deportista es incorrecta.", 39, deportista.darCantidadTrofeos( ) );
    }

    /**
     * Prueba 2: Verifica el m�todo cambiarEdad.<br>
     * <b> M�todos a probar: </b> <br>
     * cambiarEdad<br>
     * darEdad <b><br>
     * Objetivo: </b> Probar funcionamiento correcta del m�todo cambiarEdad<br>
     * <b> Resultados esperados: </b> <br>
     * 1. La edad fue cambiada correctamente.<br>
     */
    @Test
    public void testCambiarEdad( )
    {
        deportista.cambiarEdad( 30 );
        assertEquals( "La edad del deportista es incorrecta.", 30, deportista.darEdad( ) );

    }

    /**
     * Prueba 3: Verifica el m�todo cambiarLugarResidencia.<br>
     * <b> M�todos a probar: </b> <br>
     * cambiarLugarResidencia<br>
     * darLugarResidencia<br>
     * <b> Objetivo: </b> Probar funcionamiento correcta del m�todo cambiarLugarResidencia<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El lugar de residencia fue cambiado correctamente.<br>
     */
    @Test
    public void testCambiarLugarResidencia( )
    {
        deportista.cambiarLugarResidencia( "Bogot�" );
        assertEquals( "El lugar de residencia del deportista es incorrecto.", "Bogot�", deportista.darLugarResidencia( ) );

    }

    /**
     * Prueba 4: Verifica el m�todo cambiarCantidadTrofeos.<br>
     * <b> M�todos a probar: </b> <br>
     * cambiarCantidadTrofeos<br>
     * darCantidadTrofeos <br>
     * <b> Objetivo: </b> Probar funcionamiento correcta del m�todo cambiarCantidadTrofeos<br>
     * <b> Resultados esperados: </b> <br>
     * 1. La cantidad de trofeos fue cambiada correctamente.<br>
     */
    @Test
    public void testCambiarCantidadTrofeos( )
    {
        deportista.cambiarCantidadTrofeos( 10 );
        assertEquals( "La cantidad detrofeos del deportista es incorrecta.", 10, deportista.darCantidadTrofeos( ) );

    }

    /**
     * Prueba 5: Verifica el m�todo cambiarRutaImagen.<br>
     * <b> M�todos a probar: </b> <br>
     * cambiarRutaImagen<br>
     * darRutaImagen<br>
     * <b> Objetivo: </b> Probar funcionamiento correcta del m�todo cambiarRutaImagen<br>
     * <b> Resultados esperados: </b> <br>
     * 1. La ruta de la imagen fue cambiada correctamente.<br>
     */
    @Test
    public void testCambiarRutaImagen( )
    {
        deportista.cambiarRutaImagen( "imagen2" );
        assertEquals( "La ruta de la imagen del deportista es incorrecta.", "imagen2", deportista.darRutaImagen( ) );

    }

}