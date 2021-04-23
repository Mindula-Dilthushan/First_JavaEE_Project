package lk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//Path Mapping or Exact Mapping
//http://localhost:8080/mapping/ NO
//http://localhost:8080/mapping NO
//http://localhost:8080/mapping/path YES
//http://localhost:8080/mapping/abcd/ndjandjsand/path NO

@WebServlet(urlPatterns = "/path")
public class PathMapping extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Path Servlet DO GET Invoked");
        resp.getWriter().write("<h1>Path Servlet DO GET Invoked</h1>");

    }
}
