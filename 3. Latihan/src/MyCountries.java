import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "MyCountries")
public class MyCountries extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();

        ArrayList<String> country = new ArrayList<>();
        country.add("Indonesia");
        country.add("Singapore");
        country.add("Australia");
        country.add("Malaysia");
        printWriter.println("<select>");
        for (int i = 0; i < country.size(); i++) {
            printWriter.println("<option value=\"" + country.get(i) + "\">" + country.get(i) + "</option>");
        }
        printWriter.println("</select>");
    }
}
