/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8queens;

import java.util.Collections;
import java.util.*;

/**
 *
 * @author uzielgl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Tablero t = new Tablero();
        
        /*
        System.out.println(t.bidimensional() ) ;
        System.out.println( "Ataques : " + t.getCalidad() );
        * */
        
        
        
        
        
        for( j in 1..30 ){
            
            Tablero solucion = null;
            def i = 0;
            Poblacion p = new Poblacion();
            
            for(  ; i<10000 ; i++){    
                ArrayList<Tablero> rands = p.get5randoms();
                ArrayList<Tablero> best2 = p.get2best( rands );
                ArrayList<Tablero> childs = p.cruzar( best2.get(0), best2.get(1) );
                p.mutate( childs );
                
                p.poblacion.addAll( childs );
                
                Collections.sort( p.poblacion );
                
                p.poblacion = new ArrayList<Tablero>( p.poblacion.subList(0, 100) );

                if( p.poblacion.get(0).getCalidad() == 0 ){
                    solucion = p.poblacion.get(0);
                    i++;
                    break;
                }
            }
            
            println "--------------- Corrida $j ------------------"
            println "Evaluciones o generaciones: " + i;
            println solucion.bidimensional()
            println "---------------------------------------------"
            println ""
            
        }
        
        
        
        

        /*
        System.out.println( p.poblacion );
        */
        /*
        Collections.sort( p.poblacion );
        
        System.out.println( p.poblacion );
        * */
        
    } 
}

