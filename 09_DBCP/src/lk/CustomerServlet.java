package lk;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.json.*;
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
        try {
            BasicDataSource ds = (BasicDataSource) getServletContext().getAttribute("ds");
            Connection connection = ds.getConnection();

            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer");
            ResultSet rst = pstm.executeQuery();
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");

            //for creating a json array
            JsonArrayBuilder allCustomers = Json.createArrayBuilder();

            while (rst.next()) {
                String id = rst.getString(1);
                String name = rst.getString(2);
                String address = rst.getString(3);
                String salary = rst.getString(4);

                //creating a json object
                JsonObjectBuilder customer = Json.createObjectBuilder();
                customer.add("id", id);
                customer.add("name", name);
                customer.add("address", address);
                customer.add("salary", salary);
                allCustomers.add(customer.build());
            }
            connection.close();
            writer.print(allCustomers.build());
            writer.close();
        } catch (SQLException throwables) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");

        try {
            BasicDataSource ds = (BasicDataSource) getServletContext().getAttribute("ds");
            Connection connection = ds.getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");
            pstm.setObject(1, id);
            pstm.setObject(2, name);
            pstm.setObject(3, address);
            pstm.setObject(4, salary);
            int i = pstm.executeUpdate();

            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            if (i > 0) {
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("operation", "success");
                writer.print(response.build());
            }
            connection.close();
            writer.close();
        } catch (SQLException throwables) {
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject customer = reader.readObject();
        String id = customer.getString("id");
        String name = customer.getString("name");
        String address = customer.getString("address");
        String salary = customer.getString("salary");

        try {
            BasicDataSource ds = (BasicDataSource) getServletContext().getAttribute("ds");
            Connection connection = ds.getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?,address=?,salary=? where id=?");
            pstm.setObject(1, name);
            pstm.setObject(2, address);
            pstm.setObject(3, salary);
            pstm.setObject(4, id);
            int i = pstm.executeUpdate();
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            if (i > 0) {
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("operation", "success");
                writer.print(response.build());
            }
            writer.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            BasicDataSource ds = (BasicDataSource) getServletContext().getAttribute("ds");
            Connection connection = ds.getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer  WHERE id=?");
            pstm.setObject(1, id);
            int i = pstm.executeUpdate();
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            if (i > 0) {
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("operation", "success");
                writer.print(response.build());
            }
            writer.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
