package Controller;

import Model.Customer;
import Service.CustomerService;
import Service.ICustomerService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "customerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {

    private ICustomerService iCustomerService = new CustomerService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        } else {
            switch (action) {
                case "create":
                    showCreate(request,response);
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                default:
                    listCustomer(request,response);
                    break;
            }
        }
    }

    //Show Create
    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //List Customer
    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.iCustomerService.findAll();
        request.setAttribute("customers",customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        } else {
            switch (action) {
                case "create":
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

    public void destroy() {
    }
}