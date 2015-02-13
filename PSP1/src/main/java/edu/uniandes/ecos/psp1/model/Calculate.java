package edu.uniandes.ecos.psp1.model;

import java.util.LinkedList;

public class Calculate 
{
    private Double mediaX;
    private Double mediaY;
    private Double sumaX;
    private Double sumaY;
    private Double sumaXCuadrado;
    private Double sumaYCuadrado;
    private Double sumaXY;
    private Double cantidad;
    private Double b1;
    private Double b0;
    private Double coefCorrelacion;
    private Double coefCorrelacionCuadrado;
    private Double yK;
    private Double xK;
    private String error;
    
    public Calculate(){
        mediaX = 0D;
        mediaY = 0D;
        sumaX = 0D;
        sumaY = 0D;
        sumaXCuadrado = 0D;
        sumaYCuadrado = 0D;
        sumaXY = 0D;
        cantidad = 0D;
        b0 = 0D;
        b1 = 0D;
        coefCorrelacion = 0D;
        coefCorrelacionCuadrado = 0D;
        error = "";
    }
    
    
    private void alistarValores(LinkedList<Double[]> lista){
     
          cantidad = new Double(lista.size());
            for(Double[] v: lista){
                sumaX+=v[0];
                sumaY+=v[1];
                sumaXCuadrado+= Math.pow(v[0], 2);
                sumaYCuadrado+= Math.pow(v[1], 2);
                sumaXY+= (v[0]*v[1]);
            }

            mediaX = (Math.round(sumaX/cantidad * 100D) / 100D);
            mediaY = (Math.round(sumaY/cantidad * 100D) / 100D);     
      
    }
    
     public void calcularValores(LinkedList<Double[]> lista, Double xK){
        try{
            this.xK = xK;
            alistarValores(lista);
            b1 = (sumaXY-(cantidad * mediaX * mediaY))/(sumaXCuadrado-(cantidad *(Math.pow(mediaX,2))));
            b0 = (mediaY - (b1 * mediaX));        
            coefCorrelacion = ((cantidad * sumaXY) - (sumaX * sumaY))/Math.sqrt(((cantidad * sumaXCuadrado)-Math.pow(sumaX,2))*((cantidad * sumaYCuadrado)-Math.pow(sumaY,2)));
            coefCorrelacionCuadrado = Math.pow(coefCorrelacion,2);
            yK = b0+(b1*xK);
        } catch (Exception e) {
          error = e.getMessage();
      }
    }
     
    
    public Double getMediaX() {
        return mediaX;
    }

    public Double getMediaY() {
        return mediaY;
    }

    public Double getSumaX() {
        return sumaX;
    }

    public Double getSumaXCuadrado() {
        return sumaXCuadrado;
    }

    public Double getSumaXY() {
        return sumaXY;
    }

    public Double getSumaY() {
        return sumaY;
    }

    public Double getSumaYCuadrado() {
        return sumaYCuadrado;
    }

    public Double getB0() {
        return (Math.round(b0*10000D)/10000D);
    }

    public Double getB1() {
        return (Math.round(b1*10000D)/10000D);
    }

    public Double getCantidad() {
        return cantidad;
    }

    public Double getCoefCorrelacion() {
        return (Math.round(coefCorrelacion*10000D)/10000D);
    }

    public Double getCoefCorrelacionCuadrado() {
        return (Math.round(coefCorrelacionCuadrado*10000D)/10000D);
    }
    
    public Double getYk() {
        return (Math.round(yK*10000D)/10000D);
    }
    
    public Double getXk() {
        return xK;
    }

    public String getError() {
        return error;
    }
    
}
