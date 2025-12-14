package org.example.mindmapservice.service;

import org.example.mindmapservice.entity.Node;
import org.example.mindmapservice.repository.NodeRepository;
import org.springframework.stereotype.Service;

@Service
public class NodeService {

    private final NodeRepository repository;

    public NodeService(NodeRepository repository) {
        this.repository = repository;
    }

    public Node create(Node node) {
        return repository.save(node);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
