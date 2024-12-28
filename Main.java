import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();
        Scanner studentScanner = new Scanner(new File("C:\\Users\\Zhanuka\\IdeaProjects\\Person1\\src\\students.txt"));
        while (studentScanner.hasNextLine()) {
            String[] data = studentScanner.nextLine().split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("Male");
            Student student = new Student(name, surname, age, gender);
            for (int i = 4; i < data.length; i++) {
                student.addGrade(Integer.parseInt(data[i]));
            }
            school.addMember(student);
        }
        System.out.println();

        Scanner teacherScanner = new Scanner(new File("C:\\Users\\Zhanuka\\IdeaProjects\\Person1\\src\\teachers.txt"));
        while (teacherScanner.hasNextLine()) {
            String[] data = teacherScanner.nextLine().split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("Male");
            String subject = data[4];
            int yearsOfExperience = Integer.parseInt(data[5]);
            int salary = Integer.parseInt(data[6]);
            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

            if (teacher.getYearsOfExperience() > 10) {
                teacher.giveRaise(10);
            }

            school.addMember(teacher);
        }
        System.out.println(school);
    }
}