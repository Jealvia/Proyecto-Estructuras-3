/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

/**
 *
 * @author Julio Alvia
 * @param <E>
 */
public class Nodo <E>{
    private Nodo<E> izquierdo,derecho;
    private E data;
    private int frecuencia;

    public Nodo(E data, int frecuencia) {
        this.data = data;
        this.izquierdo=this.derecho=null;
        this.frecuencia = frecuencia;
    }

    public Nodo<E> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo<E> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo<E> getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo<E> derecho) {
        this.derecho = derecho;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
    
    @Override
    public String toString(){
        return "("+this.data.toString()+", "+this.frecuencia+")";
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    
    
}
