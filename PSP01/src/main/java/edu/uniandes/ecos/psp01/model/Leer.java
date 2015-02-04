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
    public Leer (){
        c = new Contar();
    }
    
    public void dir(File f) {
        if (f.exists()) {
            if (f.isDirectory()) {
                //System.out.println(f.getAbsolutePath());
                if(f.listFiles() != null){
                    for (File archivo : f.listFiles()) {
                       dir(archivo);
                    }
                }
            } else if (f.isFile() && f.getName().endsWith(".java")) {
                 System.out.println("Path:"+f.getAbsolutePath());
                 leer(f);
            }
        }
    }
   
    public void leer(File f){
        try {
            BufferedReader f2 = new BufferedReader(new FileReader(f));
            String linea;
            while((linea = f2.readLine()) != null){
               // System.out.println(linea); 
                c.contarLineas(linea);
           }
            System.out.println("Lineas:"+c.lineas);
            System.out.println("Clases:"+c.clases);
            System.out.println("Metodos:"+c.metodos);
            c = new Contar();
        } catch (IOException e) {
            e.printStackTrace();
        } 
   
    }
    
}
