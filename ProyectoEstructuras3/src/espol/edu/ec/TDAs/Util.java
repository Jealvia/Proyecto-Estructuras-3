/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Julio Alvia
 */
public class Util {
    
    public static String leerTexto(String nombreArchivo) {
        String resultado;
        try {
            Scanner sc = new Scanner(new File(nombreArchivo));
            resultado = sc.nextLine();
        } catch (FileNotFoundException ex) {
            resultado = "";
        }
        return resultado;

    }
    
    public static String leerTexto(File file) throws FileNotFoundException {
        String resultado;
        
        if (file != null) {
            Scanner sc = new Scanner(file);
            resultado = sc.nextLine();
        } else {
            resultado = "";
        }
        
        return resultado;
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
        return completarHexa(resultado, cerosFaltantes).toUpperCase();
        
    }
    
    public static String hexadecimalBinario(String hexadecimal){
        int cerosFaltantes = 4-(hexadecimal.length()%4);
        String resultado = "";
        for(int i = 0; i<hexadecimal.length(); i++)
        {
            if(!"-".equals(hexadecimal.substring(i, i+1)))
            {
                String temporal = hexadecimal.substring(i, i+1);
                int decimal = Integer.parseInt(temporal, 16);
                resultado += Util.completarBinarioAntes(Integer.toString(decimal, 2));
            }
               
        }
        
        return resultado.substring(0, resultado.length()-cerosFaltantes);
        
    }
    
        private static String completarBinarioAntes(String binario)
    {
        String resultado = "";
        int cerosFaltantes = 4-binario.length();
        for(int i = 0; i<cerosFaltantes; i++)
        {
            resultado+="0";
        }
        return resultado+binario;
    }
    
    public static void guardarTexto(String nombreArchivo, String texto, HashMap<String, String> mapa) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo+"_compress.txt")));
            pw.println(texto);
            pw.close();
            PrintWriter pw1 = new PrintWriter(new BufferedWriter(new FileWriter("tablacodigos.txt")));
            mapa.forEach((k,v) -> pw.println(k+":"+v));
            pw1.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public static String obtenerPath(File file) {
        return file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator)) + File.separator;
    }
    
    public static boolean guardarTexto(File file, String texto, HashMap<String, String> mapa) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(obtenerPath(file) + file.getName())));
            pw.println(texto);
            pw.close();
            PrintWriter pw1 = new PrintWriter(new BufferedWriter(new FileWriter(obtenerPath(file) + "tablacodigos.txt")));
            mapa.forEach((k,v) -> pw1.println(k+":"+v));
            pw1.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static HashMap<String,String> leerMapa (String nombreArchivo){
        HashMap<String,String> mapa=new HashMap<>();
        String linea;
        try {
            FileReader f = new FileReader(nombreArchivo+".txt");
            BufferedReader br = new BufferedReader(f);
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                String valores[];
                valores = linea.split(":");
                String clave = valores[0].trim();
                String valor = valores[1].trim();
                System.out.println(linea);
                mapa.put(clave, valor);

            }
        } catch (IOException e) {
        }
        return mapa;
        
    }
    
    public static HashMap<String,String> leerMapa (File file){
        HashMap<String,String> mapa=new HashMap<>();
        String linea;
        try {
//            FileReader f = new FileReader(obtenerPath(file) + file.getName());
            FileReader f = new FileReader(file.getAbsolutePath());
            BufferedReader br = new BufferedReader(f);
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                String valores[];
                valores = linea.split(":");
                String clave = valores[0].trim();
                String valor = valores[1].trim();
                System.out.println(linea);
                mapa.put(clave, valor);

            }
        } catch (IOException e) {
        }
        return mapa;
        
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
