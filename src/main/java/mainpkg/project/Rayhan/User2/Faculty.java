package mainpkg.project.Rayhan.User2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.project.AppendableObjectOutputStream;
import mainpkg.project.Rayhan.User;

import java.io.*;
import java.time.LocalDate;

public class Faculty extends User implements Serializable {
    private String department, gender ;
    private LocalDate dob, doj ;
    public Faculty(String name, String password, String email, String pN, String type, String department, String gender, LocalDate dob, LocalDate doj) {
        super(name, password, email, pN, type);
        this.department = department;
        this.gender = gender;
        this.dob = dob;
        this.doj = doj;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public void newCourse(String code, String title, int credit, String day, String time) {
        Course course = new Course(code, title, day, time, credit) ;
        courseFileWrite(course);
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
}
