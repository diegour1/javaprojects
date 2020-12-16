/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
 * Clase usada para verificar que los métodos de la clase SistemaHuracanes estén correctamente implementados.
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
    // Métodos
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
     * Escenario 3: Construye un nuevo sistema de huracanes vacío.
     */
    private void setupEscenario2( )
    {
        sistemaHuracanes = new SistemaHuracanes( );
    }

    /**
     * Prueba 1: Verifica el método registrarHuracan. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarHuracan <br>
     * buscarHuracan <br>
     * darHuracanes <br>
     * <b> Objetivo: </b> Probar que el método registrarHuracan sea capaz de registrar un huracán en el sistema correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar (por nombre) un huracán previamente agregado, se debe obtener una posición diferente de -1 (se debe encontrar) y los datos del huracán en esa posición
     * deben corresponder a los del huracán con el nombre correspondiente. <br>
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

        // Agrega un huracán y luego verifica que se haya agregado de forma correcta
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

            assertTrue( "El huracán no se agregó correctamente.", agregado );
            assertEquals( "El huracán no se agregó correctamente.", i - 1, pos );
            assertEquals( "El huracán no se agregó con el nombre correcto.", nombre, huracan.darNombre( ) );
            assertEquals( "El huracán no se agregó con la categoría correcta.", categoria, huracan.darCategoria( ) );
            assertEquals( "El huracán no se agregó con la velocidad correcta.", velocidad, huracan.darVelocidad( ) );
            assertEquals( "El huracán no se agregó con el costo correcto.", costoDanios, huracan.darCostoEstimadoDanios( ), 0.1 );
            assertEquals( "El huracán no se agregó con la imagen correcta.", imagen, huracan.darImagen( ) );
        }
    }

    /**
     * Prueba 2: Verifica el método registrarHuracan, agregando un huracán con nombre repetido. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarHuracan <br>
     * buscarHuracan <br>
     * darHuracanes <br>
     * <b> Objetivo: </b> Probar que el método registrarHuracan no agregue un huracán en el sistema cuando ya existe un huracán con el mismo nombre registrado. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al registrar un huracán con un nombre ya existente, no se debe agregar a la lista de huracanes.
     */
    @Test
    public void testRegistrarHuracan2( )
    {
        int tamanio = sistemaHuracanes.darHuracanes( ).size( );
        
        boolean agregado = sistemaHuracanes.registrarHuracan( "Emily", 5, 97, 2, "imagen_emily.png" );
        assertFalse( "El huracán no debería haberse agregado", agregado );
        assertEquals("El tamaño del arreglo no debería haber aumentado", tamanio, sistemaHuracanes.darHuracanes().size( ));

        agregado = sistemaHuracanes.registrarHuracan( "Katrina", 3, 100, 1, "imagen_katrina.png" );
        assertFalse( "El huracán no debería haberse agregado", agregado );
        assertEquals("El tamaño del arreglo no debería haber aumentado", tamanio, sistemaHuracanes.darHuracanes().size( ));

        agregado = sistemaHuracanes.registrarHuracan( "Wilma", 1, 450, 20, "imagen_katrina.png" );
        assertFalse( "El huracán no debería haberse agregado", agregado );
        assertEquals("El tamaño del arreglo no debería haber aumentado", tamanio, sistemaHuracanes.darHuracanes().size( ));
    }

    /**
     * Prueba 3: Verifica el método buscarHuracan. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarHuracan. <br>
     * <b> Objetivo: </b> Probar que el método buscarHuracan sea capaz de encontrar huracanes registrados en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un huracán previamente agregado, se debe obtener la posición donde se encuentra en el arreglo. <br>
     * 2. Al buscar un huracán que no exista, la posición retornada debe ser -1.
     */
    @Test
    public void testBuscarHuracan( )
    {
        assertEquals( "El huracán debería estar en la posición 7.", 7, sistemaHuracanes.buscarHuracan( "Rita" ) );
        assertEquals( "El huracán debería estar en la posición 0.", 0, sistemaHuracanes.buscarHuracan( "Bill" ) );
        assertEquals( "No debería haber encontrado el huracán.", -1, sistemaHuracanes.buscarHuracan( "Antonio" ) );
    }

    /**
     * Prueba 4: Verifica el método buscarBinarioPorNombre. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarBinarioPorNombre <br>
     * ordenarPorNombre <br>
     * <b> Objetivo: </b> Probar que el método buscarBinarioPorNombre() sea capaz de encontrar huracanes registrados en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un huracán previamente agregado, se debe obtener la posición donde se encuentra en el arreglo ordenado. <br>
     * 2. Al buscar un huracán que no exista, la posición retornada debe ser -1.
     */
    //TODO Parte 2 punto N: Implementar el método de prueba según la documentacion.

    /**
     * Prueba 5: Verifica el método de ordenar por nombre. <b> Métodos a probar: </b> <br>
     * ordenarPorNombre. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorNombre() ordena el sistema de forma correcta (en orden ascendente por nombre). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por nombre, los huracanes deben quedar ordenados por orden alfabético de acuerdo a su nombre. <br>
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

            assertTrue( "No se ordenó bien por nombre", h0.darNombre( ).compareTo( h1.darNombre( ) ) <= 0 );
        }
    }

    /**
     * Prueba 6: Verifica el método de ordenar por velocidad. <b> Métodos a probar: </b> <br>
     * ordenarPorVelocidad. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorVelocidad() ordena el sistema de forma correcta (en orden descendente por velocidad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por velocidad, el huracán con la menor velocidad debe quedar de primero y el de mayor velocidad de último.
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

            assertTrue( "No se ordenó bien por velocidad", h0.darVelocidad( ) >= h1.darVelocidad( ) );
        }
    }

    /**
     * Prueba 7: Verifica el método de ordenar por costo estimado en daños <b><br>
     * Métodos a probar: </b> <br>
     * ordenarPorDanios. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorDanios() ordena el sistema de forma correcta (en orden ascendente por costo estimado en daños). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar el sistema por costo en daños, el huracán con el menor costo estimado en daños debe quedar de primero y el de mayor costo en daños de último.
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

            assertTrue( "No se ordenó bien por danios", h0.darCostoEstimadoDanios( ) <= h1.darCostoEstimadoDanios( ) );
        }
    }

    /**
     * Prueba 8: Verifica el método buscarHuracanMayorCostoDanios funcione correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarHuracanMayorCostoDanios. <br>
     * <b> Objetivo: </b> Probar que el método buscarHuracanMayorCostoDanios() retorna el huracán correcto (el que tiene mayor costo estimado en daños). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el huracán con mayor costo estimado en daños se debe obtener la posición del huracán con el costo estimado en daños en el sistema. <br>
     * 2. Al buscar el huracán con mayor costo estimado en daños en un sistema vacío la posición retornada debe ser -1.
     */
    //TODO Parte 2 punto O: Implementar el método de prueba según la documentacion.
    
    /**
     * Prueba 9: Verifica el método buscarHuracanMenorCostoDanios funcione correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarHuracanMenorCostoDanios. <br>
     * <b> Objetivo: </b> Probar que el método buscarHuracanMenorCostoDanios() retorna el huracán correcto (el que tiene menor costo estimado en daños). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el huracán con menor costo estimado en daños, se debe obtener la posición del huracán con el costo estimado en daños más pequeño en el sistema. <br>
     * 2. Al buscar el huracán con menor costo estimado en daños en un sistema vacío, la posición retornada debe ser -1.
     */
    //TODO Parte 2 punto P: Implementar el método de prueba según la documentacion.
    
    /**
     * Prueba 10: Verifica el método buscarHuracanMayorVelocidad funcione correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarHuracanMayorVelocidad. <br>
     * <b> Objetivo: </b> Probar que el método buscarHuracanMayorVelocidad() retorna el huracán correcto (el que tiene mayor velocidad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el huracán con mayor velocidad, se debe obtener la posición del huracán con la velocidad en el sistema. <br>
     * 2. Al buscar el huracán con mayor velocidad en un sistema vacío, la posición retornada debe ser -1.
     */
    //TODO Parte 2 punto Q: Implementar el método de prueba según la documentacion.
    
    // -----------------------------------------------------------------
    // Métodos Auxiliares
    // -----------------------------------------------------------------
    /**
     * Carga los huracanes del sistema especificada a partir de un archivo de propiedades.
     * @param pArchivo Nombre del archivo de propiedades que contiene la información de los huracanes.
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
                // Carga un huracán
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