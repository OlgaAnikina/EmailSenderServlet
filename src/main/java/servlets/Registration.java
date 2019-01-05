package servlets;

import action.ValidatorDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@WebServlet("/regist")
public class Registration extends HttpServlet {
    ClassLoader classLoader = getClass().getClassLoader();
    private String path = classLoader.getResource("/users.txt").getPath();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ValidatorDate validatorDate = new ValidatorDate();

        Scanner in = new Scanner(new File(path));
        StringBuffer data = new StringBuffer();

        while (in.hasNextLine()) {
            data.append(in.nextLine()).append(System.getProperty("line.separator"));
        }

        if (validatorDate.validate(login, password)) {
            response.getWriter().write("<h1>User with same login already exist.</h1>");
        } else if (login.equals("") || (password.equals(""))) {
            response.getWriter().write("<h1>Login and Password can't be empty</h1>");
        } else {
            FileWriter writer = new FileWriter(path, false);
            writer.write(data.toString() + login + "/" + password + ";");
            writer.flush();
            writer.close();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("inner.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
