package edu.uniandes.ASE.app;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File f = new File(System.getProperty("user.dir"));
        App.dir(f);
        
    }
    public static void dir(File f) {
        if (f.exists()) {
            if (f.isDirectory()) {
                //System.out.println(f.getAbsolutePath());
                if(f.listFiles() != null){
                    for (File archivo : f.listFiles()) {
                       dir(archivo);
                    }
                }
            } else if (f.isFile() && f.getName().endsWith(".java")) {
                 System.out.println(f.getAbsolutePath());
                 leer(f);
            }
        }
    }
    public static void leer(File f){
        try {
            BufferedReader f2 = new BufferedReader(new FileReader(f));
            String linea;
            while((linea = f2.readLine()) != null){
                System.out.println(linea); 
           }
        } catch (IOException e) {
         e.printStackTrace();
       } 
   
    }
}
