package entity;

public class Admin {
    private Integer adId;
    private String adName;
    private String adCollege;
    private String adPassword;
    private String adSex;
    private String adPortrait;
    private String adAge;
    private String adAuthority;
    private String adNO;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
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

    public String getAdAuthority() {
        return adAuthority;
    }

    public void setAdAuthority(String adAuthority) {
        this.adAuthority = adAuthority;
    }

    public String getAdNO() {
        return adNO;
    }

    public void setAdNO(String adNO) {
        this.adNO = adNO;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adId=" + adId +
                ", adName='" + adName + '\'' +
                ", adCollege='" + adCollege + '\'' +
                ", adPassword='" + adPassword + '\'' +
                ", adSex='" + adSex + '\'' +
                ", adPortrait='" + adPortrait + '\'' +
                ", adAge='" + adAge + '\'' +
                ", adAuthority='" + adAuthority + '\'' +
                ", adNO='" + adNO + '\'' +
                '}';
    }
}
