package org.example.mindmapservice.controller;

import org.example.mindmapservice.entity.Edge;
import org.example.mindmapservice.service.EdgeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edges")
public class EdgeController {

    private final EdgeService service;

    public EdgeController(EdgeService service) {
        this.service = service;
    }

    @PostMapping
    public Edge create(@RequestBody Edge edge) {
        return service.create(edge);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
