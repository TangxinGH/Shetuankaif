package entity;

import java.util.Date;

public class Activity {
    private Integer actID;
    private String actTitle;
    private String actContent;
    private Date actPublishTime;
    private String actAuthor;
    private Integer actAuthorID;
    private String actAttachment;
    private String actUndefined;

    public Integer getActID() {
        return actID;
    }

    public void setActID(Integer actID) {
        this.actID = actID;
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }

    public String getActContent() {
        return actContent;
    }

    public void setActContent(String actContent) {
        this.actContent = actContent;
    }

    public Date getActPublishTime() {
        return actPublishTime;
    }

    public void setActPublishTime(Date actPublishTime) {
        this.actPublishTime = actPublishTime;
    }

    public String getActAuthor() {
        return actAuthor;
    }

    public void setActAuthor(String actAuthor) {
        this.actAuthor = actAuthor;
    }

    public Integer getActAuthorID() {
        return actAuthorID;
    }

    public void setActAuthorID(Integer actAuthorID) {
        this.actAuthorID = actAuthorID;
    }

    public String getActAttachment() {
        return actAttachment;
    }

    public void setActAttachment(String actAttachment) {
        this.actAttachment = actAttachment;
    }

    public String getActUndefined() {
        return actUndefined;
    }

    public void setActUndefined(String actUndefined) {
        this.actUndefined = actUndefined;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "actID=" + actID +
                ", actTitle='" + actTitle + '\'' +
                ", actContent='" + actContent + '\'' +
                ", actPublishTime=" + actPublishTime +
                ", actAuthor='" + actAuthor + '\'' +
                ", actAuthorID=" + actAuthorID +
                ", actAttachment='" + actAttachment + '\'' +
                ", actUndefined='" + actUndefined + '\'' +
                '}';
    }
}
