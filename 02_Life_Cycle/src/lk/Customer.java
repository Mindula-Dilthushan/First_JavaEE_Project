package lk;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "MyServlet",urlPatterns = "/myServlet")
public class Customer extends HttpServlet {

    public Customer(){
        System.out.println("Created Customer Object (Instantiated)");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Init Customer");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Customer doGet");
        printWriter.close();
    }

    @Override
    public void destroy() {
        System.out.println("Customer Destroy");
    }


}
