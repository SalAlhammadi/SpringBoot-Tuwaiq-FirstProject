package project1.Services;

import org.springframework.stereotype.Service;
import project1.Model.Student;
import java.util.ArrayList;


@Service
public class StuService {

    private final ArrayList<Student> studentDB = new ArrayList<>();

    public void add(Student stu) {
        studentDB.add(stu);
    }

    public ArrayList<Student> getAll() {
        return studentDB;
    }

    public boolean isStu(int stuID) {
        for (Student student : studentDB)
            if (student.getID() == stuID)
                return true;

        return false;
    }

    public Student getStu(int stuID) {
        for (Student student : studentDB)
            if (student.getID() == stuID)
                return student;

        return null;
    }

    public Student getStuByName(String stuName) {
        for (Student student : studentDB)
            if (student.getName().equalsIgnoreCase(stuName))
                return student;

        return null;
    }
    public String updateStu(Student stu) {
        for (int i = 0; i < studentDB.size(); i++) {
            if (studentDB.get(i).getID().equals(stu.getID()))
                studentDB.set(i, stu);
        }

        return "Student updated successfully";
    }

    public String delStu(int stuID) {
        for (int i = 0; i < studentDB.size(); i++) {
            if (studentDB.get(i).getID().equals(stuID))
                studentDB.remove(i);
        }
        return "Student deleted successfully";
    }


    public ArrayList<Student> getStuMajoredIn(String stuMajor) {
        ArrayList<Student> stuResults = new ArrayList<>();
        for (Student student : studentDB) {
            if (student.getMajor().equalsIgnoreCase(stuMajor))
                stuResults.add(student);
        }

        return  stuResults;
    }

    public boolean isMajor(String stuMajor) {
        return stuMajor.equalsIgnoreCase("CS")
                || stuMajor.equalsIgnoreCase("Math")
                || stuMajor.equalsIgnoreCase("Engineering")
                || stuMajor.equalsIgnoreCase("Engineer");
    }

    public ArrayList<Student> getStuOver(int age) {
        ArrayList<Student> stuResults = new ArrayList<>();
        for (Student student : studentDB) {
            if (student.getAge() >= age)
                stuResults.add(student);
        }
        return  stuResults;
    }

}
