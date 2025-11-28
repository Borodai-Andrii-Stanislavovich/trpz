package org.example;

import java.time.LocalDate;

class NodeFactory {
    private long nextId = 1;

    public Leaf createLeaf(String name, String text) {
        return new Leaf(nextId++, name, text);
    }

    public Composite createComposite(String name, String text) {
        return new Composite(nextId++, name, text);
    }

    public Leaf createLeafWithCategory(String name, String text, String category) {
        Leaf leaf = createLeaf(name, text);
        leaf.setCategory(category);
        return leaf;
    }

    public Composite createCompositeWithCategory(String name, String text, String category) {
        Composite composite = createComposite(name, text);
        composite.setCategory(category);
        return composite;
    }

    public Leaf createLeafWithPosition(String name, String text, Integer x, Integer y) {
        Leaf leaf = createLeaf(name, text);
        leaf.setXPosition(x);
        leaf.setYPosition(y);
        return leaf;
    }

    public Composite createCompositeWithPosition(String name, String text, Integer x, Integer y) {
        Composite composite = createComposite(name, text);
        composite.setXPosition(x);
        composite.setYPosition(y);
        return composite;
    }

    public Leaf createUrgentLeaf(String name, String text, LocalDate urgency) {
        Leaf leaf = createLeaf(name, text);
        leaf.setUrgency(urgency);
        return leaf;
    }

    public Composite createUrgentComposite(String name, String text, LocalDate urgency) {
        Composite composite = createComposite(name, text);
        composite.setUrgency(urgency);
        return composite;
    }
}
