/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg8queens

/**
 *
 * @author uzielgl
 */
class Poblacion{
    public ArrayList poblacion = [];
    public mutationProbability = 0.8;
    
    
    public Poblacion(  ){
        Tablero t;

        for( i in 0..99){
            t = new Tablero();
            poblacion.add( t );
        }        
    }
    
    public ArrayList<Tablero> get5randoms(){
        Collections.shuffle( poblacion );
        return [ poblacion[0], poblacion[1], poblacion[2], poblacion[3], poblacion[4] ];
    }
    
    public ArrayList<Tablero> get2best( ArrayList<Tablero> tableros ){
        Collections.sort( tableros );
        return [ tableros[0], tableros[1] ];
    }
    
    
    public ArrayList<Tablero> cruzar( Tablero parent1, Tablero parent2 ){
        /*
        println parent1;
        println parent2;
        println "";
        */
        
        Integer crosspoint = new Random().nextInt(7) + 1;
        
        //println crosspoint;
        
        def c1_1 = (ArrayList) crosspoint == 1 ? [ parent1.queens[0] ] : parent1.queens[0..<crosspoint]; //Children 1 part 1
        def c1_2 = (ArrayList) crosspoint == 7 ? [ parent1.queens[7] ] : parent1.queens[crosspoint..7]; //Children 1 part 2
        
        def c2_1 = (ArrayList) crosspoint == 1 ? [ parent2.queens[0] ] : parent2.queens[0..<crosspoint]; //Children 1 part 1
        def c2_2 = (ArrayList) crosspoint == 7 ? [ parent2.queens[7] ] : parent2.queens[crosspoint..7]; //Children 1 part 2
        
        /*
        println c1_1;
        println c1_2;
        
        println c2_1;
        println c2_2;
        println "";
        */
        return [ new Tablero( join( c1_1, c2_2) ), new Tablero( join( c2_1, c1_2) ) ];
    }
    
    
    public mutate( ArrayList<Tablero> ts){
        for( Tablero t: ts){
            if( Math.random() <= mutationProbability  ){
                t.mutate();
            }
        }
    }
    
    /** Juntar dos array de posiciones de listas e.g. [1,2,3] [3,4,5,2,1,2] : [1,2,3,4,5,6,7,8]
     *y rellenar los faltantes*/
    public ArrayList join( ArrayList part1, ArrayList part2 ){
        for( int i : part2 ) if( !( i in part1) ) part1 << i;
                
        for( i in 1..8) if( !( i in part1 ) ) part1 << i;

        return part1;
    }
   
}

