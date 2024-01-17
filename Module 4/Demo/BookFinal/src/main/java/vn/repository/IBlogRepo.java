package vn.repository;

import vn.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepo extends JpaRepository< Blog, Integer > {
    public List< Blog > findAllByNameContaining(String name);

    @Query("from Blog b where b.title like :title")
    public List< Blog > search(@Param("title") String title);
}
