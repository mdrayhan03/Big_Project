package mainpkg.project.Rayhan;

import java.util.Objects;

public class User {
    private String id, name, password, email, pN;

    public User(String name, String password, String email, String pN, String type) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.pN = pN;
        this.id = this.generateID(type) ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpN() {
        return pN;
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", pN='" + pN + '\'' +
                '}';
    }

    public String generateID(String type) {
        String id = "" ;

        if (type == "Student") {
            id += this.name.substring(0, 3);
            id += this.email.substring(0, 3);
            id += this.pN.substring(this.getpN().length());
        }

        else if (type == "Faculty") {
            id += this.pN.substring(0, 2);
            id += this.email.substring(0, 2);
        }

        else if (type == "admin") {
            id = "admin" ;
        }

        return id ;
    }

    public boolean loginVR(String id, String password) {
        System.out.println(Objects.equals(this.getId(), id) && Objects.equals(this.getPassword(), password));
        if(Objects.equals(this.getId(), id) && Objects.equals(this.getPassword(), password)) {
            return true ;
        }
        return false ;
    }
}
