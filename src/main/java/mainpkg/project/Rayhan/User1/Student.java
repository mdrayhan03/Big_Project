package mainpkg.project.Rayhan.User1;

import mainpkg.project.Rayhan.User;

public class Student extends User {
    private String dept ;
    private Float cgpa ;
    public Student(String name, String password, String email, String pN, String type, String dept) {
        super(name, password, email, pN, type);
        this.dept = dept ;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "dept='" + dept + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
