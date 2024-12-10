package mainpkg.project.Rayhan;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String id, name, password, email, phone;

    public User(String name, String password, String email, String pN, String type) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = pN;
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

    public String getphone() {
        return phone;
    }

    public void setphone(String pN) {
        this.phone = pN;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", pN='" + phone + '\'' +
                '}';
    }

    public String generateID(String type) {
        String id = "" ;

        if (type == "Student") {
            id += this.name.substring(0, 3);
            id += this.email.substring(0, 3);
            id += this.phone.substring(this.getphone().length());
        }

        else if (type == "Faculty") {
            id += this.phone.substring(0, 2);
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
