package codegym.vn.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0, message = "STT phải là số nguyên dương")
    private int id;

    @NotBlank
    @Size(min = 5, max = 50, message = "{title.size}")
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRelease;

    @NotBlank
    @Column(name = "people", columnDefinition = "varchar(100)")
    private String people;

    @NotBlank
    @Size(min = 5, max = 500, message = "{content.size}")
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, Date dateRelease, String people, String content, Category category) {
        this.id = id;
        this.title = title;
        this.dateRelease = dateRelease;
        this.people = people;
        this.content = content;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
