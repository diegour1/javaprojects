/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: fabricaDeCarros
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que representa la fabrica de carros.
 */
public class FabricaDeCarros
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Ruta del archivo donde se est� salvando actualmente la f�brica.
     */
    private String rutaArchivo;

    /**
     * Lista con las partes que hay en la f�brica, ordenados en el orden en el que fueron agregados. <br>
     * Las partes se pintan en el mismo orden que aparecen aqu�.
     */
    private List partes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva f�brica sin partes. <br>
     * <b>post: </b>Se inicializ� la lista de partes. <br>
     */
    public FabricaDeCarros( )
    {
        rutaArchivo = null;
        //TODO Parte3 PuntoA. Inicializar la lista de partes.
        partes = new ArrayList();
        verificarInvariante( );
    }

    /**
     * Retorna la colecci�n de partes de carro de la f�brica.
     * @return Colecci�n de partes.
     */
    public Collection darPartes( )
    {
        return partes;
    }

    //
    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna la ruta del archivo donde se est� guardando la informaci�n de esta f�brica.
     * @return Ruta del archivo. Si no se ha establecido todav�a el valor de rutaArchivo, retorna null.
     */
    public String darRutaArchivo( )
    {
        return rutaArchivo;
    }

    /**
     * Retorna una lista con todos los tipo de partes posibles.
     * @return Lista con los tipos de las partes.
     */
    public ArrayList darTipos( )
    {
        ArrayList tipos = new ArrayList( );
        tipos.add( DelanteraCamioneta.TIPO );
        tipos.add( DelanteraSedan.TIPO );
        tipos.add( DelanteraCompacto.TIPO );
        tipos.add( TraseraSedan.TIPO );
        tipos.add( TraseraCamioneta.TIPO );
        tipos.add( TraseraCompacto.TIPO );
        tipos.add( Calavera.TIPO );
        tipos.add( Teselacion.TIPO );
        tipos.add( Rayo.TIPO );
        tipos.add( RinesEconomicos.TIPO );
        tipos.add( RinesGamaMedia.TIPO );
        tipos.add( RinesDeLujo.TIPO );
      //TODO Parte9 PuntoC. Complete el m�todo agregando los tipos de las clases que cre�.
        return tipos;
    }

    /**
     * Carga una f�brica leyendo un archivo. <br>
     * <b>pre: </b> El archivo de lectura existe.<br>
     * <b>post: </b> Se elimin� la f�brica anterior y se carg� la nueva.<br>
     *               Se actualiz� la ruta del archivo.
     * @param pRutaArchivo Nueva ruta de archivo de donde se lee la informaci�n. pRutaArchivo!=null && !pRutaArchivo.equals("").
     * @throws Exception Si hay problemas leyendo el rutaArchivo
     * @throws Exception Si el formato del archivo no es el esperado.
     */
    public void abrir( String pRutaArchivo ) throws Exception
    {
        List partesAnteriores = new ArrayList( );
        // Cargar las partes
        BufferedReader br = new BufferedReader( new FileReader( pRutaArchivo ) );
        String linea = br.readLine( );
        try
        {
            // Salvar las partes anteriores por si se presenta alg�n error
            partesAnteriores.addAll( partes );

            // Eliminar las partes anteriores
            partes.clear( );

            // Crear las partes
            int cuantasPartes = Integer.parseInt( linea );
            for( int i = 0; i < cuantasPartes; i++ )
            {
                linea = br.readLine( );
                crearParte( linea, br );
            }

            br.close( );
        }
        catch( NumberFormatException nfe )
        {
            br.close( );
            partes.clear( );
            partes.addAll( partesAnteriores );
            throw new Exception( "Error de formato" );
        }

        // Cambia la ruta por la nueva ruta de archivo
        rutaArchivo = pRutaArchivo;

        verificarInvariante( );
    }

    /**
     * Agrega la parte dada por par�metro a la f�brica. <br>
     * <b>post: </b> La parte fue agregada a la f�brica.
     * @param pF Parte a agregar. pF != null.
     */
    public void agregarParte( IParte pF )
    {
        partes.add( pF );
        verificarInvariante( );
    }

    /**
     * Retorna la �ltima parte que se encuentre en la lista que contiene los puntos especificados.
     * @param pX Coordenada x buscada. pX >= 0.
     * @param pY Coordenada y buscada. pY >= 0.
     * @return Parte que contiene los puntos especificados, null si no existe ninguna.
     */
    public IParte buscarParte( int pX, int pY )
    {
        //TODO Parte3 PuntoD. Complete el m�todo seg�n la documentaci�n dada usando Iterator.
        IParte iParteBuscada = null;
        Iterator iter = partes.iterator( );
        while(iter.hasNext( ))
        {
            IParte p = (IParte) iter.next( );
            //if(p.darX( ) >= pX && p.darY( ) >= pY && (p.darX( ) + p.darAncho( ) <= pX) && (p.darY( ) + p.darAlto( ) <= pY) )
            if(p.estaDentro( pX, pY ))
            {
                iParteBuscada = p;
            }
        }
        return iParteBuscada;
    }

    /**
     * Cambia la posici�n de la parte con las caracter�sticas dadas al nuevo punto de coordenadas dadas. <br>
     * <b>post: </b> La parte con las caracter�sticas tiene las nuevas coordenadas.
     * @param pX Coordenada en x donde se encuentra la parte a cambiar de posici�n. pX >= 0.
     * @param pY Coordenada en y donde se encuentra la parte a cambiar de posici�n. pY >= 0.
     * @param pNuevoX Nueva coordenada en x donde se desea posicionar la parte. pNuevoX >= 0.
     * @param pNuevoY Nueva coordenada en y donde se desea posicionar la parte. pNuevoY >= 0.
     */
    public void cambiarPosicionParte( int pX, int pY, int pNuevoX, int pNuevoY )
    {
        IParte parteRev = buscarParte( pX, pY );
        if( parteRev != null )
        {
            parteRev.cambiarX( pNuevoX );
            parteRev.cambiarY( pNuevoY );
        }
        verificarInvariante( );
    }

    /**
     * Crea una parte con los datos contenidos en rutaArchivo y la adiciona a la lista respectiva. <br>
     * <b>post: </b> Se cre� la parte y se agreg� a la f�brica.
     * @param pTipoParte Tipo de la parte a crear. pTipoParte !=null && pTipoParte pertenece a {DelanteraCamioneta.TIPO, DelanteraCompacto.TIPO,
     *        DelanteraSedan.TIPO, RinesDeLujo.TIPO, RinesGamaMedia.TIPO, RinesGamaBaja.TIPO, TraseraCamioneta.TIPO, TraseraCompacto.TIPO, TraseraSedan.TIPO}.
     * @param pBr Stream de donde se pueden leer los datos para crear la construcci�n. pBr!=null.
     * @throws Exception Si hay problemas leyendo el rutaArchivo.
     * @throws Exception Si el formato del rutaArchivo no es el esperado.
     */
    private void crearParte( String pTipoParte, BufferedReader pBr ) throws Exception
    {
        IParte nuevaParte = null;
        if( pTipoParte.equals( RinesEconomicos.TIPO ) )
        {
            nuevaParte = new RinesEconomicos( pBr );
        }
        else if( pTipoParte.equals( RinesGamaMedia.TIPO ) )
        {
            nuevaParte = new RinesGamaMedia( pBr );
        }
        else if( pTipoParte.equals( RinesDeLujo.TIPO ) )
        {
            nuevaParte = new RinesDeLujo( pBr );
        }
        else if( pTipoParte.equals( DelanteraCamioneta.TIPO ) )
        {
            nuevaParte = new DelanteraCamioneta( pBr );
        }
        else if( pTipoParte.equals( DelanteraSedan.TIPO ) )
        {
            nuevaParte = new DelanteraSedan( pBr );
        }
        else if( pTipoParte.equals( DelanteraCompacto.TIPO ) )
        {
            nuevaParte = new DelanteraCompacto( pBr );
        }
        else if( pTipoParte.equals( TraseraCamioneta.TIPO ) )
        {
            nuevaParte = new TraseraCamioneta( pBr );
        }
        else if( pTipoParte.equals( TraseraSedan.TIPO ) )
        {
            nuevaParte = new TraseraSedan( pBr );
        }
        else if( pTipoParte.equals( TraseraCompacto.TIPO ) )
        {
            nuevaParte = new TraseraCompacto( pBr );
        }
        else if( pTipoParte.equals( Calavera.TIPO ) )
        {
            nuevaParte = new Calavera( pBr );
        }
        else if( pTipoParte.equals( Teselacion.TIPO ) )
        {
            nuevaParte = new Teselacion( pBr );
        }
        else if( pTipoParte.equals( Rayo.TIPO ) )
        {
            nuevaParte = new Rayo( pBr );
        }
        //TODO Parte9 PuntoB. Complete el m�todo agregando las clases que cre�.
        else
        {
            throw new Exception( "Error en el formato del rutaArchivo. El tipo " + pTipoParte + " es incorrecto." );
        }
        partes.add( nuevaParte );
        verificarInvariante( );
    }

    /**
     * Crea y retorna una parte con las especificaciones dadas por par�metro.<br>
     * <b> post: </b> Se cre� la parte con los datos dados por par�metro.
     *  @param pTipoParte Tipo de la parte a crear. pTipoParte !=null && pTipoParte pertenece a {DelanteraCamioneta.TIPO, 
     *                   DelanteraCompacto.TIPO, DelanteraSedan.TIPO, RinesDeLujo.TIPO, RinesGamaMedia.TIPO, RinesGamaBaja.TIPO, TraseraCamioneta.TIPO,
     *                   TraseraCompacto.TIPO, TraseraSedan.TIPO}.
     * @param pX Coordenada x de la parte. pX >= 0.
     * @param pY Coordenada y de la parte. pY >= 0.
     * @param pColorCarro Color del carro. pColorCarro != null.
     * @return Parte creada con las especificaciones dadas.
     */
    public Parte crearParte( String pTipoParte, int pX, int pY, Color pColorCarro )
    {
        Parte nuevaParte = null;
        if( pTipoParte.equals( RinesEconomicos.TIPO ) )
        {
            nuevaParte = new RinesEconomicos( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( RinesGamaMedia.TIPO ) )
        {
            nuevaParte = new RinesGamaMedia( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( RinesDeLujo.TIPO ) )
        {
            nuevaParte = new RinesDeLujo( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( DelanteraCamioneta.TIPO ) )
        {
            nuevaParte = new DelanteraCamioneta( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( DelanteraSedan.TIPO ) )
        {
            nuevaParte = new DelanteraSedan( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( DelanteraCompacto.TIPO ) )
        {
            nuevaParte = new DelanteraCompacto( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( TraseraCamioneta.TIPO ) )
        {
            nuevaParte = new TraseraCamioneta( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( TraseraSedan.TIPO ) )
        {
            nuevaParte = new TraseraSedan( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( TraseraCompacto.TIPO ) )
        {
            nuevaParte = new TraseraCompacto( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( Calavera.TIPO ) )
        {
            nuevaParte = new Calavera( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( Teselacion.TIPO ) )
        {
            nuevaParte = new Teselacion( pX, pY, pColorCarro );
        }
        else if( pTipoParte.equals( Rayo.TIPO ) )
        {
            nuevaParte = new Rayo( pX, pY, pColorCarro );
        }
        //TODO Parte9 PuntoA. Complete el m�todo agregando las clases que cre�.
        
        return nuevaParte;
    }

    /**
     * Elimina la parte que contiene los puntos especificados.<br>
     * Si no se encuentra ninguna parte con estas caracter�sticas, no se elimina nada.<br>
     * <b>post: </b> La parte con las caracter�sticas especificadas no se encuentra en la lista de partes.
     * @param pX Coordenada en x de la parte a eliminar. pX >= 0.
     * @param pY Coordenada en y de la parte a eliminar. pY >= 0.
     */
    public void eliminarParte( int pX, int pY )
    {
        //TODO Parte3 PuntoE. Completar seg�n la documentaci�n del m�todo usando Iterator.
        boolean eliminado = false;
        Iterator iter = partes.iterator( );
        IParte pBuscada = buscarParte(pX, pY);
        while(iter.hasNext( ) && !eliminado)
        {
            IParte p = (IParte) iter.next( );
            if(pBuscada.equals( p ))
            {
                partes.remove( p );
                eliminado = true;
            }
        }
    }

    /**
     * Pinta todas las partes sobre la superficie proporcionada. <br>
     * <b>post: </b> Se pintan todas las partes en el lienzo.
     * @param pG Es la superficie sobre la que deben quedar las partes. pG != null y pG es una superficie limpia (no se va a borrar antes de pintar).
     */
    public void pintarPartes( Graphics2D pG )
    {
        //TODO Parte3 PuntoC. Completar seg�n la documentaci�n del m�todo usando Iterator.
        //Recuerde que cada parte sabe como dibujarse.
        Iterator iter = partes.iterator( );
        while(iter.hasNext())
        {
            IParte p = (IParte) iter.next( );
            p.pintar( pG );
        }
    }

    /**
     * Reinicia la f�brica, eliminando todas las partes. <br>
     * <b>post: </b> La lista de partes se encuentra vac�a y la ruta de rutaArchivo es nula.
     */
    public void reiniciar( )
    {
        partes.clear( );
        rutaArchivo = null;
        verificarInvariante( );
    }

    /**
     * Guarda la f�brica actual en la rutaArchivo que se ven�a usando. <br>
     * <b>post: </b> Se guard� la f�brica en la rutaArchivo.
     * @throws IOException Si hay problemas guardando la f�brica.
     */
    public void guardar( ) throws IOException
    {
        //TODO Parte3 PuntoB. Completar seg�n la documentaci�n del m�todo usando Iterator.
        //Recuerde que cada parte sabe guardarse.
        try
        {
            Iterator iter = partes.iterator();
            while ( iter.hasNext( ))
            {
                IParte p = (IParte) iter.next();
                p.guardar( new PrintWriter(rutaArchivo) );
            }            
        }
        catch(IOException e)
        {
            throw new IOException("Error al guardar cada parte en el archivo");
        }
    }

    /**
     * Guarda la f�brica actual en la rutaArchivo dado por par�metro.<br>
     * <b>post: </b> Se actualiz� la rutaArchivo con la nueva ruta pArchivoRuta y se guard� la f�brica en este archivo.
     * @param pRutaArchivo Nombre del rutaArchivo en donde se guardar� la f�brica. pRutaArchivo != null && !pRutaArchivo.equals("").
     * @throws IOException Si hay problemas guardando la f�brica.
     */
    public void guardar( String pRutaArchivo ) throws IOException
    {
        rutaArchivo = pRutaArchivo;
        guardar( );
    }

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv: </b><br>
     * partes != null.
     */
    private void verificarInvariante( )
    {
        assert ( partes != null ) : "La lista de partes debe estar inicializada";

    }

    // -----------------------------------------------------------------
    // M�todos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

}