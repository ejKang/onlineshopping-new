package net.ejkang.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.ejkang.shoppingbackend.dao.CategoryDAO;
import net.ejkang.shoppingbackend.dao.ProductDAO;
import net.ejkang.shoppingbackend.dto.Category;
import net.ejkang.shoppingbackend.dto.Product;


@Controller
@RequestMapping("/manage")
public class ManagementController {

    @Autowired
    private CategoryDAO categoryDAO ;

    @Autowired
    private ProductDAO productDAO ;

    @RequestMapping(value="products", method=RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name = "operation" , required = false)String operation){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageProducts", true);
        mv.addObject("title", "Manage Products");

        Product nProduct = new Product();

        nProduct.setSupplierId(1);
        nProduct.setActive(true);

        mv.addObject("product", nProduct);

        if (operation != null) {
            if (operation.equals("product")) {
                mv.addObject("message", "Product Submitted Successfully");
            }
        }
        return mv;
    }
    
    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDAO.list();
    }

    @RequestMapping(value="products", method=RequestMethod.POST)
    public String handleProductSubmission(@ModelAttribute("product")Product mProduct) {

        productDAO.add(mProduct);

        return "redirect:/manage/products?operation=product"; 
    }
}