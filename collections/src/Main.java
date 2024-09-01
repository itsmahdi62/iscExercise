import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Student Almasi = new Student().setName("Mahdi").setFamily("Almasi").setAge(23).setGrade(18);
        Student Bahrami = new Student().setName("Hossein").setFamily("Bahrami").setAge(17).setGrade(20);
        Student Najd = new Student().setName("Saeed").setFamily("Najd").setAge(16).setGrade(5);
        Student Majidi = new Student().setName("Majid").setFamily("Majidi").setAge(15).setGrade(9);
        Student Hosseini = new Student().setName("Hossein").setFamily("Hosseini").setAge(22).setGrade(8);
        Student Amini = new Student().setName("Amin").setFamily("Amini").setAge(21).setGrade(19);
        List<Student> students = new ArrayList<>();
        students.add(Almasi);
        students.add(Bahrami);
        students.add(Najd);
        students.add(Majidi);
        students.add(Hosseini);
        students.add(Amini);

        System.out.println("Simple print");
//        students.forEach(y -> System.out.println(y));

        System.out.println("****************************************");
        System.out.println("loop via iterator and toString");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
//            System.out.println(student.toString());
        }

        System.out.println("****************************************");
        System.out.println("sort by grade : ");
        students.sort((o1, o2) -> (int)(o1.getGrade()-o2.getGrade()));
//        System.out.println(students);
//        students.forEach(y -> System.out.println(y));

        System.out.println("****************************************");
        System.out.println("collecting Age : ");
        Map<Integer , List<Student>> collectAge = students.stream().collect(Collectors.groupingBy(Student::getAge));
//        System.out.println(collectAge);

        System.out.println("****************************************");
        System.out.println("group by grades : ");
        System.out.println("students who has pass the exam  : ");
        Map<Boolean, List<Student>> groupedByGrade = students.stream()
                .collect(Collectors.partitioningBy(student -> student.getGrade() >= 10));
        groupedByGrade.get(true).forEach(y -> System.out.println(y));
        System.out.println("Students who has been failed : ");
        groupedByGrade.get(false).forEach(y-> System.out.println(y));

        Map<Boolean , List<Student>> groupByAge = students.stream()
                .collect(Collectors.groupingBy(y -> y.getAge() >= 18));
        System.out.println("****************************************");
        System.out.println("group by ages : ");
        System.out.println("students at college (age>18) : ");
        groupByAge.get(true).forEach(y-> System.out.println(y));
        System.out.println("students at school (age<18) : ");
        groupByAge.get(false).forEach(y-> System.out.println(y));


        System.out.println("****************************************");
        double averageGrade = students
                .stream()
                .mapToDouble(y -> y.getGrade())
                .average()
                .getAsDouble();
        System.out.println("Average Grade : " + averageGrade);

        System.out.println("****************************************");
        double collegeAverageGrade = groupByAge.get(true)
                .stream()
                .mapToDouble(y -> y.getGrade())
                .average()
                .getAsDouble();
        System.out.println("Average Grade of students of college : " + collegeAverageGrade);
    }
}