package edu.uniandes.ecos.psp1.controller;



import edu.uniandes.ecos.psp1.model.Calculate;
import edu.uniandes.ecos.psp1.model.LeerArchivo;
import edu.uniandes.ecos.psp1.view.MainView;
import java.io.File;
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
        File f = new File(System.getProperty("user.dir"));
        LeerArchivo l = new LeerArchivo();
        l.dir(f);
        
        
        LinkedList<Double[]> lista = new LinkedList();
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
        Calculate c = new Calculate();
        c.calcularValores(lista);
        
        if(c.getError() != null && !c.getError().isEmpty()){
            MainView.error(req, resp, c.getError());
        } else {
            MainView.showResults(req, resp, c, lista);
        }
        
        
    }

}
