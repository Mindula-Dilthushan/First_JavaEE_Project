package lk;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/up")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Catch the file from the request
        Part uploadedFile = req.getPart("file");
        //Get the file name
        String submittedFileName = uploadedFile.getSubmittedFileName();
        //Select a place to upload
        String realPath = getServletContext().getRealPath("");
        //Get the input stream of the file
        InputStream inputStream = uploadedFile.getInputStream();

        //Create a new empty file to store the uploaded file
        File newFile = new File(realPath + File.separator + submittedFileName);
        newFile.createNewFile();

        //To write down the file
        FileOutputStream out = new FileOutputStream(newFile);

        //Read the input stream and write it down to the newly created file
        int read;
        byte[] buffer = new byte[1024];
        while ((read = inputStream.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, buffer.length);
//            resp.getOutputStream().write(buffer, 0, buffer.length);
        }
        out.close();

    }
}
