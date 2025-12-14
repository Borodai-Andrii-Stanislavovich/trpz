package org.example.mindmapservice.entity;

import jakarta.persistence.*;

@Entity
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromNodeId;
    private Long toNodeId;

    @ManyToOne
    @JoinColumn(name = "mindmap_id")
    private MindMap mindMap;

    public Long getId() { return id; }
    public Long getFromNodeId() { return fromNodeId; }
    public Long getToNodeId() { return toNodeId; }
    public MindMap getMindMap() { return mindMap; }

    public void setId(Long id) { this.id = id; }
    public void setFromNodeId(Long fromNodeId) { this.fromNodeId = fromNodeId; }
    public void setToNodeId(Long toNodeId) { this.toNodeId = toNodeId; }
    public void setMindMap(MindMap mindMap) { this.mindMap = mindMap; }
}
