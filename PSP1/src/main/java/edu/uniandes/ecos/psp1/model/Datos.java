/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp1.model;

import java.util.LinkedList;

/**
 *
 * @author diego.lozano
 */
public class Datos {
    
    private LinkedList<Double[]> lista;
    private Double xK;
    private String nombreX;
    private String nombreY;
    private String titulo;
    
    public Datos(){
       lista  = new LinkedList();
       xK = 386D;
       nombreX = "";
       nombreY = "";
       titulo = "";
    }
    public void cargarDatos1(){
       
        Double [] d = new Double []{130D,186D};
        lista.add(d);
        d = new Double [] {650D,699D};
        lista.add(d);
        d = new Double [] {99D,132D};
        lista.add(d);
        d =  new Double []{150D,272D};
        lista.add(d);
        d =  new Double []{128D,291D};
        lista.add(d);
        d =  new Double []{302D,331D};
        lista.add(d);
        d =  new Double []{95D,199D};
        lista.add(d);
        d =  new Double []{945D,1890D};
        lista.add(d);
        d =  new Double []{368D,788D};
        lista.add(d);
        d =  new Double []{961D,1601D};
        lista.add(d);
       
        nombreX = "Estimated Proxy Size";
        nombreY = "Actual Added and Modified Size";
        titulo = "Test 1";
    }
    
    public void cargarDatos2(){
       
        Double [] d = new Double []{130D,15D};
        lista.add(d);
        d = new Double [] {650D,69.9D};
        lista.add(d);
        d = new Double [] {99D,6.5D};
        lista.add(d);
        d =  new Double []{150D,22.4D};
        lista.add(d);
        d =  new Double []{128D,28.4D};
        lista.add(d);
        d =  new Double []{302D,35.9D};
        lista.add(d);
        d =  new Double []{95D,19.4D};
        lista.add(d);
        d =  new Double []{945D,198.7D};
        lista.add(d);
        d =  new Double []{368D,38.8D};
        lista.add(d);
        d =  new Double []{961D,138.2D};
        lista.add(d);
       
        nombreX = "Estimated Proxy Size";
        nombreY = "Actual Development Hours";
        titulo = "Test 2";
    }
    
    public void cargarDatos3(){
       
        Double [] d = new Double []{163D,186D};
        lista.add(d);
        d = new Double [] {765D,699D};
        lista.add(d);
        d =  new Double []{141D,132D};
        lista.add(d);
        d =  new Double []{166D,272D};
        lista.add(d);
        d =  new Double []{137D,291D};
        lista.add(d);
        d =  new Double []{355D,331D};
        lista.add(d);
        d =  new Double []{136D,199D};
        lista.add(d);
        d =  new Double []{1206D,1890D};
        lista.add(d);
        d =  new Double []{433D,788D};
        lista.add(d);
        d =  new Double []{1130D,1601D};
        lista.add(d);
       
        nombreX = "Plan Added and Modified size";
        nombreY = "Actual Added and Modified Size";
        titulo = "Test 3";
    }
    
    public void cargarDatos4(){
       
        Double [] d = new Double []{163D,15.0D};
        lista.add(d);
        d = new Double [] {765D,69.9D};
        lista.add(d);
        d =  new Double []{141D,6.5D};
        lista.add(d);
        d =  new Double []{166D,22.4D};
        lista.add(d);
        d =  new Double []{137D,28.4D};
        lista.add(d);
        d =  new Double []{355D,65.9D};
        lista.add(d);
        d =  new Double []{136D,19.4D};
        lista.add(d);
        d =  new Double []{1206D,198.7D};
        lista.add(d);
        d =  new Double []{433D,38.8D};
        lista.add(d);
        d =  new Double []{1130D,138.2D};
        lista.add(d);
       
        nombreX = "Plan Added and Modified size";
        nombreY = "Actual Development Hours";
        titulo = "Test 4";
    }
    
    public LinkedList<Double[]> getLista() {
        return lista;
    }

    public Double getxK() {
        return xK;
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
