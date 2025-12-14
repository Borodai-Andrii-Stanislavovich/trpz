package org.example.mindmapservice.repository;

import org.example.mindmapservice.entity.MindMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MindMapRepository extends JpaRepository<MindMap, Long> {
}
