package kunpeng.entity;

import java.util.Date;

public class Activity {
    private Integer ActID;
    private String Act_Title;
    private String Act_Content;
    private Date Act_Publish_Time;
    private String Act_Author;
    private String Act_Attachment;
    private String Act_Undefined;

    public Integer getActID() {
        return ActID;
    }

    public void setActID(Integer actID) {
        ActID = actID;
    }

    public String getAct_Title() {
        return Act_Title;
    }

    public void setAct_Title(String act_Title) {
        Act_Title = act_Title;
    }

    public String getAct_Content() {
        return Act_Content;
    }

    public void setAct_Content(String act_Content) {
        Act_Content = act_Content;
    }

    public Date getAct_Publish_Time() {
        return Act_Publish_Time;
    }

    public void setAct_Publish_Time(Date act_Publish_Time) {
        Act_Publish_Time = act_Publish_Time;
    }

    public String getAct_Author() {
        return Act_Author;
    }

    public void setAct_Author(String act_Author) {
        Act_Author = act_Author;
    }

    public String getAct_Attachment() {
        return Act_Attachment;
    }

    public void setAct_Attachment(String act_Attachment) {
        Act_Attachment = act_Attachment;
    }

    public String getAct_Undefined() {
        return Act_Undefined;
    }

    public void setAct_Undefined(String act_Undefined) {
        Act_Undefined = act_Undefined;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "ActID=" + ActID +
                ", Act_Title='" + Act_Title + '\'' +
                ", Act_Content='" + Act_Content + '\'' +
                ", Act_Publish_Time=" + Act_Publish_Time +
                ", Act_Author='" + Act_Author + '\'' +
                ", Act_Attachment='" + Act_Attachment + '\'' +
                ", Act_Undefined='" + Act_Undefined + '\'' +
                '}';
    }
}
