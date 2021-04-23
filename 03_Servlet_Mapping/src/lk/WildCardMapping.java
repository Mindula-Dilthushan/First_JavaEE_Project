package lk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//Wild Card Mapping
//http://localhost:8080/mapping/ NO
//http://localhost:8080/mapping NO
//http://localhost:8080/mapping/item/a/b/c/d YES
//http://localhost:8080/mapping/abcd/item/1/2/3 NO

@WebServlet(urlPatterns = "/items/*")
public class WildCardMapping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Wild Card Mapping Was Invoked");
        resp.getWriter().write("<h1>Wild Card Mapping Was Invoked</h1>");
    }
}
