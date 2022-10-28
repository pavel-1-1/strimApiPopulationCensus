package strimApiPopulationCensus;

import java.util.*;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(names.get(new Random().nextInt(names.size())), families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100), Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }

        Stream<Person> myStream = persons.stream();
        long under18YearsOld = myStream.filter(n -> n.getAge() < 18).count();
        System.out.println(under18YearsOld);

        myStream = persons.stream();
        List<String> conscripts = myStream.filter(n -> n.getSex() == Sex.MAN).filter(n -> n.getAge() >= 18 & n.getAge() <= 27).
                map(n -> n.getFamily() + " " + n.getAge()).toList();
        System.out.println(conscripts);

        myStream = persons.stream();
        List<String> ableBodiedPeople = myStream.filter(n -> n.getEducation() == Education.HIGHER).
                filter(n -> !(n.getSex() == Sex.WOMAN & n.getAge() < 18)).filter(n -> !(n.getSex() == Sex.WOMAN & n.getAge() > 60)).
                filter(n -> !(n.getSex() == Sex.MAN & n.getAge() < 18)).filter(n -> !(n.getSex() == Sex.MAN & n.getAge() > 65)).
                sorted(Comparator.comparing(Person::getFamily)).map(Person::getFamily).toList();
        System.out.printf("%s %s\n", ableBodiedPeople, ableBodiedPeople.size());

    }
}
