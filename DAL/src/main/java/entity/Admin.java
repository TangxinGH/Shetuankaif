package entity;

public class Admin {
    private Integer adNo;
    private String adName;
    private String adCollege;
    private String adPassword;
    private String adSex;
    private String adPortrait;
    private String adAge;

    public Integer getAdNo() {
        return adNo;
    }

    public void setAdNo(Integer adNo) {
        this.adNo = adNo;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdCollege() {
        return adCollege;
    }

    public void setAdCollege(String adCollege) {
        this.adCollege = adCollege;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }

    public String getAdSex() {
        return adSex;
    }

    public void setAdSex(String adSex) {
        this.adSex = adSex;
    }

    public String getAdPortrait() {
        return adPortrait;
    }

    public void setAdPortrait(String adPortrait) {
        this.adPortrait = adPortrait;
    }

    public String getAdAge() {
        return adAge;
    }

    public void setAdAge(String adAge) {
        this.adAge = adAge;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adNo=" + adNo +
                ", adName='" + adName + '\'' +
                ", adCollege='" + adCollege + '\'' +
                ", adPassword='" + adPassword + '\'' +
                ", adSex='" + adSex + '\'' +
                ", adPortrait='" + adPortrait + '\'' +
                ", adAge='" + adAge + '\'' +
                '}';
    }
}
