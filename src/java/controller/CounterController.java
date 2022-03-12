package controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CounterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext ctx = getServletContext();
        Integer count = (Integer) ctx.getAttribute("pcount");
        out.println(count + ": pageview");
        ctx.setAttribute("pcount", ++count);
    }
}
