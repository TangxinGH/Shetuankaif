package entity;

import java.util.Date;

public class Notice {
    private Integer NtID;
    private String Nt_Content;
    private Date Nt_Publish_Time;
    private Integer Nt_Author_ID;
    private String Nt_Attachment;
    private String Nt_Author;
    private String Nt_Title;

    public String getNt_Title(){
        return Nt_Title;
    }

    public void setNt_Title(String Nt_Title){
        this.Nt_Title = Nt_Title;
    }

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

    public int getNt_Author_ID() {
        return Nt_Author_ID;
    }

    public void setNt_Author_ID(int Nt_Author_ID) {
        this.Nt_Author_ID = Nt_Author_ID;
    }

    public String getNt_Attachment() {
        return Nt_Attachment;
    }

    public void setNt_Attachment(String nt_Attachment) {
        Nt_Attachment = nt_Attachment;
    }

    public String getNt_Author() {
        return Nt_Author;
    }

    public void setNt_Author(String nt_Ad_Name) {
        Nt_Author = nt_Ad_Name;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "NtID=" + NtID +
                ", Nt_Title=" + Nt_Title +
                ", Nt_Content='" + Nt_Content + '\'' +
                ", Nt_Publish_Time=" + Nt_Publish_Time +
                ", Nt_Author_ID='" + Nt_Author_ID + '\'' +
                ", Nt_Author='" + Nt_Author + '\'' +
                ", Nt_Attachment='" + Nt_Attachment + '\'' +
                '}';
    }
}
