package org.example.mindmapservice.service;

import org.example.mindmapservice.entity.MindMap;
import org.example.mindmapservice.repository.MindMapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MindMapService {

    private final MindMapRepository repository;

    public MindMapService(MindMapRepository repository) {
        this.repository = repository;
    }

    public MindMap create(MindMap map) {
        return repository.save(map);
    }

    public List<MindMap> findAll() {
        return repository.findAll();
    }

    public MindMap findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
