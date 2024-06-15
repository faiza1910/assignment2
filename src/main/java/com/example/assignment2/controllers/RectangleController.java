package com.example.assignment2.controllers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/rectangles/add")
    public String addRectangles(@RequestParam Map<String, String> newRectangle, HttpServletResponse response){
        String newName = newRectangle.get("name");
        int newWidth= Integer.parseInt(newRectangle.get("width"));
        int newHeight= Integer.parseInt(newRectangle.get("height"));
        String newColor = newRectangle.get("color");
        rectangleRepo.save(new Rectangle(newName,newWidth,newHeight,newColor));
        return "redirect:/rectangles/view";
    }
    @GetMapping("/static/add")
    public String showAddForm() {
        return "redirect:/add.html";
    }
    @GetMapping("/rectangles/view/{id}")
    public String getRectangle(@PathVariable int id, Model model){
        Optional<Rectangle> rectangle= rectangleRepo.findById(id);
        model.addAttribute("rectangles", rectangle.get());
        return "redirect:/rectangles/rectangle";
    }
    
    @GetMapping("/rectangles/delete/{id}")
    public String deleteReactangle(@PathVariable int id){
        rectangleRepo.deleteById(id);
        return "redirect:/rectangles/view";
    }
    
}
