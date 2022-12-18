package project1.Services;

import org.springframework.stereotype.Service;
import project1.Model.Teacher;
import java.util.ArrayList;
@Service
public class TeaService {

    private final ArrayList<Teacher> TeacherDB = new ArrayList<>();

    public void add(Teacher Tea) {
        TeacherDB.add(Tea);
    }

    public ArrayList<Teacher> getAll() {
        return TeacherDB;
    }

    public boolean isTea(int TeaID) {
        for (Teacher teacher : TeacherDB)
            if (teacher.getID() == TeaID)
                return true;

        return false;
    }

    public Teacher getTea(int TeaID) {
        for (Teacher teacher : TeacherDB)
            if (teacher.getID() == TeaID)
                return teacher;

        return null;
    }

    public String updateTea(Teacher Tea) {
        for (int i = 0; i < TeacherDB.size(); i++) {
            if (TeacherDB.get(i).getID().equals(Tea.getID()))
                TeacherDB.set(i, Tea);
        }

        return "Teacher updated successfully";
    }

    public String delTea(int TeaID) {
        for (int i = 0; i < TeacherDB.size(); i++) {
            if (TeacherDB.get(i).getID().equals(TeaID))
                TeacherDB.remove(i);
        }
        return "Teacher deleted Successfully";
    }

    public ArrayList<Teacher> getTeaOver(double salary) {
        ArrayList<Teacher> stuResults = new ArrayList<>();
        for (Teacher teacher : TeacherDB) {
            if (teacher.getSalary() >= salary)
                stuResults.add(teacher);
        }
        return  stuResults;
    }


}
