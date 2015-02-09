package edu.uniandes.ecos.psp01.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainView{
    
    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>PSP1 Program!</h1>");
         pw.println("<h2>Este programa calcula el numero de lineas de cada clase, metodo y mas cosas.</h2>");
        
        pw.write("<form action=\"calcular\" method=\"post\"> \n" +
        "    <input type=\"submit\" value=\"Calcular\">\n" +
        "</form> ");
        pw.write("</html>");

    }
    
    public static void showResults(HttpServletRequest req, HttpServletResponse resp, ArrayList<String> resultados)
            throws ServletException, IOException {
        for(String resultado: resultados){
            resp.getWriter().println(resultado + "<br>");
        }
    }
    
    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
    }
    
}
