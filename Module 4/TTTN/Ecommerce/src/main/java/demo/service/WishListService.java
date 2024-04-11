package demo.service;

import demo.dto.ProductDto;
import demo.model.User;
import demo.model.WishList;
import demo.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {
    @Autowired
    WishListRepo wishListRepo;

    @Autowired
    ProductService productService;
    public void createWishList(WishList wishList){
        wishListRepo.save(wishList);
    }

    public List< ProductDto> getWishListForuser(User user) {
        final List<WishList> wishLists = wishListRepo.findAllByUserOrderByCreatedDateDesc(user);
        List<ProductDto> productDtos = new ArrayList<>();
        for (WishList wishList : wishLists){
            productDtos.add(productService.getProductDto(wishList.getProduct()));
        }
        return productDtos;
    }
}
