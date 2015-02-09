package edu.uniandes.ecos.psp01.view;

import edu.uniandes.ecos.psp01.model.Leer;
import java.io.File;


public class ConsoleView {
   
    
    public static void main( String[] args ) {
        File f = new File(System.getProperty("user.dir"));
        Leer l = new Leer();
        l.dir(f);
        for(String resultado: l.getResultados()){
            System.out.println(resultado);
        }
    }
    
}
