package org.example.mindmapservice.repository;

import org.example.mindmapservice.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Long> {
}
