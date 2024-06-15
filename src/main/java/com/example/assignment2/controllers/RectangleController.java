package com.example.assignment2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.assignment2.models.Rectangle;

@Controller
public class RectangleController {
    @GetMapping("rectangles/view")
    public String getAllRectangles(Model model){
        List<Rectangle> rectangles= new ArrayList<>();
        model.addAttribute("rectangles", rectangles);
        return "rectangles/showAll";
    }
}
