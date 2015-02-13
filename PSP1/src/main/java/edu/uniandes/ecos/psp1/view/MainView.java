package edu.uniandes.ecos.psp1.view;

import edu.uniandes.ecos.psp1.model.Calculate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainView{
    
    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h2>PSP1 Program!</h1>");
        pw.println("<h2>Este programa calcula los par&aacute;metros &beta;<SUB>0</SUB>, &beta;<SUB>1</SUB>, coeficiente de correlaci&oacute;n r<SUB>xy</SUB> y r<SUP>2</SUP>.</h2>");
        
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
