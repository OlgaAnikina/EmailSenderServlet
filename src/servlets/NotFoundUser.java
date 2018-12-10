package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notfound")
public class NotFoundUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String userPassword = request.getParameter("userpassword");
        String useMmail = request.getParameter("useremail");
        try {
            writer.println("<h2>" + " You inpuy incorrect date! Please check them and try again." + "</h2>");
            writer.println("<h2>Your Password " + userPassword + " </h2>");
            writer.println("<h2>Your mail: " + useMmail + " </h2>");
        } finally {
            writer.close();
        }
    }
}