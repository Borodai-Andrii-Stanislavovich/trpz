package org.example;

import java.time.LocalDate;

class NodeFactory {
    private long nextId = 1;

    public EndNode createLeaf(String name, String text) {
        return new EndNode(nextId++, name, text);
    }

    public CompositeNode createComposite(String name, String text) {
        return new CompositeNode(nextId++, name, text);
    }

    public EndNode createLeafWithCategory(String name, String text, String category) {
        EndNode leaf = createLeaf(name, text);
        leaf.setCategory(category);
        return leaf;
    }

    public CompositeNode createCompositeWithCategory(String name, String text, String category) {
        CompositeNode composite = createComposite(name, text);
        composite.setCategory(category);
        return composite;
    }

    public EndNode createLeafWithPosition(String name, String text, Integer x, Integer y) {
        EndNode leaf = createLeaf(name, text);
        leaf.setXPosition(x);
        leaf.setYPosition(y);
        return leaf;
    }

    public CompositeNode createCompositeWithPosition(String name, String text, Integer x, Integer y) {
        CompositeNode composite = createComposite(name, text);
        composite.setXPosition(x);
        composite.setYPosition(y);
        return composite;
    }

    public EndNode createUrgentLeaf(String name, String text, LocalDate urgency) {
        EndNode leaf = createLeaf(name, text);
        leaf.setUrgency(urgency);
        return leaf;
    }

    public CompositeNode createUrgentComposite(String name, String text, LocalDate urgency) {
        CompositeNode composite = createComposite(name, text);
        composite.setUrgency(urgency);
        return composite;
    }
}
