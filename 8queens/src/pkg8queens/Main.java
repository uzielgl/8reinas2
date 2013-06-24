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
        
        for ( int a = 1; a < 31; a++){
        
            int i = 0;
            Tablero best_solucion = null;
            Poblacion p = new Poblacion( 100 );      
            for( ; i<10000; i++){
                ArrayList<Tablero> parents = p.getParents();
                ArrayList<Tablero> childs = p.getChilds( parents);
                //Mutamos los hijos
                p.mutate( childs );

                //Agregamos los hijos a la población inicial y ordenamos
                p.poblacion.addAll(childs);

                //Eliminamos los peores
                Collections.sort(p.poblacion);
                p.poblacion = new ArrayList<Tablero>( p.poblacion.subList(0, 100) );

                //Posible solución 
                best_solucion = (Tablero) p.poblacion.get(0);
                if( i % 1000 == 0 ){
                    System.out.println("evaluacion " + i);
                    System.out.println("calidad "  + best_solucion.getCalidad() );
                //System.out.println( best_solucion.bidimensional() ) ;
                }
                if( best_solucion.getCalidad() == 0){
                    break;
                }
            }
            
            /*
            System.out.println( best_solucion.bidimensional() );
            System.out.println("evaluaciones " + i);
            System.out.println( best_solucion );
            * */
            
            System.out.println("--------------- Corrida " + a + " ------------------");
            System.out.println("Evaluciones o generaciones: " + i);
            System.out.println(best_solucion.bidimensional() );
            System.out.println("Calidad: " + best_solucion );
            System.out.println("---------------------------------------------");
            System.out.println("");
            
        }
        
        
        
        
        
        
        
  
        
        
        
        //Tablero t = new Tablero();
        
        /*
        System.out.println(t.bidimensional() ) ;
        System.out.println( "Ataques : " + t.getCalidad() );
        * */
        
        /*
        Tablero t = new Tablero();
        println t.bidimensional();
        println t.getCalidad();        
        /*
         *
        for(i in 0..1000){
            t.mutate();
        
            println t.bidimensional();
            println t.getCalidad();
        }*/
        
     
        
        /*
        Tablero t2 = new Tablero();
        println t2.bidimensional();
        println t2.getCalidad();
        
        Tablero c = t.cruza( t2 );
        println c.bidimensional();
        println c.getCalidad();
        */
        
        
        
        
        
        /*
        
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
        
        */
        
        

        /*
        System.out.println( p.poblacion );
        */
        /*
        Collections.sort( p.poblacion );
        
        System.out.println( p.poblacion );
        * */
        
    } 
}

