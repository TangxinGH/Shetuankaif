package kunpeng.Configuration;

//import kunpeng.entity.Notice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.NoticeService;
import service.UserService;

@Configuration
public class myConfiguration {
    @Bean("testBean") //只能方法上
    public UserService beanUsersevice(){
        return new UserService(); //会自动实例化实例化成为一个springBean 在springIOC容器里
    }
    @Bean("testBeanB")
    public NoticeService beanNoticeService(){
        return new NoticeService();
    }
    @Bean("tes")
    public testB tessstB(){
        return new testB();
    }

}
