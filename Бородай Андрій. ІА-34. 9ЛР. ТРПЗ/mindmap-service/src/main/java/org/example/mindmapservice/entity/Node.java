package org.example.mindmapservice.entity;

import jakarta.persistence.*;

@Entity
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    @ManyToOne
    @JoinColumn(name = "mindmap_id")
    private MindMap mindMap;

    public Long getId() { return id; }
    public String getLabel() { return label; }
    public MindMap getMindMap() { return mindMap; }

    public void setId(Long id) { this.id = id; }
    public void setLabel(String label) { this.label = label; }
    public void setMindMap(MindMap mindMap) { this.mindMap = mindMap; }
}
