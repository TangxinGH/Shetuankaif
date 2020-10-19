package entity;

public class Admin {
    private Integer adId;
    private String adNo;
    private String adName;
    private String adCollege;
    private String adPassword;
    private String adSex;
    private String adPortrait;
    private Integer adAge;
    private String adAuthority;


    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAdNo() {
        return adNo;
    }

    public void setAdNo(String adNo) {
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

    public Integer getAdAge() {
        return adAge;
    }

    public void setAdAge(Integer adAge) {
        this.adAge = adAge;
    }

    public String getAdAuthority() {
        return adAuthority;
    }

    public void setAdAuthority(String adAuthority) {
        this.adAuthority = adAuthority;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adId=" + adId +
                ", adNo='" + adNo + '\'' +
                ", adName='" + adName + '\'' +
                ", adCollege='" + adCollege + '\'' +
                ", adPassword='" + adPassword + '\'' +
                ", adSex='" + adSex + '\'' +
                ", adPortrait='" + adPortrait + '\'' +
                ", adAge=" + adAge +
                ", adAuthority='" + adAuthority + '\'' +
                '}';
    }
}
