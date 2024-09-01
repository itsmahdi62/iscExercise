import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
//        System.out.println(students);

        System.out.println("****************************************");
        System.out.println("loop via iterator and toString");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
//            System.out.println(student.toString());
        }


        students.sort((o1, o2) -> (int)(o1.getGrade()-o2.getGrade()));
        System.out.println(students);
    }
}