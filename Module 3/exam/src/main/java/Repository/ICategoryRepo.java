package Repository;

import Model.Category;

import java.util.List;

public interface ICategoryRepo {
    List<Category> showListCategory();
    Category findCategoryById(int id);
}
