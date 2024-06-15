package com.example.assignment2.controllers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.assignment2.models.Rectangle;
import com.example.assignment2.models.RectangleRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RectangleController {
    @Autowired
    private RectangleRepository rectangleRepo;
    @GetMapping("rectangles/view")
    public String getAllRectangles(Model model){
        List<Rectangle> rectangles= rectangleRepo.findAll();
        model.addAttribute("rectangles", rectangles);
        return "rectangles/showAll";
    }
    
    
}
