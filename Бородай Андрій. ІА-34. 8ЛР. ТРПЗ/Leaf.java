package org.example;

import java.util.Collections;
import java.util.List;

class Leaf extends Node {

    public Leaf(Long id, String name, String text) {
        super(id, name, text);
    }

    @Override
    public NodeDTO toDTO() {
        NodeDTO dto = new NodeDTO(id, name, text);
        dto.setCategory(category);
        dto.setUrgency(urgency);
        dto.setXPosition(xPosition);
        dto.setYPosition(yPosition);
        dto.setNodeType("LEAF");
        return dto;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public List<Node> getChildren() {
        return Collections.emptyList();
    }
}