import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCookie")
public class ServletCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        boolean newbie = true;
        String count = "";


        Cookie[] allCookie = request.getCookies();
        if (allCookie != null){
            for (int i = 0; i < allCookie.length; i++) {
                Cookie cookie = allCookie[i];
                if (cookie.getName().equals("repeatVisitor") && cookie.getValue().equals("yes")){
                    newbie = false;
                    //break;
                }
                if (cookie.getName().equals("accessCount")){
                    count = cookie.getValue();
                    //break;
                }
            }
        }



        String title;
        if (newbie){
            Cookie returnVisitorCookie = new Cookie("repeatVisitor", "yes");
            returnVisitorCookie.setMaxAge(60);
            response.addCookie(returnVisitorCookie);
            title = "Welcome";
        }
        else{
            title = "Welcome Back";
        }

        int countInt = 0;
        try {
            countInt = Integer.parseInt(count);
        }
        catch (NumberFormatException e){

        }

        Cookie accessCountCookie = new Cookie("accessCount", String.valueOf(++countInt));
        accessCountCookie.setMaxAge(60*60*24);
        response.addCookie(accessCountCookie);


        printWriter.println("<html><head><title>" +
                title +
                "</title></head><body>" +
                "Your visit: " + countInt +
                "</body></html>");
    }
}
