package edu.uniandes.ecos.psp2.model;

public class Calculate 
{

    private String error;
    private Double dof;
    private Double x;
    private Double totalCalculado;
    private Integer segmentos;
    
    
    public Calculate(){}
    
    
    public void calcularValores(Double dof, Double x){
        try {
            this.dof = dof;
            this.x = x;
            Double e = 0.00001;
            
            segmentos = 10;
            Double resultado = 0D;
            Double resultadoTmp = calcularIntegral(segmentos, dof, x);
            
            while(Math.abs(resultado-resultadoTmp)>=e){
                resultado = resultadoTmp;
                segmentos = segmentos+10;
                resultadoTmp = calcularIntegral(segmentos, dof, x);
            }
            this.totalCalculado = aproximar(resultado);
            
        } catch (Exception e){
            error = e.getMessage();
        }
    }
    
    private Double calcularIntegral(Integer segmentos,Double dof, Double x){
        
        Double c1 = (dof+1)/2;
        Double w = x/segmentos;
        Double xi = 0D;
        Double total = 0D;
        Double r1,r2;

        if(dof%2 == 0){
            r1 = factorialDecimal((dof+1D),2D);
            r2 = factorialEntero(dof/2);
        } else {
            r1 = factorialEntero(((dof+1D)/2));
            r2 = factorialDecimal(dof,2D);
        }

        for(int i = 0; i<=segmentos;i++){
            Double v1 = 1+(Math.pow(xi, 2)/dof);
            Double v2 = Math.pow(v1, -1 * c1);
            Double v3 = r1/(Math.pow((dof * Math.PI), 0.5) * r2);
            Double v4 = v2 * v3;

            Double multiplicador;
            
            if(i == 0 || i == segmentos){
                multiplicador = 1D;
            } else if(i%2 != 0){
                multiplicador = 4D;
            } else {
                multiplicador = 2D;
            }
            
            Double v5 = (w/3) * multiplicador * v4;
            xi+= w;
            total+= v5;
        }
        return total;
    }
    
    private Double aproximar(Double d){
        return (Math.round(d*100000D)/100000D);
    }
    
    private Double factorialEntero(Double numero){
        Double factorial = 1D; 
        numero--;
         
        while ( numero!=0 ) {
            factorial=factorial*numero;
            numero--;
        }
        return factorial;
    }
    
    private Double factorialDecimal(Double numerador, Double denominador){
        Double factorial = 1D;  
        
        numerador = numerador-2D;
        while(numerador>=1){
            factorial = factorial*(numerador/denominador);
            numerador = numerador-2D;
        } 
        return factorial * Math.sqrt(Math.PI);
    }
    
    public String getError() {
        return error;
    }

    public Double getDof() {
        return dof;
    }

    public Double getTotalCalculado() {
        return totalCalculado;
    }

    public Double getX() {
        return x;
    }

    public Integer getSegmentos() {
        return segmentos;
    }
}
