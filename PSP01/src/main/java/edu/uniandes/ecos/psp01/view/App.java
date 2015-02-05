package edu.uniandes.ecos.psp01.view;

import edu.uniandes.ecos.psp01.model.Leer;
import java.io.File;


public class App {
   
    
    public static void main( String[] args ) {
        File f = new File(System.getProperty("user.dir"));
        Leer l = new Leer();
        l.dir(f);
    }
    
}
