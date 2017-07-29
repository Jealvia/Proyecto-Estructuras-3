/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.HashMap;

/**
 *
 * @author Julio Alvia
 */
public class Util {
    
    public static String leerTexto(String nombreArchivo) {
        String linea;
        String cadena = "";
        try {
            FileReader f = new FileReader(nombreArchivo + ".txt");
            BufferedReader br = new BufferedReader(f);
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                cadena += linea;
                //temporal.add(tmp);

            }
        } catch (IOException e) {
        }
        return cadena;

    }
    
    public static HashMap<String,Integer> calcularFrecuencias (String texto){
        int tam=texto.length();
        HashMap<String,Integer> mapa=new HashMap<>();
        for(int i=0;i<tam;i++){
            if(mapa.get(texto.charAt(i))!=null){
                String tmp=String.valueOf(texto.charAt(i));
                mapa.put(tmp,1);
            }else{
                String tmp=String.valueOf(texto.charAt(i));
                mapa.put(tmp, mapa.get(tmp)+1);
            }
            
        }
        
        
        return mapa;
        
    }
    
    public static String binarioHexadecimal (String binario){
        int cerosFaltantes = 4-(binario.length()%4);
        binario = completarBinario(binario, cerosFaltantes);
        String resultado = "";
        for(int i = 0; i<binario.length(); i+=4)
        {
            String temporal = binario.substring(i, i+4);
            int decimal = Integer.parseInt(temporal, 2);
            resultado += Integer.toString(decimal, 16);
        }
        return completarHexa(resultado, cerosFaltantes);
        
    }
    
    public static String hexadecimalBinario(String hexadecimal){
        return null;
        
    }
    
    public static void guardarTexto (String nombreArchivo, String texto, HashMap<String,String> mapa){
        
    }
    
    public static HashMap<String,String> leerMapa (String nombreArchivo){
        return null;
        
    }
    
    private static String completarBinario(String binario, int cerosFaltantes)
    {
        String resultado = binario;
        for (int i = 0; i< cerosFaltantes && cerosFaltantes<4; i++)
        {
            resultado+="0";
        }
        return resultado;
    }
    
    private static String completarHexa(String hexa, int cerosFaltantes)
    {
        String resultado = hexa;
        for (int i = 0; i< cerosFaltantes && cerosFaltantes<4; i++)
        {
            resultado+="-";
        }
        return resultado;
    }
    
}
