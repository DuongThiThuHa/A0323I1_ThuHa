package demo.controller;

import demo.common.ApiResponse;
import demo.dto.ProductDto;
import demo.exceptions.AuthenticationFailException;
import demo.model.Product;
import demo.model.User;
import demo.model.WishList;
import demo.service.AuthenticationService;
import demo.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;
    @Autowired
    AuthenticationService authenticationService;

    //save product in wishlist
    @PostMapping("/add")
    public ResponseEntity< ApiResponse > addToWishList(@RequestBody Product product, @RequestParam("token") String token) throws AuthenticationFailException {
        //authentication the token
        authenticationService.authenticate(token);


        //find the user
        User user = authenticationService.getUser(token);


        //save the item in wishlist
        WishList wishList = new WishList(user, product);
        wishListService.createWishList(wishList);
        ApiResponse apiResponse = new ApiResponse(true, "Added to wishlist");
    return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    //get all wishlist item
    @GetMapping("/{token}")
    public ResponseEntity< List< ProductDto > >getWishList(@PathVariable("token")  String token) throws AuthenticationFailException {
        //authentication the token
        authenticationService.authenticate(token);

        //find the user
        User user = authenticationService.getUser(token);
        List<ProductDto> productDtos =  wishListService.getWishListForuser(user);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

}
