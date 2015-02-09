package edu.uniandes.ecos.psp01.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leer {
    
    private Contar c;
    private String rutaAnterior;
    private ArrayList<String> resultados;
    public Leer (){
        c = new Contar();
        rutaAnterior = "";
        resultados = new ArrayList();
    }
    
    public void dir(File f) {
        if (f.exists()) {
            if (f.isDirectory()) {
                if(f.listFiles() != null){
                    for (File archivo : f.listFiles()) {
                       dir(archivo);
                    }
                }
            } else if (f.isFile() && f.getName().endsWith(".java")) {
                leer(f);
            }
        }
    }
   
    public void leer(File f){
        try {
            if(!rutaAnterior.equalsIgnoreCase(f.getParent())){
                resultados.add("Ruta:"+f.getParent()); 
                rutaAnterior = f.getParent();
            }
            BufferedReader f2 = new BufferedReader(new FileReader(f));
            String linea;
            while((linea = f2.readLine()) != null){
               c.contarLineas(linea);
           }
            resultados.add("Nombre Clase:"+c.getNombreClase());
            resultados.add("Lineas:"+c.getLineas());
            resultados.add("Clases:"+c.getClases());
            resultados.add("Metodos:"+c.getMetodos());
            c = new Contar();
        } catch (IOException e) {
            e.printStackTrace();
        } 
   
    }

    public ArrayList<String> getResultados() {
        return resultados;
    }

    public void setResultados(ArrayList<String> resultados) {
        this.resultados = resultados;
    }
    
}
