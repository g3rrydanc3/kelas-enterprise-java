import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    private int accessCount;

    public void init() throws ServletException{
        accessCount = 0;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        /*printWriter.println("<html>" +
                "<body>" +
                "<h1>This is my Servlet</h1>" +
                "<body>" +
                "</html>");*/

        int localCount = 0;
        synchronized (this){
            accessCount++;
            localCount = accessCount;
        }

        printWriter.println("This page has been access " + localCount + " times");
        printWriter.println("<br>");
        String uname = request.getParameter("param1");
        String passw = request.getParameter("param2");
        printWriter.println(uname + "-" + passw);

        Enumeration paramNameEnumeration = request.getParameterNames();

        while(paramNameEnumeration.hasMoreElements()){
            String pname = (String)paramNameEnumeration.nextElement();
            printWriter.println("<h1>" + pname + "</h1>");
            String[] pvalues = request.getParameterValues(pname);
            if (pvalues.length == 1){
                String val = pvalues[0];
                if (val.length() == 0){
                    printWriter.println("<i>No Value</i>");
                }
                else{
                    printWriter.println(val);
                }
            }
            else{
                printWriter.println("<ul>");
                for (int i = 0; i < pvalues.length; i++) {
                    printWriter.println("<li>" + pvalues[i] + "</li>");
                }
                printWriter.println("</ul>");
            }
        }
    }
}
