package lk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//default mapping
//http://localhost:8080/mapping/ No
//http://localhost:8080/mapping NO
//http://localhost:8080/mapping/abcd YES
//http://localhost:8080/mapping/abcd/ndjandjsand YES

@WebServlet(urlPatterns = "/")
public class DefaultMapping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Default Mapping Servlet Invoked");
        resp.getWriter().write("<h1>Default Mapping Servlet Invoked</h1>");
    }
}
