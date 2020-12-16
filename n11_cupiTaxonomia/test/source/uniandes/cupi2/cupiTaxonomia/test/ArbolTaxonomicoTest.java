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

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.cupiTaxonomia.mundo.*;

/**
 * Clase usada para verificar la correcta implementación de la clase ArbolTaxonomico.
 */
public class ArbolTaxonomicoTest
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------
    
    /**
     * Constante que representa la ruta del archivo donde se guarda y se carga la información.
     */
    private final static String RUTA = "./test/data/test.data";
    
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private ArbolTaxonomico arbolTaxonomico;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un árbol taxonómico vacío.
     */
    @Before
    public void setupEscenario1( )
    {
        try
        {
            arbolTaxonomico = new ArbolTaxonomico( "" );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error " + e.getMessage( ) + "." );
        }
    }
    
    /**
     * Escenario 2: Crea un árbol taxonómico a partir de un archivo.
     */
    @Test
    public void setupEscenario2( )
    {
        try
        {
            arbolTaxonomico = new ArbolTaxonomico( RUTA );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error " + e.getMessage( ) + "." );
        }
    }

    /**
     * Escenario 3: Crea un árbol taxonómico con taxones.
     */
    @Test
    public void setupEscenario3( )
    {
        try
        {
            arbolTaxonomico = new ArbolTaxonomico( "" );
            arbolTaxonomico.agregarTaxon( "Último antepasado común universal", Taxon.DOMINIO, "Dominio 1" );
            arbolTaxonomico.agregarTaxon( "Último antepasado común universal", Taxon.DOMINIO, "Dominio 2" );
            arbolTaxonomico.agregarTaxon( "Dominio 1", Taxon.REINO, "Reino 1" );
            arbolTaxonomico.agregarTaxon( "Dominio 2", Taxon.REINO, "Reino 2" );
            arbolTaxonomico.agregarTaxon( "Dominio 2", Taxon.REINO, "Reino 3" );
            arbolTaxonomico.agregarTaxon( "Reino 2", Taxon.FILO, "Filo 1" );
            arbolTaxonomico.agregarTaxon( "Reino 2", Taxon.FILO, "Filo 2" );
            arbolTaxonomico.agregarTaxon( "Reino 3", Taxon.FILO, "Filo 3" );
            arbolTaxonomico.agregarTaxon( "Filo 1", Taxon.CLASE, "Clase 1" );
            arbolTaxonomico.agregarTaxon( "Filo 1", Taxon.CLASE, "Clase 2" );
            arbolTaxonomico.agregarTaxon( "Filo 2", Taxon.CLASE, "Clase 3" );
            arbolTaxonomico.agregarTaxon( "Clase 1", Taxon.ORDEN, "Orden 1" );
            arbolTaxonomico.agregarTaxon( "Clase 2", Taxon.ORDEN, "Orden 2" );
            arbolTaxonomico.agregarTaxon( "Clase 3", Taxon.ORDEN, "Orden 3" );
            arbolTaxonomico.agregarTaxon( "Orden 1", Taxon.FAMILIA, "Familia 1" );
            arbolTaxonomico.agregarTaxon( "Familia 1", Taxon.GENERO, "Genero 1" );
            arbolTaxonomico.agregarTaxon( "Genero 1", Taxon.ESPECIE, "Especie 1" );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error " + e.getMessage( ) );
        }
    }

    /**
     * Escenario 4: Crea un árbol taxonómico con taxones y seres vivos.
     */
    @Test
    public void setupEscenario4( )
    {
        try
        {
            arbolTaxonomico = new ArbolTaxonomico( "" );
            arbolTaxonomico.agregarTaxon( "Último antepasado común universal", Taxon.DOMINIO, "Dominio 1" );
            arbolTaxonomico.agregarTaxon( "Último antepasado común universal", Taxon.DOMINIO, "Dominio 2" );
            arbolTaxonomico.agregarTaxon( "Dominio 1", Taxon.REINO, "Reino 1" );
            arbolTaxonomico.agregarTaxon( "Dominio 2", Taxon.REINO, "Reino 2" );
            arbolTaxonomico.agregarTaxon( "Dominio 2", Taxon.REINO, "Reino 3" );
            arbolTaxonomico.agregarTaxon( "Reino 2", Taxon.FILO, "Filo 1" );
            arbolTaxonomico.agregarTaxon( "Reino 2", Taxon.FILO, "Filo 2" );
            arbolTaxonomico.agregarTaxon( "Reino 3", Taxon.FILO, "Filo 3" );
            arbolTaxonomico.agregarTaxon( "Filo 1", Taxon.CLASE, "Clase 1" );
            arbolTaxonomico.agregarTaxon( "Filo 1", Taxon.CLASE, "Clase 2" );
            arbolTaxonomico.agregarTaxon( "Filo 2", Taxon.CLASE, "Clase 3" );
            arbolTaxonomico.agregarTaxon( "Clase 1", Taxon.ORDEN, "Orden 1" );
            arbolTaxonomico.agregarTaxon( "Clase 2", Taxon.ORDEN, "Orden 2" );
            arbolTaxonomico.agregarTaxon( "Clase 3", Taxon.ORDEN, "Orden 3" );
            arbolTaxonomico.agregarTaxon( "Orden 1", Taxon.FAMILIA, "Familia 1" );
            arbolTaxonomico.agregarTaxon( "Orden 1", Taxon.FAMILIA, "Familia 2" );
            arbolTaxonomico.agregarTaxon( "Orden 3", Taxon.FAMILIA, "Familia 3" );
            arbolTaxonomico.agregarTaxon( "Familia 2", Taxon.GENERO, "Genero 1" );
            arbolTaxonomico.agregarTaxon( "Familia 3", Taxon.GENERO, "Genero 2" );
            arbolTaxonomico.agregarTaxon( "Genero 1", Taxon.ESPECIE, "Especie 1" );
            arbolTaxonomico.agregarTaxon( "Genero 1", Taxon.ESPECIE, "Especie 2" );
            arbolTaxonomico.agregarTaxon( "Genero 1", Taxon.ESPECIE, "Especie 3" );
            arbolTaxonomico.agregarTaxon( "Genero 2", Taxon.ESPECIE, "Especie 4" );
            arbolTaxonomico.agregarTaxon( "Genero 2", Taxon.ESPECIE, "Especie 5" );
            arbolTaxonomico.agregarSerVivo( "Especie 1", "Común 1", "Científico 1", "Características", "Imagen" );
            arbolTaxonomico.agregarSerVivo( "Especie 2", "Común 2", "Científico 2", "Características", "Imagen" );
            arbolTaxonomico.agregarSerVivo( "Especie 4", "Común 3", "Científico 3", "Características", "Imagen" );
            arbolTaxonomico.agregarSerVivo( "Especie 5", "Común 4", "Científico 4", "Características", "Imagen" );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error " + e.getMessage( ) );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * ArbolTaxonomico <br>
     * darTaxonRaiz <br>
     * darNumTaxones <br>
     * darNumSeresVivos <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se construye un árbol taxonómico vacío correctamente. <br>
     */
    @Test
    public void testArbolTaxonomico1( )
    {
        setupEscenario1( );
        assertNotNull( "La categoría raíz no fue inicializada. El taxón raíz del árbol no puede ser nula.", arbolTaxonomico.darTaxonRaiz( ) );       
    }
    
    /**
     * Prueba 2: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * ArbolTaxonomico <br>
     * darTaxonRaiz <br>
     * darNumTaxones <br>
     * darNumSeresVivos <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se construye un árbol taxonómico a partir de un archivo.
     */
    @Test
    public void testArbolTaxonomico2( )
    {
        setupEscenario2( );
        assertEquals( "El árbol no fue inicializado correctamente. Existen 36 taxones en el árbol.", 36, arbolTaxonomico.darNumTaxones( ) );
        assertEquals( "El árbol no fue inicializado correctamente. Existen 4 seres vivos en el árbol.", 4, arbolTaxonomico.darNumSeresVivos( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método agregarTaxon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarTaxon <br>
     * darTaxonRaiz <br>
     * darNumTaxones <br>
     * <b> Casos de prueba: </b> 
     * 1. Se agrega correctamente un sub-taxón al taxón actual. <br>
     * 2. Se agrega correctamente un taxón nieto.
     */
    @Test
    public void testAgregarTaxon( )
    {
        setupEscenario1( );
        try
        {
            // Caso de prueba 1.
            arbolTaxonomico.agregarTaxon( "Último antepasado común universal", Taxon.DOMINIO, "Dominio 1" );
            Taxon raiz = arbolTaxonomico.darTaxonRaiz( );
            assertEquals( "No se agregó correctamente el taxón. El taxón raíz debe tenede 1 subtaxón.", 1, raiz.darSubTaxones( ).size( ) );
            
            // Caso de prueba 2.
            arbolTaxonomico.agregarTaxon( "Dominio 1", Taxon.REINO, "Reino 1" );
            assertEquals( "No se agregó correctamente el taxón. Deben haber 3 taxones en el árbol.", 3, arbolTaxonomico.darNumTaxones( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }
    }

    /**
     * Prueba 4: Se encarga de verificar el método agregarTaxon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarTaxon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta agregar un taxón existente.
     */
    @Test
    public void testAgregarTaxonError( )
    {
        setupEscenario3( );
        try
        {
            arbolTaxonomico.agregarTaxon( "Último antepasado común universal", Taxon.DOMINIO, "Dominio 1" );
            fail( "No debería agregar el taxón pues ya existe un taxón con ese nombre." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
        }
    }

    /**
     * Prueba 5: Se encarga de verificar el método eliminarTaxon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarTaxon <br>
     * darNumTaxones <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se intenta eliminar exitosamente un taxón. <br>
     * 2. Se intenta eliminar un taxón que no existe.
     */
    @Test
    public void testEliminarTaxon( )
    {
        setupEscenario3( );
        arbolTaxonomico.eliminarTaxon( Taxon.CLASE, "Clase 1" );
        assertEquals( "El taxón no fue eliminado correctamente. Deben existir 13 taxones en el árbol.", 13, arbolTaxonomico.darNumTaxones( ) );
        
        arbolTaxonomico.eliminarTaxon( Taxon.REINO, "Reino 4" );
        assertEquals( "El taxón no debería ser eliminado. Deben existir 13 taxones en el árbol.", 13, arbolTaxonomico.darNumTaxones( ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el método agregarSerVivo de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarSerVivo <br>
     * darNumSeresVivos <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Agrega correctamente al ser vivo.
     */
    @Test
    public void testAgregarSerVivo( )
    {
        setupEscenario3( );
        try
        {
            arbolTaxonomico.agregarSerVivo( "Especie 1", "Común", "Científico", "Características", "Imagen" );
            assertEquals( "No se agregó correctamente el ser vivo. Debe haber 1 ser vivo en el árbol.", 1, arbolTaxonomico.darNumSeresVivos( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }
    }

    /**
     * Prueba 7: Se encarga de verificar el método agregarSerVivo de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarSerVivo <br>
     * darNumSeresVivos <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ya existe un ser vivo con el mismo nombre científico.
     */
    @Test
    public void testAgregarSerVivoError( )
    {
        setupEscenario4( );

        try
        {
            arbolTaxonomico.agregarSerVivo( "Especie 1", "Común", "Científico 3", "Características", "Imagen" );
            fail( "No debería agregar el ser vivo pues ya existe un ser vivo con el mismo nombre científico." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el método darNumTaxones de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darNumTaxones <br>
     * agregarTaxon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula correctamente el número de taxones en el árbol.
     */
    @Test
    public void testDarNumTaxones( )
    {
        setupEscenario3( );
        int numTaxones = arbolTaxonomico.darNumTaxones( );
        assertEquals( "El número de taxones no es calculado correctamente. Debe haber 18 taxones en el árbol", 18, numTaxones );
        
        try
        {
            arbolTaxonomico.agregarTaxon( "Reino 3", Taxon.FILO, "Filo 4" );
            numTaxones = arbolTaxonomico.darNumTaxones( );
            assertEquals( "El número de taxones no es calculado correctamente. Debe haber 19 taxones en el árbol", 19, numTaxones );
            
            arbolTaxonomico.agregarTaxon( "Reino 3", Taxon.FILO, "Filo 5" );
            arbolTaxonomico.agregarTaxon( "Reino 3", Taxon.FILO, "Filo 6" );
            numTaxones = arbolTaxonomico.darNumTaxones( );
            assertEquals( "El número de taxones no es calculado correctamente. Debe haber 21 taxones en el árbol", 21, numTaxones );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el método darNumSeresVivos de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darNumSeresVivos <br>
     * agregarSerVivo <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula correctamente el número de seres vivos en el árbol.
     */
    @Test
    public void testDarNumSeresVivos( )
    {
        setupEscenario4( );
        int numSeresVivos = arbolTaxonomico.darNumSeresVivos( );
        assertEquals( "El número de seres vivos no es calculado correctamente. Debe haber 4 seres vivos en el árbol.", 4, numSeresVivos );
        
        try
        {
            arbolTaxonomico.agregarSerVivo( "Especie 3", "Común 5", "Científico 5", "Características", "Imagen" );
            numSeresVivos = arbolTaxonomico.darNumSeresVivos( );
            assertEquals( "El número de seres vivos no es calculado correctamente. Debe haber 5 seres vivos en el árbol.", 5, numSeresVivos );
            
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el método darSeresVivos de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darSeresVivos <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Retorna la lista de seres vivos de un sub-árbol que tiene seres vivos. <br>
     * 2. Retorna la lista de seres vivos de un sub-árbol que no tiene seres vivos.
     */
    @Test
    public void testDarSeresVivos( )
    {
        setupEscenario4( );
        
        // Caso de prueba 1.
        ArrayList<SerVivo> seresVivos = arbolTaxonomico.darSeresVivos( Taxon.FAMILIA, "Familia 2" );
        assertEquals( "El número de seres vivos encontrados no es correcto. Debe haber 2 seres vivos en la lista.", 2, seresVivos.size( ) );

        // Caso de prueba 2.
        seresVivos = arbolTaxonomico.darSeresVivos( Taxon.ORDEN, "Orden 2" );
        assertEquals( "El número de seres vivos encontrados no es correcto. No debe haber seres vivos en la lista.", 0, seresVivos.size( ) );
    }

    /**
     * Prueba 11: Se encarga de verificar el método darTaxonesTipo de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darTaxonesTipo <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Retorna la lista de taxones de un tipo que existe en el árbol taxonómico. <br>
     * 2. Retorna la lista de taxones de un tipo que no existe en el árbol taxonómico.
     */
    @Test
    public void testDarTaxonesTipo( )
    {
        // Caso de prueba 1.
        setupEscenario3( );
        ArrayList<String> taxones = arbolTaxonomico.darTaxonesTipo( Taxon.REINO );
        assertEquals( "El número de taxones encontrados no es correcto. Hay 3 taxones de tipo Reino.", 3, taxones.size( ) );

        taxones = arbolTaxonomico.darTaxonesTipo( Taxon.GENERO );
        assertEquals( "El número de taxones encontrados no es correcto. Hay 1 taxón de tipo Género.", 1, taxones.size( ) );
        
        // Caso de prueba 2.
        setupEscenario1( );
        taxones = arbolTaxonomico.darTaxonesTipo( Taxon.FILO );
        assertEquals( "El número de taxones encontrados no es correcto. No debe haber taxones de tipo Filo.", 0, taxones.size( ) );

    }

    /**
     * Prueba 12: se encarga de verificar el método darTaxonesPreorden de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darTaxonesPreorden <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Retorna la lista de taxones en preorden del árbol taxonómico. <br>
     */
    @Test
    public void testDarTaxonesPreorden( )
    {
        setupEscenario3( );
        ArrayList<Taxon> listaTaxones = arbolTaxonomico.darTaxonesPreorden( );

        assertEquals( "El número de taxones encontrados no es correcto.", 18, listaTaxones.size( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Último antepasado común universal", ( listaTaxones.get( 0 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Dominio 1", ( listaTaxones.get( 1 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Reino 1", ( listaTaxones.get( 2 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Dominio 2", ( listaTaxones.get( 3 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Reino 2", ( listaTaxones.get( 4 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Filo 1", ( listaTaxones.get( 5 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Clase 1", ( listaTaxones.get( 6 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Orden 1", ( listaTaxones.get( 7 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Familia 1", ( listaTaxones.get( 8 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 1", ( listaTaxones.get( 9 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 1", ( listaTaxones.get( 10 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Clase 2", ( listaTaxones.get( 11 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Orden 2", ( listaTaxones.get( 12 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Filo 2", ( listaTaxones.get( 13 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Clase 3", ( listaTaxones.get( 14 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Orden 3", ( listaTaxones.get( 15 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Reino 3", ( listaTaxones.get( 16 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Filo 3", ( listaTaxones.get( 17 ) ).darNombre( ) );
    }

    /**
     * Prueba 14: Se encarga de verificar el método darTaxonesPostorden de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darTaxonesPostorden <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Retorna la lista de taxones en postorden del árbol taxonómico. <br>
     */
    @Test
    public void testDarTaxonesPostorden( )
    {
        setupEscenario3( );
        ArrayList<Taxon> listaTaxones = arbolTaxonomico.darTaxonesPostorden( );

        assertEquals( "El número de taxones encontrados no es correcto.", 18, listaTaxones.size( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Reino 1", ( listaTaxones.get( 0 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Dominio 1", ( listaTaxones.get( 1 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 1", ( listaTaxones.get( 2 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 1", ( listaTaxones.get( 3 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Familia 1", ( listaTaxones.get( 4 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Orden 1", ( listaTaxones.get( 5 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Clase 1", ( listaTaxones.get( 6 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Orden 2", ( listaTaxones.get( 7 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Clase 2", ( listaTaxones.get( 8 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Filo 1", ( listaTaxones.get( 9 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Orden 3", ( listaTaxones.get( 10 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Clase 3", ( listaTaxones.get( 11 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Filo 2", ( listaTaxones.get( 12 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Reino 2", ( listaTaxones.get( 13 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Filo 3", ( listaTaxones.get( 14 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Reino 3", ( listaTaxones.get( 15 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Dominio 2", ( listaTaxones.get( 16 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Último antepasado común universal", ( listaTaxones.get( 17 ) ).darNombre( ) );
    }
    
    /**
     * Prueba 15: Se encarga de verificar el método guardar de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * guardar <br>
     * ArbolTaxonomico <br>
     * darNumTaxones <br>
     * darNumSeresVivos <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se guarda correctamente el estado del mundo. <br>
     */
    @Test
    public void testGuardar( )
    {
        try
        {
            setupEscenario4( );
            String ruta = "./test/data/testGuardar.data";
            arbolTaxonomico.guardar( ruta );
            
            ArbolTaxonomico nuevoArbol = new ArbolTaxonomico( ruta );
            assertEquals( "La información no fue guardada correctamente. Debe haber 18 taxones en el árbol.", 25, nuevoArbol.darNumTaxones( ) );
            assertEquals( "La información no fue guardada correctamente. Debe haber 4 seres vivos en el árbol.", 4, nuevoArbol.darNumSeresVivos( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar la excepción" + e.getMessage( ) + "." );
        }
    }
}