package org.example.mindmapservice.controller;

import org.example.mindmapservice.entity.Node;
import org.example.mindmapservice.service.NodeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nodes")
public class NodeController {

    private final NodeService service;

    public NodeController(NodeService service) {
        this.service = service;
    }

    @PostMapping
    public Node create(@RequestBody Node node) {
        return service.create(node);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
