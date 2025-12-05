package lab4;

//Класс Студент, который реализует интерфейс Comparable<Student>
public class Student implements Comparable<Student> {
    private String name;
    private int grade;
    private int age;

    public Student(String name, int grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    //Реализуем метод compare() из интерфейса Comparable
    @Override
    public int compare(Student other) {
        //Сравниваем оценки: чем выше оценка, тем "больше" студент
        return this.grade - other.grade;
    }

    //сравнение по возрасту
    public int compareByAge(Student other) {
        return this.age - other.age;
    }

    //сравнение по имени
    public int compareByName(Student other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (оценка: " + grade + ", возраст: " + age + ")";
    }
}