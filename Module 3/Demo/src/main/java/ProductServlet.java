import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet")
public class ProductServlet extends HttpServlet {
    private IProductRepo iProductRepo = new ProductRepo();
    private ICategoryRepo iCategoryRepo = new CategoryRepo();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String action = request.getParameter("action");
       if (action == null){
           action = "";
       } else {
           switch (action){
               case "showFormCreate":
                   showFormCreate(request,response);
               default:
                   showListProduct(request,response);
           }
       }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList ;
        productList = iProductRepo.showListProduct();
        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = iCategoryRepo.showListCategory();
        request.setAttribute("categoryList",categoryList);
        try {
            request.getRequestDispatcher("/formCreate.jsp").forward(request,response);
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
            action = "";
        } else {
            switch (action){
                case "create":
                    create(request,response);
                    break;
                case  "delete":
                    delete(request,response);
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        iProductRepo.delete(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = iCategoryRepo.findCategoryById(categoryId);
        Product product = new Product(name,categoryId);
        iProductRepo.create(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}