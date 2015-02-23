package edu.uniandes.ecos.psp2.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainView{
    
    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h2>PSP2 Program!</h1>");
        pw.println("<h2>Este programa integra num&eacute;ricamente una funci&oacute;n usando la regla de Simpson.</h2>");
        
        pw.write("<form action=\"calcular\" method=\"post\"> \n" +
        "    <input type=\"submit\" value=\"Calcular\">\n" +
        "</form> ");
        pw.write("</html>");

    }
    
    public static void showResults(HttpServletRequest req, HttpServletResponse resp, String respuesta) throws ServletException, IOException {
        resp.getWriter().println(respuesta);
    }
    
    public static void error(HttpServletRequest req, HttpServletResponse resp, String error) throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
        resp.getWriter().println(error);
    }
    
}
