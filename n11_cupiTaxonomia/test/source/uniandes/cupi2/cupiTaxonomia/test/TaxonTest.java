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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import uniandes.cupi2.cupiTaxonomia.mundo.*;

/**
 * Clase usada para verificar la correcta implementación de la clase Taxón.
 */
public class TaxonTest
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Taxon taxon;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1. Crea un nuevo taxón con valores por defecto, sin sub-taxones y sin seres vivos.
     */
    @Before 
    public  void setupEscenario1( )
    {
        taxon = new Taxon( );
    }

    /**
     * Escenario 2. Crea un nuevo taxón de tipo Especie sin sub-taxones y sin seres vivos.
     */
    @Test
    public void setupEscenario2( )
    {
        taxon = new Taxon( Taxon.ESPECIE, "Especie" );
    }

    /**
     * Escenario 3. Crea un nuevo taxón de tipo Dominio con sub-taxones de tipo Reino y sin seres vivos.
     */
    @Test
    public void setupEscenario3( )
    {
        taxon = new Taxon( Taxon.DOMINIO, "Dominio" );
        try
        {
            taxon.agregarSubTaxon( Taxon.REINO, "Reino 1" );
            taxon.agregarSubTaxon( Taxon.REINO, "Reino 2" );
            taxon.agregarSubTaxon( Taxon.REINO, "Reino 3" );
            taxon.agregarSubTaxon( Taxon.REINO, "Reino 4" );
            taxon.agregarSubTaxon( Taxon.REINO, "Reino 5" );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }
    }

    /**
     * Escenario 4. Crea un nuevo taxón de tipo Especie con un ser vivo.
     */
    @Test
    public void setupEscenario4( )
    {
        taxon = new Taxon( Taxon.ESPECIE, "Especie" );
        try
        {
            taxon.agregarSerVivo( "ser vivo", "cientifico", "caracteristicas", "imagen" );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }
    }

    /**
     * Escenario 5. Crea un nuevo taxón de tipo Familia con sub-taxones hijos de tipo Género y sub-taxones nietos de tipo Especie.
     */
    @Test
    public void setupEscenario5( )
    {
        taxon = new Taxon( Taxon.FAMILIA, "Familia" );
        try
        {
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 1" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 2" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 3" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 4" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 5" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 6" );

            Taxon taxonHijo2 = taxon.buscarTaxon( "Genero 2" );
            Taxon taxonHijo5 = taxon.buscarTaxon( "Genero 5" );

            taxonHijo2.agregarSubTaxon( Taxon.ESPECIE, "Especie 21" );
            taxonHijo2.agregarSubTaxon( Taxon.ESPECIE, "Especie 22" );
            taxonHijo2.agregarSubTaxon( Taxon.ESPECIE, "Especie 23" );
            taxonHijo5.agregarSubTaxon( Taxon.ESPECIE, "Especie 51" );
        }
        catch( Exception e )
        {
        	System.out.println(e.getMessage());
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }
    }

    /**
     * Escenario 6. Crea un nuevo taxón de tipo Familia con sub-taxones de tipo Especie y seres vivos.
     */
    @Test
    public void setupEscenario6( )
    {
        taxon = new Taxon( Taxon.FAMILIA, "Familia" );
        try
        {
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 1" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 2" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 3" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 4" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 5" );
            taxon.agregarSubTaxon( Taxon.GENERO, "Genero 6" );

            Taxon taxonHijo2 = taxon.buscarTaxon( "Genero 2" );
            Taxon taxonHijo3 = taxon.buscarTaxon( "Genero 3" );
            Taxon taxonHijo5 = taxon.buscarTaxon( "Genero 5" );

            taxonHijo2.agregarSubTaxon( Taxon.ESPECIE, "Especie 21" );
            taxonHijo2.agregarSubTaxon( Taxon.ESPECIE, "Especie 22" );
            taxonHijo2.agregarSubTaxon( Taxon.ESPECIE, "Especie 23" );
            taxonHijo3.agregarSubTaxon( Taxon.ESPECIE, "Especie 31" );
            taxonHijo5.agregarSubTaxon( Taxon.ESPECIE, "Especie 51" );

            Taxon taxonNieto21 = taxon.buscarTaxon( "Especie 21" );
            Taxon taxonNieto23 = taxon.buscarTaxon( "Especie 23" );

            taxonNieto21.agregarSerVivo( "ser vivo", "cientifico1", "caracteristicas", "imagen" );
            taxonNieto23.agregarSerVivo( "ser vivo", "cientifico2", "caracteristicas", "imagen" );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar método constructor (sin parámetros) de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Taxon <br>
     * darNombre <br>
     * darTipo <br>
     * darSubTaxones <br>
     * darSerVivo <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se crea un taxón con los valores por defecto. <br>
     */
    @Test
    public void testTaxon( )
    {

        assertNotNull( "El nombre del taxón no fue inicializado.", taxon.darNombre( ) );
        assertEquals( "El nombre dle taxón no fue inicializado correctamente.", "Último antepasado común universal", taxon.darNombre( ) );
        assertEquals( "El tipo del taxón no fue inicializado correctamente.", Taxon.LUCA, taxon.darTipo( ) );
        assertNotNull( "La lista de sub-taxones no fue inicializada.", taxon.darSubTaxones( ) );
        assertNull( "El ser vivo debe ser nulo.", taxon.darSerVivo( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método constructor (con parámetros) de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Taxon <br>
     * darNombre <br>
     * darTipo <br>
     * darSubTaxones <br>
     * darSerVivo <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se crea un taxón con los valores dados. <br>
     */
    @Test
    public void testTaxon2( )
    {
        setupEscenario2( );

        assertNotNull( "El nombre del taxón no fue inicializado.", taxon.darNombre( ) );
        assertEquals( "El nombre dle taxón no fue inicializado correctamente.", "Especie", taxon.darNombre( ) );
        assertEquals( "El tipo del taxón no fue inicializado correctamente.", Taxon.ESPECIE, taxon.darTipo( ) );
        assertNotNull( "La lista de sub-taxones no fue inicializada.", taxon.darSubTaxones( ) );
        assertNull( "El ser vivo debe ser nulo.", taxon.darSerVivo( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método agregarSerVivo de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarSerVivo <br>
     * darSerVivo <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El taxón no tiene un ser vivo.
     */
    @Test
    public void testAgregarSerVivo( )
    {
        setupEscenario2( );

        try
        {
            taxon.agregarSerVivo( "nombre", "cientifico", "caracteristicas", "imagen" );
            SerVivo ser = taxon.darSerVivo( );
            assertNotNull( "No se agregó el ser vivo al taxón.", taxon.darSerVivo( ) );
            assertEquals( "El nombre científico del ser vivo no es el correcto.", "cientifico", ser.darNombreCientifico( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería generar el error: " + e.getMessage( ) + "." );
        }
    }

    /**
     * Prueba 4: Se encargar de verificar el método agregarSerVivo de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarSerVivo <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El taxón tiene un ser vivo.
     */
    @Test
    public void testAgregarSerVivoError( )
    {
        setupEscenario4( );
        try
        {
            taxon.agregarSerVivo( "nombre", "científico", "características", "imagen" );
            fail( "No debería agregar pues el taxón ya tiene un ser vivo." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
        }
    }

    /**
     * Prueba 5 - Se encarga de verificar el método agregarSubTaxon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarSubTaxon <br>
     * darSubTaxones <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agrega correctamente el subtaxón.
     */
    @Test
    public void testAgregarSubTaxon( )
    {
        taxon.agregarSubTaxon( Taxon.DOMINIO, "Dominio" );
        ArrayList<Taxon> subTaxones = taxon.darSubTaxones( );
        assertEquals( "No se agrego el sub-taxón.", 1, subTaxones.size( ) );
        Taxon t = ( Taxon )subTaxones.get( 0 );
        assertEquals( "El tipo de taxón agregado no es correcto.", Taxon.DOMINIO, t.darTipo( ) );
        assertEquals( "El nombre del taxón agregado no correcto.", "Dominio", t.darNombre( ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el método buscarTaxon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarTaxon <br>
     * darNombre <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El taxón buscado es el actual. <br>
     * 2. El taxón buscado es un hijo del taxón actual. <br>
     * 3. El taxón buscado es un nieto del taxón actual. <br>
     * 4. El taxón buscado no existe.
     */
    @Test
    public void testBuscarTaxon( )
    {
        setupEscenario5( );

        // Caso de prueba 1.
        Taxon actual = taxon.buscarTaxon( "Familia" );
        assertNotNull( "El taxón buscado si existe.", actual );
        assertEquals( "El taxón encontrado no es el correcto.", "Familia", actual.darNombre( ) );

        // Caso de prueba 2.
        Taxon hijo = taxon.buscarTaxon( "Genero 3" );
        assertNotNull( "El taxón buscado si existe.", hijo );
        assertEquals( "El taxón encontrado no es el correcto.", "Genero 3", hijo.darNombre( ) );

        hijo = taxon.buscarTaxon( "Genero 6" );
        assertNotNull( "El taxón buscado si existe.", hijo );
        assertEquals( "El taxón encontrado no es el correcto.", "Genero 6", hijo.darNombre( ) );

        // Caso de prueba 3.
        Taxon nieto = taxon.buscarTaxon( "Especie 22" );
        assertNotNull( "El taxón buscado si existe.", nieto );
        assertEquals( "El taxón encontrado no es el correcto.", "Especie 22", nieto.darNombre( ) );

        nieto = taxon.buscarTaxon( "Especie 51" );
        assertNotNull( "El taxón buscado si existe.", nieto );
        assertEquals( "El taxón encontrado no es el correcto.", "Especie 51", nieto.darNombre( ) );

        // Caso de prueba 4.
        Taxon noExiste = taxon.buscarTaxon( "No existe" );
        assertNull( "El taxón buscado no existe.", noExiste );
    }

    /**
     * Prueba 7: Se encarga de verificar el método buscarTaxonNivel de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarTaxonNivel <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El taxón buscado es el actual. <br>
     * 2. El taxón buscado es un hijo del taxón actual. <br>
     * 3. El taxón buscado es un nieto del taxón actual. 
     */
    @Test
    public void testBuscarTaxonNivel1( )
    {

        setupEscenario5( );

        // Caso de prueba 1.
        Taxon actual = taxon.buscarTaxonNivel( Taxon.FAMILIA, "Familia" );
        assertNotNull( "El taxón buscado sí existe.", actual );
        assertEquals( "El taxón encontrado no es el correcto.", "Familia", actual.darNombre( ) );

        // Caso de prueba 2.
        Taxon hijo = taxon.buscarTaxonNivel( Taxon.GENERO, "Genero 2" );
        assertNotNull( "El taxón buscado sí existe.", hijo );
        assertEquals( "El taxón encontrado no es el correcto.", "Genero 2", hijo.darNombre( ) );

        hijo = taxon.buscarTaxonNivel( Taxon.GENERO, "Genero 4" );
        assertNotNull( "El taxón buscado sí existe.", hijo );
        assertEquals( "El taxón encontrado no es el correcto.", "Genero 4", hijo.darNombre( ) );

        // Caso de prueba 3.
        Taxon nieto = taxon.buscarTaxonNivel( Taxon.ESPECIE, "Especie 51" );
        assertNotNull( "El taxón buscado sí existe.", nieto );
        assertEquals( "El taxón encontrado no es el correcto.", "Especie 51", nieto.darNombre( ) );

        nieto = taxon.buscarTaxonNivel( Taxon.ESPECIE, "Especie 23" );
        assertNotNull( "El taxón buscado sí existe.", nieto );
        assertEquals( "El taxón encontrado no es el correcto.", "Especie 23", nieto.darNombre( ) );
    }

    /**
     * Prueba 8: Se encarga de verificar el método buscarTaxonNivel de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarTaxonNivel <br>
     * <b> Casos de prueba: </b> <br>
     * 1. La distancia es superior al número de niveles y el taxón buscado no existe. <br>
     * 2. La distancia es superior al número de niveles y el taxón buscado existe, pero no es de ese nivel. <br>
     * 3. La distancia es válida pero el taxón no existe.
     */
    @Test
    public void testBuscarTaxonNivel2( )
    {
        setupEscenario5( );

        // Caso de prueba 1.
        Taxon noExiste = taxon.buscarTaxonNivel( Taxon.REINO, "Reino 4" );
        assertNull( "El taxón buscado no existe.", noExiste );

        // Caso de prueba 2.
        noExiste = taxon.buscarTaxonNivel( Taxon.ESPECIE, "Genero 5" );
        assertNull( "El taxón buscado no existe.", noExiste );

        // Caso de prueba 3.
        noExiste = taxon.buscarTaxonNivel( Taxon.ESPECIE, "No existe" );
        assertNull( "El taxón buscado no existe.", noExiste );
    }

    /**
     * Prueba 9: Se encarga de verificar el método buscarSerVivo de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarSerVivo <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El ser vivo buscado es del taxón actual.
     */
    @Test
    public void testBuscarSerVivo1( )
    {
        setupEscenario4( );

        SerVivo ser = taxon.buscarSerVivo( "cientifico" );
        assertNotNull( "El ser vivo buscado si existe.", ser );
        assertEquals( "El ser vivo encontrado no es el correcto.", "cientifico", ser.darNombreCientifico( ) );
    }
    
    /**
     * Prueba 10: Se encarga de verificar el método buscarSerVivo de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarSerVivo <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El ser vivo buscado es de un hijo del taxón actual. <br>
     * 2. El ser vivo buscado es de un nieto del taxón actual. <br>
     * 3. El ser vivo buscado no existe.
     */
    @Test
    public void testBuscarSerVivo2( )
    {
        setupEscenario6( );

        // Caso de prueba 1.
        Taxon taxonPadre = taxon.buscarTaxon( "Genero 2" );
        SerVivo ser = taxonPadre.buscarSerVivo( "cientifico1" );
        assertNotNull( "El ser vivo buscado si existe.", ser );
        assertEquals( "El ser vivo encontrado no es el correcto.", "cientifico1", ser.darNombreCientifico( ) );

        // Caso de prueba 2.
        ser = taxon.buscarSerVivo( "cientifico2" );
        assertNotNull( "El ser vivo buscado si existe", ser );
        assertEquals( "El ser vivo encontrado no es el correcto", "cientifico2", ser.darNombreCientifico( ) );
        
        ser = taxon.buscarSerVivo( "cientifico1" );
        assertNotNull( "El ser vivo buscado si existe", ser );
        assertEquals( "El ser vivo encontrado no es el correcto", "cientifico1", ser.darNombreCientifico( ) );

        // Caso de prueba 3.
        SerVivo noExiste = taxon.buscarSerVivo( "No existe" );
        assertNull( "El ser vivo buscado no existe.", noExiste );
    }

    /**
     * Prueba 11: Se encarga de verificar el método eliminarTaxon de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarTaxon <br>
     * buscarTaxon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se elimina un subtaxón sin hijos. <br>
     * 2. Se elimina un subtaxón con hijos. <br>
     * 3. Se va a eliminar un taxón de un sub-taxón. <br>
     * 4. Se va a eliminar un taxón de un sub-taxón que tiene sub-taxones.
     */
    @Test
    public void testEliminarTaxon( )
    {
        setupEscenario6( );
        
        // Caso de prueba 1.
        taxon.eliminarTaxon( Taxon.GENERO, "Genero 4" );
        assertEquals( "El taxón no fue eliminado. Deberían haber 5 sub-taxones.", 5, taxon.darSubTaxones( ).size( ) );
        Taxon t = taxon.buscarTaxon( "Genero 4" );
        assertNull( "El taxón no fue eliminado correctamente.", t );
        
        // Caso de prueba 2.
        taxon.eliminarTaxon( Taxon.GENERO, "Genero 5" );
        assertEquals( "El taxón no fue eliminado. Deberían haber 4 sub-taxones.", 4, taxon.darSubTaxones( ).size( ) );
        t = taxon.buscarTaxon( "Genero 5" );
        assertNull( "El taxón no fue eliminado correctamente.", t );
        t = taxon.buscarTaxon( "Especie 51" );
        assertNull( "Los subtaxones del taxon eliminado deberían ser eliminados.", t );

        // Caso de prueba 3.
        taxon.eliminarTaxon( Taxon.ESPECIE, "Especie 23" );
        t = taxon.buscarTaxon( "Especie 23" );
        assertNull( "El taxón no fue eliminado", t );

        // Caso de prueba 4.
        taxon.eliminarTaxon( Taxon.GENERO, "Genero 2" );
        assertEquals( "El taxón no fue eliminado. Deberían haber 3 sub-taxones.", 3, taxon.darSubTaxones( ).size( ) );
        t = taxon.buscarTaxon( "Genero 2" );
        assertNull( "El taxón no fue eliminado correctamente.", t );
        t = taxon.buscarTaxon( "Especie 21" );
        assertNull( "El taxón no fue eliminado correctamente.", t );
    }

    /**
     * Prueba 12: Se encarga de verificar el método darNumTaxones de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darNumTaxones <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El taxón es una hoja. <br>
     * 2. El taxón es tiene sub-taxones. <br>
     */
    @Test
    public void testDarNumTaxones( )
    {
        // Caso de prueba 1.
        setupEscenario2( );
        int numTaxones = taxon.darNumTaxones( );
        assertEquals( "El número de taxones no es calculado correctamente.", 1, numTaxones );
        
        // Caso de prueba 2.
        setupEscenario3( );
        numTaxones = taxon.darNumTaxones( );
        assertEquals( "El número de taxones no es calculado correctamente.", 6, numTaxones );
        
        
        setupEscenario5( );
        numTaxones = taxon.darNumTaxones( );
        assertEquals( "El número de taxones no es calculado correctamente.", 11, numTaxones );
    }

    /**
     * Prueba 13: Se encarga de verificar el método darNumSeresVivos de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darNumSeresVivos <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula correctamente el número de seres vivos.
     */
    @Test
    public void testDarNumSeresVivos( )
    {
        setupEscenario6( );
        int numSeres = taxon.darNumSeresVivos( );
        assertEquals( "El número de libros no es calculado correctamente.", 2, numSeres );
        
        try
        {
            Taxon taxonEspecie = taxon.buscarTaxon( "Especie 51" );
            taxonEspecie.agregarSerVivo( "nombre comun", "cientifico3", "caracteristicas", "imagen" );
            numSeres = taxon.darNumSeresVivos( );
            assertEquals( "El número de libros no es calculado correctamente.", 3, numSeres );
        }
        catch( Exception e )
        {
            // No debería generar excepción.
        }
        
    }

    /**
     * Prueba 14: Se encarga de verificar el método buscarSeresVivos de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarSeresVivos <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se retorna correctamente la lista de seres vivos.
     */
    @Test
    public void testBuscarSeresVivos( )
    {
        setupEscenario6( );

        ArrayList<SerVivo> listaSeresVivos = new ArrayList<SerVivo>( );
        taxon.buscarSeresVivos( listaSeresVivos );
        assertEquals( "El número de seres vivos encontrados no es correcto.", 2, listaSeresVivos.size( ) );
    }

    /**
     * Prueba 15: Se encarga de verificar el método buscarTaxonesPreorden de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarTaxonesPreorden <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los taxones fueron ordenados correctamente en preorden.
     */
    @Test
    public void testBuscarTaxonesPreorden( )
    {
        setupEscenario5( );

        ArrayList<Taxon> listaTaxones = new ArrayList<Taxon>( );
        taxon.buscarTaxonesPreorden( listaTaxones );

        assertEquals( "El número de taxones encontrados no es correcto.", 11, listaTaxones.size( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Familia", ( ( Taxon )listaTaxones.get( 0 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 1", ( ( Taxon )listaTaxones.get( 1 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 2", ( ( Taxon )listaTaxones.get( 2 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 21", ( ( Taxon )listaTaxones.get( 3 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 22", ( ( Taxon )listaTaxones.get( 4 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 23", ( ( Taxon )listaTaxones.get( 5 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 3", ( ( Taxon )listaTaxones.get( 6 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 4", ( ( Taxon )listaTaxones.get( 7 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 5", ( ( Taxon )listaTaxones.get( 8 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 51", ( ( Taxon )listaTaxones.get( 9 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 6", ( ( Taxon )listaTaxones.get( 10 ) ).darNombre( ) );
    }

    /**
     * Prueba 16: Se encarga de verificar el método buscarTaxonesPostorden de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarTaxonesPostorden <br>
     * <b> Casos de prueba: </b> 
     * 1.  Los taxones fueron ordenados correctamente en postorden.
     */
    @Test
    public void testBuscarTaxonesPostorden( )
    {
        setupEscenario5( );

        ArrayList<Taxon> listaTaxones = new ArrayList<Taxon>( );
        taxon.buscarTaxonesPostorden( listaTaxones );

        assertEquals( "El número de taxones encontrados no es correcto.", 11, listaTaxones.size( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 1", ( ( Taxon )listaTaxones.get( 0 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 21", ( ( Taxon )listaTaxones.get( 1 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 22", ( ( Taxon )listaTaxones.get( 2 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 23", ( ( Taxon )listaTaxones.get( 3 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 2", ( ( Taxon )listaTaxones.get( 4 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 3", ( ( Taxon )listaTaxones.get( 5 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 4", ( ( Taxon )listaTaxones.get( 6 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 51", ( ( Taxon )listaTaxones.get( 7 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 5", ( ( Taxon )listaTaxones.get( 8 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Genero 6", ( ( Taxon )listaTaxones.get( 9 ) ).darNombre( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Familia", ( ( Taxon )listaTaxones.get( 10 ) ).darNombre( ) );
    }

    /**
     * Prueba 17: Se encarga de verificar el método buscarTaxonesNivel de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarTaxonesNivel <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se retorna correctamente los elementos del nivel. 
     */
    @Test
    public void testBuscarTaxonesNivel( )
    {
        setupEscenario5( );

        ArrayList<String> listaTaxones = new ArrayList<String>( );
        taxon.buscarTaxonesNivel( Taxon.ESPECIE, listaTaxones );

        assertEquals( "El número de taxones encontrados no es correcto.", 4, listaTaxones.size( ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 21", ( String )listaTaxones.get( 0 ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 22", ( String )listaTaxones.get( 1 ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 23", ( String )listaTaxones.get( 2 ) );
        assertEquals( "Los taxones no fueron ordenados correctamente.", "Especie 51", ( String )listaTaxones.get( 3 ) );
    }

    /**
     * Prueba 18: Se encarga de verificar el método toString de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * toString <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El método retorna: el nombre del tipo: nombre del taxón.
     */
    @Test
    public void testToString( )
    {
        setupEscenario2( );
        assertEquals( "La representación String del taxón no es correcta.", "Especie: Especie", taxon.toString( ) );
    }
}