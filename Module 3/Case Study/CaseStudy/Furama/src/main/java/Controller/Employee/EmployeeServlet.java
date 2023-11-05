package Controller.Employee;

import Model.Employee;
import Service.Employee.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/employee")

public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = " ";
        }else {
            switch (action){
                case "add":
                    create(request,response);
                default:
                    break;
            }

        }
    }
//    private int employee_id;
//    private String employee_name;
//    private String employee_birthday;
//    private String employee_id_card;
//    private String employee_phone;
//    private String employee_email;
//    private String employee_degree;
//    private String position_id;
//    private String employee_salary;
    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        String name = request.getParameter("employee_name");
        String birthday = request.getParameter("employee_birthday");
        String card_id = request.getParameter("employee_id_card");
        String phone = request.getParameter("employee_phone");
        String email = request.getParameter("employee_email");
        String degree = request.getParameter("employee_degree");
        String position = request.getParameter("employee_position_id");
        String salary = request.getParameter("employee_salary");

        Employee employee = new Employee(id,name,birthday,card_id,phone,email,degree,position,salary);
        employeeService.add(employee);
        request.setAttribute("employee",employeeService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Employee/create.jsp");
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
        if (action == null){
            action = " ";
        }else {
            switch (action){
                case "add":
                break;
                default:
                    break;
            }

        }


    }
}
