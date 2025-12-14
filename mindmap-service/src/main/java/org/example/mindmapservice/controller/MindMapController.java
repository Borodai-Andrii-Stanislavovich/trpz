package org.example.mindmapservice.controller;

import org.example.mindmapservice.entity.MindMap;
import org.example.mindmapservice.service.MindMapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mindmaps")
public class MindMapController {

    private final MindMapService service;

    public MindMapController(MindMapService service) {
        this.service = service;
    }

    @PostMapping
    public MindMap create(@RequestBody MindMap map) {
        return service.create(map);
    }

    @GetMapping
    public List<MindMap> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MindMap one(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
