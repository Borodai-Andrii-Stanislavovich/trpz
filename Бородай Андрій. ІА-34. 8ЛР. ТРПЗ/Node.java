package org.example;

import java.time.LocalDate;
import java.util.*;

abstract class Node {
    protected Long id;
    protected String name;
    protected String text;
    protected String category;
    protected LocalDate urgency;
    protected Integer xPosition;
    protected Integer yPosition;

    public Node(Long id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getText() { return text; }
    public String getCategory() { return category; }
    public LocalDate getUrgency() { return urgency; }
    public Integer getXPosition() { return xPosition; }
    public Integer getYPosition() { return yPosition; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setText(String text) { this.text = text; }
    public void setCategory(String category) { this.category = category; }
    public void setUrgency(LocalDate urgency) { this.urgency = urgency; }
    public void setXPosition(Integer xPosition) { this.xPosition = xPosition; }
    public void setYPosition(Integer yPosition) { this.yPosition = yPosition; }

    public abstract NodeDTO toDTO();
    public abstract boolean isLeaf();
    public abstract List<Node> getChildren();

    public void addChild(Node child) {
        throw new UnsupportedOperationException("Cannot add child to leaf node");
    }

    public void removeChild(Node child) {
        throw new UnsupportedOperationException("Cannot remove child from leaf node");
    }

    public Node findNodeById(Long searchId) {
        if (this.id.equals(searchId)) {
            return this;
        }
        return null;
    }
}