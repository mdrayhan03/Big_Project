package mainpkg.project.Rayhan.User2;

import java.io.Serializable;

public class Course implements Serializable {
    String code, title, day, time, status;
    int credit, room;

    public Course(String code, String title, String day, String time, int credit) {
        this.code = code;
        this.title = title;
        this.day = day;
        this.time = time;
        this.credit = credit;
        this.status = "pending";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", credit=" + credit +
                ", room=" + room +
                '}';
    }

}
