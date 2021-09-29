package de.dhbwka.java.exercise.classes.periodic;

import java.util.ArrayList;
import java.util.List;

public class PeriodicTable {

    List<Element> elements = new ArrayList<>();

    public void addElement(final Element element) {
        elements.add(element);
    }

    public boolean hasElement(final int ordinal) {
        boolean found = false;
        for (final Element element : elements) {
            if (element.getOrdinal() == ordinal) {
                found = true;
            }
        }
        return found;
    }

    // could lead to NPE
    public Element getElement(final int ordinal) {
        for (final Element element : elements) {
            if (element.getOrdinal() == ordinal) {
                return element;
            }
        }
        return null;
    }

    public List<Element> getMetals() {
        final List<Element> metals = new ArrayList<>();
        for (final Element element : elements) {
            if (element instanceof Metal) {
                metals.add(element);
            }
        }
        return metals;
    }

    public static void main(final String[] args) {
        final PeriodicTable pt = new PeriodicTable();
        pt.addElement(new Element("Bla", "test", 10, 'K', new Phase().createLiquid(), false));
        pt.addElement(new Metal("Eisen", "FE", 26, 'N', new Phase().createSolid(), false, false, 1.002E7));
        System.out.println(pt.getElement(10));
        System.out.println(pt.getElement(26));
    }
}
