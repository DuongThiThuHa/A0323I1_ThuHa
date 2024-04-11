package demo.controller;

import demo.common.ApiResponse;
import demo.dto.cart.AddToCartDto;
import demo.dto.cart.CartDto;
import demo.exceptions.AuthenticationFailException;
import demo.exceptions.CustomerException;
import demo.exceptions.ProductNotExistsException;
import demo.model.User;
import demo.service.AuthenticationService;
import demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private AuthenticationService authenticationService;


//post cart api
    @PostMapping("/add")
public ResponseEntity< ApiResponse > addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistsException {
    authenticationService.authenticate(token);

    User user = authenticationService.getUser(token);

    cartService.addToCart(addToCartDto, user );
    return new ResponseEntity<>(new ApiResponse(true, "Add to cart"), HttpStatus.CREATED);
}

    //get all cart items
    @GetMapping("/")
    public ResponseEntity< CartDto > getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);

        CartDto cartDto = cartService.listCartItem(user);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    //delete a cart
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId, @RequestParam("token") String token) throws AuthenticationFailException, CustomerException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        cartService.deleteCartItem(itemId, user);
        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
}
