package strimApiPopulationCensus;

public class Person {
    private final String name;
    private final String family;
    private final Integer age;
    private final Sex sex;
    private final Education education;

    protected Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    protected String getName() {
        return name;
    }

    protected String getFamily() {
        return family;
    }

    protected Integer getAge() {
        return age;
    }

    protected Sex getSex() {
        return sex;
    }

    protected Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}
