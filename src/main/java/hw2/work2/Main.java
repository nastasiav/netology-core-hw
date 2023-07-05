package hw2.work2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Collection<Person> persons = getCollectionPersons();

        long minorsCount = persons.stream()
                .filter(el -> el.getAge() < 18)
                .count();

        System.out.println(minorsCount);

        List<String> militaryPersons = persons.stream()
                .filter(el -> el.getSex().equals(Sex.MAN))
                .filter(el -> el.getAge() >= 18 && el.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());

//        System.out.println(militaryPersons);

        List<Person> workersWithEdu = persons.stream()
                .filter(el -> el.getEducation().equals(Education.HIGHER))
                .filter(el -> (el.getSex().equals(Sex.WOMAN) && el.getAge() >= 18 && el.getAge() <= 60)
                        || (el.getSex().equals(Sex.MAN) && el.getAge() >= 18 && el.getAge() <= 65))
                .sorted(Comparator.comparing(Person::getFamily).thenComparing(Person::getName))
                .collect(Collectors.toList());

//        System.out.println(workersWithEdu);
    }

    private static Collection<Person> getCollectionPersons() {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        return persons;
    }
}