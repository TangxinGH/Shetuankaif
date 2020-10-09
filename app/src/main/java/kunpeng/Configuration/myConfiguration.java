package kunpeng.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.UserService;

@Configuration
public class myConfiguration {
    @Bean("testBean") //只能方法上
    public UserService beanUsersevice(){
        return new UserService(); //会自动实例化实例化成为一个springBean 在springIOC容器里
    }
    @Bean("tes")
    public testB tessstB(){
        return new testB();
    }

}
