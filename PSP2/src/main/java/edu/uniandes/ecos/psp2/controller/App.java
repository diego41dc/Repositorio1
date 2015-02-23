package edu.uniandes.ecos.psp2.controller;



import edu.uniandes.ecos.psp2.model.Calculate;
import edu.uniandes.ecos.psp2.view.MainView;
import java.io.IOException;
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
        
        Calculate c = new Calculate();
        c.calcularValores(9D,1.1);
        calcularRespuesta(c, st,"Test 1");
        
        Calculate c2 = new Calculate();
        c2.calcularValores(10D,1.1812);
        calcularRespuesta(c2, st,"Test 2");
        
        Calculate c3 = new Calculate();
        c3.calcularValores(30D,2.750);
        calcularRespuesta(c3, st,"Test 3");
        
        MainView.showResults(req, resp, st.toString());
       
    }
    
    
    public void calcularRespuesta(Calculate c, StringBuilder st, String titulo){
        st.append("<h2>"+titulo+"</h1>");
        st.append("<dl>");
        st.append("<dt><b>Datos ingresados:</b></dt>");
        st.append("<dd><b>dof: </b>"+c.getDof()+ "</dd>");
        st.append("<dd><b>x:</b> 0-"+c.getX()+ "</dd>");
        
        st.append("<dt></dt>");
        st.append("<dt><b>Datos calculados:</b></dt>");
        st.append("<dd><b>Segmentos: </b>"+c.getSegmentos()+ "</dd>");
        st.append("<dd><b>p: </b>"+c.getTotalCalculado()+ "</dd>");
        
        st.append("</dl>");
        st.append("</br>");
    }

}
