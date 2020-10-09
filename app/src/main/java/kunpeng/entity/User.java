package kunpeng.entity;

import java.util.Date;

public class User {
 
    private Integer Sno;
    private String Sname;
    private String SCollege;

    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSCollege() {
        return SCollege;
    }

    public void setSCollege(String SCollege) {
        this.SCollege = SCollege;
    }

    @Override
    public String toString() {
        return "User{" +
                "Sno=" + Sno +
                ", Sname='" + Sname + '\'' +
                ", SCollege='" + SCollege + '\'' +
                '}';
    }
}
