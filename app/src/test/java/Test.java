import kunpeng.App;
import entity.Notice;
import org.mockito.internal.matchers.Not;
import org.springframework.beans.factory.annotation.Autowired;
import service.NoticeService;

import java.util.Date;

public class Test {
//    @Autowired  必须是一个springBean 类型的。
    @org.junit.jupiter.api.Test
    public void test1(){
        System.out.println("hello world");
    }

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
