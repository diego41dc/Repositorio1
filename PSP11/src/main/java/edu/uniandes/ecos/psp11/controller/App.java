package edu.uniandes.ecos.psp11.controller;



import edu.uniandes.ecos.psp11.model.Calculate;
import edu.uniandes.ecos.psp11.model.Datos;
import edu.uniandes.ecos.psp11.view.MainView;
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
        c.calcularValores(d.getLista());
        
        if(c.getError() != null && !c.getError().isEmpty()){
            MainView.error(req, resp, c.getError());
        } else {
            calcularRespuesta(c, d,st);
            
            d = new Datos();
            c = new Calculate();
            d.cargarDatos2();
            c.calcularValores(d.getLista());
            
            if(c.getError() != null && !c.getError().isEmpty()){
                MainView.error(req, resp, c.getError());
            } else {
                 calcularRespuesta(c, d,st);
                
                d = new Datos();
                c = new Calculate();
                d.cargarDatos3();
                c.calcularValores(d.getLista());
                
                if(c.getError() != null && !c.getError().isEmpty()){
                    MainView.error(req, resp, c.getError());
                } else {
                    calcularRespuesta(c, d,st);
                    MainView.showResults(req, resp, st.toString());
                }
            }
        }
        
        
        
    }
    
    
    public void calcularRespuesta(Calculate c, Datos d, StringBuilder st){
        st.append("<h2>"+d.getTitulo()+"</h1>");
        st.append("<dl>");
        st.append("<dt><b>Datos ingresados:</b></dt>");
       
        
        st.append("<dd>Lista:</dd>");
        st.append("<dd><b>["+d.getNombreX()+" , "+d.getNombreY()+ "]</b></dd>");
        
        for(Double[] l: d.getLista()){
             st.append("<dd>["+l[0]+" , "+l[1]+ "]</dd>");
        }
        
        st.append("<dt></dt>");
        st.append("<dt><b>Datos calculados:</b></dt>");
        st.append("<dd><b>VS:</b>"+c.getVs()+ "</dd>");
        st.append("<dd><b>S:</b>"+c.getS()+ "</dd>");
        st.append("<dd><b>M:</b>"+c.getM()+ "</dd>");
        st.append("<dd><b>L:</b>"+c.getL()+ "</dd>");
        st.append("<dd><b>VL:</b>"+c.getVl()+ "</dd>"); 
        
        st.append("</dl>");
        
        st.append("</br>");
    }

}
