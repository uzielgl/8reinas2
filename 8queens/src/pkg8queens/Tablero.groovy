/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg8queens
/**
 *
 * @author uzielgl
 */
class Tablero implements Comparable<Tablero>{
    
    def r = new Random();
    
    //@deprecated
    public ArrayList<Integer> queens = new ArrayList<Integer>();
    
    
    public tablero = []; //El tablero sera de 8 x 8 
    
    
    public Tablero(){
        for( i in 0..7){
            tablero[i] = [];
            for( j in 0..7 ){
                tablero[i][j] = "0";
            }
        }
        
        //Agregamos las 8 reinas
        for( i in 1..8){
            addReina();
        }
    }
    
    public Tablero( ArrayList queens){
        for( i in 0..7){
            tablero[i] = [];
            for( j in 0..7 ){
                tablero[i][j] = "0";
            }
        }
        for( Reina r: queens ){
            addReina( r.row, r.col );
        }
    }
    
    public String bidimensional(){
        //Armamos la cadena
        String t = "";
        for( ArrayList tab: tablero)
            t += tab.toString() + "\n";
        return t.toString();
    }
    
    //Agrega una reina en cierta posición aleatoreamente
    public addReina(  ){
        def row;
        def col;
        for(;;){
            row = r.nextInt(8);
            col = r.nextInt(8);
            if( tablero[row][col] == "0"){
                tablero[row][col] = new Reina( row, col );
                break;
            }
        }
        return tablero[row][col];
    }
    
    public addReina( row, col ){
        if( tablero[row][col] == "0" ){
            tablero[row][col] = new Reina( row, col);
            return true;
        }
        return false;
    }
    
    /** Regresa el total de ataques en el tablero, sólo el primer ataque de 
     * izquierda a derecha, barriendo todas las posiciones
     * */
    public int getCalidad(){
        def ataques = 0;
        def reinas = getReinas();
        for( Reina r: reinas) {
            for( Reina r2: reinas )
                if( r != r2 ){
                    if ( r.isThreatFor( r2 ) ){
                        ataques++;
                    }
                }
        }
        return ataques;
    }
    
    public getReinas(){
        def reinas = [];
        for( i in 0..7)
            for (j in 0..7)
                if( tablero[i][j] instanceof Reina )
                    reinas << tablero[i][j]
        return reinas;
    }
    
    /** 
     **/
    public Tablero cruza( Tablero other){
        def queens = [];
        
        def queens1 = this.getReinas();
        def queens2 = other.getReinas();
        
        for( i in 0..7 ){
            def pos = r.nextInt(2);
            def opuesto_pos = pos == 0 ? 1: 0;
            def tablero_to_user = [ queens1, queens2 ][ pos ];
            def tablero_opuesto = [ queens1, queens2 ][ opuesto_pos ];
            
            if( isQueenIn( queens, tablero_to_user[i] ) ){
                //println "TRUE"
                queens << tablero_opuesto[i];
            }else
                queens << tablero_to_user[ i ];
        }      
        
        Tablero tableroHijo = new Tablero( queens );
        /*
        println queens1;
        println queens2
        println queens
        */
        //println tableroHijo.getReinas();
        /*
        if( tableroHijo.getReinas().size() < 8){
            //println this.bidimensional();
            //println other.bidimensional();
            //println tableroHijo.bidimensional();
            println this.getReinas();
            println other.getReinas();
            println tableroHijo.getReinas();
        }
        println "";
        */
        return tableroHijo
    }
    
    /** Determina si la reina está en ese arreglo de reinas*/
    public isQueenIn( ArrayList reinas, Reina reina){
        for( r in reinas){
            if( r == reina ) return true;
        }
        return false;
    }
    
     public mutate( ){
         //escogemos una reina al azar
         def reina = this.getReinas()[ r.nextInt(8) ];
         //escogemos una nueva posición
         def row;
         def col;
         for(;;){
            row = r.nextInt(8);
            col = r.nextInt(8);
            if( tablero[row][col] == '0'){
                //Eliminamos la antigua reina
                tablero[ reina.row ][ reina.col ] = '0';
                //Movemos a nueva posición
                tablero[row][col] = reina;
                //Actualizamos 
                reina.col = col;
                reina.row = row;
                break;
            }
         }
    }
    
    /********* No usadas todavia **********************/
    
    
    
    
    /*
    public Tablero( ){
        
        //this.queens = queens;
    }
     */
    
    public String toString(){
        return getCalidad();
    }
    

    
    
    
   
    
    public void setQueens( queens ){
        this.queens = queens;
    }
    
    
   
    
    /** Lo ordena de menor a mayor considerando su número de ataques*/
    public int compareTo( Tablero otroTablero ){
        return getCalidad() - otroTablero.getCalidad();
    }
}

