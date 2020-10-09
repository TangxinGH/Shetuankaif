package entity;


public class User {
 public User(){
     super();
//     无参构造方法。根据usermapper.xml的配置 ，反射构造出 实例化
 }
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
