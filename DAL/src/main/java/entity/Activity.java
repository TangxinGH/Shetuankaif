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

    public Integer getAct_Author_ID(){
        return actAuthorID;
    }

    public void setAct_Author_ID(Integer Act_Author_ID){
        actAuthorID = Act_Author_ID;
    }

    public Integer getActID() {
        return actID;
    }

    public void setActID(Integer actID) {
        this.actID = actID;
    }

    public String getAct_Title() {
        return actTitle;
    }

    public void setAct_Title(String act_Title) {
        actTitle = act_Title;
    }

    public String getAct_Content() {
        return actContent;
    }

    public void setAct_Content(String act_Content) {
        actContent = act_Content;
    }

    public Date getAct_Publish_Time() {
        return actPublishTime;
    }

    public void setAct_Publish_Time(Date act_Publish_Time) {
        actPublishTime = act_Publish_Time;
    }

    public String getAct_Author() {
        return actAuthor;
    }

    public void setAct_Author(String act_Author) {
        actAuthor = act_Author;
    }

    public String getAct_Attachment() {
        return actAttachment;
    }

    public void setAct_Attachment(String act_Attachment) {
        actAttachment = act_Attachment;
    }

    public String getAct_Undefined() {
        return actUndefined;
    }

    public void setAct_Undefined(String act_Undefined) {
        actUndefined = act_Undefined;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "ActID=" + actID +
                ", Act_Title='" + actTitle + '\'' +
                ", Act_Content='" + actContent + '\'' +
                ", Act_Publish_Time=" + actPublishTime +
                ", Act_Author='" + actAuthor + '\'' +
                ", Act_Author_ID='" + actAuthorID + '\'' +
                ", Act_Attachment='" + actAttachment + '\'' +
                ", Act_Undefined='" + actUndefined + '\'' +
                '}';
    }
}
