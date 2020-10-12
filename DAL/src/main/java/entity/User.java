package entity;


public class User {

    private Integer sno;
    private String sname;
    private String sCollege;
    private String password;
    private String sex;
    private String age;
    private String headportrait;

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getsCollege() {
        return sCollege;
    }

    public void setsCollege(String sCollege) {
        this.sCollege = sCollege;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    @Override
    public String toString() {
        return "User{" +
                "Sno=" + sno +
                ", Sname='" + sname + '\'' +
                ", SCollege='" + sCollege + '\'' +
                ", Password='" + password + '\'' +
                ", Sex='" + sex + '\'' +
                ", Age='" + age + '\'' +
                ", Headportrait='" + headportrait + '\'' +
                '}';
    }
}
