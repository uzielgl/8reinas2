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
    public ArrayList<Integer> queens = new ArrayList<Integer>();
    
    public Tablero(){
        queens = [1,2,3,4,5,6,7,8]; 
        Collections.shuffle( queens );
        //queens = [5,2,1,4,6,8,7,3]; //4 ataques
        //queens = [2,3,7,6,4,1,5,8]; // 2 ataques
        //queens = [6,5,4,3,8,1,2,7]; // 5 ataques
        //queens = [1,7,5,3,6,4,8,2]; // 2 ataques
    }
    
    public Tablero( queens ){
        this.queens = queens;
    }
    
    public String toString(){
        return queens.toString() + " calidad: " + getCalidad();
    }
    
    /** Regresa el total de ataques en el tablero, sólo el primer ataque de 
     * izquierda a derecha, barriendo todas las posiciones
     * */
    public int getCalidad(){
        def ataques = 0;
        for( i in 0..7){
            for( def j=i+1; j < 8; j++){
                def m = get_pendiente(i, j);
                //println m
                if(  m == 1 || m == -1 ){
                    ataques++;
                    break;
                }
            }
        }
        return ataques;
    }
    
    /* Obtienen el angulo entre dos posiciones del tablero [x,x,x,x,x,x,x,x] (dos de esas X)
     * para convertirlo a puntos cardinales, la posición es la X y el valor en la posición -1 es la Y
     **/
    public get_pendiente( pos1, pos2 ){
        def m = ( queens[ pos2 ] - queens[ pos1 ] ) / ( ( pos2 + 1 ) - ( pos1 +1 ) );
        /*
        println "" + ( pos1+1 ) + ", " + queens[pos1];
        println "" + ( pos2+1 ) + ", " + queens[pos2];
        println Math.toDegrees(Math.atan( m ));
        println m
        println ""
        */
        return m;
    }
    
    public String bidimensional(){
        def String[][] tablero = new String[8][8];
        for( i in 0..7){
            for ( j in 0..7)
                tablero[i][j] = "0";
        }
        
        for( i in 0..7){
            tablero[ queens[i] - 1 ][i] = "X";
        }
        
        //Armamos la cadena
        String t = "";
        for( String[] tab: tablero)
            t += tab.toString() + "\n";
        
        return t.toString();
    }
    
    public void setQueens( queens ){
        this.queens = queens;
    }
    
    
    public mutate( ){
        def options = [0,1,2,3,4,5,6,7];
        def r1 = new Random().nextInt(8); //Primera posición a cambiar
        def v1 = queens.get( r1 ); // valor de esa posición
        
        options.remove( r1 );
        
        def r2 = new Random().nextInt(7); //Segunda posición a cambiar
        def v2 = queens.get( r2 ); // valor de esa posición
        
        queens[ r1 ] =  v2;
        queens[ r2 ] =  v1;
        /*
        
        def i = new Random( ).nextInt( 8 );
        def t = queens.get(i); //Obtenemos el que se a a in tercambiar
        
        queens.remove( i );
        
        //como ya es de 7 elementos, insertamos del 0 al 6
        i = new Random().nextInt( 8 );
        
        queens.putAt( 7..<7, t );  //Metemos el que generamos preiamente
        
        */
        //println queens;
    }
    
    /** Lo ordena de menor a mayor considerando su número de ataques*/
    public int compareTo( Tablero otroTablero ){
        return getCalidad() - otroTablero.getCalidad();
    }
}

