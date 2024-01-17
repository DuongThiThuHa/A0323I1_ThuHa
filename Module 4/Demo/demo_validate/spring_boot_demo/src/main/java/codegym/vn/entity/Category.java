package codegym.vn.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name", columnDefinition = "varchar(50)")
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List< Blog > blogs;

    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List< Blog > getBlogs() {
        return blogs;
    }

    public void setBlogs(List< Blog > blogs) {
        this.blogs = blogs;
    }
}
