package Controller;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Error! ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }else {
            switch (action){
                case "create":
                    createStudent(request,response);
                    break;
                case "edit":
                    editStudent(request,response);
                    break;
                case "delete":
                    break;
                default:
                    break;
            }
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }else {
            switch (action){
                case "create":
                    createStudent(request,response);
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                default:
                    break;
            }
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}