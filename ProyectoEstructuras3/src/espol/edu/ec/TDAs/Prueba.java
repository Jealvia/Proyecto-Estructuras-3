/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

import static espol.edu.ec.TDAs.Util.hexadecimalBinario;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author User
 */
public class Prueba {
    
    public static ArbolHuffman arbol;
    
    public static void calcularArbol (HashMap<String,Integer> mapa){
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
                arbol= new ArbolHuffman();
                arbol.setRaiz(primerNodo);
            }
            
        }
    }
    
    public static HashMap<String,Integer> calcularFrecuencias (String texto){
        int tam=texto.length();
        HashMap<String,Integer> mapa=new HashMap<>();
        for(int i=0;i<tam;i++){
            if(mapa.get(String.valueOf(texto.charAt(i)))!=null){
                String tmp=String.valueOf(texto.charAt(i));
                mapa.put(tmp,mapa.get(tmp)+1);
            }else{
                String tmp=String.valueOf(texto.charAt(i));
                mapa.put(tmp, 1);
            }
            
        }
        
        
        return mapa;
        
    }
    
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = calcularFrecuencias("AAAAAABBBBBBBBCCCCCDDDDDDDEEEEEEFFFFFFFFGGGGGGGGGGG");
        System.out.println(mapa);
        calcularArbol(mapa);
        System.out.println(arbol);
        arbol.calcularArbol(mapa);
        System.out.println(arbol);
        System.out.println(arbol.calcularCodigos());
        System.out.println(arbol.codificar("AAAAAABBBBBBBBCCCCCDDDDDDDEEEEEEFFFFFFFFGGGGGGGGGGG", arbol.calcularCodigos()));
        System.out.println(arbol.decodificar("0110110110110110110010010010010010010010011111111111111110100100100100100100101101101101101101100000000000000000000000001010101010101010101010", arbol.calcularCodigos()));
        System.out.println("AAAAAABBBBBBBBCCCCCDDDDDDDEEEEEEFFFFFFFFGGGGGGGGGGG");
        System.out.println(hexadecimalBinario("6DB6C924927FFFA4924B6DB6000000AAAAA8--"));
        String s = hexadecimalBinario("6DB6C924927FFFA4924B6DB6000000AAAAA8--");
        System.out.println(s);
        System.out.println(arbol.decodificar(s, arbol.calcularCodigos()));
        //System.out.println("AAAAAABBBBBBBBCCCCCDDDDDDDEEEEEEFFFFFFFFGGGGGGGGGGG".equals(arbol.decodificar("0110110110110110110010010010010010010010011111111111111110100100100100100100101101101101101101100000000000000000000000001010101010101010101010", arbol.calcularCodigos())));
    }
    
}
