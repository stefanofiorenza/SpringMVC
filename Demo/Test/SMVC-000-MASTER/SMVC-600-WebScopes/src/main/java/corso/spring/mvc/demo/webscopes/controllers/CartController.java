package corso.spring.mvc.demo.webscopes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import corso.spring.mvc.demo.webscopes.beans.Product;
import corso.spring.mvc.demo.webscopes.beans.ShoppingCart;
import corso.spring.mvc.demo.webscopes.dao.ProductDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/cart")
public class CartController {

	public static final String PRODUCT_VIEW="products";
	public static final String CART_VIEW="cart";
	
	public static final String CART_UPDATE_KEY="updateCart";
	public static final String CART_LIST_KEY="productsInCart";
	
	@Autowired
	private ShoppingCart shoppingCart;
	
	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping("/")
	public String index(){
		return PRODUCT_VIEW;	
	}
	
	@RequestMapping("/add")
	public ModelAndView addProductToCart(@RequestParam(value="pid") int prodId){
		ModelAndView mav = new ModelAndView(PRODUCT_VIEW);
		mav.addObject(CART_UPDATE_KEY, shoppingCart.addProduct(prodId));
		return mav;	
	}
	
	@RequestMapping("/remove")
	public ModelAndView removeProductToCart(@RequestParam(value="pid")int prodId){
		ModelAndView mav = new ModelAndView(PRODUCT_VIEW);
		mav.addObject(CART_UPDATE_KEY, shoppingCart.removeProduct(prodId));
		return mav;	
	}
	
	@RequestMapping("/list")
	public ModelAndView showProductsInCart(){
		ModelAndView mav = new ModelAndView(CART_VIEW);
		List<Product> products = new ArrayList<Product>();		
			
		for (int prodId : shoppingCart.listProducts()){
			products.add(productDao.findById(prodId));
		}
		mav.addObject(CART_LIST_KEY, products);
		return mav;		
	}
	
}
