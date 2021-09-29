package de.dhbwka.java.exercise.collections;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    private T value;
    private BinaryTree<T> left = null;
    private BinaryTree<T> right = null;

    public BinaryTree() {
    }

    public void add(T newValue) {
        if (value != null) {
            int compare = newValue.compareTo(value);
            switch (compare) {
                case -1:
                    if (left == null) {
                        left = new BinaryTree<>();
                    }
                    left.add(newValue);
                    break;
                case 0:
                    break;
                case 1:
                    if (right == null) {
                        right = new BinaryTree<>();
                    }
                    right.add(newValue);
                    break;
                default:
                    break;
            }
        } else {
            value = newValue;
        }
    }

    public T getValue() {
        return value;
    }

    public List<T> traverse() {
        List<T> list = new ArrayList<>();

        if (left != null && right != null) {
            list = left.traverse();
            list.add(value);
            list.addAll(right.traverse());
            return list;
        } else if (left != null) {
            list = left.traverse();
            list.add(value);
            return list;
        } else if (right != null) {
            list.add(value);
            list.addAll(right.traverse());
            return list;

        } else {
            list.add(value);
            return list;
        }
    }
}