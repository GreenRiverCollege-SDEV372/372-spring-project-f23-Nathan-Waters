package edu.greenriver.sdev.food.controller;

import edu.greenriver.sdev.food.services.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    private PageService service;

    public PageController(PageService service){
        this.service = service;
    }

    @GetMapping("/recipesPage")
    public String getRecipesPage(){
        return "recipesPage";
    }
}
