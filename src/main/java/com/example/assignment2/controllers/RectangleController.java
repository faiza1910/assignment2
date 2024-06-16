package com.example.assignment2.controllers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    // @GetMapping("rectangles/{name}")
    // public String getRectangleByName(@PathVariable String name, Model model){
    //     List<Rectangle> rectangles = rectangleRepo.findByName(name);
    //     model.addAttribute("rectangles", rectangles);
    //     return "rectangles/rectangle";
    // }
    
    @GetMapping("/rectangles/{id}")
    public String getRectangleById(@PathVariable int id, Model model){
        Rectangle rectangle = rectangleRepo.findById(id).orElse(null);
        model.addAttribute("rectangle", rectangle);
        return "rectangles/rectangle";
    }

    

    // @PostMapping("/rectangles/edit/{id}")
    // public String editRectangle(@PathVariable int id, @RequestParam Map<String, String> editRectangle){
    //     try {
    //         Rectangle rectangle = rectangleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rectangle Id: " + id));
    //         rectangle.setName(editRectangle.get("name"));
    //         rectangle.setWidth(Integer.parseInt(editRectangle.get("width")));
    //         rectangle.setHeight(Integer.parseInt(editRectangle.get("height")));
    //         rectangle.setColor(editRectangle.get("color"));
    //         rectangleRepo.save(rectangle);
    //         return "redirect:/rectangles/view";
    //     } catch (Exception e) {
    //         // Log the exception or handle it appropriately
    //         e.printStackTrace();
    //         return "error-page"; // Redirect to an error page or handle the error in UI
    //     }
    // }

    @PostMapping("/rectangles/edit")
    public String editRec(@ModelAttribute Rectangle edittedRectangle){
        Rectangle oldRec = rectangleRepo.findById(edittedRectangle.getId()).orElse(null);
        if(oldRec!=null){
            oldRec.setName(edittedRectangle.getName());
            oldRec.setWidth(edittedRectangle.getWidth());
            oldRec.setHeight(edittedRectangle.getHeight());
            oldRec.setName(edittedRectangle.getName());
            rectangleRepo.save(oldRec);
        }
        return "redirect:/rectangles/view";
    }

    
    @GetMapping("/rectangles/delete/{id}")
    public String deleteReactangle(@PathVariable int id){
        rectangleRepo.deleteById(id);
        return "redirect:/rectangles/view";
    }
    
}
