package io.recruitment.assessment.api.controllers;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import javax.annotation.security.RolesAllowed;
import io.recruitment.assessment.config.GlobalConstants;

@EnableWebSecurity
@RestController
@RequestMapping("/news")
public class NewsConroller {
    //This controller is really a stub, 
    //it should handle requests and talk too the database layer or services with the database layer,
    //referably implemented by dependency injection

    @GetMapping
    @RolesAllowed({GlobalConstants.Roles.CUSTOMER})
    Map<String, String> GetNews() {
        
        return Map.of("news", "Bill Gates resurrects dinosaurs!");
    }

    @PostMapping
    @RolesAllowed({GlobalConstants.Roles.ADMIN})
    Map<String, String> PostNew(String news) {
        
        return Map.of("news", news);
    }

}
