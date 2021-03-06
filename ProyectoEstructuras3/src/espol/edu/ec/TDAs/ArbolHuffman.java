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

    public ArbolHuffman() {
        this.raiz = null;
    }
    
    
    
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
            else
            {
                this.raiz = primerNodo;
            }
            
        }
    }
    
    public HashMap<String,String> calcularCodigos (){
        
        HashMap<String, String> mapa = new HashMap<>();
        calcularCodigos(mapa, this.raiz,"");
        return mapa;
    }
    
    private void calcularCodigos(HashMap<String,String> mapa, Nodo nodo, String resultado)
    {
        if(1==nodo.getData().toString().length())
        {
            mapa.put(nodo.getData().toString(), resultado);
        }
        else
        {
            calcularCodigos(mapa, nodo.getIzquierdo(), resultado+"0"); //izquierda 0 derecha 1
            calcularCodigos(mapa,nodo.getDerecho(), resultado+"1");
        }
    }
    
    public String codificar (String texto, HashMap<String,String> mapa){
        String resultado = "";
        for(char letra: texto.toCharArray())
        {
            resultado+= mapa.get(String.valueOf(letra));
        }
        return resultado;
    }
    
    public String decodificar (String texto, HashMap<String,String> mapa){
        String resultado = "";
        String temporal = "";
        HashMap<String,String> mapaDecodificar = new HashMap<>();
        mapa.forEach((k, v)->mapaDecodificar.put(v, k));
        for(char num: texto.toCharArray())
        {
            if (mapaDecodificar.containsKey(temporal))
            {
                resultado+=mapaDecodificar.get(temporal);
                temporal = String.valueOf(num);
            }
            else
            {
                temporal+= String.valueOf(num); //decodificar saca una g menos por alguna razón
            }
        }
        resultado += mapaDecodificar.get(temporal);
        return resultado;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }
    
    @Override
    public String toString() {
        return toString(this.raiz);
    }

    private String toString(Nodo<E> nodo) {
        if(nodo!=null)
        {
            String cadena="";
            if(nodo.getDerecho()!= null && nodo.getIzquierdo()!= null)
            {
                cadena += nodo+"["+nodo.getIzquierdo()+", "+nodo.getDerecho()+"] ";
            }
            else if(nodo.getDerecho()!= null && nodo.getIzquierdo()== null)
            {
                cadena += nodo+"["+"null, "+nodo.getDerecho()+"] ";
            }
            else if(nodo.getDerecho()== null && nodo.getIzquierdo()!= null)
            {
                cadena += nodo+"["+nodo.getIzquierdo()+", null"+"] ";
            }
            else if(nodo.getDerecho()== null && nodo.getIzquierdo()== null)
            {
                cadena+=nodo+"[null, null] ";
            }
            return cadena + toString(nodo.getIzquierdo())+ toString(nodo.getDerecho());
        }
        return "";
    }
}
