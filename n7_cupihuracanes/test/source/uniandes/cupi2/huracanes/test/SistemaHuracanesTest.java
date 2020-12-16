/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiHuracanes
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.huracanes.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import uniandes.cupi2.cupihuracanes.mundo.Huracan;
import uniandes.cupi2.cupihuracanes.mundo.SistemaHuracanes;

/**
 * Clase usada para verificar que los m�todos de la clase SistemaHuracanes est�n correctamente implementados.
 */
public class SistemaHuracanesTest 
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Sistema de huracanes de prueba.
     */
    private SistemaHuracanes sistemaHuracanes;


    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 2: Construye un nuevo sistema de huracanes a partir de un archivo de texto. <b> Los huracanes son creados con datos reales
     */
    @Before
    public void setupEscenario1( )
    {
        sistemaHuracanes = new SistemaHuracanes( );
        cargarHuracanes( "./test/data/huracanes2.txt" );
    }

    /**
     * Escenario 3: Construye un nuevo sistema de huracanes vac�o.
     */
    private void setupEscenario2( )
    {
        sistemaHuracanes = new SistemaHuracanes( );
    }

    /**
     * Prueba 1: Verifica el m�todo registrarHuracan. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarHuracan <br>
     * buscarHuracan <br>
     * darHuracanes <br>
     * <b> Objetivo: </b> Probar que el m�todo registrarHuracan sea capaz de registrar un hurac�n en el sistema correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar (por nombre) un hurac�n previamente agregado, se debe obtener una posici�n diferente de -1 (se debe encontrar) y los datos del hurac�n en esa posici�n
     * deben corresponder a los del hurac�n con el nombre correspondiente. <br>
     */
    @Test
    public void testRegistrarHuracan1( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        String nombre;
        int categoria;
        int velocidad;
        double costoDanios;
        String imagen;
        boolean agregado;

        // Agrega un hurac�n y luego verifica que se haya agregado de forma correcta
        for( int i = 1; i <= 10; i++ )
        {
            nombre = "nombre" + i;
            categoria = 1 + i % 5;
            velocidad = i;
            costoDanios = i;
            imagen = "imagen" + i;

            agregado = sistemaHuracanes.registrarHuracan( nombre, categoria, velocidad, costoDanios, imagen );
            int pos = sistemaHuracanes.buscarHuracan( nombre );
            Huracan huracan = ( Huracan )sistemaHuracanes.darHuracanes( ).get( pos );

            assertTrue( "El hurac�n no se agreg� correctamente.", agregado );
            assertEquals( "El hurac�n no se agreg� correctamente.", i - 1, pos );
            assertEquals( "El hurac�n no se agreg� con el nombre correcto.", nombre, huracan.darNombre( ) );
            assertEquals( "El hurac�n no se agreg� con la categor�a correcta.", categoria, huracan.darCategoria( ) );
            assertEquals( "El hurac�n no se agreg� con la velocidad correcta.", velocidad, huracan.darVelocidad( ) );
            assertEquals( "El hurac�n no se agreg� con el costo correcto.", costoDanios, huracan.darCostoEstimadoDanios( ), 0.1 );
            assertEquals( "El hurac�n no se agreg� con la imagen correcta.", imagen, huracan.darImagen( ) );
        }
    }

    /**
     * Prueba 2: Verifica el m�todo registrarHuracan, agregando un hurac�n con nombre repetido. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarHuracan <br>
     * buscarHuracan <br>
     * darHuracanes <br>
     * <b> Objetivo: </b> Probar que el m�todo registrarHuracan no agregue un hurac�n en el sistema cuando ya existe un hurac�n con el mismo nombre registrado. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al registrar un hurac�n con un nombre ya existente, no se debe agregar a la lista de huracanes.
     */
    @Test
    public void testRegistrarHuracan2( )
    {
        int tamanio = sistemaHuracanes.darHuracanes( ).size( );
        
        boolean agregado = sistemaHuracanes.registrarHuracan( "Emily", 5, 97, 2, "imagen_emily.png" );
        assertFalse( "El hurac�n no deber�a haberse agregado", agregado );
        assertEquals("El tama�o del arreglo no deber�a haber aumentado", tamanio, sistemaHuracanes.darHuracanes().size( ));

        agregado = sistemaHuracanes.registrarHuracan( "Katrina", 3, 100, 1, "imagen_katrina.png" );
        assertFalse( "El hurac�n no deber�a haberse agregado", agregado );
        assertEquals("El tama�o del arreglo no deber�a haber aumentado", tamanio, sistemaHuracanes.darHuracanes().size( ));

        agregado = sistemaHuracanes.registrarHuracan( "Wilma", 1, 450, 20, "imagen_katrina.png" );
        assertFalse( "El hurac�n no deber�a haberse agregado", agregado );
        assertEquals("El tama�o del arreglo no deber�a haber aumentado", tamanio, sistemaHuracanes.darHuracanes().size( ));
    }

    /**
     * Prueba 3: Verifica el m�todo buscarHuracan. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarHuracan. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarHuracan sea capaz de encontrar huracanes registrados en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un hurac�n previamente agregado, se debe obtener la posici�n donde se encuentra en el arreglo. <br>
     * 2. Al buscar un hurac�n que no exista, la posici�n retornada debe ser -1.
     */
    @Test
    public void testBuscarHuracan( )
    {
        assertEquals( "El hurac�n deber�a estar en la posici�n 7.", 7, sistemaHuracanes.buscarHuracan( "Rita" ) );
        assertEquals( "El hurac�n deber�a estar en la posici�n 0.", 0, sistemaHuracanes.buscarHuracan( "Bill" ) );
        assertEquals( "No deber�a haber encontrado el hurac�n.", -1, sistemaHuracanes.buscarHuracan( "Antonio" ) );
    }

    /**
     * Prueba 4: Verifica el m�todo buscarBinarioPorNombre. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarBinarioPorNombre <br>
     * ordenarPorNombre <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarBinarioPorNombre() sea capaz de encontrar huracanes registrados en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un hurac�n previamente agregado, se debe obtener la posici�n donde se encuentra en el arreglo ordenado. <br>
     * 2. Al buscar un hurac�n que no exista, la posici�n retornada debe ser -1.
     */
    //TODO Parte 2 punto N: Implementar el m�todo de prueba seg�n la documentacion.

    /**
     * Prueba 5: Verifica el m�todo de ordenar por nombre. <b> M�todos a probar: </b> <br>
     * ordenarPorNombre. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarPorNombre() ordena el sistema de forma correcta (en orden ascendente por nombre). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por nombre, los huracanes deben quedar ordenados por orden alfab�tico de acuerdo a su nombre. <br>
     */
    @Test
    public void testOrdenarPorNombre( )
    {

        sistemaHuracanes.ordenarPorNombre( );
        ArrayList huracanes = sistemaHuracanes.darHuracanes( );
        for( int i = 1; i < huracanes.size( ); i++ )
        {
            Huracan h0 = ( Huracan )huracanes.get( i - 1 );
            Huracan h1 = ( Huracan )huracanes.get( i );

            assertTrue( "No se orden� bien por nombre", h0.darNombre( ).compareTo( h1.darNombre( ) ) <= 0 );
        }
    }

    /**
     * Prueba 6: Verifica el m�todo de ordenar por velocidad. <b> M�todos a probar: </b> <br>
     * ordenarPorVelocidad. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarPorVelocidad() ordena el sistema de forma correcta (en orden descendente por velocidad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por velocidad, el hurac�n con la menor velocidad debe quedar de primero y el de mayor velocidad de �ltimo.
     */
    @Test
    public void testOrdenarPorVelocidad( )
    {
        sistemaHuracanes.ordenarPorVelocidad( );
        ArrayList huracanes = sistemaHuracanes.darHuracanes( );
        for( int i = 1; i < huracanes.size( ); i++ )
        {
            Huracan h0 = ( Huracan )huracanes.get( i - 1 );
            Huracan h1 = ( Huracan )huracanes.get( i );

            assertTrue( "No se orden� bien por velocidad", h0.darVelocidad( ) >= h1.darVelocidad( ) );
        }
    }

    /**
     * Prueba 7: Verifica el m�todo de ordenar por costo estimado en da�os <b><br>
     * M�todos a probar: </b> <br>
     * ordenarPorDanios. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarPorDanios() ordena el sistema de forma correcta (en orden ascendente por costo estimado en da�os). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por costo en da�os, el hurac�n con el menor costo estimado en da�os debe quedar de primero y el de mayor costo en da�os de �ltimo.
     */
    @Test
    public void testOrdenarPorDanios( )
    {
        sistemaHuracanes.ordenarPorDanios( );
        ArrayList huracanes = sistemaHuracanes.darHuracanes( );
        for( int i = 1; i < huracanes.size( ); i++ )
        {
            Huracan h0 = ( Huracan )huracanes.get( i - 1 );
            Huracan h1 = ( Huracan )huracanes.get( i );

            assertTrue( "No se orden� bien por danios", h0.darCostoEstimadoDanios( ) <= h1.darCostoEstimadoDanios( ) );
        }
    }

    /**
     * Prueba 8: Verifica el m�todo buscarHuracanMayorCostoDanios funcione correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarHuracanMayorCostoDanios. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarHuracanMayorCostoDanios() retorna el hurac�n correcto (el que tiene mayor costo estimado en da�os). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el hurac�n con mayor costo estimado en da�os se debe obtener la posici�n del hurac�n con el costo estimado en da�os en el sistema. <br>
     * 2. Al buscar el hurac�n con mayor costo estimado en da�os en un sistema vac�o la posici�n retornada debe ser -1.
     */
    //TODO Parte 2 punto O: Implementar el m�todo de prueba seg�n la documentacion.
    
    /**
     * Prueba 9: Verifica el m�todo buscarHuracanMenorCostoDanios funcione correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarHuracanMenorCostoDanios. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarHuracanMenorCostoDanios() retorna el hurac�n correcto (el que tiene menor costo estimado en da�os). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el hurac�n con menor costo estimado en da�os, se debe obtener la posici�n del hurac�n con el costo estimado en da�os m�s peque�o en el sistema. <br>
     * 2. Al buscar el hurac�n con menor costo estimado en da�os en un sistema vac�o, la posici�n retornada debe ser -1.
     */
    //TODO Parte 2 punto P: Implementar el m�todo de prueba seg�n la documentacion.
    
    /**
     * Prueba 10: Verifica el m�todo buscarHuracanMayorVelocidad funcione correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarHuracanMayorVelocidad. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarHuracanMayorVelocidad() retorna el hurac�n correcto (el que tiene mayor velocidad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el hurac�n con mayor velocidad, se debe obtener la posici�n del hurac�n con la velocidad en el sistema. <br>
     * 2. Al buscar el hurac�n con mayor velocidad en un sistema vac�o, la posici�n retornada debe ser -1.
     */
    //TODO Parte 2 punto Q: Implementar el m�todo de prueba seg�n la documentacion.
    
    // -----------------------------------------------------------------
    // M�todos Auxiliares
    // -----------------------------------------------------------------
    /**
     * Carga los huracanes del sistema especificada a partir de un archivo de propiedades.
     * @param pArchivo Nombre del archivo de propiedades que contiene la informaci�n de los huracanes.
     */
    private void cargarHuracanes( String pArchivo )
    {
        try
        {
            FileInputStream fis = new FileInputStream( new File( pArchivo ) );
            Properties propiedades = new Properties( );
            propiedades.load( fis );

            // Cargar los huracanes
            String dato;
            String nombre;
            int categoria;
            int velocidad;
            double costoDanios;
            String imagen;
            String aux;
            dato = "total.huracanes";
            aux = propiedades.getProperty( dato );
            int cantidadHuracanes = Integer.parseInt( aux );

            for( int cont = 1; cont <= cantidadHuracanes; cont++ )
            {
                // Carga un hurac�n
                dato = "huracan" + cont + ".nombre";
                nombre = propiedades.getProperty( dato );

                dato = "huracan" + cont + ".categoria";
                categoria = Integer.parseInt( propiedades.getProperty( dato ) );

                dato = "huracan" + cont + ".velocidad";
                velocidad = Integer.parseInt( propiedades.getProperty( dato ) );

                dato = "huracan" + cont + ".costoDanios";
                costoDanios = Double.parseDouble( propiedades.getProperty( dato ) );

                dato = "huracan" + cont + ".imagen";
                imagen = propiedades.getProperty( dato );

                sistemaHuracanes.registrarHuracan( nombre, categoria, velocidad, costoDanios, imagen );
                fis.close( );
            }
        }
        catch( Exception e )
        {
            fail( "No se pudo cargar el archivo de huracanes:" + e.getMessage( ) );
        }
    }

}