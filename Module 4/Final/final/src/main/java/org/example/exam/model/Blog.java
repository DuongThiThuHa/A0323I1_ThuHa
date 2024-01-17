package org.example.exam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Min(value = 0, message = "ID phai la so nguyen duong")
    private int id;

    @Column(name = "title", columnDefinition = "varchar(50)")
    @Size(min = 1, max = 50, message = "{title.size}")
    private String title;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRelease;

    @Column(name = "people", columnDefinition = "varchar(100)")
    private String people;

    @Column(name = "content", columnDefinition = "varchar(500)")
    @Size(min = 5, max = 50, message = "{content.size}")
    private String content;

    public Blog() {
    }

    public Blog(int id, String title, Category category, Date dateRelease, String people, String content) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.dateRelease = dateRelease;
        this.people = people;
        this.content = content;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
