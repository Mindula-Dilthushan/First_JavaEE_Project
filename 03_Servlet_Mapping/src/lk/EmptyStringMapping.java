package lk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//Empty String Mapping
//http://localhost:8080/mapping/ YES
//http://localhost:8080/mapping YES
//http://localhost:8080/mapping/abcd NO
//http://localhost:8080/mapping/abcd/ndjandjsand NO


@WebServlet(urlPatterns = "")
public class EmptyStringMapping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Empty String Mapping Was Invoked");
        resp.getWriter().write("<h1>Empty String Mapping Was Invoked</h1>");
    }
}
