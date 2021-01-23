package io.recruitment.assessment.api.controllers;

import java.util.List;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.recruitment.assessment.config.GlobalConstants;
import io.recruitment.assessment.dto.ProductDto;

import java.util.Map;

import javax.annotation.security.RolesAllowed;

@EnableWebSecurity
@RestController
@RequestMapping("/products")
public class ProductController {
    private List<String> _fictousLog = new ArrayList<String>();
    private List<ProductDto> _products = new ArrayList<ProductDto> ();
    private final String _errorMessage = "Error! See the application log or contact your administrator.";

    public ProductController() {
        _products.add(new ProductDto("Hammer", "This is a very nice hammer", 200, 1));
        _products.add(new ProductDto("Nails", "These are nice nails", 100, 2));
        _products.add(new ProductDto("Hard wood floor", "Oak wood flooring for a good price", 100, 4));
    }

    @GetMapping
    @RolesAllowed({GlobalConstants.Roles.ADMIN, GlobalConstants.Roles.CUSTOMER})
    Map<String, List<ProductDto>> GetProducts() {
        
        return Map.of("products", _products);
    }

    @PostMapping
    @RolesAllowed({GlobalConstants.Roles.ADMIN})
    Map<String, String> AddProducts(List<ProductDto> products) {
        try {
            _products.addAll(products);
        } catch(Exception e) {
            LogThis(e);
            return Map.of("status", _errorMessage);
        }
        return Map.of("status", "true");
    }

    @PutMapping
    @RolesAllowed({GlobalConstants.Roles.ADMIN})
    Map<String, String> UpdateProducts(List<ProductDto> updateProducts) {
        try {
            for(ProductDto product : updateProducts) {
                ProductDto productToUpdate = _products.stream().filter(pr -> product.getId() == pr.getId()).findAny().orElse(null);
                if(productToUpdate != null) {
                    productToUpdate.setName(product.getName());
                    productToUpdate.setProductPrice(product.getProductPrice());
                } else {
                    _products.add(product);
                }
            }
        } catch(Exception e) {
            LogThis(e);
            return Map.of("status", _errorMessage);
        }
        return Map.of("status", "true");
    }

    @DeleteMapping
    @RolesAllowed({GlobalConstants.Roles.ADMIN})
    Map<String, String> DeleteProducts(List<Integer> productIds) {
        try  {
            for(Integer id : productIds) {
                ProductDto productToDelete = _products.stream().filter(pr -> id == pr.getId()).findAny().orElse(null);
                if(productToDelete != null) {
                    _products.remove(productToDelete);
                } 
            }
        } catch(Exception e) {
            LogThis(e);
            return Map.of("status", _errorMessage);
        }
        return Map.of("status", "true");
    }

    private void LogThis(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
         _fictousLog.add(sw.toString());
    }
}
