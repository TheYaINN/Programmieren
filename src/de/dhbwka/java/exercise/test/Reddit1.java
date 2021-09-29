package de.dhbwka.java.exercise.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reddit1 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        words.add("apple");
        words.add("boy");
        words.add("cat");
        words.add("dog");
        words.add("elephant");
        words.add("enormous");

        System.out.println(bucketGetter(words));
    }

    public static List<String> bucketGetter(List<String> words) {
        List<String> bucketList = new ArrayList<>(26);

        for (String str : words) {
            Arrays.stream(str.split("")).forEach(c -> bucketList.set(Character.getNumericValue(c.toCharArray()[0]), c));
        }
        return bucketList;
    }
}
