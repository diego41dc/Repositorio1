package edu.uniandes.ecos.ASE.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App 
{
    /**
     * Carga el archivo en una lista
     * @param archivo
     * @return 
     */
    private LinkedList cargarArchivo(String archivo){
        LinkedList<Double> lista = new LinkedList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = "";
            while ((linea = br.readLine()) != null) {
                lista.addLast(Double.parseDouble(linea));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Calcula la desviacion y el promedio del archivo cargado
     * @param archivo 
     */
    private void calcular(String archivo){
        LinkedList<Double> lista = cargarArchivo(archivo);
         Double sumaTotal = 0D;
        for(Double v: lista){
            sumaTotal+=v;
        }
        Double promedio = sumaTotal/lista.size();
        System.out.println("Mean:" + Math.round(promedio * 100.0) / 100.0);
        
        Double suma = 0D;
        for(Double v: lista){
            suma+=((Math.pow((v-promedio),2))/(lista.size()-1));
        }
        Double desviacion = Math.sqrt(suma);
        System.out.println("Std. Dev:" + Math.round(desviacion * 100.0) / 100.0);
        
    }
    public static void main( String[] args ) {
        App a = new App();
        a.calcular("datos.txt");
    }
}
