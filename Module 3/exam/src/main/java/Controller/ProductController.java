package Controller;

import Model.Category;
import Model.Product;
import Repository.CategoryRepo;
import Repository.ICategoryRepo;
import Repository.IProductRepo;
import Repository.ProductRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/product")

public class ProductController extends HttpServlet {
    private IProductRepo iProductRepo = new ProductRepo();
    private ICategoryRepo iCategoryRepo = new CategoryRepo();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
//            case "edit":
//                edit(request,response);
            case "delete":
                delete(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        iProductRepo.delete(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = iCategoryRepo.findCategoryById(categoryId);
        Product product = new Product(name,price,quantity,color,category);
        iProductRepo.create(product);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            System.out.println("99");
            action = "";
        }
        switch (action){
            case "show-form-create":
                showFormCreate(request,response);
                break;
            default:
                System.out.println("11");;
                showListProduct(request, response);
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list;
        list = iProductRepo.showListProduct();
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> list = iCategoryRepo.showListCategory();
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
