package com.example.assignment2.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RectangleRepository extends JpaRepository<Rectangle, Integer> {
     List<Rectangle> findByName(String name);
     List<Rectangle> findByColor(String color);
     List<Rectangle> findByWidthandHeight(int width, int height);
}
