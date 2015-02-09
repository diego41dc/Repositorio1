package edu.uniandes.ecos.psp01.controller;



import edu.uniandes.ecos.psp01.model.Leer;
import edu.uniandes.ecos.psp01.view.MainView;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends HttpServlet{

    public static void main(String[] args) {
        
        System.out.println(System.getenv());
        
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
            contar(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
    /**
     * Method to set the console input for the numbers
     * @param req
     * @param resp
     * @throws java.lang.Exception
     */
    public void contar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        File f = new File(System.getProperty("user.dir"));
        Leer l = new Leer();
        l.dir(f);
        
        MainView.showResults(req, resp, l.getResultados());
    }

}
