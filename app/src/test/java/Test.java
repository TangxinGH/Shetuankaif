import kunpeng.App;
import entity.Notice;
import org.mockito.internal.matchers.Not;
//import kunpeng.Configuration.testB;
import org.springframework.beans.factory.annotation.Autowired;
import service.NoticeService;

import java.util.Date;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.UserService;
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class Test {
//    @Autowired  必须是一个springBean 类型的。!!!
//    只有app有springboot的依赖，所以所有与spring相关的应该在这里测试

   // @Autowired
    //UserService userService;
   // @Autowired
   // testB testB;
   /* @org.junit.jupiter.api.Test
    public  void test(){
        userService.login();//测试
        userService.login("sff","xxxx");
        System.out.println("autowiredxx");
    }
    @org.junit.jupiter.api.Test
    public void test1(){
        System.out.println("hello world");
    }*/

    @org.junit.jupiter.api.Test
    public void test2(){
        Notice notice = new Notice();
        notice.setNt_Title("刘忠骚吗");
        notice.setNtID(1);
        notice.setNt_Author("刘忠");
        notice.setNt_Content("刘忠好骚");
        notice.setNt_Attachment("www.baidu.com");
        notice.setNt_Publish_Time(new Date());
        NoticeService service = new NoticeService();
        System.out.println(service.addANotice(notice) == 1);
    }
}
