package kunpeng.Configuration;

//import kunpeng.entity.Notice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.NoticeService;
import org.springframework.context.annotation.Primary;
import service.UserService;

@Configuration
@ComponentScan //为什么要这个呢， 也作为
//配置组件扫描指令以与@Configuration类一起使用。提供与Spring XML<context:component-scan>元素平行的支持。
//        可以指定basePackageClasses()或basePackages()（或其别名 value()）来定义要扫描的特定程序包。如果未定义特定的程序包，则将从声明此批注的类的程序包中进行扫描。
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
