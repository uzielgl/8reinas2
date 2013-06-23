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
        
        Poblacion p = new Poblacion();
              
        
        
        ArrayList<Tablero> rands = p.get5randoms();
        
        
        
        ArrayList<Tablero> best2 = p.get2best( rands );
        
        ArrayList<Tablero> childs = p.cruzar( best2.get(0), best2.get(1) );
        
        p.mutate( childs );
        
        p.poblacion.addAll( childs );
        
        Collections.sort( p.poblacion );
        
        p.poblacion = new ArrayList<Tablero>( p.poblacion.subList(0, 100) );
        
        
        
        
        /*
        System.out.println( p.poblacion );
        */
        /*
        Collections.sort( p.poblacion );
        
        System.out.println( p.poblacion );
        * */
        
    } 
}

