package Controller;

import Model.NguoiThue;
import Model.PhongTro;
import Model.Rent;
import Service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PhongTroController", value = "/tro")
public class PhongTroController extends HttpServlet {
    private IPhongTroService iPhongTroService= new PhongTroService();
    private INguoiThueService iNguoiThueService = new NguoiThueService();
    private IRentService iRentService = new RentService();
    private Object Validate;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                showPage(request, response);
                break;
            case "rent":
                showRentPage(request, response);
                break;
        }
    }

    private void showRentPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhongTro phongTro = iPhongTroService.findByID(request.getParameter("id"));
        List<NguoiThue> nguoiThueList = iNguoiThueService.findAll();
        request.setAttribute("phongTro", phongTro);
        request.setAttribute("Date", new Date());
        request.setAttribute("nguoiThueList", nguoiThueList);
        request.getRequestDispatcher("/rent.jsp").forward(request, response);
    }

    private void showPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhongTro> phongTroList = iPhongTroService.findAll();
        request.setAttribute("phongTroList", phongTroList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                showPage(request, response);
                break;
            case "rent":
                doRent(request, response);
                break;
        }
    }

    private void doRent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isValid = true;
        String name = request.getParameter("name");
        Date ngayThue = new Date();

        if (isValid) {
            String book_id = request.getParameter("id");
            PhongTro phongTro = iPhongTroService.findByID(book_id);
            int maNguoiThue = Integer.parseInt(request.getParameter("maNguoiThue"));
            NguoiThue nguoiThue = iNguoiThueService.findByID(maNguoiThue);
            Rent rent = new Rent(name,phongTro, maNguoiThue, ngayThue);
            iRentService.add(rent);
        } else {
            showRentPage(request, response);
        }
    }

}
