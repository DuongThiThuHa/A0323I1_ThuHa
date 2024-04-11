package demo.service;

import demo.dto.cart.AddToCartDto;
import demo.dto.cart.CartDto;
import demo.dto.cart.CartItemDto;
import demo.exceptions.CustomerException;
import demo.exceptions.ProductNotExistsException;
import demo.model.Cart;
import demo.model.Product;
import demo.model.User;
import demo.repository.CartRepo;
import demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    ProductService productService;

    @Autowired
    CartRepo cartRepo;

    public void addToCart(AddToCartDto addToCartDto, User user) throws ProductNotExistsException {
        //validate if the product id is valid
        Product product = productService.findById(addToCartDto.getProductId());
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());

        //save the cart
        cartRepo.save(cart);

    }


    public CartDto listCartItem(User user) {
        List<Cart> cartList = cartRepo.findAllByUserOrderByCreatedDateDesc(user);
        List< CartItemDto > cartItems = new ArrayList<>();
        double totalCost = 0;
        for (Cart cart : cartList){
            CartItemDto cartItemDto = new CartItemDto();
            totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }

        CartDto cartDto = new CartDto();
        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems(cartItems);
        return cartDto;
    }

    public void deleteCartItem(Integer cartItemId, User user) throws CustomerException {
        Optional<Cart> optionalCart = cartRepo.findById(cartItemId);
        if (optionalCart.isEmpty()){
            throw new CustomerException("Cart item id is invalid "+ cartItemId);
        }
        Cart cart = optionalCart.get();
        if (cart.getUser() != user){
            throw new CustomerException("Cart item does not belong to user : " + cartItemId);
        }

        cartRepo.delete(cart);
    }
}
