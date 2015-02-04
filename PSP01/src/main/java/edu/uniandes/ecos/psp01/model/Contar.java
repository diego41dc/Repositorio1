/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp01.model;

/**
 *
 * @author diego.lozano
 */
public class Contar {
    
    public Integer lineas = 0;
    public Integer metodos = 0;
    public Integer clases = 0;
    public Boolean enMetodo = false;
    public Integer corchetes = 0;
    public Integer inicioCorchetes = 0;
    public Integer inicioLinea = 0;
    public String nombreClase = "";
    
    public Contar(){
        lineas = 0;
        metodos = 0;
        clases = 0;
        enMetodo = false;
        corchetes = 0;
        inicioCorchetes = 0;
        inicioLinea = 0;
        nombreClase = "";
    }
    
       
    public void contarLineas(String linea){
        if(!(linea == null)){
            //String tmp = quitarTabs(linea);
             String tmp = linea;
           /* if(!linea.equalsIgnoreCase(tmp)){
                System.out.println("Linea antes:"+linea);
                System.out.println("Linea despues:"+tmp);
            }*/
            if(!tmp.trim().equalsIgnoreCase("") && !tmp.isEmpty()){
                lineas++;
                System.out.println("Linea:"+lineas+":"+linea);
                if(tmp.contains("{")){
                    corchetes++;
                }else if(tmp.contains("}")){
                    corchetes--;
                }
                
                
                if(tmp.contains("class")){
                    clases++;
                    nombreClase = quitarTabs(tmp.replace("class", "").trim());
                } else if(((tmp.contains("public")|| tmp.contains("private") || tmp.contains(nombreClase))||tmp.contains("static")) && (tmp.contains("(")&& tmp.contains(")"))&& (tmp.contains("{")) && (!tmp.contains("if"))/*&& !tmp.contains("contains")*/){
                    metodos++;
                    enMetodo = true;
                    inicioCorchetes = corchetes-1;
                    inicioLinea = lineas;
                } else if(enMetodo && inicioCorchetes == corchetes){
                    System.out.println("Fin metodo:"+inicioLinea+"-"+lineas+":"+(lineas-inicioLinea+1)+"; corchete:"+inicioCorchetes+":"+corchetes);
                    enMetodo = false;
                    inicioCorchetes = 0;
                    inicioLinea = 0;
                } else {
                    
                }
            }
        }
    }
    
    private String quitarTabs(String linea){
        return linea.replaceAll("  ", "").replaceAll(System.getProperty("line.separator"), "");
    }
}
