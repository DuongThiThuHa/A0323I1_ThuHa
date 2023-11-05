package Controller;

import Model.PhongTro;
import Model.Rent;
import Service.IRentService;
import Service.RentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RentController", value = "/rent")

public class RentController extends HttpServlet {
    private IRentService iRentService = new RentService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        } else {
            switch (action){
                case "list":
                    showRentList(request,response);
            }
        }
    }

    private void showRentList(HttpServletRequest request, HttpServletResponse response) {
        List<Rent> rentList = iRentService.findAll();
        request.setAttribute("rentList", rentList);
        try {
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }else {
            switch (action){
                case "craete":
                    showRentList(request,response);
            }
        }
    }
}
