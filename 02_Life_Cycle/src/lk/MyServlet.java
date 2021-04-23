package lk;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet",urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

    public MyServlet(){
        System.out.println("Created MyServlet Object (Instantiated)");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Init Servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("My Servlet doGet Called");
            try (PrintWriter writer = resp.getWriter()) {
                writer.write("My Servlet Called");
            } catch (IOException e) {
            }
    }

    @Override
    public void destroy() {
        System.out.println("My Servlet Destroy");
    }
}
