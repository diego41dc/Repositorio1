package edu.uniandes.ecos.psp1.controller;



import edu.uniandes.ecos.psp1.model.Calculate;
import edu.uniandes.ecos.psp1.model.Datos;
import edu.uniandes.ecos.psp1.view.MainView;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends HttpServlet{

    public static void main(String[] args) {
        
        Server server = new Server(8380);
        //Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MainView.showHome(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
        try {
            MainView.showHome(req,resp);
            ejecutar(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
    public void ejecutar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        StringBuilder st = new StringBuilder();
        
        Datos d = new Datos();
        Calculate c = new Calculate();
       
        d.cargarDatos1();
        c.calcularValores(d.getLista(),d.getxK());
        
        if(c.getError() != null && !c.getError().isEmpty()){
            MainView.error(req, resp, c.getError());
        } else {
            calcularRespuesta(c, d.getLista(),d.getxK(), d.getNombreX(), d.getNombreY(), d.getTitulo(),st);
            
            d = new Datos();
            c = new Calculate();
            d.cargarDatos2();
            c.calcularValores(d.getLista(),d.getxK());
            
            if(c.getError() != null && !c.getError().isEmpty()){
                MainView.error(req, resp, c.getError());
            } else {
                calcularRespuesta(c, d.getLista(),d.getxK(), d.getNombreX(), d.getNombreY(), d.getTitulo(),st);
                
                d = new Datos();
                c = new Calculate();
                d.cargarDatos3();
                c.calcularValores(d.getLista(),d.getxK());
                
                if(c.getError() != null && !c.getError().isEmpty()){
                    MainView.error(req, resp, c.getError());
                } else {
                    calcularRespuesta(c, d.getLista(),d.getxK(), d.getNombreX(), d.getNombreY(), d.getTitulo(),st);
                    
                    d = new Datos();
                    c = new Calculate();
                    d.cargarDatos4();
                    c.calcularValores(d.getLista(),d.getxK());
                    
                    if(c.getError() != null && !c.getError().isEmpty()){
                        MainView.error(req, resp, c.getError());
                    } else {
                        calcularRespuesta(c, d.getLista(),d.getxK(), d.getNombreX(), d.getNombreY(), d.getTitulo(),st);
                        MainView.showResults(req, resp, st.toString());
                    }
                   
                }
            }
        }
        
        
        
    }
    
    
    public void calcularRespuesta(Calculate c, LinkedList<Double[]> lista, Double xK,String nombreX,String nombreY, String titulo, StringBuilder st){
        st.append("<h2>"+titulo+"</h1>");
        st.append("<dl>");
        st.append("<dt><b>Datos ingresados:</b></dt>");
       
        st.append("<dd>X<SUB>k</SUB><b>:"+xK+ "</b></dd>");
        
        st.append("<dd>Lista:</dd>");
        st.append("<dd><b>["+nombreX+" , "+nombreY+ "]</b></dd>");
        
        for(Double[] l: lista){
             st.append("<dd>["+l[0]+" , "+l[1]+ "]</dd>");
        }
        
        st.append("<dt></dt>");
        st.append("<dt><b>Datos calculados:</b></dt>");
        st.append("<dd><b>mediaX:</b>"+c.getMediaX()+ "</dd>");
        st.append("<dd><b>mediaY:</b>"+c.getMediaY()+ "</dd>");
        st.append("<dd><b>sumaX:</b>"+c.getSumaX()+ "</dd>");
        st.append("<dd><b>sumaY:</b>"+c.getSumaY()+ "</dd>");
        st.append("<dd><b>sumaXCuadrado:</b>"+c.getSumaXCuadrado()+ "</dd>"); 
        st.append("<dd><b>sumaYCuadrado:</b>"+c.getSumaYCuadrado()+ "</dd>");
        st.append("<dd><b>sumaXY:</b>"+c.getSumaXY()+ "</dd>");
        st.append("<dd><b>b1:</b>"+c.getB1()+ "</dd>");
        st.append("<dd><b>b0:</b>"+c.getB0()+ "</dd>");
        st.append("<dd><b>coefCorrelacion:</b>"+c.getCoefCorrelacion()+ "</dd>");
        st.append("<dd><b>coefCorrelacionCuadrado:</b>"+c.getCoefCorrelacionCuadrado()+ "</dd>");
        st.append("<dd><b>Y<SUB>k</SUB>:</b>"+c.getYk()+ "</dd>");
        
        st.append("</dl>");
        
        st.append("</br>");
    }

}
