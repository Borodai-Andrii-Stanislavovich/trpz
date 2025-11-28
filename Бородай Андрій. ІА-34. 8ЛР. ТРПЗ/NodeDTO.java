package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class NodeDTO {
    private Long id;
    private String name;
    private String text;
    private String category;
    private LocalDate urgency;
    private Integer xPosition;
    private Integer yPosition;
    private String nodeType;
    private List<NodeDTO> children;

    public NodeDTO(Long id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.children = new ArrayList<>();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getText() { return text; }
    public String getCategory() { return category; }
    public LocalDate getUrgency() { return urgency; }
    public Integer getXPosition() { return xPosition; }
    public Integer getYPosition() { return yPosition; }
    public String getNodeType() { return nodeType; }
    public List<NodeDTO> getChildren() { return children; }

    public void setCategory(String category) { this.category = category; }
    public void setUrgency(LocalDate urgency) { this.urgency = urgency; }
    public void setXPosition(Integer xPosition) { this.xPosition = xPosition; }
    public void setYPosition(Integer yPosition) { this.yPosition = yPosition; }
    public void setNodeType(String nodeType) { this.nodeType = nodeType; }

    public void addChild(NodeDTO child) {
        this.children.add(child);
    }

    public void addChildren(List<NodeDTO> children) {
        this.children.addAll(children);
    }
}
