package lk;

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "1023");
            PreparedStatement pstm = connection.prepareStatement("select * from Customer");
            ResultSet rst = pstm.executeQuery();
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");

            JsonArrayBuilder allCustomers = Json.createArrayBuilder();

            while (rst.next()) {
                String id = rst.getString(1);
                String name = rst.getString(2);
                String address = rst.getString(3);
                String salary = rst.getString(4);

                JsonObjectBuilder customer = Json.createObjectBuilder();
                customer.add("id",id);
                customer.add("name",name);
                customer.add("address",address);
                customer.add("salary",salary);
                allCustomers.add(customer.build());
            }
            writer.print(allCustomers.build());
            writer.close();
        } catch (ClassNotFoundException e) {

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "1023");
            PreparedStatement pstm = connection.prepareStatement("insert into Customer values(?,?,?,?)");
            pstm.setObject(1, id);
            pstm.setObject(2, name);
            pstm.setObject(3, address);
            pstm.setObject(4, salary);
            int i = pstm.executeUpdate();

            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            if (i > 0) {
                writer.write("{\"operation\":\"success\"}");
            }
            writer.close();
        } catch (ClassNotFoundException e) {

        } catch (SQLException throwables) {

        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader jsonReader = Json.createReader(req.getReader());
        JsonObject customer = jsonReader.readObject();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "1023");
            PreparedStatement pstm = connection.prepareStatement("UPDATE customer set name=?,address=?,salary=? WHERE id=?");
            pstm.setObject(1,name);
            pstm.setObject(2,address);
            pstm.setObject(3,salary);
            pstm.setObject(4,id);
                int i = pstm.executeUpdate();
                PrintWriter writer = resp.getWriter();

                if(i>0){
                    writer.write("Customer Updated");
                    writer.write(id);
                    writer.write(name);
                    writer.write(address);
                    writer.write(salary);
                }
                writer.close();

        } catch (ClassNotFoundException e) {

        } catch (SQLException throwables) {
        }
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        JsonReader jsonReader =
    }
}
