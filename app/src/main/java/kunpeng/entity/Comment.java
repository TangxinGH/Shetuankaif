package kunpeng.entity;

import java.util.Date;

public class Comment {
    private Integer CmtID;
    private Integer ActID;
    private Integer Sno;
    private String Cmt_Content;
    private Date Cmt_Date;
    private String Cmt_Undefined;

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

    public String getCmt_Undefined() {
        return Cmt_Undefined;
    }

    public void setCmt_Undefined(String cmt_Undefined) {
        Cmt_Undefined = cmt_Undefined;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CmtID=" + CmtID +
                ", ActID=" + ActID +
                ", Sno=" + Sno +
                ", Cmt_Content='" + Cmt_Content + '\'' +
                ", Cmt_Date=" + Cmt_Date +
                ", Cmt_Undefined='" + Cmt_Undefined + '\'' +
                '}';
    }
}
