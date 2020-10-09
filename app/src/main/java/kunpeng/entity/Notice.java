package kunpeng.entity;

import java.util.Date;

public class Notice {
    private Integer NtID;
    private String Nt_Content;
    private Date Nt_Publish_Time;
    private String Nt_Author;
    private String Nt_Attachment;
    private String Nt_Undefined;

    public Integer getNtID() {
        return NtID;
    }

    public void setNtID(Integer ntID) {
        NtID = ntID;
    }

    public String getNt_Content() {
        return Nt_Content;
    }

    public void setNt_Content(String nt_Content) {
        Nt_Content = nt_Content;
    }

    public Date getNt_Publish_Time() {
        return Nt_Publish_Time;
    }

    public void setNt_Publish_Time(Date nt_Publish_Time) {
        Nt_Publish_Time = nt_Publish_Time;
    }

    public String getNt_Author() {
        return Nt_Author;
    }

    public void setNt_Author(String nt_Author) {
        Nt_Author = nt_Author;
    }

    public String getNt_Attachment() {
        return Nt_Attachment;
    }

    public void setNt_Attachment(String nt_Attachment) {
        Nt_Attachment = nt_Attachment;
    }

    public String getNt_Undefined() {
        return Nt_Undefined;
    }

    public void setNt_Undefined(String nt_Undefined) {
        Nt_Undefined = nt_Undefined;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "NtID=" + NtID +
                ", Nt_Content='" + Nt_Content + '\'' +
                ", Nt_Publish_Time=" + Nt_Publish_Time +
                ", Nt_Author='" + Nt_Author + '\'' +
                ", Nt_Attachment='" + Nt_Attachment + '\'' +
                ", Nt_Undefined='" + Nt_Undefined + '\'' +
                '}';
    }
}
