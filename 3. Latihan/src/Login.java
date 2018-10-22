import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = null;
        String password = null;

        PrintWriter writer = response.getWriter();
        username = request.getParameter("username");
        password = request.getParameter("password");

        String usernameReverse = new StringBuffer(username).reverse().toString();

        if (username != null && password != null && password.equals(usernameReverse)){
            //login success
            writer.println(request.getParameter("rememberme"));
            if (request.getParameter("rememberme").equals("1")) {
                writer.println(request.getParameter("rememberme"));
                Cookie remembermeCookie = new Cookie("rememberme", username);
                remembermeCookie.setMaxAge(60 * 60 * 24 * 2);
                response.addCookie(remembermeCookie);
            }
            writer.println("Welcome, " + username);
        }
        else{
            //login fail
            writer.println("Login error." +
                    "<br>" +
                    "<a href='Login'>Back to home</a>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String username = null;
        Cookie[] allCookie = request.getCookies();
        if (allCookie != null){
            for (int i = 0; i < allCookie.length; i++) {
                Cookie cookie = allCookie[i];
                if (cookie.getName().equals("rememberme")){
                    username = cookie.getValue();
                }
            }
        }
        if (username != null){
            writer.println("Welcome, " + username);
        }
        else{
            writer.println("<form method='post' action='Login'>" +
                    "Username : <input type='text' name='username'>" +
                    "<br>" +
                    "Password : <input type='password' name='password'>" +
                    "<br>" +
                    "<input type='checkbox' name='rememberme' value='1'>Remember Me" +
                    "<br>" +
                    "<input type='submit'>" +
                    "</form>");
        }

    }
}
