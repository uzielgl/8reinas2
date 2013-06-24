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
    public parentsPercent = 0.25;
    public bestPercent = 0.75;
    public worstPercent = 0.25;
    
    public r = new Random();
    
    public Poblacion( int tam ){
        Tablero t;
        for( i in 0..<tam){
            t = new Tablero();
            poblacion.add( t );
        }        
    }
    
    /** Obtenemos los padres que se van a cruzar, de acuerdo a las propiedaddes
     *de esta clase*/
    public ArrayList<Tablero> getParents(){
        Collections.sort( poblacion );
        def middle =  (int)this.poblacion.size() / 2; ///
        def bests = (ArrayList) this.poblacion[0..<middle];
        def worst = (ArrayList) this.poblacion[middle..<this.poblacion.size()];
        
        //obtenemos un porcentaje de los mejores
        def best_total = (int) ( parentsPercent * bestPercent ) * poblacion.size();
        def worst_total = (int) ( parentsPercent * worstPercent) * poblacion.size();
        
        def selections_bests = bests[0..<best_total];
        
        def selections_worst = [];
        for ( i in 0..<worst_total){
            def pos = r.nextInt( worst.size() );
            selections_worst << worst[pos];
            worst.remove( pos );
        }
            
        def r = selections_bests + selections_worst;
        //Si no es par, agregamos alguno de los mejores
        if( r.size() % 2 != 0) r.add( bests[ best.size() - 1 ] );
        
        return r;
    }
    
    
    public ArrayList<Tablero> getChilds( ArrayList<Tablero> parents){
        def pares = parents.collate( 2 );
        def childs = [];
        for( i in pares){
            childs <<  i[0].cruza( i[1] );
        }
        return childs;
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

