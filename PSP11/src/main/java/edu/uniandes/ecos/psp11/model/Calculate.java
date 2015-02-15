package edu.uniandes.ecos.psp11.model;

import java.util.LinkedList;

public class Calculate 
{

    private String error;
    private Double vs;
    private Double s;
    private Double m;
    private Double l;
    private Double vl;
    
    
    public Calculate(){
        error = "";
        vs = 0D;
        s = 0D;
        m = 0D;
        l = 0D;
        vl = 0D;
    }
    
    
    public void calcularValores(LinkedList<Double[]> lista){
        try {
            LinkedList <Double> listaBase = new LinkedList();
            LinkedList <Double> listaLN = new LinkedList();
            Double sumaLN = 0D;
            Double sumaCalLN = 0D;
            Double phi;
            Double avgLN;

            for(Double[] l1: lista){
                listaBase.add(aproximar(l1[0]/l1[1]));
            }

            for(Double l2: listaBase){
                Double ln = aproximar(Math.log(l2));
                listaLN.add(ln);
                sumaLN += ln;
            }

            avgLN = aproximar(sumaLN/listaLN.size());

            for(Double l3: listaLN){
               sumaCalLN += aproximar(Math.pow( l3-avgLN, 2));
            }
            phi = aproximar(Math.sqrt(sumaCalLN/(listaBase.size()-1D)));

            Double lnVS = aproximar(avgLN-2*phi);
            Double lnS = aproximar(avgLN-phi);
            Double lnM = aproximar(avgLN);
            Double lnL = aproximar(avgLN+phi);
            Double lnVL = aproximar(avgLN+2*phi);

            vs = aproximar(Math.exp(lnVS));
            s = aproximar(Math.exp(lnS));
            m = aproximar(Math.exp(lnM));
            l = aproximar(Math.exp(lnL));
            vl = aproximar(Math.exp(lnVL));
        } catch (Exception e){
            error = e.getMessage();
        }
    }
    
    
    private Double aproximar(Double d){
        return (Math.round(d*10000D)/10000D);
    }
    
    public String getError() {
        return error;
    }

    public Double getVs() {
        return vs;
    }

    public Double getS() {
        return s;
    }

    public Double getM() {
        return m;
    }

    public Double getL() {
        return l;
    }

    public Double getVl() {
        return vl;
    }
    
}
