package edu.uniandes.ecos.psp01.model;

import java.util.ArrayList;

/**
 *
 * @author diego.lozano
 */
public class Contar {
    
    private Integer lineas;
    private Integer metodos;
    private Integer clases;
    private Boolean enMetodo;
    private Integer corchetes;
    private Integer inicioCorchetes;
    private Integer inicioLinea;
    private String nombreClase;
    private ArrayList lineasMetodo;
    
    public Contar(){
        lineas = 0;
        metodos = 0;
        clases = 0;
        enMetodo = false;
        corchetes = 0;
        inicioCorchetes = 0;
        inicioLinea = 0;
        nombreClase = "";
        lineasMetodo = new ArrayList();
    }
    
       
    public void contarLineas(String linea){
        if(!(linea == null)){
            String tmp = quitarTabs(linea);

            if(!tmp.trim().equalsIgnoreCase("") && !tmp.isEmpty()){
                lineas++;
                if(tmp.contains("{")){
                    corchetes++;
                }
                if(tmp.contains("}")){
                    corchetes--;
                }
                
                
                if(tmp.contains("class")&& !tmp.contains("\"class\"")&&!tmp.contains(".class")){
                    clases++;
                    nombreClase = quitarTabs(tmp.replace("public", "").replace("protected", "").replace("private", "").replace("class", "").replace("{", "").replace("}", "").trim());
                 } else if(((tmp.contains("public")|| tmp.contains("private") || tmp.contains(nombreClase))||tmp.contains("static")) && (tmp.contains("(")&& tmp.contains(")"))&& (tmp.contains("{")) && (!tmp.contains("if"))&& !tmp.contains("contains")){
                    metodos++;
                    enMetodo = true;
                    inicioCorchetes = corchetes-1;
                    inicioLinea = lineas;
                } else if(enMetodo && corchetes.equals(inicioCorchetes)){
                    lineasMetodo.add(lineas-inicioLinea+1);
                    enMetodo = false;
                    inicioCorchetes = 0;
                    inicioLinea = 0;
                 }
            }
        }
    }
    
    private String quitarTabs(String linea){
        return linea.replaceAll("  ", "").replaceAll(System.getProperty("line.separator"), "");
    }

    public Integer getLineas() {
        return lineas;
    }

    public Integer getMetodos() {
        return metodos;
    }

    public Integer getClases() {
        return clases;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public ArrayList getLineasMetodo() {
        return lineasMetodo;
    }
}
