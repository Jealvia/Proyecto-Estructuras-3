/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author Julio Alvia
 * @param <E>
 */
public class ArbolHuffman<E> {
    private Nodo<E> raiz;
    
    
    public void calcularArbol (HashMap<String,Integer> mapa){
        PriorityQueue<Nodo> cola = new PriorityQueue<>((Nodo n1, Nodo n2)->n1.getFrecuencia()-n2.getFrecuencia());
        mapa.forEach((letra, frecuencia)-> cola.offer(new Nodo<>(letra, frecuencia)));
        while(!cola.isEmpty())
        {
            Nodo primerNodo = cola.poll();
            Nodo segundoNodo = cola.poll();
            if(segundoNodo!=null)
            {
                Nodo padre = new Nodo<>(primerNodo.getData().toString()+segundoNodo.getData().toString(), 
                        primerNodo.getFrecuencia()+segundoNodo.getFrecuencia());
                padre.setDerecho(primerNodo);
                padre.setIzquierdo(segundoNodo);
                cola.offer(padre);
            }
            
        }
    }
    
    public HashMap<String,String> calcularCodigos (){
        
        return null;
    }
    
    public String codificar (String texto, HashMap<String,String> mapa){
        
        return null;
    }
    
    public String decodificar (String texto, HashMap<String,String> mapa){
        
        return null;
    }
}
