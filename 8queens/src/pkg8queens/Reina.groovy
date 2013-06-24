/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg8queens

/**
 *
 * @author uzielgl
 */
class Reina {
    public int row;
    public int col;
    
    public Reina( row, col){
        this.row = row;
        this.col = col;
    }
    
    public setLocation( row, col ){
        this.row = row;
        this.col = col;
    }
    
    public String toString(){
        return "R";
    }
    
    
    /** Determina si está reina, es una amaneza (puede atacar) a otra
     * @param Reina r - La otra reina a evaluar, para deteminar si la puede atacar o no 
     **/
    public boolean isThreatFor( Reina r ){
        if( row == r.row  || col == r.col )
            return true;
        if( getPendiente(this, r) == 1 || getPendiente(this, r) == -1)
            return true;
        return false;
    }
    
    /* Obtienen el angulo entre dos Reinas
     **/
    public getPendiente( Reina r1, Reina r2 ){
        def m = ( r2.row - r1.row ) / ( r2.col - r1.col );
        return m;
    }
    
    public boolean equals( Reina o){
        if ( row == o.row && col == o.col ) return true;
        return false;
    }
    
    
    
    
}

