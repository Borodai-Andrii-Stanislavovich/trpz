package org.example.mindmapservice.service;

import org.example.mindmapservice.entity.Edge;
import org.example.mindmapservice.repository.EdgeRepository;
import org.springframework.stereotype.Service;

@Service
public class EdgeService {

    private final EdgeRepository repository;

    public EdgeService(EdgeRepository repository) {
        this.repository = repository;
    }

    public Edge create(Edge edge) {
        return repository.save(edge);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
