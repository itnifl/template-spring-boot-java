package io.recruitment.assessment.api.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import io.recruitment.assessment.config.GlobalConstants;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import io.recruitment.assessment.dto.ProductOrderDto;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @GetMapping
    @RolesAllowed({GlobalConstants.Roles.ADMIN, GlobalConstants.Roles.CUSTOMER})
    Map<String, List<ProductOrderDto>> GetOrders(String userLogin) {
        //Should fetch from database layer and in the process filter  on userLogin
        //Should only be accessible to admin or the current user when he queries himself

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(GlobalConstants.Roles.ADMIN)) 
        || auth.getName() == userLogin) {
            List<ProductOrderDto> orders = new ArrayList<ProductOrderDto>();
            //Fetch from db here
            return Map.of("orders", orders);
        }
        
        //If this is a user of the CUSTOMER role and he is querying something that doesn't belong to him, return an empty list:
        return Map.of("orders", new ArrayList<ProductOrderDto>());
    }

}
