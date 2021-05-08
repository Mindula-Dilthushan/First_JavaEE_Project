package lk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String pathInfo = req.getPathInfo();
//        String method = req.getMethod();
//        String contextPath = req.getContextPath();
//        String queryString = req.getQueryString();
//        StringBuffer requestURL = req.getRequestURL();
//        String servletPath = req.getServletPath();
//
//        System.out.println("Path InFo" + pathInfo);
//        System.out.println("Method " + method);
//        System.out.println("Context Path " + contextPath);
//        System.out.println("Query String " + queryString);
//        System.out.println("Request URL " + requestURL);
//        System.out.println("Servlet Path " + servletPath);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "1023");
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customer");
            ResultSet rst = pstm.executeQuery();

            resp.setContentType("text/html");
            //response generate
            PrintWriter writer = resp.getWriter();
            writer.write("<link href=\"assests/css/bootstrap.min.css\" rel=\"stylesheet\">");
            writer.write("<table class=\"table table-bordered\")");
            writer.write("<thead>");
            writer.write("<tr>");
            writer.write("<td>ID</td><td>Name</td><td>Address</td><td>Salary</td>");
            writer.write("</tr>");
            writer.write("</thead>");
            writer.write("<tbody>");
            while (rst.next()) {
                String id = rst.getString(1);
                String name = rst.getString(2);
                String address = rst.getString(3);
                String salary = rst.getString(4);

                writer.write("<tr><td>" + id + "</td><td>" + name + "</td><td>" + address + "</td><td>" + salary + "</td></tr>");
            }

            writer.write("</tbody>");
            writer.write("</table>");
            writer.close();

        } catch (ClassNotFoundException e) {
        } catch (SQLException throwables) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //gather the information from the request
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "1023");
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer values(?,?,?,?)");
            pstm.setObject(1, id);
            pstm.setObject(2, name);
            pstm.setObject(3, address);
            pstm.setObject(4, salary);
            PrintWriter writer = resp.getWriter();
            int i = pstm.executeUpdate();
            if (i > 0) {
                writer.write("Customer Saved");
            } else {
                writer.write("Customer Not Saved");
            }
            writer.close();

        } catch (ClassNotFoundException e) {
        } catch (SQLException throwables) {
        }
    }
}
