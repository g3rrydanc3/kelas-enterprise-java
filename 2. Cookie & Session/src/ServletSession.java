import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ServletSession")
public class ServletSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String title = "";
        HttpSession session = request.getSession();
        Integer accessCount = (Integer)session.getAttribute("accessCount");
        if (accessCount == null){
            accessCount = new Integer(0);
            title = "Hi Newbie!";
        }
        else{
            accessCount = new Integer(accessCount.intValue() + 1);
        }
        session.setAttribute("accessCount", accessCount);


        ArrayList arrayListCart = (ArrayList) session.getAttribute("shopcart");
        if(arrayListCart == null){
            arrayListCart = new ArrayList();
            session.setAttribute("shopcart", arrayListCart);
        }
        String barang = request.getParameter("barang");
        synchronized (arrayListCart){
            if (barang != null){
                arrayListCart.add(barang);
            }
            if (arrayListCart.size() == 0){
                printWriter.println("<i>No Item in Cart </i>");
            }
            else{
                printWriter.println("<ul>");
                for (int i = 0; i < arrayListCart.size(); i++) {
                    printWriter.println("<li>" + (String)arrayListCart.get(i) + "</li>");
                }
                printWriter.println("</ul>");
            }
        }


        printWriter.println("<html><head><title></title></head><body>"+
                session.getId() + "<br> "+
                session.getCreationTime() + "<br> " +
                session.getLastAccessedTime() + "<br>" +
                session.getMaxInactiveInterval() + "<br> " +
                accessCount +
                "</body></html>");
    }
}
