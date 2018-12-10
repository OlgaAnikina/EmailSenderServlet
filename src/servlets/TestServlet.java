package servlets;

import action.EmailSender;
import action.ValidatorMail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    private static final String USER_PASSWORD = "q9w8e7r6";
    private ValidatorMail validatorMail = new ValidatorMail();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String useremail = request.getParameter("useremail");
        String userpassword = request.getParameter("userpassword");

        Date currentDate = new Date();


        if (userpassword.equals(USER_PASSWORD) && (validatorMail.validate(useremail))) {
            try {
                request.setAttribute("useremail", useremail);
                request.setAttribute("userpassword", userpassword);

                request.setAttribute("data", currentDate);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("inner.jsp");
                requestDispatcher.forward(request, response);
                EmailSender.sender();

            } catch (ServletException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        } else {
            String path = "/notfound";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}
