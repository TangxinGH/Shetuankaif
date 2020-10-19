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

    public Integer getNtID() {
        return ntID;
    }

    public void setNtID(Integer ntID) {
        this.ntID = ntID;
    }

    public String getNtContent() {
        return ntContent;
    }

    public void setNtContent(String ntContent) {
        this.ntContent = ntContent;
    }

    public Date getNtPublishTime() {
        return ntPublishTime;
    }

    public void setNtPublishTime(Date ntPublishTime) {
        this.ntPublishTime = ntPublishTime;
    }

    public Integer getNtAuthorID() {
        return ntAuthorID;
    }

    public void setNtAuthorID(Integer ntAuthorID) {
        this.ntAuthorID = ntAuthorID;
    }

    public String getNtAttachment() {
        return ntAttachment;
    }

    public void setNtAttachment(String ntAttachment) {
        this.ntAttachment = ntAttachment;
    }

    public String getNtAuthor() {
        return ntAuthor;
    }

    public void setNtAuthor(String ntAuthor) {
        this.ntAuthor = ntAuthor;
    }

    public String getNtTitle() {
        return ntTitle;
    }

    public void setNtTitle(String ntTitle) {
        this.ntTitle = ntTitle;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "ntID=" + ntID +
                ", ntContent='" + ntContent + '\'' +
                ", ntPublishTime=" + ntPublishTime +
                ", ntAuthorID=" + ntAuthorID +
                ", ntAttachment='" + ntAttachment + '\'' +
                ", ntAuthor='" + ntAuthor + '\'' +
                ", ntTitle='" + ntTitle + '\'' +
                '}';
    }
}
