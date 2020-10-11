import kunpeng.App;
import kunpeng.Configuration.testB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import service.*;
import entity.*;

import java.util.Date;

import service.NoticeService;
import service.UserService;
import  entity.Notice;
import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@DirtiesContext
public class Test {
//    @Autowired  必须是一个springBean 类型的。!!!
//    只有app有springboot的依赖，所以所有与spring相关的应该在这里测试

    @Autowired
    UserService userService;
//    @Autowired
//    @Qualifier("tes") //因为我在自定义bean中 为testB 取了别名
    testB testB;
    @org.junit.jupiter.api.Test
    public  void test(){
        userService.login();//测试
        userService.login("sff","xxxx");
        System.out.println("autowiredxx");
    }
    @org.junit.jupiter.api.Test
    public void test1(){
        System.out.println("hello world");
    }

    @Autowired
    NoticeService noticeService;

    @org.junit.jupiter.api.Test
    public void testNoticeService(){
        Notice notice = new Notice();
        notice.setNt_Title("刘忠骚吗");
        notice.setNtID(1);
        notice.setNt_Author_ID(123);
        notice.setNt_Author("刘忠");
        notice.setNt_Content("刘忠好骚");
        notice.setNt_Attachment("www.baidu.com");
        notice.setNt_Publish_Time(new Date());
        //NoticeService service = new NoticeService();
        try {
            System.out.println(noticeService.addANotice(notice) == 1);
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException){
                System.err.println("外键约束生效！对应表中无该记录！插入失败！");
            }
            else {throw e;}
        }
    }

    @Autowired
    ActivityService activityService;

    @org.junit.jupiter.api.Test
    public void testActivityService(){
        Activity activity = new Activity();
        activity.setAct_Title("西部支援计划");
        activity.setAct_Content(activity.getAct_Title()+"不存在！");
        activity.setActID(1);
        activity.setAct_Author_ID(666);
        activity.setAct_Publish_Time(new Date());
        activity.setAct_Author("黄晓明");
        activity.setAct_Attachment("www.bing.com");
        try {
            System.out.println(activityService.addAnActivity(activity)==0);
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException){
                System.err.println("外键约束生效！对应表中无该记录！插入失败！");
            }
            else {
                throw e;
            }
        }
    }

    @Autowired
    CommentService commentService;

    @org.junit.jupiter.api.Test
    public void testCommentService(){
        Comment comment = new Comment();
        comment.setActID(1);
        comment.setCmt_Content("日批，亲嘴");
        comment.setCmt_Date(new Date());
        comment.setSno(1234567890);
        comment.setCmt_Sname("骚忠");
        try{
            commentService.addAComment(comment);
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException){
                System.err.println("外键约束生效！对应表中无该记录！插入失败！");
            }
            else {
                throw e;
            }
        }
    }
}
