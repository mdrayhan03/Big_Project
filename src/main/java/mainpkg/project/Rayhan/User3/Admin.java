package mainpkg.project.Rayhan.User3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.project.AppendableObjectOutputStream;
import mainpkg.project.Rayhan.User;
import mainpkg.project.Rayhan.User2.Course;
import mainpkg.project.Rayhan.User2.Faculty;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;

public class Admin extends User {
    public Admin(String name, String password, String email, String pN, String type) {
        super(name, password, email, pN, type);
    }

    public void addFaculty(String name, String password, String email, String pN, String type, String department, String gender, LocalDate dob, LocalDate doj) {
        Faculty faculty = new Faculty(name, password, email, pN, type, department, gender, dob, doj) ;
        this.facultyFileWrite(faculty);
    }

    public void facultyFileWrite(Faculty faculty) {
        System.out.println(faculty);
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("FacultyData.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(faculty);

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public ObservableList<Faculty> facultyFileRead() {
        ObservableList<Faculty> faculties = FXCollections.observableArrayList() ;

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("FacultyData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Faculty st ;
            try {
                while(true){
                    st = (Faculty) ois.readObject();
                    System.out.println((st));
                    faculties.add(st) ;
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }

        return faculties ;
    }

    public void addCourseAccept(Course course, int room) {
        course.setRoom(room);
        course.setStatus("accepted");
        courseFileUpdate(course);
    }

    public void addCourseReject(Course course) {
        course.setStatus("rejected");
        courseFileUpdate(course);
    }

    public void courseFileWrite(Course course) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("CourseData.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(course);

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public ObservableList<Course> courseFileRead() {
        ObservableList<Course> courses = FXCollections.observableArrayList() ;

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("CourseData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Course st ;
            try {
                while(true){
                    st = (Course) ois.readObject();
                    System.out.println((st));
                    courses.add(st) ;
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }

        return courses ;
    }

    public void courseFileUpdate(Course course) {
        ObservableList<Course> courses = courseFileRead() ;
        File f = new File("CourseData.bin") ;
        f.delete() ;

        for (Course c: courses) {
            if (Objects.equals(c.getCode(), course.getCode())) {
                courseFileWrite(course);
            }
            else {
                courseFileWrite(c);
            }
        }
    }

    public void courseFileDelete(Course course) {
        ObservableList<Course> courses = courseFileRead() ;
        File f = new File("CourseData.bin") ;
        f.delete() ;

        for (Course c: courses) {
            if (!Objects.equals(c.getCode(), course.getCode())) {
                courseFileWrite(c);
            }
        }
    }
}
