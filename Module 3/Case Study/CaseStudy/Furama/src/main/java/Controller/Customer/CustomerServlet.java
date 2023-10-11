package Controller.Customer;

import Model.Customer;
import Service.Customer.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            default:
                showCustomer(request,response);
        }

    }

    private void showCustomer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customer",customerService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birth");
        Boolean gender = request.getParameter("gender").isEmpty();
        String cardID = request.getParameter("cardID");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int  CustomerType = Integer.parseInt(request.getParameter("CustomerType"));
        Customer customer = new Customer(id,name,birthday,gender,cardID,phone,email,address,CustomerType);
        customerService.add(customer);
        request.setAttribute("customer",customerService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Customer/list.jsp");
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
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
        }
    }
}


