package edu.uniandes.ecos.psp2.view;

import edu.uniandes.ecos.psp2.model.Calculate;

public class Main {
    public static void main (String args[]){
        Calculate c = new Calculate();
        c.calcularValores(9D,1.1);
        
        Calculate c2 = new Calculate();
        c2.calcularValores(10D,1.1812);
        
        Calculate c3 = new Calculate();
        c3.calcularValores(30D,2.750);
    }
    
}
