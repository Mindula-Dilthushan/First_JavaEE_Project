package lk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//File Extension Mapping
//http://localhost:8080/mapping/ NO
//http://localhost:8080/mapping NO
//http://localhost:8080/mapping/abcd.php YES
//http://localhost:8080/mapping/abcd/ndjandjsand.php YES


@WebServlet(urlPatterns = "*.php")
public class FileExtensionMapping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("File Extension Mapping Was Called");
        resp.getWriter().write("<h1>File Extension Mapping Was Called</h1>");
    }
}
