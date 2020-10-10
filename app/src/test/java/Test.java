import kunpeng.App;
import kunpeng.Configuration.testB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import service.UserService;
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
}
