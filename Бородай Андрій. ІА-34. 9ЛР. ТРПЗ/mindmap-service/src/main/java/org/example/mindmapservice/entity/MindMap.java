package org.example.mindmapservice.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class MindMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "mindMap", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Node> nodes;

    @OneToMany(mappedBy = "mindMap", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edge> edges;

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public List<Node> getNodes() { return nodes; }
    public List<Edge> getEdges() { return edges; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setNodes(List<Node> nodes) { this.nodes = nodes; }
    public void setEdges(List<Edge> edges) { this.edges = edges; }
}
