package entity;


public class User {
 public User(){
     super();
//     无参构造方法。根据usermapper.xml的配置 ，反射构造出 实例化
 }
    private Integer Sno;
    private String Sname;
    private String SCollege;
    private String Password;
    private String Sex;
    private String Age;
    private String Headportrait;

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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getHeadportrait() {
        return Headportrait;
    }

    public void setHeadportrait(String headportrait) {
        Headportrait = headportrait;
    }

    @Override
    public String toString() {
        return "User{" +
                "Sno=" + Sno +
                ", Sname='" + Sname + '\'' +
                ", SCollege='" + SCollege + '\'' +
                ", Password='" + Password + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Age='" + Age + '\'' +
                ", Headportrait='" + Headportrait + '\'' +
                '}';
    }
}
