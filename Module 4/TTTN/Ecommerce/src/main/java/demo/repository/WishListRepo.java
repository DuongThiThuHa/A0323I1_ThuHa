package demo.repository;

import demo.model.User;
import demo.model.WishList;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepo extends JpaRepository< WishList, Integer > {
    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);

}
