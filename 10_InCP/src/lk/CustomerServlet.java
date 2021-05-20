package lk;
import javax.annotation.Resource;
import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String option = req.getParameter("option");
        switch (option) {
            case "search":
                break;
            case "getAll":

        }

        try {
            try (Connection connection = ds.getConnection()) {
                PreparedStatement pstm = connection.prepareStatement("select * from Customer");
                ResultSet rst = pstm.executeQuery();
                JsonArrayBuilder allCustomers = Json.createArrayBuilder();
                while (rst.next()) {
                    JsonObjectBuilder customer = Json.createObjectBuilder();
                    customer.add("id", rst.getString(1));
                    customer.add("name", rst.getString(2));
                    customer.add("address", rst.getString(3));
                    customer.add("salary", rst.getString(4));
                    allCustomers.add(customer.build());
                }

                resp.getWriter().print(allCustomers.build());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //how to read a json array from a request body using JSON P
        JsonReader reader = Json.createReader(req.getReader());
        JsonArray jsonArray = reader.readArray();

       /* for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.getJsonObject(i);
            String id = jsonObject.getString("id");
            System.out.println(id);
        }*/

        for (JsonValue jsonObject : jsonArray) {
            JsonObject customer = jsonObject.asJsonObject();
            String id = customer.getString("id");
            String name = customer.getString("name");
            String address = customer.getString("address");
            String salary = customer.getString("salary");
            System.out.println(id + " " + name + " " + address + " " + salary);
        }
    }
}
