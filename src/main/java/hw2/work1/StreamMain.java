package hw2.work1;

import java.util.Comparator;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> intList = new IntList().getIntList();

        intList.stream()
                .filter(el -> (el > 0) && (el % 2 == 0))
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}
