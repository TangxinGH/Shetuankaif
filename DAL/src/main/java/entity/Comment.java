package entity;

import java.util.Date;

public class Comment {
    private Integer cmtID;
    private Integer actID;
    private Integer sno;
    private String cmtContent;
    private Date cmtDate;
    private String cmtSname;

    public Integer getCmtID() {
        return cmtID;
    }

    public void setCmtID(Integer cmtID) {
        this.cmtID = cmtID;
    }

    public Integer getActID() {
        return actID;
    }

    public void setActID(Integer actID) {
        this.actID = actID;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

    public Date getCmtDate() {
        return cmtDate;
    }

    public void setCmtDate(Date cmtDate) {
        this.cmtDate = cmtDate;
    }

    public String getCmtSname() {
        return cmtSname;
    }

    public void setCmtSname(String cmtSname) {
        this.cmtSname = cmtSname;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cmtID=" + cmtID +
                ", actID=" + actID +
                ", sno=" + sno +
                ", cmtContent='" + cmtContent + '\'' +
                ", cmtDate=" + cmtDate +
                ", cmtSname='" + cmtSname + '\'' +
                '}';
    }
}
