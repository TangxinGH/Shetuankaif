package entity;

import java.util.Date;

public class Comment {
    private Integer CmtID;
    private Integer ActID;
    private Integer Sno;
    private String Cmt_Content;
    private Date Cmt_Date;
    private String Cmt_Sname;

    public Integer getCmtID() {
        return CmtID;
    }

    public void setCmtID(Integer cmtID) {
        CmtID = cmtID;
    }

    public Integer getActID() {
        return ActID;
    }

    public void setActID(Integer actID) {
        ActID = actID;
    }

    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public String getCmt_Content() {
        return Cmt_Content;
    }

    public void setCmt_Content(String cmt_Content) {
        Cmt_Content = cmt_Content;
    }

    public Date getCmt_Date() {
        return Cmt_Date;
    }

    public void setCmt_Date(Date cmt_Date) {
        Cmt_Date = cmt_Date;
    }

    public String getCmt_Sname() {
        return Cmt_Sname;
    }

    public void setCmt_Sname(String Cmt_Sname) {
        this.Cmt_Sname = Cmt_Sname;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CmtID=" + CmtID +
                ", ActID=" + ActID +
                ", Sno=" + Sno +
                ", Cmt_Content='" + Cmt_Content + '\'' +
                ", Cmt_Date=" + Cmt_Date +
                ", Cmt_Sname='" + Cmt_Sname + '\'' +
                '}';
    }
}
