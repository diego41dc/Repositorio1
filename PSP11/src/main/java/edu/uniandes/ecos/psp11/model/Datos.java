/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp11.model;

import java.util.LinkedList;

/**
 *
 * @author diego.lozano
 */
public class Datos {
    
    private LinkedList<Double[]> lista;
    private String nombreX;
    private String nombreY;
    private String titulo;
    
    public Datos(){
       lista = new LinkedList();
       nombreX = "";
       nombreY = "";
       titulo = "";
    }
    public void cargarDatos1(){
       
        Double [] d = new Double []{18D,3D};
        lista.add(d);
        d = new Double [] {18D,3D};
        lista.add(d);
        d = new Double [] {25D,3D};
        lista.add(d);
        d =  new Double []{31D,3D};
        lista.add(d);
        d =  new Double []{37D,3D};
        lista.add(d);
        d =  new Double []{82D,5D};
        lista.add(d);
        d =  new Double []{82D,4D};
        lista.add(d);
        d =  new Double []{87D,4D};
        lista.add(d);
        d =  new Double []{89D,4D};
        lista.add(d);
        d =  new Double []{230D,10D};
        lista.add(d);
        d =  new Double []{85D,3D};
        lista.add(d);
        d =  new Double []{87D,3D};
        lista.add(d);
        d =  new Double []{558D,10D};
        lista.add(d);
       
        nombreX = "Class LOC";
        nombreY = "Number of Methods";
        titulo = "Example: LOC/method";
    }
    
    public void cargarDatos2(){
       
        Double [] d = new Double []{18D,3D};
        lista.add(d);
        d = new Double [] {18D,3D};
        lista.add(d);
        d = new Double [] {25D,3D};
        lista.add(d);
        d =  new Double []{31D,3D};
        lista.add(d);
        d =  new Double []{37D,3D};
        lista.add(d);
        d =  new Double []{82D,5D};
        lista.add(d);
        d =  new Double []{82D,4D};
        lista.add(d);
        d =  new Double []{87D,4D};
        lista.add(d);
        d =  new Double []{89D,4D};
        lista.add(d);
        d =  new Double []{230D,10D};
        lista.add(d);
        d =  new Double []{85D,3D};
        lista.add(d);
        d =  new Double []{87D,3D};
        lista.add(d);
        d =  new Double []{558D,10D};
        lista.add(d);
       
        nombreX = "Class LOC";
        nombreY = "Number of Methods";
        titulo = "Test 1: LOC/Method";
    }
    
    public void cargarDatos3(){
       
        Double [] d = new Double []{7D,1D};
        lista.add(d);
        d = new Double [] {12D,1D};
        lista.add(d);
        d = new Double [] {10D,1D};
        lista.add(d);
        d =  new Double []{12D,1D};
        lista.add(d);
        d =  new Double []{10D,1D};
        lista.add(d);
        d =  new Double []{12D,1D};
        lista.add(d);
        d =  new Double []{12D,1D};
        lista.add(d);
        d =  new Double []{12D,1D};
        lista.add(d);
        d =  new Double []{12D,1D};
        lista.add(d);
        d =  new Double []{8D,1D};
        lista.add(d);
        d =  new Double []{8D,1D};
        lista.add(d);
        d =  new Double []{8D,1D};
        lista.add(d);
        d =  new Double []{20D,1D};
        lista.add(d);
        d =  new Double []{14D,1D};
        lista.add(d);
        d =  new Double []{18D,1D};
        lista.add(d);
        d =  new Double []{12D,1D};
        lista.add(d);
       
        nombreX = "Pages";
        nombreY = "Chapter";
        titulo = "Test 2: Pgs/Chapter";
    }
        
    public LinkedList<Double[]> getLista() {
        return lista;
    }

    

    public String getNombreX() {
        return nombreX;
    }

    public String getNombreY() {
        return nombreY;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    
}
