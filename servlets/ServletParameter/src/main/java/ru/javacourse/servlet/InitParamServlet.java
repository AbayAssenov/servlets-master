package ru.javacourse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для демонстрации работы с параметрами в web.xml
 * @author ASaburov
 */
public class InitParamServlet extends HttpServlet {

    String param1;
    String param2;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        param1 = config.getInitParameter("parameter1");
        param2 = config.getInitParameter("parameter2");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//
//        String param1 = getServletConfig().getInitParameter("parameter1");
//        String param2 = getServletConfig().getInitParameter("parameter2");

        String page = request.getParameter("page");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet</h1>");
            out.println("<h1>Parameter1 = " + param1 + "</h1>");
            out.println("<h1>Parameter2 = " + param2 + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    } 

}
