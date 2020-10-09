package entity;

public class Admin {
    private Integer Ad_no;
    private String Ad_name;
    private String Ad_College;

    public Integer getAd_no() {
        return Ad_no;
    }

    public void setAd_no(Integer ad_no) {
        Ad_no = ad_no;
    }

    public String getAd_name() {
        return Ad_name;
    }

    public void setAd_name(String ad_name) {
        Ad_name = ad_name;
    }

    public String getAd_College() {
        return Ad_College;
    }

    public void setAd_College(String ad_College) {
        Ad_College = ad_College;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Ad_no=" + Ad_no +
                ", Ad_name='" + Ad_name + '\'' +
                ", Ad_College='" + Ad_College + '\'' +
                '}';
    }
}
