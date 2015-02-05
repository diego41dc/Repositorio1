package edu.uniandes.ecos.psp01.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author diego.lozano
 */
public class Leer {
    
    private Contar c;
    private String rutaAnterior;
    public Leer (){
        c = new Contar();
        rutaAnterior = "";
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
                System.out.println("Ruta:"+f.getParent()); 
                rutaAnterior = f.getParent();
            }
            BufferedReader f2 = new BufferedReader(new FileReader(f));
            String linea;
            while((linea = f2.readLine()) != null){
               c.contarLineas(linea);
           }
            System.out.println("Nombre Clase:"+c.getNombreClase());
            System.out.println("Lineas:"+c.getLineas());
            System.out.println("Clases:"+c.getClases());
            System.out.println("Metodos:"+c.getMetodos());
            c = new Contar();
        } catch (IOException e) {
            e.printStackTrace();
        } 
   
    }
    
}
