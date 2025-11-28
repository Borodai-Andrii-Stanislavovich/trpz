package org.example;

import java.util.ArrayList;
import java.util.List;

class CompositeNode extends Node {
    private List<Node> children;

    public CompositeNode(Long id, String name, String text) {
        super(id, name, text);
        this.children = new ArrayList<>();
    }

    @Override
    public NodeDTO toDTO() {
        NodeDTO dto = new NodeDTO(id, name, text);
        dto.setCategory(category);
        dto.setUrgency(urgency);
        dto.setXPosition(xPosition);
        dto.setYPosition(yPosition);
        dto.setNodeType("COMPOSITE");

        for (Node child : children) {
            dto.addChild(child.toDTO());
        }

        return dto;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public void addChild(Node child) {
        children.add(child);
    }

    @Override
    public void removeChild(Node child) {
        children.remove(child);
    }

    public void addChildren(List<Node> children) {
        this.children.addAll(children);
    }

    public void removeChildById(Long childId) {
        children.removeIf(child -> child.getId().equals(childId));
    }

    @Override
    public Node findNodeById(Long searchId) {
        if (this.id.equals(searchId)) {
            return this;
        }

        for (Node child : children) {
            Node found = child.findNodeById(searchId);
            if (found != null) {
                return found;
            }
        }

        return null;
    }

    public List<Node> getAllLeaves() {
        List<Node> leaves = new ArrayList<>();
        for (Node child : children) {
            if (child.isLeaf()) {
                leaves.add(child);
            } else {
                leaves.addAll(((CompositeNode) child).getAllLeaves());
            }
        }
        return leaves;
    }

    public List<Node> getAllNodes() {
        List<Node> allNodes = new ArrayList<>();
        allNodes.add(this);
        for (Node child : children) {
            if (child.isLeaf()) {
                allNodes.add(child);
            } else {
                allNodes.addAll(((CompositeNode) child).getAllNodes());
            }
        }
        return allNodes;
    }
}