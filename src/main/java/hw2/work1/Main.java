package hw2.work1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = new IntList().getIntList();
        List<Integer> results = new ArrayList<>();

        for (int el : intList) {
            if (el > 0 && (el % 2 == 0)) {
                results.add(el);
            }
        }

        Collections.sort(results);

        for (int el : results) {
            System.out.println(el);
        }
    }
}