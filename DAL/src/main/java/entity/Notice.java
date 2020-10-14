package entity;

import java.util.Date;

public class Notice {
    private Integer ntID;
    private String ntContent;
    private Date ntPublishTime;
    private Integer ntAuthorID;
    private String ntAttachment;
    private String ntAuthor;
    private String ntTitle;

    public String getNt_Title(){
        return ntTitle;
    }

    public void setNt_Title(String Nt_Title){
        ntTitle = Nt_Title;
    }

    public Integer getNtID() {
        return ntID;
    }

    public void setNtID(Integer ntID) {
        this.ntID = ntID;
    }

    public String getNt_Content() {
        return ntContent;
    }

    public void setNt_Content(String nt_Content) {
        this.ntContent = nt_Content;
    }

    public Date getNt_Publish_Time() {
        return ntPublishTime;
    }

    public void setNt_Publish_Time(Date nt_Publish_Time) {
        this.ntPublishTime = nt_Publish_Time;
    }

    public int getNt_Author_ID() {
        return ntAuthorID;
    }

    public void setNt_Author_ID(int Nt_Author_ID) {
        ntAuthorID = Nt_Author_ID;
    }

    public String getNt_Attachment() {
        return ntAttachment;
    }

    public void setNt_Attachment(String nt_Attachment) {
        this.ntAttachment = nt_Attachment;
    }

    public String getNt_Author() {
        return ntAuthor;
    }

    public void setNt_Author(String nt_Ad_Name) {
        ntAuthor = nt_Ad_Name;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "NtID=" + ntID +
                ", Nt_Title=" + ntTitle +
                ", Nt_Content='" + ntContent + '\'' +
                ", Nt_Publish_Time=" + ntPublishTime +
                ", Nt_Author_ID='" + ntAuthorID + '\'' +
                ", Nt_Author='" + ntAuthor + '\'' +
                ", Nt_Attachment='" + ntAttachment + '\'' +
                '}';
    }
}
