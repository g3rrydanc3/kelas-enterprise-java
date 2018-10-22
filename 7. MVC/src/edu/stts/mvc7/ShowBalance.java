package edu.stts.mvc7;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowBalance")
public class ShowBalance extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BankCustomer customer = BankCustomer.getCustomer(request.getParameter("id"));
        String url = "";
        if(customer == null || customer.equals(null)){
            url = "/WEB-INF/unknown.jsp";
    }
        else if(customer.getBalance() <= 0){
            url = "/WEB-INF/zero.jsp";
            request.setAttribute("zeroCustomer", customer);
        }
        else{
            url= "/WEB-INF/customer.jsp";
            request.setAttribute("bankCustomer", customer);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
