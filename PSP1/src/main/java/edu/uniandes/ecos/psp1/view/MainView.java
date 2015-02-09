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
    
    public static void showResults(HttpServletRequest req, HttpServletResponse resp, Calculate c, LinkedList<Double[]> lista)
            throws ServletException, IOException {
         
        resp.getWriter().println("<dl>");
        resp.getWriter().println("<dt><b>Datos ingresados:</b></dt>");
       
        
        for(Double[] l: lista){
             resp.getWriter().println("<dd>["+l[0]+" , "+l[1]+ "]</dd>");
        }
        
        resp.getWriter().println("<dt></dt>");
        resp.getWriter().println("<dt><b>Datos calculados:</b></dt>");
        resp.getWriter().println("<dd><b>mediaX:</b>"+c.getMediaX()+ "</dd>");
        resp.getWriter().println("<dd><b>mediaY:</b>"+c.getMediaY()+ "</dd>");
        resp.getWriter().println("<dd><b>sumaX:</b>"+c.getSumaX()+ "</dd>");
        resp.getWriter().println("<dd><b>sumaY:</b>"+c.getSumaY()+ "</dd>");
        resp.getWriter().println("<dd><b>sumaXCuadrado:</b>"+c.getSumaXCuadrado()+ "</dd>"); 
        resp.getWriter().println("<dd><b>sumaYCuadrado:</b>"+c.getSumaYCuadrado()+ "</dd>");
        resp.getWriter().println("<dd><b>sumaXY:</b>"+c.getSumaXY()+ "</dd>");
        resp.getWriter().println("<dd><b>b1:</b>"+c.getB1()+ "</dd>");
        resp.getWriter().println("<dd><b>b0:</b>"+c.getB0()+ "</dd>");
        resp.getWriter().println("<dd><b>coefCorrelacion:</b>"+c.getCoefCorrelacion()+ "</dd>");
        resp.getWriter().println("<dd><b>coefCorrelacionCuadrado:</b>"+c.getCoefCorrelacionCuadrado()+ "</dd>");
        
        resp.getWriter().println("</dl>");
    }
    
    public static void error(HttpServletRequest req, HttpServletResponse resp, String error)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
        resp.getWriter().println(error);
    }
    
}
